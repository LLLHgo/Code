package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import Enum.ResultMessage;
import businesslogicservice.orderblservice.OrderOperatorBLService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice.OrderDataService_Stub;
import po.OrderPO;
import vo.orderVO.OrderVO;

public class OrderOperator implements OrderOperatorBLService{
	OrderDataService orderDateService;
	PackageTransform packageTrans;
	// 用来判断vo中信息是否完整的vo包
	OrderVO orderVO;
	ResultMessage result;
	boolean resultB;
	ArrayList<OrderPO> orderPOList;
	ArrayList<OrderVO> orderVOList;
	
	
	public OrderOperator(){
		try {
			orderDateService=new OrderDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
		packageTrans=new PackageTransform();
		orderPOList=new ArrayList<OrderPO>();
		orderVOList=new ArrayList<OrderVO>();
	}
	// 下订单
	@Override
	public ResultMessage createOrderPO(OrderVO orderVO) {
		// 判断包中的信息是否有空的，如果空，则返回ResultMessage.HASVOID
		boolean voInfoHasVoid=hasVoidInfo(orderVO);
		if(voInfoHasVoid){
			return ResultMessage.HASVOID;
		}
		// "000000001"
		String validId=lookUpIdinDatabase();
		orderVO.setOrderId(validId);
		OrderPO orderPO=packageTrans.VOToPO(orderVO);
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
	// 判断vo中信息是否完整
	boolean hasVoidInfo(OrderVO vo){
		this.orderVO=vo;
		if(voidClientId()||voidClientName()||voidClientPhone()||voidcVIPType()||voidOrderDate()||voidcOrderType()||
				voidHotelName()||voidHotelId()||voidPrice()||voidRoomType()||voidRoomNum()||voidRoomNum()||voidDays()
				||voidAnticipateArrivedTime()||voidActualArrivedTime()||voidAnticipateLeaveTime())
			return false;
		else
			return true;
	}
	boolean voidClientId(){
		return orderVO.getClientId()==null||orderVO.getClientId().equals("");
	}
	boolean voidClientName(){
		return orderVO.getClientName()==null||orderVO.getClientName().equals("");
	}
	boolean voidClientPhone(){
		return orderVO.getClientPhone()==null||orderVO.getClientPhone().equals("");
	}
	boolean voidcVIPType(){
		return orderVO.getVipType()==null||orderVO.getVipType().equals("");
	}
	boolean voidOrderDate(){
		return orderVO.getOrderDate()==null||orderVO.getOrderDate().equals("");
	}
	boolean voidcOrderType(){
		return orderVO.getOrderType()==null||orderVO.getOrderType().equals("");
	}
	boolean voidHotelName(){
		return orderVO.getHotelName()==null||orderVO.getHotelName().equals("");
	}
	boolean voidHotelId(){
		return orderVO.getHotelId()==null||orderVO.getHotelId().equals("");
	}
	boolean voidPrice(){
		return orderVO.getPrice()==0;
	}
	boolean voidRoomType(){
		return orderVO.getRoomType()==null||orderVO.getRoomType().equals("");
	}
	boolean voidRoomNum(){
		return orderVO.getRoomNum()==0;
	}
	boolean voidDays(){
		return orderVO.getDays()==0;
	}
	boolean voidAnticipateArrivedTime(){
		return orderVO.getAnticipateArrivedTime()==null||orderVO.getAnticipateArrivedTime().equals("");
	}
	boolean voidActualArrivedTime(){
		return orderVO.getActualArrivedTime()==null||orderVO.getActualArrivedTime().equals("");
	}
	boolean voidAnticipateLeaveTime(){
		return orderVO.getAnticipateLeaveTime()==null||orderVO.getAnticipateLeaveTime().equals("");
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
	
	// 保存订单
	@Override
	public ResultMessage saveOrderPO(OrderVO orderVO) {

		// 转换为po保存到数据库中
		OrderPO orderPO=packageTrans.VOToPO(orderVO);
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

	
}
