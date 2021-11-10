package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class AjouterLivreDialog extends JDialog
{

	private static final long serialVersionUID = -7234872429960564209L;
	private AjouterLivrePanel ajouterLivrePanel;
	
	public AjouterLivreDialog()
	{
		super(GestionnairePanel.getLivreWin(),"Ajouter livre");
		this.ajouterLivrePanel = new AjouterLivrePanel(this);
		this.setContentPane(ajouterLivrePanel);
		this.setModal(true);
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