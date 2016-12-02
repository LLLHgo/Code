package presentation.client.compoment;

import javax.swing.JFrame;

public class OrderDetailFrame extends JFrame{
	public OrderDetailFrame(){

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		OrderDetailPanel hdp=new OrderDetailPanel();
		this.add(hdp);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(591, 433);
		this.setLocation(500,200);
	}
}
