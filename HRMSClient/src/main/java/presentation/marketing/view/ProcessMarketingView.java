package presentation.marketing.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.GuideBoardButton;
import vo.marketingVO.MarketingVO;


public class ProcessMarketingView extends JPanel{
	private static final long serialVersionUID = 1L;
	private ProcessMarketingViewControllerService controller;
	private String MarketingID;
	private Image image;
	private JLabel IDLabel;
	private JLabel ID=new JLabel("ID:");
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,22);
	private GuideBoardButton profile=new GuideBoardButton(241,"个人信息");
	private GuideBoardButton abnormal=new GuideBoardButton(301,"异常订单");
	private GuideBoardButton credit=new GuideBoardButton(361,"修改信用值");
	private GuideBoardButton VIP=new GuideBoardButton(421,"管理会员");
	private GuideBoardButton strategy=new GuideBoardButton(481,"制定策略");
	private GuideBoardButton exit=new GuideBoardButton(541,"退出");
	private JLabel welcome;

    public ProcessMarketingView(ProcessMarketingViewControllerService controller){
    	image=new ImageIcon("./src/main/resource/picture/marketing/marketing.png").getImage();
		this.controller=controller;
    	this.MarketingID=controller.getMarketingID();
    	this.setBounds(0, 0,1000,618);

        ID.setFont(font);
        ID.setBounds(50,185,50,30);
        this.add(ID);

        //根据MarketingID加入IDLabel
        IDLabel =new JLabel(MarketingID);
        IDLabel.setFont(font);
      	IDLabel.setBounds(100, 185,200,30);
    	this.add(IDLabel);

    	//获得头像和welcome
    	getProfile();

        this.validate();


        //给 profile button加监听
    	profile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
               System.out.println("dj");

			}

    	});
    	this.add(profile);this.add(abnormal);this.add(credit);
    	this.add(VIP);this.add(strategy);this.add(exit);
        this.setLayout(null);
    }

	private void getProfile() {
        MarketingVO Mvo=controller.init(MarketingID);
        JLabel defaultLabel=new JLabel();
        // 设置放置图片的JLabel的位置
        defaultLabel.setBounds(85, 90,100,200);
        Icon photo;
        if(Mvo.getImage()!=null)//位置营销人员设置个人头像
            photo=new ImageIcon(Mvo.getImage());
        else  //网站营销人员未设置个人头像，则使用默认头像
        	photo=new ImageIcon("./src/main/resource/picture/default.png");
        defaultLabel.setIcon(photo);
        this.add(defaultLabel);

        //welcome:JLabel welcomeIcon:Icon
        welcome=new JLabel();
        welcome.setBounds(275,-19,775,800);
        Icon welcomeIcon=new ImageIcon("./src/main/resource/picture/welcomeIcon.png");
        welcome.setIcon(welcomeIcon);
        this.add(welcome);
	}

	protected  void paintComponent(Graphics g) {
    	g.drawImage(image,0,0,getSize().width,getSize().height,this);
    }


}
