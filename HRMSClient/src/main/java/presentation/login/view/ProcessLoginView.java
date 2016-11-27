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
import presentation.hotelstaff.controller.HotelstaffViewController;
import presentation.hotelstaff.view.HotelinfoPanel;
import presentation.hotelstaff.view.HotelstaffView;
import presentation.login.controller.ProcessLoginViewController;
import presentation.marketing.controller.ProcessMarketingViewController;
import presentation.marketing.view.ProcessMarketingView;
import presentation.marketing.view.ProcessMarketingViewControllerService;
import presentation.sitemanager.controller.ProcessSitemanagerViewController;
import presentation.sitemanager.view.ProcessSitemanagerView;
import presentation.sitemanager.view.ProcessSitemanagerViewControllerService;

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
	private ProcessLoginViewController controller;
	private ProcessSitemanagerViewControllerService ps;
	public ProcessLoginView(JFrame frame,ProcessLoginViewController controller){
		ProcessSitemanagerViewControllerService controller0 = new ProcessSitemanagerViewController("S00000001");
		ProcessSitemanagerView view = new ProcessSitemanagerView(controller0);
		controller0.setView(view);
			this.controller=controller;
			ImageIcon lib=new ImageIcon("image/loginButton.png");
			ImageIcon sub=new ImageIcon("image/signUpButton.png");
			imageIcon = new ImageIcon("image/login.png");
			this.setOpaque(true);
		    this.setLayout(null);
		    IdField = new JTextField();
			KeyField = new JPasswordField();
			IdField.setFont(new java.awt.Font("微软雅黑", 4,  25));
			KeyField.setFont(new java.awt.Font("微软雅黑", 4,  25));
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
			loginButton.setOpaque(true);
			loginButton.setContentAreaFilled(false);
			loginButton.setBorderPainted(false);
			loginButton.setFocusPainted(false);
			loginButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String id=IdField.getText();
					System.out.println(id);
					String key=new String(KeyField.getPassword());
					switch(controller.login(id,key)){
					case 'c':
						frame.getContentPane().removeAll();
						frame.getContentPane().add(new ProcessClientView(frame,id));
						frame.getContentPane().revalidate();
						frame.getContentPane().repaint();
						break;
					case 'h':
						frame.getContentPane().removeAll();
						HotelstaffViewController hotelstaff = HotelstaffViewController.getInstance(id);
						HotelstaffView view = new HotelstaffView(hotelstaff);
						hotelstaff.setView(view);
						frame.getContentPane().add(view);
						frame.getContentPane().revalidate();
						frame.getContentPane().repaint();
						break;
					case 's':
						frame.getContentPane().removeAll();
						frame.getContentPane().add(new ProcessSitemanagerView(controller0));
						//frame.getContentPane().add(new HotelinfoPanel(new HotelinfoViewController(), key));
						frame.getContentPane().revalidate();
						frame.getContentPane().repaint();

						break;
					case 'm':
						ProcessMarketingViewControllerService controller1=new ProcessMarketingViewController(id);
						frame.getContentPane().removeAll();
						frame.getContentPane().add(new ProcessMarketingView(controller1));
						//frame.getContentPane().add(new HotelinfoPanel(new HotelinfoViewController(), key));
						frame.getContentPane().revalidate();
						frame.getContentPane().repaint();

						break;
					case 'e':
						DialogCreator.failDialog("Fail");
						break;
					}
				}
				});

			signUpButton=new JButton();
			signUpButton.setBounds(548,417,120,32);
			signUpButton.setIcon(sub);
			signUpButton.setOpaque(true);
			signUpButton.setContentAreaFilled(false);
			signUpButton.setBorderPainted(false);
			signUpButton.setFocusPainted(false);
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
