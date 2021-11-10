package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;



public class AbonneWin extends JFrame
{
	private static final long serialVersionUID = 3359213156328495388L;
	private AbonnePanel abonnePanel;
	
	public AbonneWin()
	{
		super("gestion des abonnés");
		this.abonnePanel = new AbonnePanel();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1000, 640);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setContentPane(abonnePanel);
		try {
			this.setIconImage(ImageIO.read(new File("resources/icone.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
