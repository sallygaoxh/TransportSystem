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
import javax.swing.text.View;


/**********************************/
public class MainTwo extends JFrame implements ActionListener{
	JButton route, train, driver,back;
	Route route1;
	Train train1;
	Driver driver1;
	MainScreen back1;
	
/**********************************/

	public MainTwo() {
		
		setTitle("Tourist Train Journey Management");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(".//image//BG22.png");
		ImageIcon routeImg=new ImageIcon(".//image//route.png");//Route
		ImageIcon trainImg=new ImageIcon(".//image//train.png");//Train
		ImageIcon driverImg=new ImageIcon(".//image//driver1.png");//Driver 
		ImageIcon backImg=new ImageIcon(".//image//back2.png");//Route
		
		JLabel imgLabel = new JLabel(img);
		route= new JButton(routeImg);
		route.setBounds(70,230,260,81);
		route.setBorderPainted(false);
		
		train = new JButton(trainImg);
		train.setBounds(392,230,244,74);
		train.setBorderPainted(false);
		
		
		
		driver = new JButton(driverImg);
		driver.setBounds(688,230,273,66);
		driver.setBorderPainted(false);
		
		back = new JButton(backImg);
		back.setBounds(911,515,113,87);
		back.setBorderPainted(false);

		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		Container cp=this.getContentPane();
		((JPanel)cp).setOpaque(false);
		
		route.addActionListener(this);
		train.addActionListener(this);
		driver.addActionListener(this);
		back.addActionListener(this);

		this.getLayeredPane().add(route, new Integer(Integer.MAX_VALUE)); 
		this.getLayeredPane().add(train, new Integer(Integer.MAX_VALUE));
		this.getLayeredPane().add(driver, new Integer(Integer.MAX_VALUE));
		this.getLayeredPane().add(back, new Integer(Integer.MAX_VALUE)); 
		
		this.pack();
		this.setLocation(200, 200);
		this.setSize(1050,678);
		this.setVisible(true);	
	}

	/***********************************************************/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==route){
			try {
				route1 = new Route();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
		}

		if(e.getSource()== train){
			try {
				train1 = new Train();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
		}
		
		if(e.getSource()== driver){
			try {
				driver1 = new Driver();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
		}
		if(e.getSource()== back){
			back1 = new MainScreen();
			this.setVisible(false);
		}
	}	
	
	
}
