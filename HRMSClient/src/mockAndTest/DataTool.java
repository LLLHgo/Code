package mockAndTest;
import java.util.*;

import Enum.OrderType;
import Enum.VIPType;
import vo.orderVO.OrderVO;

/**
 * 用于产生测试用的数据
 * @author yilu
 * @version 创建时间：2016年11月2日 下午16:31:13
 *
 */
public class DataTool {
	static Date d1=new Date(2016,10,2);
	static Date d2=new Date(2016,10,13);
	static Date d3=new Date(2016,10,24);
	static Date d4=new Date(2016,10,29);
	static Date d5=new Date(2016,11,2);
	
	static String orderId1="20161002190125";
	static String orderId2="20161013120702";
	static String orderId3="20161020172303";
	
	static String phone1="17717568998";
	
	static ArrayList<OrderVO> orders=new ArrayList<OrderVO>();
	
	static{
		orders.add((new OrderVO("20161015085702","C00000002","Lucy","17714368889",
				VIPType.ORDINARYVIP,d1,OrderType.NORMALNONEXEC,"caesar",650.32,new ArrayList<String>())));
	}
	
	public static ArrayList<OrderVO> getOrders(){
		return orders;
	}
	
	
	
	
}
