package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import businesslogic.hoteinfobl.HotelinfoManage;

@Ignore("hotelinfomanage已经调用真实dataservice，不需要桩")

public class SetEvaluateTest  {

	HotelinfoManage hotelinfo = new HotelinfoManage();

	@Test
	public void test1(){
		//添加成功
		assertEquals(true,hotelinfo.SetEvaluate(3, "棒！", "C00000001", "H00000001"));
	}
}
