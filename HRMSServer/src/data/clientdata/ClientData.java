package data.clientdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Enum.ResultMessage;
import dataservice.clientdataservice.ClientDataService;
import po.ClientPO;
import po.LevelPO;

public class ClientData extends UnicastRemoteObject implements ClientDataService{

	public ClientData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public File findCreditRecord(String clientID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setCredit(String clientID, int recharge) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClientPO findPersonalInfo(String clientID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyPersonalInfo(String clientID, ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkAccount(String client_id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAllLevel(LevelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createClient(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
