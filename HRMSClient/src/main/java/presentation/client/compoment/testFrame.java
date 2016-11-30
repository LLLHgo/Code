package presentation.client.compoment;

import javax.swing.JFrame;

import presentation.login.controller.ProcessLoginViewController;
import presentation.login.view.ProcessLoginView;

public class testFrame {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().add(new ProcessLoginView(frame, new ProcessLoginViewController()));
		//frame.getContentPane().add(new HotelstaffView(frame,new HotelstaffViewController(),"H00000000"));
		//frame.getContentPane().add(new HotelinfoPanel());
HotelDetailPanel h=new HotelDetailPanel();
		frame.add(h);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(1000, 638);

	}
}
