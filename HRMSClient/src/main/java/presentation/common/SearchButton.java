package presentation.common;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SearchButton extends JButton {
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	int w;
	int h;
	ImageIcon img;
	public SearchButton(int x,int y,int w,int h){
		super();
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		setOthers();
	}
	void setOthers(){
		img=new ImageIcon("src/main/resource/picture/sitemanager/search.png");
		this.setIcon(img);
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setOpaque(false);
		this.setVisible(true);
	}
}
