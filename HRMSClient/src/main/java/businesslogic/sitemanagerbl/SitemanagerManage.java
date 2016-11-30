package businesslogic.sitemanagerbl;

import java.rmi.RemoteException;

import Enum.ResultMessage;
import businesslogicservice.sitemanagerblservice.SitemanagerBLService;
import dataservice.sitemanagerdataservice.SitemanagerDataService;
import po.SitemanagerPO;
import vo.sitemanager.SitemanagerVO;

public class SitemanagerManage implements SitemanagerBLService {
	SitemanagerDataService SitemanagerDataService;
	SitemanagerVO sitemanagerVO;
	SitemanagerPO sitemanagerPO;
	String currentTel,updateTel;
	String currentPassword,updatePassword;
	/**
	 * 管理界面得到网站管理人员账户信息
	 * @return SitemanagerVO
	 */
	public SitemanagerVO sitemanagerAcountShow(){
		try {
			sitemanagerPO=SitemanagerDataService.getAccount();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		sitemanagerVO=new SitemanagerVO(sitemanagerPO.getSitemanagerId(),sitemanagerPO.getSitemanagerPhoneNumber(),
				sitemanagerPO.getPassword());
		return sitemanagerVO;
	}
	
	/**
	 * 修改网站管理人员账户
	 * @param accountVO
	 * @return
	 */
	public ResultMessage sitemanagerAccountUpdate(SitemanagerVO updateVO){
		currentTel=sitemanagerVO.getSitemanagerPhoneNumber();
		currentPassword=sitemanagerVO.getPassword();
		updateTel=updateVO.getSitemanagerPhoneNumber();
		updatePassword=updateVO.getPassword();
		if(sameTel()&&samePassword())
			return ResultMessage.SAMEINFO;
		else if (voidTel())
			return ResultMessage.VOIDTEL;
		else if(voidPassword())
			return ResultMessage.VOIDPASSWORD;
		else{
			sitemanagerPO=new SitemanagerPO(updateVO.getSitemanagerId(),updateTel,updatePassword);
			// 将更新的账户信息保存到数据层
			try {
				SitemanagerDataService.SitemanagerAccountUpdate(sitemanagerPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return ResultMessage.SUCCESS;
		}
	}
	boolean sameTel(){
		return currentTel.equals(updateTel);
	}
	boolean samePassword(){
		return currentPassword.equals(updatePassword);
	}
	boolean voidTel(){
		return updateTel.trim().equals("")||(updateTel==null);
	}
	boolean voidPassword(){
		return updatePassword.trim().equals("")||(updatePassword==null);
	}
	
	
	/**
	 * 检查登录的网站管理人员账户密码是否正确
	 * @param account
	 * @return 登录帐号或密码正确（true）或错误（false）的布尔值
	 */
	public ResultMessage checkAccount (SitemanagerVO accountVO){
		try {
			sitemanagerPO=SitemanagerDataService.getAccount();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(accountVO.getSitemanagerId().equals(sitemanagerPO.getSitemanagerId())&&
				sitemanagerPO.getPassword().equals(sitemanagerPO.getPassword())){
			return ResultMessage.SUCCESS;
		}
		else
			return ResultMessage.FAIL;
	}
	

	@Override
	public SitemanagerVO init(String id) {
		// TODO Auto-generated method stub
		try {
			sitemanagerPO=SitemanagerDataService.getAccount();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		sitemanagerVO=new SitemanagerVO(sitemanagerPO.getSitemanagerId(),sitemanagerPO.getSitemanagerPhoneNumber(),
				sitemanagerPO.getPassword());
		return sitemanagerVO;
	}
}