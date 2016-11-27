package presentation.marketing.compoment;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MakePanel extends MJPanel{
	private static final long serialVersionUID = 1L;
	private Font font=new Font("楷体",Font.ITALIC,20);
	private Font font2=new Font("楷体",Font.ITALIC,18);
	private Icon valueIcon=new ImageIcon("./src/main/resource/picture/marketing/yearBackground.png");
	private JLabel levelLabel=new MJLabel("等级",10,0,100,40,font);
	private JLabel levelInputLabel=new MJLabel(55,4,100,43,valueIcon);
	private JTextField levelField=new MJTextField(13,2,46,30,font2);
	private JLabel discountLabel=new MJLabel("折扣",150,0,60,40,font);
	private JLabel discountInputLabel=new MJLabel(200,4,60,43,valueIcon);
	private JTextField discountField=new MJTextField(13,2,46,30,font2);

	public MakePanel(int x, int y, int w, int h) {
		super(x, y, w, h);
		levelInputLabel.add(levelField);
		discountInputLabel.add(discountField);
		this.add(levelLabel);
		this.add(levelInputLabel);
		this.add(discountLabel);
		this.add(discountInputLabel);

		this.revalidate();
		this.repaint();

	}

	public  void setInput(double dis){
		levelField.setText(""+dis);
	}

	public double[] getInput(){
		double dou[]=new double[2];
		dou[0]=Double.parseDouble(levelField.getText());
		dou[1]=Double.parseDouble(discountField.getText());
		return dou;
	}
}