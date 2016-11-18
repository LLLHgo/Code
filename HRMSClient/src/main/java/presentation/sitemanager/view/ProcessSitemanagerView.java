package presentation.sitemanager.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.CheckButton;
import presentation.common.DeleteButton;
import presentation.common.GuideBoardButton;
import presentation.common.ModifyButton;
import presentation.common.MyLabel;
import presentation.common.MyTextField;
import vo.sitemanager.SitemanagerVO;

public class ProcessSitemanagerView extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ProcessSitemanagerViewControllerService controller;
	private MyLabel currentUserIdLabel;
	private JLabel currentUserIconLabel;
	private ImageIcon backgroundImage;
	private ImageIcon defaultUserIcon;
	private ImageIcon currentUserIcon;
	private GuideBoardButton jbClientManage;
	private GuideBoardButton jbHotelManage;
	private GuideBoardButton jbMarktingManage;
	private GuideBoardButton jbSitemanagerManage;
	private GuideBoardButton jbShowLog;
	private GuideBoardButton jbExit;
	public JPanel mainPanel;
	public SitemanagerAccountShowPanel sitemanagerAccountShowPanel;
	
	SitemanagerVO sitemanagerVO;
	SitemanagerVO currentSitemanagerUserVO;
	String currentUserId;
	
	public ProcessSitemanagerView(ProcessSitemanagerViewControllerService controller){
		backgroundImage=new ImageIcon("src/main/resource/picture/sitemanager/accountManageBackground.png");
		defaultUserIcon=new ImageIcon("src/main/resource/picture/sitemanager/defaulteUserIcon.png");
		this.controller=controller;
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setSize(1000, 618);
		this.setVisible(true);
		setOpaque(false);
		
		currentUserId=controller.getSitemanagerId();
		currentSitemanagerUserVO=controller.init(currentUserId);
		
		currentUserIdLabel=new MyLabel(60,190,200,40,"ID: "+currentUserId);
		currentUserIdLabel.setForeground(Color.white);
		currentUserIconLabel=new JLabel();
		currentUserIcon=getIcon(currentSitemanagerUserVO);
		currentUserIconLabel.setIcon(currentUserIcon);
		currentUserIconLabel.setBounds(90, 90, 95, 95);
		
		jbClientManage=new GuideBoardButton(241,"用户账户管理");
		jbHotelManage=new GuideBoardButton(299,"酒店账户管理");
		jbMarktingManage=new GuideBoardButton(357,"网营账户管理");
		jbSitemanagerManage=new GuideBoardButton(414,"个人账户管理");
		jbShowLog=new GuideBoardButton(471,"查看日志");
		jbExit=new GuideBoardButton(528,"退出");
		
		mainPanel=new JPanel();
		mainPanel.setBounds(276,82,702,502);
		mainPanel.setLayout(null);
		mainPanel.setOpaque(false);
		
		this.add(currentUserIdLabel);
		this.add(currentUserIconLabel);
		this.add(jbClientManage);
		this.add(jbHotelManage);
		this.add(jbMarktingManage);
		this.add(jbSitemanagerManage);
		this.add(jbShowLog);
		this.add(jbExit);
		this.add(mainPanel);
		
		jbSitemanagerManage.addMouseListener(new jbSiteManagerListener());
		this.setVisible(true);
	}
	// 设置当前sitemanager头像
	ImageIcon getIcon(SitemanagerVO sitemanagerVO){
		ImageIcon icon=sitemanagerVO.getUserImage();
		if(icon!=null){
			return icon;
		}
		else
			return defaultUserIcon;
	}
	// 大框架界面 ：包括左上logo，左边导航栏的矩形框架、右边主界面
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		backgroundImage.setImage(backgroundImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		backgroundImage.paintIcon(this, g, 0, 0);
	}
	
	
	// 按钮监听－网站管理人员管理账户
	class jbSiteManagerListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			sitemanagerVO=controller.sitemanagerAcountShow();
			JPanel siteManagerPanel=new SitemanagerAccountShowPanel(sitemanagerVO);
			siteManagerPanel.setBounds(0, 0, 702, 502);
			siteManagerPanel.setVisible(true);
			mainPanel.add(siteManagerPanel);
			mainPanel.setBackground(Color.blue);
		}

		public void mousePressed(MouseEvent e) {
			//jbSitemanagerManage.setBorderPainted(true);
		}

		public void mouseReleased(MouseEvent e) {
			//jbSitemanagerManage.setBorderPainted(true);
		}

		public void mouseEntered(MouseEvent e) {
			//jbSitemanagerManage.setBorderPainted(true);
		}

		public void mouseExited(MouseEvent e) {
			//jbSitemanagerManage.setBorderPainted(false);
		}

		
	}
	
	class SitemanagerAccountShowPanel extends JPanel{
		private static final long serialVersionUID = 1L;
		MyLabel idLabel;
		MyLabel telLabel;
		MyLabel passwordLabel;
		MyLabel idTextLabel;
		MyTextField telField;
		MyTextField passWordField;
		ModifyButton modifyButton;
		//DeleteButton deleteButton;
		CheckButton checkButton;
		ImageIcon img=new ImageIcon("src/main/resource/picture/sitemanager/sitemanagerAccountShow.png");
		
		public  SitemanagerAccountShowPanel(SitemanagerVO sitemanagerVO){
			this.setBounds(0,0,702,502);
			this.setLayout(null);
			
			String id=sitemanagerVO.getSitemanagerId();
			String tel=sitemanagerVO.getSitemanagerPhoneNumber();
			String password=sitemanagerVO.getPassword();
			idLabel=new MyLabel(300, 200, 60, 40,"帐号:");
			telLabel=new MyLabel(300,240,60,40,"电话:");
			passwordLabel=new MyLabel(300, 280, 100, 40,"密码:");
			idTextLabel=new MyLabel(350,200,150,40,id);
			telField=new MyTextField(350,240,200,40,tel);
			passWordField=new MyTextField(350,280,200,40,password);
			modifyButton=new ModifyButton(620,180,50,50);
			//deleteButton=new DeleteButton(612,280,65,65);
			checkButton=new CheckButton(618,280,55,55);
			
			this.add(idLabel);
			this.add(telLabel);
			this.add(passwordLabel);
			this.add(idTextLabel);
			this.add(telField);
			this.add(passWordField);
			this.add(modifyButton);
			//this.add(deleteButton);
			this.add(checkButton);
			
			this.setVisible(true);
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			img.setImage(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
			img.paintIcon(this, g, 0, 0);
		}
	}
	
	
}
