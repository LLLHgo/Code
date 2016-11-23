package presentation.sitemanager.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Enum.VIPType;
import presentation.sitemanager.component.CheckButton;
import presentation.sitemanager.component.DeleteButton;
import presentation.sitemanager.component.ModifyButton;
import presentation.sitemanager.component.MyLabel;
import presentation.sitemanager.component.MyTextField;
import presentation.sitemanager.component.SearchButton;
import vo.clientVO.ClientVO;

public class ProcessClientAccountManageView extends JPanel{

	private static final long serialVersionUID = 1L;
	private ProcessSitemanagerViewControllerService controller;
	private ProcessSitemanagerView view;
	ClientVO clientVO;
	String id;
	String name;
	String tel;
	VIPType viptype;
	int vipgrade;
	String birth;
	int credit;
	String password;
	// 左边的label
	MyLabel idLabelL;
	MyLabel nameLabelL;
	MyLabel telLabelL;
	MyLabel viptypeLabelL;
	MyLabel vipgradeLabelL;
	MyLabel birthLabelL;
	MyLabel firmLabelL;
	MyLabel creditLabelL;
	MyLabel passwordLabelL;
	
	// 右边的显示具体网站管理人员的id  只改客户的名字、电话、密码
	MyLabel clientIdLabel;
	MyTextField nameText;
	MyTextField telText;
	MyLabel viptypeLabel;
	MyLabel vipgradeLabel;
	MyLabel birthLabel;
	MyLabel firmLabel;
	MyLabel creditLabel;
	MyTextField passwordText;
	
	// 设置右边工具栏图标
	ModifyButton modifyButton;
	CheckButton checkButton;
	DeleteButton deleteButton;
	
	// 客户头像
	JLabel clientIconLabel;
	ImageIcon userdefaultIcon;
	
	// 搜索框
	SearchButton searchButton;
	JTextField searchText;
	
	// 状态栏
	MyLabel conditionLabel;
	
	// 背景图片
	private ImageIcon background;
	
	public ProcessClientAccountManageView(ProcessSitemanagerViewControllerService controller,ProcessSitemanagerView processSitemanagerView){
		this.controller=controller;
		this.view=processSitemanagerView;
		this.setBounds(277,79,702,502);
		this.setLayout(null);
		// 设置背景图片
		background=new ImageIcon("src/main/resource/picture/sitemanager/clientAccountManage.png");
		this.setBounds(276,82,702,502);
		// 搜索按钮
		searchButton=new SearchButton(530,20,40,40);
		// 搜索区域
		searchText=new JTextField();
		searchText.setBounds(210,17,275,40);
		searchText.setFont(new java.awt.Font("微软雅黑",1,20));
		searchText.setOpaque(false);
		searchButton.addMouseListener(new SearchListener());		
		// 状态栏
		conditionLabel=new MyLabel(80,450,500,40,"操作中...");
		conditionLabel.setForeground(Color.white);
		// 右边工具栏
		modifyButton=new ModifyButton(618,180,50,50);
		checkButton=new CheckButton(610,240,65,65);
		deleteButton=new DeleteButton(612,310,65,65);
		modifyButton.addMouseListener(new ModifyMouseListener());
		deleteButton.addMouseListener(new DeleteMouseListener());
		checkButton.addMouseListener(new CheckButtonListener());
		modifyButton.setEnabled(false);
		checkButton.setEnabled(false);
		deleteButton.setEnabled(false);
		// 账户头像区域
		clientIconLabel=new JLabel();
		userdefaultIcon=new ImageIcon("src/main/resource/picture/sitemanager/defaulteUserIcon.png");
		clientIconLabel.setIcon(userdefaultIcon);
		clientIconLabel.setBounds(160,200,100,100);
		// 账户信息区域
		idLabelL=new MyLabel(300,130,60,25,"帐号：");
		nameLabelL=new MyLabel(300,160,60,25,"名字：");
		telLabelL=new MyLabel(300,190,100,25,"电话：");
		viptypeLabelL=new MyLabel(300,220,100,25,"会员种类：");
		vipgradeLabelL=new MyLabel(300,250,100,25,"会员等级：");
		birthLabelL=new MyLabel(300,280,60,25,"生日：");
		firmLabelL=new MyLabel(300,310,100,25,"公司：");
		creditLabelL=new MyLabel(300,340,100,25,"信用值：");
		passwordLabelL=new MyLabel(300,370,60,25,"密码:");
		
		clientIdLabel=new MyLabel(400,130,180,25,"");
		nameText=new MyTextField(400,160,180,25,"");
		telText=new MyTextField(400,190,180,25,"");
		viptypeLabel=new MyLabel(400,220,180,25,"");
		vipgradeLabel=new MyLabel(400,250,180,25,"");
		birthLabel=new MyLabel(400,280,180,25,"");
		firmLabel=new MyLabel(400,310,180,25,"");
		creditLabel=new MyLabel(400,340,180,25,"");
		passwordText=new MyTextField(400,380,180,25,"");
		
		this.add(searchButton);
		this.add(searchText);
		this.add(conditionLabel);
		this.add(modifyButton);
		this.add(checkButton);
		this.add(deleteButton);
		this.add(clientIconLabel);
		this.add(idLabelL);  this.add(nameLabelL);  this.add(telLabelL); this.add(viptypeLabelL); this.add(vipgradeLabelL);
		this.add(birthLabelL); this.add(creditLabelL); this.add(passwordLabelL);
		
		this.add(clientIdLabel);  this.add(nameText); this.add(telText); this.add(viptypeLabel);
		this.add(vipgradeLabel);   this.add(birthLabel); this.add(creditLabel);  this.add(passwordText);
		this.repaint(); 
		view.add(this);
	}
	void showSpecificAccountInfo(ClientVO clientVO){
		
	}
	
	class SearchListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			id=searchText.getText();
			clientVO=controller.clientAccountFind(id);
			if(clientVO==null){
				conditionLabel.setText("无匹配的账户，请确认客户帐号后重新输入！");
			}
			else{
				conditionLabel.setText("找到匹配账户");
				showSpecificAccountInfo(clientVO);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	class DeleteMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	class CheckButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class ModifyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		background.setImage(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		background.paintIcon(this, g, 0, 0);
	}
}
