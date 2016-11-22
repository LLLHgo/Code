package presentation.sitemanager.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Enum.ResultMessage;
import presentation.common.AddButton;
import presentation.common.CheckButton;
import presentation.common.DeleteButton;
import presentation.common.ModifyButton;
import presentation.common.MyLabel;
import presentation.common.MyTextField;
import presentation.common.SearchButton;
import presentation.common.UserIconModifyButton;
import vo.marketingVO.MarketingVO;

public class MarketingAccountManageView extends JPanel{
	private static final long serialVersionUID = 1L;
	private ProcessSitemanagerViewControllerService controller;
	MarketingVO marketingVO;

	String id;
	String name;
	String tel;
	String password;
	ImageIcon background;
	MyLabel idLabel;
	MyLabel nameLabel;
	MyLabel telLabel;
	MyLabel passwordLabel;
	JLabel currentImgLabel;
	// 右边的显示具体网站管理人员的id
	MyLabel marketingIdLabel;
	MyTextField marketingName;
	MyTextField marketingTel;
	MyTextField marketingPassword;

	SearchButton searchButton;
	JTextField searchBarText;

	ModifyButton modifyButton;
	CheckButton checkButton;
	DeleteButton deleteButton;
	AddButton addButton;

	//放网站管理人员头像的label
	JLabel marktingIcon;
	ImageIcon currentMarktingIcon;

	// 上传头像按钮
	MyLabel updateIconLabel;
	UserIconModifyButton userIconModigyButton;
	ImageIcon userIconDefault;
	UserIconModifyButton userIconModifyButton;

	// 状态栏
	MyLabel conditionalText;

	//修改后的新信息
	String newName;
	String newTel;
	String newPassword;
	MarketingVO newMarketingVO;
	Icon newImg;
	public MarketingAccountManageView(ProcessSitemanagerViewControllerService controller){
		this.controller=controller;
		this.setLayout(null);
		background=new ImageIcon("src/main/resource/picture/sitemanager/marketingAccountManage.png");
		userIconDefault=new ImageIcon("src/main/resource/picture/sitemanager/defaultUserAddIcon.png");
		// 搜索按钮
		searchButton=new SearchButton(530,20,40,40);
		// 搜索区域
		searchBarText=new JTextField();
		searchBarText.setBounds(210,17,275,40);
		searchBarText.setFont(new java.awt.Font("微软雅黑",  1,  20));
		searchBarText.setOpaque(false);
		searchButton.addMouseListener(new SearchListener());
		// 状态栏
		conditionalText=new MyLabel(80,450,500,40,"操作中...");
		conditionalText.setForeground(Color.white);
		// 右边工具栏
		modifyButton=new ModifyButton(618,135,50,50);;
		checkButton=new CheckButton(618,200,55,55);
		deleteButton=new DeleteButton(610,275,65,65);
		addButton=new AddButton(612,355,65,65);
		// 账户信息
		idLabel=new MyLabel(300,160,60,40,"帐号：");
		nameLabel=new MyLabel(300,200,60,40,"名字：");
		telLabel=new MyLabel(300,240,60,40,"电话：");
		passwordLabel=new MyLabel(300,280,60,40,"密码：");
		marketingIdLabel=new MyLabel(350,160,200,40,"");
		marketingName=new MyTextField(350,200,200,40,"");
		marketingTel=new MyTextField(350,240,200,40,"");
		marketingPassword=new MyTextField(350,280,200,40,"");
		// 网站营销人员头像区域
		marktingIcon=new JLabel();
		marktingIcon.setIcon(userIconDefault);
		marktingIcon.setBounds(160,200,100,100);
		// 显示－>上传头像的label
		updateIconLabel=new MyLabel(160,320,100,20,"上传头像");
		updateIconLabel.setForeground(Color.white);
		userIconModifyButton=new UserIconModifyButton(220,280,100,100);

		modifyButton.setEnabled(false);
		checkButton.setEnabled(false);
		deleteButton.setEnabled(false);

		modifyButton.addMouseListener(new MarketingModifyListener());
		checkButton.addMouseListener(new MarketingCheckListener());
		// 右边工具栏
		this.add(modifyButton);
		this.add(checkButton);
		this.add(deleteButton);
		this.add(addButton);
		// 主面板详细信息
		this.add(idLabel);
		this.add(nameLabel);
		this.add(telLabel);
		this.add(passwordLabel);

		this.add(marketingIdLabel);
		this.add(marketingName);
		this.add(marketingTel);
		this.add(marketingPassword);
		// 搜索栏
		this.add(searchButton);
		this.add(searchBarText);
		this.add(conditionalText);
		// 网站营销人员头像
		this.add(marktingIcon);
		this.add(updateIconLabel);
		this.add(userIconModifyButton);
	}
	void showSpecificAccountInfo(MarketingVO marketingVO){
		this.setLayout(null);
		id=marketingVO.getMarketingID();
		name=marketingVO.getName();
		password=marketingVO.getPassword();
		tel=marketingVO.getTelephone();
		marketingIdLabel.setText(id);
		marketingName.setText(name);
		marketingTel.setText(tel);
		marketingPassword.setText(password);

		checkButton.setEnabled(true);
		modifyButton.setEnabled(true);
		marketingName.setEditable(false);
		marketingTel.setEditable(false);
		marketingPassword.setEditable(false);
	}
	class SearchListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			id=searchBarText.getText();
			marketingVO=controller.MarketingAccountFind(id);
			if(marketingVO==null){
				conditionalText.setText("无匹配的账户，请确认网站营销人员帐号后重新输入！");
			}
			else{
				conditionalText.setText("找到匹配账户");
				showSpecificAccountInfo(marketingVO);
			}

		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}

	class MarketingModifyListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			marketingName.setEditable(true);
			marketingTel.setEditable(true);
			marketingPassword.setEditable(true);
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
	class MarketingCheckListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			ResultMessage result;
			newName=marketingName.getText();
			newTel=marketingTel.getText();
			newPassword=marketingPassword.getText();
			newImg= marktingIcon.getIcon();
			newMarketingVO=new MarketingVO(newName,newPassword,id,newTel);
			result=controller.MarketingAccountUpdate(newMarketingVO);
			if(result==ResultMessage.SUCCESS){
				conditionalText.setText("修改成功！");
			}else{
				conditionalText.setText("信息未做更改，不再进行保存！");
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

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		background.setImage(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		background.paintIcon(this, g, 0, 0);
	}

}
