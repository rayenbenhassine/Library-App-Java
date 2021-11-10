package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Classes.Emprunt;
import OracleBD.ConnecterBD;

public class EmprunterPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1072375726341015959L;
	private JLabel lblIdAbonne;
	private JLabel lblDateEmprunt;
	private JLabel lblDateRetour;
	@SuppressWarnings("rawtypes")
	private JComboBox cbIdAbonne;
	private JTextField txtDateEmprunt;
	private JTextField txtDateRetour;
	private JButton btnAnnuler;
	private JLabel lblEmprunter;
	private JButton btnAjouter;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EmprunterPanel(EmprunterDialog emprunterDialog) 
	{
		this.setLayout(null);
		this.setBackground(new Color(63,123,93));
		
		lblEmprunter = new JLabel("EMPRUNTER");
		this.add(lblEmprunter);
		lblEmprunter.setBounds(150, 0, 450, 40);
		lblEmprunter.setFont(new Font("Segoe UI",Font.BOLD,20));
		lblEmprunter.setForeground(Color.WHITE);
		
		lblIdAbonne = new JLabel("Id abonne");
		this.add(lblIdAbonne);
		lblIdAbonne.setBounds(80, 75, 450, 40);
		lblIdAbonne.setFont(new Font("Segoe UI",Font.BOLD,13));
		lblIdAbonne.setForeground(Color.WHITE);

		
		
		Vector<Integer> VectorId = new Vector<Integer>();
		ResultSet result = ConnecterBD.executeSelectQuery("select id_abonne from abonne");
		try {
			while (result.next())
			{
				VectorId.add(result.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cbIdAbonne = new JComboBox(VectorId);
		this.add(cbIdAbonne);
		cbIdAbonne.setBounds(210, 80, 100, 25);		
		
		lblDateEmprunt = new JLabel("Date d'emprunt :");
		this.add(lblDateEmprunt);
		lblDateEmprunt.setBounds(80, 120, 120, 30);
		lblDateEmprunt.setFont(new Font("Segoe UI",Font.BOLD,13));
		lblDateEmprunt.setForeground(Color.WHITE);

		txtDateEmprunt = new JTextField();
		this.add(txtDateEmprunt);
		txtDateEmprunt.setBounds(210, 120, 150, 28);
		
		lblDateRetour = new JLabel("Date Retour :");
		this.add(lblDateRetour);
		lblDateRetour.setBounds(80, 160, 120, 30);
		lblDateRetour.setFont(new Font("Segoe UI",Font.BOLD,13));
		lblDateRetour.setForeground(Color.WHITE);

		txtDateRetour = new JTextField();
		this.add(txtDateRetour);
		txtDateRetour.setBounds(210, 160, 150, 28);
		
		btnAjouter = new JButton("Ajouter");
		this.add(btnAjouter);
		btnAjouter.setBounds(100, 230, 100, 30);
		btnAjouter.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Emprunt emprunt = createEmprunt();
			if (emprunt == null)
			{
				JOptionPane.showMessageDialog(LeftPanel4.getEmprunterDialog(),"Remplir tous les champs","Erreur",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				emprunt.ajouterEmprunt();
				TableEmprunts.afficherTous();
				TableDisponibles.afficherTous();
				int n = JOptionPane.showConfirmDialog(LeftPanel4.getEmprunterDialog(),"Emprunt ajoutée avec succes","Succes",JOptionPane.OK_CANCEL_OPTION);
				if (n == JOptionPane.OK_OPTION || n == JOptionPane.CANCEL_OPTION || n == JOptionPane.CLOSED_OPTION)
					LeftPanel4.getEmprunterDialog().dispose();
			}
		}
	});
		btnAjouter.setBackground(new Color(36,72,54));
		btnAjouter.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnAjouter.setForeground(Color.WHITE);
		
		btnAnnuler = new JButton("Annuler");
		this.add(btnAnnuler);
		btnAnnuler.setBounds(240, 230, 100, 30);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				emprunterDialog.dispose();
			}
		});
		btnAnnuler.setBackground(new Color(36,72,54));
		btnAnnuler.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnAnnuler.setForeground(Color.WHITE);
	}
	
	private Emprunt createEmprunt()
	{
		int id_abonne = Integer.parseInt(cbIdAbonne.getSelectedItem().toString());
		DefaultTableModel model = (DefaultTableModel) DisponiblesPanel.getTableDisponibles().getModel();
		int selectedRowIndex = DisponiblesPanel.getTableDisponibles().getSelectedRow();
		int id_exemplaire = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
		int id_livre = Integer.parseInt(NorthPanel4.getCbId().getSelectedItem().toString());
		String date_emprunt = txtDateEmprunt.getText();
		String date_retour = txtDateRetour.getText();
		String statut = "en cours";

		
		if(!(date_emprunt.equals("") || date_retour.equals("")))
		{
			int id_emprunt = 0;
			
			ConnecterBD.executeQuery("drop sequence seq_id_emprunt");
			ConnecterBD.executeQuery("create sequence seq_id_emprunt start with 1");
			
			boolean ok = true;
			while (ok)
			{
				ResultSet result_seq = ConnecterBD.executeSelectQuery("select seq_id_emprunt.nextval from dual");
				try {
					while(result_seq.next())
						if (rechercher_id_seq(result_seq.getInt(1)) == false) //rechercher si le nextval de la nouvelle sequance créé existe deja comme id_abonne
						{
							id_emprunt = result_seq.getInt("nextval");
							ok = false;
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			Emprunt emprunt = new Emprunt(id_emprunt,id_abonne,id_exemplaire,id_livre,date_emprunt,date_retour,statut);
			
			return emprunt;
		}
		else
		{
			return null;
		}
	}
	
	private boolean rechercher_id_seq(int nextval)
	{
		ResultSet result = ConnecterBD.executeSelectQuery("select id_emprunter from emprunter");
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
