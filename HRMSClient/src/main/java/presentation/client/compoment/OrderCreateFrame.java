package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class OrderCreateFrame extends JFrame{
	private OrderCreatePanel hdp;
	public OrderCreateFrame(){

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		hdp=new OrderCreatePanel();
		this.add(hdp);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(591, 433);
		this.setLocation(400,200);
	}
	class OrderCreatePanel extends JPanel{
		private ImageIcon imageIcon = null;
		private Label hotelNameLabel;
		private Label totalMoneyLabel;
		private Label actualMoneyLabel;
		private Field nameField;
		public OrderCreatePanel(){
		imageIcon = new ImageIcon("image/OrderCreatePanel.png");
		hotelNameLabel=new Label("test",90,13,300,30);
		totalMoneyLabel=new Label("test",117,240,300,30);
		actualMoneyLabel=new Label("test",374,238,300,30);
		nameField=new Field("test",123,70,92,30,20);
		this.add(hotelNameLabel);
		this.add(nameField);
		this.add(totalMoneyLabel);
		this.add(actualMoneyLabel);
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
		class Field extends JTextField{
			public Field(String str,int x,int y,int w,int h,int big){
				super(str);
				java.awt.Font f=new java.awt.Font("微软雅黑", 4,  big);
				this.setFont(f);
				this.setForeground(Color.WHITE);
				this.setBorder(new EmptyBorder(0,0,0,0));
				this.setBounds(x,y,w,h);
				this.setOpaque(false);
				this.setFocusable(true);

			}
		}
		@Override
		public void paintComponent(Graphics g) {
			    g.drawImage(imageIcon.getImage(), 0, 0, this);
			    super.paintComponents(g);
			   }
	}

}
