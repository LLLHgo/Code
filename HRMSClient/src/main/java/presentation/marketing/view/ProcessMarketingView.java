package presentation.marketing.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private Font font2=new Font("楷体",Font.ITALIC,20);
	private GuideBoardButton profile=new GuideBoardButton(241,"个人信息");
	private GuideBoardButton abnormal=new GuideBoardButton(301,"异常订单");
	private GuideBoardButton credit=new GuideBoardButton(361,"修改信用值");
	private GuideBoardButton VIP=new GuideBoardButton(421,"管理会员");
	private GuideBoardButton strategy=new GuideBoardButton(481,"制定策略");
	private GuideBoardButton exit=new GuideBoardButton(541,"退出");
	private JLabel welcome;
	private Icon pressedIcon=new ImageIcon("./src/main/resource/picture/pressedIcon.png");
	private JPanel profilePanel;
	private MarketingVO Mvo;

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


        //给 profile button加监听
    	profile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
               // profile.setIcon(pressedIcon);
			   deleteWelcome();//调用外部类的隐藏welcome的JLabel的方法
               controller.profileButtonClicked();
			}

    	});

    	this.add(profile);this.add(abnormal);this.add(credit);
    	this.add(VIP);this.add(strategy);this.add(exit);
        this.setLayout(null);
    }

    //点击菜单栏后，隐藏welcome的JLabel
    private void deleteWelcome(){
    	welcome.setVisible(false);
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

	public void profileButtonClicked() {
		//profileButton点击后的JPanel
        profilePanel=new JPanel();
        profilePanel.setLayout(null);
        profilePanel.setBounds(276, 82, 704, 500);
        profilePanel.setOpaque(false);

        //将五个Label加到panel上
        JLabel nameLabel =new JLabel("姓名");
        JLabel  accountLabel =new JLabel("账号");
        JLabel  TELLabel =new JLabel("TEL");
        JLabel passwordLabel=new JLabel("密码");
        JLabel photoLabel=new JLabel("头像");
        ArrayList<JLabel> labelList =new ArrayList<JLabel>();
        labelList.add(nameLabel);labelList.add(accountLabel);
        labelList.add(TELLabel);labelList.add(passwordLabel);labelList.add(photoLabel);
        int num=0;
        for(JLabel label:labelList){
        	label.setFont(font);
        	label.setForeground(Color.white);
        	label.setBounds(100, 40+num*80, 60, 60);
        	num++;
        	profilePanel.add(label);
        }

        // 设置JTextField
        JTextField nameField=new JTextField(Mvo.getName());
        JTextField accountField =new JTextField(MarketingID);
        JTextField TELField=new JTextField(Mvo.getTelephone());
        JTextField passwordField=new JTextField(Mvo.getPassword());
        ArrayList<JTextField> fieldList=new ArrayList<JTextField>();
        fieldList.add(nameField);fieldList.add(accountField);fieldList.add(TELField);fieldList.add(passwordField);
        num=0;
        for(JTextField field:fieldList){
        	field.setFont(font2);
        	field.setForeground(Color.black);
        	field.setBounds(250, 46+num*80, 200, 48);
        	field.setBackground(null);
        	field.setOpaque(false);
        	field.setEditable(false);
        	num++;
        	profilePanel.add(field);
        }

        //设置TELmodify图标与监听
        Icon modifyIcon=new ImageIcon("./src/main/resource/picture/marketing/modify.png");
        JLabel modifyLabelForTEL=new JLabel();
        modifyLabelForTEL.setBounds(550, 215, 60, 60);
        modifyLabelForTEL.setIcon(modifyIcon);
        modifyLabelForTEL.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				TELField.setEditable(true);
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
        profilePanel.add(modifyLabelForTEL);

        //设置Passwordmodify图标与监听
        JLabel modifyLabelForPassword=new JLabel();
        modifyLabelForPassword.setBounds(550, 293, 60, 60);
        modifyLabelForPassword.setIcon(modifyIcon);
        modifyLabelForPassword.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEditable(true);
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
        profilePanel.add(modifyLabelForPassword);

        //加入头像监听
        Icon photoIcon=new ImageIcon("./src/main/resource/picture/marketing/addphoto.png");
        JLabel addphotoLabel=new JLabel();
        addphotoLabel.setIcon(photoIcon);

        if(Mvo.getImage()!=null){
        	Icon myphoto=new ImageIcon(Mvo.getImage());
        	JLabel myphotoLabel=new JLabel();
        	myphotoLabel.setIcon(myphoto);
        	myphotoLabel.setBounds(320,445, 200, 200);
        	addphotoLabel.setBounds(320,445, 60, 60);
        }else{
            addphotoLabel.setBounds(340,445, 60, 60);
        }
        addphotoLabel.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				String newTEL=TELField.getText(),newPassword=passwordField.getText();

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
        profilePanel.add(addphotoLabel);

        //加入确认图标
        Icon ensureIcon=new ImageIcon("./src/main/resource/picture/marketing/ensure.png");
        JLabel ensureLabel=new JLabel();
        ensureLabel.setBounds(300,445, 60, 60);
        ensureLabel.setIcon(ensureIcon);
        ensureLabel.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				String newTEL=TELField.getText(),newPassword=passwordField.getText();

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
        profilePanel.add(ensureLabel);
        this.add(profilePanel);
	}


}
