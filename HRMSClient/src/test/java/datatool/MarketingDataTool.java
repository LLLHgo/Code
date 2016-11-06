package datatool;

import java.util.ArrayList;
import java.util.List;

import vo.marketingVO.MarketingVO;

public class MarketingDataTool {
    static MarketingVO V1=new MarketingVO("Daniel","mypassword","M0000001","13590875643");
    static MarketingVO V2=new MarketingVO("Melody","123456789","M000002","15011134226");
    static MarketingVO V3=new MarketingVO("Rachel","fearlove","M000004","13783275589");;
    static List<MarketingVO> list;
    static{
    	list=new ArrayList<MarketingVO>();
    	list.add(V1);
    	list.add(V2);
    	list.add(V3);
    }
}
