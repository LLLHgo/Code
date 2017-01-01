package bltest.marketingtest;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.marketingbl.MarketingManage;
/**
 * 获得最近创建的网站营销人员账户的账号的测试代码
 * @author huangpiao
 *
 */
public class getMarketingIDTester {
@Test
public void test(){
	MarketingManage manage=new MarketingManage();
	assertEquals("M00000009",manage.getMarketingID());
}
}
