package bltest.clientbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import businesslogic.clientbl.ClientManage;

@Ignore("clientmanage已经调用真实dataservice，不需要桩")
public class CheckAccountTest {


	 ClientManage Manage = new ClientManage();
	@Test
	public void test1(){
		//账号密码都对
		assertEquals(true,Manage.checkAccount("C00000001","justfun"));
	}

	@Test
	public void test2(){
		//账号错
		assertEquals(false,Manage.checkAccount("C00000002","justfun"));
	}

	@Test
	public void test3(){
		//密码错
		assertEquals(false,Manage.checkAccount("C00000001","notfun"));
	}

	@Test
	//账号密码都错
	public void test4(){

		assertEquals(false,Manage.checkAccount("C00000002","justfunny"));
	}
}
