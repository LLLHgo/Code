package presentation.login.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.text.Caret;

import presentation.DialogCreator;
import presentation.client.view.ProcessClientView;
import presentation.client.view.ProcessClientView;
import presentation.hotelinfo.view.HotelinfoPanel;
import presentation.hotelstaff.controller.HotelstaffViewController;
import presentation.hotelstaff.view.HotelstaffView;

public class ProcessLoginView extends JPanel {
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
	public ProcessLoginView(JFrame frame){
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
						frame.getContentPane().removeAll();
						frame.getContentPane().add(new HotelstaffView(frame,IdField.getText()
								));
						frame.getContentPane().add(new ProcessClientView());
						frame.getContentPane().revalidate();
						frame.getContentPane().repaint();
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
