package presentation.sitemanager.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import presentation.sitemanager.component.CheckButton;

public class CreditFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	Container containter;
	JTextArea creditArea;
	JScrollPane jscrollPane;
	CheckButton checkButton;
	
	public CreditFrame(ArrayList<String> credits){
		this.setBounds(200, 200, 300, 500);
		containter=this.getContentPane();
		
		creditArea=new JTextArea(10,1);
		creditArea.setFont(new java.awt.Font("华文黑体",  1,  20));
		creditArea.setForeground(Color.black);
		creditArea.setWrapStyleWord(true);
		creditArea.setLineWrap(true);
		creditArea.setOpaque(false);
		
		jscrollPane = new JScrollPane(creditArea);
		jscrollPane.setBounds(10,10,280,400);
		jscrollPane.setOpaque(false); 
		
		checkButton=new CheckButton(200,420,65,65);
		checkButton.addMouseListener(new CheckListener());
		
		this.add(checkButton);
		this.add(jscrollPane);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	class CheckListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			dispose();
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		
	}
}
