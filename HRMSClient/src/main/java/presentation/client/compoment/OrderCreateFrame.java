package presentation.client.compoment;

import javax.swing.JFrame;

public class OrderCreateFrame extends JFrame{
	public OrderCreateFrame(){

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		OrderCreatePanel hdp=new OrderCreatePanel();
		this.add(hdp);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(591, 433);
		this.setLocation(400,200);
	}
}
