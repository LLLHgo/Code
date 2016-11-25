package presentation.marketing.view;

import java.util.List;

import javax.swing.JPanel;

import vo.marketingVO.MarketingVO;
import vo.strategyVO.MarketingStrategyVO;;

public class ProcessMarketingStrategyView extends JPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String MarketingID;
	private MarketingVO Mvo;
	private List<MarketingStrategyVO> MSvo;
	public ProcessMarketingStrategyView(ProcessMarketingViewControllerService controller,JPanel panel){
		this.MarketingID=controller.getMarketingID();
        this.Mvo=controller.init(MarketingID);
        this.MSvo=controller.getMarketingStrategy(MarketingID);
    	this.setBounds(200, 82, 704, 500);
    	this.setLayout(null);
    	this.setOpaque(false);
	}

}
