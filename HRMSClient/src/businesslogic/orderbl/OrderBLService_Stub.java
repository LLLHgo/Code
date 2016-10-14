package businesslogic.orderbl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.VIPType;
import businesslogicservice.orderblservice.OrderBLService;
import po.OrderPO;
import vo.orderVO.OrderVO;

public class OrderBLService_Stub implements OrderBLService{
	    // 订单号
	    private String orderId;
	    // 客户帐号
	    private String clientId;
	    // 客户名字
		private String clientName;
		// 客户手机号
		private String clientPhone;
		// 客户vip类型
		private VIPType vipType;
		// 订单下达时间
		private Date orderDate;
		// 订单类型
		private OrderType orderType;
		// 订单中酒店名称
		private String hotelName;
		// 订单价格
		private double price;
		// 订单享受的优惠策略
		private ArrayList <String> strategies;
	public OrderBLService_Stub(){
		
		
	}
	/**
	 * 下订单
	 * @param orderInfo
	 * @return 创建订单成功（true）或是失败（false）的布尔值
	 */
	@Override
	public boolean createOrder(OrderVO orderInfo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 保存订单
	 * @param order
	 * @return 保存订单成功（true）或失败（false）的布尔值
	 */
	@Override
	public boolean saveOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 取消订单
	 * @param orderId
	 * @return 置订单于取消状态成功（true）或失败（false）的布尔值
	 */
	@Override
	public boolean cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 查找具体订单
	 * @param orderID
	 * @return 具体订单
	 */
	@Override
	public OrderVO findSpecificOrderList(String orderID) {
		// TODO Auto-generated method stub
		return new OrderVO(orderId,clientId,clientName,clientPhone,vipType,orderDate,orderType,hotelName,price,strategies);
	}
	/**
	 * 查找某种用户(客户或酒店)的所有订单
	 * @param userID
	 * @return 某种用户(客户或酒店)的所有订单列表
	 */
	@Override
	public List<OrderVO> findUserOrderList(String userID) {
		// TODO Auto-generated method stub
		List<OrderVO> UserOrderList=new ArrayList<OrderVO>();
		return UserOrderList;
	}
	/**
	 * 查找客户某天的订单
	 * @param clientId
	 * @param date
	 * @return 客户某天的订单列表
	 */
	@Override
	public List<OrderVO> findSpecificDayClientOrder(String clientId, Date date) {
		// TODO Auto-generated method stub
		List<OrderVO> findSpecificDayClientOrderList=new ArrayList<OrderVO>();
		return findSpecificDayClientOrderList;
	}

	@Override
	public OrderVO findSpecificHotelClientOrder(String clientId, String hoteIId) {
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
	public List<OrderVO> findAbnormalOrderList(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkTime(OrderPO order, Date date) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
