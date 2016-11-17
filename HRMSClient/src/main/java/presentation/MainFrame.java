package presentation;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.login.view.ProcessLoginView;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	Container ct;
	public static JPanel jCards=new JPanel();
	public static CardLayout cl=new CardLayout();

	public MainFrame(){
	ProcessLoginView loginPanel=new ProcessLoginView();
	jCards.setLayout(cl);
	jCards.add(loginPanel, "LoginPanel");
	jCards.setBounds(0, 0, 1000, 618);
	jCards.setVisible(true);
	ct = this.getContentPane();
	ct.add(jCards);
	cl.show(jCards, "LoginPanel");

	this.setTitle("HRMS");
	this.setSize(1000, 638);
	this.setLocationRelativeTo(null);
	this.setLayout(null);
	this.setVisible(true);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
public static void main(String args[]){
	MainFrame m=new MainFrame();
}
}
