import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



/**********************************/
public class Driver extends JFrame implements ActionListener{
	JButton back;
	MainTwo back1;
	JTextArea time;
	JTable table;
	ArrayList<Driverclass> driverList = new ArrayList<Driverclass>();
	
/**
 * @throws IOException ********************************/

	public Driver() throws IOException {
		init();
	}

	public void init() throws IOException{
		setTitle("Tourist Train Journey Management");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("./image/BGd1.png");
		ImageIcon backImg=new ImageIcon("./image/back.png");

		JLabel imgLabel = new JLabel(img);
		back= new JButton(backImg);
		back.setBounds(835,482,175,72);
		back.setBorderPainted(false);
		time = new JTextArea();
		time.setBounds(650, 30, 400, 100);
		time.setOpaque(false);
		time.setEditable(false);
		time.getCaret().setVisible(false);
		time.setForeground(Color.WHITE);
		Font font=new Font("Adobe Hebrew",Font.PLAIN,30);
		time.setFont(font);
				

		//Add the components in the Pane
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		Container cp=this.getContentPane();
		((JPanel)cp).setOpaque(false);
		back.addActionListener(this);
		this.getLayeredPane().add(back, new Integer(Integer.MAX_VALUE)); 
		
		//creat table
		table = new JTable(1,5);	
		table.setBounds(55, 150, 900, 900);
		table.setOpaque(false);
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//words stay in center!
		render.setOpaque(false);
		table.setDefaultRenderer(Object.class, render);
		table.setEnabled(false);
		table.setGridColor(Color.LIGHT_GRAY);//border's color 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(40); 
		table.setForeground(Color.white);//word's color
		table.setFont(new Font("Adobe Hebrew", Font.PLAIN, 25));
		FileService fileService = new FileService();
		//SET TABLE
		String temp = null; 
		String[] ss= null;
		BufferedReader br = new BufferedReader(new FileReader(new File (".//Record//driverInfo.txt")));
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        ArrayList<Journeyclass> journeyList = fileService.jouneryFile();	
        
		while((temp = br.readLine())!=null){
			String[] temp1 = temp.split(",");
			driverList.add(new Driverclass(temp1[0],temp1[1]));       
		}
        for(int i = 0;i<driverList.size();i++){
    	  	System.out.println(""+driverList.get(i).toString());
      	}
        
        for(int j = 0;j<driverList.size();j++){
	        for(int i = 0;i<journeyList.size();i++){
	    	  	if (driverList.get(j).state.equals("work")&&journeyList.get(i).driverName.equals(driverList.get(j).driverName)){
	    	  		System.out.println(driverList.get(j).driverName+" "+journeyList.get(i).trainName+" "+journeyList.get(i).route);
	    	  		String[] tablecontent = {journeyList.get(i).driverName,driverList.get(j).state,journeyList.get(i).journeyName,journeyList.get(i).trainName,journeyList.get(i).route};
	    	  		tableModel.addRow(tablecontent);
	    	  		table.invalidate();
	    	  	}
	      	}
	        if(driverList.get(j).state.equals("idle"))
    	  	{
    	  		String[] tablecontent = {driverList.get(j).driverName,driverList.get(j).state};
    	  		tableModel.addRow(tablecontent);
    	  		table.invalidate();
    	  	}
        }
		
		this.getLayeredPane().add(table,new Integer(Integer.MAX_VALUE) );  
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
			back1 = new MainTwo();
			this.setVisible(false);
		}

	}	
	
}

	