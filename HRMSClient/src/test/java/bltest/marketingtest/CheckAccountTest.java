package bltest.marketingtest;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import businesslogic.marketingbl.MarketingManage;
/**
 * 测试网站营销人员的账号信息的测试代码
 * @author huangpiao
 *
 */
@Ignore("managemanage已经调用真实dataservice，不需要桩")
public class CheckAccountTest {
	private MarketingManage manage=new MarketingManage();

	@Test
	public void test1(){
		//账号密码都对
		assertEquals(true,manage.checkAccount("M00000001","password"));
	}

	@Test
	public void test2(){
		//账号密码都对
		assertEquals(true,manage.checkAccount("M00000002","johnpass"));
	}

	@Test
	public void test3(){
		//账号错
		assertEquals(true,manage.checkAccount("M00000004","yes"));
	}

	@Test
	public void test4(){
		//账号对密码粗
		assertEquals(true,manage.checkAccount("M00000008","that'sright"));
	}
	@Test
	public void test5(){

		assertEquals(null,manage.MarketingAccountFind("M000000089"));
	}

}
