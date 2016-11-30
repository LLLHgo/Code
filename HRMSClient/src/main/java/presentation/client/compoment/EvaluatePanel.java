package presentation.client.compoment;

import java.awt.Color;

import java.awt.Graphics;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class EvaluatePanel extends JPanel{
	private ImageIcon imageIcon = null;
	private SearchButton searchButton;
	private JTextField searchField;
	private HotelListPane hlp;
	public EvaluatePanel(JFrame frame){
		hlp=new HotelListPane(frame);
		frame.add(hlp);
	imageIcon = new ImageIcon("image/searchPanel.png");
	searchField=new JTextField();
	searchButton=new SearchButton();
	searchField.setBounds(72, 18, 450, 50);
	searchField.setBorder(new EmptyBorder(0,0,0,0));
	searchField.setFont(new java.awt.Font("微软雅黑", 4,  25));
	searchField.setForeground(Color.WHITE);
	searchField.setOpaque(false);
	searchField.setFocusable(true);



	this.add(searchButton);
	this.add(searchField);
	this.setVisible(false);
    this.setLayout(null);
    this.setSize(704, 502);
    this.setOpaque(false);
	}

	public void setvisible(boolean flag){
		this.setVisible(flag);
		hlp.setVisible(flag);

	}
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
