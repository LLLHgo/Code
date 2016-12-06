package runner;



import java.rmi.RemoteException;

import impl.mysql.SitemanagerDataServiceMySqlImpl;
import initial.DataBaseInit;
import po.SitemanagerPO;
import rmi.RemoteHelper;

public class ServerRunner {
	
	public ServerRunner(){
		new RemoteHelper();
	}

	public static void main(String[] args) {
		ServerRunner s=new ServerRunner();
		DataBaseInit d=new DataBaseInit();
		s.test();

	}
	void test(){
		SitemanagerDataServiceMySqlImpl si;
		SitemanagerPO sitemanagerPO = null;
		try {
			si = new SitemanagerDataServiceMySqlImpl();
			sitemanagerPO=si.getAccount();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println(sitemanagerPO.getPassword());
		
	}

}
