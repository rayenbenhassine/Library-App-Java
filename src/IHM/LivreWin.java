package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;



public class LivreWin extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 760161343792533241L;
	private LivrePanel livrePanel;
	
	public LivreWin()
	{
		super("gestion des livres");
		this.livrePanel = new LivrePanel();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1000, 640);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setContentPane(livrePanel);
		try {
			this.setIconImage(ImageIO.read(new File("resources/icone.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
