package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice.OrderDataService_Stub;
import po.OrderPO;
import vo.orderVO.OrderVO;

public class OrderManage implements OrderBLService{
	OrderDataService orderDateService;
	OrderVO orderVO;
	ResultMessage result;
	boolean resultB;
	ArrayList<OrderPO> orderPOList;
	ArrayList<OrderVO> orderVOList;
	
	
	public OrderManage(){
		try {
			orderDateService=new OrderDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
		orderPOList=new ArrayList<OrderPO>();
		orderVOList=new ArrayList<OrderVO>();
	}
	// 下订单
	@Override
	public ResultMessage createOrderPO(OrderVO orderVO) {
		// "000000001"
		String validId=lookUpIdinDatabase();
		orderVO.setOrderId(validId);
		OrderPO orderPO=VOToPO(orderVO);
		// 将下的订单存到数据库中
		try {
			resultB=orderDateService.add(orderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(resultB==true)
			return ResultMessage.SUCCESS;
		else
			return ResultMessage.DATEBASEFAIL;
	}
	
	// 查看当前可用的最新id帐号
	public String lookUpIdinDatabase(){
		int id=0;
		String idValid;
		int deltaLength;
		try {
			id=orderDateService.lookIdValid();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		idValid=id+"";
		// 不足9位，则补足9位
		if(idValid.length()<9){
			deltaLength=9-idValid.length();
			for(int i=0;i<deltaLength;i++){
				idValid="0"+idValid;
			}
		}
		return idValid;
	}
	// 将orderVO转化为orderPO
	OrderPO VOToPO(OrderVO vo){
		OrderPO po=new OrderPO(vo.getOrderId(),vo.getClientId(),vo.getClientName(),vo.getClientPhone(),
				vo.getVipType(),vo.getOrderDate(),vo.getOrderType(),vo.getHotelName(),vo.getHotelId(),
				vo.getPrice(),vo.getStrategies(),vo.getRoomType(),vo.getRoomNum(),vo.getDays(),
				vo.getAnticipateArrivedTime(),vo.getActualArrivedTime(),vo.getAnticipateLeaveTime());
		return po;
	}
	// 将orderPO转化为orderVO
		OrderVO POToVO(OrderPO po){
			OrderVO vo=new OrderVO(po.getOrderId(),po.getClientId(),po.getClientName(),po.getClientPhone(),
					po.getVipType(),po.getOrderDate(),po.getOrderType(),po.getHotelName(),po.getHotelId(),
					po.getPrice(),po.getStrategies(),po.getRoomType(),po.getRoomNum(),po.getDays(),
					po.getAnticipateArrivedTime(),po.getActualArrivedTime(),po.getAnticipateLeaveTime());
			return vo;
		}
	
	// 保存订单
	@Override
	public ResultMessage saveOrderPO(OrderVO orderVO) {

		// 转换为po保存到数据库中
		OrderPO orderPO=VOToPO(orderVO);
		try {
			resultB=orderDateService.save(orderPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(resultB==true){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.DATEBASEFAIL;
	}

	// 将订单置为撤销状态
	@Override
	public ResultMessage cancelOrderPO(String orderId) {

		String lastOrderIdString=lookUpIdinDatabase();
		// 判断是否存在该帐号
		if(Integer.parseInt(lastOrderIdString)>=Integer.parseInt(orderId)){
			// 存在该帐号，则调用data层方法，在数据库中将帐号的订单状态置为撤销状态
			try {
				resultB=orderDateService.cancel(orderId);
			} catch (RemoteException e) {

				e.printStackTrace();
			}
			if(resultB==true)
				return ResultMessage.SUCCESS;
			else
				return ResultMessage.DATEBASEFAIL;
		}
		// 不存在该帐号
			return ResultMessage.IDINVALID;
	}

	// 找到某用户的某个具体订单
	@Override
	public OrderVO findSpecificOrder(String userId, String orderID) {
		
		OrderPO orderfindPO = null;
		try {
			orderfindPO = orderDateService.findSpecificUserOrder(userId, orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		OrderVO orderfindVO=POToVO(orderfindPO);
		// 用户是否有权限查看该订单
		// 客户请求，订单是否属于这个客户
		if(orderfindVO.getClientId().equals(userId)){
			return orderfindVO;
		}
		// 酒店请求，订单是否是该酒店的
		else if(orderfindVO.getHotelId().equals(userId)){
			return orderfindVO;
		}
		// 网站营销人员请求，该订单是否是异常的
		else if(orderfindVO.getOrderType().equals(OrderType.ABNORMAL)&&orderID.charAt(0)=='M')
			return orderfindVO;
		else
			return null;
	}
	
	
	@Override
	public ArrayList<OrderVO> findUserOrderList(String userID) {

		if(userID.length()==9){
			// 调用数据层的数据得到用户的所有订单
			try {
				orderPOList=orderDateService.findUserOrderList(userID);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			for(int i=0;i<orderPOList.size();i++){
				orderVOList.add(POToVO(orderPOList.get(i)));
			}
			return orderVOList;
		}
		return null;
	}

	@Override
	public List<OrderVO> findSpecificDayClientOrderList(String clientId, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> findSpecificHotelClientOrderList(String clientId, String hotelId) {
		
		if(clientId.length()==9&&hotelId.length()==9){
			try {
				orderPOList=orderDateService.findClientInHotelAllOrderList(clientId, hotelId);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			for(int i=0;i<orderPOList.size();i++){
				orderVOList.add(POToVO(orderPOList.get(i)));
			}
			return orderVOList;
		}
		return null;
	}

	@Override
	public List<OrderVO> findClientTypeOrderList(OrderType type, String clientId) {
		if(clientId.length()==9&&clientId.charAt(0)=='C'){
			try {
				orderPOList=orderDateService.findClientTypeOrderList(type, clientId);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			for(int i=0;i<orderPOList.size();i++){
				orderVOList.add(POToVO(orderPOList.get(i)));
			}
			return orderVOList;
		}
		return null;
	}
	
	@Override
	public List<OrderVO> findHotelTypeOrderList(OrderType type, String hotelId) {
		
		if(hotelId.length()==9&&hotelId.charAt(0)=='H'){
			try {
				orderPOList=orderDateService.findHotelTypeOrderList(type, hotelId);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			for(int i=0;i<orderPOList.size();i++){
				orderVOList.add(POToVO(orderPOList.get(i)));
			}
			return orderVOList;
		}
		return null;
	}

	@Override
	public List<OrderVO> findAbnormalOrderList(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkTimeOperateAbnormal(OrderVO order, Date date) {
		// TODO Auto-generated method stub
		return false;
	}

}
