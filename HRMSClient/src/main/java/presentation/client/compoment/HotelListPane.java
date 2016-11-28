package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class HotelListPane extends JScrollPane{
	static JPanel roominfoPanel=new JPanel();
public HotelListPane(){
	super(roominfoPanel);
	roominfoPanel.setLayout(null);
    roominfoPanel.setPreferredSize(new Dimension(600,600));
    roominfoPanel.setBounds(0,0,1000,4000);
    roominfoPanel.setOpaque(false);


   this.setBounds(320, 170, 920, 400);
   this.setOpaque(false);
   this.getViewport().setOpaque(false);
   this.getVerticalScrollBar().setVisible(false);
   this.setBorder(new EmptyBorder(0,0,0,0));
   this.setVisible(false);
    for(int i=0;i<6;i++){
    	HotelEvaluateItemPanel p=new HotelEvaluateItemPanel(0, i*100);
    	 //p.setBounds(0,i*100,600,100);
    	 roominfoPanel.add(p);
    }
    this.getVerticalScrollBar().setVisible(false);
}
}
