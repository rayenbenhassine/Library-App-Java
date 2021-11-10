package IHM;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class EmprunterDialog extends JDialog 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1635792758700965403L;
	private EmprunterPanel emprunterPanel;
	
	public EmprunterDialog()
	{
		super(GestionnairePanel.getEmpruntWin(),"Gestion des exemplaires");
		this.emprunterPanel = new EmprunterPanel(this);
		this.setContentPane(emprunterPanel);
		this.setModal(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(450, 350);
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
