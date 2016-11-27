package presentation.sitemanager.view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import presentation.sitemanager.component.MyLabel;
import presentation.sitemanager.component.RefreshButton;
import vo.logVO.LogVO;

public class ProcessShowLogView extends JPanel{

	private static final long serialVersionUID = 1L;
	ProcessSitemanagerViewControllerService  controller;
	ProcessSitemanagerView view;
	
	// 背景图片
	ImageIcon background;
	// 日志题头
	MyLabel logUpLabel;
	// 中间的jtextarea部分
	ArrayList<LogVO> list;
	JTextArea area;
	// 下面的刷新按钮
	RefreshButton refreshButton;
	
	public ProcessShowLogView(ProcessSitemanagerViewControllerService controller,
			ProcessSitemanagerView processSitemanagerView){
		this.controller=controller;
		this.view=processSitemanagerView;
		background=new ImageIcon("src/main/resource/picture/sitemanager/showLog.png");
		refreshButton=new RefreshButton(400,500);
		//showLog();
		
		this.add(refreshButton);
		this.setBounds(277,79,702,502);
		view.add(this);
	}
	public void showLog(){
		list=controller.findLog();
		Iterator<LogVO> it=list.iterator();
		while(it.hasNext()){
			
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		background.setImage(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		background.paintIcon(this, g, 0, 0);
	}
}
