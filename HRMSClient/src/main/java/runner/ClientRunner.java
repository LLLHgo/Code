package runner;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.SitemanagerPO;
import presentation.MainFrame;
import rmi.RemoteHelper;

public class ClientRunner {
	private RemoteHelper remoteHelper;
	
	public ClientRunner() {
		
		try {
			linkToServer();
		} catch (MalformedURLException e) {
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		initGUI();
	}
	
	private void linkToServer() throws MalformedURLException, NotBoundException {
		remoteHelper = RemoteHelper.getInstance();
		//remoteHelper.init();
		System.out.println("linked");
	}
	private void initGUI() {
		@SuppressWarnings("unused")
		MainFrame mainFrame = new MainFrame();
	}
	
	public void test(){
		SitemanagerPO po=new SitemanagerPO("S00000001","025-88888882","HRMS");
		try {
			System.out.println(remoteHelper.getSitemanagerDataService().SitemanagerAccountUpdate(po));
			//System.out.println(remoteHelper.getIOService().writeFile("2", "admin", "testFile"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ClientRunner clientRunner = new ClientRunner();
		clientRunner.test();
	}
}
