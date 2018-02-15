import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.print.attribute.AttributeSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JSplitPane;
import javax.swing.UIManager;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;

import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;

import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//@SuppressWarnings("serial")
public class Assign extends JFrame implements ActionListener{

	private JPanel contentPane;
	JButton btnBack;
	private JLabel lbleghhmm;
	Route route1;
	ArrayList<Driverclass> driverList = new ArrayList<Driverclass>();
	ArrayList<Journeyclass> journeyList =  new ArrayList<Journeyclass>();
	ArrayList<String> timetable = new ArrayList<String>();
	ArrayList<Trainclass> trainList = new ArrayList<Trainclass>();
	private JTextField journeyNo;
	private JTextField startTime;
	private JTextField startMinute;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Assign() throws IOException{
		init();
	}
	
	public void init() throws IOException {
		final FileService fileService = new FileService();
		driverList = fileService.driverFile();
		trainList = fileService.trainFile();
		journeyList = fileService.jouneryFile();
		ArrayList<String> availableDriver = new ArrayList<String>();
		ArrayList<String> availableTrain = new ArrayList<String>();

	
		for(int i=0;i<driverList.size();i++){
			if(driverList.get(i).state.equals("idle")){
				availableDriver.add(driverList.get(i).driverName);
			}
		}
		for(int i = 0;i<trainList.size();i++){
			if(trainList.get(i).state.equals("idle")){
				availableTrain.add(trainList.get(i).trainName);
			}
		}
		setBackground(Color.LIGHT_GRAY);
		setTitle("Assign New Route");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 1000, 916, 459);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		contentPane.setBackground(new Color(204, 204, 204));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		startTime = new JTextField(2);
		startTime.setFont(new Font("Adobe Hebrew", Font.PLAIN, 26));
		startTime.setBounds(602, 66, 56, 35);
		contentPane.add(startTime);
		startTime.setColumns(10);
		startTime.addKeyListener(new KeyListener() {  
		    public void keyTyped(KeyEvent e) {  
		        // 
		        char keyCh = e.getKeyChar(); 
		        if (keyCh<'0'|| keyCh>'9') {  
		            if (keyCh != '\n') //   
		                e.setKeyChar('\0');  
		        }  
		    }  
		  
		    public void keyReleased(KeyEvent e) {  
		    }  
		  
		    public void keyPressed(KeyEvent e) {  
		    }  
		});
		
		startMinute = new JTextField(10);
		startMinute.setFont(new Font("Adobe Hebrew", Font.PLAIN, 26));
		startMinute.setBounds(739, 66, 56, 35);
		startMinute.addKeyListener(new KeyListener() {  
		    public void keyTyped(KeyEvent e) {  
		        char keyCh = e.getKeyChar(); 
		        if (keyCh<'0'|| keyCh>'9') {  
		            if (keyCh != '\n') 
		                e.setKeyChar('\0');  
		        }  
		    }

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			});
		  
		contentPane.add(startMinute);

