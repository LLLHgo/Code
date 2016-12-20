package businesslogic.clientbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import businesslogic.marketingbl.MarketingManage;
import businesslogicservice.clientblservice.ClientBLService;
import businesslogicservice.marketinblservice.MarketingBLService;
import dataservice.clientdataservice.ClientDataService;
import po.ClientPO;
import rmi.RemoteHelper;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;


public class ClientManage implements ClientBLService{
	static ClientDataService clientdata;
	MarketingBLService marketing=new MarketingManage();
	@Override
	public ClientVO getclient(String clientID) {
		if(clientID.equals("")||clientID==null)
			return null;
		else if(clientID.charAt(0)=='C'&&clientID.length()==9){
		try{
			ClientPO po=RemoteHelper.getInstance().clientDataService().findPersonalInfo(clientID);
			if(po!=null){
			ClientVO vo=new ClientVO(po.getID(),po.getPassword(),po.getName(),po.getTel(),po.getType(),po.getLevel(),po.getBirth(),po.getFirm(),po.getCredit(),po.getRecord());
			return vo;
			}
		}catch(RemoteException e){
				e.printStackTrace();
			}

		}
	return null;

	}

	@Override
	public String  createClient(ClientVO vo) {

		// TODO Auto-generated method stub
		if(vo.getTel()==null||vo.getTel()=="")
			return "FAIL";
		else if(vo.getTel().length()==11){
		try{
			ClientPO po=new ClientPO(vo.getID(),vo.getPassword(),vo.getName(),vo.getTel(),vo.getType(),vo.getLevel(),vo.getBirth(),vo.getFirm(),vo.getCreditRecord(),vo.getCredit());
			String res=RemoteHelper.getInstance().clientDataService().createClient(po);
			if(res.charAt(0)=='C')
				return res;
		}catch(RemoteException e){
				e.printStackTrace();
			}

		}

		return "FAIL";

	}

	@Override
	public ResultMessage saveSitemanagerDelete(String clientId) {
		// TODO Auto-generated method stub
		if(clientId==""||clientId==null)
			return ResultMessage.FAIL;
		else if(clientId.charAt(0)=='C'&&clientId.length()==9){
		try{
			if(RemoteHelper.getInstance().clientDataService().deleteClient(clientId))
				return ResultMessage.SUCCESS;
			}catch(RemoteException e){
				e.printStackTrace();

			}}
		return ResultMessage.FAIL;

	}

	@Override
	public boolean setCredit(String clientID, int recharge,String date,String reason) {
		// TODO Auto-generated method stub
		List<LevelVO> level=marketing.findAllLevel();
		boolean flag=true;
		try{
			if(!RemoteHelper.getInstance().clientDataService().setCredit(clientID, recharge, date, reason))
				flag=false;
			if(flag)
			for(int i=0;i<level.size();i++){
				if(getclient(clientID).getCredit()<level.get(i).getCreditNeeded()){
				flag=setClientLevel(clientID,level.get(i).getLevel()-1);
				break;
				}
			}
			return flag;
			}catch(RemoteException e){
				e.printStackTrace();

			}
			 return false;
	}
	@Override
	public boolean setClientLevel(String clientID,int level) {
		ClientVO client=getclient(clientID);
		client.setLevel(level);
		if(updateInfo(client)==ResultMessage.SUCCESS)
		return true;
		else return false;

	}
	@Override
	public boolean setAllClientLevel(ArrayList<LevelVO>  vos) {
		// TODO Auto-generated method stub
		try{
			boolean res=clientdata. setAllLevel();
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
			ClientPO po=new ClientPO(vo.getID(),vo.getPassword(),vo.getName(),vo.getTel(),vo.getType(),vo.getLevel(),vo.getBirth(),vo.getFirm(),vo.getCreditRecord(),vo.getCredit());
			ResultMessage rs=RemoteHelper.getInstance().clientDataService().modifyPersonalInfo(po);
				return rs;
			}catch(RemoteException e){
				e.printStackTrace();

			}
		return ResultMessage.FAIL;
	}



	@Override
	public ArrayList<String> getCreditRecord(String clientID) {
		// TODO Auto-generated method stub
		if(clientID==""||clientID==null)
			return null;
		else if(clientID.charAt(0)=='C'&&clientID.length()==9){
		try{
			ArrayList<String> list=RemoteHelper.getInstance().clientDataService().findCreditRecord(clientID);
			if(list!=null)
			return list;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean checkAccount(String clientID, String password)  {
		// TODO Auto-generated method stub
		try{
		if(RemoteHelper.getInstance().clientDataService().checkAccount(clientID,password))
			return true;
		}catch(RemoteException e){
			e.printStackTrace();

		}
		 return false;
	}



}
