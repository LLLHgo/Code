package presentation.client.controller;

import java.util.ArrayList;

import Enum.OrderType;
import businesslogic.hoteinfobl.Hotelinfo;
import businesslogic.orderbl.OrderFind;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.orderblservice.OrderFindBLService;
import vo.orderVO.OrderVO;

public class EvaluatePanelController {
	HotelinfoBLService hotelInfo=new Hotelinfo();
	OrderFindBLService orderfind=new OrderFind();
	public ArrayList<OrderVO> findClientFinOrderList( String clientId){
		return orderfind.findClientTypeOrderList(OrderType.NORMALEXEC,clientId);
	}
	public ArrayList<OrderVO> findClientTypeOrderList(OrderType type, String clientId){
		return orderfind.findClientTypeOrderList(type, clientId);
	}
}
