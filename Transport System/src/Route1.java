import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
import javax.swing.JScrollPane;  
import javax.swing.JTable;  
import javax.swing.ListSelectionModel;  
import javax.swing.UIManager;  
import javax.swing.table.DefaultTableCellRenderer;  
import javax.swing.table.JTableHeader;  
import javax.swing.table.TableCellRenderer;
import javax.swing.text.SimpleAttributeSet;  


/**********************************/
//@SuppressWarnings("serial")
public class Route1 extends JFrame implements ActionListener{
	JButton back,screen;
	Route back1;
	StationScreen stationScreen ;
	JTextArea time;
	JTextArea routeNo;
	JTable table;
	String route;
	
/**
 * @throws IOException ********************************/

	public Route1(String route) throws IOException {
		
		init(route);
	}
	
	public Route1() {
	// TODO Auto-generated constructor stub
}

	public void init(String route) throws IOException {
		this.route = route;
		setTitle("Tourist Train Journey Management");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(".//image//BG341.png");
		ImageIcon backImg=new ImageIcon(".//image//back.png");
		ImageIcon screenImg=new ImageIcon(".//image//screen.png");

		Container cp=this.getContentPane();
		((JPanel)cp).setOpaque(false);
		JLabel imgLabel = new JLabel(img);
		back= new JButton(backImg);
		back.setBounds(835,482,175,72);
		back.setBorderPainted(false);
		screen= new JButton(screenImg);
		screen.setBounds(614,491,215,62);
		screen.setBorderPainted(false);
		
		//set current time
		time = new JTextArea();
		time.setBounds(650, 30, 400, 100);
		time.setOpaque(false);
		time.setEditable(false);
		time.getCaret().setVisible(false);
		time.setForeground(Color.WHITE);
		Font font=new Font("黑体",Font.PLAIN,30);
		time.setFont(font);
		
	    routeNo = new JTextArea(route);
		routeNo.setBounds(200, 80, 400, 100);
		routeNo.setOpaque(false);
		routeNo.setEditable(false);
		routeNo.getCaret().setVisible(false);
		routeNo.setForeground(Color.WHITE);
		routeNo.setFont(font);
		this.getLayeredPane().add(routeNo, new Integer(Integer.MAX_VALUE));
		
		//Add the components in the Pane
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		back.addActionListener(this);
		screen.addActionListener(this);
		this.getLayeredPane().add(back, new Integer(Integer.MAX_VALUE)); 
		this.getLayeredPane().add(screen, new Integer(Integer.MAX_VALUE)); 
		
	    final JTextArea varTime = time;   
	    Timer timeAction = new Timer(1000, new ActionListener() {          
	     public void actionPerformed(ActionEvent e) {       
	    	 long timemillis = System.currentTimeMillis();   
	         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
	         varTime.setText(df.format(new Date(timemillis)));   
	         	}      
	         });            
	    timeAction.start();  
		this.getLayeredPane().add(time, new Integer(Integer.MAX_VALUE));  

		FileService fileService = new FileService();
		ArrayList<Journeyclass> journeyList = fileService.jouneryFile();
		ArrayList<Routeclass> routeList = fileService.routeFile();
		ArrayList<String> line1 = new ArrayList<String>();
		ArrayList<String> line2 = new ArrayList<String>();
        for (int i = 0;i<routeList.size();i++){
        	if(routeList.get(i).routeName.equals(route)){
        		line1.add("Journey");
        		line1.add("Center");
        		for (int m = 0;m<routeList.get(i).stations.size()-1;m++){
        			line1.add(routeList.get(i).stations.get(m));
        		}
        		for (int m = routeList.get(i).stations.size()-1;m>=0;m--){
        			line1.add(routeList.get(i).stations.get(m));
        		}
        		line1.add("Center");
        		break;
        	}
        }
        System.out.println(line1);
		//set table
		table = new JTable(0,line1.size());	
		table.setBounds(50, 150, 900, 900);
		table.setOpaque(false);
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//words stay in center!
		render.setOpaque(false);
		table.setDefaultRenderer(Object.class, render);
		table.setEnabled(false);
		table.setGridColor(Color.LIGHT_GRAY);//border's color 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(60); 
		table.setForeground(Color.white);//word's color
		table.setFont(new Font("Adobe Hebrew", Font.PLAIN, 26));
        String[] ss1 = (String[]) line1.toArray(new String[line1.size()]);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
        tableModel.addRow(ss1);
        table.invalidate(); 
		
        for (int i = 0;i<journeyList.size();i++){
        	if(journeyList.get(i).route.equals(route)){
        		line2.add(journeyList.get(i).journeyName);
        		line2.addAll(journeyList.get(i).timetable);
                String[] ss2 = (String[]) line2.toArray(new String[line2.size()]);
                System.out.println(line2.toString());
                tableModel.addRow(ss2);
                table.invalidate(); 
                line2.clear();
        	}
        }
        
          
		
		this.getLayeredPane().add(table,new Integer(Integer.MAX_VALUE) );
	
		this.pack();
		this.setLocation(200, 200);
		this.setSize(1050,626);
		this.setVisible(true);	
	}
	
	/***********************************************************/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back){
			try {
				back1 = new Route();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
		}
		if(e.getSource()==screen){
			try {
				stationScreen = new StationScreen(this.route);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
		}
		
	}	
	
}

	