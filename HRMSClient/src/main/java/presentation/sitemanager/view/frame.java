package presentation.sitemanager.view;

import javax.swing.JFrame;

import presentation.sitemanager.controller.ProcessSitemanagerViewController;


public class frame {

	public static void main(String[] args) {
		String sitemanagerId="S00000001";
		JFrame mFrame = new JFrame();
		mFrame.setSize(1000, 638);
		mFrame.setLocation(100, 100);
		ProcessSitemanagerViewControllerService controller = new ProcessSitemanagerViewController(sitemanagerId);
		ProcessSitemanagerView view = new ProcessSitemanagerView(controller);
		controller.setView(view);
		mFrame.setLayout(null);
		mFrame.getContentPane().add(view);
		mFrame.setVisible(true);
	}

}
