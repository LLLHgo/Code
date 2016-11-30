package businesslogic.clientbl;

import java.io.File;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogicservice.clientblservice.ClientBLService;
import dataservice.clientdataservice.ClientDataService;
import po.ClientPO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.orderVO.OrderVO;


public class ClientManage implements ClientBLService{
	static ClientDataService clientdata;
	@Override
	public ClientVO getclient(String clientID) {
		// TODO Auto-generated method stub
		try{
		return clientdata.findPersonalInfo (clientID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage createClient(ClientVO vo) {
		// TODO Auto-generated method stub
		try{
			boolean res=clientdata.createClient(vo);
			if(res)return ResultMessage.SUCCESS;
			else 	return ResultMessage.FAIL;
			}catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public ResultMessage saveSitemanagerDelete(String clientId) {
		// TODO Auto-generated method stub
		try{
			boolean res=clientdata.deleteClient(clientId);
			if(res)return ResultMessage.SUCCESS;
			else 	return ResultMessage.FAIL;
			}catch(Exception e){
				e.printStackTrace();
			}
		return null;

	}

	@Override
	public boolean setCredit(String clientID, int recharge) {
		// TODO Auto-generated method stub
		try{
			boolean res=clientdata.setCredit(clientID,recharge);
			return res;
			}catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean setAllClientLevel(LevelVO vo) {
		// TODO Auto-generated method stub
		try{
			boolean res=clientdata. setAllLevel(vo);
			return res;
			}catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}


	@Override
	public ResultMessage updateInfo(ClientVO vo) {
		// TODO Auto-generated method stub
		try{
			return clientdata.modifyPersonalInfo(vo);
			}catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}



	@Override
	public ArrayList<String> getCreditRecord(String clientID) {
		// TODO Auto-generated method stub
		try{
			return clientdata.getCreditRecord(clientID);
			}catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}



}