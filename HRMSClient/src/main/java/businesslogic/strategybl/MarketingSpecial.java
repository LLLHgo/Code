package businesslogic.strategybl;


import businesslogic.hoteinfobl.Hotelinfo;
import po.StrategyPO.MarketingSpecialPO;
import po.StrategyPO.StrategyPO;
import vo.clientVO.ClientVO;

public class MarketingSpecial extends Strategy {

	public double calDis(StrategyPO strt, ClientVO clientvo,Hotelinfo hotelInfoVO) {
		double res=1;
		if(super.isavailable(strt.getStartTime(),strt.getEndTime())&&
				hotelInfoVO.getName().equals(((MarketingSpecialPO) strt).getBusinessDistrict())){
			int[] levels=((MarketingSpecialPO) strt).getLevels();
			double[] discounts=((MarketingSpecialPO) strt).getDiscounts();
			for(int i=0;i<levels.length;i++){
				if(levels[i]==clientvo.getLevel()){
					res=discounts[i];
					break;
				}
			}
		}else{
			res=1;
		}
		return res;
	}
}
