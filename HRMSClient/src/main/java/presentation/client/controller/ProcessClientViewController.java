package presentation.client.controller;

import java.io.File;
import java.sql.Date;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import presentation.client.view.ProcessClientViewControllerService;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.orderVO.OrderVO;

public class ProcessClientViewController implements ProcessClientViewControllerService {

	@Override
	public ClientVO getclient(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createClient(ClientVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setCredit(String clientID, int recharge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAllClientLevel(LevelVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HotelinfoVO> getSearchHotel(ClientRequirementVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getSearchDateOrder(String clientID, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getSearchHotelOrder(String clientID, String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateInfo(ClientVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Order(OrderVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean repealOrder(String orderID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderVO> getAllOrderList(String clientID, OrderType order_type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getOrderList(String clientID, OrderType order_type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getCreditRecord(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelinfoVO> getHistoryList(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

}
