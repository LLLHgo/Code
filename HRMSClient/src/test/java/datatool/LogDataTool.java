package datatool;

import java.util.ArrayList;

import po.LogPO;

public class LogDataTool {
     //List<LogPO> getLogList():logList

	static LogPO logPO1=new LogPO("2016-08-10 09:21:22 H00000010 修改密码");
	static LogPO logPO2=new LogPO("2016-08-10 09:20:11 C00000002 下订单20160810092001");
	
	static ArrayList<LogPO> logList=new ArrayList<LogPO>();
	static{
		logList.add(logPO1);
		logList.add(logPO2);
	}		
	
}
