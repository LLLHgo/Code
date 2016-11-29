package businesslogicservice.logblservice;

import java.util.ArrayList;

import Enum.ResultMessage;
import businesslogicservice.logblservice.LogBLService;
import vo.logVO.LogVO;

public class LogBLService_Stub implements LogBLService {
	String logInfo;
	
	public LogBLService_Stub(String logInfo){
		this.logInfo=logInfo;
	}
	public LogBLService_Stub(){
		
	}
	/**
	 * 界面得到日志列表
	 * @return 日志列表
	 */
	@Override
	public ArrayList<LogVO> getLog(String year,String month,String day) {
		// TODO Auto-generated method stub
		ArrayList<LogVO> logList1=new ArrayList<LogVO>();
		ArrayList<LogVO> logList2=new ArrayList<LogVO>();
		if(day.equals("28")){
			logList1.add(new LogVO("C00000001 2016-11-28  00:25:25 登录"));
			logList1.add(new LogVO("C00000002 2016-11-28  00:25:29 登录"));
			return logList1;
		}
		if(day.equals("29")){
			logList2.add(new LogVO("C00000003 2016-11-29  00:25:29 登录"));
			return logList2;
		}
		
		return logList1;
	}
	/**
	 * 界面得到添加日志成功或失败信息
	 * @param logInfo
	 * @return 添加日志成功或失败的enum值
	 */
	@Override
	public ResultMessage addLog(String logInfo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
