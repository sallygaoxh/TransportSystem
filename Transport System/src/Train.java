import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
public class Train extends JFrame implements ActionListener{
	JButton back;
	MainTwo back1;
	JTextArea time;
	JTable table;
	ArrayList<JButton> buttonList = new ArrayList<JButton>();
	ArrayList<Trainclass>trainList = new ArrayList<Trainclass>();
	TrainScreen trainScreen;
	
/**
 * @throws IOException ********************************/

	public Train() throws IOException {
		init();
	}
	
	
	public void init() throws IOException {
		setTitle("Tourist Train Journey Management");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(".//image//BG34.png");//改一下图片路径！（背景）
		ImageIcon backImg=new ImageIcon(".//image//back.png");//（Back）

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
		Font font=new Font("黑体",Font.PLAIN,30);
		time.setFont(font);
				

		//Add the components in the Jpane
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		Container cp=this.getContentPane();
		((JPanel)cp).setOpaque(false);
		back.addActionListener(this);
		this.getLayeredPane().add(back, new Integer(Integer.MAX_VALUE)); 
		
		//set table
				table = new JTable(3,3);	
				table.setBounds(200, 70, 500, 500);
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
				table.setFont(new Font("Adobe Hebrew", Font.PLAIN, 28));

				//更新文件
				FileService fileService = new FileService();
				
				//锟斤拷锟斤拷锟斤拷锟�
				String temp = null; 
				String[] ss= null;
				BufferedReader br = new BufferedReader(new FileReader(new File (".//Record//train.txt")));            
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		        tableModel.setRowCount(0);
		        temp = br.readLine();
		        ss= temp.split(",");
		        tableModel.addRow(ss);
		        table.invalidate();
		        
		        int count = 0;
				while((temp = br.readLine())!=null){
					ss= temp.split(",");
					String[] trainMsg = temp.split(",");
					trainList.add(new Trainclass(trainMsg[0],trainMsg[1],trainMsg[2]));
		            tableModel.addRow(ss);
		            table.invalidate();
		            count++;
				}
		        ArrayList<Journeyclass> journeyList = fileService.jouneryFile();	
				
				for(int i = 0;i<count;i++){
					buttonList.add(new JButton());
					buttonList.get(i).setVisible(true);
					if(trainList.get(i).state.equals("idle")){		
					}else{
						buttonList.get(i).setFont(new Font("Adobe Hebrew", Font.BOLD, 28));
						buttonList.get(i).setContentAreaFilled(false);
						buttonList.get(i).setBorderPainted(false);
						buttonList.get(i).setForeground(Color.gray);
						buttonList.get(i).setName("T"+(i+1));
						buttonList.get(i).setText("T"+(i+1));
						buttonList.get(i).addActionListener(this);
						buttonList.get(i).setBounds(235,110+i*40,100,45);
						this.getLayeredPane().add(buttonList.get(i), new Integer(Integer.MAX_VALUE)); 
					}
				}
				br.close();
				this.getLayeredPane().add(table,new Integer(Integer.MAX_VALUE) );
				
				
		//设置Timer 1000ms实现一次动作 实际是一个线程     
	    final JTextArea varTime = time;   
	    Timer timeAction = new Timer(1000, new ActionListener() {          
	     public void actionPerformed(ActionEvent e) {       
	    	 long timemillis = System.currentTimeMillis();   
	         //转换日期显示格式   
	         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	         varTime.setText(df.format(new Date(timemillis)));   
	         	}      
	         });            
	    timeAction.start();  
		this.getLayeredPane().add(time, new Integer(Integer.MAX_VALUE));  

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
		for(int i = 0;i<buttonList.size();i++){
			if(e.getSource()==buttonList.get(i)){
				try {
					trainScreen = new TrainScreen("T"+(i+1));
					trainScreen.setVisible(true);
					//this.setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.setVisible(false);
			}
		}

	}	
	
}	

	