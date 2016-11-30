package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.HotelStrategy;
import Enum.ResultMessage;
import Enum.VIPType;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.TextField;
import presentation.hotelstaff.component.TimePanel;
import presentation.hotelstaff.controller.HotelstaffViewController;
import presentation.marketing.compoment.MJButton;
import presentation.marketing.compoment.newPanel;
import vo.districtVO.DistrictVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class DetailedStrategy extends JPanel{

	private static final long serialVersionUID = 1L;

	private HotelstaffViewController controller;
	private String hotelID;
	private HotelStrategyVO vo;
	private JPanel newPanel;
	private ImageIcon Iinit;
	private JLabel resultLabel;
	private TextField jtfname;
	private TextField jtfdiscount;
	private TextField jtfroom;
	private TextField jtfmoney;
	private JComboBox jcbKind;
	private JComboBox jcbLevel;
	private ConfirmButton confirm;
	private CancleButton cancle;
	private String name;
	private Calendar startTime;
	private Calendar endTime;
	private VIPType viptype;
	private double discount;
	private int minSum;
	private int minRooms;
	
	public DetailedStrategy(HotelstaffViewController controller,HotelStrategyVO vo){
		this.controller=controller;
		this.hotelID=controller.gethotelID();
		this.vo = vo;
		Iinit = new ImageIcon("./src/main/resource/picture/hotelstrategy/newstrategy.png");
		init();
	}
	
	public void init(){
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setSize(1000, 618);
		this.setVisible(true);
		setOpaque(false);
		
		//显示结果
		resultLabel = new JLabel();
		resultLabel.setForeground(Color.BLACK);
		resultLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
		resultLabel.setBounds(290, 50, 500, 20);
		this.add(resultLabel);	
		
		this.add(new TimePanel(458,129,308,37));
		this.add(new TimePanel(458,182,308,37));
		
		jtfname = new TextField("",460,90,400,35,4);
		jtfname.setText(vo.getName());
		this.add(jtfname);
		
		jtfdiscount = new TextField("",460,234,50,35,4);
		jtfdiscount.setText(String.valueOf(vo.getDiscount()));
		this.add(jtfdiscount);
		
		jtfroom = new TextField("",460,401,50,35,4);
		jtfroom.setText(String.valueOf(vo.getMinRooms()));
		this.add(jtfroom);
		
		jtfmoney = new TextField("",460,453,50,35,4);
		jtfmoney.setText(String.valueOf(vo.getMinSum()));
		this.add(jtfmoney);
		
		//TODO radiobutton
		
		confirm = new ConfirmButton(840,480);
		this.add(confirm);
		confirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				ResultMessage result = controller.updatehotelStrategy(vo);
				if(result == ResultMessage.SUCCESS){
					controller.JBStrategyClicked("修改策略成功");
				}else{
					showMessage(result.toString());
				}
				
			}
			
		});
		
		cancle = new CancleButton(690,480);
		this.add(cancle);
		cancle.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.JBStrategyClicked("取消操作成功");	
			}
			
		});
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(Iinit.getImage(), 305,90,464,404,this);
    }
	
	public void showMessage(String message){
	 	//提示信息
		new Thread(new Runnable(){
			@Override
			public void run() {
					resultLabel.setText(message);
				try {
					Thread.sleep(1000);
	            }catch(InterruptedException ex){
	                    ex.printStackTrace();
	            }
	            resultLabel.setText("");
			}
		}).start();
	}
}