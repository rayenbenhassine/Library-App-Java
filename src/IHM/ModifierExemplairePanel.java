package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import OracleBD.ConnecterBD;

public class ModifierExemplairePanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8825517929800498063L;
	private JLabel lblModifierExemplaire;
	private JLabel lblDateAcquisition;
	private JTextField txtDateAcquisition;
	private JLabel lblEtat;
	@SuppressWarnings("rawtypes")
	private JComboBox cbEtat;
	private JButton btnModifierExemplaire;
	private JButton btnAnnuler;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ModifierExemplairePanel(ModifierExemplaireDialog modifierExemplaireDialog) 
	{
		this.setLayout(null);
		this.setBackground(new Color(35,106,106));
		
		DefaultTableModel model = (DefaultTableModel) CentrePanel3.getTableExemplaires().getModel();
		int selectedRowIndex = CentrePanel3.getTableExemplaires().getSelectedRow();
		
		
		lblModifierExemplaire = new JLabel("Modifier exemplaire");
		this.add(lblModifierExemplaire);
		lblModifierExemplaire.setBounds(80, 0, 450, 40);
		lblModifierExemplaire.setFont(new Font("Segoe UI",Font.BOLD,20));
		lblModifierExemplaire.setForeground(Color.WHITE);
		
		lblDateAcquisition = new JLabel("Date d'acquisition :");
		this.add(lblDateAcquisition);
		lblDateAcquisition.setBounds(30, 70, 120, 30);
		lblDateAcquisition.setFont(new Font("Segoe UI",Font.BOLD,13));
		lblDateAcquisition.setForeground(Color.WHITE);
		
		txtDateAcquisition = new JTextField();
		this.add(txtDateAcquisition);
		txtDateAcquisition.setBounds(160, 70, 150, 28);
		txtDateAcquisition.setText(model.getValueAt(selectedRowIndex, 1).toString());
		
		lblEtat = new JLabel("Etat :");
		this.add(lblEtat);
		lblEtat.setBounds(30, 120, 120, 30);
		lblEtat.setFont(new Font("Segoe UI",Font.BOLD,13));
		lblEtat.setForeground(Color.WHITE);
		
		String[] cbtab = {"Neuf","Bon","Vieux"};
		cbEtat = new JComboBox(cbtab);
		this.add(cbEtat);
		cbEtat.setBounds(160, 120, 150, 28);
		cbEtat.setSelectedItem(model.getValueAt(selectedRowIndex, 2).toString());

		
		btnModifierExemplaire = new JButton("Modifier");
		this.add(btnModifierExemplaire);
		btnModifierExemplaire.setBounds(50, 180, 100, 30);
		btnModifierExemplaire.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				DefaultTableModel model2 = (DefaultTableModel) CentrePanel2.getTableLivres().getModel();
				int selectedRowIndex2 = CentrePanel2.getTableLivres().getSelectedRow();
				ConnecterBD.executeQuery("update exemplaire set date_acquisition = '" + txtDateAcquisition.getText() + "' where id_livre = " + model2.getValueAt(selectedRowIndex2, 0).toString() + " and id_exemplaire = " + model.getValueAt(selectedRowIndex, 0).toString());
				ConnecterBD.executeQuery("update exemplaire set etat = '" + cbEtat.getSelectedItem() + "' where id_livre = " + model2.getValueAt(selectedRowIndex2, 0).toString()+ " and id_exemplaire = " + model.getValueAt(selectedRowIndex, 0).toString());
				TableExemplaires.afficherTous();
			}
		});
		btnModifierExemplaire.setBackground(new Color(35,106,106));
		btnModifierExemplaire.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnModifierExemplaire.setForeground(Color.WHITE);

		btnAnnuler = new JButton("Annuler");
		this.add(btnAnnuler);
		btnAnnuler.setBounds(180, 180, 100, 30);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifierExemplaireDialog.dispose();
			}
		});
		btnAnnuler.setBackground(new Color(35,106,106));
		btnAnnuler.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnAnnuler.setForeground(Color.WHITE);
	}
	
	
	
}
