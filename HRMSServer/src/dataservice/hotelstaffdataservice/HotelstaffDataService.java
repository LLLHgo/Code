package dataservice.hotelstaffdataservice;

import java.rmi.RemoteException;

import po.HotelstaffPO;

public interface HotelstaffDataService {
	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
	/**
	 *返回酒店工作人员信息
	 * @param hotelStaffID
	 * @return
	 */
	public HotelstaffPO findBasicInfo(String hotelStaffID);
	/**
	 * 更新密码
	 * @param po
	 * @throws RemoteException
	 */
	public void updatePassword(HotelstaffPO po) throws RemoteException;
	/**
	 * 检查酒店工作人员账户密码
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean checkAccount(HotelstaffPO po) throws RemoteException;
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
