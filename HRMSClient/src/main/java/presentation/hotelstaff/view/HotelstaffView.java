package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.GuideBoardButton;
import presentation.hotelinfo.controller.HotelinfoViewController;
import presentation.hotelinfo.view.HotelinfoPanel;
import presentation.hotelstaff.controller.HotelstaffViewController;
import presentation.hotelstaff.view.component.UserImageLabel;
import presentation.login.view.ProcessLoginView;

public class HotelstaffView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private String hotelID;
	private JFrame frame;
	private ImageIcon init_image;
	private GuideBoardButton jbHotelinfo;
	private GuideBoardButton jbRoominfo;
	private GuideBoardButton jbOrder;
	private GuideBoardButton jbStrategy;
	private GuideBoardButton jbPersonalinfo;
	private GuideBoardButton jbExit;
	private UserImageLabel userLabel;
	private JLabel IDLabel;
	
	public HotelstaffView(JFrame frame,String hotelID){
		this.frame = frame;
		this.hotelID = hotelID;
		initHotelstaff();
	}
	
	private void initHotelstaff(){
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setSize(1000, 618);
		this.setVisible(true);
		setOpaque(false);
		//初始化背景图
		init_image = new ImageIcon("./src/main/resource/picture/hotelstaff/background.png");
		//初始化按钮
		jbHotelinfo=new GuideBoardButton(250,"酒店信息");
		jbRoominfo=new GuideBoardButton(300,"房间信息");
		jbOrder=new GuideBoardButton(350,"处理订单");
		jbStrategy=new GuideBoardButton(400,"制订策略");
		jbPersonalinfo=new GuideBoardButton(450,"个人信息");
		jbExit=new GuideBoardButton(500,"退出");
		this.add(jbHotelinfo);
		this.add(jbRoominfo);
		this.add(jbOrder);
		this.add(jbStrategy);
		this.add(jbPersonalinfo);
		this.add(jbExit);
		//给酒店信息按钮添加监听
		jbHotelinfo.addActionListener(new JBHotelinfoActionListener());
		jbRoominfo.addActionListener(new JBRoominfoActionListener());
		jbOrder.addActionListener(new JBOrderActionListener());
		jbStrategy.addActionListener(new JBStrategyinfoActionListener());
		jbPersonalinfo.addActionListener(new JBPersonalinfoActionListener());
		jbExit.addActionListener(new JBExitActionListener());
		
		//初始化头像标签
		userLabel = new UserImageLabel(88,95);
		this.add(userLabel);
		//初始化ID标签
		IDLabel = new JLabel();
		IDLabel.setBounds(35, 195, 260, 24);
		IDLabel.setFont(new java.awt.Font("微软雅黑", 1, 28));
		IDLabel.setForeground(Color.white);
		IDLabel.setText("ID:"+hotelID);
		this.add(IDLabel);
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(init_image.getImage(), 0,0,getSize().width,getSize().height,this);
    }

	
	class JBHotelinfoActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new HotelinfoPanel(new HotelinfoViewController(),hotelID));
			frame.getContentPane().add(new HotelstaffView(frame,hotelID));
			frame.getContentPane().revalidate();
			frame.getContentPane().repaint();
			
		}
		
	}
	
	class JBRoominfoActionListener	implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	class JBOrderActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			
		}
	}
	
	class JBStrategyinfoActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
	
			
		}
		
	}
	
	class JBPersonalinfoActionListener	implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().removeAll();
			frame.getContentPane().add(new HotelstaffPanel(new HotelstaffViewController(),hotelID));
			frame.getContentPane().add(new HotelstaffView(frame,hotelID));
			frame.getContentPane().revalidate();
			frame.getContentPane().repaint();
			
		}
		
	}
	class JBExitActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
		
	}
}
