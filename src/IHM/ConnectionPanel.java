package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Classes.Gestionnaire;

public class ConnectionPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6659443911936263628L;
	private JLabel lblLogin;
	private static JTextField txtLogin;
	private JLabel lblMdp;
	private static JPasswordField txtMdp;
	private JButton btnSeConnecter;
	private JLabel lblDev;
	private static Gestionnaire gestionnaire;
	
	public ConnectionPanel(ConnectionWin connectionWin)
	{
		super();
		this.setLayout(null);

		lblLogin = new JLabel("Username :");
		this.add(lblLogin);
		lblLogin.setBounds(410, 260, 120, 30);
		lblLogin.setFont(new Font("Segoe UI",Font.BOLD,14));
		lblLogin.setForeground(Color.WHITE);


		txtLogin = new JTextField();
		this.add(txtLogin);
		txtLogin.setBounds(505, 260, 200, 30);

		
		lblMdp = new JLabel("Password :");
		this.add(lblMdp);
		lblMdp.setBounds(410, 300, 120, 30);
		lblMdp.setFont(new Font("Segoe UI",Font.BOLD,14));
		lblMdp.setForeground(Color.WHITE);

		
		txtMdp = new JPasswordField();
		this.add(txtMdp);
		txtMdp.setBounds(505, 300, 200, 30);

		
		btnSeConnecter = new JButton("Sign in");
		this.add(btnSeConnecter);
		btnSeConnecter.setBounds(505, 340, 200, 35);
		btnSeConnecter.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnSeConnecter.setBackground(new Color(159,9,29));
		btnSeConnecter.setForeground(Color.WHITE);
		btnSeConnecter.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (Gestionnaire.exists(txtLogin.getText(),txtMdp.getText()))
				{
					connectionWin.dispose();
					gestionnaire = new Gestionnaire(txtLogin.getText(), txtMdp.getText(), Gestionnaire.getNom(txtLogin.getText()),Gestionnaire.getPrenom(txtLogin.getText()));
					@SuppressWarnings("unused")
					GestionnaireWin gestionnaireWin = new GestionnaireWin(gestionnaire);
					
				}
				else
				{
					JOptionPane.showMessageDialog(connectionWin,"login ou mot de passe incorrecte","message",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		lblDev = new JLabel("© Software Developped By Ben Hassine Rayen & Sellami Yassmine");
		this.add(lblDev);
		lblDev.setBounds(460, 590, 330, 30);
		lblDev.setFont(new Font("Segoe UI",Font.BOLD,10));
		lblDev.setForeground(Color.WHITE);
	}
	
	public static Gestionnaire getGestionnaire()
	{
		return gestionnaire;
	}
	


	public void paintComponent(Graphics g)
	{
		try 
		{
			Image img = ImageIO.read(new File("resources/wallpaper.png"));
			g.drawImage(img, 0, 0,this);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
