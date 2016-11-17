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
import presentation.common.GuideBoardButton;

public class ClientPanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JButton searchHotel;
	private GuideBoardButton signUpButton;
	 private ImageIcon imageIcon = null;
	public ClientPanel(){

			imageIcon = new ImageIcon("image/clientWel.png");
			ImageIcon shb=new ImageIcon("image/searchHotel.png");
			searchHotel=new GuideBoardButton(240,"查询酒店");
			/*searchHotel.setBounds(70,230,140,40);
			searchHotel.setIcon(shb);
			searchHotel.setOpaque(false);
			searchHotel.setBorderPainted(false);*/

			this.add(searchHotel);
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
