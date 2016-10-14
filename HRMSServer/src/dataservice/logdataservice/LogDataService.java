package dataservice.logdataservice;

import po.LogPO;

public interface LogDataService {
	
	// 从数据库中得到所有日志
	public LogPO getLogList();
	// 在数据库中增加一条日志记录
	public boolean addLog (LogPO logPo);
}
