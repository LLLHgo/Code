package po;

import java.util.ArrayList;
import java.util.Date;

import Enum.OrderType;

public class OrderPO {
	private String orderId;
	private String clientId;
	private String clientName;
	private String clientPhone;
	private Date orderDate;
	private OrderType orderType;
	private String hotelName;
	private double price;
	private ArrayList <String> strategies;
	
	public OrderPO(){
		
	}
	public OrderPO(String orderId,String clientId,String clientName,String clientPhone,
			Date orderDate,OrderType orderType,String hotelName,double price,ArrayList <String> strategies){
		this.orderId=orderId;
		this.clientId=clientId;
		this.clientName=clientName;
		this.clientPhone=clientPhone;
		this.orderDate=orderDate;
		this.orderType=orderType;
		this.hotelName=hotelName;
		this.price=price;
		this.strategies=strategies;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public OrderType getOrderStatus() {
		return orderType;
	}
	public void setOrderStatus(OrderType orderType) {
		this.orderType = orderType;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ArrayList<String> getStrategies() {
		return strategies;
	}
	public void setStrategies(ArrayList<String> strategies) {
		this.strategies = strategies;
	}
}