		JLabel lblSetStartTime = new JLabel("Set Start Time");
		lblSetStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetStartTime.setFont(new Font("Arial Unicode MS", Font.BOLD, 26));
		lblSetStartTime.setVerticalAlignment(SwingConstants.TOP);
		lblSetStartTime.setBounds(385, 61, 184, 29);
		contentPane.add(lblSetStartTime);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(220, 220, 220));
		btnBack.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnBack.setFont(new Font("Adobe Hebrew", Font.BOLD, 28));
		btnBack.setBounds(689, 318, 134, 37);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		
		String[] train=new String[availableTrain.size()];
		availableTrain.toArray(train);
		
		final JComboBox trainNo = new JComboBox(train);
		trainNo.setBorder(new EmptyBorder(0, 0, 0, 0));
		trainNo.setFont(new Font("Adobe Hebrew", Font.BOLD, 20));
		trainNo.setBounds(214, 257, 81, 35);
		contentPane.add(trainNo);
		
		String[] driver=new String[availableDriver.size()];
		availableDriver.toArray(driver);
		
		final JComboBox driverNo = new JComboBox(driver);
		driverNo.setBorder(new EmptyBorder(0, 0, 0, 0));
		driverNo.setFont(new Font("Adobe Hebrew", Font.BOLD, 20));
		driverNo.setBounds(214, 190, 81, 35);
		contentPane.add(driverNo);
		
		String[] route={"R1", "R2", "R3", "R4"};
		
		
		JLabel lblRoute = new JLabel("Route No.");
		lblRoute.setVerticalAlignment(SwingConstants.TOP);
		lblRoute.setFont(new Font("Arial Unicode MS", Font.BOLD, 26));
		lblRoute.setBounds(45, 52, 134, 29);
		contentPane.add(lblRoute);
		
		JLabel lblJourneyNo = new JLabel("Journey No.");
		lblJourneyNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblJourneyNo.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		lblJourneyNo.setBounds(33, 125, 146, 32);
		contentPane.add(lblJourneyNo);
		
		JLabel lblTrainNo = new JLabel("Train No.");
		lblTrainNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrainNo.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		lblTrainNo.setBounds(43, 257, 136, 32);
		contentPane.add(lblTrainNo);
		
		JLabel lblDriverNo = new JLabel("Driver No.");
		lblDriverNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDriverNo.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		lblDriverNo.setBounds(33, 190, 146, 32);
		contentPane.add(lblDriverNo);
		  
		  lbleghhmm = new JLabel("(eg.hh:mm)");
		  lbleghhmm.setForeground(SystemColor.menu);
		  lbleghhmm.setFont(new Font("Adobe Hebrew", Font.BOLD, 24));
		  lbleghhmm.setBounds(632, 127, 154, 29);
		  contentPane.add(lbleghhmm);
		  
		  final JComboBox routeNo = new JComboBox();
		  routeNo.setModel(new DefaultComboBoxModel(new String[] {"R1", "R2", "R3", "R4"}));
		  routeNo.setBounds(214, 52, 84, 38);
		  contentPane.add(routeNo);
		  
		  journeyNo = new JTextField();
		  journeyNo.setBounds(214, 125, 84, 32);
		  journeyNo.setText("J"+(journeyList.size()+1));
		  journeyNo.setEditable(false);
		  contentPane.add(journeyNo);
		  journeyNo.setColumns(10);
		  
			JButton btnOk = new JButton("Ok");
			btnOk.setBackground(new Color(220, 220, 220));
			btnOk.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {		
					if (startMinute.getText().length()<1|| startTime.getText().length()<1){
						JOptionPane.showMessageDialog(contentPane, "Invalid input.");
					}
					else if(Integer.parseInt(startMinute.getText())<0||Integer.parseInt(startMinute.getText())>60||
							Integer.parseInt(startTime.getText())<0||Integer.parseInt(startTime.getText())>24){
						JOptionPane.showMessageDialog(contentPane, "Invalid input.");
					}
					else{
						String journeyName = journeyNo.getText();
						String driverName = (String) driverNo.getSelectedItem();
						String trainName = (String) trainNo.getSelectedItem();
						String routeString = (String) routeNo.getSelectedItem();
						String startTimeString = startTime.getText()+":"+startMinute.getText();
						try {
							Journeyclass newJourney = new Journeyclass(journeyName,trainName,driverName,routeString,startTimeString);
							JOptionPane.showMessageDialog(contentPane, "Success!");
							System.out.println(newJourney.toString());
							String msg = newJourney.toString()+"\r\n";
							BufferedWriter bw = null;
							try {
								bw = new BufferedWriter(new FileWriter(".//Record//journey.txt",true));
								bw.write(msg);
								bw.flush();
						    }
						    catch (IOException ex) {
						    	ex.printStackTrace();
						    } finally  {
						    	try{
						    		if(bw != null)
						    			bw.close();	
						    	}catch(IOException e1) {
						    		e1.printStackTrace();
						    	}				
						    }
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							FileService fileService1 = new FileService();
							System.out.println(fileService1.jouneryFile().size());
							fileService.rewrite(fileService1.trainFile(), fileService1.driverFile(), fileService1.jouneryFile(),routeString);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
			});
			
			btnOk.setBorder(new EmptyBorder(0, 0, 0, 0));
			btnOk.setFont(new Font("Adobe Hebrew", Font.BOLD, 28));
			btnOk.setBounds(481, 318, 134, 37);
			contentPane.add(btnOk);
			
			JLabel label = new JLabel(":");
			label.setVerticalAlignment(SwingConstants.TOP);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Arial Unicode MS", Font.BOLD, 26));
			label.setBounds(679, 61, 39, 35);
			contentPane.add(label);
			
		  
		  this.pack();
		  this.setSize(1027,590);
		  this.setLocation(200, 200);
		  this.setVisible(true);	
		  
	}
	
    public void  actionPerformed(ActionEvent e){
		   if(e.getSource()==btnBack){
			    try {
					route1 = new Route();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.setVisible(false);
		   }
		  }
}
