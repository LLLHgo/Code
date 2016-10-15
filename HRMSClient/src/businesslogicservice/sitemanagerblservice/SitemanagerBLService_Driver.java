package businesslogicservice.sitemanagerblservice;

import java.util.Date;

import Enum.ResultMessage;
import Enum.VIPType;
import vo.clientVO.ClientAccountVO;

public class SitemanagerBLService_Driver {
	public void drive(SitemanagerBLService sitemanagerBLService){
		ResultMessage result;
		//Date date;
		ClientAccountVO clientAccountvo = null;
		
		// 修改客户账户
		System.out.println("修改客户账户:");
		result=sitemanagerBLService.clientAccountUpdate(new ClientAccountVO("C00000008","Ken","13777879889",
				VIPType.ORDINARYVIP,2,new Date(),null,"01234"));
		if(result==ResultMessage.SUCCESS){
			System.out.println("修改成功");
		}
		else if(result==ResultMessage.FAIL){
			System.out.println("修改失败");
		}
		System.out.println(clientAccountvo.getClient_name()+" "+clientAccountvo.getClient_tel()+clientAccountvo.getClient_birth());
		
		// 删除账户
		System.out.println("删除客户账户:");
		result=sitemanagerBLService.accountDelete("H00000090");
		if(result==ResultMessage.SUCCESS){
			System.out.println("删除成功");
		}
		else if(result==ResultMessage.FAIL){
			System.out.println("删除失败");
		}
	
		// 管理界面得到客户账户信息
		System.out.println("得到客户账户信息:");
		clientAccountvo=sitemanagerBLService.clientAccountFind("C00000009");
		System.out.println("显示客户账户信息:");
		System.out.println(clientAccountvo.getClient_name()+clientAccountvo.getVip_type());
		
		// 修改网站营销人员账户
		
		// 删除网站营销人员账户
		
		// 管理界面得到网站营销人员账户信息
		
		// 添加酒店
		
		// 管理界面得到酒店工作人员账户信息
		
		// 修改酒店工作人员账户
		
		// 检查登录的网站管理人员账户密码是否正确
	}
}
