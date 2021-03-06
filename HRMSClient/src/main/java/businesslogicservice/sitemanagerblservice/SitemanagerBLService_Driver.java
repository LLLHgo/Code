package businesslogicservice.sitemanagerblservice;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.logVO.LogVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanagerVO.SitemanagerVO;
/**
 * 网站管理人员模块bl层的驱动
 * @author yilu
 *
 */
public class SitemanagerBLService_Driver {
	public void drive(SitemanagerBLService sitemanagerBLService){
		ResultMessage result;
		//Date date;
		ClientVO clientAccountVO = null;
		MarketingVO marketingAccountVO=null;
		HotelinfoVO hotelInfoVO=null;
		HotelstaffVO hotelstaffVO=null;
		SitemanagerVO sitemanagerVO=null;
		ArrayList<LogVO> list=new ArrayList<LogVO>();
		String logInfo=null;
		ImageIcon image = null;
		

		
		// 管理界面得到酒网站管理人员账户信息
		System.out.println("得到网站管理人员账户信息:");
		sitemanagerVO=sitemanagerBLService.sitemanagerAcountShow();
		System.out.print("显示网站管理人员账户信息:");
		System.out.println(sitemanagerVO.getPassword());
		System.out.println("这里是账户的详细信息");
		
		// 修改网站管理人员账户
		System.out.println("修改酒店工作人员账户:");
		result=sitemanagerBLService.sitemanagerAccountUpdatePO(new SitemanagerVO("S00000001","17889967883","h123"));
		if(result==ResultMessage.SUCCESS){
			System.out.println("修改成功");
		}
		else if(result==ResultMessage.FAIL){
			System.out.println("修改失败");
		}
		System.out.println(hotelstaffVO.getHotelID()+" "+hotelstaffVO.getTel());
		
		// 检查登录的网站管理人员账户密码是否正确
		System.out.println("检查登录的网站管理人员账户密码是否正确:");
		result=sitemanagerBLService.checkAccount(new SitemanagerVO("S00000001","17889967883","h123"));
		if(result==ResultMessage.SUCCESS){
			System.out.println("登录帐号密码正确");
		}
		else if(result==ResultMessage.FAIL){
			System.out.println("登录帐号密码错误");
		}
		
		// 显示日志列表
		/*System.out.println("显示日志列表：");
		list=sitemanagerBLService.findLog();
		System.out.println("这里是日志列表的第一条：");
		System.out.println(list.get(0));*/
		
		// 添加日志
		/*System.out.println("添加日志：");
		result=sitemanagerBLService.addLog(logInfo);
		if(result==ResultMessage.SUCCESS){
			System.out.println("添加成功");
		}
		else if(result==ResultMessage.FAIL){
			System.out.println("添加失败");
		}*/
		
	}
}
