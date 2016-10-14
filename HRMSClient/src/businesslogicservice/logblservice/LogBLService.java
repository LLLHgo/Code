package businesslogicservice.logblservice;

import java.util.List;

import po.ResultMessage;
import vo.LogVO;

public interface LogBLService {
	// 界面得到日志列表
	public List<LogVO> getLog();
	//界面得到添加日志成功或失败信息
	public ResultMessage addLog (String logInfo);

}
