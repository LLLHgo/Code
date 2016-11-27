package presentation.client.compoment;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class HotelListPanel extends JPanel{
	private JScrollPane scrollPane;
	public HotelListPanel(){

		JPanel roominfoPanel=new JPanel();
		roominfoPanel.setLayout(null);
	    roominfoPanel.setPreferredSize(new Dimension(600,1000));
	    roominfoPanel.setBounds(0,0,1000,4000);
	    for(int i=0;i<6;i++){
	    	HotelEvaluateItemPanel p=new HotelEvaluateItemPanel();
	    	 p.setBounds(0,i*100,600,100);
	    	 roominfoPanel.add(p);
	    }
	    roominfoPanel.setOpaque(false);

		scrollPane = new JScrollPane(roominfoPanel);
	    scrollPane.setBounds(0, 0, 587, 400);
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    scrollPane.getVerticalScrollBar().setVisible(true);
	    scrollPane.setBorder(new EmptyBorder(0,0,0,0));
	    scrollPane.setVisible(true);
	    this.add(scrollPane);
	    this.setBounds(0,0,600,400);
	    this.setOpaque(false);
	    this.setVisible(false);
	    this.revalidate();
	    this.repaint();
	}
}
