package bltest.clientbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.clientbl.ClientManage;
import vo.clientVO.ClientVO;

@Ignore("clientmanage已经调用真实dataservice，不需要桩")
public class UpdateInfoTest {
	ClientManage Manage = new ClientManage();

	@Test
	public void test1(){
		//账号不存在
		assertEquals(ResultMessage.FAIL,Manage.updateInfo(new ClientVO("C00000002","notfun")));
	}

	@Test
	public void test2(){
		//账号非客户
		assertEquals(ResultMessage.FAIL,Manage.updateInfo(new ClientVO("H00000002","notfun")));
	}

	@Test
	public void test3(){
		//账号正确
		assertEquals(ResultMessage.SUCCESS,Manage.updateInfo(new ClientVO("C00000001","notfun")));
	}


}
