package Mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import Enum.VIPType;
import vo.orderVO.OrderVO;

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
	// orderVO
	private OrderVO orderVO;
	// 酒店帐号
	private String hotelId;
	// 日志
	private String logInfo;
	
	public MockOrder(OrderVO orderVO){
		this.orderVO=orderVO;
	}
	
	public MockOrder(String str){
		if(str.length()==16)
			this.orderId=str;
		else if(str.charAt(0)=='C')
			this.clientId=str;
		else if(str.charAt(0)=='H')
			this.hotelId=str;
		else
			this.logInfo=str;
	}
	public MockOrder(){
		
	}
	public MockOrder(String str,Date orderDate){
		if(str.charAt(0)=='C'){
			this.clientId=str;
			this.orderDate=orderDate;
		}
		else{
			this.orderId=str;
			this.orderDate=orderDate;
		}
	}
	
	public MockOrder(String str1,String str2){
		if(str1.charAt(0)=='C'&&str2.charAt(0)=='H'){
			this.clientId=str1;
			this.hotelId=str2;
		}
		else if(str1.charAt(0)=='H'&&str2.length()==16){
			this.hotelId=str1;
			this.orderId=str2;
		}
	}
	
	public MockOrder(OrderType orderType,String id){
		this.orderType=orderType;
		if(id.charAt(0)=='C'){
			this.clientId=id;
		}
		else if(id.charAt(0)=='H'){
			this.hotelId=id;
		}
	}
	
	public MockOrder(Date orderDate){
		this.orderDate=orderDate;
	}
	
	/**
	 * 下订单
	 * @param orderInfo
	 * @return 创建订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage createOrder (OrderVO orderInfo){
		return ResultMessage.SUCCESS;
	}
	/**
	 * 保存订单
	 * @param order
	 * @return 保存订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage saveOrder (OrderVO order){
		return ResultMessage.SUCCESS;
	}
	/**
	 * 取消订单
	 * @param orderId
	 * @return 置订单于取消状态成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage cancelOrder (String orderId){
		return ResultMessage.SUCCESS;
	}
	/**
	 * 查找具体订单
	 * @param orderID
	 * @return 具体订单
	 */
	public OrderVO  findSpecificOrderList(String orderID){
		return orderVO;
	}
}