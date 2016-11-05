package ControllerTest;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Enum.OrderType;
import Enum.ResultMessage;
import Enum.VIPType;
import Mock.MockClientManage;
import businesslogic.clientbl.Client;
import presentation.client.controller.ProcessClientViewController;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.orderVO.OrderVO;

public class ProcessClientViewControllerTest {
	private ProcessClientViewController controller;
	Client c1;
    Client c2;
    Client c3;
	@Before
	public void setUp(){
		 Date day1=new Date(1996,2,29);
		 File file=new File("credit");
		 Date day3=new Date(1992,5,29);
		c1 = new Client("C00000001","justfun","ErgouWang","13747474741",
				 VIPType.ORDINARYVIP,2,day1,"",file);
        c2 = new Client("C00000002","actullyjustfun","sangouWang","13747474742",
       		 VIPType.ENTERPRISEVIP,4,null,"Fake",file);
        c3 = new Client("C00000003","definitelyjustfun","sigouWang","13747474743",
       		 VIPType.ORDINARYVIP,1,day3,"",file);
	}

	/**
	 *通过客户ID得到客户个人信息
	 * @param clientID
	 * @return 客户的个人信息
	 */
	@Test
	public ClientVO getclient (String clientID){
		MockClientManage mc=new MockClientManage(clientID);
		return mc.getclient(clientID);
	}

	/**
	 *增加新客户
	 * @param vo
	 * @return 增加新用户成功与否
	 */
	@Test
	public boolean createClient(ClientVO vo){
		MockClientManage mc=new MockClientManage(vo);
		return mc.createClient(vo);
	}
	/**
	 *设置（修改）某一客户信用值
	 * @param clientID
	 * @param recharge
	 * @return 修改信用值成功与否
	 */
	/*@Test
	public boolean setCredit(String clientID,int recharge){
		MockClientManage mc=new MockClientManage(clientID);
		return mc.setCredit(clientID,recharge);
	}*/
	/**
	 * 根据新的会员等级制度修改所有客户的会员等级
	 * @param vo
	 * @return 修改会员等级成功与否
	 */
	/*@Test
	public boolean setAllClientLevel(LevelVO vo){
		MockClientManage mc=new MockClientManage();
		return mc.setAllClientLevel(vo);
	}*/
	/**
	 * 通过完整正确的酒店关键词得到相关酒店列表
	 * @param vo
	 * @return符合关键词的酒店列表
	 */
	@Test
	public List<HotelinfoVO> getSearchHotel(ClientRequirementVO vo){
		List<HotelinfoVO> hotel=new ArrayList<HotelinfoVO>();
		return hotel;
	}
	/**
	 *得到具体日期的客户订单
	 * @param clientID
	 * @param date
	 * @return 该日期的客户订单
	 */
	@Test
	public List<OrderVO> getSearchDateOrder(String clientID,Date date){
		List<OrderVO> order=new ArrayList<OrderVO>();
		return order;
	}
	/**
	 *得到具体酒店的客户订单
	 * @param clientID
	 * @param hotelID
	 * @return 该酒店的客户订单
	 */
	@Test
	public List<OrderVO> getSearchHotelOrder( String clientID,String hotelID){
		List<OrderVO> order=new ArrayList<OrderVO>();
		return order;
	}
	/**
	 *修改客户基本信息
	 * @param vo
	 * @return 修改个人信息成功与否提示信息
	 */
	@Test
	public  ResultMessage updateInfo(ClientVO vo){
		if(vo!=null)
			return ResultMessage.SUCCESS;
		else
			return ResultMessage.FAIL;
	}
	/**
	 *创建订单
	 * @param orderID
	 * @return 创建成功与否
	 */
	@Test
	public boolean createOrder(OrderVO vo){
		if(vo!=null)
			return true;
		else
			return false;
	}
	/**
	 *撤销订单
	 * @param orderID
	 * @return 撤销成功与否
	 */
	@Test
	public boolean repealOrder(String orderID){
		if(orderID!=null)
			return true;
		else
			return false;
	}
	/**
	 *得到客户的所有订单
	 * @param clientID
	 * @param order_type
	 * @return 所有订单列表
	 */
	@Test
	public List<OrderVO> getAllOrderList(String clientID,OrderType order_type){
		List<OrderVO> order=new ArrayList<OrderVO>();
		return order;
	}
	/**
	 *得到客户某一类型的订单
	 * @param clientID
	 * @param order_type
	 * @return 类型订单列表
	 */
	@Test
	public List<OrderVO> getOrderList(String clientID,OrderType order_type){
		List<OrderVO> order=new ArrayList<OrderVO>();
		return order;
	}
	/**
	 *得到客户的信用记录
	 * @param clientID
	 * @return 信用记录
	 */
	@Test
	public File getCreditRecord(String clientID){
		if(clientID!=null)
			return new File(clientID);
		else
			return null;
	}
	/**
	 *得到客户的历史预订酒店列表
	 * @param clientID
	 * @return 历史预订酒店列表
	 */
	@Test
	public List<HotelinfoVO> getHistoryList(String clientID){
		List<HotelinfoVO> hotel=new ArrayList<HotelinfoVO>();
		return hotel;
	}


}
