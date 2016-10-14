package dataservice.clientdataservice;

import java.io.File;
import java.rmi.RemoteException;

import Enum.ResultMessage;
import po.ClientPO;

public interface ClientDataService {
	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
	/**
	 * 查询信用记录
	 * @param clientID
	 * @return信用记录文件
	 */
	public File findCreditRecord(String clientID);
	/**
	 * 修改客户信用值
	 * @param clientID
	 * @param recharge
	 * @return 修改是否成功
	 */
	public boolean setCredit(String clientID,int recharge);
	/**
	 * 查询客户个人基本信息
	 * @param clientID
	 * @return 客户PO
	 */
	public ClientPO  findPersonalInfo (String clientID);
	/**
	 * 修改客户个人基本信息
	 * @param clientID
	 * @param po
	 * @return 修改是否成功
	 */
	public ResultMessage modifyPersonalInfo (String clientID,ClientPO po);
}
