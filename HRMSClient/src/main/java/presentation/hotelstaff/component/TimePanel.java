package presentation.hotelstaff.component;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TimePanel extends JPanel{

	private static final long serialVersionUID = 1L;

	Calendar c=Calendar.getInstance();
	private JTextField yearField=new TextField(
			String.valueOf(c.get(Calendar.YEAR)),10,0,70,40,4);
	private JTextField monthField=new TextField(
			String.valueOf(c.get(Calendar.MONTH)),95,0,40,40,2);
	private JTextField dateField=new TextField(
			String.valueOf(c.get(Calendar.DATE)),150,0,40,40,2);
	private JTextField hourField=new TextField(
			String.valueOf(c.get(Calendar.HOUR_OF_DAY)),210,0,40,40,2);
	private JTextField minuteField=new TextField(
			String.valueOf(c.get(Calendar.MINUTE)),270,0,40,40,2);

	public TimePanel(int x,int y,int w,int h){
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		this.add(yearField);
		this.add(monthField);
		this.add(dateField);
		this.add(hourField);
		this.add(minuteField);
	}

	public void setTime(int year,int month,int date,int hour,int minute){
		this.yearField.setText(""+year);
		this.monthField.setText(""+(month+1)%12);
		this.dateField.setText(""+date);
		this.hourField.setText(""+hour);
		this.minuteField.setText(""+minute);
	}
	public Calendar getTime(){
		int year=Integer.parseInt(yearField.getText());
		int month=Integer.parseInt(monthField.getText());
		int date=Integer.parseInt(dateField.getText());
		int hour=Integer.parseInt(hourField.getText());
		int minute=Integer.parseInt(minuteField.getText());
		Calendar c=Calendar.getInstance();
		c.set(year,month,date,hour,minute);
		return c;
	}
}
























