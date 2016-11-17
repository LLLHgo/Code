package presentation.client.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.DialogCreator;

public class ProcessClientView extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JButton loginButton;
	private JButton signUpButton;
	 private ImageIcon imageIcon = null;
	public ProcessClientView(){
			imageIcon = new ImageIcon("image/client.png");
			this.setOpaque(true);
		    this.setLayout(null);

		    this.setSize(1000, 618);

		    this.setVisible(true);
	}
	@Override
	 public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
