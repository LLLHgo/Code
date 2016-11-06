package ControllerTest;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import businesslogic.strategybl.StrategyManage;
import businesslogicservice.strategyblservice.StrategyBLService;

public class ProcessMarketingViewControllerTest {
	private StrategyBLService StrategyBLService;

	@Before
	public void setup(){
		StrategyBLService=new StrategyManage();

	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
}
