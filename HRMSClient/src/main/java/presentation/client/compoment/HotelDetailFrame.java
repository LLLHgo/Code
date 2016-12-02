package presentation.client.compoment;

import javax.swing.JFrame;

import presentation.login.controller.ProcessLoginViewController;
import presentation.login.view.ProcessLoginView;

public class HotelDetailFrame extends JFrame{
	public HotelDetailFrame(){

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		HotelDetailPanel hdp=new HotelDetailPanel();
		this.add(hdp);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(591, 433);
		this.setLocation(500,200);
	}
}
