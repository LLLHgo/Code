package bltest.orderbltest.orderCheckTimeTester;


import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Ignore;
import org.junit.Test;

import dataservice.orderdataservice.OrderDataService;
import rmi.RemoteHelper;
/**
 * order模块bl层的checkTimeToAbnormal方法的测试
 * @author 1
 *
 */
@Ignore("ordermanage已经调用真实dataservice，不需要桩")
public class checkTimeTester {
	RemoteHelper remote;
	OrderDataService dataservice;
	public checkTimeTester(){
		dataservice=remote.getInstance().getOrderDataService();
		
	}
	@Test
	public void test() {
		boolean result=false;
		try {
			result=dataservice.checkTimeOperateAbnormal();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertEquals(true,result);
	}

}
