package presentation.marketing.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import datatool.OrderDataTool;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;

public class ProcessMarketingAbnormalView extends JPanel{
	private ProcessMarketingViewControllerService controller;
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,22);
	private Font font2=new Font("楷体",Font.ITALIC,20);
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
    showAbnormalOrderPanel.setPreferredSize(new Dimension(720,200*orders.size()));
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
   
    for(int i=0;i<10;i++){
        JPanel panel=new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 10+70*num, 700, 50);
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