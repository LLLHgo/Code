package businesslogic.logbl;

import java.util.ArrayList;

import Enum.ResultMessage;
import businesslogicservice.logblservice.LogBLService;
import vo.logVO.LogVO;

public class LogManage implements LogBLService{
	/**
	 * 界面得到添加日志成功或失败信息
	 * @param logInfo
	 * @return 添加日志成功或失败的enum值
	 */
	public ResultMessage addLog (String logInfo){
		return null;
	}
	/**
	 * 界面得到某天的日志列表
	 * @return 日志列表
	 */
	@Override
	public ArrayList<LogVO> getLog(String year, String month, String day) {
		
		return null;
	}

}
