package presentation.marketing.compoment;

import javax.swing.JPanel;

public class newPanel extends MJPanel{

	private JPanel startPanel=new TimePanel("开始时间",160,50,660,50);
	private JPanel endPanel=new TimePanel("结束时间",160,90,660,50);
	private JPanel typePanel=new MemberPanel("会员种类",160,130,350,50);
	private JPanel levelPanel=new InputPanel("最低等级",160,170,350,50);
    private JPanel discountPanel=new InputPanel("折扣",410,170,300,50);
    private JPanel roomPanel=new InputPanel("最少房间数",160,210,350,50);
    private JPanel expenditurePanel=new InputPanel("最少消费额",410,210,350,50);
    private JPanel hotelPanel=new HotelPanel("酒店",410,290,300,50);

    private static final long serialVersionUID = 1L;

	public newPanel(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.setVisible(false);
		this.add(startPanel);
    	this.add(endPanel);
    	this.add(discountPanel);
    	this.add(hotelPanel);
    	this.add(typePanel);
    	this.add(levelPanel);
    	this.add(roomPanel);
        this.add(expenditurePanel);
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
