package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import OracleBD.ConnecterBD;

public class LeftPanel5 extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8887485329344245070L;
	private JButton btnRetour;
	private JButton btnSupprimer;
	private JButton btnAfficher;

	
	public LeftPanel5()
	{
		this.setLayout(null);
		this.setPreferredSize(new Dimension(200,0));
		
		btnRetour = new JButton("Annuler");
		this.add(btnRetour);
		btnRetour.setBounds(25, 25, 150, 35);
		btnRetour.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnRetour.setForeground(Color.black);
		btnRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				LeftPanel4.getHistoriqueEmpruntsDialog().dispose();
			}
		});
		
		
		btnSupprimer = new JButton("Supprimer");
		this.add(btnSupprimer);
		btnSupprimer.setBounds(25, 280, 150, 35);
		btnSupprimer.setBackground(new Color(36,72,54));
		btnSupprimer.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				DefaultTableModel model = (DefaultTableModel) CentrePanel5.getTableHistoriqueEmprunts().getModel();
				int selectedRowIndex = CentrePanel5.getTableHistoriqueEmprunts().getSelectedRow();

				ConnecterBD.executeQuery("delete from emprunter where id_emprunter = " + model.getValueAt(selectedRowIndex, 0));
				TableHistoriqueEmprunts.afficherTous();
			}
		});
		
		btnAfficher = new JButton("Tout Afficher");
		this.add(btnAfficher);
		btnAfficher.setBounds(25, 340, 150, 35);
		btnAfficher.setBackground(new Color(36,72,54));
		btnAfficher.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnAfficher.setForeground(Color.WHITE);;	
		btnAfficher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				TableHistoriqueEmprunts.afficherTous();
			}
		});

	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		GradientPaint grad = new GradientPaint(100, 100, new Color(63,123,93), 500, getHeight(), Color.WHITE);
		g2.setPaint(grad);
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
}