package ordertest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Enum.ResultMessage;
import mockAndTest.DataTool;
import presentation.order.controller.ProcessOrderViewController;
import presentation.order.view.ProcessOrderViewControllerService;

public class ProcessOrderViewControllerTest {
	
	ProcessOrderViewControllerService bl;
	ResultMessage result;
	
	@Before
	public void setUp() throws Exception{
		bl=new ProcessOrderViewController();
	}
	@Test
	public void testcreateOrder(){
		result=bl.createOrder(DataTool.getOrders().get(0));
		if(result == ResultMessage.FAIL)
		{
			fail("can not create a order");
		}
	}
}
