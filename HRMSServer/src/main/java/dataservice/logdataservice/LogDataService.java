package dataservice.logdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogPO;
/**
 * 日志的数据层接口
 * @author yilu
 *
 */
public interface LogDataService extends Remote{
	
	/**
	 * 从数据库中得到所有日志
	 * @return 日志PO
	 */
	public ArrayList<LogPO> getLogList() throws RemoteException;
	/**
	 * 在数据库中增加一条日志记录
	 * @param logPo
	 * @return 添加成功（true）或失败（false）
	 */
	public boolean addLog (LogPO logPo) throws RemoteException;
}
