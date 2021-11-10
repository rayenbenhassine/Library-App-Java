package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import OracleBD.ConnecterBD;

public class RendrePanel extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9033058897398298595L;
	private JLabel lblDateRetour;
	private JTextField txtDateRetour;
	private JButton btnAnnuler;
	private JButton btnRendre;
	private JLabel lblRendre;

	public RendrePanel(RendreDialog rendreDialog) 
	{
		this.setLayout(null);
		this.setBackground(new Color(63,123,93));
		
		lblRendre = new JLabel("RENDRE");
		this.add(lblRendre);
		lblRendre.setBounds(165, 0, 450, 40);
		lblRendre.setFont(new Font("Segoe UI",Font.BOLD,20));
		lblRendre.setForeground(Color.WHITE);
		
		lblDateRetour = new JLabel("Date Retour :");
		this.add(lblDateRetour);
		lblDateRetour.setBounds(80, 70, 120, 30);
		lblDateRetour.setFont(new Font("Segoe UI",Font.BOLD,13));
		lblDateRetour.setForeground(Color.WHITE);
		
		txtDateRetour = new JTextField();
		this.add(txtDateRetour);
		txtDateRetour.setBounds(210, 70, 150, 28);
		
		btnRendre = new JButton("Rendre");
		this.add(btnRendre);
		btnRendre.setBounds(100, 130, 100, 30);
		btnRendre.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			DefaultTableModel model = (DefaultTableModel) EmpruntsPanel.getTableEmpurunts().getModel();
			int selectedRowIndex = EmpruntsPanel.getTableEmpurunts().getSelectedRow();
			ConnecterBD.executeQuery("update emprunter set statut = 'rendu' where id_emprunter = " + model.getValueAt(selectedRowIndex, 0));
			ConnecterBD.executeQuery("update emprunter set date_retour = '" + txtDateRetour.getText() + "' where id_emprunter = " + model.getValueAt(selectedRowIndex, 0));
			TableEmprunts.afficherTous();
			TableDisponibles.afficherTous();
		}
	});
		btnRendre.setBackground(new Color(36,72,54));
		btnRendre.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnRendre.setForeground(Color.WHITE);
		
		btnAnnuler = new JButton("Annuler");
		this.add(btnAnnuler);
		btnAnnuler.setBounds(220, 130, 100, 30);
		btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rendreDialog.dispose();
			}
		});
		btnAnnuler.setBackground(new Color(36,72,54));
		btnAnnuler.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnAnnuler.setForeground(Color.WHITE);
	}
	
}
