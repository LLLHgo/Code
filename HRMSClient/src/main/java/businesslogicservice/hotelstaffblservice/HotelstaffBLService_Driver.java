package businesslogicservice.hotelstaffblservice;

import Enum.ResultMessage;
import vo.hotelstaffVO.HotelstaffVO;

public class HotelstaffBLService_Driver {

	public void drive(HotelstaffBLService hotelstaffBLService){
		//登录时检测账号密码
		boolean checkAccountBool=hotelstaffBLService.checkAccount("H00000000", "000000");
		if(checkAccountBool)System.out.println("登录成功！");

		//获得酒店工作人员信息
		String result =hotelstaffBLService.getBasicinfo("H00000000");
		if(result!=null)System.out.println("获得酒店工作人员信息成功！");

		
		//返回酒店工作人员信息
		HotelstaffVO HSTvo=hotelstaffBLService.returnSitemanagerAccount("H00000000");
		if(HSTvo!=null)System.out.println("获得酒店工作人员信息成功！");

	    //保存酒店工作人员信息更改
		ResultMessage hsbls=hotelstaffBLService.saveSitemanagerUpdate(new HotelstaffVO());
		if(hsbls==ResultMessage.SUCCESS)System.out.println("保存酒店工作人员信息更改成功！");

		//设置密码
		ResultMessage setPasswordResult=hotelstaffBLService.setPassword("H00000000","000000");
		if(setPasswordResult==ResultMessage.SUCCESS)System.out.println("修改密码成功");
	}
}
