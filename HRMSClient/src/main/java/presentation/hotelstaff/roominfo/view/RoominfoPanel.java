package presentation.hotelstaff.roominfo.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.plaf.synth.SynthSpinnerUI;

import Enum.Star;
import presentation.common.ModifyButton;
import presentation.common.MyLabel;
import presentation.hotelstaff.component.AddButton;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.DetailedRoominfo;
import presentation.hotelstaff.component.LeftButton;
import presentation.hotelstaff.component.RightButton;
import presentation.hotelstaff.component.RoominfoLabel;
import presentation.hotelstaff.hotelinfo.controller.HotelinfoViewController;
import vo.hotelinfoVO.HotelinfoVO;

public class RoominfoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private HotelinfoViewController controller;
	private String hotelID;
	private ImageIcon init_image;
	private ModifyButton jbModify1;
	private ModifyButton jbModify2;
	private ModifyButton jbModify3;
	private ConfirmButton jbConfirm;
	private CancleButton jbCancle;
	private LeftButton jbLeft;
	private RightButton jbRight;
	private AddButton jbAdd;
	private RoominfoLabel label1_roomNO;
	private RoominfoLabel label1_type;
	private RoominfoLabel label1_price;
	private RoominfoLabel label1_state;
	private RoominfoLabel label2_roomNO;
	private RoominfoLabel label2_type;
	private RoominfoLabel label2_price;
	private RoominfoLabel label2_state;
	private RoominfoLabel label3_roomNO;
	private RoominfoLabel label3_type;
	private RoominfoLabel label3_price;
	private RoominfoLabel label3_state;
	private RoominfoLabel  arrayRoomNO[]=new RoominfoLabel[3];
	private RoominfoLabel arrayType[]=new RoominfoLabel[3];
	private RoominfoLabel arrayPrice[]=new RoominfoLabel[3];
	private RoominfoLabel arrayState[]=new RoominfoLabel[3];
	private DetailedRoominfo detail;
	private int page=1;
	private int maxPage;

	public RoominfoPanel(HotelinfoViewController controller,String hotelID){
		this.controller = controller;
		this.hotelID = hotelID;
		initHotelinfoPanel();
	}
	
	private void initHotelinfoPanel(){
		this.setLayout(null);
		this.setBounds(0,0,1000,618);
		this.setVisible(true);
		setOpaque(false);
		
		init_image = new ImageIcon("./src/main/resource/picture/hotelinfo/roominfo.png");
	
		jbLeft = new LeftButton(295,480);
		jbRight = new RightButton(888,480);
		jbLeft.addActionListener(new LeftButtonActionListener());
		jbRight.addActionListener(new RightButtonActionListener());
		jbLeft.setEnabled(false);
		
		this.add(jbLeft);
		this.add(jbRight);
		
		jbModify1 = new ModifyButton(880,150,60,60);
		jbModify1.addActionListener(new ModifyButtonActionListener());
		this.add(jbModify1);
		
		jbModify2 = new ModifyButton(880,270,60,60);
		jbModify2.addActionListener(new ModifyButtonActionListener());
		this.add(jbModify2);
		
		jbModify3 = new ModifyButton(880,390,60,60);
		jbModify3.addActionListener(new ModifyButtonActionListener());
		this.add(jbModify3);
		
//		jbConfirm = new ConfirmButton(695,485);
//		jbConfirm.addActionListener(new ConfirmButtonActionListener());
//		jbConfirm.setVisible(false);
//		this.add(jbConfirm);
//		
//		jbCancle = new CancleButton(495,488);
//		jbCancle.addActionListener(new CancleButtonActionListener());
//		jbCancle.setVisible(false);
//		this.add(jbCancle);
		
		jbAdd = new AddButton(590,488);
		jbAdd.addActionListener(new AddButtonActionListener());
		jbAdd.setVisible(true);
		this.add(jbAdd);
		
		arrayRoomNO[0]=label1_roomNO = new RoominfoLabel(320,122,180,25,"房间号：");
		arrayType[0]=label1_type = new RoominfoLabel(540,122,180,25,"类型：");
		arrayPrice[0]=label1_price = new RoominfoLabel(540,160,180,25,"价格：");
		arrayState[0]=label1_state = new RoominfoLabel(540,198,180,25,"状态：");
		arrayRoomNO[1]=label2_roomNO = new RoominfoLabel(320,245,180,25,"房间号：");
		arrayType[1]=label2_type = new RoominfoLabel(540,245,180,25,"类型：");
		arrayPrice[1]=label2_price = new RoominfoLabel(540,283,180,25,"价格：");
		arrayState[1]=label2_state = new RoominfoLabel(540,321,180,25,"状态：");
		arrayRoomNO[2]=label3_roomNO = new RoominfoLabel(320,370,180,25,"房间号：");
		arrayType[2]=label3_type = new RoominfoLabel(540,370,180,25,"类型：");
		arrayPrice[2]=label3_price = new RoominfoLabel(540,408,180,25,"价格：");
		arrayState[2]=label3_state = new RoominfoLabel(540,446,180,25,"状态：");
		
		if(controller.getRoominfoList(hotelID)!=null){
			maxPage = (controller.getRoominfoList(hotelID).size()-1)/3+1;
		}
		if(page==maxPage){
			jbRight.setEnabled(false);
		}
		
		if(controller.getRoominfoList(hotelID)==null){
			
		}else if(controller.getRoominfoList(hotelID).size()<=3){
			for(int i=0;i<controller.getRoominfoList(hotelID).size();i++){
				arrayRoomNO[i].setText("房间号:"+controller.getRoominfoList(hotelID).get(i).getRoomNum());
				arrayType[i].setText("类型:"+controller.getRoominfoList(hotelID).get(i).getType());
				arrayPrice[i].setText("价格:"+controller.getRoominfoList(hotelID).get(i).getPrice());
				arrayState[i].setText("状态:"+controller.getRoominfoList(hotelID).get(i).getRoomState());
			}
		}else{
			for(int i=0;i<3;i++){
				arrayRoomNO[i].setText("房间号:"+controller.getRoominfoList(hotelID).get(i).getRoomNum());
				arrayType[i].setText("类型:"+controller.getRoominfoList(hotelID).get(i).getType());
				arrayPrice[i].setText("价格:"+controller.getRoominfoList(hotelID).get(i).getPrice());
				arrayState[i].setText("状态:"+controller.getRoominfoList(hotelID).get(i).getRoomState());
			}
		}
		this.add(label1_roomNO);
		this.add(label2_roomNO);
		this.add(label3_roomNO);
		this.add(label1_type);
		this.add(label2_type);
		this.add(label3_type);
		this.add(label1_price);
		this.add(label2_price);
		this.add(label3_price);
		this.add(label1_state);
		this.add(label2_state);
		this.add(label3_state);
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(init_image.getImage(), 290,120,650,360,this);
    }

	private class ModifyButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbModify1){
				jbModify1.setVisible(false);
				jbModify2.setEnabled(false);
				jbModify3.setEnabled(false);
			}else if(e.getSource()==jbModify2){
				jbModify2.setVisible(false);
				jbModify1.setEnabled(false);
				jbModify3.setEnabled(false);
			}else if(e.getSource()==jbModify3){
				jbModify3.setVisible(false);
				jbModify1.setEnabled(false);
				jbModify2.setEnabled(false);
			}
