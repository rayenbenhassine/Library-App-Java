package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ConnectionWin extends JFrame
{
	
	private static final long serialVersionUID = -412050852633570325L;
	
	private ConnectionPanel connectionPanel;



	public ConnectionWin()
	{
		super("S'authentifier");
		this.connectionPanel = new ConnectionPanel(this);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(810, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setContentPane(connectionPanel);
		try {
			this.setIconImage(ImageIO.read(new File("resources/icone.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	



	
}
