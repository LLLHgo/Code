package presentation.hotelinfo.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import presentation.hotelstaff.view.ReviewButton;

public class HotelinfoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private ImageIcon init_image;
	private ReviewButton jbAddress;
	private ReviewButton jbArea;
	private ReviewButton jbIntro;
	private ReviewButton jbFacility;
	private ReviewButton jbTEL;
	private ReviewButton jbStar;
	
	public HotelinfoPanel(){
		initHotelinfoPanel();
	}
	
	private void initHotelinfoPanel(){
		this.setLayout(null);
		this.setBounds(277, 132, 666, 448);
		this.setVisible(true);
		setOpaque(false);
		
		init_image = new ImageIcon("./src/main/resource/picture/hotelinfo/hotelinfoPanel.png");
	
		jbAddress = new ReviewButton(625,8,40,35);
		jbArea = new ReviewButton(625,66,40,35);
		jbIntro = new ReviewButton(625,128,40,35);
		jbFacility = new ReviewButton(625,227,40,35);
		jbTEL = new ReviewButton(625,302,40,35);
		jbStar = new ReviewButton(625,358,40,35);
		
		this.add(jbAddress);
		this.add(jbArea);
		this.add(jbIntro);
		this.add(jbFacility);
		this.add(jbTEL);
		this.add(jbStar);
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(init_image.getImage(), 0,0,getSize().width,getSize().height,this);
    }

}
