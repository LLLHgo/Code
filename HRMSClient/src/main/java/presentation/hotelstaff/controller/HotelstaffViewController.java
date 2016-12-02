package presentation.hotelstaff.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Enum.OrderType;
import Enum.ResultMessage;
import Mock.MockHotelinfoManage;
import Mock.MockHotelstaffManage;
import Mock.MockOrderManage;
import Mock.MockStrategyManage;
import businesslogic.hoteinfobl.HotelinfoManage;
import businesslogic.hotelstaffbl.Hotelstaff;
import businesslogic.hotelstaffbl.HotelstaffManage;
import businesslogic.strategybl.StrategyManage;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.hotelinfoblservice.RoominfoBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.orderblservice.OrderOperatorBLService;
import businesslogicservice.orderblservice.OrderBLService_Stub;
import businesslogicservice.orderblservice.OrderFindBLService;
import businesslogicservice.strategyblservice.StrategyBLService;
import businesslogicservice.strategyblservice.StrategyBLService_Stub;
import datatool.DistrictDataTool;
import presentation.hotelstaff.view.AddRoomPanel;
import presentation.hotelstaff.view.BirthdayStrategyPanel;
import presentation.hotelstaff.view.BusinessStrategyPanel;
import presentation.hotelstaff.view.DetailedStrategy;
import presentation.hotelstaff.view.PeriodStrategy;
import presentation.hotelstaff.view.HotelinfoPanel;
import presentation.hotelstaff.view.HotelstaffPanel;
import presentation.hotelstaff.view.NewRoominfoPanel;
import presentation.hotelstaff.view.NewStrategyPanel;
import presentation.hotelstaff.view.OrderPanel;
import presentation.hotelstaff.view.RoomStrategyPanel;
import presentation.hotelstaff.view.RoominfoPanel;
import presentation.hotelstaff.view.StrategyPanel;
import vo.clientVO.ClientVO;
import vo.districtVO.DistrictVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelstaffViewController implements HotelstaffViewControllerService{
	
	private static HotelstaffViewController controller;
	
	private String hotelID;
	public JPanel view;
	public JPanel panel;
	
	HotelinfoBLService hotelinfo;
	RoominfoBLService roominfo;
	StrategyBLService strategy;
	OrderFindBLService orderFind;
	OrderOperatorBLService orderOperator;
	HotelstaffBLService hotelstaff;
	
//	HotelinfoBLService_stub hotelinfo;
//	StrategyBLService_stub strategy;
//	OrderBLService_stub order;
//	HotelstaffBLService_stub hotelstaff;
//	public HotelstaffViewController(){
//		new HotelstaffViewController("H00000001");
//	}

	public String gethotelID(){
		return hotelID;
	}

	private HotelstaffViewController(String hotelID){
		this.hotelID = hotelID;
		hotelinfo = new HotelinfoManage();
//		strategy = new StrategyManage();
//		order = new OrderManage();
		hotelstaff = new HotelstaffManage();
	
//		hotelinfo = new HotelinfoBLService_stub();
		strategy = new StrategyBLService_Stub();
		orderFind = new OrderBLService_Stub();
		orderOperator=new OrderBLService_Stub();
//		hotelstaff = new HotelstaffBLService_stub();
	}

	public static HotelstaffViewController getInstance(String hotelID){
		if(controller == null){
			controller = new HotelstaffViewController(hotelID);
		}
		return controller;
	}
	
	public void setView(JPanel view){
		this.view = view;
	}
	
	@Override
	public HotelinfoVO getHotelBasicinfo(String hotelID) {
		return hotelinfo.getBasicinfo(hotelID);
	}

	@Override
	public ArrayList<HotelinfoVO> getHotelBasicinfoList(ClientRequirementVO vo) {
		return hotelinfo.getBasicinfoList(vo);
	}

	@Override
	public ResultMessage updateBassicinfo(HotelinfoVO VO) {
		return hotelinfo.updateBassicinfo(VO);
	}

	@Override
	public RoominfoVO getRoominfo(String hotelID, String roomID) {
		return roominfo.getroominfo(hotelID, roomID);
	}

	@Override
	public ArrayList<RoominfoVO> getRoominfoList(String hotelID) {
		return roominfo.getRoominfoList(hotelID);
	}

	@Override
	public double calculatePrice(ArrayList<HotelStrategyVO> hotelStrategylist,
			ArrayList<MarketingStrategyVO> marketingStrategyList, ClientVO vo, double originalPrice) {
		return roominfo.calculatePrice(hotelStrategylist, marketingStrategyList, vo, originalPrice);
	}


	@Override
	public ResultMessage updatehotelStrategy(HotelStrategyVO vo) {
		 return strategy.updateHotelStrategy(vo);
	}

	@Override
	public ArrayList<HotelStrategyVO> gethotelStrategy(String hotelID) {
		return (ArrayList<HotelStrategyVO>) strategy.getHotelStrategy(hotelID);
	}

	@Override
	public ResultMessage deletehotelStrategy(HotelStrategyVO hotelStrategy) {
		boolean result = strategy.deletehotelStrategy(hotelStrategy);
		if(result == true){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAIL;
		}
	}

	@Override
	public HotelinfoVO gethotelinfoVO(String hotelID) {
		return hotelinfo.gethotelinfoVO(hotelID);
	}

	@Override
	public RoominfoVO getroominfo(String hotelID, String roomID) {
		return roominfo.getroominfo(hotelID, roomID);
	}

	@Override
	public ResultMessage updateroominfo(RoominfoVO vo,String hotelID) {
		if(roominfo.updateroominfo(vo,hotelID)==true){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAIL;
	}


	@Override
	public ResultMessage updateOrderState(OrderVO vo) {
		return orderOperator.saveOrderPO(vo);
	}

	@Override
	public ArrayList<OrderVO> getALLHotelOrderList(String hotelID, OrderType ALL) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(ALL, hotelID);
	}

	@Override
	public ArrayList<OrderVO> getUnexecutedHotelOrderList(String hotelID, OrderType NORMALEXEC) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(NORMALEXEC, hotelID);
	}

	@Override
	public ArrayList<OrderVO> getExecutedHotelOrderList(String hotelID, OrderType NORMALNONEXEC) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(NORMALNONEXEC, hotelID);
	}

	@Override
	public ArrayList<OrderVO> getAbnormalHotelOrderList(String hotelID, OrderType ABNORMALCANCEL) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(ABNORMALCANCEL, hotelID);
	}
	
	@Override
	public ArrayList<OrderVO> getCancleHotelOrderList(String hotelID, OrderType ABNORMALCANCEL) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(ABNORMALCANCEL, hotelID);
	}
	
	@Override
	public String getHotelstaffBasicinfo(String hotelID) {
		return hotelstaff.getBasicinfo(hotelID);
	}

	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		return hotelstaff.setPassword(hotelID, password);
	}

	@Override
	public boolean checkAccount(String hotelID, String password) {
		return hotelstaff.checkAccount(hotelID, password);
	}

	public void JBHotelinfoClicked(){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new HotelinfoPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}
	
	public void JBRoominfoClicked(){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new NewRoominfoPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}
	
	public void JBOrderClicked(){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new OrderPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}
	
	public void JBPersonalinfoClicked(){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new HotelstaffPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}


	public void JBExitClicked(){
		System.exit(0);
	}

	public void JBAddRoomClicked(){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new AddRoomPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}
	
	public void JBStrategyClicked(){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new StrategyPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}
	
	public void JBStrategyClicked(String message){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new StrategyPanel(panelcontroller);
		view.add(panel);
		((StrategyPanel)panel).showMessage(message);
		panel.revalidate();
		panel.repaint();
	}
	
	public void JBRoomClicked(String message){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new NewRoominfoPanel(panelcontroller);
		view.add(panel);
		((NewRoominfoPanel)panel).showMessage(message);
		panel.revalidate();
		panel.repaint();
	}
	
	@Override
	public ResultMessage addArea(String area) {
		if(hotelinfo.addArea(area)==true){
			return ResultMessage.AddAreaSuccess;
		}
		return null;
	}

	@Override
	public String[] getArea() {
		return hotelinfo.getArea();
	}
	

	@Override
	public ResultMessage addRoomType(String type) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public String[] getRoomType() {
		return roominfo.getRoomType();
	}


	public void detailedStrategy(HotelStrategyVO vo) {
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		if(vo.getName().equals("生日特惠折扣")){
			panel = new BirthdayStrategyPanel(panelcontroller,vo);
		}else if(vo.getName().equals("三间及以上预订特惠")){
			panel = new RoomStrategyPanel(panelcontroller,vo);
		}else if(vo.getName().equals("合作企业客户折扣")){
			panel = new BusinessStrategyPanel(panelcontroller,vo);
		}else if(vo.getName().equals("双十一活动折扣")){
			panel = new PeriodStrategy(panelcontroller,vo);
		}else{
			panel = new DetailedStrategy(panelcontroller,vo);
		}
		
		view.add(panel);
		//TODO
//		((NewRoominfoPanel)panel).showMessage(message);
		panel.revalidate();
		panel.repaint();
		
	}

	@Override
	public void newStrategy() {
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new NewStrategyPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}

	@Override
	public ArrayList<OrderVO> getExecutedHotelOrderList(String hotelID, String clientID) {
		ArrayList<OrderVO> list = (ArrayList<OrderVO>) orderFind.findSpecificHotelClientOrderList(clientID, hotelID);
		return list;
	}



}