//			jbCancle.setVisible(true);
//			jbConfirm.setVisible(true);
			jbAdd.setVisible(false);
		}
		
	}
	
//	private class ConfirmButtonActionListener implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			
//			jbModify1.setVisible(true);
//			jbModify2.setVisible(true);
//			jbModify3.setVisible(true);
//			jbCancle.setVisible(false);
//			jbConfirm.setVisible(false);
//			jbAdd.setVisible(true);
//			
//		}
//	}
//	private class CancleButtonActionListener implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			jbModify1.setVisible(true);
//			jbModify2.setVisible(true);
//			jbModify3.setVisible(true);
//			jbCancle.setVisible(false);
//			jbConfirm.setVisible(false);
//			jbAdd.setVisible(true);
//		}
//	}
	private void setPanelUnEditable(){
		this.setVisible(false);
	}
	
	
	private class AddButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new DetailedRoominfo("","","","");
			setPanelUnEditable();
		}
	}
	
	private class LeftButtonActionListener  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			page--;
			if(page==maxPage){
				jbRight.setEnabled(false);
			}
			if(page>1){
				jbLeft.setEnabled(true);
			}
			if(page==1){
				jbLeft.setEnabled(false);
			}
			if(page<maxPage){
				jbRight.setEnabled(true);
			}
			for(int i=0;i<3;i++){
				arrayRoomNO[i].setText("房间号:");
				arrayType[i].setText("类型:");
				arrayPrice[i].setText("价格:");
				arrayState[i].setText("状态:");
			}
			int index=0;
			for(int i=(page-1)*3;i<page*3&&i<controller.getRoominfoList(hotelID).size()-1;i++){
				arrayRoomNO[index].setText("房间号:"+controller.getRoominfoList(hotelID).get(i).getRoomNum());
				arrayType[index].setText("类型:"+controller.getRoominfoList(hotelID).get(i).getType());
				arrayPrice[index].setText("价格:"+controller.getRoominfoList(hotelID).get(i).getPrice());
				arrayState[index].setText("状态:"+controller.getRoominfoList(hotelID).get(i).getRoomState());
				index++;
			}
		}
		
	}
	
	private class RightButtonActionListener  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			page++;
			if(page==1){
				jbLeft.setEnabled(false);
			}
			if(page<maxPage){
				jbRight.setEnabled(true);
			}
			if(page==maxPage){
				jbRight.setEnabled(false);
			}
			if(page>1){
				jbLeft.setEnabled(true);
			}
			for(int i=0;i<3;i++){
				arrayRoomNO[i].setText("房间号:");
				arrayType[i].setText("类型:");
				arrayPrice[i].setText("价格:");
				arrayState[i].setText("状态:");
			}
			int index=0;
			for(int i=(page-1)*3;i<page*3&&i<controller.getRoominfoList(hotelID).size()-1;i++){
				arrayRoomNO[index].setText("房间号:"+controller.getRoominfoList(hotelID).get(i).getRoomNum());
				arrayType[index].setText("类型:"+controller.getRoominfoList(hotelID).get(i).getType());
				arrayPrice[index].setText("价格:"+controller.getRoominfoList(hotelID).get(i).getPrice());
				arrayState[index].setText("状态:"+controller.getRoominfoList(hotelID).get(i).getRoomState());
				index++;
			}
		}
		
	}
}