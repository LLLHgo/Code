package ControllerTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Enum.ResultMessage;
import Mock.MockLogManage;



public class ProcessOrderViewControllerTest {
	
	MockLogManage logManageMock=new MockLogManage();
	@Test
	public void addLogTest(String logInfo) {
		assertEquals(ResultMessage.SUCCESS,logManageMock.addLog(logInfo));
	}

}
