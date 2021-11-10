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

import Classes.Exemplaire;
import OracleBD.ConnecterBD;

public class AjouterExemplairePanel extends JPanel
{
	private static final long serialVersionUID = 8900828850675256987L;
	private JLabel lblAjouterExemplaire;
	private JLabel lblDateAcquisition;
	private JTextField txtDateAcquisition;
	private JLabel lblEtat;
	@SuppressWarnings("rawtypes")
	private JComboBox cbEtat;
	private JButton btnAjouterExemplaire;
	private JButton btnAnnuler;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AjouterExemplairePanel(AjouterExemplaireDialog ajouterExemplaireDialog) 
	{
		this.setLayout(null);
		this.setBackground(new Color(35,106,106));
		
		lblAjouterExemplaire = new JLabel("Ajouter exemplaire");
		this.add(lblAjouterExemplaire);
		lblAjouterExemplaire.setBounds(80, 0, 450, 40);
		lblAjouterExemplaire.setFont(new Font("Segoe UI",Font.BOLD,20));
		lblAjouterExemplaire.setForeground(Color.WHITE);

		lblDateAcquisition = new JLabel("Date d'acquisition :");
		this.add(lblDateAcquisition);
		lblDateAcquisition.setBounds(30, 70, 120, 30);
		lblDateAcquisition.setFont(new Font("Segoe UI",Font.BOLD,13));
		lblDateAcquisition.setForeground(Color.WHITE);
		
		txtDateAcquisition = new JTextField();
		this.add(txtDateAcquisition);
		txtDateAcquisition.setBounds(160, 70, 150, 28);
		
		lblEtat = new JLabel("Etat :");
		this.add(lblEtat);
		lblEtat.setBounds(30, 120, 120, 30);
		lblEtat.setFont(new Font("Segoe UI",Font.BOLD,13));
		lblEtat.setForeground(Color.WHITE);

		String[] cbtab = {"Neuf","Bon","Vieux"};
		cbEtat = new JComboBox(cbtab);
		this.add(cbEtat);
		cbEtat.setBounds(160, 120, 150, 28);
		
		
		btnAjouterExemplaire = new JButton("Ajouter");
		this.add(btnAjouterExemplaire);
		btnAjouterExemplaire.setBounds(50, 180, 100, 30);
		btnAjouterExemplaire.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Exemplaire exemplaire = createExemplaire();
				if (exemplaire == null)
				{
					JOptionPane.showMessageDialog(LeftPanel2.getExemplairesDialog(),"Veuillez remplir tous les champs","Erreur",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					exemplaire.ajouterExemplaire();
					TableExemplaires.afficherTous();
					NorthPanel3.refresh();
				}
				
			}
		});
		btnAjouterExemplaire.setBackground(new Color(35,106,106));
		btnAjouterExemplaire.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnAjouterExemplaire.setForeground(Color.WHITE);

		btnAnnuler = new JButton("Annuler");
		this.add(btnAnnuler);
		btnAnnuler.setBounds(180, 180, 100, 30);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ajouterExemplaireDialog.dispose();
			}
		});
		btnAnnuler.setBackground(new Color(35,106,106));
		btnAnnuler.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnAnnuler.setForeground(Color.WHITE);
	}
	
	
	private Exemplaire createExemplaire()
	{
		String dateAcquisition = txtDateAcquisition.getText();
		String etat = (String)cbEtat.getSelectedItem();
	
		if(!(dateAcquisition.equals("") || etat.equals("")))
		{
			int id_exemplaire = 0;
			
			
			DefaultTableModel model = (DefaultTableModel) CentrePanel2.getTableLivres().getModel();
			int selectedRowIndex = CentrePanel2.getTableLivres().getSelectedRow();
			Integer id_livre = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
			ConnecterBD.executeQuery("drop sequence seq_id_exemplaire_" + id_livre);
			ConnecterBD.executeQuery("create sequence seq_id_exemplaire_" + id_livre +" start with 1");
			boolean ok = true;
			while (ok)
			{
				ResultSet result_seq = ConnecterBD.executeSelectQuery("select seq_id_exemplaire_"+id_livre+".nextval from dual");
				try {
					while(result_seq.next())
						if (rechercher_idExemplaire_seq(result_seq.getInt(1),id_livre) == false) //rechercher si le nextval de la nouvelle sequance créé existe deja comme id_abonne
						{
							id_exemplaire = result_seq.getInt("nextval");
							ok = false;
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			Exemplaire exemplaire = new Exemplaire(id_exemplaire,dateAcquisition,id_livre,etat);
			return exemplaire;
		}
		else
		{
			return null;
		}
	}
	

	private boolean rechercher_idExemplaire_seq(int nextval,int id_livre)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select id_exemplaire from exemplaire where id_livre = " + id_livre);
		try 
		{
			while (result.next())
			{
				if (result.getInt(1) == nextval)
					return true;
			}
			return false;
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	

	
}
