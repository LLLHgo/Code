package ControllerTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import Enum.ResultMessage;
import Mock.MockClientManage;
import Mock.MockHotelinfoManage;
import Mock.MockHotelstaffManager;
import Mock.MockLogManage;
import Mock.MockSitemanagerManage;
import datatool.ClientDataTool;
import datatool.LogDataTool;
import datatool.SitemanagerDataTool;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.logVO.LogVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanager.SitemanagerVO;

public class ProcessSiteManagerViewControllerTest {
	MockSitemanagerManage ms;
	MockClientManage mc;
	MockHotelinfoManage mh;
	MockHotelstaffManager mhs;
	MockLogManage ml;
	LogDataTool logDataTool;
	ClientDataTool clientDataTool;
	SitemanagerDataTool sitemanagerDataTool;
	String findinfo;
	boolean resultB;
	SitemanagerVO accountVO;
	ResultMessage result;
	String logInfo;
	
	@Before
	public void setUp(){
	    ms=new MockSitemanagerManage();
		mc=new MockClientManage();
		mh=new MockHotelinfoManage();
		mhs=new MockHotelstaffManager();
		//MockMarketingManage mm=new MockMarketingManage();
		ml=new MockLogManage();
		logDataTool=new LogDataTool();
	    clientDataTool=new ClientDataTool();
	    sitemanagerDataTool=new SitemanagerDataTool();
		findinfo="";
		accountVO=SitemanagerDataTool.sitemanagerVO;
		result=ResultMessage.SUCCESS;
		logInfo="";
		
	}

	@Test
	public void clientAccountUpdate() {
		// TODO Auto-generated method stub
		ClientVO clientVO=ClientDataTool.clientVO1;
		assertEquals(ResultMessage.SUCCESS,mc.updateInfo(clientVO));
	}

	//@Test
	public void accountDelete(String userId) {
		// TODO Auto-generated method stub
		//result=ms.saveSitemanagerDelete(userId);
		//assertEquals(ResultMessage.SUCCESS,result);
	}

	@Test
	public void clientAccountFind() {
		// TODO Auto-generated method stub
	    ClientVO clientVOExpected=ClientDataTool.clientVO1;
	    ClientVO clientVOReal=mc.getclient(findinfo);
	    assertEquals(clientVOExpected.getBirth(),clientVOReal.getBirth());
	    assertEquals(clientVOExpected.getCreditRecord(),clientVOReal.getCreditRecord());
	    assertEquals(clientVOExpected.getFirm(),clientVOReal.getFirm());
	    assertEquals(clientVOExpected.getID(),clientVOReal.getID());
	    assertEquals(clientVOExpected.getLevel(),clientVOReal.getLevel());
	    assertEquals(clientVOExpected.getName(),clientVOReal.getName());
	    assertEquals(clientVOExpected.getPassword(),clientVOReal.getPassword());
	    assertEquals(clientVOExpected.getTel(),clientVOReal.getTel());
	    assertEquals(clientVOExpected.getType(),clientVOReal.getType());
	}

	//@Test
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		// TODO Auto-generated method stub
		
		return null;
	}

	//@Test
	public ResultMessage MarketingAccountUpdate(MarketingVO marketing) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Test
	public MarketingVO MarketingAccountFind(String findInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Test
	public ResultMessage MarketingAccountDelete(String marketingID) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Test
	public ResultMessage HotelAccountAdd(HotelinfoVO hotelinfoVO, HotelstaffVO hotelstaffVO) {
		// TODO Auto-generated method stub
		
		return null;
	}

	//@Test
	public HotelstaffVO HotelStaffAccountFind(String findInfo) {
		// TODO Auto-generated method stub
		
		return null;
	}

	//@Test
	public ResultMessage HotelStaffAccountUpdate(HotelstaffVO hotelstaffVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void sitemanagerAcountShow() {
		// TODO Auto-generated method stub
		SitemanagerVO sitemanagerVOReal=ms.sitemanagerAcountShow();
		SitemanagerVO sitemanagerVOExpexted=SitemanagerDataTool.sitemanagerVO;
		assertEquals(sitemanagerVOExpexted.getPassword(),sitemanagerVOReal.getPassword());
		assertEquals(sitemanagerVOExpexted.getSitemanagerId(),sitemanagerVOReal.getSitemanagerId());
		assertEquals(sitemanagerVOExpexted.getSitemanagerPhoneNumber(),sitemanagerVOReal.getSitemanagerPhoneNumber());
	}

	@Test
	public void sitemanagerAccountUpdate() {
		// TODO Auto-generated method stub
		result=ms.sitemanagerAccountUpdate(accountVO);
		assertEquals(ResultMessage.SUCCESS,result);
	}

	@Test
	public void checkAccount() {
		// TODO Auto-generated method stub
		SitemanagerVO sitemanagerVOReal=SitemanagerDataTool.sitemanagerVO;
		resultB=ms.checkAccount(sitemanagerVOReal);
		assertEquals(false,resultB);
	}

	@Test
	public void findLogTest() {
		// TODO Auto-generated method stub
		ArrayList<LogVO> listReal=ml.getLog();
		ArrayList<LogVO> listExpected=LogDataTool.logList;
		Iterator<LogVO> it1=listReal.iterator();
		Iterator<LogVO> it2=listExpected.iterator();
		while(it1.hasNext()){
			assertEquals(it2.next().getLogInfo(),it1.next().getLogInfo());
		}
		
	}

	@Test
	public void addLog() {
		// TODO Auto-generated method stub
		result=ml.addLog(logInfo);
		assertEquals(ResultMessage.SUCCESS,result);
	}
	

}
