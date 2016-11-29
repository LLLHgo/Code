package presentation.hotelstaff.view;

import javax.swing.JPanel;

import presentation.hotelstaff.controller.HotelstaffViewController;

public class NewStrategyPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private HotelstaffViewController controller;
	private String hotelID;
	
	public NewStrategyPanel(HotelstaffViewController controller){
		this.controller=controller;
		this.hotelID=controller.gethotelID();
		init();
	}
	
	public void init(){
		
	}
}
