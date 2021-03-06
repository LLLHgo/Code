package dataservice.clientdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Enum.ResultMessage;
import po.ClientPO;


public class ClientDataService_Driver {
	public void drive(ClientDataService clientDataService) throws RemoteException{
		ClientPO po=new ClientPO();
		//测试创建新客户
		//boolean cc=clientDataService.createClient(po);
		//if(cc)System.out.println("New Client!ERROR!");
		//测试设置信用值
		boolean sc=clientDataService.setCredit("000001", 2,"no","no");
		if(sc)System.out.println("Update Credit!");
			//测试修改个人基本信息
		if(clientDataService.modifyPersonalInfo( po)==ResultMessage.SUCCESS)System.out.println("Update Info!");
		//测试查看个人信用记录
		ArrayList<String> cr=clientDataService.findCreditRecord("000001");
		if(cr!=null)System.out.println("Get Client Credit Record!");
		//查找客户账户
		boolean ca=clientDataService.checkAccount("000001", "000000");
		if(ca)System.out.println("Account Exist!");
	}
}


