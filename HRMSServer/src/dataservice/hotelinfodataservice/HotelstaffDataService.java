package dataservice.hotelinfodataservice;

import java.rmi.RemoteException;

import po.HotelinfoPO;
import po.RoominfoPO;

public interface HotelstaffDataService {
	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
	/**
	 * 获得房间信息列表
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public RoominfoPO getRoominfoList(String hotelID) throws RemoteException;
	/**
	 * 获得房间信息
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public HotelinfoPO findhotelinfo(String hotelID) throws RemoteException;
	/**
	 * 更新酒店信息
	 * @param po
	 * @throws RemoteException
	 */
	public void updatehotelinfo(HotelinfoPO po) throws RemoteException;
	/**
	 * 更新房间信息
	 * @param po
	 * @throws RemoteException
	 */
	public void updateroominfo(RoominfoPO po) throws RemoteException;
	/**
	 * 删除持久化数据
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(RoominfoPO po) throws RemoteException;
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
