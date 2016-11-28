package presentation.marketing.compoment;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class showLevel extends MJPanel{
private static final long serialVersionUID = 1L;
private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,20);
private Image background=new ImageIcon("./src/main/resource/picture/marketing/showBackground.png").getImage();
private Icon inputIcon=new ImageIcon("./src/main/resource/picture/marketing/levelIcon.png");

public showLevel(String name,int level,int credit,int x, int y, int w, int h) {
	super(x, y, w, h);
    JLabel Name=new MJLabel("等级名称 ",25,10,400,30,font);
    JLabel Level=new MJLabel("等级层次 ",25,55,130,30,font);
    JLabel Credit=new MJLabel("所需信用值 ",25,100,130,30,font);
    JLabel nameLabel=new MJLabel(175,10,200,50,inputIcon);
    JLabel levelLabel=new MJLabel(175,50,200,50,inputIcon);
    JLabel creditLabel=new MJLabel(175,90,200,50,inputIcon);
    JTextField levelField=new MJTextField(""+level,17,8,160,30,font);
    JTextField nameField=new MJTextField(""+name,17,8,160,30,font);
    JTextField creditField=new MJTextField(""+credit,17,8,160,30,font);
    nameLabel.add(nameField);
    levelLabel.add(levelField);
    creditLabel.add(creditField);

    this.add(Name);
    this.add(Level);
    this.add(Credit);
    this.add(nameLabel);
    this.add(levelLabel);
    this.add(creditLabel);
    this.revalidate();
    this.repaint();
}

protected  void paintComponent(Graphics g) {
	g.drawImage(background,0,0,getSize().width,getSize().height,this);
}
}
