package presentation.sitemanager.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.common.GuideBoardButton;
import presentation.sitemanager.controller.ProcessSitemanagerViewController;

public class ProcessSitemanagerView extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ProcessSitemanagerViewControllerService controller;
	private Image image;//background
	private Icon backgroundIcon;
	private GuideBoardButton jbClientManage;
	private GuideBoardButton jbHotelManage;
	private GuideBoardButton jbMarktingManage;
	private GuideBoardButton jbSitemanagerManage;
	private GuideBoardButton jbShowLog;
	private GuideBoardButton jbExit;
	
	public ProcessSitemanagerView(ProcessSitemanagerViewControllerService controller){
		//backgroundIcon=new ImageIcon("/pic/sitemanager/background-the Greate Wall.jpg");
		
		this.controller=controller;
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setSize(1000, 618);
		this.setVisible(true);
		setOpaque(false);
		
		jbClientManage=new GuideBoardButton(241,"用户账户管理");
		jbHotelManage=new GuideBoardButton(299,"酒店账户管理");
		jbMarktingManage=new GuideBoardButton(357,"网营账户管理");
		jbSitemanagerManage=new GuideBoardButton(414,"个人账户管理");
		jbShowLog=new GuideBoardButton(471,"查看日志");
		jbExit=new GuideBoardButton(528,"退出");
		
		jbClientManage.setVisible(true);
		this.add(jbClientManage);
		this.add(jbHotelManage);
		this.add(jbMarktingManage);
		this.add(jbSitemanagerManage);
		this.add(jbShowLog);
		this.add(jbExit);
		
		
		this.setVisible(true);
	}
	
	
	/*public ProcessSitemanagerView(){
		backgroundIcon=new ImageIcon("/pic/sitemanager/background-the Greate Wall.jpg");
		
	
	}
	public void paint(Graphics g){
	    super.paint(g);
	    image = ((ImageIcon) backgroundIcon).getImage();
	    g.drawImage(image,0,0,null);
	}
	*/
	
}
