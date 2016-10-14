package businesslogicservice.orderblservice;

import java.util.Date;
import java.util.List;
import po.OrderType;
import po.OrderPO;
import vo.orderVO.OrderVO;

public interface OrderBLService {
	
	// 下订单
	public boolean createOrder (OrderVO orderInfo);
	// 保存订单
	public boolean saveOrder (OrderVO order);
	// 取消订单
	public boolean cancelOrder (String orderId);
	// 查找订单
	public OrderVO  findSpecificOrderList(String orderID);
	// 查找某种用户(客户或酒店)的所有订单
	public List<OrderVO>  findUserOrderList (String userID);
	
	// 查找客户某天的订单
	public  OrderVO findSpecificDayClientOrder(String clientId, Date date);
	// 查找用户在某个酒店的所有订单
	public  OrderVO findSpecificHotelClientOrder (String clientId, String hoteIId);
	// 查找用户某个种类（正常未执行、正常已执行、取消、异常）的订单
	public  List<OrderVO> findClientTypeOrder (OrderType type,String clientId);
	
	// 查找酒店的某个具体订单
	public OrderVO findSpecificHotelOrder (String hotelId, String orderId);
	
	// 查找具体某天的异常订单
	public List<OrderVO> findAbnormalOrderList (Date date);

	// 检查时间，判断是否将订单置为异常
	public boolean checkTime (OrderPO order, Date date);

}
