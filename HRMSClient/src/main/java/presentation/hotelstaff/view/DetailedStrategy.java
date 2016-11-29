package presentation.hotelstaff.view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.strategyVO.HotelStrategyVO;

public class DetailedStrategy extends JPanel{

	private static final long serialVersionUID = 1L;
	private HotelstaffViewController controller;
	private String hotelID;
	private ImageIcon image;
	
	public DetailedStrategy(HotelstaffViewController controller,HotelStrategyVO vo){
		this.controller = controller;
		this.hotelID = controller.gethotelID();
		if(vo.getName().equals(""))
		init();
	}
	
	private void init(){
		
	}
}
