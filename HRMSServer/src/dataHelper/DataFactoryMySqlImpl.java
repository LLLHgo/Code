package dataHelper;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Enum.ResultMessage;

public class DataFactoryMySqlImpl extends UnicastRemoteObject{

	private static final long serialVersionUID = 1L;
	protected Connection conn;
	protected PreparedStatement preState;
	protected String sql;
	protected ResultSet result;

	protected DataFactoryMySqlImpl() throws RemoteException {
		super();
		//this.conn = DataBaseInit.getConnection();
	}
	
	/**
	 * 执行语句并返回执行结果
	 * @param tempPreState
	 * @return
	 */
	protected ResultMessage getDoResult(PreparedStatement tempPreState){
		try {
			if(tempPreState.execute()){
				return ResultMessage.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

}
