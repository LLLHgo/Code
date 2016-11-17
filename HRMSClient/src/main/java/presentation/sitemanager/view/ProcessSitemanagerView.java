package presentation.sitemanager.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.common.GuideBoardButton;
import presentation.common.MyLabel;
import presentation.common.MyTextField;
import presentation.sitemanager.controller.ProcessSitemanagerViewController;

public class ProcessSitemanagerView extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ProcessSitemanagerViewControllerService controller;
	//private Image image;//background
	private ImageIcon backgroundImage;
	private GuideBoardButton jbClientManage;
	private GuideBoardButton jbHotelManage;
	private GuideBoardButton jbMarktingManage;
	private GuideBoardButton jbSitemanagerManage;
	private GuideBoardButton jbShowLog;
	private GuideBoardButton jbExit;
	public JPanel mainPanel;
	
	public ProcessSitemanagerView(ProcessSitemanagerViewControllerService controller){
		backgroundImage=new ImageIcon("src/main/resource/picture/sitemanager/accountManageBackground.png");
		this.controller=controller;
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setSize(1000, 618);
		this.setVisible(true);
		setOpaque(false);
		
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
	
	// 大框架界面 ：包括左上logo，左边导航栏的矩形框架、右边主界面
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		backgroundImage.setImage(backgroundImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		backgroundImage.paintIcon(this, g, 0, 0);
	}
	
	
	// 按钮监听－网站管理人员管理账户
	class jbSiteManagerListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			JPanel siteManagerPanel=new SitemanagerAccountShowPanel();
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
		ImageIcon img=new ImageIcon("src/main/resource/picture/sitemanager/sitemanagerAccountShow.png");
		
		public  SitemanagerAccountShowPanel(){
			this.setBounds(0,0,702,502);
			this.setLayout(null);
			
			idLabel=new MyLabel(300, 200, 60, 40,"帐号:");
			telLabel=new MyLabel(300,240,60,40,"电话:");
			passwordLabel=new MyLabel(300, 280, 100, 40,"密码:");
			idTextLabel=new MyLabel(350,200,150,40,"S00000001");
			telField=new MyTextField(350,240,150,40,"025-88888878");
			passWordField=new MyTextField(350,280,150,40,"HRMSsitemanager");
	
			this.add(idLabel);
			this.add(telLabel);
			this.add(passwordLabel);
			this.add(idTextLabel);
			this.add(telField);
			this.add(passWordField);
			
			this.setVisible(true);
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			img.setImage(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
			img.paintIcon(this, g, 0, 0);
		}
	}
	
	
}
