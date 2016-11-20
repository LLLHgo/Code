package presentation.marketing.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.common.GuideBoardButton;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;


public class ProcessMarketingView extends JPanel{
	private static final long serialVersionUID = 1L;
	private ProcessMarketingViewControllerService controller;
	private String MarketingID;
	private Image image;
	private JLabel IDLabel;
	private JLabel ID=new JLabel("ID:");
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,22);
	private Font font2=new Font("楷体",Font.ITALIC,20);
	private Font font3=new Font("微软雅黑",Font.HANGING_BASELINE,28);
	private GuideBoardButton profile=new GuideBoardButton(241,"个人信息");
	private GuideBoardButton abnormal=new GuideBoardButton(301,"异常订单");
	private GuideBoardButton credit=new GuideBoardButton(361,"修改信用值");
	private GuideBoardButton VIP=new GuideBoardButton(421,"管理会员");
	private GuideBoardButton strategy=new GuideBoardButton(481,"制定策略");
	private GuideBoardButton exit=new GuideBoardButton(541,"退出");
	private JLabel welcome;
	private Icon pressedIcon=new ImageIcon("./src/main/resource/picture/pressedIcon.png");
	private MarketingVO Mvo;
	private Image newImage=null;

    public ProcessMarketingView(ProcessMarketingViewControllerService controller){
    	image=new ImageIcon("./src/main/resource/picture/marketing/marketing.png").getImage();
		this.controller=controller;
    	this.MarketingID=controller.getMarketingID();
    	this.setBounds(0, 0,1000,618);

        ID.setFont(font);
        ID.setForeground(Color.white);
        ID.setBounds(50,185,50,30);
        this.add(ID);

        //根据MarketingID加入IDLabel
        IDLabel =new JLabel(MarketingID);
        IDLabel.setFont(font);
        IDLabel.setForeground(Color.white);
      	IDLabel.setBounds(100, 185,200,30);
    	this.add(IDLabel);

    	//获得头像和welcome
    	getProfile();
        this.validate();

        //给profileButton加监听
        profile.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.profileButtonClicked();
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

        abnormal.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.abnormalButtonClicked();
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

      	this.add(profile);this.add(abnormal);this.add(credit);
    	this.add(VIP);this.add(strategy);this.add(exit);
        this.setLayout(null);
    }

    //获得头像和welcome的方法
	private void getProfile() {
        Mvo=controller.init(MarketingID);
        JLabel defaultLabel=new JLabel();
        // 设置放置图片的JLabel的位置
        defaultLabel.setBounds(85,90,100,200);
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

    //点击菜单栏后，隐藏welcome的JPanel
    public void hideWelcome(){
    	welcome.setVisible(false);
    }


}
