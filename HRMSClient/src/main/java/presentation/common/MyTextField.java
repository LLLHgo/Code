package presentation.common;

import java.awt.Color;

import javax.swing.JTextField;

public class MyTextField extends JTextField{
	
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	int w;
	int h;
	String info;
	public MyTextField (int x,int y,int w,int h,String info){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.info=info;
		
		setOthers();
	}
	void setOthers(){
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setFont(new java.awt.Font("微软雅黑",  1,  20));
		this.setForeground(Color.white);
		this.setText(info);
	}
}
