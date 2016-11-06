package ControllerTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Enum.ResultMessage;
import Mock.*;
import datatool.ClientDataTool;
import datatool.LevelDataTool;
import datatool.MarketingStrategyDataTool;
import datatool.OrderDataTool;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;

public class ProcessMarketingViewControllerTest {
	private MockStrategyManage sm;
	private MockClientManage cm;
	private MockOrderManage om;
	private ResultMessage re;
	private Date date;

	@Before
	public void setup(){
		MarketingStrategyVO v1=MarketingStrategyDataTool.V1;
		sm=new MockStrategyManage();
		cm=new MockClientManage();
		om=new MockOrderManage();
		date=new Date(2016,10,17);
	}
	@Test
	public void testgetClient() {
        ClientVO cvo=ClientDataTool.clientVO1;
        assertEquals(cvo.client_birth,cm.getclient("C00000001").client_birth);
	}

	@Test
	public void testsetAllClientLevel(){
		LevelVO lvo=LevelDataTool.v1;
		assertEquals(true,cm.setAllClientLevel(lvo));
	}

	@Test
	public void testfindAbnormalOrderList(){
		OrderVO ov1=OrderDataTool.orderVO5,ov2=OrderDataTool.orderVO6,ov3=OrderDataTool.orderVO7;
		List<OrderVO> olist=om.findAbnormalOrderList(date);
		assertEquals(true,olist.contains(ov1));
		assertEquals(true,olist.contains(ov2));
		assertEquals(true,olist.contains(ov3));
	}
	@Test
	public void testfindSpecificAbnormalOrder(){
		OrderVO vo=OrderDataTool.orderVO7;
		//assertEquals(vo.getClientId(),om.findSpecificOrderList("20161017092601").getClientId());
	}
	public  void testsaveAbnormalOrder(){
		OrderVO vo=OrderDataTool.orderVO5;
		//assertEquals(vo.getClientId(),om.)
	}
	public void testaddMarketingStrategy(){
		MarketingStrategyVO ms=MarketingStrategyDataTool.V3;
		assertEquals(true,sm.addMarketingStrategy(ms));
	}
	public void testdeleteMarketingStrategy(){
		MarketingStrategyVO ms=MarketingStrategyDataTool.V3;
		assertEquals(true,sm.deleteMarketingStrategy(ms));
	}
	public void testgetMarketingStrategy(){
		MarketingStrategyVO ms1=MarketingStrategyDataTool.V1;
		MarketingStrategyVO ms2=MarketingStrategyDataTool.V2;
		MarketingStrategyVO ms3=MarketingStrategyDataTool.V3;
		assertEquals(true,sm.getMarketingStrategy("M000001").contains(ms1));
		assertEquals(true,sm.getMarketingStrategy("M000001").contains(ms2));
		assertEquals(true,sm.getMarketingStrategy("M000001").contains(ms3));
	}
}
