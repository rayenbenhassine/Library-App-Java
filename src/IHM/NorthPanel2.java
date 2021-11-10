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

import Classes.Livre;

public class NorthPanel2 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7276070189611863565L;
	private JLabel lblRechercher;
	@SuppressWarnings("rawtypes")
	private JComboBox cbRechecher; 
	@SuppressWarnings("unused")
	private JButton btnRechercher;
	private JTextField txtRechercher;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public NorthPanel2()
	{
		this.setBackground(new Color(217,236,236));
		this.setLayout(null);
		this.setPreferredSize(new Dimension(0,150));
		
		lblRechercher = new JLabel("Rechercher par");
		this.add(lblRechercher);
		lblRechercher.setBounds(100, 40, 100, 20);
		lblRechercher.setFont(new Font("Arial",Font.BOLD,12));
		
		String[] cbtab = {"Tout afficher","Id","ISBN","Titre","Auteur","Thème"};
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
					TableLivres.afficherTous();
				}
				else if (typeRecherche.equals("Id"))
				{
					if(isNumeric(inputRecherche))
					{
						if(Livre.RechercheParId(inputRecherche))
						{
							TableLivres.afficherParId(inputRecherche);
						}
						else
						{
							JOptionPane.showMessageDialog(GestionnairePanel.getLivreWin(),"Oups ! livre inexistant","Erreur",JOptionPane.ERROR_MESSAGE);
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(GestionnairePanel.getLivreWin(),"Veillez saisir un ID correct","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (typeRecherche.equals("ISBN"))
				{
					if(isNumeric(inputRecherche))
					{
						if(Livre.RechercheParISBN(inputRecherche))
						{
							TableLivres.afficherParISBN(inputRecherche);
						}
						else
						{
							JOptionPane.showMessageDialog(GestionnairePanel.getLivreWin(),"Oups ! livre inexistant","Erreur",JOptionPane.ERROR_MESSAGE);
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(GestionnairePanel.getLivreWin(),"Veillez saisir un ISBN correct","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (typeRecherche.equals("Titre"))
				{
					if(Livre.RechercheParTitre(inputRecherche))
					{
						TableLivres.afficherParTitre(inputRecherche);
					}
					else
					{
						JOptionPane.showMessageDialog(GestionnairePanel.getAbonneWin(),"Livre introuvable","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (typeRecherche.equals("Auteur"))
				{
					if(Livre.RechercheParAuteur(inputRecherche))
					{
						TableLivres.afficherParAuteur(inputRecherche);
					}
					else
					{
						JOptionPane.showMessageDialog(GestionnairePanel.getAbonneWin(),"Livre introuvable","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (typeRecherche.equals("Thème"))
				{
					if(Livre.RechercheParTheme(inputRecherche))
					{
						TableLivres.afficherParTheme(inputRecherche);
					}
					else
					{
						JOptionPane.showMessageDialog(GestionnairePanel.getAbonneWin(),"Livre introuvable","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
			}
		});
		btnRechercher.setBackground(new Color(41,125,125));
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
