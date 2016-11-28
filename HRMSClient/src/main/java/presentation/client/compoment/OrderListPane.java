package presentation.client.compoment;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class OrderListPane extends JScrollPane{
	static JPanel roominfoPanel=new JPanel();
	public OrderListPane(){
		super(roominfoPanel);
		roominfoPanel.setLayout(null);
	    roominfoPanel.setPreferredSize(new Dimension(600,600));
	    roominfoPanel.setBounds(0,0,1000,4000);
	    roominfoPanel.setOpaque(false);


	   this.setBounds(370, 170, 920, 400);
	   this.setOpaque(false);
	   this.getViewport().setOpaque(false);
	   this.getVerticalScrollBar().setVisible(false);
	   this.setBorder(new EmptyBorder(0,0,0,0));
	   this.setVisible(false);
	    for(int i=0;i<6;i++){
	    	OrderItemPanel p=new OrderItemPanel(0, i*100);
	    	 //p.setBounds(0,i*100,600,100);
	    	 roominfoPanel.add(p);
	    }
	    this.getVerticalScrollBar().setVisible(false);
	}
}
