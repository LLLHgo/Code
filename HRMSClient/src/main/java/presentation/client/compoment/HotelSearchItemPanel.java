package presentation.client.compoment;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.DialogCreator;

public class HotelSearchItemPanel extends JPanel{
	private ImageIcon imageIcon = null;

	viewButton vb;
	private PersonalPanel ppp;
public HotelSearchItemPanel(int x,int y,JFrame frame){
	imageIcon = new ImageIcon("image/hotelSearchPanel.png");
	 ppp=new PersonalPanel();
	vb=new viewButton(500, 30);

    this.setLayout(null);
	this.setBounds(x,y,600,100);
	this.add(vb);
	this.setOpaque(false);
	this.setVisible(true);
}

@Override
public void paintComponent(Graphics g) {
	    g.drawImage(imageIcon.getImage(), 0, 0, this);
	    super.paintComponents(g);
	   }
}


