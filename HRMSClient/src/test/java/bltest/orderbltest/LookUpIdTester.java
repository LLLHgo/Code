package bltest.orderbltest;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.orderbl.OrderManage;

public class LookUpIdTester {
	
	OrderManage orderManage;

	public LookUpIdTester(){
		orderManage=new OrderManage();
	}
	@Test
	public void test() {
		assertEquals("000000105",orderManage.lookUpIdinDatabase());
	}

}
