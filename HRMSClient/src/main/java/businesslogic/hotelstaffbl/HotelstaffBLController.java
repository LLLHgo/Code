/**
 *hotelstaff的逻辑层包 
 */
package businesslogic.hotelstaffbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogic.clientbl.ClientManage;
import businesslogic.hoteinfobl.Hotelinfo;
import businesslogic.logbl.LogManage;
import businesslogic.orderbl.Order;
import businesslogic.orderbl.OrderCheck;
import businesslogic.orderbl.OrderFind;
import businesslogic.orderbl.OrderOperator;
import businesslogic.strategybl.StrategyManage;
import businesslogicservice.clientblservice.ClientBLService;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffControllerBLService;
import businesslogicservice.logblservice.LogBLService;
import businesslogicservice.orderblservice.OrderFindBLService;
import businesslogicservice.orderblservice.OrderOperatorBLService;
import businesslogicservice.strategyblservice.StrategyBLService;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
/**
 * 这是酒店工作人员在BL层的一个controller，负责将方法分派给BL层中的其他类。由于lq老师上课介绍说View层的controller是不可以知道
 * BL层的逻辑的，但是当时我在View层的controller已经写好了，所以就保留了view层的controller，但具体逻辑实现还是在现在的这个controller里
 * @version 1
 * @author liuyu
 *
 */
public class HotelstaffBLController implements HotelstaffControllerBLService{

	HotelinfoBLService hotelinfo;
	StrategyBLService strategy;
	OrderFindBLService orderFind;
	OrderOperatorBLService orderOperator;
	OrderCheck orderCheck;
	HotelstaffBLService hotelstaff;
	LogBLService log;
	ClientBLService client;
	

	public HotelstaffBLController(){
		hotelinfo = new Hotelinfo();
		hotelstaff = new HotelstaffManage();
		log = new LogManage();
		orderFind = new OrderFind();
		orderOperator=new OrderOperator();
		strategy = new StrategyManage();
		client = new ClientManage();
		orderCheck = new OrderCheck();
//		hotelinfo = new HotelinfoBLService_stub();
//		strategy = new StrategyBLService_Stub();
//		orderFind = new OrderBLService_Stub();
//		orderOperator=new OrderBLService_Stub();
//		hotelstaff = new HotelstaffBLService_stub();

	}

	//获得酒店基本信息
	@Override
	public HotelinfoVO getHotelBasicinfo(String hotelID) {
		return hotelinfo.getBasicinfo(hotelID);
	}
	
	//获得酒店基本信息列表
	@Override
	public ArrayList<HotelinfoVO> getHotelBasicinfoList(String area,String hotelname,int hotelstar,String roomType) {
		return hotelinfo.getBasicinfoList(area,hotelname,hotelstar,roomType);
	}
	
	//更新酒店基本信息
	@Override
	public ResultMessage updateBassicinfo(HotelinfoVO VO) {
		return hotelinfo.updateBassicinfo(VO);
	}

	//获得房间信息
	@Override
	public RoominfoVO getRoominfo(String hotelID, String roomID) {
		return hotelinfo.getroominfo(hotelID, roomID);
	}

	//获得房间信息列表
	@Override
	public ArrayList<RoominfoVO> getRoominfoList(String hotelID) {
		return hotelinfo.getRoominfoList(hotelID);
	}

	//更新酒店策略
	@Override
	public ResultMessage updatehotelStrategy(HotelStrategyVO vo) {
		 return strategy.updateHotelStrategy(vo);
	}

	//获得酒店策略
	@Override
	public ArrayList<HotelStrategyVO> gethotelStrategy(String hotelID) {
		return (ArrayList<HotelStrategyVO>) strategy.getHotelStrategy(hotelID);
	}

	//查找房间信息
	@Override
	public RoominfoVO getroominfo(String hotelID, String roomID) {
		return hotelinfo.getroominfo(hotelID, roomID);
	}

