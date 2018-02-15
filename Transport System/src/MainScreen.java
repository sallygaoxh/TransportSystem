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
public class MainScreen extends JFrame implements ActionListener{
	JButton manager, driver;
	MainOne manager1;
	LogD driver1;
	
/**********************************/

	public MainScreen() {
		
		setTitle("Tourist Train Journey Management");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon img = new ImageIcon("./image/BG12.png");
		ImageIcon managerImg=new ImageIcon("./image/manager.png");
		ImageIcon driverImg=new ImageIcon("./image/driver.png");
		
		JLabel imgLabel = new JLabel(img);
		manager= new JButton(managerImg);
		manager.setBounds(110,265,261,71);//setBounds(x,y,width,height)
		manager.setBorderPainted(false);
		driver = new JButton(driverImg);
		driver.setBounds(705,270,211,52);
		driver.setBorderPainted(false);

		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		Container cp=this.getContentPane();
		((JPanel)cp).setOpaque(false);
		
		manager.addActionListener(this);
		driver.addActionListener(this);

		this.getLayeredPane().add(manager, new Integer(Integer.MAX_VALUE)); 
		this.getLayeredPane().add(driver, new Integer(Integer.MAX_VALUE)); 

		this.pack();
		this.setLocation(200, 200);
		this.setSize(1107,678);//setSize(width,height)
		this.setVisible(true);	
	}
	
	/***********************************************************/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==manager){
			manager1 = new MainOne();
			this.setVisible(false);
		}

		if(e.getSource()== driver){
			driver1 = new LogD();
			this.setVisible(false);
		}
	}	
	
	
}