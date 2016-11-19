package presentation.sitemanager.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.ResultMessage;
import presentation.common.AddButton;
import presentation.common.CheckButton;
import presentation.common.DeleteButton;
import presentation.common.GuideBoardButton;
import presentation.common.ModifyButton;
import presentation.common.MyLabel;
import presentation.common.MyTextField;
import presentation.common.UserIconModify;
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
		String id;
		String tel;
		String password;
		MyLabel idLabel;
		MyLabel telLabel;
		MyLabel passwordLabel;
		MyLabel idTextLabel;
		MyTextField telField;
		MyTextField passWordField;
		ModifyButton modifyButton;
		//DeleteButton deleteButton;
		AddButton addButton;
		CheckButton checkButton;
		MyLabel conditionalLabel;
		MyLabel UploadUserIcon;
		//UploadUserIcon uploadUserIcon;
		// 主菜单界面的账户头像
		JLabel accountUserHeadLabel;
		ImageIcon defaultAddUserIcon;
		UserIconModify userIconModify;
		// 主菜单界面的账户头像的icon
		ImageIcon currentUserIcon;
		ImageIcon img=new ImageIcon("src/main/resource/picture/sitemanager/sitemanagerAccountShow.png");
		
		public  SitemanagerAccountShowPanel(SitemanagerVO sitemanagerVO){
			this.setBounds(0,0,702,502);
			this.setLayout(null);
			
			id=sitemanagerVO.getSitemanagerId();
			tel=sitemanagerVO.getSitemanagerPhoneNumber();
			password=sitemanagerVO.getPassword();
			idLabel=new MyLabel(300, 200, 60, 40,"帐号:");
			telLabel=new MyLabel(300,240,60,40,"电话:");
			passwordLabel=new MyLabel(300, 280, 100, 40,"密码:");
			idTextLabel=new MyLabel(350,200,150,40,id);
			telField=new MyTextField(350,240,200,40,tel);
			passWordField=new MyTextField(350,280,200,40,password);
			modifyButton=new ModifyButton(620,180,50,50);
			//deleteButton=new DeleteButton(612,280,65,65);
			checkButton=new CheckButton(618,280,55,55);
			//addButton=new AddButton(614,340,65,65);
			UploadUserIcon=new MyLabel(160,320,100,20,"上传头像");
			UploadUserIcon.setForeground(Color.white);
			conditionalLabel=new MyLabel(80,450,350,40,"操作中...");
			conditionalLabel.setForeground(Color.white);
			userIconModify=new UserIconModify(220,280,100,100);
			
			defaultAddUserIcon=new ImageIcon("src/main/resource/picture/sitemanager/defaultUserAddIcon.png");
			accountUserHeadLabel=new JLabel();
			accountUserSetImageIcon(sitemanagerVO.getUserImage());
			accountUserHeadLabel.setBounds(160,200,100,100);
			
			modifyButton.addMouseListener(new ModifyListener());
			checkButton.addMouseListener(new AddListener());
			userIconModify.addMouseListener(new UserIconModifyListener());
			
			this.add(idLabel);
			this.add(telLabel);
			this.add(passwordLabel);
			this.add(idTextLabel);
			this.add(telField);
			this.add(passWordField);
			this.add(modifyButton);
			//this.add(deleteButton);
			this.add(checkButton);
			//this.add(addButton);
			this.add(UploadUserIcon);
			this.add(conditionalLabel);
			this.add(accountUserHeadLabel);
			this.add(userIconModify);
			this.setVisible(true);
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			img.setImage(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
			img.paintIcon(this, g, 0, 0);
		}
		
		void accountUserSetImageIcon(ImageIcon imageIcon){
			if(imageIcon==null){
				accountUserHeadLabel.setIcon(defaultAddUserIcon);
			}
			else
				accountUserHeadLabel.setIcon(imageIcon);
			currentUserIcon=imageIcon;
		}
		
		
		class ModifyListener implements MouseListener{

			public void mouseClicked(MouseEvent e) {
				telField.setEditable(true);
				passWordField.setEditable(true);
			}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
			}

			public void mouseExited(MouseEvent e) {
				
			}
			
		}
		
		class AddListener implements MouseListener{
			String newTel;
			String newPassword;
			ImageIcon newImg;
			SitemanagerVO newSitemanagerVO;
			ResultMessage result;
			public void mouseClicked(MouseEvent e) {
				newTel=telField.getText();
				newPassword=passWordField.getText();
				newImg=currentUserIcon;
				newSitemanagerVO=new SitemanagerVO(id,newTel,newPassword,currentUserIcon);
				result=controller.sitemanagerAccountUpdate(newSitemanagerVO);
				if(result==ResultMessage.SUCCESS){
					conditionalLabel.setText("保存成功！");
				}
				else{
					conditionalLabel.setText("信息并未发生修改，不再进行保存！");
				}
				telField.setEditable(false);
				passWordField.setEditable(false);
			}
			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
			}

			public void mouseExited(MouseEvent e) {
				
			}
			
		}
		class UserIconModifyListener implements MouseListener{
			// 找图片文件
				// 按取消键，则不保存，默认newimage为当前的icon
			Icon newImage=UploadUserIcon.getIcon();
			public void mouseClicked(MouseEvent e) {
				if(currentUserIcon==newImage){
					currentUserIcon=(ImageIcon) newImage;
				}
				else{
					UploadUserIcon.setIcon(newImage);
					conditionalLabel.setText("上传头像成功");
				}
			}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
			}

			public void mouseExited(MouseEvent e) {
				
			}
			
		}
	}
	
	
}
