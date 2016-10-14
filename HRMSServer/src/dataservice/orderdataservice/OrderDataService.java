package dataservice.orderdataservice;

import java.util.Date;
import java.util.List;

import po.OrderPO;
import po.UserType;

public interface OrderDataService {
	// 在数据库中增加一个订单记录
	public boolean add(OrderPO order);
	// 在数据库中保存一个订单记录
	public boolean save(OrderPO order);
	// 将数据库中将订单置为取消状态
	public boolean cancel(String orderId);
	// 查找某用户的具体订单
	public OrderPO findSpecificClientOrder(UserType userType, String orderId);
	// 查找某客户的所有订单
	public List<OrderPO> findUserOrderList(String clientId);
	// 查找某客户的某个种类（正常未执行、正常已执行、取消、异常）的订单
	public List<OrderPO> findClientTypeOrder (String clientId);
	// 查找某酒店的
	public List<OrderPO> findHotelOrderList (String hotelId);
	//
	public OrderPO findHotelOrderList (String hotelId, String orderId);
	//
	public List<OrderPO> findAbnormalOrderList(Date date);
	//
	public OrderPO findAbnormalOrderList(String orderId);
	//
	public void checkTime (String orderId);

}
