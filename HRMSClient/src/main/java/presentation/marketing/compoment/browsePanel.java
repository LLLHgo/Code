package presentation.marketing.compoment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Enum.marketingStrategy;
import vo.strategyVO.MarketingStrategyVO;

public class browsePanel extends MJScrollPane{
	private static final long serialVersionUID = 1L;
    private List<MarketingStrategyVO> list;
    private JPanel panel;
    private Icon deleteIcon=new ImageIcon("./src/main/resource/picture/marketing/delete.png");

    private static int[] height={140,200,250};
	public browsePanel(int x, int y, int w, int h,List<MarketingStrategyVO> list,JPanel panel) {
		super(x, y, w, h,panel);
		this.list=list;
		this.panel=panel;
		//特定期间的策略高度为140，专属商圈的折扣为150，其他的策略高度为200.
        refresh();
	}
	private void refresh(){
		panel.removeAll();
		int period=0,special=0,others=0;
		for(MarketingStrategyVO vo:list){
			if(vo.getType()==(marketingStrategy.CREATED))
				others++;
			else if(vo.getType()==(marketingStrategy.PERIOD))
				period++;
			else if(vo.getType()==(marketingStrategy.VIPSPECIAL))
			    special++;
		}
        panel.setPreferredSize(new Dimension(690,height[0]*period+height[1]*special+height[2]*others));

        int position=30;//记录当前panel排版的位置
        for(MarketingStrategyVO vo:list){
            if(vo.getType()==marketingStrategy.PERIOD){
            	Calendar start = vo.getStartTime();
            	Calendar end=vo.getEndTime();
        		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM");// 设置Calendar的格式
        		JPanel showPeriod=new showPeriod(vo.getName(),"开始时间："+df.format(start.getTime()),"结束时间："+df.format(end.getTime()),
        				vo.getDiscount(),60,position,600,height[0]);
            	showPeriod.setOpaque(true);
            	position+=height[0];
            	JButton delete=new MJButton(260,100,70,40,deleteIcon);
                delete.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e) {
                        list.remove(vo);
                        refresh();
        			}
                 });
                showPeriod.add(delete);
            	panel.add(showPeriod);
            }
        }
        this.revalidate();
        this.repaint();
	}

}



























