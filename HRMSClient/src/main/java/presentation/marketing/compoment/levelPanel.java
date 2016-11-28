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

	private JPanel panel;
    private Icon deleteIcon=new ImageIcon("./src/main/resource/picture/marketing/delete.png");
    private int height=180;
    private Icon addIcon=new ImageIcon("./src/main/resource/picture/marketing/addIcon.png");
    private JButton add;


	public levelPanel(int x, int y, int w, int h,List<LevelVO> list,JPanel panel) {
		super(x, y, w, h,panel);
		this.list=list;
		this.panel=panel;

		add=new MJButton(250,list.size()*height+30,50,50,addIcon);
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			    list.add(new LevelVO(0,"",0));
			    add.setLocation(250, list.size()*height+30);
			    refresh();
			}

		});

		this.add(add);

		refresh();
	}

	private void refresh(){
		panel.removeAll();

		add.setLocation(250, list.size()*height+30);
        panel.setPreferredSize(new Dimension(690,height*list.size()+30+50));

        int position=30;//记录当前panel排版的位置
        for(LevelVO vo:list){
      	    JPanel showLevel=new showLevel(vo.getName(),vo.getLevel(),vo.getCreditNeeded(),90,position,420,height);
        	JButton delete=new MJButton(190,height-40,70,40,deleteIcon);
            delete.addActionListener(new ActionListener(){
    			@Override
    			public void actionPerformed(ActionEvent e) {
                    list.remove(vo);

                    refresh();
    			}
             });
            showLevel.add(delete);
        	position+=height;
        	panel.add(showLevel);

        }
        this.revalidate();
        this.repaint();
	}


	public List<LevelVO> getLevel(){
		List<LevelVO> d=list;
		list=new ArrayList<LevelVO>();
		return d;

	}

}
