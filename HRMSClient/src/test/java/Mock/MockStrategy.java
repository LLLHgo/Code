package Mock;

import java.util.ArrayList;
import java.util.List;

import Enum.VIPType;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class MockStrategy {
	//网站营销人员制定的策略1
	private MarketingStrategyVO ms1;
	//网站营销人员制定的策略2
	private MarketingStrategyVO ms2;
	//酒店工作人员制定的策略1
	private HotelStrategyVO hs1;
	//酒店工作人员制定的策略2
	private HotelStrategyVO hs2;
    //福利1
	private PrivilegeVO pv1;
	//福利2
	private PrivilegeVO pv2;

	public MockStrategy(){

	}
    public MockStrategy(MarketingStrategyVO vo){
		this.ms1=vo;
	}

    public MockStrategy(MarketingStrategyVO v1,MarketingStrategyVO v2){
		this.ms1=v1;
		this.ms2=v2;
	}
    public MockStrategy(HotelStrategyVO vo){
		this.hs1=vo;
	}

    public MockStrategy(HotelStrategyVO v1,HotelStrategyVO v2){
		this.hs1=v1;
		this.hs2=v2;
	}

    public boolean addMarketingStrategy(MarketingStrategyVO vo) {
		return true;
	}

	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		List<MarketingStrategyVO> list=new ArrayList<MarketingStrategyVO>();
		list.add(ms1);
		list.add(ms2);
		return list;
	}


	public boolean deleteMarketingStrategy(MarketingStrategyVO vo) {
		return true;
	}


	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		List<HotelStrategyVO> list=new ArrayList<HotelStrategyVO>();
		list.add(hs1);
		list.add(hs2);
		return list;
	}


	public boolean updateHotelStrategy(HotelStrategyVO vo) {
		return true;
	}

	public boolean addPrivilege(PrivilegeVO vo) {
		return true;
	}


	public List<PrivilegeVO> findAllPrivilege(VIPType type) {
		List<PrivilegeVO> list=new ArrayList<PrivilegeVO>();
		list.add(pv1);
		list.add(pv2);
		return list;
	}


	public boolean delete(PrivilegeVO vo) {
		return true;
	}

}
