package presentation.hotelstaff.component;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SearchButton extends JButton{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int w=50;
	private int h=50;
	private ImageIcon icon;
	
	public SearchButton(int x,int y){
		super();
		this.x = x;
		this.y = y;
		this.setBounds(this.x,this.y,this.w,this.h);
		this.icon = new ImageIcon(this.getClass().getResource("images/searchButton.png"));
		this.setIcon(this.icon);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);		
	}
}
