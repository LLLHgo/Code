package businesslogic.orderbl;

import java.util.Date;
import java.util.List;

import Enum.OrderType;
import businesslogicservice.orderblservice.OrderBLService;
import po.OrderPO;
import vo.orderVO.OrderVO;

public class OrderBLService_Stub implements OrderBLService{
	public OrderBLService_Stub(){
		
		
	}

	@Override
	public boolean createOrder(OrderVO orderInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderVO findSpecificOrderList(String orderID) {
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
