package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class AjouterAbonneDialog extends JDialog
{
	private static final long serialVersionUID = -1994835922530136948L;
	private AjouterAbonnePanel ajouterAbonnePanel;
	
	public AjouterAbonneDialog()
	{
		super(GestionnairePanel.getAbonneWin(),"Ajouter abonné");
		this.ajouterAbonnePanel = new AjouterAbonnePanel(this);
		this.setContentPane(ajouterAbonnePanel);
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
