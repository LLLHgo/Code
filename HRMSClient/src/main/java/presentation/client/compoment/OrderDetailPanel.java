package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.client.compoment.HotelDetailPanel.Label;

public class OrderDetailPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private Label orderNumLabel;
	private Label hotelNameLabel;
	private Label personLabel;
	private Label liveTimeLabel;
	private Label totalMoneyLabel;
	private Label actualMoneyLabel;
	private Label orderTimeLabel;
	public OrderDetailPanel(){
	imageIcon = new ImageIcon("image/OrderDetailPanel.png");
	orderNumLabel=new Label("test",110,13,300,30);
	hotelNameLabel=new Label("test",90,63,300,30);
	personLabel=new Label("test",110,118,300,30);
	liveTimeLabel=new Label("test",133,233,300,30);
	totalMoneyLabel=new Label("test",117,290,300,30);
	actualMoneyLabel=new Label("test",375,290,300,30);
	orderTimeLabel=new Label("test",180,345,300,30);
	this.add(orderNumLabel);
	this.add(hotelNameLabel);
	this.add(personLabel);
	this.add(liveTimeLabel);
	this.add(totalMoneyLabel);
	this.add(actualMoneyLabel);
	this.add(orderTimeLabel);

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
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
