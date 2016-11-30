package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HotelDetailPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private JFrame frame;
	private exitButton exit;
	private JPanel panel;
	//public HotelDetailPanel(JFrame frame,HotelSearchListPane hsp){
	public HotelDetailPanel(){

	exit=new exitButton();
	imageIcon = new ImageIcon("image/HotelDetailPanel.png");


	this.add(exit);
	this.setVisible(true);
    this.setLayout(null);
    this.setBounds(50,80,591,413);
    this.setOpaque(false);
    this.setVisible(true);
    //frame.add(this);
    //panel=this;
	}
	class exitButton extends JButton{
		ImageIcon icon;
		public exitButton(){
		icon=new ImageIcon("image/exitButton.png");
		this.setIcon(icon);
		this.setOpaque(true);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setBounds(520,5,60,60);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
