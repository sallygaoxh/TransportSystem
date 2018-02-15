import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StationScreen extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextArea time_3;	
	String routeName;
	Route route;
	JButton btnNewButton;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public StationScreen(String routeName) throws IOException {
		init(routeName);
	}
	
	public void init (String routeName) throws IOException{
		this.routeName =  routeName;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		FileService fileService = new FileService();
		ArrayList<Routeclass> routeList = new ArrayList<Routeclass>();
		ArrayList<Journeyclass> journeyList = new ArrayList<Journeyclass>();
		ArrayList<ArrayList<String>> timetable = new ArrayList<ArrayList<String>>();
		ArrayList<Calendar> timeCalendars = new ArrayList<Calendar>();
		ArrayList<String> trainName = new ArrayList<String>();
		routeList = fileService.routeFile();
		journeyList = fileService.jouneryFile();
		
		//set  current time
		Calendar currentTime = Calendar.getInstance();
		System.out.println(df.format(currentTime.getTime()));
		ArrayList<String> stationList = new ArrayList<String>();

		for(int i = 0;i<routeList.size();i++){
			if (this.routeName.equals(routeList.get(i).routeName))
				stationList = routeList.get(i).stations;
		}
		
		for(int i = 0;i<journeyList.size();i++){
			if (this.routeName.equals(journeyList.get(i).route)){
				for(int j = 0;j<routeList.size();j++){
					if(journeyList.get(i).route.equals(routeList.get(j).routeName)){
						timetable.add(journeyList.get(i).timetable);
						trainName.add(journeyList.get(i).trainName);
						break;
					}		
				}
			}
		}
		String[][] timeStrings =  new String[timetable.size()][2];
		for(int i = 0; i<timetable.size();i++){
			for(int j=0;j<timetable.get(i).size();j++){
				timeStrings[i]=timetable.get(i).get(j).split(":");
			}			
		}
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1372, 1110);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(this);
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setFont(new Font("Adobe Hebrew", Font.BOLD, 28));
		btnNewButton.setBounds(1172, 999, 153, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblStop1 = new JLabel("Center");
		lblStop1.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		lblStop1.setBounds(234, 21, 153, 37);
		contentPane.add(lblStop1);
		
		JLabel lblStop2 = new JLabel("Stop: "+stationList.get(0));
		lblStop2.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		lblStop2.setBounds(998, 21, 98, 37);
		contentPane.add(lblStop2);
		
		JLabel lblStop3 = new JLabel("Stop: "+stationList.get(1));
		lblStop3.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		lblStop3.setBounds(234, 369, 98, 37);
		contentPane.add(lblStop3);
		
		JLabel lblStop4 = new JLabel("Stop: "+stationList.get(2));
		lblStop4.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		lblStop4.setBounds(998, 369, 98, 37);
		contentPane.add(lblStop4);
		
		JLabel label_stop4 = new JLabel("");
		label_stop4.setOpaque(true);
		label_stop4.setBackground(Color.BLACK);
		label_stop4.setBounds(798, 413, 519, 207);
		contentPane.add(label_stop4);
		
		JTextArea time_4 = new JTextArea();
		time_4.setOpaque(false);
		time_4.setForeground(Color.WHITE);
		time_4.setFont(new Font("∫⁄ÃÂ", Font.BOLD, 15));
		time_4.setBounds(0, 0, 519, 24);
		label_stop4.add(time_4);
		
		final JTextArea varTime2 = time_4;   
	    Timer timeAction2 = new Timer(1000, new ActionListener() {          
	     public void actionPerformed(ActionEvent e) {       
	    	 long timemillis = System.currentTimeMillis();   
	         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	         varTime2.setText(df.format(new Date(timemillis)));   
	         	}      
	         });            
	    timeAction2.start(); 
		
		JTextArea text_4 = new JTextArea();
		text_4.setOpaque(false);
		text_4.setForeground(Color.WHITE);
		text_4.setFont(new Font("∫⁄ÃÂ", Font.BOLD, 15));
		text_4.setBounds(0, 26, 519, 183);
		label_stop4.add(text_4);
		
		if(timetable.get(0).size()>7){
			String content4 = "The timetable of trains that will arrive at this stop:\r\n  Forward trains:\r\n";
			for(int i =0;i<timetable.size();i++){
				content4+="  Train Name: "+trainName.get(i)+" "+timetable.get(i).get(3)+"\r\n";
			}	
			content4+="  Backward trains:\r\n";
			for(int i =0;i<timetable.size();i++){
				content4+="  Train Name: "+trainName.get(i)+" "+timetable.get(i).get(timetable.get(0).size()-4)+"\r\n";
			}
			text_4.setText(content4);
		}else{
			String content4 = "The timetable of trains that will arrive and departure at this stop:\r\n";
			for(int i =0;i<timetable.size();i++){
				content4+="  Train Name: "+trainName.get(i)+" "+timetable.get(i).get(3)+"\r\n";
			}	
			text_4.setText(content4);
		}

		
		if(stationList.size()>3){
			JLabel lblStop5 = new JLabel("Stop: "+stationList.get(3));
			lblStop5.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
			lblStop5.setBounds(234, 729, 98, 37);
			contentPane.add(lblStop5);
			
			JLabel label_stop5 = new JLabel("");
			label_stop5.setOpaque(true);
			label_stop5.setBackground(Color.BLACK);
			label_stop5.setBounds(31, 772, 519, 207);
			contentPane.add(label_stop5);
			
			JTextArea time_5 = new JTextArea();
			time_5.setOpaque(false);
			time_5.setForeground(Color.WHITE);
			time_5.setFont(new Font("∫⁄ÃÂ", Font.BOLD, 15));
			time_5.setBounds(0, 0, 519, 24);
			label_stop5.add(time_5);
			
			final JTextArea varTime4 = time_5;   
			
			JTextArea text_5 = new JTextArea();
			text_5.setOpaque(false);
			text_5.setForeground(Color.WHITE);
			text_5.setFont(new Font("∫⁄ÃÂ", Font.BOLD, 15));
			text_5.setBounds(0, 26, 519, 183);
			label_stop5.add(text_5);
			
			String content5 = "The timetable of trains that will arrive and departure at this stop:\r\n";
			for(int i =0;i<timetable.size();i++){
				content5+="  Train Name: "+trainName.get(i)+" "+timetable.get(i).get(4)+"\r\n";
			}	
			text_5.setText(content5);
			
		    Timer timeAction4 = new Timer(1000, new ActionListener() {          
		     public void actionPerformed(ActionEvent e) {       
		    	 long timemillis = System.currentTimeMillis();   
		    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		         varTime4.setText(df.format(new Date(timemillis)));   
		         	}      
		         });            
		    timeAction4.start(); 
		    
		}

		
		JLabel label_stop1 = new JLabel("");
		label_stop1.setOpaque(true);
		label_stop1.setBackground(new Color(0, 0, 0));
		label_stop1.setBounds(31, 63, 519, 207);
		contentPane.add(label_stop1);
		
		JTextArea time_1 = new JTextArea();
		time_1.setOpaque(false);
		time_1.setForeground(Color.WHITE);
		time_1.setFont(new Font("∫⁄ÃÂ", Font.BOLD, 15));
		time_1.setBounds(0, 0, 519, 24);
		label_stop1.add(time_1);
		
		final JTextArea varTime = time_1;   
	    Timer timeAction = new Timer(1000, new ActionListener() {          
	     public void actionPerformed(ActionEvent e) {       
	    	 long timemillis = System.currentTimeMillis();   
	         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	         varTime.setText(df.format(new Date(timemillis)));   
	         	}      
	         });            
	    timeAction.start();
		
		JTextArea text_1 = new JTextArea();
		text_1.setOpaque(false);
		text_1.setForeground(Color.WHITE);
		text_1.setFont(new Font("∫⁄ÃÂ", Font.BOLD, 15));
		text_1.setBounds(0, 26, 519, 183);
		label_stop1.add(text_1);
		
		String content1 = "The timetable of trains that will departure at Center stop:\r\n";
		for(int i =0;i<timetable.size();i++){
			content1+="  Train Name: "+trainName.get(i)+" "+timetable.get(i).get(0)+"\r\n";
		}
		content1+="The backward trains will arrive at Center stop at :\r\n";
		for(int i =0;i<timetable.size();i++){
			content1+="  Train Name: "+trainName.get(i)+" "+timetable.get(i).get(timetable.get(0).size()-1)+"\r\n";
		}
		text_1.setText(content1);
		
		JLabel label_stop2 = new JLabel("");
		label_stop2.setOpaque(true);
		label_stop2.setBackground(Color.BLACK);
		label_stop2.setBounds(798, 63, 519, 207);
		contentPane.add(label_stop2);
		
		JTextArea time_2 = new JTextArea();
		time_2.setOpaque(false);
		time_2.setForeground(Color.WHITE);
		time_2.setFont(new Font("∫⁄ÃÂ", Font.BOLD, 15));
		time_2.setBounds(0, 0, 519, 24);
		label_stop2.add(time_2);
		
		final JTextArea varTime1 = time_2;   
	    Timer timeAction1 = new Timer(1000, new ActionListener() {          
	     public void actionPerformed(ActionEvent e) {       
	    	 long timemillis = System.currentTimeMillis();   
	         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	         varTime1.setText(df.format(new Date(timemillis)));   
	         	}      
	         });            
	    timeAction1.start(); 
		
		JTextArea text_2 = new JTextArea();
		text_2.setOpaque(false);
		text_2.setForeground(Color.WHITE);
		text_2.setFont(new Font("∫⁄ÃÂ", Font.BOLD, 15));
		text_2.setBounds(0, 26, 519, 183);
		label_stop2.add(text_2);
		
		String content2 = "The timetable of trains that will arrive at this stop:\r\n  Forward trains:\r\n";
		for(int i =0;i<timetable.size();i++){
			content2+="  Train Name: "+trainName.get(i)+" "+timetable.get(i).get(1)+"\r\n";
		}
		content2+="  Backward trains:\r\n";
		for(int i =0;i<timetable.size();i++){
			content2+="  Train Name: "+trainName.get(i)+" "+timetable.get(i).get(timetable.get(0).size()-2)+"\r\n";
		}
		text_2.setText(content2);
		
		JLabel label_stop3 = new JLabel("");
		label_stop3.setOpaque(true);
		label_stop3.setBackground(Color.BLACK);
		label_stop3.setBounds(31, 413, 519, 207);
		contentPane.add(label_stop3);
		
		time_3 = new JTextArea();
		time_3.setOpaque(false);
		time_3.setForeground(Color.WHITE);
		time_3.setFont(new Font("∫⁄ÃÂ", Font.BOLD, 15));
		time_3.setBounds(0, 0, 519, 24);
		label_stop3.add(time_3);
		
		final JTextArea varTime3 = time_3;   
	    Timer timeAction3 = new Timer(1000, new ActionListener() {          
	     public void actionPerformed(ActionEvent e) {       
	    	 long timemillis = System.currentTimeMillis();   
	         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	         varTime3.setText(df.format(new Date(timemillis)));   
	         	}      
	         });            
	    timeAction3.start(); 
		
		JTextArea text_3 = new JTextArea();
		text_3.setOpaque(false);
		text_3.setForeground(Color.WHITE);
		text_3.setFont(new Font("∫⁄ÃÂ", Font.BOLD, 15));
		text_3.setBounds(0, 26, 519, 183);
		label_stop3.add(text_3);

		String content3 = "The timetable of trains that will arrive at this stop:\r\n  Forward trains:\r\n";
		for(int i =0;i<timetable.size();i++){
			content3+="  Train Name: "+trainName.get(i)+" "+timetable.get(i).get(2)+"\r\n";
		}
		content3+="  Backward trains:\r\n";
		for(int i =0;i<timetable.size();i++){
			content3+="  Train Name: "+trainName.get(i)+" "+timetable.get(i).get(timetable.get(0).size()-3)+"\r\n";
		}
		text_3.setText(content3);
	
		  this.pack();
		  this.setLocation(200, 200);
		  this.setSize(1500,1200);
		  this.setVisible(true);
	
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton){
			try {
				route = new Route();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
		}
	}
}
