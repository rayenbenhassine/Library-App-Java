package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import OracleBD.ConnecterBD;

public class ModifierLivrePanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5861980136603714602L;
	private JLabel lblAjouterLivre;
	private JLabel lblisbn;
	private JLabel lbltitre;
	private JLabel lblauteur;
	private JLabel lblNbPages;
	private JLabel lblTheme;
	private JLabel lblMaisonEdition;
	private JTextField txtisbn;
	private JTextField txttitre;
	private JTextField txtauteur;
	private JTextField txtNbPages;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTheme;
	private JTextField txtMaisonEdition;
	private JButton btnAnnuler;
	private JButton btnModifierLivre;
	

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ModifierLivrePanel(ModifierLivreDialog modifierLivreDialog)
	{
		this.setLayout(null);
		this.setBackground((new Color(53, 106, 106)));		
		lblAjouterLivre = new JLabel("Modifier Livre");
		this.add(lblAjouterLivre);
		lblAjouterLivre.setBounds(100, 0, 450, 60);
		lblAjouterLivre.setFont(new Font("Segoe UI",Font.BOLD,30));
		lblAjouterLivre.setForeground(Color.WHITE);
		
		
		lblisbn = new JLabel("ISBN :");
		this.add(lblisbn);
		lblisbn.setBounds(40, 100, 450, 60);
		lblisbn.setFont(new Font("Segoe UI",Font.BOLD,15));
		lblisbn.setForeground(Color.WHITE);

		

		txtisbn = new JTextField();
		this.add(txtisbn);
		txtisbn.setBounds(220, 115, 165, 28);
		
		
		lbltitre = new JLabel("Titre :");
		this.add(lbltitre);
		lbltitre.setBounds(40, 140, 450, 60);
		lbltitre.setFont(new Font("Segoe UI",Font.BOLD,15));
		lbltitre.setForeground(Color.WHITE);

		
		txttitre = new JTextField();
		this.add(txttitre);
		txttitre.setBounds(220, 155, 165, 28);
		
		
		
		lblauteur = new JLabel("Auteur :");
		this.add(lblauteur);
		lblauteur.setBounds(40, 180, 450, 60);
		lblauteur.setFont(new Font("Segoe UI",Font.BOLD,15));
		lblauteur.setForeground(Color.WHITE);

		
		txtauteur = new JTextField();
		this.add(txtauteur);
		txtauteur.setBounds(220, 195, 165, 28);
		
		
		lblNbPages = new JLabel("Nombre de pages :");
		this.add(lblNbPages);
		lblNbPages.setBounds(40, 220, 450, 60);
		lblNbPages.setFont(new Font("Segoe UI",Font.BOLD,15));
		lblNbPages.setForeground(Color.WHITE);

		
		txtNbPages = new JTextField();
		this.add(txtNbPages);
		txtNbPages.setBounds(220, 235, 165, 28);
		
		
		lblTheme = new JLabel("Thème :");
		this.add(lblTheme);
		lblTheme.setBounds(40, 260, 450, 60);
		lblTheme.setFont(new Font("Segoe UI",Font.BOLD,15));
		lblTheme.setForeground(Color.WHITE);

		
		String[] cbtab = {"Aventure","Action","Policier","Romance","Comedie","Horreur","Science fiction","Autre"};
		cbTheme = new JComboBox(cbtab);
		this.add(cbTheme);
		cbTheme.setBounds(220, 275, 165, 28);
		
		lblMaisonEdition = new JLabel("Maison d'édition :");
		this.add(lblMaisonEdition);
		lblMaisonEdition.setBounds(40, 300, 450, 60);
		lblMaisonEdition.setFont(new Font("Segoe UI",Font.BOLD,15));
		lblMaisonEdition.setForeground(Color.WHITE);

		
		txtMaisonEdition = new JTextField();
		this.add(txtMaisonEdition);
		txtMaisonEdition.setBounds(220, 315, 165, 28);
		
		btnModifierLivre = new JButton("Modifier");
		this.add(btnModifierLivre);
		btnModifierLivre.setBounds(100, 450, 100, 30);
		btnModifierLivre.setBackground(new Color(41, 125, 125));
		btnModifierLivre.setForeground(Color.WHITE);
		btnModifierLivre.setFont(new Font("Segoe UI",Font.BOLD,16));
		
	

		
		btnAnnuler = new JButton("Annuler");
		this.add(btnAnnuler);
		btnAnnuler.setBounds(220, 450, 100, 30);
		btnAnnuler.setBackground(new Color(41, 125, 125));
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Segoe UI",Font.BOLD,16));

		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifierLivreDialog.dispose();
			}
		});
		

		DefaultTableModel model = (DefaultTableModel) CentrePanel2.getTableLivres().getModel();
		int selectedRowIndex = CentrePanel2.getTableLivres().getSelectedRow();
		txtisbn.setText(model.getValueAt(selectedRowIndex, 1).toString());
		txttitre.setText(model.getValueAt(selectedRowIndex, 2).toString());
		txtauteur.setText(model.getValueAt(selectedRowIndex, 3).toString());
		txtNbPages.setText(model.getValueAt(selectedRowIndex, 4).toString());
		cbTheme.setSelectedItem(model.getValueAt(selectedRowIndex, 5).toString());
		txtMaisonEdition.setText(model.getValueAt(selectedRowIndex, 6).toString());
		
		btnModifierLivre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String titre = txttitre.getText();
				String auteur = txtauteur.getText();
				String theme = (String)cbTheme.getSelectedItem();
				String maisonEdition = txtMaisonEdition.getText();
				boolean ok1 = true;
				boolean ok2 = true;
				long isbn = 0;
				if (!txtisbn.getText().equals(""))
					try {
						isbn = Long.parseLong(txtisbn.getText());
					} catch (NumberFormatException e1) {
						ok1 = false;
					}					
				@SuppressWarnings("unused")
				int nbPages = 0;
				if (!txtNbPages.getText().equals(""))
					try {
						nbPages = Integer.parseInt(txtNbPages.getText());
					} catch (NumberFormatException e1) {
						ok2 = false;
					}
				if (titre.equals("") || auteur.equals("") || theme.equals("") || maisonEdition.equals("") || txtisbn.getText().equals("") || txtNbPages.getText().equals(""))
					JOptionPane.showMessageDialog(LeftPanel.getAjouterAbonneDialog(),"Remplir tous les champs","Erreur",JOptionPane.ERROR_MESSAGE);
				else if (ok1 == false)
					JOptionPane.showMessageDialog(LeftPanel.getAjouterAbonneDialog(),"Veuillez saisir un ISBN correct","Erreur",JOptionPane.ERROR_MESSAGE);
				else if(txtisbn.getText().length() != 10)
					JOptionPane.showMessageDialog(LeftPanel.getAjouterAbonneDialog(),"l'ISBN doit comporter 10 chiffres","Erreur",JOptionPane.ERROR_MESSAGE);
				else if (ok2 == false)
					JOptionPane.showMessageDialog(LeftPanel.getAjouterAbonneDialog(),"Veuillez saisir un nombre de page correct","Erreur",JOptionPane.ERROR_MESSAGE);
				else
				{
					ConnecterBD.executeQuery("update livre set isbn = " + txtisbn.getText() + " where id_livre = " + model.getValueAt(selectedRowIndex, 0));
					ConnecterBD.executeQuery("update livre set titre = '" + txttitre.getText() + "' where id_livre = " + model.getValueAt(selectedRowIndex, 0));
					ConnecterBD.executeQuery("update livre set auteur = '" + txtauteur.getText() + "' where id_livre = " + model.getValueAt(selectedRowIndex, 0));
					ConnecterBD.executeQuery("update livre set nb_pages = " + txtNbPages.getText() + " where id_livre = " + model.getValueAt(selectedRowIndex, 0));
					ConnecterBD.executeQuery("update livre set theme = '" + cbTheme.getSelectedItem() + "' where id_livre = " + model.getValueAt(selectedRowIndex, 0));
					ConnecterBD.executeQuery("update livre set maison_edition = '" + txtMaisonEdition.getText() + "' where id_livre = " + model.getValueAt(selectedRowIndex, 0));
				}
				TableLivres.afficherTous();
			}
			
		});
	}

}

