package presentation.marketing.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.marketing.compoment.MJButton;
import presentation.marketing.compoment.MJPanel;
import presentation.marketing.controller.ProcessMarketingViewController;
import presentation.marketing.compoment.*;
import vo.levelVO.LevelVO;

public class ProcessMarketingVIPView extends JPanel{

	private static final long serialVersionUID = 1L;

	private ProcessMarketingViewControllerService controller;
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,28);
	private JPanel groupPanel=new MJPanel(0,0,780,500);
	private JScrollPane levelPanel;

	private Icon VIPPreIcon=new ImageIcon("./src/main/resource/picture/marketing/strategyPreIcon.png");
	private Icon backIcon=new ImageIcon("./src/main/resource/picture/marketing/backIcon.png");
	private int height=180;


	public ProcessMarketingVIPView(ProcessMarketingViewController controller,ProcessMarketingView view) {
		this.controller=controller;
		this.setBounds(200, 82, 780, 500);
    	this.setLayout(null);
    	this.setOpaque(false);

    	JButton levelButton=new MJButton("制定等级",250,110,400,100,font,VIPPreIcon);
    	JButton privilegeButton=new MJButton ("会员福利",250,280,400,100,font,VIPPreIcon);

    	levelButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                levelButtonClicked();
			}


      	});
    	groupPanel.add(levelButton);
    	groupPanel.add(privilegeButton);

    	this.add(groupPanel);
    	view.add(this);
    	this.revalidate();
    	this.repaint();

	}


	private void levelButtonClicked() {
		hideGroup();
		List<LevelVO> levels=controller.findAllLevel();
		JPanel panel=new MJPanel(0,0,200,200);
        panel.setPreferredSize(new Dimension(690,height*levels.size()+70));
		levelPanel=new levelPanel(80,0,820,400,levels,panel);
		levelPanel.setVisible(true);


		JButton back=new MJButton(2,8,85,50,backIcon);

		back.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                List<LevelVO> delete=((levelPanel) levelPanel).getLevel();
                for(LevelVO vo:delete){
                	controller.deleteLevel(vo);
                }
                groupPanel.setVisible(true);
			    levelPanel.removeAll();
				levelPanel.setVisible(false);
				levelPanel=null;
			}
		});


		levelPanel.add(back);
        this.add(levelPanel);
	    this.revalidate();
		this.repaint();
	}
	public void hideVIP() {
		this.removeAll();
		this.setVisible(false);
	}
	public void hideGroup(){
		groupPanel.setVisible(false);
	}


}
