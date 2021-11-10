package IHM;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitrePanel2 extends JPanel
{

	private static final long serialVersionUID = 5493556915359818635L;
	
	private JLabel titre; 
	
	public TitrePanel2()
	{
		this.setLayout(new FlowLayout());
		this.titre = new JLabel("GESTION DES LIVRES");
		titre.setFont(new Font("Segoe UI",Font.BOLD,35));
		titre.setForeground(Color.WHITE);
		this.setBackground(new Color(35,106,106));
		this.add(titre);
		
	}
}
