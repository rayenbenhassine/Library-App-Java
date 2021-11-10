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

import Classes.Abonne;
import OracleBD.ConnecterBD;

public class AjouterAbonnePanel extends JPanel
{
	private static final long serialVersionUID = -7537814581251948880L;
	private JLabel lblAjouterAbonne;
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
	private JButton btnAjouterAbonne;
	private JButton btnAnnuler;

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AjouterAbonnePanel(AjouterAbonneDialog ajouterAbonneDialog)
	{
		this.setLayout(null);
		this.setBackground(new Color(152,14,33));
		
		lblAjouterAbonne = new JLabel("Ajouter Abonne");
		this.add(lblAjouterAbonne);
		lblAjouterAbonne.setBounds(100, 0, 450, 60);
		lblAjouterAbonne.setFont(new Font("Arial",Font.BOLD,30));
		lblAjouterAbonne.setForeground(Color.WHITE);
		
		
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
		
		btnAjouterAbonne = new JButton("Ajouter");
		this.add(btnAjouterAbonne);
		btnAjouterAbonne.setBounds(100, 450, 100, 30);
		btnAjouterAbonne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Abonne abonne = createAbonne();
				if (abonne == null)
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
					else if (VerifExistance(nom, prenom, date, email, statut, adrsesse, tel))
						JOptionPane.showMessageDialog(LeftPanel.getAjouterAbonneDialog(),"Abonne existant","Erreur",JOptionPane.ERROR_MESSAGE);

				}
				else
				{
					abonne.ajouterAbonne();
					TableAbonnes.afficherTous();
				}
				
			}
		});
		btnAjouterAbonne.setBackground(new Color(159,9,29));
		btnAjouterAbonne.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnAjouterAbonne.setForeground(Color.WHITE);
		
		btnAnnuler = new JButton("Annuler");
		this.add(btnAnnuler);
		btnAnnuler.setBounds(220, 450, 100, 30);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ajouterAbonneDialog.dispose();
			}
		});
		btnAnnuler.setBackground(new Color(159,9,29));
		btnAnnuler.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnAnnuler.setForeground(Color.WHITE);
	}
	
	
	private Abonne createAbonne()
	{
		String nom = txtNom.getText();
		String prenom = txtPrenom.getText();
		String date = txtDate.getText();
		String email = txtEmail.getText();
		String statut = (String)cbStatut.getSelectedItem();
		String adrsesse = txtAdr.getText();
		long tel = 0;
		if (!txtTel.getText().equals(""))
			try 
			{
				tel = Long.parseLong(txtTel.getText());
			} 
			catch (NumberFormatException e1)
			{
				return null;
			}

		if(!(nom.equals("") || prenom.equals("") || date.equals("") || email.equals("") || txtTel.getText().equals("") || adrsesse.equals("")) && txtTel.getText().length() == 8 && VerifExistance(nom,prenom,date,email,statut,adrsesse,tel) == false)
		{
			String login = ConnectionPanel.getGestionnaire().getLogin();
			int id_abonne = 0;
			
			ConnecterBD.executeQuery("drop sequence seq_id_abonne");
			ConnecterBD.executeQuery("create sequence seq_id_abonne start with 1");
			
			boolean ok = true;
			while (ok)
			{
				ResultSet result_seq = ConnecterBD.executeSelectQuery("select seq_id_abonne.nextval from dual");
				try {
					while(result_seq.next())
						if (rechercher_id_seq(result_seq.getInt(1)) == false) //rechercher si le nextval de la nouvelle sequance créé existe deja comme id_abonne
						{
							id_abonne = result_seq.getInt("nextval");
							ok = false;
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			Abonne abonne = new Abonne(id_abonne,nom,prenom,date,email,statut,tel,adrsesse,login);
			
			return abonne;
		}
		else
		{
			return null;
		}
	}
	


	private boolean VerifExistance(String nom, String prenom, String date, String email, String statut, String adresse,
			long tel) 
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select nom_abonne,prenom_abonne,date_naissance,email,statut,tel,adresse from abonne");
		try {
			while (result.next())
			{
				if(result.getString("nom_abonne").equals(nom) && result.getString("prenom_abonne").equals(prenom) && result.getString("email").equals(email) && result.getString("statut").equals(statut) && result.getLong("tel") == tel && result.getString("adresse").equals(adresse))
					return true;
			}
		} 
		catch (SQLException e)
		{
			return false;
		}
		return false;
	}


	private boolean rechercher_id_seq(int nextval)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select id_abonne from abonne");
		try {
			while (result.next())
			{
				if (result.getInt(1) == nextval)
					return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
