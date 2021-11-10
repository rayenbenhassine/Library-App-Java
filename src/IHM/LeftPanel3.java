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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import OracleBD.ConnecterBD;

public class LeftPanel3 extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -331847299238475179L;
	private JButton btnRetour;
	private JButton btnAjouter;
	private JButton btnAfficher;
	private JButton btnModifier;
	private JButton btnSupprimer;
	public LeftPanel3()
	{
		this.setBackground(Color.orange);
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
				LeftPanel2.getExemplairesDialog().dispose();
			}
		});

		
		btnAjouter = new JButton("Ajouter");
		this.add(btnAjouter);
		btnAjouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new AjouterExemplaireDialog();
			}
		});
		btnAjouter.setBounds(25, 260, 150, 35);
		btnAjouter.setBackground(new Color(41,125,125));
		btnAjouter.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnAjouter.setForeground(Color.WHITE);

		btnAfficher = new JButton("Afficher");
		this.add(btnAfficher);
		btnAfficher.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				CentrePanel3.getTableExemplaires().afficherTous();
			}
		});
		btnAfficher.setBounds(25, 320, 150, 35);
		btnAfficher.setBackground(new Color(41,125,125));
		btnAfficher.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnAfficher.setForeground(Color.WHITE);

		btnModifier = new JButton("Modifier");
		this.add(btnModifier);
		btnModifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (CentrePanel3.getTableExemplaires().getSelectedRow() != -1)
				{
					new ModifierExemplaireDialog();
				}
				else
				{
					JOptionPane.showMessageDialog(LeftPanel2.getExemplairesDialog(),"Veuillez selectionner un exemplaire","Info",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnModifier.setBounds(25, 380, 150, 35);
		btnModifier.setBackground(new Color(41,125,125));
		btnModifier.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnModifier.setForeground(Color.WHITE);
		
		btnSupprimer = new JButton("Supprimer");
		this.add(btnSupprimer);
		btnSupprimer.setBounds(25, 440, 150, 30);
		btnSupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (CentrePanel3.getTableExemplaires().getSelectedRow() != -1)
				{
					int n = JOptionPane.showConfirmDialog(LeftPanel2.getExemplairesDialog(),"La suppression de l'exemplaire supprimera tous les emprunts correspondants","Info",JOptionPane.OK_CANCEL_OPTION);
					if(n == JOptionPane.OK_OPTION)
					{
						DefaultTableModel model = (DefaultTableModel) CentrePanel3.getTableExemplaires().getModel();
						int selectedRowIndex = CentrePanel3.getTableExemplaires().getSelectedRow();
						DefaultTableModel model2 = (DefaultTableModel) CentrePanel2.getTableLivres().getModel();
						int selectedRowIndex2 = CentrePanel2.getTableLivres().getSelectedRow();
						ConnecterBD.executeQuery("delete from exemplaire where id_exemplaire = " + model.getValueAt(selectedRowIndex, 0) + " and id_livre = " + model2.getValueAt(selectedRowIndex2, 0));
						ConnecterBD.executeQuery("delete from emprunter where id_exemplaire = " + model.getValueAt(selectedRowIndex, 0) + " and id_livre = " + model2.getValueAt(selectedRowIndex2, 0));
						TableExemplaires.afficherTous();
					}
				}
				else
					JOptionPane.showMessageDialog(LeftPanel2.getExemplairesDialog(),"Veuillez selectionner un exemplaire","Info",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		
		btnSupprimer.setBounds(25, 440, 150, 35);
		btnSupprimer.setBackground(new Color(41,125,125));
		btnSupprimer.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnSupprimer.setForeground(Color.WHITE);
	}
	
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		GradientPaint grad = new GradientPaint(100, 100, new Color(35,106,106), 500, getHeight(), Color.WHITE);
		g2.setPaint(grad);
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
}
