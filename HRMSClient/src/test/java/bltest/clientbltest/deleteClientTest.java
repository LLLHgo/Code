package bltest.clientbltest;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import businesslogic.clientbl.ClientManage;
@Ignore
public class deleteClientTest {

	
	ClientManage Manage = new ClientManage();
	@Test
	public void test1(){
		//账号都对
		assertEquals(true,Manage.saveSitemanagerDelete("C00000052"));
	}
	@Test
	public void test2(){
		//账号不存在
		assertEquals(false,Manage.saveSitemanagerDelete("C00000112"));
	}

}
