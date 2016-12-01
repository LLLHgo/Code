package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import Enum.UserType;
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
	
	
	public OrderManage(){
		try {
			orderDateService=new OrderDataService_Stub();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	// 下订单
	@Override
	public ResultMessage createOrder(OrderVO orderVO) {
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
			// TODO Auto-generated catch block
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

	@Override
	public ResultMessage saveOrder(OrderVO orderVO) {
		// TODO Auto-generated method stub
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

	@Override
	public ResultMessage cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		String lastOrderIdString=lookUpIdinDatabase();
		// 判断是否存在该帐号
		if(Integer.parseInt(lastOrderIdString)>=Integer.parseInt(orderId)){
			// 存在该帐号，则调用data层方法，在数据库中将帐号的订单状态置为撤销状态
			try {
				resultB=orderDateService.cancel(orderId);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
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

	@Override
	public OrderVO findSpecificOrderList(UserType userType, String orderID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<OrderVO> findUserOrderList(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> findSpecificDayClientOrder(String clientId, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> findSpecificHotelClientOrder(String clientId, String hoteIId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> findClientTypeOrder(OrderType type, String clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO findSpecificHotelOrder(String hotelId, String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<OrderVO> findHotelTypeOrder(OrderType type, String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> findAbnormalOrderList(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkTime(OrderVO order, Date date) {
		// TODO Auto-generated method stub
		return false;
	}

}
