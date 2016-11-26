package presentation.marketing.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import vo.districtVO.DistrictVO;

public class newPanel extends MJPanel{

	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,21);
	private Font font2=new Font("微软雅黑",Font.CENTER_BASELINE,18);
	private JPanel startPanel=new TimePanel("开始时间",160,50,660,50);
	private JPanel endPanel=new TimePanel("结束时间",160,90,660,50);
	private JPanel typePanel=new MemberPanel("会员种类",160,130,350,50);
	private JPanel levelPanel=new InputPanel("最低等级",160,170,350,50);
    private JPanel discountPanel=new InputPanel("折扣",420,170,300,50);
    private JPanel roomPanel=new InputPanel("最少房间数",145,210,350,50);
    private JPanel expenditurePanel=new InputPanel("最少消费额",385,210,350,50);
    private JPanel hPanel=new HotelPanel("酒店",160,250,300,50);
    private JPanel hotelsPanel;

    private static final long serialVersionUID = 1L;

	public newPanel(int x, int y, int w, int h,List<DistrictVO> list) {
		super(x, y, w, h);
		this.setVisible(false);
		this.add(startPanel);
    	this.add(endPanel);
    	this.add(discountPanel);
    	this.add(hPanel);
    	this.add(typePanel);
    	this.add(levelPanel);
    	this.add(roomPanel);
        this.add(expenditurePanel);

        int items=0;//酒店的个数 每个酒店需要40高度
        for(DistrictVO vo:list){
        	items+=vo.getHotels().size();
        }
        hotelsPanel=new MJPanel(0, 0, 700,3520);
        hotelsPanel.setPreferredSize(new Dimension(590,40*items+40+50*list.size()));//dimension的高度是酒店占高度和商圈占高度的和

        int dis=-1;//商圈的个数 每个商圈需要50高度
        items=0;
        for(DistrictVO vo:list){
        	items+=vo.getHotels().size();
        	dis++;
        	JLabel district=new MJLabel(vo.getName(),40,dis*50+(items-vo.getHotels().size())*40,400,50,font);
        	hotelsPanel.add(district);
        	
        	List<String> hotelList=vo.getHotels();
        	int index=0;
        	for(String s:hotelList){
        		index++;
        		JRadioButton hotelButton=new MJRadioButton(s,false,60,dis*50+items*40+index*40,400,40,font2);//每个酒店在所对应商圈下方
        		hotelsPanel.add(hotelButton);
        	}
        	
        }

        //放置showAbnormalOrderPanel的JScrollPanel
        JScrollPane hotelsScroll = new MJScrollPane(205, 285, 580, 217,hotelsPanel);
        this.add(hotelsScroll);
        this.revalidate();
        this.repaint();

	}
	public TimePanel getStartPanel(){
		return (TimePanel) this.startPanel;
	}
	public TimePanel getEndPanel(){
		return (TimePanel) this.endPanel;
	}
	public InputPanel getDiscountPanel() {
		return (InputPanel) this.discountPanel;
	}

}
