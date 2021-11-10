package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class ModifierLivreDialog extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5444107165892055750L;
	private ModifierLivrePanel modifierLivrePanel;
	
	public ModifierLivreDialog()
	{
		super(GestionnairePanel.getLivreWin(),"Modifier livre");
		this.modifierLivrePanel = new ModifierLivrePanel(this);
		this.setContentPane(modifierLivrePanel);
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
