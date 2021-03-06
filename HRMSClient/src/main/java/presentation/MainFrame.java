package presentation;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import presentation.login.controller.ProcessLoginViewController;
import presentation.login.view.ProcessLoginView;

public class MainFrame {
	//private static ProcessLoginControllerService controller;
	public MainFrame(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ProcessLoginView(frame, new ProcessLoginViewController()));
		//frame.getContentPane().add(new HotelstaffView(frame,new HotelstaffViewController(),"H00000000"));
		//frame.getContentPane().add(new HotelinfoPanel());
		frame.setVisible(true);
		frame.setSize(1000, 638);

		Toolkit kit = Toolkit.getDefaultToolkit();    // 定义工具包
	    Dimension screenSize = kit.getScreenSize();   // 获取屏幕的尺寸
	    int screenWidth = screenSize.width/2;         // 获取屏幕的宽
	    int screenHeight = screenSize.height/2;       // 获取屏幕的高
	    int height = frame.getHeight();
	    int width = frame.getWidth();
	    frame.setLocation(screenWidth-width/2, screenHeight-height/2);

	}

}
