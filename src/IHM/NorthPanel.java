package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Classes.Abonne;

public class NorthPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7516264057200583373L;
	private JLabel lblRechercher;
	@SuppressWarnings("rawtypes")
	private JComboBox cbRechecher; 
	private JTextField txtRechercher;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public NorthPanel()
	{
		this.setBackground(new Color(243,212,212));

		this.setLayout(null);
		this.setPreferredSize(new Dimension(0,150));
		
		lblRechercher = new JLabel("Rechercher par");
		this.add(lblRechercher);
		lblRechercher.setBounds(100, 40, 120, 20);
		//lblRechercher.setFont(new Font("Arial",Font.BOLD,12));
		lblRechercher.setFont(new Font("Segoe UI",Font.BOLD,16));
		lblRechercher.setForeground(Color.black);
		
		String[] cbtab = {"Tout afficher","Id","Nom","Prenom"};
		cbRechecher = new JComboBox(cbtab);
		this.add(cbRechecher);
		cbRechecher.setBounds(230, 37, 130, 25);
		txtRechercher = new JTextField();
		this.add(txtRechercher);
		txtRechercher.setBounds(100, 80, 260, 30);
		
		JButton btnRechercher = new JButton("Rechercher");
		this.add(btnRechercher);
		btnRechercher.setBounds(380, 80, 110, 30);
		btnRechercher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String typeRecherche = (String) cbRechecher.getSelectedItem();
				String inputRecherche = txtRechercher.getText();
				
				if (typeRecherche.equals("Tout afficher"))
				{
					TableAbonnes.afficherTous();
				}
				else if (typeRecherche.equals("Id"))
				{
					if(isNumeric(inputRecherche))
					{
						if(Abonne.RechercheParId(inputRecherche))
						{
							TableAbonnes.afficherParId(inputRecherche);
						}
						else
						{
							JOptionPane.showMessageDialog(GestionnairePanel.getAbonneWin(),"Id introuvable","Erreur",JOptionPane.ERROR_MESSAGE);
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(GestionnairePanel.getAbonneWin(),"Veillez saisir un ID correct","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (typeRecherche.equals("Prenom"))
					{
						if(Abonne.RechercheParPrenom(inputRecherche))
						{
							TableAbonnes.afficherParPrenom(inputRecherche);
						}
						else
						{
							JOptionPane.showMessageDialog(GestionnairePanel.getAbonneWin(),"Abonne introuvable","Erreur",JOptionPane.ERROR_MESSAGE);
						}
					}
				else if (typeRecherche.equals("Nom"))
				{
					if(Abonne.RechercheParNom(inputRecherche))
					{
						TableAbonnes.afficherParNom(inputRecherche);
					}
					else
					{
						JOptionPane.showMessageDialog(GestionnairePanel.getAbonneWin(),"Abonne introuvable","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
				
			}
		});
		btnRechercher.setBackground(new Color(159,9,29));
		btnRechercher.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnRechercher.setForeground(Color.WHITE);
	}
	
	private boolean isNumeric(String inputRecherche)
	{
	    try 
	    {
	        Integer d = Integer.parseInt(inputRecherche);
	        System.out.println(d);
	        return true;
	    } 
	    catch (NumberFormatException nfe) 
	    {
	        return false;
	    }
	    
	    
	
	}


	
}
