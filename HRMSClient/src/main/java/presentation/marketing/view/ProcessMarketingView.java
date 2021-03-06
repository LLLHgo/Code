package presentation.marketing.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import presentation.common.GuideBoardButton;
import presentation.marketing.compoment.MJLabel;
/**
 * marketing总界面的panel
 * @author huangpiao
 *
 */
public class ProcessMarketingView extends JPanel{
	private static final long serialVersionUID = 1L;
	private String MarketingID;
	private Icon welcomeIcon=new ImageIcon(this.getClass().getResource("welcomeIcon.png"));

	private Image image=new ImageIcon(this.getClass().getResource("marketing.png")).getImage();
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,22);
	private MJLabel ID=new MJLabel("ID:",50,185,50,30,font);
	private MJLabel IDLabel;
	private GuideBoardButton profile=new GuideBoardButton(241,"个人信息");
	private GuideBoardButton abnormal=new GuideBoardButton(301,"异常订单");
	private GuideBoardButton credit=new GuideBoardButton(361,"信用值充值");
	private GuideBoardButton VIP=new GuideBoardButton(421,"等级设置");
	private GuideBoardButton strategy=new GuideBoardButton(481,"制定策略");
	private GuideBoardButton exit=new GuideBoardButton(541,"退出");
	private MJLabel welcome=new MJLabel(275,-19,775,800,welcomeIcon);
	private MJLabel hintLabel=new MJLabel("",280,35,700,40,font);

	public ProcessMarketingView(ProcessMarketingViewControllerService controller){
		this.MarketingID=controller.getMarketingID();
    	this.setBounds(0, 0,1000,618);
    	this.setLayout(null);

       	//根据MarketingID加入IDMLabel 默认头像和welcomeMLabel
		IDLabel=new MJLabel(MarketingID,100, 185,200,30,font);
		this.add(welcome);
        this.add(ID);
       	this.add(IDLabel);

        //给profileButton加监听
        profile.addActionListener(new ActionListener(){
        	@Override
			public void actionPerformed(ActionEvent e) {
				controller.profileButtonClicked();
			}
        });

        //给abnormalButtton加监听
        abnormal.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.abnormalButtonClicked();
			}
        });

        //给strategyButtton加监听
        strategy.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.strategyButtonClicked();
			}
        });

      //给VIPButtton加监听
        VIP.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.VIPButtonClicked();
			}
        });

      //给creditButtton加监听
        credit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.creditButtonClicked();
			}
        });

        //给exitButton加监听
        exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                System.exit(0);
			}
         });

      	this.add(profile);
      	this.add(abnormal);
      	this.add(credit);
    	this.add(VIP);
    	this.add(strategy);
    	this.add(exit);

    	hintLabel.setForeground(Color.black);
    	this.add(hintLabel);

    }


	protected  void paintComponent(Graphics g) {
    	g.drawImage(image,0,0,getSize().width,getSize().height,this);
    }

    //点击菜单栏后，隐藏welcome的JPanel
    public void hideWelcome(){
    	welcome.setVisible(false);
    }

    public void setHint(String hint){

    	hintLabel.setVisible(true);
        hintLabel.setText(hint);
    	new Thread(new Runnable(){
			@Override
			public void run() {
				hintLabel.setText(hint);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				hintLabel.setText("");
			}

		}).start();

    }

}
