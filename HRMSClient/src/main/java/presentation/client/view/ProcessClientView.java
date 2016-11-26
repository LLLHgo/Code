package presentation.client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.DialogCreator;
import presentation.client.compoment.SearchPanel;
import presentation.client.compoment.ViewOrderPanel;
import presentation.client.compoment.WelPanel;
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
	private String id;
	private WelPanel wp;
	private SearchPanel sp;
	private ViewOrderPanel vp;
	private ImageIcon imageIcon = null;
	private JLabel idLabel;
	private JFrame frame;
	public ProcessClientView(JFrame frame,String id){
			this.frame=frame;
			this.id=id;
			idLabel =new JLabel(id);
			idLabel.setBounds(80,185, 180, 30);
			idLabel.setFont(new java.awt.Font("微软雅黑", 4,  25));
			idLabel.setForeground(Color.WHITE);
			wp=new WelPanel();
			sp=new SearchPanel();
			vp=new ViewOrderPanel();
			imageIcon = new ImageIcon("image/clientPanel.png");
			searchHotel=new GuideBoardButton(240,"查询酒店");
			searchHotel.addActionListener( new searchButtonListener());
			viewOrder=new GuideBoardButton(290,"浏览订单");
			viewOrder.addActionListener( new viewOrderButtonListener());
			personal=new GuideBoardButton(340,"个人信息");
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
		    this.add(idLabel);
		    wp.setLocation(277,82);
		    sp.setLocation(277,82);
		    vp.setLocation(277,82);
		    wp.setVisible(true);
		    frame.add(wp);
		    frame.add(sp);
		    frame.add(vp);
		    this.setSize(1000, 618);
		    this.setVisible(true);
	}
	private class searchButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			wp.setVisible(false);
			vp.setVisible(false);
			sp.setVisible(true);
		}

	}
	private class viewOrderButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			wp.setVisible(false);
			sp.setVisible(false);
			vp.setVisible(true);
		}

	}
	@Override
	 public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
