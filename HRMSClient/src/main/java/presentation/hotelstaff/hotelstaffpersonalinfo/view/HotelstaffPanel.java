package presentation.hotelstaff.hotelstaffpersonalinfo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Enum.Star;
import presentation.common.ModifyButton;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.ReviewImageButton;
import presentation.hotelstaff.component.ReviewTextArea;
import presentation.hotelstaff.component.UserImageLabel;
import presentation.hotelstaff.hotelstaffpersonalinfo.controller.HotelstaffPanelController;
import vo.hotelinfoVO.HotelinfoVO;

public class HotelstaffPanel extends JPanel{
	
	private HotelstaffPanelController controller;
	private String hotelID;
	private ImageIcon ipassword;
	private JPasswordField jpfPassword;
	private UserImageLabel jlUserImage;
	private ReviewImageButton jbReviewImage;
	private ModifyButton jbModify;
	private ConfirmButton jbConfirm;
	private CancleButton jbCancle;
	private String password;
	
	public HotelstaffPanel(HotelstaffPanelController controller,String hotelID){
		this.controller = controller;
		this.hotelID = hotelID;
		initHotelstaffPanel();
	}
	
	private void initHotelstaffPanel(){
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setSize(1000, 618);
		this.setVisible(true);
		setOpaque(false);
		
		ipassword = new ImageIcon("./src/main/resource/picture/hotelstaff/password.png");
		
		password = controller.getBasicinfo(hotelID).getPassword();
		
		jpfPassword = new JPasswordField(15);
		jpfPassword.setEchoChar('*');
		Font font = new Font("微软雅黑",Font.PLAIN,20);
		jpfPassword.setFont(font);
		jpfPassword.setForeground(Color.white);
		jpfPassword.setBounds(345, 260, 585, 50);
		jpfPassword.setOpaque(false);
		jpfPassword.setBorder(null);
		jpfPassword.setText(password);
		jpfPassword.setEditable(false);
		this.add(jpfPassword);
		
		jbModify = new ModifyButton(900,255,60,60);
		jbModify.addActionListener(new ModifyButtonActionListener());
		this.add(jbModify);
		
		jbConfirm = new ConfirmButton(680,485);
		jbConfirm.addActionListener(new ConfirmButtonActionListener());
		jbConfirm.setVisible(false);
		this.add(jbConfirm);
		
		jbCancle = new CancleButton(480,488);
		jbCancle.addActionListener(new CancleButtonActionListener());
		jbCancle.setVisible(false);
		this.add(jbCancle);
		
		jlUserImage = new UserImageLabel(550,150);
		this.add(jlUserImage);
		
		jbReviewImage = new ReviewImageButton(650,187);
		jbReviewImage.addActionListener(new ReviewImageActionListener());
		this.add(jbReviewImage);
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(ipassword.getImage(), 285,260,670,50,this);
    }
	
	
	
	private class ModifyButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jbConfirm.setVisible(true);
			jbCancle.setVisible(true);
			jbModify.setVisible(false);
			jpfPassword.setEditable(true);
		}	
	}
	
	private class ConfirmButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jbConfirm.setVisible(false);
			jbCancle.setVisible(false);
			jbModify.setVisible(true);
			jpfPassword.setEditable(false);
			password = jpfPassword.getPassword().toString();
			controller.setPassword(hotelID, password);
			//TODO
		}	
	}
	
	private class CancleButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jbConfirm.setVisible(false);
			jbCancle.setVisible(false);
			jbModify.setVisible(true);
			jpfPassword.setEditable(false);
			jpfPassword.setText(password);
		}	
	}
	

	private class ReviewImageActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO
		}	
	}
}
