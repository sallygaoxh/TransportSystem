
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.GroupLayout.Alignment;
public class LogD extends JFrame implements ActionListener{
	private JFrame jf;
	private Container con;
	private JPanel userJPanel, passJPanel, regJPanel;
	private JLabel userJLabel, passJLabel;
	
	private JTextField userJtf;
	private JPasswordField passJtf;
	private JButton login;
	
	Driver1 login1;
	MainScreen login2;
	
	public LogD(){
		init();
	}
	
	public void init() {
		jf = new JFrame("Driver Login");
		con = jf.getContentPane();
		con.setLayout(new GridLayout(5, 1));
		
		userJLabel = new JLabel("Driver No.");
		userJtf = new JTextField(10);
		userJLabel.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		userJPanel = new JPanel();
		userJPanel.add(userJLabel);
		userJPanel.add(userJtf);
		
		passJLabel = new JLabel("PassWord");
		passJtf = new JPasswordField(10);
		passJLabel.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		passJPanel = new JPanel();
		passJPanel.add(passJLabel);
		passJPanel.add(passJtf);
		
	
		login = new JButton("Login");
		login.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		login.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String userName = userJtf.getText();
					String pwd = new String(passJtf.getPassword());
					User user = new User();
					user.setUserName(userName);
					user.setPwd(pwd);
					LogDService service = new LogDService();
					boolean b = service.login(user);
					if(b) {
						JOptionPane.showMessageDialog(jf, "Success!");
						jf.setVisible(false);
						try {
							login1 = new Driver1(user);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} else {
						JOptionPane.showMessageDialog(jf, "Wrong!");
					}
				}
			});
		regJPanel = new JPanel();
		
		con.add(userJPanel);
		con.add(passJPanel);
		
		con.add(regJPanel);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				login2 = new MainScreen();
			}
		});
		GroupLayout gl_regJPanel = new GroupLayout(regJPanel);
		gl_regJPanel.setHorizontalGroup(
			gl_regJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_regJPanel.createSequentialGroup()
					.addGap(106)
					.addComponent(login)
					.addGap(44)
					.addComponent(back)
					.addContainerGap(120, Short.MAX_VALUE))
		);
		gl_regJPanel.setVerticalGroup(
			gl_regJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_regJPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_regJPanel.createParallelGroup(Alignment.TRAILING, false)
					.addComponent(back, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(login, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		regJPanel.setLayout(gl_regJPanel);
		
		jf.pack();
		jf.setLocation(200, 200);
		jf.setSize(500, 500);
		jf.setVisible(true);
	}

//	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}