package presentation.client.controller;

import java.util.ArrayList;

import Enum.ResultMessage;
import businesslogic.hoteinfobl.HotelinfoManage;
import businesslogic.orderbl.OrderOperator;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.orderblservice.OrderOperatorBLService;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.orderVO.OrderVO;

public class SearchPanelController {
HotelinfoBLService hotelInfo=new HotelinfoManage();
OrderOperatorBLService order=new OrderOperator();
	public HotelinfoVO getBasicinfo(String hotelID) {
	return hotelInfo.getBasicinfo(hotelID);
}
	public ArrayList<HotelinfoVO> getBasicinfoList(ClientRequirementVO clientvo) {
		return hotelInfo.getBasicinfoList(new ClientRequirementVO());
	}
	public ResultMessage createOrderPO(OrderVO orderVO) {
		return order.createOrderPO(orderVO);
	}
}