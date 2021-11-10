package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import OracleBD.ConnecterBD;

public class ModifierAbonnePanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2420722122798840925L;
	private JLabel lblModifierAbonne;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblDate;
	private JLabel lblEmail;
	private JLabel lblStatut;
	private JLabel lblTel;
	private JLabel lblAdr;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtDate;
	private JTextField txtEmail;
	@SuppressWarnings("rawtypes")
	private JComboBox cbStatut;
	private JTextField txtTel;
	private JTextField txtAdr;
	private JButton btnModifierAbonne;
	private JButton btnAnnuler;

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ModifierAbonnePanel(ModifierAbonneDialog modifierAbonneDialog)
	{
		this.setLayout(null);
		this.setBackground(new Color(152,14,33));
		
		lblModifierAbonne = new JLabel("Modifier Abonne");
		this.add(lblModifierAbonne);
		lblModifierAbonne.setBounds(100, 0, 450, 60);
		lblModifierAbonne.setFont(new Font("Arial",Font.BOLD,30));
		lblModifierAbonne.setForeground(Color.WHITE);
		
		lblNom = new JLabel("Nom :");
		this.add(lblNom);
		lblNom.setBounds(40, 100, 450, 60);
		lblNom.setFont(new Font("Arial",Font.BOLD,15));
		lblNom.setForeground(Color.WHITE);


		txtNom = new JTextField();
		this.add(txtNom);
		txtNom.setBounds(220, 115, 165, 28);
		
		
		lblPrenom = new JLabel("Prenom :");
		this.add(lblPrenom);
		lblPrenom.setBounds(40, 140, 450, 60);
		lblPrenom.setFont(new Font("Arial",Font.BOLD,15));
		lblPrenom.setForeground(Color.WHITE);

		txtPrenom = new JTextField();
		this.add(txtPrenom);
		txtPrenom.setBounds(220, 155, 165, 28);
		
		
		
		lblDate = new JLabel("Date de naissance :");
		this.add(lblDate);
		lblDate.setBounds(40, 180, 450, 60);
		lblDate.setFont(new Font("Arial",Font.BOLD,15));
		lblDate.setForeground(Color.WHITE);
		
		txtDate = new JTextField();
		this.add(txtDate);
		txtDate.setBounds(220, 195, 165, 28);
		
		
		lblEmail = new JLabel("Email :");
		this.add(lblEmail);
		lblEmail.setBounds(40, 220, 450, 60);
		lblEmail.setFont(new Font("Arial",Font.BOLD,15));
		lblEmail.setForeground(Color.WHITE);

		txtEmail = new JTextField();
		this.add(txtEmail);
		txtEmail.setBounds(220, 235, 165, 28);
		
		
		lblStatut = new JLabel("Statut :");
		this.add(lblStatut);
		lblStatut.setBounds(40, 260, 450, 60);
		lblStatut.setFont(new Font("Arial",Font.BOLD,15));
		lblStatut.setForeground(Color.WHITE);

		String[] cbtab = {"Etudiant","Enseignant","Autre"};
		cbStatut = new JComboBox(cbtab);
		this.add(cbStatut);
		cbStatut.setBounds(220, 275, 165, 28);
		
		lblTel = new JLabel("Tel :");
		this.add(lblTel);
		lblTel.setBounds(40, 300, 450, 60);
		lblTel.setFont(new Font("Arial",Font.BOLD,15));
		lblTel.setForeground(Color.WHITE);

		txtTel = new JTextField();
		this.add(txtTel);
		txtTel.setBounds(220, 315, 165, 28);
		
		lblAdr = new JLabel("Adresse :");
		this.add(lblAdr);
		lblAdr.setBounds(40, 340, 450, 60);
		lblAdr.setFont(new Font("Arial",Font.BOLD,15));
		lblAdr.setForeground(Color.WHITE);

		txtAdr = new JTextField();
		this.add(txtAdr);
		txtAdr.setBounds(220, 355, 165, 28);
		
		btnModifierAbonne = new JButton("Modifier");
		this.add(btnModifierAbonne);
		btnModifierAbonne.setBounds(100, 450, 100, 30);
		btnModifierAbonne.setBackground(new Color(159,9,29));
		btnModifierAbonne.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnModifierAbonne.setForeground(Color.WHITE);
		
		btnAnnuler = new JButton("Annuler");
		this.add(btnAnnuler);
		btnAnnuler.setBounds(220, 450, 100, 30);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifierAbonneDialog.dispose();
			}
		});
		btnAnnuler.setBackground(new Color(159,9,29));
		btnAnnuler.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnAnnuler.setForeground(Color.WHITE);

		DefaultTableModel model = (DefaultTableModel) CentrePanel.getTableAbonnes().getModel();
		int selectedRowIndex = CentrePanel.getTableAbonnes().getSelectedRow();
		txtNom.setText(model.getValueAt(selectedRowIndex, 1).toString());
		txtPrenom.setText(model.getValueAt(selectedRowIndex, 2).toString());
		txtDate.setText(model.getValueAt(selectedRowIndex, 3).toString());
		txtEmail.setText(model.getValueAt(selectedRowIndex, 4).toString());
		cbStatut.setSelectedItem(model.getValueAt(selectedRowIndex, 5).toString());
		txtTel.setText(model.getValueAt(selectedRowIndex, 6).toString());
		txtAdr.setText(model.getValueAt(selectedRowIndex, 7).toString());
		btnModifierAbonne.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String date = txtDate.getText();
				String email = txtEmail.getText();
				String statut = (String)cbStatut.getSelectedItem();
				String adrsesse = txtAdr.getText();
				long tel = 0;
				boolean ok = true;
				if (!txtTel.getText().equals(""))
					try 
					{
						tel = Long.parseLong(txtTel.getText());
					} 
					catch (NumberFormatException e1)
					{
						ok = false;
					}
				if (nom.equals("") || prenom.equals("") || date.equals("") || email.equals("") || txtTel.getText().equals("") || adrsesse.equals(""))
					JOptionPane.showMessageDialog(LeftPanel.getAjouterAbonneDialog(),"Remplir tous les champs","Erreur",JOptionPane.ERROR_MESSAGE);
				else if (ok == false)
					JOptionPane.showMessageDialog(LeftPanel.getAjouterAbonneDialog(),"Veuillez saisir un Tel valide","Erreur",JOptionPane.ERROR_MESSAGE);
				else if (txtTel.getText().length() != 8)
					JOptionPane.showMessageDialog(LeftPanel.getAjouterAbonneDialog(),"Tel doit comporter 8 chiffres","Erreur",JOptionPane.ERROR_MESSAGE);
				else
				{
					ConnecterBD.executeQuery("update abonne set nom_abonne = '" + txtNom.getText() + "' where id_abonne = " + model.getValueAt(selectedRowIndex, 0));
					ConnecterBD.executeQuery("update abonne set prenom_abonne = '" + txtPrenom.getText() + "' where id_abonne = " + model.getValueAt(selectedRowIndex, 0));
					ConnecterBD.executeQuery("update abonne set date_naissance = '" + txtDate.getText() + "' where id_abonne = " + model.getValueAt(selectedRowIndex, 0));
					ConnecterBD.executeQuery("update abonne set email = '" + txtEmail.getText() + "' where id_abonne = " + model.getValueAt(selectedRowIndex, 0));
					ConnecterBD.executeQuery("update abonne set statut = '" + cbStatut.getSelectedItem() + "' where id_abonne = " + model.getValueAt(selectedRowIndex, 0));
					ConnecterBD.executeQuery("update abonne set tel = '" + txtTel.getText() + "' where id_abonne = " + model.getValueAt(selectedRowIndex, 0));
					ConnecterBD.executeQuery("update abonne set adresse = '" + txtAdr.getText() + "' where id_abonne = " + model.getValueAt(selectedRowIndex, 0));
					
					TableAbonnes.afficherTous();
				}

			}
		});
	}
	
	
}