	//更新房间信息
	@Override
	public ResultMessage updateroominfo(RoominfoVO vo,String hotelID) {
		if(hotelinfo.updateroominfo(vo,hotelID)==true){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAIL;
	}

	//更新订单状态
	@Override
	public ResultMessage updateOrderState(OrderVO vo) {
			Date date = new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			String stringdate = format.format(date.getTime());
			boolean setcrediet = client.setCredit(vo.getClientId(), (int)vo.getPrice(), stringdate, "finish order");
			if(setcrediet == false){
				return ResultMessage.FAIL;
			}
		return orderOperator.saveOrderPO(vo);
	}

	//获得酒店所有订单的列表
	@Override
	public ArrayList<OrderVO> getALLHotelOrderList(String hotelID, OrderType ALL) {
	//	return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(ALL, hotelID);
		return orderFind.findUserOrderList(hotelID);
	}

	//获得酒店未执行订单的列表
	@Override
	public ArrayList<OrderVO> getUnexecutedHotelOrderList(String hotelID, OrderType NORMALEXEC) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(NORMALEXEC, hotelID);
	}

	//获得酒店已执行订单的列表
	@Override
	public ArrayList<OrderVO> getExecutedHotelOrderList(String hotelID, OrderType NORMALNONEXEC) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(NORMALNONEXEC, hotelID);
	}

	//获得酒店异常订单的列表
	@Override
	public ArrayList<OrderVO> getAbnormalHotelOrderList(String hotelID, OrderType ABNORMALCANCEL) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(ABNORMALCANCEL, hotelID);
	}

	//获得酒店已取消订单的列表
	@Override
	public ArrayList<OrderVO> getCancleHotelOrderList(String hotelID, OrderType ABNORMALCANCEL) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(ABNORMALCANCEL, hotelID);
	}

	//获得酒店工作人员基本信息
	@Override
	public String getHotelstaffBasicinfo(String hotelID) {
		return hotelstaff.getBasicinfo(hotelID);
	}

	//设置酒店工作人员密码
	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		return hotelstaff.setPassword(hotelID, password);
	}

	//检查酒店工作人员账号密码
	@Override
	public boolean checkAccount(String hotelID, String password) {
		return hotelstaff.checkAccount(hotelID, password);
	}

	//增加商圈
	@Override
	public ResultMessage addArea(String area) {
		if(hotelinfo.addArea(area)==true){
			return ResultMessage.AddAreaSuccess;
	}
		return null;
	}

	//获得所有商圈
	@Override
	public String[] getArea() {
		return hotelinfo.getArea();
	}

	//增加房间类型
	@Override
	public ResultMessage addRoomType(String type) {
		return ResultMessage.SUCCESS;
	}

	//获得房间类型
	@Override
	public String[] getRoomType() {
		return hotelinfo.getRoomType();
	}

	//获得某个客户特定的订单信息
	@Override
	public ArrayList<OrderVO> getExecutedHotelOrderList(String hotelID, String clientID) {
		ArrayList<OrderVO> list = (ArrayList<OrderVO>) orderFind.findSpecificHotelClientOrderList(clientID, hotelID);
		return list;
	}

	//从界面按照订单号或客户账号对订单进行搜索
	@Override
	public ArrayList<OrderVO> searchOrderFromHotelUI(String hotelID,String text){
		//TODO orderFind里面提供的方法可能会改
		ArrayList<OrderVO> list;
		if(text.charAt(0)=='C'){
			list =(ArrayList<OrderVO>)orderFind.findSpecificHotelClientOrderList(text, hotelID) ;
		}else{
			list = new ArrayList<OrderVO>();
			OrderVO vo = orderFind.findSpecificOrder(hotelID, text);
			if(vo!=null){
				list.add(vo);
			}else{
				return null;
			}
		}
			return list;
	}

	//增加日志
	@Override
	public boolean addLog(String s){
		ResultMessage result= log.addLog(s);
		if(result == ResultMessage.SUCCESS){
			return true;
		}
		return false;
	}

	//新增房间信息
	@Override
	public boolean addroominfo(RoominfoVO vo) {
		return hotelinfo.addroominfo(vo);
	}

	//删除房间信息
	@Override
	public boolean deleteroom(String hotelID, String roomID) {
		return hotelinfo.deleteroom(hotelID,roomID);
	}

	//修改客户信用值
	@Override
	public boolean reviewCrediet(String clientID, int recharge, String date, String reason) {
		return client.setCredit(clientID, recharge, date, reason);
	}

	//更新房间状态（所谓的系统自动更新订单状态，将超时未执行的订单置为异常）
	@Override
	public boolean refreshroomstate() {
		return orderCheck.checkTimeOperateAbnormal();
	}

}
