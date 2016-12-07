package runner;

import java.rmi.RemoteException;
import java.util.ArrayList;

import impl.mysql.SitemanagerDataServiceMySqlImpl;
import impl.txt.LogDataServiceTxtImpl;
import po.LogPO;
import po.SitemanagerPO;

public class test {
	// SitemanagerDataServiceMySqlImpl  getAccount
		void test1(){
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
		// SitemanagerDataServiceMySqlImpl SitemanagerAccountUpdate
		void test2(){
			SitemanagerDataServiceMySqlImpl si;
			boolean result=false;
			SitemanagerPO sitemanagerPO = new SitemanagerPO("S00000001","025-88888825","HRMSSitemanager");
			try {
				si = new SitemanagerDataServiceMySqlImpl();
				result=si.SitemanagerAccountUpdate(sitemanagerPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			System.out.println(result);
		}
		// LogDataServiceTxtImpl getLogList
		void test3(){
			LogDataServiceTxtImpl li;
			ArrayList<LogPO> list=new ArrayList<LogPO>();
			try {
				li=new LogDataServiceTxtImpl();
				list=li.getLogList();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			System.out.println(list.get(0).getLogInfo());
		}
		// LogDataServiceTxtImpl addLog
		void test4(){
			LogDataServiceTxtImpl li;
			LogPO logPO=new LogPO("M00000010 Mon Dec 07 23:23:32 CDT 2016 修改C00000015信用值");
			boolean result=false;
			try {
				li=new LogDataServiceTxtImpl();
				result=li.addLog(logPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}	
			System.out.println(result);
		}
		

}
