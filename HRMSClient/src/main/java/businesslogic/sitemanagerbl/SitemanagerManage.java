package businesslogic.sitemanagerbl;

import java.rmi.RemoteException;

import Enum.ResultMessage;
import businesslogicservice.sitemanagerblservice.SitemanagerBLService;
import dataservice.sitemanagerdataservice.SitemanagerDataService;
import po.SitemanagerPO;
import rmi.RemoteHelper;
import vo.sitemanagerVO.SitemanagerVO;
/**
 * 网站管理人员管理类
 * @author yilu
 *
 */
public class SitemanagerManage implements SitemanagerBLService {
	RemoteHelper remote;
	SitemanagerDataService sitemanagerDataService;
	SitemanagerVO sitemanagerVO;
	SitemanagerPO sitemanagerPO;
	String currentTel,updateTel;
	String currentPassword,updatePassword;
	boolean result;
	
	public SitemanagerManage(){
		remote=RemoteHelper.getInstance();
		sitemanagerDataService=remote.getSitemanagerDataService();
		
	}
	/**
	 * 管理界面得到网站管理人员账户信息
	 * @return SitemanagerVO
	 */
	public SitemanagerVO sitemanagerAcountShow(){
		try {
			sitemanagerPO=sitemanagerDataService.getAccount();
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
	public ResultMessage sitemanagerAccountUpdatePO(SitemanagerVO updateVO){
		currentTel=sitemanagerVO.getSitemanagerPhoneNumber();
		currentPassword=sitemanagerVO.getPassword();
		updateTel=updateVO.getSitemanagerPhoneNumber();
		updatePassword=updateVO.getPassword();
		
		System.out.println("InSitemanagerManage:"+updateVO.getPassword());
		
		if(voidTel()&&voidPassword())
			return ResultMessage.VOIDINFO;
		else if (voidTel())
			return ResultMessage.VOIDTEL;
		else if(voidPassword())
			return ResultMessage.VOIDPASSWORD;
		else{
			sitemanagerPO=new SitemanagerPO(updateVO.getSitemanagerId(),updateTel,updatePassword);
			// 将更新的账户信息保存到数据层
			try {
				result=sitemanagerDataService.SitemanagerAccountUpdate(sitemanagerPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(result==true)
				return ResultMessage.SUCCESS;
			else
				return ResultMessage.DATEBASEFAIL;
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
			sitemanagerPO=sitemanagerDataService.getAccount();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(accountVO.getSitemanagerId().equals(sitemanagerPO.getSitemanagerId())&&
				accountVO.getPassword().equals(sitemanagerPO.getPassword())){
			return ResultMessage.SUCCESS;
		}
		else
			return ResultMessage.FAIL;
	}
}