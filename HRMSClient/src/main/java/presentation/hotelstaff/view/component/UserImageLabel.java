package presentation.hotelstaff.view.component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class UserImageLabel extends JLabel{
	private ImageIcon user_image;
	
	public UserImageLabel(int x,int y){
		user_image = new ImageIcon("./src/main/resource/picture/hotelstaff/user_image.png");
		this.setIcon(user_image);
		this.setBounds(x, y, 97, 85);
	}
}
