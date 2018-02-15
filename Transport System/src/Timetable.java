import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

//@SuppressWarnings("serial")
public class Timetable extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtStation;
	private JTextField txtJ;
	private JTextField txtJ_1;
	private JTextField txtJ_2;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtABC;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_1;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_9;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_5;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	JButton btnNewButton;
	Route route1;

	
	public Timetable(){
		init();
	}
	public void init() {
		setTitle("Timetable");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2115, 894);
		contentPane = new JPanel();
		
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRoute = new JLabel("ROUTE1");
		lblRoute.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		lblRoute.setBounds(302, 23, 151, 29);
		contentPane.add(lblRoute);
		
		JLabel lblRoute_3 = new JLabel("ROUTE2");
		lblRoute_3.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		lblRoute_3.setBounds(1502, 23, 136, 29);
		contentPane.add(lblRoute_3);
		
		JLabel lblRoute_1 = new JLabel("ROUTE3");
		lblRoute_1.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		lblRoute_1.setBounds(302, 359, 150, 29);
		contentPane.add(lblRoute_1);
		
		JLabel lblRoute_2 = new JLabel("ROUTE4");
		lblRoute_2.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		lblRoute_2.setBounds(1503, 359, 151, 29);
		contentPane.add(lblRoute_2);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setFont(new Font("Adobe Hebrew", Font.BOLD, 28));
		btnNewButton.setBounds(1932, 766, 136, 49);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		txtStation = new JTextField();
		txtStation.setForeground(new Color(102, 102, 102));
		txtStation.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtStation.setBackground(new Color(204, 204, 204));
		txtStation.setHorizontalAlignment(SwingConstants.CENTER);
		txtStation.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		txtStation.setText("Station");
		txtStation.setBounds(21, 74, 163, 63);
		contentPane.add(txtStation);
		txtStation.setColumns(10);
		
		txtJ = new JTextField();
		txtJ.setForeground(new Color(102, 102, 102));
		txtJ.setBackground(new Color(204, 204, 204));
		txtJ.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtJ.setText("J1");
		txtJ.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		txtJ.setToolTipText("");
		txtJ.setHorizontalAlignment(SwingConstants.CENTER);
		txtJ.setBounds(21, 135, 163, 41);
		contentPane.add(txtJ);
		txtJ.setColumns(10);
		
		txtJ_1 = new JTextField();
		txtJ_1.setForeground(new Color(102, 102, 102));
		txtJ_1.setToolTipText("");
		txtJ_1.setText("J2");
		txtJ_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtJ_1.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		txtJ_1.setColumns(10);
		txtJ_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtJ_1.setBackground(new Color(204, 204, 204));
		txtJ_1.setBounds(21, 175, 163, 49);
		contentPane.add(txtJ_1);
		
		txtJ_2 = new JTextField();
		txtJ_2.setForeground(new Color(102, 102, 102));
		txtJ_2.setToolTipText("");
		txtJ_2.setText("J3");
		txtJ_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtJ_2.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		txtJ_2.setColumns(10);
		txtJ_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtJ_2.setBackground(new Color(204, 204, 204));
		txtJ_2.setBounds(21, 224, 163, 46);
		contentPane.add(txtJ_2);
		
		textField = new JTextField();
		textField.setText("Station");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(102, 102, 102));
		textField.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField.setColumns(10);
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField.setBackground(new Color(204, 204, 204));
		textField.setBounds(1090, 74, 163, 63);
		contentPane.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setText("J2");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(new Color(102, 102, 102));
		textField_2.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_2.setColumns(10);
		textField_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_2.setBackground(new Color(204, 204, 204));
		textField_2.setBounds(1090, 175, 163, 49);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setText("J3");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(new Color(102, 102, 102));
		textField_3.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_3.setColumns(10);
		textField_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_3.setBackground(new Color(204, 204, 204));
		textField_3.setBounds(1090, 224, 163, 46);
		contentPane.add(textField_3);
		
		textField_8 = new JTextField();
		textField_8.setText("Station");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setForeground(new Color(102, 102, 102));
		textField_8.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_8.setColumns(10);
		textField_8.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_8.setBackground(new Color(204, 204, 204));
		textField_8.setBounds(21, 402, 163, 63);
		contentPane.add(textField_8);
		
		textField_10 = new JTextField();
		textField_10.setToolTipText("");
		textField_10.setText("J2");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setForeground(new Color(102, 102, 102));
		textField_10.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_10.setColumns(10);
		textField_10.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_10.setBackground(new Color(204, 204, 204));
		textField_10.setBounds(21, 504, 163, 49);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setToolTipText("");
		textField_11.setText("J3");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setForeground(new Color(102, 102, 102));
		textField_11.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_11.setColumns(10);
		textField_11.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_11.setBackground(new Color(204, 204, 204));
		textField_11.setBounds(21, 552, 163, 46);
		contentPane.add(textField_11);
		
		textField_4 = new JTextField();
		textField_4.setText("Station");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(new Color(102, 102, 102));
		textField_4.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_4.setColumns(10);
		textField_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_4.setBackground(new Color(204, 204, 204));
		textField_4.setBounds(1090, 402, 163, 63);
		contentPane.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("");
		textField_6.setText("J2");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setForeground(new Color(102, 102, 102));
		textField_6.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_6.setColumns(10);
		textField_6.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_6.setBackground(new Color(204, 204, 204));
		textField_6.setBounds(1090, 504, 163, 49);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("");
		textField_7.setText("J3");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setForeground(new Color(102, 102, 102));
		textField_7.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_7.setColumns(10);
		textField_7.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_7.setBackground(new Color(204, 204, 204));
		textField_7.setBounds(1090, 552, 163, 46);
		contentPane.add(textField_7);
		
		txtABC = new JTextField();
		txtABC.setText("Center A B C D");
		txtABC.setHorizontalAlignment(SwingConstants.CENTER);
		txtABC.setForeground(new Color(102, 102, 102));
		txtABC.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		txtABC.setColumns(10);
		txtABC.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtABC.setBackground(new Color(204, 204, 204));
		txtABC.setBounds(183, 74, 401, 63);
		contentPane.add(txtABC);
		
		textField_12 = new JTextField();
		textField_12.setToolTipText("");
		textField_12.setText("10:00 12:00 13:23 14:00 15:09");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setForeground(new Color(102, 102, 102));
		textField_12.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_12.setColumns(10);
		textField_12.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_12.setBackground(new Color(204, 204, 204));
		textField_12.setBounds(183, 132, 401, 46);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("Center A B C D");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setForeground(new Color(102, 102, 102));
		textField_13.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_13.setColumns(10);
		textField_13.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_13.setBackground(new Color(204, 204, 204));
		textField_13.setBounds(583, 74, 401, 63);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setToolTipText("");
		textField_14.setText("10:00 12:00 13:23 14:00 15:09");
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setForeground(new Color(102, 102, 102));
		textField_14.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_14.setColumns(10);
		textField_14.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_14.setBackground(new Color(204, 204, 204));
		textField_14.setBounds(583, 132, 401, 46);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setToolTipText("");
		textField_15.setText("10:00 12:00 13:23 14:00 15:09");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setForeground(new Color(102, 102, 102));
		textField_15.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_15.setColumns(10);
		textField_15.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_15.setBackground(new Color(204, 204, 204));
		textField_15.setBounds(183, 178, 401, 46);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setToolTipText("");
		textField_16.setText("10:00 12:00 13:23 14:00 15:09");
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setForeground(new Color(102, 102, 102));
		textField_16.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_16.setColumns(10);
		textField_16.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_16.setBackground(new Color(204, 204, 204));
		textField_16.setBounds(583, 178, 401, 46);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setToolTipText("");
		textField_17.setText("10:00 12:00 13:23 14:00 15:09");
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setForeground(new Color(102, 102, 102));
		textField_17.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_17.setColumns(10);
		textField_17.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_17.setBackground(new Color(204, 204, 204));
		textField_17.setBounds(183, 224, 401, 46);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setToolTipText("");
		textField_18.setText("10:00 12:00 13:23 14:00 15:09");
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setForeground(new Color(102, 102, 102));
		textField_18.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_18.setColumns(10);
		textField_18.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_18.setBackground(new Color(204, 204, 204));
		textField_18.setBounds(583, 224, 401, 46);
		contentPane.add(textField_18);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setText("J1");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(new Color(102, 102, 102));
		textField_1.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_1.setColumns(10);
		textField_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_1.setBackground(new Color(204, 204, 204));
		textField_1.setBounds(1090, 136, 163, 41);
		contentPane.add(textField_1);
		
		textField_19 = new JTextField();
		textField_19.setText("Center A B C D");
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setForeground(new Color(102, 102, 102));
		textField_19.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_19.setColumns(10);
		textField_19.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_19.setBackground(new Color(204, 204, 204));
		textField_19.setBounds(1253, 73, 401, 63);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setText("Center A B C D");
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setForeground(new Color(102, 102, 102));
		textField_20.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_20.setColumns(10);
		textField_20.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_20.setBackground(new Color(204, 204, 204));
		textField_20.setBounds(1654, 73, 401, 63);
		contentPane.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setToolTipText("");
		textField_21.setText("10:00 12:00 13:23 14:00 15:09");
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setForeground(new Color(102, 102, 102));
		textField_21.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_21.setColumns(10);
		textField_21.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_21.setBackground(new Color(204, 204, 204));
		textField_21.setBounds(1253, 135, 401, 46);
		contentPane.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setToolTipText("");
		textField_22.setText("10:00 12:00 13:23 14:00 15:09");
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setForeground(new Color(102, 102, 102));
		textField_22.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_22.setColumns(10);
		textField_22.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_22.setBackground(new Color(204, 204, 204));
		textField_22.setBounds(1654, 136, 401, 46);
		contentPane.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setToolTipText("");
		textField_23.setText("10:00 12:00 13:23 14:00 15:09");
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setForeground(new Color(102, 102, 102));
		textField_23.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_23.setColumns(10);
		textField_23.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_23.setBackground(new Color(204, 204, 204));
		textField_23.setBounds(1253, 180, 401, 46);
		contentPane.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setToolTipText("");
		textField_24.setText("10:00 12:00 13:23 14:00 15:09");
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setForeground(new Color(102, 102, 102));
		textField_24.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_24.setColumns(10);
		textField_24.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_24.setBackground(new Color(204, 204, 204));
		textField_24.setBounds(1654, 180, 401, 46);
		contentPane.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setToolTipText("");
		textField_25.setText("10:00 12:00 13:23 14:00 15:09");
		textField_25.setHorizontalAlignment(SwingConstants.CENTER);
		textField_25.setForeground(new Color(102, 102, 102));
		textField_25.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_25.setColumns(10);
		textField_25.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_25.setBackground(new Color(204, 204, 204));
		textField_25.setBounds(1253, 224, 401, 46);
		contentPane.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setToolTipText("");
		textField_26.setText("10:00 12:00 13:23 14:00 15:09");
		textField_26.setHorizontalAlignment(SwingConstants.CENTER);
		textField_26.setForeground(new Color(102, 102, 102));
		textField_26.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_26.setColumns(10);
		textField_26.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_26.setBackground(new Color(204, 204, 204));
		textField_26.setBounds(1654, 224, 401, 46);
		contentPane.add(textField_26);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("");
		textField_9.setText("J1");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setForeground(new Color(102, 102, 102));
		textField_9.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_9.setColumns(10);
		textField_9.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_9.setBackground(new Color(204, 204, 204));
		textField_9.setBounds(21, 465, 163, 41);
		contentPane.add(textField_9);
		
		textField_27 = new JTextField();
		textField_27.setText("Center A B C D");
		textField_27.setHorizontalAlignment(SwingConstants.CENTER);
		textField_27.setForeground(new Color(102, 102, 102));
		textField_27.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_27.setColumns(10);
		textField_27.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_27.setBackground(new Color(204, 204, 204));
		textField_27.setBounds(183, 402, 401, 63);
		contentPane.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setText("Center A B C D");
		textField_28.setHorizontalAlignment(SwingConstants.CENTER);
		textField_28.setForeground(new Color(102, 102, 102));
		textField_28.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_28.setColumns(10);
		textField_28.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_28.setBackground(new Color(204, 204, 204));
		textField_28.setBounds(583, 402, 401, 63);
		contentPane.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setToolTipText("");
		textField_29.setText("10:00 12:00 13:23 14:00 15:09");
		textField_29.setHorizontalAlignment(SwingConstants.CENTER);
		textField_29.setForeground(new Color(102, 102, 102));
		textField_29.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_29.setColumns(10);
		textField_29.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_29.setBackground(new Color(204, 204, 204));
		textField_29.setBounds(183, 462, 401, 46);
		contentPane.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setToolTipText("");
		textField_30.setText("10:00 12:00 13:23 14:00 15:09");
		textField_30.setHorizontalAlignment(SwingConstants.CENTER);
		textField_30.setForeground(new Color(102, 102, 102));
		textField_30.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_30.setColumns(10);
		textField_30.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_30.setBackground(new Color(204, 204, 204));
		textField_30.setBounds(583, 465, 401, 46);
		contentPane.add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setToolTipText("");
		textField_31.setText("10:00 12:00 13:23 14:00 15:09");
		textField_31.setHorizontalAlignment(SwingConstants.CENTER);
		textField_31.setForeground(new Color(102, 102, 102));
		textField_31.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_31.setColumns(10);
		textField_31.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_31.setBackground(new Color(204, 204, 204));
		textField_31.setBounds(183, 507, 401, 46);
		contentPane.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setToolTipText("");
		textField_32.setText("10:00 12:00 13:23 14:00 15:09");
		textField_32.setHorizontalAlignment(SwingConstants.CENTER);
		textField_32.setForeground(new Color(102, 102, 102));
		textField_32.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_32.setColumns(10);
		textField_32.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_32.setBackground(new Color(204, 204, 204));
		textField_32.setBounds(583, 509, 401, 46);
		contentPane.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setToolTipText("");
		textField_33.setText("10:00 12:00 13:23 14:00 15:09");
		textField_33.setHorizontalAlignment(SwingConstants.CENTER);
		textField_33.setForeground(new Color(102, 102, 102));
		textField_33.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_33.setColumns(10);
		textField_33.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_33.setBackground(new Color(204, 204, 204));
		textField_33.setBounds(183, 552, 401, 46);
		contentPane.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setToolTipText("");
		textField_34.setText("10:00 12:00 13:23 14:00 15:09");
		textField_34.setHorizontalAlignment(SwingConstants.CENTER);
		textField_34.setForeground(new Color(102, 102, 102));
		textField_34.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_34.setColumns(10);
		textField_34.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_34.setBackground(new Color(204, 204, 204));
		textField_34.setBounds(583, 552, 401, 46);
		contentPane.add(textField_34);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("");
		textField_5.setText("J1");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setForeground(new Color(102, 102, 102));
		textField_5.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_5.setColumns(10);
		textField_5.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_5.setBackground(new Color(204, 204, 204));
		textField_5.setBounds(1090, 465, 163, 41);
		contentPane.add(textField_5);
		
		textField_35 = new JTextField();
		textField_35.setText("Center A B C D");
		textField_35.setHorizontalAlignment(SwingConstants.CENTER);
		textField_35.setForeground(new Color(102, 102, 102));
		textField_35.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_35.setColumns(10);
		textField_35.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_35.setBackground(new Color(204, 204, 204));
		textField_35.setBounds(1253, 402, 401, 63);
		contentPane.add(textField_35);
		
		textField_36 = new JTextField();
		textField_36.setText("Center A B C D");
		textField_36.setHorizontalAlignment(SwingConstants.CENTER);
		textField_36.setForeground(new Color(102, 102, 102));
		textField_36.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_36.setColumns(10);
		textField_36.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_36.setBackground(new Color(204, 204, 204));
		textField_36.setBounds(1654, 402, 401, 63);
		contentPane.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setToolTipText("");
		textField_37.setText("10:00 12:00 13:23 14:00 15:09");
		textField_37.setHorizontalAlignment(SwingConstants.CENTER);
		textField_37.setForeground(new Color(102, 102, 102));
		textField_37.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_37.setColumns(10);
		textField_37.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_37.setBackground(new Color(204, 204, 204));
		textField_37.setBounds(1253, 462, 401, 46);
		contentPane.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setToolTipText("");
		textField_38.setText("10:00 12:00 13:23 14:00 15:09");
		textField_38.setHorizontalAlignment(SwingConstants.CENTER);
		textField_38.setForeground(new Color(102, 102, 102));
		textField_38.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_38.setColumns(10);
		textField_38.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_38.setBackground(new Color(204, 204, 204));
		textField_38.setBounds(1654, 462, 401, 46);
		contentPane.add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setToolTipText("");
		textField_39.setText("10:00 12:00 13:23 14:00 15:09");
		textField_39.setHorizontalAlignment(SwingConstants.CENTER);
		textField_39.setForeground(new Color(102, 102, 102));
		textField_39.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_39.setColumns(10);
		textField_39.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_39.setBackground(new Color(204, 204, 204));
		textField_39.setBounds(1253, 507, 401, 46);
		contentPane.add(textField_39);
		
		textField_40 = new JTextField();
		textField_40.setToolTipText("");
		textField_40.setText("10:00 12:00 13:23 14:00 15:09");
		textField_40.setHorizontalAlignment(SwingConstants.CENTER);
		textField_40.setForeground(new Color(102, 102, 102));
		textField_40.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_40.setColumns(10);
		textField_40.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_40.setBackground(new Color(204, 204, 204));
		textField_40.setBounds(1654, 507, 401, 46);
		contentPane.add(textField_40);
		
		textField_41 = new JTextField();
		textField_41.setToolTipText("");
		textField_41.setText("10:00 12:00 13:23 14:00 15:09");
		textField_41.setHorizontalAlignment(SwingConstants.CENTER);
		textField_41.setForeground(new Color(102, 102, 102));
		textField_41.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_41.setColumns(10);
		textField_41.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_41.setBackground(new Color(204, 204, 204));
		textField_41.setBounds(1253, 552, 401, 46);
		contentPane.add(textField_41);
		
		textField_42 = new JTextField();
		textField_42.setToolTipText("");
		textField_42.setText("10:00 12:00 13:23 14:00 15:09");
		textField_42.setHorizontalAlignment(SwingConstants.CENTER);
		textField_42.setForeground(new Color(102, 102, 102));
		textField_42.setFont(new Font("Adobe Hebrew", Font.BOLD, 30));
		textField_42.setColumns(10);
		textField_42.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_42.setBackground(new Color(204, 204, 204));
		textField_42.setBounds(1654, 552, 401, 46);
		contentPane.add(textField_42);
				
		  this.pack();
		  this.setLocation(200, 200);
		  this.setSize(2115, 894);
		  this.setVisible(true);	
	}
	public void actionPerformed(ActionEvent e) {
		   if(e.getSource()==btnNewButton){
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

