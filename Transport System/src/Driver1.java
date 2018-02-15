import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



/**********************************/
public class Driver1 extends JFrame implements ActionListener{
	JButton back,start,stop;
	MainScreen back1;
	JTextArea time,state;
	JTable table;
	
/**
 * @throws IOException ********************************/

	public Driver1(User user) throws IOException {
		init(user);
	}

	public void init(User user) throws IOException{
		//update file
		FileService fileService = new FileService();
		String temp = null;
		String[] ss= null;
		ImageIcon img; 
		BufferedReader br = new BufferedReader(new FileReader(new File (".//Record//driverInfo.txt")));	      
        ArrayList<Journeyclass> journeyList = fileService.jouneryFile();		        
        ArrayList<Driverclass> driverList = new ArrayList<Driverclass>();
        
        while((temp = br.readLine())!=null){
			String[] temp1 = temp.split(",");
			
	        if(temp1[0].equals(user.getUserName())){
	        	driverList.add(new Driverclass(temp1[0],temp1[1]));
	        	System.out.println(""+driverList.get(0).toString());
	    	}
        }
        
		setTitle("Tourist Train Journey Management");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (driverList.get(0).state.equals("work")){
			img = new ImageIcon(".//image//BGd2.png");//改一下图片路径！（背景）
		}else
			img = new ImageIcon(".//image//BGd1.png");//改一下图片路径！（背景）
		ImageIcon backImg=new ImageIcon(".//image//back.png");//（Back）
		ImageIcon startImg=new ImageIcon(".//image//start2.png");//（start）
		ImageIcon stopImg=new ImageIcon(".//image//stop2.png");//（stop）

		JLabel imgLabel = new JLabel(img);
		back= new JButton(backImg);
		back.setBounds(835,482,175,72);
		back.setBorderPainted(false);
		back.addActionListener(this);

		time = new JTextArea();
		time.setBounds(655, 30, 400, 100);
		time.setOpaque(false);
		time.setEditable(false);
		time.getCaret().setVisible(false);
		time.setForeground(Color.WHITE);
		Font font=new Font("黑体",Font.PLAIN,30);
		time.setFont(font);
		
				

		//Add the components in the Pane
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		Container cp=this.getContentPane();
		((JPanel)cp).setOpaque(false);
		
		this.getLayeredPane().add(back, new Integer(Integer.MAX_VALUE));  		
		
		//set table
		table = new JTable(1,5);	
		table.setBounds(60, 150, 900, 900);
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
		table.setFont(new Font("Adobe Hebrew", Font.PLAIN, 25));
				
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);

		        
        for(int i = 0;i<journeyList.size();i++){
    	  	if (driverList.get(0).state.equals("work")&&journeyList.get(i).driverName.equals(driverList.get(0).driverName)){
    	  		String[] tablecontent = {journeyList.get(i).driverName,driverList.get(0).state,journeyList.get(i).journeyName,journeyList.get(i).trainName,journeyList.get(i).route};
    	  		tableModel.addRow(tablecontent);
    	  		table.invalidate();
    			start= new JButton(startImg);
    			start.setBounds(455,462,112,95);
    			start.setBorderPainted(false);
    			
    			stop= new JButton(stopImg);
    			stop.setBounds(565,467,97,89);
    			stop.setBorderPainted(false);
    			
    			start.addActionListener(this);
    			stop.addActionListener(this);
    			
    			state = new JTextArea();
    			state.setBounds(300, 300, 400, 100);
    			state.setOpaque(false);
    			state.setEditable(false);
    			state.setForeground(Color.WHITE);
    			//Font font=new Font("黑体",Font.PLAIN,30);
    			state.setFont(font);
    			state.setText("Train State: In Service");
    			
    	  		this.getLayeredPane().add(start, new Integer(Integer.MAX_VALUE)); 
    			this.getLayeredPane().add(stop, new Integer(Integer.MAX_VALUE));
    			this.getLayeredPane().add(state, new Integer(Integer.MAX_VALUE));
    			break;
    	  	}else{
    	  		String[] tablecontent1 = {driverList.get(0).driverName,"idle","null","null","null"};
    	  		System.out.println(tablecontent1.toString());
    	  		tableModel.addRow(tablecontent1);
    	  		table.invalidate();
    	  		break;
    	  	}
        }
				
		this.getLayeredPane().add(table,new Integer(Integer.MAX_VALUE) );
		//Timer 
	    final JTextArea varTime = time;   
	    Timer timeAction = new Timer(1000, new ActionListener() {          
	     public void actionPerformed(ActionEvent e) {       
	    	 long timemillis = System.currentTimeMillis();   
	          
	         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	         varTime.setText(df.format(new Date(timemillis)));   
	         	}      
	         });            
	    timeAction.start();  
		this.getLayeredPane().add(time, new Integer(Integer.MAX_VALUE));  

		br.close();
		this.pack();
		this.setLocation(200, 200);
		this.setSize(1050,626);
		this.setVisible(true);	
	}
	
	/***********************************************************/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back){
			back1 = new MainScreen();
			this.setVisible(false);
		}
		if(e.getSource()==start){
			state.setText("Train State: In Service");
		}
		if(e.getSource()==stop){
			state.setText("Train State: Stop");
		}

	}	
	
}

	