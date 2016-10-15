package businesslogicservice.orderblservice;

import Enum.ResultMessage;
import vo.orderVO.OrderVO;
import Enum.VIPType;

import java.util.ArrayList;
import java.util.Date;

import Enum.OrderType;

public class OrderBLService_Driver {
	public void drive(OrderBLService orderBLService){
		OrderVO orderInfo;
		ResultMessage result;
		
		// 下订单
		System.out.println("下订单:");
		result=orderBLService.createOrder(new OrderVO("20161015085702","C00000002","Lucy","17714368889",
				VIPType.ORDINARYVIP,new Date(),OrderType.NORMALNONEXEC,"caesar",650.32,new ArrayList<String>()));
		if(result==ResultMessage.SUCCESS) 
			System.out.println("创建失败");
		else if(result==ResultMessage.FAIL)
			System.out.println("创建成功");
		
		// 保存订单
		System.out.println("保存订单:");
		result=orderBLService.createOrder(new OrderVO("20161015085702","C00000002","Lucy","17714368889",
				VIPType.ORDINARYVIP,new Date(),OrderType.NORMALNONEXEC,"caesar",650.32,new ArrayList<String>()));
		if(result==ResultMessage.SUCCESS) 
			System.out.println("保存成功");
		else if(result==ResultMessage.FAIL)
			System.out.println("保存失败");
		
		// 取消订单
		System.out.println("取消订单:");
		result=orderBLService.cancelOrder("20161015085702");
		if(result==ResultMessage.SUCCESS) 
			System.out.println("订单号对应的订单不存在，置为取消状态失败");
		else 
			System.out.println("成功将该订单号对应订单置为取消状态");
		
		// 查找具体订单
		System.out.println("查找订单:20160929170503");
		
		
		
		
	
		
			
	}
}
