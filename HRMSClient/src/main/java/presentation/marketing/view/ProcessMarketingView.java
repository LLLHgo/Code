package presentation.marketing.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.marketingVO.MarketingVO;


public class ProcessMarketingView extends JPanel{
	private static final long serialVersionUID = 1L;
	private ProcessMarketingViewControllerService controller;
	private String MarketingID;
	private ImageIcon icon;
	private Image image;
	private JLabel IDLabel;
	private JLabel ID=new JLabel("ID:");
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,22);
	private JButton profile=new JButton("个人信息");
	private JButton abnormal=new JButton("异常订单");
	private JButton credit=new JButton("修改信用值");
	private JButton VIP=new JButton("管理会员");
	private JButton strategy=new JButton("制定策略");
	private JButton exit=new JButton("退出");
	private ArrayList<JButton> buttonList=new ArrayList<JButton>();

    public ProcessMarketingView(ProcessMarketingViewControllerService controller){
    	this.setBackground(Color.gray);
    	image=new ImageIcon("./src/main/resource/picture/marketing/marketing.jpg").getImage();
		icon=new ImageIcon(image);
    	this.controller=controller;
    	this.MarketingID=controller.getMarketingID();
    	this.setBounds(0, 0,1000,618);
    	//加入菜单栏的button
    	buttonList.add(profile);buttonList.add(abnormal);buttonList.add(credit);
    	buttonList.add(VIP);buttonList.add(strategy);buttonList.add(exit);
    	int num=0;
    	for(JButton button:buttonList){
    		button.setBounds(48,241+60*num,190,40);
    		num++;
    		this.add(button);
    	}

        this.setLayout(null);

    	getProfile();

        this.validate();
    }

    private void getProfile() {
    	IDLabel =new JLabel(MarketingID);
       	this.add(IDLabel);
        IDLabel.setFont(font);
        ID.setFont(font);
        ID.setBounds(50,185,50,30);
    	IDLabel.setBounds(100, 185,200,30);
    	this.add(ID);
        MarketingVO Mvo=controller.init(MarketingID);

	}

	protected  void paintComponent(Graphics g) {
    	int x=0,y=0;
    	g.drawImage(image,x,y,getSize().width,getSize().height,this);
    }


}
