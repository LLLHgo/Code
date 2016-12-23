package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.client.controller.SearchPanelController;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;

public class SearchPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon = null;
	private JTextField searchField;
	private SearchButton searchButton;
	private Button historyButton;
	private Button sortButton;
	private JComboBox<String> areabox;
	private JComboBox<String> roombox;
	private JComboBox<String> starbox;
	private JComboBox<String> sortbox;
	private HotelSearchListPane hslp;
	private JPanel Panel;
	private JFrame frame;
	ClientVO client;
	private SearchPanelController controller;
	public SearchPanel(ClientVO client,JFrame frame,SearchPanelController controller){
		this.client=client;
		Panel=new JPanel();
		this.frame=frame;
		this.controller=controller;
		ArrayList<HotelinfoVO>list=new ArrayList<HotelinfoVO>();
		hslp=new HotelSearchListPane(frame,list);
		frame.add(hslp);

		historyButton=new Button("image/history.png",10,25);
		this.add(historyButton);
		sortButton=new Button("image/sort.png",60,25);
		sortButton.addActionListener(new sortButtonListener());
		this.add(sortButton);

		sortbox=new JComboBox<String>();
		sortbox.setOpaque(false);
		sortbox.addItem("按星级");
		sortbox.addItem("按评分");
		sortbox.addItem("按价格");
		sortbox.setBounds(0,35,110,20);
		sortbox.setVisible(false);
		sortbox.addItemListener(new ItemListener() {
			@Override
		      public void itemStateChanged(final ItemEvent e) {
		        int index = sortbox.getSelectedIndex();
		        if (index != 0) { // ==0表示选中的事第一个
		          String content = sortbox.getSelectedItem().toString();
		          System.out.println("index222="
		              + index + ", content=" + content);
		          sortbox.setVisible(false);
		          sortButton.setVisible(true);
		          historyButton.setVisible(true);
		        }
		      }

		    });
		this.add(sortbox);

		areabox=new JComboBox<String>();
		areabox.addItem("全部商圈");
		areabox.addItem("栖霞区");
		areabox.addItem("新街口");
		areabox.setBounds(100,15,110,20);
		this.add(areabox);

		roombox=new JComboBox<String>();
		roombox.addItem("全部房间");
		roombox.addItem("标准间");
		roombox.addItem("大床房");
		roombox.addItem("商务间");
		roombox.setBounds(100,35,110,20);
		this.add(roombox);
		starbox=new JComboBox<String>();
		starbox.addItem("全部星级");
		starbox.addItem("三星级以下");
		starbox.addItem("四星级");
		starbox.addItem("五星级");
		starbox.addItem("六星级");
		starbox.addItem("七星级");
		starbox.setBounds(100,55,110,20);
		this.add(starbox);

		imageIcon = new ImageIcon(this.getClass().getResource("image/searchPanel.png"));
		searchField=new JTextField();
		searchButton=new SearchButton();
		searchButton.setBounds(625,15,60,60);
		searchButton.addActionListener(new searchButtonListener());
		searchField.setBounds(252, 18, 350, 50);
		searchField.setBorder(new EmptyBorder(0,0,0,0));
		searchField.setFont(new java.awt.Font("微软雅黑", 4,  25));
		searchField.setForeground(Color.WHITE);
		searchField.setOpaque(false);
		searchField.setFocusable(true);
		this.add(searchButton);
		this.add(searchField);
		this.setVisible(false);
	    this.setLayout(null);
	    this.setSize(704, 502);
	    this.setOpaque(false);

	}
	public void setvisible(boolean flag){
		this.setVisible(flag);
		if(!flag)
		hslp.setVisible(flag);

	}

	private class sortButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			sortbox.setVisible(true);
			sortButton.setVisible(false);
	        historyButton.setVisible(false);
		}

	}
	private class searchButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String info=searchField.getText();
			//ArrayList<HotelinfoVO>list=new ArrayList<HotelinfoVO>();
			//list.add(HotelinfoDataTool.hotelinfoVO1);
			//hslp.change(list);
			hslp.change(controller.getBasicinfoList(info));
			hslp.setVisible(true);
			hslp.repaint();
			hslp.revalidate();
			frame.repaint();
			frame.revalidate();
		}

	}
	private class HotelSearchListPane extends JScrollPane{
		private static final long serialVersionUID = 1L;

		public HotelSearchListPane(JFrame frame,ArrayList<HotelinfoVO> list){
			super(Panel);
			if(list!=null){
			Panel.setLayout(null);
		    Panel.setPreferredSize(new Dimension(600,list.size()));
		    Panel.setBounds(0,0,1000,4000);
		    Panel.setOpaque(false);


		   this.setBounds(320, 170, 920, 400);
		   this.setOpaque(false);
		   this.getViewport().setOpaque(false);
		   this.getVerticalScrollBar().setVisible(false);
		   this.setBorder(new EmptyBorder(0,0,0,0));
		   this.setVisible(false);
		    for(int i=0;i<list.size();i++){
		    	HotelinfoVO vo=list.get(i);
		    	HotelSearchItemPanel p=new HotelSearchItemPanel(0, i*100,vo);
		    	 //p.setBounds(0,i*100,600,100);
		    	p.vb.addActionListener(new ActionListener(){
		    		public void actionPerformed(ActionEvent e) {
		    			new HotelDetailFrame(client,controller,vo);
		    		}
		    		});
		    	 Panel.add(p);
		    }
		    this.getVerticalScrollBar().setVisible(false);

		}
		}
	public void change(ArrayList<HotelinfoVO> list){
		Panel.removeAll();
		if(list!=null)
			 for(int i=0;i<list.size();i++){
			    	HotelinfoVO vo=list.get(i);
			    	HotelSearchItemPanel p=new HotelSearchItemPanel(0, i*100,vo);
			    	 //p.setBounds(0,i*100,600,100);
			    	p.vb.addActionListener(new ActionListener(){
			    		public void actionPerformed(ActionEvent e) {
			    			new HotelDetailFrame(client,controller,vo);
			    		}
			    		});
			    	 Panel.add(p);
			    }
			    this.getVerticalScrollBar().setVisible(false);

			    this.repaint();
	}
	}
	class Button extends JButton{
		private static final long serialVersionUID = 1L;
		ImageIcon icon;
		public Button(String add,int x,int y){
		icon=new ImageIcon(this.getClass().getResource(add));
		this.setIcon(icon);
		this.setOpaque(true);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setBounds(x,y,40,40);
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }

}
