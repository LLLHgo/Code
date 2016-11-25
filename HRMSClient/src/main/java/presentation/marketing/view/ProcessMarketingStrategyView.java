package presentation.marketing.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.marketing.compoment.MJButton;
import presentation.marketing.compoment.MJLabel;
import presentation.marketing.compoment.MJPanel;
import presentation.marketing.compoment.timePanel;
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
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,28);

	private Font font2=new Font("微软雅黑",Font.HANGING_BASELINE,25);

	private Icon strategyPreIcon=new ImageIcon("./src/main/resource/picture/marketing/strategyPreIcon.png");
	private Icon backIcon=new ImageIcon("./src/main/resource/picture/marketing/backIcon.png");
	private JButton double11Button=new MJButton("双11促销",250,50,400,100,font,strategyPreIcon);
	private JButton specialButton=new MJButton ("VIPSpecial",250,155,400,100,font,strategyPreIcon);
	private JButton newButton=new MJButton("制定新策略",250,260,400,100,font,strategyPreIcon);
	private JButton browseButton=new MJButton("查看策略",250,365,400,100,font,strategyPreIcon);
	private JPanel groupPanel=new MJPanel(0,0,780,500);
	private JPanel newPanel=new MJPanel(0,0,780,500);
	private JButton back=new MJButton(80,8,85,50,backIcon);
	public ProcessMarketingStrategyView(ProcessMarketingViewControllerService controller,JPanel panel){
		this.MarketingID=controller.getMarketingID();
        this.Mvo=controller.init(MarketingID);
        this.MSvo=controller.getMarketingStrategy(MarketingID);
    	this.setBounds(200, 82, 780, 500);
    	this.setLayout(null);
    	this.setOpaque(false);

    	groupPanel.add(double11Button);
    	groupPanel.add(specialButton);
    	groupPanel.add(newButton);
    	groupPanel.add(browseButton);

    	double11Button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                double11ButtonClicked();
			}
       	});

    	specialButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                specialButtonClicked();
			}
       	});

    	newButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                newButtonClicked();
			}
       	});
    	browseButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                browseButtonClicked();
			}
       	});
    	this.add(groupPanel);
    	panel.add(this);
	}

	public void double11ButtonClicked(){
		hideGroup();
	}
	public void specialButtonClicked(){
		hideGroup();
	}
	public void newButtonClicked(){
		hideGroup();
		JPanel startPanel=new timePanel(100,50,660,50);
		newPanel.add(startPanel);
		this.add(newPanel);
	}
	public void browseButtonClicked(){
		hideGroup();

	}

	public void hideStrategy() {
		this.removeAll();
		this.setVisible(false);
	}
	public void hideGroup(){
		groupPanel.setVisible(false);
		this.add(back);
	}

}
