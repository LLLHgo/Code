package dataservice.strategydataservice;

import java.util.List;

import Enum.VIPType;
import po.PrivilegePO;

public interface StrategyDataService {
	/**
	 * 增加会员福利信息
	 * @param po
	 * @return 是否增加成功
	 */
    public boolean addPrivilege(PrivilegePO po);

    /**
     * 根据VIPtype返回已制定的会员福利信息
     * @param type
     * @return 返回该种类会员的福利信息列表
     */
    public List<PrivilegePO> findAllPrivilege(VIPType type);

    /**
     * 删除会员福利信息
     * @param po
     * @return 返回是否删除成功
     */
    public boolean deletePrivilege(PrivilegePO po);

    public boolean addStrategy(StrategyPO po);
}
