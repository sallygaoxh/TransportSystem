import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class Register extends JFrame implements ActionListener{
	private JFrame jf;
	private Container con;
	private JPanel userJPanel, passJPanel, spassJPanel, regJPanel, msgJPanel;
	private JLabel userJLabel, passJLabel, spassJLabel;
	private JLabel msg;
	private JTextField userJtf;
	private JPasswordField passJtf, spassJtf;
	private JButton reset, register;
	
	public Register(){
		init();
	}
	
	public void init() {
		jf = new JFrame("Register");
		con = jf.getContentPane();
		con.setLayout(new GridLayout(5, 1));
		
		userJLabel = new JLabel("UserName");
		userJLabel.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		userJtf = new JTextField(10);
		userJPanel = new JPanel();
		userJPanel.add(userJLabel);
		userJPanel.add(userJtf);
		
		passJLabel = new JLabel("PassWord");
		passJLabel.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		passJtf = new JPasswordField(10);
		passJPanel = new JPanel();
		passJPanel.add(passJLabel);
		passJPanel.add(passJtf);
		
		spassJLabel = new JLabel("PassWord Again");
		spassJLabel.setFont(new Font("Adobe Hebrew", Font.BOLD, 26));
		spassJtf = new JPasswordField(10);
		spassJPanel = new JPanel();
		spassJPanel.add(spassJLabel);
		spassJPanel.add(spassJtf);
		
		msg = new JLabel();
		msgJPanel = new JPanel();
		msgJPanel.add(msg);
		
		reset = new JButton("Clear");
		reset.setFont(new Font("Adobe Hebrew", Font.BOLD, 28));
		reset.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
						userJtf.setText("");
						passJtf.setText("");
						spassJtf.setText("");
					}
			});
		register = new JButton("Register");
		register.setFont(new Font("Adobe Hebrew", Font.BOLD, 28));
		register.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String pass = new String(passJtf.getPassword());
					String spass= new String(spassJtf.getPassword());
					if(!pass.equals(spass)) {
						msg.setText("Error! Passwords are different!");
						return ;
					} 
					
					String userName = userJtf.getText();
					User user = new User();
					user.setUserName(userName);
					user.setPwd(pass);
					RegisterService service = new RegisterService();
					int result = service.register(user);
					if(result == 1){
						JOptionPane.showMessageDialog(jf, "Success!");
						jf.setVisible(false);
					}
					else
						msg.setText("Username already existed.");
				}
			});
		regJPanel = new JPanel();
		regJPanel.add(reset);
		regJPanel.add(register);
		
		con.add(userJPanel);
		con.add(passJPanel);
		con.add(spassJPanel);
		con.add(msgJPanel);
		con.add(regJPanel);
		
		jf.pack();
		jf.setSize(500, 500);
		jf.setLocation(200, 200);
		jf.setVisible(true);
	}

//	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
