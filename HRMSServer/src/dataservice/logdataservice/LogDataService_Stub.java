package dataservice.logdataservice;

import java.util.List;

import po.LogPO;

public class LogDataService_Stub implements LogDataService {
	LogPO logPO;
	List<LogPO> logPOList;
	
	public LogDataService_Stub(LogPO logPO,List<LogPO> logPOList){
		this.logPO=logPO;
		this.logPOList=logPOList;
	}
	
	/**
	 * 从数据库中得到所有日志
	 * @return 日志PO
	 */
	public List<LogPO> getLogList(){
		return logPOList;
	}
	public boolean addLog (LogPO logPo){
		return true;
	}
}
