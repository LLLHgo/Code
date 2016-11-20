package presentation.marketing.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.OrderType;
import Enum.ResultMessage;
import datatool.OrderDataTool;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;

public class ProcessMarketingAbnormalView extends JPanel{
	private ProcessMarketingViewControllerService controller;
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,22);
	private Font font2=new Font("楷体",Font.PLAIN,17);
	private Font font3=new Font("微软雅黑",Font.HANGING_BASELINE,28);
	private Image newImage=null;
	private String MarketingID;
	private MarketingVO Mvo;
	private JPanel searchAbnormalPanel;
	private JPanel showAbnormalOrderPanel;
	public ProcessMarketingAbnormalView(ProcessMarketingViewControllerService controller,JPanel panel){
    	this.controller=controller;
    	this.MarketingID=controller.getMarketingID();
        this.Mvo=controller.init(MarketingID);
    	this.setBounds(275, 82, 704, 500);
    	this.setLayout(null);
    	this.setOpaque(false);

		//添加搜索订单与查看订单列表JLabel
		JLabel searchLabel=new JLabel("搜索订单");
		JLabel abnormalListLabel=new JLabel("异常订单列表");
		searchLabel.setFont(font3);abnormalListLabel.setFont(font3);
		searchLabel.setForeground(Color.white);abnormalListLabel.setForeground(Color.white);
		searchLabel.setBounds(125, 0, 200, 80);abnormalListLabel.setBounds(375,0, 200, 80);
    	this.add(searchLabel);this.add(abnormalListLabel);

    	//为搜索订单JLabel添加监听
    	searchLabel.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
                searchAbnormalLabelClicked();
			}@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
     		@Override
			public void mouseExited(MouseEvent e) {}

    	} );
    	panel.add(this);
	}

	public void searchAbnormalLabelClicked() {
	//searchAbnormalLabel点击后的JPanel
	searchAbnormalPanel=new JPanel();
	searchAbnormalPanel.setLayout(null);
	searchAbnormalPanel.setBounds(0, 80, 700, 70);
	searchAbnormalPanel.setOpaque(false);

	//为搜索Bar加组件 Label加背景Icon和JTextField
	JLabel searchBarLabel=new JLabel();
	JTextField searchBarField=new JTextField();
	Icon searchBarIcon=new ImageIcon("./src/main/resource/picture/marketing/searchBar.png");
    searchBarLabel.setIcon(searchBarIcon);
    searchBarField.setFont(font2);
    searchBarField.setOpaque(false);
    searchBarField.setBorder(new EmptyBorder(0,0,0,0));
    searchBarLabel.setBounds(60, 5, 500, 50);
	searchBarField.setBounds(17, 0, 405,44);
 	searchBarLabel.add(searchBarField);
	searchAbnormalPanel.add(searchBarLabel);

	//为搜索key加组件 Label加背景和监听
	JLabel searchKeyLabel=new JLabel();
	Icon searchKeyIcon=new ImageIcon("./src/main/resource/picture/marketing/searchKey.png");
	searchKeyLabel.setIcon(searchKeyIcon);
	searchKeyLabel.setBounds(550, 5, 60, 60);
	searchKeyLabel.addMouseListener(new MouseListener(){
		@Override
		public void mouseClicked(MouseEvent e) {
			String orderIDEntered=searchBarField.getText();
			OrderVO order=controller.findSpecificOrder(orderIDEntered);
			ArrayList<OrderVO> orders=new ArrayList<OrderVO>();
			orders.add(order);
			showAbnormalOrders(orders);//调用显示abnormalOrder的方法
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	});
	searchAbnormalPanel.add(searchKeyLabel);

    this.add(searchAbnormalPanel);
    this.repaint();
}

public void showAbnormalOrders(ArrayList<OrderVO> orders){
	 orders=OrderDataTool.list1;
	//设置放置Order信息的JPanel
    showAbnormalOrderPanel=new JPanel();
    showAbnormalOrderPanel.setLayout(null);
    showAbnormalOrderPanel.setPreferredSize(new Dimension(680,+30+150*orders.size()));
    showAbnormalOrderPanel.setBounds(0, 0, 702, 3520);
    showAbnormalOrderPanel.setBackground(Color.LIGHT_GRAY);
    showAbnormalOrderPanel.setOpaque(false);

    //设置放置showAbnormalOrderPanel的JScrollPanel
    JScrollPane showAbnormalScroll = new JScrollPane(showAbnormalOrderPanel);
    showAbnormalScroll.setBounds(20, 150, 699, 365);
    showAbnormalScroll.setBorder(new EmptyBorder(0,0,0,0));
    showAbnormalScroll.setOpaque(false);
    showAbnormalScroll.getViewport().setOpaque(false);
    int num=0;

    Image image=new ImageIcon("./src/main/resource/picture/marketing/orderBackground.png").getImage();
    for(OrderVO order:orders){
    	//制作order背景
        JPanel panel=new JPanel(){
			private static final long serialVersionUID = 1L;
			protected  void paintComponent(Graphics g) {
            	g.drawImage(image,0,0,getSize().width,getSize().height,this);
            }
		};
        panel.setBounds(10, 10+150*num, 700, 150);
        panel.setLayout(null);

        //制作order需要的组件
        Icon checkIcon=new ImageIcon("./src/main/resource/picture/marketing/littleCheck.png");
        JLabel nameLabel=new JLabel("用户："+order.getClientName());
        JLabel orderIDLabel=new JLabel("订单号："+order.getOrderId());
        JLabel hotelLabel=new JLabel("入住酒店："+order.getHotelName());
        JLabel priceLabel=new JLabel("订单价格："+order.getPrice());
        JLabel creditLabel=new JLabel("恢复信用值 ");
        JRadioButton fullButton=new JRadioButton("全额",false);
        JRadioButton halfButton=new JRadioButton("半额",false);
        JLabel checkLabel=new JLabel();
        ButtonGroup group=new ButtonGroup();
        group.add(fullButton);group.add(halfButton);
        checkLabel.setIcon(checkIcon);


        nameLabel.setBounds(5, 5, 600, 30);
        orderIDLabel.setBounds(5, 31, 600, 30);
        hotelLabel.setBounds(5, 57, 300, 30);
        priceLabel.setBounds(310, 57, 300, 30);
        creditLabel.setBounds(5, 86, 300, 30);
        fullButton.setBounds(165, 86, 67, 30);
        halfButton.setBounds(280, 86, 67, 30);
        checkLabel.setBounds(430, 86, 30, 30);

        nameLabel.setFont(font2);     nameLabel.setForeground(Color.white);
        orderIDLabel.setFont(font2);  orderIDLabel.setForeground(Color.white);
        hotelLabel.setFont(font2);    hotelLabel.setForeground(Color.white);
        priceLabel.setFont(font2);    priceLabel.setForeground(Color.white);
        creditLabel.setFont(font2);   creditLabel.setForeground(Color.white);
        fullButton.setFont(font2);     fullButton.setForeground(Color.white);
        halfButton.setFont(font2);     halfButton.setForeground(Color.white);

        fullButton.setContentAreaFilled(false);
        fullButton.setOpaque(false);
        fullButton.setBackground(null);
        fullButton.setBorderPainted(false);;


        panel.add(nameLabel);
        panel.add(orderIDLabel);
        panel.add(hotelLabel);
        panel.add(priceLabel);
        panel.add(creditLabel);
        panel.add(fullButton);
        panel.add(halfButton);


        checkLabel.addMouseListener(new MouseListener(){
        	boolean ifSuccess=false;
			@Override
			public void mouseClicked(MouseEvent e) {
				String log=MarketingID+"撤销异常订单"+order.orderId;
				// Date date=new Date();
				if(group.getSelection()==fullButton){
					controller.setCredit(order.getClientId(),order.getPrice());
					log=log+"全额";
					System.out.println("dss");
				}else if(group.getSelection()==halfButton){
					controller.setCredit(order.getClientId(), order.getPrice()*0.5);
					log=log+"半额";
				}
				if (group.getSelection()!=null){
					order.setOrderStatus(OrderType.ABNORMALCANCEL);
					controller.saveOrder(order);
					//log=log+
					controller.addLog(log);
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
        });
        panel.add(checkLabel);


        showAbnormalOrderPanel.add(panel);
        num++;
    }

    this.add(showAbnormalScroll);
    this.revalidate();
    this.repaint();
}

	public void hideAbnormal() {
		this.setVisible(false);
	}

}