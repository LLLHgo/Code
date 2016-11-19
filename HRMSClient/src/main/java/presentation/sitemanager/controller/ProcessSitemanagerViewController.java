package presentation.sitemanager.controller;

import java.util.ArrayList;

import Enum.ResultMessage;
import businesslogicservice.sitemanagerblservice.SitemanagerBLService;
import businesslogicservice.sitemanagerblservice.SitemanagerBLService_Stub;
import presentation.sitemanager.view.ProcessSitemanagerView;
import presentation.sitemanager.view.ProcessSitemanagerViewControllerService;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.logVO.LogVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanager.SitemanagerVO;

public class ProcessSitemanagerViewController implements ProcessSitemanagerViewControllerService {
	
	String sitemanagerId;
	private ProcessSitemanagerView processSitemanagerView;
	SitemanagerBLService sitemanagerblservice; // 以stub调用
	
	public ProcessSitemanagerViewController(String sitemanagerId){
		this.sitemanagerId=sitemanagerId;
		sitemanagerblservice=new SitemanagerBLService_Stub();
	}
	
	
	public String getSitemanagerId(){
		return sitemanagerId;
	}
	public void setView(ProcessSitemanagerView view) {
		this.processSitemanagerView=view;
	}
	
	public SitemanagerVO init(String id) {
		return sitemanagerblservice.init(id);
	}
	public ResultMessage clientAccountUpdate(ClientVO clientVO) {
		return ResultMessage.SUCCESS;
	}

	public ResultMessage accountDelete(String userId) {
		return ResultMessage.SUCCESS;
	}

	public ClientVO clientAccountFind(String findInfo) {
		return null;
	}

	
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		return ResultMessage.SUCCESS;
	}


	public ResultMessage MarketingAccountUpdate(MarketingVO marketing) {
		return ResultMessage.SUCCESS;
	}

	public MarketingVO MarketingAccountFind(String findInfo) {
		return null;
	}

	public ResultMessage MarketingAccountAdd(HotelinfoVO hotelinfo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage HotelAccountAdd(HotelinfoVO hotelinfoVO, HotelstaffVO hotelstaffVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public HotelstaffVO HotelStaffAccountFind(String findInfo) {
		return null;
	}

	@Override
	public ResultMessage HotelStaffAccountUpdate(HotelstaffVO hotelstaffVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public SitemanagerVO sitemanagerAcountShow() {
		return sitemanagerblservice.sitemanagerAcountShow();
	}

	@Override
	public ResultMessage sitemanagerAccountUpdate(SitemanagerVO accountVO) {
		return sitemanagerblservice.sitemanagerAccountUpdate(accountVO);
	}

	@Override
	public ResultMessage checkAccount(SitemanagerVO accountVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<LogVO> findLog() {
		return null;
	}

	@Override
	public ResultMessage addLog(String logInfo) {
		return ResultMessage.SUCCESS;
	}



}
