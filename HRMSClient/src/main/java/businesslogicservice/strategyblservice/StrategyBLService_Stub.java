package businesslogicservice.strategyblservice;

import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import Enum.VIPType;
import businesslogic.hoteinfobl.Hotelinfo;
import businesslogic.hoteinfobl.Roominfo;
import datatool.HotelStrategyDataTool;
import datatool.MarketingStrategyDataTool;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.priceVO.PriceVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class StrategyBLService_Stub implements StrategyBLService{

	/**
	 * 增加网站营销人员所制定的策略
	 * @param vo
	 * @return 返回是否增加成功
	 */
    public ResultMessage  addMarketingStrategy(MarketingStrategyVO vo) {
		if(vo!=null){
			System.out.println(vo.getName()+" "+vo.getEndTime());
			System.out.println(vo.getType()+" "+vo.getStartTime());
			return ResultMessage.SUCCESS;
		}
		else
			return ResultMessage.FAIL;
	}

    /**
     * 返回营销人员所指定的促销策略
     * @param id
     * @return 返回策略信息列表
     */
    public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		return MarketingStrategyDataTool.list;
	}

    /**
     * 删除网站营销人员制定的促销策略
     * @param vo
     * @return 返回是否删除成功
     */
    public ResultMessage deleteMarketingStrategy(String vo) {
    	if(vo!=null){
    		return ResultMessage.SUCCESS;
    	}
		else
			return ResultMessage.FAIL;
	}

    /**
     * 根据酒店ID返回该酒店的促销策略
     * @param hotelID
     * @return 返回该酒店的促销策略列表
     */
    public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
    	return HotelStrategyDataTool.list;
	}

    /**
     * 更新酒店制定的促销策略
     * @param vo
     * @return 返回是否更新成功
     */
    public ResultMessage updateHotelStrategy(HotelStrategyVO vo) {
    	if(vo!=null)
    		return ResultMessage.SUCCESS;
		else
			return ResultMessage.FAIL;
	}


	@Override
	public boolean deletehotelStrategy(HotelStrategyVO vo) {
		if(vo!=null)
			return true;
		else
			return false;
	}

	@Override
	public PriceVO calculatePrice(ClientVO clientVO, RoominfoVO roomInfoVO, HotelinfoVO hotelInfoVO, int num) {
		// TODO Auto-generated method stub
		return null;
	}

}
