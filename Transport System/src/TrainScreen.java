import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Color;
import java.io.IOException;
import java.lang.invoke.VolatileCallSite;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.ComponentOrientation;

public class TrainScreen extends JFrame implements ActionListener{

	private JPanel contentPane;
	volatile boolean stop; 
	volatile int count,count1;
	volatile Calendar startTime;
	JButton button;
	Train train1;

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public TrainScreen(String trainName) throws IOException, InterruptedException {
		FileService fileService = new FileService();
		ArrayList<Journeyclass> journeyList = fileService.jouneryFile();
		final ArrayList<Integer> interval = new ArrayList<Integer>();
		ArrayList<Routeclass> routeList = fileService.routeFile();
		final ArrayList<String> timetable = new ArrayList<String>();
		final ArrayList<String> stations = new ArrayList<String>();
		startTime = Calendar.getInstance();
		String routeName = "";
		for(int i = 0;i<journeyList.size();i++){
			if(trainName.equals(journeyList.get(i).trainName)){
				timetable.addAll(journeyList.get(i).timetable);
				routeName = journeyList.get(i).route;
				startTime = journeyList.get(i).startTime;
				stations.add("Center");
				stations.addAll(journeyList.get(i).stations);
				for(int j = journeyList.get(i).stations.size()-2;j>=0;j--){
					stations.add(journeyList.get(i).stations.get(j));
				}
				stations.add("Center");
			}
		}
		
		for(int i = 0; i<routeList.size();i++){
			if(routeList.get(i).routeName.equals(routeName)){
				
				interval.addAll(routeList.get(i).interval);
				for(int j = 0 ; j<routeList.get(i).interval.size();j++)
					interval.add(routeList.get(i).interval.get(routeList.get(i).interval.size()-j-1));
				break;
			}
		}
		System.out.println (routeName+","+interval.toString());
		count = stations.size();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setOpaque(true);
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(152, 106, 519, 237);
		contentPane.add(label_1);
		
		final JTextArea title = new JTextArea();
		title.setEditable(false);
		title.setOpaque(false);
		title.setFont(new Font("Adobe Hebrew", Font.BOLD, 28));
		title.setText("LED Screen On "+trainName);
		title.setBounds(244, 47, 337, 37);
		title.setText("State: on service");
		title.setForeground(Color.BLACK);
		contentPane.add(title);
	   
		
		button = new JButton("Back");
		button.setBackground(new Color(240, 240, 240));
		button.setOpaque(false);
		button.addActionListener(this);
		button.setFont(new Font("Adobe Hebrew", Font.BOLD, 24));
		button.setBounds(654, 411, 153, 37);
		contentPane.add(button);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(Color.WHITE);
		textArea.setOpaque(false);
		textArea.setBounds(0, 40, 519, 197);
		textArea.setFont(new Font("Adobe Hebrew", Font.BOLD, 24));
		textArea.setText("Leaving from the Center stop at "+ timetable.get(0));
		label_1.add(textArea);
		
	    final JTextArea varTime = textArea;   
	    final Timer timeAction = new Timer(2500, new ActionListener() {          
	     public void actionPerformed(ActionEvent e) {       
	    	 	String content = "Leaving from Station " + stations.get(stations.size()-count)+"\r\n"+
	    	 					 "The next stop is "+ stations.get(stations.size()-count+1)+"\r\n"+
	    	 					 "We will arrive at "+timetable.get(stations.size()-count+1)+"\r\n";	 
	    	 	varTime.setText(content);
	    	 	count--;
	         	}      
	         });            
	    timeAction.start();   
	    
		JButton btnNewButton = new JButton();
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setIcon(new ImageIcon(".//image//stop.png"));
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);	
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				timeAction.stop(); 
				title.setText("State: stop");
			}
		});
		btnNewButton.setBounds(289, 377, 77, 71);
		btnNewButton.setFont(new Font("Adobe Hebrew", Font.BOLD, 24));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(".//image//start1.png"));
		btnNewButton_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				timeAction.start(); 
				title.setText("State: in service");
			}
		});
		btnNewButton_1.setBounds(440, 377, 77, 71);
		btnNewButton_1.setFont(new Font("Adobe Hebrew", Font.BOLD, 24));
		contentPane.add(btnNewButton_1);
	  this.pack();
	  this.setSize(1027,590);
	  this.setLocation(200, 200);
	  this.setVisible(true);
		
	}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button){
				try {
					train1= new Train();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.setVisible(false);
			}
		}
}