package businesslogic.strategybl;

import java.util.ArrayList;

import Enum.VIPType;
import po.StrategyPO.HotelCompanyPO;
import po.StrategyPO.StrategyPO;
import vo.clientVO.ClientVO;

public class HotelCompany extends Strategy{

	public double calDis(StrategyPO strt, ClientVO clientVO, String name,ArrayList<String> companys) {
		if(super.isavailable(strt.getStartTime(), strt.getEndTime())&&name.equals(strt.getName())&&
				clientVO.getType().equals(VIPType.ENTERPRISEVIP)){//满足时间,酒店名字与促销中的名字一致，是企业会员条件
			//for()
			return ((HotelCompanyPO) strt).getDiscount();
		}else{//不满足时间,酒店名字与促销中的名字一致，是企业会员条件
			return 1;
		}
	}



}
