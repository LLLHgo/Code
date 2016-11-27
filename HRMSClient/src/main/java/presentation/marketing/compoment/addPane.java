package presentation.marketing.compoment;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class addPane extends MJScrollPane{
	private static final long serialVersionUID = 1L;
	private Font font=new Font("楷体",Font.HANGING_BASELINE,18);


	private Icon addIcon=new ImageIcon("./src/main/resource/picture/marketing/addIcon.png");
	private JButton addButton=new MJButton(230,10,60,60,addIcon);
	private List<Integer> leve=new ArrayList<Integer>();
	private List<Double> dis=new ArrayList<Double>();
	private JPanel addPanel=new MJPanel(0,0,900,00);

	public addPane(int x, int y, int w, int h,JPanel panel) {
        super(x,y,w,h);
        addPanel.setPreferredSize(new Dimension(200,900));
        this.add(addPanel);
        this.add(addButton);
        this.revalidate();
        this.repaint();
	}



}
