package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HotelDetailFrame extends JFrame{
	HotelDetailPanel hdp;
	public HotelDetailFrame(){

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		hdp=new HotelDetailPanel();
		this.add(hdp);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(591, 433);
		this.setLocation(500,200);
	}
	class HotelDetailPanel extends JPanel{
		private ImageIcon imageIcon = null;
		private Label hotelNameLabel;
		private Label hotelLevelLabel;
		private Label hotelAddressLabel;
		private Label hotelFacilityLabel;
		private orderButton order;
		public HotelDetailPanel(){
		imageIcon = new ImageIcon("image/HotelDetailPanel.png");

		order=new orderButton(470,280);
		order.addActionListener(new orderButtonListener());
		hotelNameLabel=new Label("test",90,13,300,30);
		hotelLevelLabel=new Label("test",90,65,300,30);
		hotelAddressLabel=new Label("test",90,125,300,30);
		hotelFacilityLabel=new Label("test",140,182,300,30);
		this.add(hotelNameLabel);
		this.add(hotelLevelLabel);
		this.add(hotelAddressLabel);
		this.add(hotelFacilityLabel);
		this.add(order);
		this.setVisible(true);
	    this.setLayout(null);
	    this.setBounds(0,0,591,413);
	    this.setOpaque(false);
	    this.setVisible(true);
	    this.repaint();

		}
		class Label extends JLabel{
			public Label(String str,int x,int y,int w,int h){
				super(str);
				java.awt.Font f=new java.awt.Font("微软雅黑", 4,  25);
				this.setFont(f);
				this.setForeground(Color.WHITE);
				this.setBounds(x,y,w,h);
			}
		}
		class orderButton extends JButton{
			ImageIcon icon;
			public orderButton(int x,int y){
			icon=new ImageIcon("image/orderButton.png");
			this.setIcon(icon);
			this.setOpaque(true);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setBounds(x,y,70,70);
			}
		}
		private class orderButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new OrderCreateFrame();
			}

		}
		@Override
		public void paintComponent(Graphics g) {
			    g.drawImage(imageIcon.getImage(), 0, 0, this);
			    super.paintComponents(g);
			   }
	}

}
