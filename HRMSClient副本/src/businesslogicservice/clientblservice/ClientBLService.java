package businesslogicservice.clientblservice;

import java.io.File;
import java.sql.Date;
import java.util.List;

import po.OrderType;
import po.ResultMessage;
import vo.*;
import vo.clientVO.ClientVO;
import vo.orderVO.OrderVO;


public interface ClientBLService {
	//通过客户ID得到客户个人信息
	public ClientVO getclient (String clientID);
	//增加新客户
	public boolean createClient(ClientVO vo);
	//设置（修改）某一客户信用值
	public boolean setCredit(String clientID,int recharge);
	//根据新的会员等级制度修改所有客户的会员等级
	public boolean setAllClientLevel(LevelVO vo);
	//通过完整正确的酒店关键词得到相关酒店列表
	public List<HotelinfoVO> getSearchHotel(OrderRequirementVO vo);
	//得到具体日期的客户订单
	public List<OrderVO> getSearchDateOrder(String clientID,Date date);
	//得到具体酒店的客户订单
	public List<OrderVO> getSearchHotelOrder( String hotelID);
	//修改客户基本信息
	public  ResultMessage updateInfo(ClientVO vo);
	//撤销订单
	public boolean repealOrder(String orderID);
	//得到客户的所有订单
	public List<OrderVO> getAllOrderList(String clientID,OrderType order_type);
	//得到客户某一类型的订单
	public List<OrderVO> getOrderList(String clientID,OrderType order_type);
	//得到客户的信用记录
	public File getCreditRecord(String clientID);
	//得到客户的历史预订酒店列表
	public List<HotelinfoVO> getHistoryList(String clientID);
}
