package data.logdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataservice.logdataservice.LogDataService;
import po.LogPO;

public class LogData extends UnicastRemoteObject implements LogDataService{

	public LogData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<LogPO> getLogList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addLog(LogPO logPo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
