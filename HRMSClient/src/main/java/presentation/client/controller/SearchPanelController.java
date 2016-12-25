package presentation.client.controller;

import java.util.ArrayList;

import Enum.ResultMessage;
import businesslogic.hoteinfobl.Hotelinfo;
import businesslogic.orderbl.OrderOperator;
import businesslogic.strategybl.StrategyManage;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.orderblservice.OrderOperatorBLService;
import businesslogicservice.strategyblservice.StrategyBLService;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;
import vo.priceVO.PriceVO;

public class SearchPanelController {
HotelinfoBLService hotelInfo=new Hotelinfo();
OrderOperatorBLService order=new OrderOperator();
StrategyBLService strategy=new StrategyManage();
	public HotelinfoVO getBasicinfo(String hotelID) {
	return hotelInfo.getBasicinfo(hotelID);
}
	public ArrayList<HotelinfoVO> getBasicinfoList(String area,String hotelname,int hotelstar,String roomType) {
		return hotelInfo.getBasicinfoList(area,hotelname,hotelstar,roomType);
	}
	public ResultMessage createOrderPO(OrderVO orderVO) {
		return order.createOrderPO(orderVO);
	}
	public PriceVO calculatePrice(ClientVO clientVO, RoominfoVO roomInfoVO, HotelinfoVO hotelInfoVO, int num,int days){
		return strategy.calculatePrice(clientVO,roomInfoVO,hotelInfoVO,num,days);
	}
	public ArrayList<HotelinfoVO> rankHotelAccordingtoHotelStar(ArrayList<HotelinfoVO> list) {
		return hotelInfo.rankHotelAccordingtoHotelStar(list);
	}

	public ArrayList<HotelinfoVO> rankHotelAccordingtoRemarkStar(ArrayList<HotelinfoVO> list) {
		return hotelInfo.rankHotelAccordingtoRemarkStar(list);
	}

	public ArrayList<HotelinfoVO> rankHotelAccordingtoMinPrice(ArrayList<HotelinfoVO> list) {
		return hotelInfo.rankHotelAccordingtoMinPrice(list);
	}
}
