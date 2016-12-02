package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import Enum.OrderType;
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
		// 订了0间房，返回ResultMessage.NOROOMORDERED
		if(orderVO.getRoomNum()==0){
			return ResultMessage.NOROOMORDERED;
		}
		// 订了0天，返回ResultMessage.NODAYORDERED
		if(orderVO.getDays()==0){
			return ResultMessage.NODAYORDERED;
		}
		// 判断预计入住时间是否无效（在当天的前一天）,如果无效，返回ResultMessage.STARTDAYNOTALLOWED
		if(!canOrderTime(orderVO.getAnticipateArrivedTime())){
			return ResultMessage.STARTDAYNOTALLOWED;
		}
		// 判断包中的信息是否有空的，如果空，则返回ResultMessage.HASVOID
		if(hasVoidInfo(orderVO)){
			return ResultMessage.HASVOID;
		};
		//System.out.println(orderVO.getOrderType());
		//System.out.println(OrderType.NORMALNONEXEC+"");
		//System.out.println((orderVO.getOrderType()+"").equals(OrderType.NORMALNONEXEC+""));
		// 判断订单中订单状态是否为正常未执行，如果状态不是正常未执行状态，则返回ResultMessage.WORNGORDERTYPEWHENCREATE
		if(!(orderVO.getOrderType()+"").equals(OrderType.NORMALNONEXEC+"")){
			return ResultMessage.WORNGORDERTYPEWHENCREATE;
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
	// 该预计到达时间能预定
	@SuppressWarnings("deprecation")
	boolean canOrderTime(String anticipateTime){ // 2016-12-02 12:00:00
		Date date=new Date();
		//int currentHour=date.getHours();
		String former=anticipateTime.split(" ")[0];
		String[] yearMonDay=former.split("-");
		int currentYear=date.getYear()+1900;
		int cunrrentMonth=date.getMonth()+1;
		int currentDay=date.getDate();
		// 当前时间和预计入住时间之间的差值
		int deltaDaysCurrentAnticip=
				dayCount(Integer.parseInt(yearMonDay[0]),Integer.parseInt(yearMonDay[1]),Integer.parseInt(yearMonDay[2]))
				-dayCount(currentYear,cunrrentMonth,currentDay);
		// 当天中午12点前订的房间,可定当天及昨天的日期的房间
		//if(currentHour<=11){
			// 判断当前年月日是否大于等于预计入住时间年月日
		//	if(deltaDaysCurrentAnticip>=0){
		//		return true;
		//	}	
		//}
		// 超过中午12点，订单的预计入住时间必须是今天及之后日期的才有效。
		//else if(currentHour>=12){
			// 判断当前年月日是否大等于预计入住时间年月日
		//	if(deltaDaysCurrentAnticip>=0){
		//		return true;
		//	}	
		//}
		if(deltaDaysCurrentAnticip>=0){
			return true;
		}
		else
			return false;
	}
	int dayCount(int year,int month,int day){
		return year*3650+month*300+day;
	}
	// 判断vo中信息是否完整
	boolean hasVoidInfo(OrderVO vo){
		this.orderVO=vo;
		if(voidClientId()||voidClientName()||voidClientPhone()||voidcVIPType()||voidOrderDate()||voidcOrderType()||
				voidHotelName()||voidHotelId()||voidPrice()||voidRoomType()||voidRoomNum()||voidRoomNum()||voidDays()
				||voidAnticipateArrivedTime()||voidAnticipateLeaveTime())
			return true;
		else
			return false;
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
