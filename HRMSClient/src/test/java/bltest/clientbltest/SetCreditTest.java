package bltest.clientbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import businesslogic.clientbl.ClientManage;

@Ignore("clientmanage已经调用真实dataservice，不需要桩")
public class SetCreditTest {
	ClientManage Manage = new ClientManage();
	@Test
	public void test1(){
		//不存在此用户
		assertEquals(false,Manage.setCredit("C00010001",100,"2016-12-20","finish order"));
	}

	@Test
	public void test2(){
		//非客户账户
		assertEquals(false,Manage.setCredit("H00000001",100,"2016-12-20","finish order"));
	}

	@Test
	public void test3(){
		//正确的客户账户
		assertEquals(true,Manage.setCredit("C00000001",100,"2016-12-20","finish order"));
	}
}
