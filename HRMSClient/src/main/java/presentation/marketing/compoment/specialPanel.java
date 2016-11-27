package presentation.marketing.compoment;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import Enum.VIPType;
import Enum.marketingStrategy;
import vo.strategyVO.MarketingStrategyVO;

public class specialPanel extends MJPanel{

	private Font font=new Font("楷体",Font.ITALIC,20);
	private Font font2=new Font("微软雅黑",Font.CENTER_BASELINE,18);
	private Icon addIcon=new ImageIcon("./src/main/resource/picture/marketing/addIcon.png");
	private Icon deleteIcon=new ImageIcon("./src/main/resource/picture/marketing/delete.png");

	private JPanel namePanel=new NamePanel("策略名称",160,10,660,50);
	private JPanel startPanel=new TimePanel("开始时间",160,50,660,50);
	private JPanel endPanel=new TimePanel("结束时间",160,90,660,50);
	private JPanel districtPanel;
	private JLabel addLabel=new MJLabel("等级折扣",160,170,200,50,font);
	private JPanel Apanel=new MJPanel(0,0,200,200);
	private JScrollPane addPane;
	private JButton addButton=new MJButton(230,10,60,60,addIcon);
	private List<Integer> leve=new ArrayList<Integer>();
	private List<Double> dis=new ArrayList<Double>();
    private List<MakePanel> makePanels=new ArrayList<MakePanel>();


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
    	this.add(addLabel);
    	Apanel.setPreferredSize(new Dimension(200,60));

    	addButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel makePanel=new MakePanel(100,10+50*makePanels.size(),400,40);
				makePanels.add((MakePanel) makePanel);

				MJButton delete=new MJButton(290,5,70,40,deleteIcon);
				delete.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						makePanel.removeAll();
					}

				});
				makePanel.add(delete);

                Apanel.add(makePanel);
                Apanel.setPreferredSize(new Dimension(300,60+50*makePanels.size()+10));
                addButton.setLocation(230,50*makePanels.size()+10);
                refresh();
			}

    	});

    	Apanel.add(addButton);
    	addPane=new MJScrollPane(160,210,550,240,Apanel);
    	this.add(addPane);

        this.revalidate();
        this.repaint();

	}

	public void refresh(){
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
