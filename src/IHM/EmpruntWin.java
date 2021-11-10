package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class EmpruntWin extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6244895366671779569L;
	private EmpruntPanel empruntPanel;
	
	public EmpruntWin()
	{
		super("gestion des emprunts");
		this.empruntPanel = new EmpruntPanel();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1000, 640);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setContentPane(empruntPanel);
		try {
			this.setIconImage(ImageIO.read(new File("resources/icone.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
