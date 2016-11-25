package presentation.marketing.compoment;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JButton;

public class MJButton extends JButton{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MJButton(int x,int y,int w,int h,Icon icon){
		this.setBounds(x,y,w,h);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setIcon(icon);
    }

	public MJButton(String text,int x,int y,int w,int h,Font font){
		this.setText(text);
		this.setBounds(x,y,w,h);
		this.setFont(font);
		this.setForeground(Color.white);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);

    }
}
