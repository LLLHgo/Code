package Mock;

import java.util.ArrayList;
import java.util.Date;

import Enum.OrderType;
import Enum.VIPType;

public class MockOrder {
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
	
	public MockOrder(){
		
	}
	
}
