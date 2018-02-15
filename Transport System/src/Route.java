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
import javax.swing.table.TableColumn;
import javax.swing.text.SimpleAttributeSet;  


/**********************************/
//@SuppressWarnings("serial")
public class Route extends JFrame implements ActionListener{
	JButton back,assign,ttable;
	MainTwo back1;
	Assign assign1;
	Route1 route1;
	JTextArea time;
	JTable table;
	ArrayList<JButton> buttonList = new ArrayList<JButton>();
	ArrayList<Routeclass> routeList = new ArrayList<Routeclass>();
	
/**
 * @throws IOException ********************************/

	public Route() throws IOException {
		init();
	}
	
	public void init() throws IOException {
		setTitle("Tourist Train Journey Management");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("./image/BG33.png");
		ImageIcon backImg=new ImageIcon("./image/back.png");
		ImageIcon assignImg=new ImageIcon("./image/assign.png");

		Container cp=this.getContentPane();
		((JPanel)cp).setOpaque(false);
		JLabel imgLabel = new JLabel(img);
		back= new JButton(backImg);
		back.setBounds(835,482,175,72);
		back.setBorderPainted(false);
		assign= new JButton(assignImg);
		assign.setBounds(620,491,176,64);
		assign.setBorderPainted(false);
		
		//set current time
		time = new JTextArea();
		time.setBounds(650, 30, 400, 100);
		time.setOpaque(false);
		time.setEditable(false);
		time.getCaret().setVisible(false);
		time.setForeground(Color.WHITE);
		Font font=new Font("黑体",Font.PLAIN,30);
		time.setFont(font);
		
		//set table
		table = new JTable(3,3);	
		table.setBounds(200, 100, 500, 500);
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
		table.setFont(new Font("Adobe Hebrew", Font.PLAIN, 28));
		
		//Add the components in the Pane
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		back.addActionListener(this);
		assign.addActionListener(this);
		this.getLayeredPane().add(back, new Integer(Integer.MAX_VALUE)); 
		this.getLayeredPane().add(assign, new Integer(Integer.MAX_VALUE)); 
		 
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

		String temp = null; 
		String[] ss= null;
		BufferedReader br = new BufferedReader(new FileReader(new File (".//Record//Route.txt")));            
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        int count = 0;
       
		//读取表格第一行的 title
        String title = br.readLine();
		ss= title.split(",");
        tableModel.addRow(ss);
        table.invalidate();
        
        while((temp = br.readLine())!=null){
			
			ss= temp.split(",");			
            tableModel.addRow(ss);
            String[] routeMsg = temp.split(",");
            String[] stations = routeMsg[1].split(" ");
            table.invalidate();
            count++;
		}
		
		for(int i = 1;i<=count;i++){
			buttonList.add(new JButton());
			buttonList.get(i-1).setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
			buttonList.get(i-1).setContentAreaFilled(false);
			buttonList.get(i-1).setBorderPainted(false);
			buttonList.get(i-1).setForeground(Color.gray);
			buttonList.get(i-1).setName("Route"+(i));
			buttonList.get(i-1).setText("R"+(i));
			buttonList.get(i-1).addActionListener(this);
			buttonList.get(i-1).setBounds(235,164+(i-1)*60,100,45);
			this.getLayeredPane().add(buttonList.get(i-1), new Integer(Integer.MAX_VALUE)); 
		}
		br.close();
		this.getLayeredPane().add(table,new Integer(Integer.MAX_VALUE) );
		
		
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
		if(e.getSource()==assign){
			try {
				assign1 = new Assign();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
		}

		for(int i = 0;i<buttonList.size();i++){
			if(e.getSource()==buttonList.get(i)){
				try {
					route1 = new Route1("R"+(i+1));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.setVisible(false);
			}
		}

	}	
	
}

	