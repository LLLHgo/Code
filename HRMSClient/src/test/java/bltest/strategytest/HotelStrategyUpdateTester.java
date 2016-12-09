package bltest.strategytest;

import java.util.Calendar;

import org.junit.Test;

import businesslogic.strategybl.StrategyManage;
import vo.strategyVO.HotelStrategyVO;

public class HotelStrategyUpdateTester {
	private StrategyManage manage=new StrategyManage();

	@Test
	public void getMarketingStrategyTest(){
		Calendar begin1=Calendar.getInstance();
		Calendar end1=Calendar.getInstance();
		Calendar begin2=Calendar.getInstance();
	    Calendar end2=Calendar.getInstance();
		Calendar begin3=Calendar.getInstance();
		Calendar end3=Calendar.getInstance();
		Calendar begin4=Calendar.getInstance();
	    Calendar end4=Calendar.getInstance();
		Calendar begin5=Calendar.getInstance();
		Calendar end5=Calendar.getInstance();
		begin1.set(2016,11,30,23,59,00);
		end1.set(2017,0,1,23,59,00);
		begin2.set(2016,11,24,00,00,00);
		end2.set(2016,11,25,00,00,00);
		begin3.set(2016,11,31,00,00,00);
		end3.set(2017,0,30,23,59,00);
		begin4.set(2016,11,24,00,00,00);
		end4.set(2016,11,25,00,00,00);
		begin5.set(2016,11,31,00,00,00);
		end5.set(2017,0,30,23,59,00);
		HotelStrategyVO vo1=new HotelStrategyVO();
	}

}


















