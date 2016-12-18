package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.OrderType;
import Enum.ResultMessage;
import datatool.RoominfoDataTool;
import presentation.client.controller.SearchPanelController;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;
import vo.priceVO.PriceVO;




public class OrderCreateFrame extends JFrame{
	private OrderCreatePanel hdp;
	private  JPanel Panel;
	private DateChooser begin;
	private DateChooser end;
	private HotelinfoVO hotelVO;
	private SearchPanelController controller;
	private ClientVO client;
	PriceVO pricevo;
	public OrderCreateFrame(ClientVO client,SearchPanelController controller,HotelinfoVO hotelVO){
		pricevo=new PriceVO(0,null);
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
		end.addMouseListener(new mouseListener());
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
	class mouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub


		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Date date=new Date();
			  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  String time=format.format(date);
			  int i=0;
			  for(;;i++){
				  if(hdp.crlp.rooms.get(i).numField.getText().charAt(0)!='<')
					  break;
			  }
			  int days=hdp.calTime(begin.getChooseDate(),end.getChooseDate());
			  int num=Integer.parseInt(hdp.crlp.rooms.get(i).numField.getText());

			  RoominfoVO room=hotelVO.getRoominfoList().get(i);
			 double beforeprice=num*days*room.getPrice();
					 pricevo=controller.calculatePrice(client,room,hotelVO,days);
			  hdp.actualMoneyLabel.setText(Double.toString(pricevo.getPrice()));
			  hdp.totalMoneyLabel.setText(Double.toString(beforeprice));

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

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
		private JTextArea strategyArea;
		public OrderCreatePanel(JFrame frame){
			crlp=new chooseRoomListPane(hotelVO.getRoominfoList());
			System.out.println(hotelVO.getRoominfoList().size());
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

		strategyArea=new JTextArea();
		strategyArea.setBounds(20,280,200,100);
		strategyArea.setOpaque(false);
		strategyArea.setForeground(Color.WHITE);
		strategyArea.setFont(new java.awt.Font("微软雅黑", 4,  20));
		strategyArea.setLineWrap(true);
		strategyArea.setCaretColor(Color.WHITE);

		this.add(strategyArea);
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
				  int i=0;
				  for(;;i++){
					  if(crlp.rooms.get(i).numField.getText().charAt(0)!='<')
						  break;
				  }
				  int days=calTime(begin.getChooseDate(),end.getChooseDate());
				  int num=Integer.parseInt(crlp.rooms.get(i).numField.getText());
				  RoominfoVO room=hotelVO.getRoominfoList().get(i);
				  pricevo=controller.calculatePrice(client,room,hotelVO,days);
				  OrderVO order=createOrderVO(nameField.getText(),time,pricevo.getPrice(),(ArrayList<String>)pricevo.getStrategys(),room.getType(),num,days);
				ResultMessage rs=controller.createOrderPO(order);
				System.out.println(rs);

			}

		}
		private OrderVO createOrderVO(String name,String time,double price,ArrayList<String> strategy,String roomType,int num,int days){
			OrderVO order=new OrderVO();
			order.setOrderId("");
			order.setClientId(client.getID());
			System.out.println(client.getID());
			order.setClientName(name);
			order.setOrderDate(time);
			order.setHotelName(hotelVO.getName());
			order.setClientPhone(client.getTel());
			System.out.println(client.getTel());
			order.setHotelId(hotelVO.getHotelID());
			//以后补上
			order.setPrice(price);

			order.setStrategies(strategy );
			order.setVipType(client.getType());
			order.setRoomType(roomType);
			order.setRoomNum(num);
			order.setOrderType(OrderType.NORMALNONEXEC);
			order.setAnticipateArrivedTime(begin.getChooseDate());
			order.setAnticipateLeaveTime(end.getChooseDate());
			order.setActualArrivedTime("");
			order.setDays(days);
			return order;
		}
		private int calTime(String begin,String end){
			int beginday=(begin.charAt(9)-'0')+10*(begin.charAt(8)-'0');
			int endday=(end.charAt(9)-'0')+10*(end.charAt(8)-'0');
			int beginmon=(begin.charAt(6)-'0')+10*(begin.charAt(5)-'0');
			int endmon=(end.charAt(6)-'0')+10*(end.charAt(5)-'0');
			int res=0;
			if(beginmon<endmon){
				res+=31-beginday+endday;
			}
			else
				res+=(endday-beginday);

			return res;
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
			  ArrayList<chooseRoomPanel> rooms;
			public chooseRoomListPane(ArrayList<RoominfoVO> list){

				super(Panel);
				rooms=new ArrayList<chooseRoomPanel>();
				Panel.setLayout(null);
			    Panel.setPreferredSize(new Dimension(200,list.size()*35));
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
			    	chooseRoomPanel p=new chooseRoomPanel(0, i*35,vo.getType(),hotelVO.getAvailableNum().get(i)+1);
			    	 Panel.add(p);
			    	 rooms.add(p);
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
