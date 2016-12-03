package businesslogicservice.orderblservice;

import java.util.ArrayList;
import java.util.Date;

import Enum.OrderType;
import Enum.ResultMessage;
import Enum.VIPType;
import businesslogicservice.orderblservice.OrderOperatorBLService;

import vo.orderVO.OrderVO;

public class OrderBLService_Stub implements OrderOperatorBLService,OrderCheckTimeBLService,OrderFindBLService{
	    
	OrderVO orderVO;
	
	public OrderBLService_Stub(){
	
	}
	
	public OrderBLService_Stub(OrderVO orderVO){
		this.orderVO=orderVO;
	}

	/**
	 * 下订单
	 * @param orderInfo
	 * @return 创建订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	@Override
	public ResultMessage createOrderPO(OrderVO orderInfo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 保存订单
	 * @param order
	 * @return 保存订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	@Override
	public ResultMessage saveOrderPO(OrderVO order) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	/**
	 * 取消订单
	 * @param orderId
	 * @return 置订单于取消状态成功（Success）或是失败（fail）的ResultMessage值
	 */
	@Override
	public ResultMessage cancelOrderPO(String orderId) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	/**
	 * 查找某用户的具体订单
	 */
	@Override
	public OrderVO findSpecificOrder(String userId, String orderID) {
		// TODO Auto-generated method stub
		OrderVO orderVO=new OrderVO("000000001","C00000001","小螺丝","16679876372",VIPType.ORDINARYVIP,"2016-12-01 12:23:28",
				OrderType.NORMALNONEXEC,"冠军楼酒店","H00000010",340.28,null,"大床房",1,1,"2016-12-19 12:00:00",
				null,"2016-12:20 12:00:00");
		return orderVO;
	}

	/**
	 * 查找某种用户(客户或酒店)的所有订单
	 * @param userID
	 * @return 某种用户(客户或酒店)的所有订单列表
	 */
	@Override
	public ArrayList<OrderVO> findUserOrderList(String userID) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> UserOrderList=new ArrayList<OrderVO>();
		return UserOrderList;
	}
	/**
	 * 查找客户某天的订单
	 * @param clientId
	 * @param date
	 * @return 客户某天的订单列表
	 */
	@Override
	public ArrayList<OrderVO> findSpecificDayClientOrderList(String clientId, String date) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> SpecificDayClientOrderList=new ArrayList<OrderVO>();
		return SpecificDayClientOrderList;
	}
	/**
	 * 查找用户客户在某个酒店的所有订单
	 * @param clientId
	 * @param hoteIId
	 * @return 客户在某个酒店的所有订单列表
	 */
	@Override
	public ArrayList<OrderVO> findSpecificHotelClientOrderList(String clientId, String hoteIId) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> SpecificHotelClientOrderList=new ArrayList<OrderVO>();
		return SpecificHotelClientOrderList;
	}
	/**
	 * 查找客户某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param type
	 * @param clientId
	 * @return 客户某个种类（正常未执行、正常已执行、取消、异常）的订单列表
	 */
	@Override
	public ArrayList<OrderVO> findClientTypeOrderList(OrderType type, String clientId) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> ClientTypeOrder=new ArrayList<OrderVO>();
		return  ClientTypeOrder;
	}

	/**
	 * 查找具体某天的异常订单
	 * @param date
	 * @return 具体某天的所有订单列表
	 */
	@Override
	public ArrayList<OrderVO> findAbnormalOrderList(String date) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> findAbnormalOrder=new ArrayList<OrderVO>();
		return  findAbnormalOrder;
	}
	/**
	 * 检查时间，判断是否将订单置为异常
	 * @param order
	 * @param date
	 * @return 判断订单置为异常状态（true）或不修改状态（false）的布尔值
	 */
	@Override
	public boolean checkTimeOperateAbnormal(OrderVO order, String date) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ArrayList<OrderVO> findHotelTypeOrderList(OrderType type, String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
