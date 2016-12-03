package presentation.marketing.compoment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import vo.levelVO.LevelVO;

public class levelPanel extends MJScrollPane{
	private static final long serialVersionUID = 1L;
    private List<LevelVO> list=new ArrayList<LevelVO>();
	private List<showLevel> panelList=new ArrayList<showLevel>();

	private JPanel panel;
    private Icon deleteIcon=new ImageIcon("./src/main/resource/picture/marketing/delete.png");
    private int height=220;
    private Icon addIcon=new ImageIcon("./src/main/resource/picture/marketing/addIcon.png");
    private JButton addButton;


	public levelPanel(int x, int y, int w, int h,List<LevelVO> list,JPanel panel) {
		super(x, y, w, h,panel);
		this.list=list;
		this.panel=panel;

		addButton=new MJButton(270,height*list.size()+30,50,50,addIcon);
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				LevelVO vo=new LevelVO(0,"",0,0.0);
				changeList();
				MJPanel showLevel=new showLevel(vo.getName(),vo.getLevel(),vo.getCreditNeeded(),vo.getDiscount(),90,height*list.size(),420,height);
			    panel.add(showLevel);
			    panelList.add((showLevel) showLevel);
			    changeList();
			    addButton.setLocation(270,height*list.size()+30);
			    refresh();
			}

		});

		refresh();
	}

	private void changeList() {
		this.list=getLevel();
	}
    private void refresh(){
       	panel.removeAll();
       	panelList=new ArrayList<showLevel>();
		addButton.setLocation(270,height*list.size()+30);
		panel.add(addButton);
        panel.setPreferredSize(new Dimension(690,height*list.size()+80));

        int position=30;//记录当前panel排版的位置
        for(LevelVO vo:list){
        	MJPanel showLevel=new showLevel(vo.getName(),vo.getLevel(),vo.getCreditNeeded(),vo.getDiscount(),90,position,420,height);
          	JButton delete=new MJButton(190,height-40,70,40,deleteIcon);
            delete.addActionListener(new ActionListener(){
				@Override
    			public void actionPerformed(ActionEvent e) {
                    panelList.remove(showLevel);
                    list.remove(vo);
    				changeList();
                    refresh();
    			}
             });
            showLevel.add(delete);
        	position+=height;
        	panel.add(showLevel);
        	panelList.add((showLevel) showLevel);
        }

        this.revalidate();
        this.repaint();

	}



	public List<LevelVO> getLevel() {
		List<LevelVO> d=new ArrayList<LevelVO>();
		for(MJPanel panel:panelList){
	        LevelVO vo=((showLevel) panel).getText();
		    d.add(vo);
		}
		return d;

	}

}
