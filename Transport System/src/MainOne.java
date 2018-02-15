import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException; 
import java.io.IOException;
import javax.swing.*;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**********************************/
public class MainOne extends JFrame implements ActionListener{
	JButton register,login,back;
	Login login1;
	Register register1;
	MainScreen back1;
	
/**********************************/

	public MainOne() {
		
		setTitle("Tourist Train Journey Management");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon img = new ImageIcon("./image/BG11.png");
		ImageIcon loginImg=new ImageIcon("./image/login.png");
		ImageIcon registerImg=new ImageIcon("./image/register.png");
		ImageIcon backImg=new ImageIcon("./image/back1.png");
		
		JLabel imgLabel = new JLabel(img);
		login= new JButton(loginImg);
		login.setBounds(145,252,155,44);//setBounds(x,y,width,height)
		login.setBorderPainted(false);
		register = new JButton(registerImg);
		register.setBounds(678,252,209,39);
		register.setBorderPainted(false);
		back = new JButton(backImg);
		back.setBounds(925,518,119,59);
		back.setBorderPainted(false);

		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		Container cp=this.getContentPane();
		((JPanel)cp).setOpaque(false);
		
		login.addActionListener(this);
		register.addActionListener(this);
		back.addActionListener(this);

		this.getLayeredPane().add(login, new Integer(Integer.MAX_VALUE)); 
		this.getLayeredPane().add(register, new Integer(Integer.MAX_VALUE)); 
		this.getLayeredPane().add(back, new Integer(Integer.MAX_VALUE)); 

		this.pack();
		this.setLocation(200, 200);
		this.setSize(1107,678);//setSize(width,height)
		this.setVisible(true);	
	}
	/***********************************************************/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){
			login1 = new Login();
			this.setVisible(false);
		}

		if(e.getSource()== register){
			register1 = new Register();
		}
		if(e.getSource()== back){
			back1 = new MainScreen();
			this.setVisible(false);
		}
	}	
	
	
}
