package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class ExemplairesDialog extends JDialog 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4166993822226956003L;
	private ExemplairesPanel exemplairesPanel;
	
	public ExemplairesDialog()
	{
		super(GestionnairePanel.getEmpruntWin(),"EMPRUNTER UN EXEMPLAIRE");
		this.exemplairesPanel = new ExemplairesPanel(this);
		this.setContentPane(exemplairesPanel);
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
