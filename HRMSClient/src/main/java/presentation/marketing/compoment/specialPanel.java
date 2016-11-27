package presentation.marketing.compoment;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import Enum.VIPType;
import Enum.marketingStrategy;
import vo.strategyVO.MarketingStrategyVO;

public class specialPanel extends MJPanel{

	private Font font=new Font("楷体",Font.HANGING_BASELINE,18);
	private Font font2=new Font("微软雅黑",Font.CENTER_BASELINE,18);
	private JPanel namePanel=new NamePanel("策略名称",160,10,660,50);
	private JPanel startPanel=new TimePanel("开始时间",160,50,660,50);
	private JPanel endPanel=new TimePanel("结束时间",160,90,660,50);
	private JPanel districtPanel;
	private JScrollPane addPane=new addPane(160,190,550,250);

	private MarketingStrategyVO createdVO;
    private List<JRadioButton> districtButton=new ArrayList<JRadioButton>();

	private static final long serialVersionUID = 1L;

	public specialPanel(int x, int y, int w, int h,List<String> list) {
		super(x, y, w, h);

		districtPanel=new SelectPanel("商圈",160,80,660,200,list);
		this.setVisible(false);
		this.add(namePanel);
		this.add(startPanel);
    	this.add(endPanel);
    	this.add(districtPanel);
    	this.add(addPane);

        this.revalidate();
        this.repaint();
	}

	public MarketingStrategyVO getCreatedVO() {

        String name=namePanel.getName();
        Calendar start=((TimePanel) startPanel).getTime();
        Calendar end=((TimePanel) endPanel).getTime();


        /*setCreatedVO(new MarketingStrategyVO(name,marketingStrategy.CRATEDE,
             start,end,discount,hotelSelected,minExpenditure,minRoom,minLevel,VIPSelected));*/
		 return createdVO;
	}
	private void setCreatedVO(MarketingStrategyVO createdVO) {
		this.createdVO = createdVO;
	}
	public void setStartTime(int year, int month, int date, int hour, int minute) {
		((TimePanel) startPanel).setTime(year,  month,  date,  hour,  minute);

	}
	public void setEndTime(int year, int month, int date, int hour, int minute) {
		((TimePanel) endPanel).setTime(year,  month,  date,  hour,  minute);

	}


}
