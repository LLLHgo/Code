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

public class ProcessClientView extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private GuideBoardButton searchHotel;
	private GuideBoardButton viewOrder;
	private GuideBoardButton personal;
	private GuideBoardButton evaluate;
	private GuideBoardButton register;
	private GuideBoardButton exit;
	 private ImageIcon imageIcon = null;
	public ProcessClientView(){

			imageIcon = new ImageIcon("image/clientWel.png");
			searchHotel=new GuideBoardButton(240,"查询酒店");
			viewOrder=new GuideBoardButton(290,"浏览订单");
			personal=new GuideBoardButton(340,"个人订单");
			evaluate=new GuideBoardButton(390,"评价酒店");
			register=new GuideBoardButton(440,"注册会员");
			exit=new GuideBoardButton(490,"退出");
			this.add(searchHotel);
			this.add(viewOrder);
			this.add(personal);
			this.add(evaluate);
			this.add(register);
			this.add(exit);
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
