package presentation.marketing.view;

import java.awt.Font;

import javax.swing.JPanel;

import presentation.marketing.compoment.MJLabel;
import presentation.marketing.controller.ProcessMarketingViewController;

public class ProcessMarketingCreditView extends JPanel{
	private static final long serialVersionUID = 1L;
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,22);
	

	public ProcessMarketingCreditView(ProcessMarketingViewController ontroller,ProcessMarketingView view) {
		this.setBounds(280, 82, 704, 500);
    	this.setLayout(null);
    	this.setOpaque(false);

    	MJLabel credit=new MJLabel("查询客户",80,30,200,30,font);
    	
        this.add(credit);
    	this.repaint();
        view.add(this);
	}

	public void hideCredit(){
	    	this.removeAll();
	        this.setVisible(false);
     }

}
