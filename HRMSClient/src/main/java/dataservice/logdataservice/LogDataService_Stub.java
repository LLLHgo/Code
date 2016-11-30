package dataservice.logdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogPO;

public class LogDataService_Stub implements LogDataService {
	LogPO logPO;
	ArrayList<LogPO> logPOList;
	
	public LogDataService_Stub(LogPO logPO,ArrayList<LogPO> logPOList)throws RemoteException{
		this.logPO=logPO;
		this.logPOList=logPOList;
	}
	
	/**
	 * 从数据库中得到所有日志
	 * @return 日志PO
	 */
	public ArrayList<LogPO> getLogList()throws RemoteException{
		return logPOList;
	}
	public boolean addLog (LogPO logPo){
		return true;
	}
}
