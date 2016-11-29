package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Enum.OrderType;
import Enum.ResultMessage;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.ViewButton;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;

public class StrategyPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private HotelstaffViewController controller;
	private String hotelID;
	private JPanel strategyPanel;
	private JScrollPane scrollPane;
	
	public StrategyPanel(HotelstaffViewController controller){
		this.controller=controller;
		this.hotelID=controller.gethotelID();
		init();
	}
	
	public void init(){
		this.setLayout(null);
		this.setBounds(0,0,1000,618);
		this.setVisible(true);
		setOpaque(false);
		
		showStrategys((ArrayList<HotelStrategyVO>)controller.gethotelStrategy(hotelID));
		
		this.add(strategyPanel);
	}
	
	void showStrategys(ArrayList <HotelStrategyVO> strategys){
		//设置放置Order信息的JPanel
	    strategyPanel=new JPanel();
	    strategyPanel.setLayout(null);
	    strategyPanel.setPreferredSize(new Dimension(666,30+53*strategys.size()));
	    strategyPanel.setBounds(0,0,1000,618);
	    strategyPanel.setOpaque(false);

	    //设置放置showAbnormalOrderPanel的JScrollPanel
	    scrollPane = new JScrollPane(strategyPanel);
	    scrollPane.setBounds(280, 140, 680, 360);
	    scrollPane.setBorder(new EmptyBorder(0,0,0,0));
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    this.add(scrollPane);
	    int num=0;

	    Image image=new ImageIcon("./src/main/resource/picture/hotelstrategy/strategybackground.png").getImage();
	    for(HotelStrategyVO strategy:strategys){
	    	//制作order背景
	        JPanel panel=new JPanel(){
				private static final long serialVersionUID = 1L;
				protected  void paintComponent(Graphics g) {
	            	g.drawImage(image,0,0,666,53,this);
	            }
			};
	        panel.setBounds(10, 10+53*num,666, 53);
	        panel.setLayout(null);
	        num++;
	        //制作order需要的组件
	        JLabel jlname = new JLabel();
	        jlname.setText(strategy.getName());
	        jlname.setBounds(10,10,600,30);
	        jlname.setForeground(Color.white);
	        jlname.setFont(new Font("微软雅黑",Font.PLAIN,20));
	        panel.add(jlname);
	        
	        ViewButton jbview = new ViewButton(620,10);
	        panel.add(jbview);
	        
	        //按下查看按钮
	        jbview.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					controller.detailedStrategy(strategy);
				}
	        	
	        });
	        
	        scrollPane.add(panel);
	}
}
}
