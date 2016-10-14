package dataservice.orderdataservice;

import java.util.Date;
import java.util.List;

import Enum.UserType;
import po.OrderPO;

public interface OrderDataService {
	/**
	 * 在数据库中增加一个订单记录
	 * @param order
	 * @return  添加成功（true）或失败（false）的布尔值
	 */
	public boolean add(OrderPO order);
	
	/**
	 * 在数据库中保存一个订单记录
	 * @param order
	 * @return 添加成功（true）或失败（false）的布尔值
	 */
	public boolean save(OrderPO order);
	
	/**
	 * 将数据库中将订单置为取消状态
	 * @param orderId
	 * @return 置为取消状态成功（true）或失败（false）的布尔值
	 */
	public boolean cancel(String orderId);
	
	/**
	 * 查找某用户的具体订单
	 * @param userType
	 * @param orderId
	 * @return
	 */
	public OrderPO findSpecificClientOrder(UserType userType, String orderId);
	
	/**
	 * 查找某客户的所有订单
	 * @param userId
	 * @return
	 */
	public List<OrderPO> findUserOrderList(String userId);
	
	/**
	 *  查找数据库中某客户的某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param clientId
	 * @return 订单列表
	 */
	public List<OrderPO> findClientTypeOrder (String clientId);
	
	/**
	 * 查找数据库中某天的异常订单
	 * @param date
	 * @return 异常订单列表
	 */
	public List<OrderPO> findAbnormalOrderList(Date date);
	
	/**
	 * 根据时间，在数据库中将超时订单置为异常状态
	 * @param orderId
	 */
	public void checkTime (String orderId);
	
}
