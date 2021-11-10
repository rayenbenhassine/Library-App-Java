package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Classes.Gestionnaire;

public class GestionnaireWin extends JFrame
{
	private static final long serialVersionUID = -8961614562059701743L;
	
	private GestionnairePanel gestionnairePanel;
	
	public GestionnaireWin(Gestionnaire gestionnaire)
	{
		super("Gestion bibliotheque");
		this.gestionnairePanel = new GestionnairePanel(this,gestionnaire);
		this.setContentPane(gestionnairePanel);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(450, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		try {
			this.setIconImage(ImageIO.read(new File("resources/icone.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

