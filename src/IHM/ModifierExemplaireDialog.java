package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class ModifierExemplaireDialog extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1100429540359015027L;
	private ModifierExemplairePanel modifierExemplairePanel;

	public ModifierExemplaireDialog()
	{
		super(LeftPanel2.getExemplairesDialog(),"Modifier exemplaire");
		this.modifierExemplairePanel = new ModifierExemplairePanel(this);
		this.setContentPane(modifierExemplairePanel);
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
