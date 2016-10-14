package businesslogicservice.orderblservice;

import java.util.Date;
import java.util.List;

import Enum.OrderType;
import po.OrderPO;
import vo.orderVO.OrderVO;

public interface OrderBLService {
	/**
	 * 下订单
	 * @param orderInfo
	 * @return 创建订单成功（true）或是失败（false）的布尔值
	 */
	public boolean createOrder (OrderVO orderInfo);
	/**
	 * 保存订单
	 * @param order
	 * @return 保存订单成功（true）或失败（false）的布尔值
	 */
	public boolean saveOrder (OrderVO order);
	/**
	 * 取消订单
	 * @param orderId
	 * @return 置订单于取消状态成功（true）或失败（false）的布尔值
	 */
	public boolean cancelOrder (String orderId);
	/**
	 * 查找具体订单
	 * @param orderID
	 * @return 具体订单
	 */
	public OrderVO  findSpecificOrderList(String orderID);
	/**
	 * 查找某种用户(客户或酒店)的所有订单
	 * @param userID
	 * @return 某种用户(客户或酒店)的所有订单列表
	 */
	public List<OrderVO>  findUserOrderList (String userID);
	
	/**
	 * 查找客户某天的订单
	 * @param clientId
	 * @param date
	 * @return 客户某天的订单列表
	 */
	public  List<OrderVO> findSpecificDayClientOrder(String clientId, Date date);
	/**
	 * 查找用户客户在某个酒店的所有订单
	 * @param clientId
	 * @param hoteIId
	 * @return 客户在某个酒店的所有订单列表
	 */
	public  List<OrderVO> findSpecificHotelClientOrder (String clientId, String hoteIId);
	/**
	 * 查找客户某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param type
	 * @param clientId
	 * @return 客户某个种类（正常未执行、正常已执行、取消、异常）的订单列表
	 */
	public  List<OrderVO> findClientTypeOrder (OrderType type,String clientId);
	
	/**
	 * 查找酒店的某个具体订单
	 * @param hotelId
	 * @param orderId
	 * @return 酒店的某个具体订单
	 */
	public OrderVO findSpecificHotelOrder (String hotelId, String orderId);
	
	/**
	 * 查找具体某天的异常订单
	 * @param date
	 * @return 具体某天的所有订单列表
	 */
	public List<OrderVO> findAbnormalOrderList (Date date);

	/**
	 * 检查时间，判断是否将订单置为异常
	 * @param order
	 * @param date
	 * @return 判断订单置为异常状态（true）或不修改状态（false）的布尔值
	 */
	public boolean checkTime (OrderPO order, Date date);

}
