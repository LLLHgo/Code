package bltest.strategytest;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import Enum.MarketingStrategy;
import Enum.ResultMessage;
import businesslogic.strategybl.StrategyManage;
import vo.strategyVO.MarketingStrategyVO;

public class MarketingStrategyTester {
	private StrategyManage manage=new StrategyManage();

	@Test
	public void marketingStrategyAddTest(){
	    Calendar begin1=Calendar.getInstance();
		Calendar end1=Calendar.getInstance();
		Calendar begin2=Calendar.getInstance();
	    Calendar end2=Calendar.getInstance();
		Calendar begin3=Calendar.getInstance();
		Calendar end3=Calendar.getInstance();
		begin1.set(2016,11,31,23,59);
		end1.set(2017,0,1,23,59);
		begin2.set(2016,12,24,00,00);
		end2.set(2016,11,11,00,00);
		begin3.set(2016,12,31,00,00);
		end3.set(2016,12,31,23,59);
		MarketingStrategyVO vo1=new MarketingStrategyVO("元旦特惠",MarketingStrategy.PERIOD,begin1,end1,0.78);
		assertEquals(ResultMessage.SUCCESS,manage.addMarketingStrategy(vo1));
	}
}



































