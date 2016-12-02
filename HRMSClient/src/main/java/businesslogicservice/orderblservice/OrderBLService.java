package businesslogicservice.orderblservice;

import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import Enum.UserType;
import po.OrderPO;
import vo.orderVO.OrderVO;

public interface OrderBLService {
	/**
	 * 下订单
	 * @param orderInfo
	 * @return 创建订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage createOrderPO (OrderVO orderInfo);
	/**
	 * 保存订单
	 * @param order
	 * @return 保存订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage saveOrderPO (OrderVO order);
	/**
	 * 取消订单
	 * @param orderId
	 * @return 置订单于取消状态成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage cancelOrderPO (String orderId);

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
	public  List<OrderVO> findSpecificDayClientOrderList(String clientId, Date date);
	/**
	 * 查找客户在某个酒店的所有订单
	 * @param clientId
	 * @param hoteIId
	 * @return 客户在某个酒店的所有订单列表
	 */
	public  List<OrderVO> findSpecificHotelClientOrderList (String clientId, String hoteIId);
	/**
	 * 查找客户某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param type
	 * @param clientId
	 * @return 客户某个种类（正常未执行、正常已执行、取消、异常）的订单列表
	 */
	public  List<OrderVO> findClientTypeOrderList (OrderType type,String clientId);

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
	public boolean checkTimeOperateAbnormal (OrderVO order, Date date);
	/**
	 * 酒店的订单，返回给酒店
	 * @param OrderType
	 * @param hotelId
	 * @return OrderVO的list
	 */
	public List<OrderVO> findHotelTypeOrderList(OrderType type, String hotelId);
	/**
	 * 返回给某一用户的具体订单
	 * @param userType
	 * @param orderID
	 * @return
	 */
	public OrderVO findSpecificOrder(String userId, String orderId);

}
