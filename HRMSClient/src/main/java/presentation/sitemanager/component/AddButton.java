package presentation.sitemanager.component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * 添加按钮
 * @author yilu
 *
 */
public class AddButton extends JButton{
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	int w;
	int h;
	ImageIcon img;
	public AddButton(int x,int y,int w,int h){
		super();
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		setOthers();
	}
	void setOthers(){
		img=new ImageIcon(this.getClass().getResource("image/addIcon.png"));
		this.setIcon(img);
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);
	}
}
