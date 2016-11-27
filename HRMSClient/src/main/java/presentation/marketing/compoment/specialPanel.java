package presentation.marketing.compoment;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Enum.VIPType;
import vo.strategyVO.MarketingStrategyVO;

public class specialPanel extends MJPanel{

	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,21);
	private Font font2=new Font("微软雅黑",Font.CENTER_BASELINE,18);
	private JPanel namePanel=new NamePanel("策略名称",160,10,660,50);
	private JPanel startPanel=new TimePanel("开始时间",160,50,660,50);
	private JPanel endPanel=new TimePanel("结束时间",160,90,660,50);
	private JPanel typePanel=new MemberPanel("会员种类",160,130,350,50);
	private JPanel levelPanel=new InputPanel("最低等级",160,170,350,50);
    private JPanel discountPanel=new InputPanel("折扣",420,170,300,50);
    private JPanel roomPanel=new InputPanel("最少房间数",145,210,350,50);
    private JPanel expenditurePanel=new InputPanel("最少消费额",385,210,350,50);
    private JPanel hotelPanel=new HotelPanel("酒店",180,250,300,50);
    private JPanel hotelsPanel;
    private List<String> hotelSelected=new ArrayList<String>();
    private List<VIPType> VIPSelected;
    private MarketingStrategyVO createdVO;
    private List<JRadioButton> hotelButton=new ArrayList<JRadioButton>();

	private static final long serialVersionUID = 1L;

	public specialPanel(int x, int y, int w, int h) {
		super(x, y, w, h);

		this.setVisible(false);
		this.add(namePanel);
		this.add(startPanel);
    	this.add(endPanel);
    	this.add(discountPanel);
    	this.add(hotelPanel);
    	this.add(typePanel);
    	this.add(levelPanel);
    	this.add(roomPanel);
        this.add(expenditurePanel);

	}

}
