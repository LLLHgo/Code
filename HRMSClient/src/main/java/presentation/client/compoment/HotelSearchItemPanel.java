package presentation.client.compoment;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HotelSearchItemPanel extends JPanel{
	private ImageIcon imageIcon = null;

	private viewButton vb;

public HotelSearchItemPanel(int x,int y){
	imageIcon = new ImageIcon("image/hotelSearchPanel.png");

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


