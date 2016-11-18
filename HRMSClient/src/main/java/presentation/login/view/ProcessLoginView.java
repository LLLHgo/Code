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
class LoginPanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField IdField;
	private JPasswordField KeyField;
	private JButton loginButton;
	private JButton signUpButton;
	 private ImageIcon imageIcon = null;
	 public boolean flag=true;
	public LoginPanel(){
			ImageIcon lib=new ImageIcon("image/loginButton.png");
			ImageIcon sub=new ImageIcon("image/signUpButton.png");
			imageIcon = new ImageIcon("image/login.png");
			this.setOpaque(true);
		    this.setLayout(null);
		    IdField = new JTextField();
			KeyField = new JPasswordField();
			Font fm=new Font("Comic Sans MS",Font.PLAIN,20);
			IdField.setFont(fm);
			KeyField.setFont(fm);
			IdField.setBorder(new EmptyBorder(0,0,0,0));
			IdField.setBounds(385, 220, 300, 48);
			IdField.setOpaque(false);
			IdField.setFocusable(true);
			KeyField.setBounds(388, 315, 297, 48);
			KeyField.setBorder(new EmptyBorder(0,0,0,0));
			KeyField.setOpaque(false);
			KeyField.setFocusable(true);

			this.add(IdField);
			this.add(KeyField);
			loginButton=new JButton();
			loginButton.setBounds(353,417,120,32);
			loginButton.setIcon(lib);
			loginButton.setOpaque(false);
			loginButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(IdField.getText().equals("C")){
						ProcessClientView client=new ProcessClientView();
						client.setVisible(true);
						flag=false;
					}
				}
				});

			signUpButton=new JButton();
			signUpButton.setBounds(548,417,120,32);
			signUpButton.setIcon(sub);
			signUpButton.setOpaque(false);
			signUpButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					DialogCreator.successDialog("Success");
				}
				});
			this.add(loginButton);
			this.add(signUpButton);
		    this.setSize(1000, 618);

		    this.setVisible(true);
	}
	@Override
	 public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
}
