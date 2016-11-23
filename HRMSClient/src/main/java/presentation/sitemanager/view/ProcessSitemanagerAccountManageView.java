package presentation.sitemanager.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.ResultMessage;
import presentation.common.AddButton;
import presentation.common.CheckButton;
import presentation.common.ModifyButton;
import presentation.common.MyLabel;
import presentation.common.MyTextField;
import vo.sitemanager.SitemanagerVO;

public class ProcessSitemanagerAccountManageView extends JPanel{
	private static final long serialVersionUID = 1L;
	private ProcessSitemanagerViewControllerService controller;
	private ProcessSitemanagerView view;
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
	AddButton addButton;
	CheckButton checkButton;
	MyLabel conditionalLabel;

	// 主菜单界面的账户头像
	JLabel accountUserHeadLabel;
	ImageIcon defaultUserIcon;
	
	ImageIcon img=new ImageIcon("src/main/resource/picture/sitemanager/sitemanagerAccountShow.png");
	
	public  ProcessSitemanagerAccountManageView(ProcessSitemanagerViewControllerService controller
		,ProcessSitemanagerView processSitemanagerView,SitemanagerVO sitemanagerVO){
		this.controller=controller;
		this.view=processSitemanagerView;
		
		this.setLayout(null);
		this.controller=controller;
		// 账户信息显示区域
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
		checkButton=new CheckButton(618,280,55,55);
		// 设置状态栏
		conditionalLabel=new MyLabel(80,450,350,40,"操作中...");
		conditionalLabel.setForeground(Color.white);
		// 设置右边主菜单的账户头像
		defaultUserIcon=new ImageIcon("src/main/resource/picture/sitemanager/defaulteUserIcon.png");
		accountUserHeadLabel=new JLabel();
		accountUserHeadLabel.setBounds(160,200,100,100);
		accountUserHeadLabel.setIcon(defaultUserIcon);
		// 给修改、确认按钮加监听
		modifyButton.addMouseListener(new ModifyListener());
		checkButton.addMouseListener(new CheckListener());
		
		this.add(idLabel);
		this.add(telLabel);
		this.add(passwordLabel);
		this.add(idTextLabel);
		this.add(telField);
		this.add(passWordField);
		this.add(modifyButton);
		this.add(checkButton);
		this.add(conditionalLabel);
		this.add(accountUserHeadLabel);
		this.setVisible(true);
		this.setBounds(276,82,702,502);
		this.repaint();
		view.add(this);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		img.setImage(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		img.paintIcon(this, g, 0, 0);
	}
	
	class ModifyListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			telField.setEditable(true);
			passWordField.setEditable(true);
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	class CheckListener implements MouseListener{
		String newTel;
		String newPassword;
		ImageIcon newImg;
		SitemanagerVO newSitemanagerVO;
		ResultMessage result;
		public void mouseClicked(MouseEvent e) {
			newTel=telField.getText();
			newPassword=passWordField.getText();
			newSitemanagerVO=new SitemanagerVO(id,newTel,newPassword);
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
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	public void hideSitemanagerAccountManageView(){
		this.setVisible(false);
	}
}
