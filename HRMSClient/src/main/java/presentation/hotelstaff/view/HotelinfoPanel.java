package presentation.hotelstaff.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Enum.Star;
import presentation.common.ModifyButton;
import presentation.common.MyLabel;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.ReviewButton;
import presentation.hotelstaff.component.ReviewTextArea;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.hotelinfoVO.HotelinfoVO;

public class HotelinfoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private HotelstaffViewController controller;
	private String hotelID;
	private String name;
	private String address;
	private String area;
	private String intro;
	private String facility;
	private String tel;
	private Star star;
	private ReviewTextArea jtaAddress;
	private ReviewTextArea jtaArea;
	private ReviewTextArea jtaIntro;
	private ReviewTextArea jtaFacility;
	private ReviewTextArea jtaTEL;
	private ReviewTextArea jtaStar;
	private ImageIcon init_image;
	private ModifyButton jbModify;
	private ConfirmButton jbConfirm;
	private CancleButton jbCancle;
	
	public HotelinfoPanel(HotelstaffViewController controller){
		this.controller = controller;
		this.hotelID = controller.gethotelID();
		initHotelinfoPanel();
	}
	
	private void initHotelinfoPanel(){
		this.setLayout(null);
		this.setBounds(0,0,1000,618);
		this.setVisible(true);
		setOpaque(false);
		
		init_image = new ImageIcon("./src/main/resource/picture/hotelinfo/hotelinfoPanel.png");
	
		jbModify = new ModifyButton(580,485,60,60);
		jbModify.addActionListener(new ModifyButtonActionListener());
		this.add(jbModify);
		
		this.name = controller.getHotelBasicinfo(hotelID).getName();
		this.address = controller.getHotelBasicinfo(hotelID).getAddress();
		this.area = controller.getHotelBasicinfo(hotelID).getArea();
		this.intro = controller.getHotelBasicinfo(hotelID).getIntroduction();
		this.facility = controller.getHotelBasicinfo(hotelID).getFacility();
		this.tel = controller.getHotelBasicinfo(hotelID).getTel();
		this.star = controller.getHotelBasicinfo(hotelID).getStar();
		
		jtaAddress = new ReviewTextArea(345,135,580,25,address);
		jtaArea= new ReviewTextArea(345,186,580,25,area);
		jtaIntro= new ReviewTextArea(345,230,580,70,intro);
		jtaFacility= new ReviewTextArea(345,311,580,70,facility);
		jtaTEL= new ReviewTextArea(345,402,580,25,tel);
		jtaStar= new ReviewTextArea(345,451,580,25,String.valueOf(star));
		
		this.add(jtaAddress);
		this.add(jtaArea);
		this.add(jtaIntro);
		this.add(jtaFacility);
		this.add(jtaTEL);
		this.add(jtaStar);
		
		jbConfirm = new ConfirmButton(695,485);
		jbConfirm.addActionListener(new ConfirmButtonActionListener());
		jbConfirm.setVisible(false);
		this.add(jbConfirm);
		
		jbCancle = new CancleButton(495,488);
		jbCancle.addActionListener(new CancleButtonActionListener());
		jbCancle.setVisible(false);
		this.add(jbCancle);
		
		MyLabel label = new MyLabel(280,90,500,25,name);
		this.add(label);
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(init_image.getImage(), 280,125,668,360,this);
    }

	private class ModifyButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jtaAddress.setEditable(true);
			jtaArea.setEditable(true);
			jtaIntro.setEditable(true);
			jtaFacility.setEditable(true);
			jtaTEL.setEditable(true);
			jtaStar.setEditable(true);
			
			jbModify.setVisible(false);
			jbCancle.setVisible(true);
			jbConfirm.setVisible(true);

		}
		
	}
	
	private class ConfirmButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jtaAddress.setEditable(false);
			jtaArea.setEditable(false);
			jtaIntro.setEditable(false);
			jtaFacility.setEditable(false);
			jtaTEL.setEditable(false);
			jtaStar.setEditable(false);
			
			jbModify.setVisible(true);
			jbCancle.setVisible(false);
			jbConfirm.setVisible(false);
			
			address = jtaAddress.getText();
			area = jtaArea.getText();
			intro = jtaIntro.getText();
			facility = jtaFacility.getText();
			tel = jtaTEL.getText();
			String sStar = jtaStar.getText();
			String[] arrayString = {"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN"};
			Star[] arrayStar = {Star.ONE,Star.TWO,Star.THREE,Star.FOUR,Star.FIVE,Star.SIX,Star.SEVEN};
			for(int i=0;i<arrayString.length;i++){
				if(sStar.equals(arrayString[i])){
					star = arrayStar[i];
				}
			}
			
			controller.updateBassicinfo(new HotelinfoVO(address,area,intro,facility,tel,star,hotelID));
		}
		
	}
	
	private class CancleButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jtaAddress.setEditable(false);
			jtaArea.setEditable(false);
			jtaIntro.setEditable(false);
			jtaFacility.setEditable(false);
			jtaTEL.setEditable(false);
			jtaStar.setEditable(false);
			
			jbModify.setVisible(true);
			jbCancle.setVisible(false);
			jbConfirm.setVisible(false);
			
			jtaAddress.setText(address);
			jtaArea.setText(area);
			jtaIntro.setText(intro);
			jtaFacility.setText(facility);
			jtaTEL.setText(tel);
			jtaStar.setText(String.valueOf(star));
		}
		
	}
}
