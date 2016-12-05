package businesslogic.strategybl;

import Enum.VIPType;
import po.StrategyPO.HotelPrivilegePO;
import po.StrategyPO.StrategyPO;
import vo.clientVO.ClientVO;

public class HotelBirthday extends Strategy{

	public double calDis(StrategyPO strt, ClientVO clientVO, String name) {
		if(super.isavailable(strt.getStartTime(), strt.getEndTime())&&name.equals(strt.getName())&&
				clientVO.getType().equals(VIPType.ORDINARYVIP)){//满足时间,酒店名字与促销中的名字一致，是生日会员条件
			return ((HotelPrivilegePO) strt).getDiscount();
		}else{//不满足时间,酒店名字与促销中的名字一致，是生日会员条件
			return 1;
		}
	}



}
