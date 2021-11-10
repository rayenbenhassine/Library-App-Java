package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class HistoriqueEmpruntsDialog extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3298402747640029674L;
	private HistoriqueEmpruntsPanel historiqueEmpruntsPanel;
	
	public HistoriqueEmpruntsDialog()
	{
		super(GestionnairePanel.getEmpruntWin(),"Historique des emprunts");
		this.historiqueEmpruntsPanel = new HistoriqueEmpruntsPanel(this);
		this.setContentPane(historiqueEmpruntsPanel);
		this.setModal(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(700, 640);
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
