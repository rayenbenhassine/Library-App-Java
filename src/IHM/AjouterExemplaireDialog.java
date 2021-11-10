package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class AjouterExemplaireDialog extends JDialog
{

	private static final long serialVersionUID = 5291090450751353855L;
	private AjouterExemplairePanel ajouterExemplairePanel;
	
	public AjouterExemplaireDialog()
	{
		super(LeftPanel2.getExemplairesDialog(),"Ajouter exemplaire");
		this.ajouterExemplairePanel = new AjouterExemplairePanel(this);
		this.setContentPane(ajouterExemplairePanel);
		this.setModal(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(350, 300);
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