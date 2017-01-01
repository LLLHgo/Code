/**
 *hotelstaff的逻辑层包 
 */
package businesslogic.hotelstaffbl;

import java.rmi.RemoteException;

import Enum.ResultMessage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import po.HotelstaffPO;
import rmi.RemoteHelper;
import vo.hotelstaffVO.HotelstaffVO;
/**
 * 酒店工作人员管理类
 * @author liuyu
 *负责处理hotelstaffdata层传来的信息,持久化保存信息到hotelstaffdata层，将酒店工作人员的信息分发到其他模块
 */
public class HotelstaffManage implements HotelstaffBLService{
	//桩测试
	//HotelstaffDataService data = new HotelstaffDataService_Stub();
	HotelstaffDataService data = RemoteHelper.getInstance().hotelstaffDataService();
	//获得酒店工作人员基本信息
	@Override
	public String getBasicinfo(String hotelID) {
		try {
			HotelstaffPO po = data.find(hotelID);
			if(po==null){
				return null;
			}
			return po.getPassword();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}

	}
	//修改酒店工作人员密码
	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		try {
			HotelstaffPO po = data.find(hotelID);
			if(po==null){
				return ResultMessage.IDINVALID;
			}
			po.setPassword(password);
			boolean result = false;
			result = data.hotelstaffUpdate(po);
			if(result==true){
				return ResultMessage.SUCCESS;
			}else{
				return ResultMessage.FAIL;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
	}

	//保存网站管理人员对酒店工作人员的更新
	@Override
	public ResultMessage saveSitemanagerUpdate(HotelstaffVO vo) {
		HotelstaffPO po = new HotelstaffPO(vo.getHotelID(),vo.getPassword(),vo.getTel());
		boolean result = false;
		try {
			result = data.sitemanagerUpdate(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(result==true){
			return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.FAIL;
		}
	}

	//保存网站管理人员对酒店工作人员的增加
	public ResultMessage saveSitemanagerAdd(HotelstaffVO vo) {
		HotelstaffPO po = new HotelstaffPO(vo.getHotelID(),vo.getPassword(),vo.getTel());
		boolean result = false;
		try {
			result = data.insert(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(result==true){
			return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.FAIL;
		}
	}
	
	//返回给网站管理人员酒店工作人员信息
	@Override
	public HotelstaffVO returnSitemanagerAccount(String hotelID) {
		HotelstaffPO po;
		try {
			po = data.find(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(po == null){
			return null;
		}
		HotelstaffVO vo = new HotelstaffVO(po.getHotelID(),po.getPassword(),po.getTel());
		return vo;
	}

	//检查账号密码
	@Override
	public boolean checkAccount(String hotelID, String password) {
		try {
			 HotelstaffPO po= data.find(hotelID);
			 if(po==null){
				 return false;
			 }
			 if(po.getPassword().equals(password)){
				 return true;
			 }
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	//返回给酒店管理人员最新创建的酒店工作人员的账号
	@Override
	public String getNewAddHotelID() {
		try {
			return data.gethotelID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
