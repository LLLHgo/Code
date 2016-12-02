package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogicservice.orderblservice.OrderFindBLService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice.OrderDataService_Stub;
import po.OrderPO;
import vo.orderVO.OrderVO;

public class OrderFind implements OrderFindBLService{
	OrderDataService orderDateService;
	PackageTransform packageTrans;
	// 用来判断vo中信息是否完整的vo包
	OrderVO orderVO;
	ResultMessage result;
	boolean resultB;
	ArrayList<OrderPO> orderPOList;
	ArrayList<OrderVO> orderVOList;
	
	
	public OrderFind(){
		try {
			orderDateService=new OrderDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
		packageTrans=new PackageTransform();
		orderPOList=new ArrayList<OrderPO>();
		orderVOList=new ArrayList<OrderVO>();
	}
	
	// 找到某用户的某个具体订单
	@Override
	public OrderVO findSpecificOrder(String userId, String orderID) {
		
		OrderPO orderfindPO = null;
		try {
			orderfindPO = orderDateService.findSpecificUserOrder(userId, orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		OrderVO orderfindVO=packageTrans.POToVO(orderfindPO);
		// 用户是否有权限查看该订单
		// 客户请求，订单是否属于这个客户
		if(orderfindVO.getClientId().equals(userId)){
			return orderfindVO;
		}
		// 酒店请求，订单是否是该酒店的
		else if(orderfindVO.getHotelId().equals(userId)){
			return orderfindVO;
		}
		// 网站营销人员请求，该订单是否是异常的
		else if(orderfindVO.getOrderType().equals(OrderType.ABNORMAL)&&orderID.charAt(0)=='M')
			return orderfindVO;
		else
			return null;
	}
			
	@Override
	public ArrayList<OrderVO> findUserOrderList(String userID) {

		if(userID.length()==9){
			// 调用数据层的数据得到用户的所有订单
			try {
				orderPOList=orderDateService.findUserOrderList(userID);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			for(int i=0;i<orderPOList.size();i++){
				orderVOList.add(packageTrans.POToVO(orderPOList.get(i)));
			}
				return orderVOList;
			}
			return null;
		}

		@Override
		public ArrayList<OrderVO> findSpecificDayClientOrderList(String clientId, Date date) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<OrderVO> findSpecificHotelClientOrderList(String clientId, String hotelId) {
			
			if(clientId.length()==9&&hotelId.length()==9){
				try {
					orderPOList=orderDateService.findClientInHotelAllOrderList(clientId, hotelId);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				for(int i=0;i<orderPOList.size();i++){
					orderVOList.add(packageTrans.POToVO(orderPOList.get(i)));
				}
				return orderVOList;
			}
			return null;
		}

		@Override
		public ArrayList<OrderVO> findClientTypeOrderList(OrderType type, String clientId) {
			if(clientId.length()==9&&clientId.charAt(0)=='C'){
				try {
					orderPOList=orderDateService.findClientTypeOrderList(type, clientId);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				for(int i=0;i<orderPOList.size();i++){
					orderVOList.add(packageTrans.POToVO(orderPOList.get(i)));
				}
				return orderVOList;
			}
			return null;
		}
		
		@Override
		public ArrayList<OrderVO> findHotelTypeOrderList(OrderType type, String hotelId) {
			
			if(hotelId.length()==9&&hotelId.charAt(0)=='H'){
				try {
					orderPOList=orderDateService.findHotelTypeOrderList(type, hotelId);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				for(int i=0;i<orderPOList.size();i++){
					orderVOList.add(packageTrans.POToVO(orderPOList.get(i)));
				}
				return orderVOList;
			}
			return null;
		}

		@Override
		public ArrayList<OrderVO> findAbnormalOrderList(Date date) {
			// TODO Auto-generated method stub
			return null;
		}
}
