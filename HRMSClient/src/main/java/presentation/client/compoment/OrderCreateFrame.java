package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.OrderType;
import Enum.ResultMessage;
import presentation.client.controller.SearchPanelController;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;




public class OrderCreateFrame extends JFrame{
	private OrderCreatePanel hdp;
	private  JPanel Panel;
	private DateChooser begin;
	private DateChooser end;
	private HotelinfoVO hotelVO;
	private SearchPanelController controller;
	private ClientVO client;
	public OrderCreateFrame(ClientVO client,SearchPanelController controller,HotelinfoVO hotelVO){
		this.controller=controller;
		this.hotelVO=hotelVO;
		this.client=client;
		this.setLayout(null);
		begin=new DateChooser();
		end=new DateChooser();
		this.add(begin);
		begin.setOpaque(false);
		begin.setBorder(new EmptyBorder(0,0,0,0));
		begin.setBounds(150,187,100,25);

		this.add(end);
		end.setOpaque(false);
		end.setBorder(new EmptyBorder(0,0,0,0));
		end.setBounds(330,187,100,25);
		this.pack();


		Panel=new JPanel();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		hdp=new OrderCreatePanel(this);
		this.add(hdp);
		this.setLocationRelativeTo(null);




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
		private chooseRoomListPane crlp;
		private deleteButton delete;
		private okButton ok;
		public OrderCreatePanel(JFrame frame){
			crlp=new chooseRoomListPane(hotelVO.getRoominfoList());
			frame.add(crlp);
		imageIcon = new ImageIcon("image/OrderCreatePanel.png");
		hotelNameLabel=new Label(hotelVO.getName(),90,13,300,30);
		totalMoneyLabel=new Label("0",117,240,300,30);
		actualMoneyLabel=new Label("0",374,238,300,30);
		nameField=new Field("",123,70,92,30,20);

		delete=new deleteButton(300,310);
		delete.addActionListener(new deleteButtonListener());
		ok=new okButton(400,290);
		ok.addActionListener(new okButtonListener());
		this.add(delete);
		this.add(ok);

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
		private class okButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date date=new Date();
				  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				  String time=format.format(date);
				OrderVO order=new OrderVO();
				order.setOrderId("");
				order.setClientId(client.getID());
				System.out.println(client.getID());
				order.setClientName(nameField.getText());
				order.setOrderDate(time);
				order.setHotelName(hotelVO.getName());
				order.setClientPhone(client.getTel());
				System.out.println(client.getTel());
				order.setHotelId(hotelVO.getHotelID());
				//以后补上
				order.setPrice(0);
				ArrayList<String> str=new ArrayList<String>() ;
				str.add("fuck");
				order.setStrategies(str );
				order.setVipType(client.getType());
				order.setRoomType("标准间");
				order.setRoomNum(2);
				order.setOrderStatus(OrderType.NORMALNONEXEC);
				order.setAnticipateArrivedTime(begin.getChooseDate());
				order.setAnticipateLeaveTime(end.getChooseDate());
				order.setActualArrivedTime("");
				order.setDays(2);
				ResultMessage rs=controller.createOrderPO(order);
				System.out.println(rs);
			}

		}
		private int calTime(String begin,String end){
			return 2;
		}
		private class deleteButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nameField.setText("");
				totalMoneyLabel.setText("");
				actualMoneyLabel.setText("");
				System.out.println("GET!"+begin.getChooseDate());
			}

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
		  class chooseRoomListPane extends JScrollPane{

			public chooseRoomListPane(ArrayList<RoominfoVO> list){
				super(Panel);
				Panel.setLayout(null);
			    Panel.setPreferredSize(new Dimension(200,105));
			    Panel.setBounds(0,0,1000,4000);
			    Panel.setOpaque(false);


			   this.setBounds(150, 134, 720, 50);
			   this.setOpaque(false);
			   this.getViewport().setOpaque(false);
			   this.getVerticalScrollBar().setVisible(false);
			   this.setBorder(new EmptyBorder(0,0,0,0));
			   this.setVisible(true);
			   if(list!=null)
			    for(int i=0;i<list.size();i++){
			    	RoominfoVO vo=list.get(i);
			    	chooseRoomPanel p=new chooseRoomPanel(0, i*35,vo.getType());
			    	 //p.setBounds(0,i*100,600,100);

			    	 Panel.add(p);
			    }
			    this.getVerticalScrollBar().setVisible(false);

			}
		}
		@Override
		public void paintComponent(Graphics g) {
			    g.drawImage(imageIcon.getImage(), 0, 0, this);
			    super.paintComponents(g);
			   }
	}

}
