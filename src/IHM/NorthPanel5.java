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

import Classes.Emprunt;

public class NorthPanel5 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2401024796081069345L;
	private JLabel lblRechercher;
	@SuppressWarnings("rawtypes")
	private JComboBox cbRechecher; 
	private JTextField txtRechercher;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public NorthPanel5()
	{
		this.setBackground(new Color(235,245,240));

		this.setLayout(null);
		this.setPreferredSize(new Dimension(0,150));
		
		lblRechercher = new JLabel("Rechercher par");
		this.add(lblRechercher);
		lblRechercher.setBounds(50, 40, 120, 20);
		lblRechercher.setFont(new Font("Segoe UI",Font.BOLD,15));
		lblRechercher.setForeground(Color.black);
		
		String[] cbtab = {"Tout afficher","Id emprunt","Id livre","Id exemplaire","Id abonne"};
		cbRechecher = new JComboBox(cbtab);
		this.add(cbRechecher);
		cbRechecher.setBounds(180, 37, 130, 25);
		
		txtRechercher = new JTextField();
		this.add(txtRechercher);
		txtRechercher.setBounds(50, 80, 260, 30);
		
		JButton btnRechercher = new JButton("Rechercher");
		this.add(btnRechercher);
		btnRechercher.setBounds(330, 80, 110, 30);
		btnRechercher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String typeRecherche = (String) cbRechecher.getSelectedItem();
				String inputRecherche = txtRechercher.getText();
				
				if (typeRecherche.equals("Tout afficher"))
				{
					TableHistoriqueEmprunts.afficherTous();
				}
				else if (typeRecherche.equals("Id emprunt"))
				{
					if(isNumeric(inputRecherche))
					{
						if(Emprunt.RechercheParIdEmprunt(inputRecherche))
						{
							TableHistoriqueEmprunts.afficherParIdEmprunt(inputRecherche);
						}
						else
						{
							JOptionPane.showMessageDialog(LeftPanel4.getHistoriqueEmpruntsDialog(),"Id emprunt introuvable","Erreur",JOptionPane.ERROR_MESSAGE);
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(LeftPanel4.getHistoriqueEmpruntsDialog(),"Veillez saisir un Id emprunt correct","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (typeRecherche.equals("Id abonne"))
				{
					if(isNumeric(inputRecherche))
					{
						if(Emprunt.RechercheParIdAbonne(inputRecherche))
						{
							TableHistoriqueEmprunts.afficherParIdAbonne(inputRecherche);
						}
						else
						{
							JOptionPane.showMessageDialog(LeftPanel4.getHistoriqueEmpruntsDialog(),"Id abonnee introuvable","Erreur",JOptionPane.ERROR_MESSAGE);
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(LeftPanel4.getHistoriqueEmpruntsDialog(),"Veillez saisir un Id abonne correct","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (typeRecherche.equals("Id livre"))
				{
					if(isNumeric(inputRecherche))
					{
						if(Emprunt.RechercheParIdLivre(inputRecherche))
						{
							TableHistoriqueEmprunts.afficherParIdLivre(inputRecherche);
						}
						else
						{
							JOptionPane.showMessageDialog(LeftPanel4.getHistoriqueEmpruntsDialog(),"Id livre introuvable","Erreur",JOptionPane.ERROR_MESSAGE);
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(LeftPanel4.getHistoriqueEmpruntsDialog(),"Veillez saisir un Id livre correct","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (typeRecherche.equals("Id exemplaire"))
				{
					if(isNumeric(inputRecherche))
					{
						if(Emprunt.RechercheParIdExemplaire(inputRecherche))
						{
							TableHistoriqueEmprunts.afficherParIdExemplaire(inputRecherche);
						}
						else
						{
							JOptionPane.showMessageDialog(LeftPanel4.getHistoriqueEmpruntsDialog(),"Id livre introuvable","Erreur",JOptionPane.ERROR_MESSAGE);
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(LeftPanel4.getHistoriqueEmpruntsDialog(),"Veillez saisir un Id livre correct","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				
				
			}
		});
		btnRechercher.setBackground(new Color(36,72,54));
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
