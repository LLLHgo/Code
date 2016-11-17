package presentation.sitemanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.common.GuideBoardButton;
import presentation.sitemanager.controller.ProcessSitemanagerViewController;

public class ProcessSitemanagerView extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ProcessSitemanagerViewControllerService controller;
	//private Image image;//background
	private ImageIcon backgroundImage;
	private ImageIcon currentRightImage;
	private GuideBoardButton jbClientManage;
	private GuideBoardButton jbHotelManage;
	private GuideBoardButton jbMarktingManage;
	private GuideBoardButton jbSitemanagerManage;
	private GuideBoardButton jbShowLog;
	private GuideBoardButton jbExit;
	
	public ProcessSitemanagerView(ProcessSitemanagerViewControllerService controller){
		backgroundImage=new ImageIcon(getClass().getResource("/picture/sitemanager/MainManageBackground.png"));
		//this.setIcon(backgroundIcon);
		
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
		
		jbClientManage.setVisible(true);
		this.add(jbClientManage);
		this.add(jbHotelManage);
		this.add(jbMarktingManage);
		this.add(jbSitemanagerManage);
		this.add(jbShowLog);
		this.add(jbExit);
		
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
		Point point=jbSitemanagerManage.getLocation();
		int x=point.x;
		int y=point.y;
		public void mouseClicked(MouseEvent e) {
			jbSitemanagerManage.setBorderPainted(true);
			JPanel siteManagerPanel=new SitemanagerAccountShowPanel();
			siteManagerPanel.setBounds(275,80,704,502);
			
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
		JLabel idLabel=new JLabel("ID:");
		JLabel telLabel=new JLabel("TEL:");
		JLabel passwordLabel=new JLabel("PASSWORD:");
		JLabel idTextLabel=new JLabel("S00000001");
		JTextField telField=new JTextField("025-88888878");
		JTextField passWordField=new JTextField("HRMSsitemanager");
		
		public  SitemanagerAccountShowPanel(){
			currentRightImage=new ImageIcon(getClass().getResource("/picture/sitemanager/sitemanagerAccountShow.png"));
			this.setSize(704,502);
			this.setLayout(null);
			
			idLabel.setBounds(300, 300, 30, 20);
			telLabel.setBounds(300,350,30,20);
			passwordLabel.setBounds(300, 400, 30, 20);
			this.add(idLabel);
			this.add(telLabel);
			this.add(passwordLabel);
			
			this.setVisible(true);
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			currentRightImage.setImage(currentRightImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
			currentRightImage.paintIcon(this, g, 0, 0);
		}
	}
	
	
}
