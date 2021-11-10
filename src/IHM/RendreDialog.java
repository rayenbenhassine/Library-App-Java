package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class RendreDialog extends JDialog 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4207449695804360267L;
	private RendrePanel rendrePanel;
	
	public RendreDialog()
	{
		super(GestionnairePanel.getEmpruntWin(),"RENDRE");
		this.rendrePanel = new RendrePanel(this);
		this.setContentPane(rendrePanel);
		this.setModal(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(450, 250);
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
