package presentation.marketing.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vo.marketingVO.MarketingVO;

public class ProcessMarketingProfileView extends JPanel{
	private ProcessMarketingViewControllerService controller;
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,22);
	private Font font2=new Font("楷体",Font.ITALIC,20);
	private Font font3=new Font("微软雅黑",Font.HANGING_BASELINE,28);
	private Image newImage=null;
	private String MarketingID;
	private MarketingVO Mvo;
	public ProcessMarketingProfileView(ProcessMarketingViewControllerService controller,JPanel panel){
    	this.controller=controller;
    	this.MarketingID=controller.getMarketingID();
        this.Mvo=controller.init(MarketingID);
    	this.setBounds(200, 82, 704, 500);
    	this.setLayout(null);
    	this.setOpaque(false);

        //将五个Label加到panel上
        JLabel nameLabel =new JLabel("姓名");
        JLabel  accountLabel =new JLabel("账号");
        JLabel  TELLabel =new JLabel("TEL");
        JLabel passwordLabel=new JLabel("密码");
        JLabel photoLabel=new JLabel("头像");
        ArrayList<JLabel> labelList =new ArrayList<JLabel>();
        labelList.add(nameLabel);labelList.add(accountLabel);
        labelList.add(TELLabel);labelList.add(passwordLabel);labelList.add(photoLabel);
        int num=0;
        for(JLabel label:labelList){
        	label.setFont(font);
        	label.setForeground(Color.white);
        	label.setBounds(100, 40+num*80, 60, 60);
        	num++;
        	this.add(label);
        }

        // 设置JTextField
        JTextField nameField=new JTextField(Mvo.getName());
        JTextField accountField =new JTextField(MarketingID);
        JTextField TELField=new JTextField(Mvo.getTelephone());
        JTextField passwordField=new JTextField(Mvo.getPassword());
        ArrayList<JTextField> fieldList=new ArrayList<JTextField>();
        fieldList.add(nameField);fieldList.add(accountField);fieldList.add(TELField);fieldList.add(passwordField);
        num=0;
        for(JTextField field:fieldList){
        	field.setFont(font2);
        	field.setForeground(Color.black);
        	field.setBounds(250, 46+num*80, 200, 48);
        	field.setBackground(null);
        	field.setOpaque(false);
        	field.setBorder(new EmptyBorder(0,0,0,0));
        	field.setEditable(false);
        	num++;
        	this.add(field);
        }

        //设置TELmodify图标与监听
        Icon modifyIcon=new ImageIcon("./src/main/resource/picture/marketing/modify.png");
        JLabel modifyLabelForTEL=new JLabel();
        modifyLabelForTEL.setBounds(550, 215, 60, 60);
        modifyLabelForTEL.setIcon(modifyIcon);
        modifyLabelForTEL.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				TELField.setEditable(true);
				JLabel TELBackgroundLabel=new JLabel();
				TELBackgroundLabel.setBounds(210, 225, 200, 250);
				Icon TELBackground=new ImageIcon("./src/main/resource/picture/marketing/fieldBackground.png");
				TELBackgroundLabel.setIcon(TELBackground);
				//this.add(TELBackgroundLabel);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}

        });
        this.add(modifyLabelForTEL);

        //设置Passwordmodify图标与监听
        JLabel modifyLabelForPassword=new JLabel();
        modifyLabelForPassword.setBounds(550, 293, 60, 60);
        modifyLabelForPassword.setIcon(modifyIcon);
        modifyLabelForPassword.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEditable(true);
				JLabel passwordBackgroundLabel=new JLabel();
				passwordBackgroundLabel.setBounds(210, 300, 300,400);
				Icon passwordBackground=new ImageIcon("./src/main/resource/picture/marketing/fieldBackground.png");
				passwordBackgroundLabel.setIcon(passwordBackground);
				//profilePanel.add(passwordBackgroundLabel);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}

        });
        this.add(modifyLabelForPassword);

        //加入头像监听
        Icon photoIcon=new ImageIcon("./src/main/resource/picture/marketing/addphoto.png");
        JLabel addphotoLabel=new JLabel();
        addphotoLabel.setIcon(photoIcon);

        //分为两种情况 有无设置头像
        if(Mvo.getImage()!=null){
        	Icon myphoto=new ImageIcon(Mvo.getImage());
        	JLabel myphotoLabel=new JLabel();
        	myphotoLabel.setIcon(myphoto);
        	myphotoLabel.setBounds(230,350, 200, 200);
        	this.add(myphotoLabel);
        	addphotoLabel.setBounds(400,375, 60, 60);
        }else{
            addphotoLabel.setBounds(325,375, 60, 60);
        }
        addphotoLabel.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				final JFileChooser fileChooser=new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fileChooser.showOpenDialog(null);
				File f=fileChooser.getSelectedFile();
				try {
					InputStream in=new FileInputStream(f);
					BufferedImage bi=ImageIO.read(in);
					newImage=(Image)bi;
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}

        });
        this.add(addphotoLabel);

        //加入确认图标
        Icon ensureIcon=new ImageIcon("./src/main/resource/picture/marketing/ensure.png");
        JLabel ensureLabel=new JLabel();
        ensureLabel.setBounds(300,445, 60, 60);
        ensureLabel.setIcon(ensureIcon);
        ensureLabel.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				String newTEL=TELField.getText(),newPassword=passwordField.getText();
                Mvo.setTelephone(newTEL);Mvo.setPassword(newPassword);
                if(newImage!=null)Mvo.setImage(newImage);
                controller.MarketingAccountUpdate(Mvo);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}

        });
        this.add(ensureLabel);
        this.repaint();
        panel.add(this);
	}


	public void profileButtonClicked() {
        this.setVisible(true);
        this.revalidate();
        this.repaint();
	}

    public void hideProfile(){
        this.setVisible(false);
    }
}
