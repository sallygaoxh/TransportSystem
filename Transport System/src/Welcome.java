import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Welcome extends Thread {
	
	private JFrame jf;
	private Container con;
	private JPanel jp;
	private JLabel imgLabel;
	MainScreen mainone1;
	private static Welcome welcome;
	public static ArrayList<Driverclass> driverList = new ArrayList<Driverclass>();
	
	public Welcome(){
		init();
	}

	public void init(){
		jf = new JFrame("Tourist Train Journey Management");
		jp = new JPanel();
		ImageIcon img = new ImageIcon("./image/BG1.png");//��һ��ͼƬ·������������
		imgLabel = new JLabel(img);
		jf.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		con = jf.getContentPane();
		((JPanel)con).setOpaque(false);
		jf.setSize(1107,678);
		jf.setLocation(200, 200);
		jf.setVisible(true);
		try {
            Thread.sleep(3000);
            jf.setVisible(false);
            mainone1 = new MainScreen();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}


	public static void main(String[] args) throws IOException{
	
		welcome = new Welcome();
	}

}