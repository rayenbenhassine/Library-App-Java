package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class ModifierAbonneDialog extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2846286222291841389L;
	private ModifierAbonnePanel modifierAbonnePanel;
	
	public ModifierAbonneDialog()
	{
		super(GestionnairePanel.getAbonneWin(),"Ajouter abonné");
		this.modifierAbonnePanel = new ModifierAbonnePanel(this);
		this.setContentPane(modifierAbonnePanel);
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
