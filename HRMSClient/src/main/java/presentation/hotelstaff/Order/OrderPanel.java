package presentation.hotelstaff.Order;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.hotelstaff.component.OrderTypeButton;
import presentation.hotelstaff.hotelinfo.controller.HotelinfoViewController;
import vo.orderVO.OrderVO;

import Enum.OrderType;
import Enum.VIPType;
import datatool.OrderDataTool;

public class OrderPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private HotelinfoViewController controller;
	private String hotelID;
	private ImageIcon init_image;
	private JTextField checkbox;
	private JButton searchButton;
	private ImageIcon Icheckbox;
	private Font font;
	private ArrayList<OrderVO> orderList;
	private JScrollPane scrollPane;
	private ImageIcon orderBackground;
	private JLabel jlSearch;
	private OrderTypeButton jbAll;
	private OrderTypeButton jbUnexecuted;
	private OrderTypeButton jbExecuted;
	private OrderTypeButton jbAbnormal;
	private JLabel jlDetailedSearch;
	private ImageIcon IDetailedSearch;
	private JButton jbDrag;
	private boolean buttonFlag;
	private JPanel orderPanel;
	
	public OrderPanel(HotelinfoViewController controller , String hotelID){
		this.controller = controller;
		this.hotelID = hotelID;
		init();
	}
	
	private void init(){
		this.setLayout(null);
		this.setBounds(0,0,1000,618);
		this.setVisible(true);
		setOpaque(false);
		
		buttonFlag = true;
		
		Icheckbox = new ImageIcon("./src/main/resource/picture/hotelorder/checkbox.png");
		IDetailedSearch = new ImageIcon("./src/main/resource/picture/hotelorder/searchbackground.png");
		
		jlSearch = new JLabel();
		jlSearch.setBounds(330, 90, 180, 25);
		jlSearch.setForeground(Color.white);
		font = new Font("微软雅黑",Font.BOLD,15);
		jlSearch.setFont(font);
		jlSearch.setOpaque(false);
		jlSearch.setBorder(null);
		this.add(jlSearch);
		jlSearch.setText("所有订单");
		
		jlDetailedSearch = new JLabel();
		jlDetailedSearch.setBounds(320, 82, 180, 200);
		jlDetailedSearch.setIcon(IDetailedSearch);
		jlDetailedSearch.setVisible(false);
		this.add(jlDetailedSearch);
	
		jbAll = new OrderTypeButton(315,120,"所有订单");
		jbUnexecuted = new OrderTypeButton(315,153,"未执行");
		jbExecuted = new OrderTypeButton(315,188,"已执行");
		jbAbnormal = new OrderTypeButton(315,223,"异常");
		jbAll.addActionListener(new SearchButtonActionListener());
		jbUnexecuted.addActionListener(new SearchButtonActionListener());
		jbExecuted.addActionListener(new SearchButtonActionListener());
		jbAbnormal.addActionListener(new SearchButtonActionListener());
		this.add(jbAll);
		this.add(jbUnexecuted); 
		this.add(jbExecuted); 
		this.add(jbAbnormal);
		
		jbDrag = new JButton();
		jbDrag.setIcon(new ImageIcon("./src/main/resource/picture/hotelorder/triangle.png"));
		jbDrag.setBounds(480,90,25,25);
		jbDrag.setContentAreaFilled(false);
		jbDrag.setBorder(null);
		jbDrag.addActionListener(new DragButtonActionListener());
		this.add(jbDrag);
		

		OrderVO orderVO4=new OrderVO("20161016092301","C00000010","Lily","17887780990"
				,VIPType.ORDINARYVIP,"2016-10-16 09:23",OrderType.NORMALNONEXEC,"LLLHH","H00000002",998,null);

		OrderVO orderVO5=new OrderVO("20161017092401","C00000011","Tinny","17887780991"
				,VIPType.ORDINARYVIP,"2016-10-17 09:24",OrderType.ABNORMAL,"LLLHH","H00000002",666,null);

		OrderVO orderVO6=new OrderVO("20161017092501","C00000012","belikout","17887780992"
				,VIPType.ORDINARYVIP,"2016-10-17 09:25",OrderType.ABNORMAL,"LLLHH","H00000002",666,null);

		OrderVO orderVO7=new OrderVO("20161017092601","C00000013","sweetstreet","17887780993"
				,VIPType.ORDINARYVIP,"2016-10-17 09:26",OrderType.ABNORMAL,"LLLHH","H00000002",666,null);
		OrderDataTool.list1.add(orderVO4);
		OrderDataTool.list1.add(orderVO5);
		showOrderList(OrderDataTool.list1);
	}
	
	private class DragButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(buttonFlag){
				jbAll.setVisible(true);
				jbUnexecuted.setVisible(true);
				jbExecuted.setVisible(true);
				jbAbnormal.setVisible(true);
				jlDetailedSearch.setVisible(true);
				scrollPane.setVisible(false);
				buttonFlag  = false;
			}else{
				jbAll.setVisible(false);
				jbUnexecuted.setVisible(false);
				jbExecuted.setVisible(false);
				jbAbnormal.setVisible(false);
				jlDetailedSearch.setVisible(false);
				scrollPane.setVisible(true);
				buttonFlag = true;
			}
		}
	}
	
	private class SearchButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbAll){
				jlSearch.setText("所有订单");
				showAllOrderList();
			}else if(e.getSource()==jbUnexecuted){
				jlSearch.setText("已执行订单");
				showUnexecutedOrderList();
			}else if(e.getSource()==jbExecuted){
				jlSearch.setText("未执行订单");
				showExecutedOrderList();
			}else if(e.getSource()==jbAbnormal){
				jlSearch.setText("异常订单");
				showAbnormalOrderList();
			}else{
				
			}
		}
	}
	
	
	private void showOrderList(ArrayList<OrderVO> orders){ 
		//设置放置Order信息的JPanel
	    orderPanel=new JPanel();
	    orderPanel.setLayout(null);
	    orderPanel.setPreferredSize(new Dimension(620,30+120*orders.size()));
	    orderPanel.setBounds(0,0,1000,618);
	    orderPanel.setOpaque(false);

	    //设置放置showAbnormalOrderPanel的JScrollPanel
	    scrollPane = new JScrollPane(orderPanel);
	    scrollPane.setBounds(320, 130, 680, 360);
	    scrollPane.setBorder(new EmptyBorder(0,0,0,0));
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    this.add(scrollPane);
	    int num=0;

	    Image image=new ImageIcon("./src/main/resource/picture/hotelorder/order.png").getImage();
	    for(OrderVO order:orders){
	    	//制作order背景
	        JPanel panel=new JPanel(){
				private static final long serialVersionUID = 1L;
				protected  void paintComponent(Graphics g) {
	            	g.drawImage(image,0,0,630,105,this);
	            }
			};
	        panel.setBounds(10, 10+120*num,630, 120);
	        panel.setLayout(null);
	        num++;
	        //制作order需要的组件
	        JLabel orderIDLabel=new JLabel(order.getOrderId());
	        JLabel nameLabel=new JLabel(order.getClientName());
	        JLabel priceLabel=new JLabel(String.valueOf(order.getPrice()));
	        JLabel entertimeLabel = new JLabel(order.getOrderDate());
//	        JLabel leavetimeLabel;
	        JLabel phoneLabel = new JLabel(order.getClientPhone());
	        OrderType[] orderType = {OrderType.NORMALNONEXEC,OrderType.NORMALEXEC,
	        		OrderType.ABNORMAL,OrderType.CANCEL};
	        String stateLabelText = "";
	    	String [] sOrderType = {"未执行","已执行","异常","已取消"};
	    	for(int i=0;i<3;i++){
	    		if(order.getOrderType()==orderType[i]){
	    			stateLabelText = sOrderType[i];
	    		}
	    	}
	        JLabel stateLabel = new JLabel(stateLabelText);
	        
	        orderIDLabel.setBounds(108, 18, 174, 15);
	        nameLabel.setBounds(498,16,100,15);
	        priceLabel.setBounds(370,53,80,15);
	        entertimeLabel.setBounds(180,53,294,15);
	        phoneLabel.setBounds(440,53,150,15);
	        stateLabel.setBounds(440,80,70,15);

	        JLabel[] labelList = {orderIDLabel,nameLabel,priceLabel,entertimeLabel,
	        		phoneLabel,stateLabel};
	        
	        for(int i=0;i<labelList.length;i++){
	        	panel.add(labelList[i]);
	        	labelList[i].setForeground(Color.white);
	        	labelList[i].setFont(new Font("微软雅黑",Font.PLAIN,14));
	        }
	        
	        orderPanel.add(panel);
	        
	    };
		
	    
	}
	
	private void showAllOrderList(){
		showOrderList((ArrayList<OrderVO>)controller.getALLHotelOrderList(hotelID,OrderType.ALL));
	}
	
	private void showUnexecutedOrderList(){
		showOrderList((ArrayList<OrderVO>)controller.getUnexecutedHotelOrderList(hotelID,OrderType.ALL));
	}
	
	
	private void showExecutedOrderList(){
		showOrderList((ArrayList<OrderVO>)controller.getExecutedHotelOrderList(hotelID,OrderType.ALL));
	}
	
	private void showAbnormalOrderList(){
		showOrderList((ArrayList<OrderVO>)controller.getAbnormalHotelOrderList(hotelID,OrderType.ALL));
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(Icheckbox.getImage(),310,90,200,25,this);
    }

}
