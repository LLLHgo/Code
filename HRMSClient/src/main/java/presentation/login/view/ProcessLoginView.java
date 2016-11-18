package presentation.login.view;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.DialogCreator;
import presentation.client.view.ClientPanel;
import presentation.client.view.ProcessClientView;


public class ProcessLoginView extends JFrame{

	private static final long serialVersionUID = 1L;
	Container ct;
	public static JPanel jCards=new JPanel();
	public static CardLayout cl=new CardLayout();
	private LoginPanel loginPanel;



	public ProcessLoginView(){
	loginPanel=new LoginPanel();
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
	ProcessLoginView m=new ProcessLoginView();
}

}
