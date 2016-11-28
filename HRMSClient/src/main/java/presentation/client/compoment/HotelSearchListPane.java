package presentation.client.compoment;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class HotelSearchListPane extends JScrollPane{
	static JPanel Panel=new JPanel();
	public HotelSearchListPane(){
		super(Panel);
		Panel.setLayout(null);
	    Panel.setPreferredSize(new Dimension(600,600));
	    Panel.setBounds(0,0,1000,4000);
	    Panel.setOpaque(false);


	   this.setBounds(320, 170, 920, 400);
	   this.setOpaque(false);
	   this.getViewport().setOpaque(false);
	   this.getVerticalScrollBar().setVisible(false);
	   this.setBorder(new EmptyBorder(0,0,0,0));
	   this.setVisible(false);
	    for(int i=0;i<6;i++){
	    	HotelSearchItemPanel p=new HotelSearchItemPanel(0, i*100);
	    	 //p.setBounds(0,i*100,600,100);
	    	 Panel.add(p);
	    }
	    this.getVerticalScrollBar().setVisible(false);
	}
}
