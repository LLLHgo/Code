package presentation.hotelstaff.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DetailedRoominfo extends JFrame{
	private static final long serialVersionUID = 1L;
	private String roomID;
	private String type;
	private String price;
	private String state;
	private ImageIcon init_image;
	private ReviewTextArea jtaRoomID;
	private ReviewTextArea jtaType;
	private ReviewTextArea jtaPrice;
	private ReviewTextArea jtaState;
	private JPanel panel;
	public DetailedRoominfo(String roomID,String type,String price,String state){
		this.setSize(250,350);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);
		
		Toolkit kit = Toolkit.getDefaultToolkit();    // 定义工具包
	    Dimension screenSize = kit.getScreenSize();   // 获取屏幕的尺寸
	    int screenWidth = screenSize.width/2;         // 获取屏幕的宽
	    int screenHeight = screenSize.height/2;       // 获取屏幕的高
	    int height = this.getHeight();
	    int width = this.getWidth();
	    this.setLocation(screenWidth-width/2, screenHeight-height/2);
	    
	    init_image = new ImageIcon("C:/Users/1/Documents/GitHub/Code/HRMSClient/src/main/resource/picture/hotelinfo/detailedroominfo.png");
	    
		this.roomID = roomID;
		this.type = type;
		this.price = price;
		this.state = state;
		init();
	}
	
	private void init(){ 
		panel = new JPanel(){
			protected void paintComponent(Graphics g) {
				g.drawImage(init_image.getImage(),0,0,250,350,panel);
		    }
		};
	    panel.setLayout(null);
	    panel.setSize(500,350);
	    panel.setVisible(true);
	    panel.setOpaque(false);
		this.getContentPane().add(panel);
		this.getContentPane().setBackground(new Color(255,255,255,0));
		
		jtaRoomID = new ReviewTextArea(110,28,200,30,roomID);
		jtaType = new ReviewTextArea(110,85,200,30,type);
		jtaPrice = new ReviewTextArea(110,140,200,30,price);
		jtaState = new ReviewTextArea(110,197,200,30,state);
		jtaRoomID.setOpaque(true);
		jtaType.setOpaque(true);
		jtaPrice.setOpaque(true);
		jtaState.setOpaque(true);
		panel.add(jtaRoomID);
		panel.add(jtaType);
		panel.add(jtaPrice);
		panel.add(jtaState);
	}

}
