package datatool;

import java.util.ArrayList;
import java.util.List;

import po.LogPO;

public class LogDataTool {
     //List<LogPO> getLogList():logList
	 //
	
	static String log1="2016-08-10 09:20:11 C00000002 下订单20160810092001";
	static String log2="2016-08-10 09:21:22 H00000010 修改密码";
	
	static ArrayList<String> logList=new ArrayList<String>();
	static{
		logList.add(log1);
		logList.add(log2);
	}
	
			
	
}
