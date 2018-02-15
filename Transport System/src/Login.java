
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
public class Login extends JFrame implements ActionListener{
	private JFrame jf;
	private Container con;
	private JPanel userJPanel, passJPanel, regJPanel;
	private JLabel userJLabel, passJLabel;
	
	private JTextField userJtf;
	private JPasswordField passJtf;
	private JButton login;
	
	MainTwo login1;
	MainOne login2;
	
	public Login(){
		init();
	}
	
	public void init() {
		jf = new JFrame("Manager Login");
		con = jf.getContentPane();
		con.setLayout(new GridLayout(5, 1));
		
		userJLabel = new JLabel("UserName");
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
					LoginService service = new LoginService();
					boolean b = service.login(user);
					if(b) {
						JOptionPane.showMessageDialog(jf, "Success!");
						jf.setVisible(false);
						login1 = new MainTwo();
						
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
				login2 = new MainOne();
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