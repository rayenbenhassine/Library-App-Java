package IHM;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitrePanel extends JPanel
{

	private static final long serialVersionUID = 5493556915359818635L;
	
	private JLabel titre; 
	
	public TitrePanel()
	{
		this.setLayout(new FlowLayout());
		this.titre = new JLabel("GESTION DES ABONNES");
		titre.setFont(new Font("Segoe UI",Font.BOLD,35));
		titre.setForeground(Color.WHITE);
		this.setBackground(new Color(152,14,33));

		//this.setBackground(Color.cyan);
		this.add(titre);
		//new Color(59,131,226)
		
	}
}
