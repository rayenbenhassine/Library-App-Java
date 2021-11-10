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

public class LeftPanel2 extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8887752082225396860L;
	private JButton btnRetour;
	private JButton btnAjouter;
	private JButton btnAfficher;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnAjouterExemplaire;
	private static AjouterLivreDialog ajouterLivreDialog;
	private static ExemplairesDialog exemplairesDialog;
	
	public LeftPanel2()
	{
		this.setLayout(null);
		this.setPreferredSize(new Dimension(200,0));
		
		btnRetour = new JButton("Retour");
		this.add(btnRetour);
		btnRetour.setBounds(25, 25, 150, 35);
		btnRetour.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnRetour.setForeground(Color.black);
		btnRetour.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				GestionnairePanel.getLivreWin().dispose();
				GestionnaireWin gestionnaireWin = new GestionnaireWin(ConnectionPanel.getGestionnaire());
			}
		});

		btnAjouterExemplaire = new JButton("Exemplaires");
		this.add(btnAjouterExemplaire);
		btnAjouterExemplaire.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (CentrePanel2.getTableLivres().getSelectedRow() != -1)
					exemplairesDialog = new ExemplairesDialog();
				else
				{
					JOptionPane.showMessageDialog(GestionnairePanel.getLivreWin(),"Veuillez selectionner un livre","Info",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnAjouterExemplaire.setBounds(25, 200, 150, 35);
		btnAjouterExemplaire.setBackground(new Color(41,125,125));
		btnAjouterExemplaire.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnAjouterExemplaire.setForeground(Color.WHITE);
		
		btnAjouter = new JButton("Ajouter");
		this.add(btnAjouter);
		btnAjouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				ajouterLivreDialog = new AjouterLivreDialog();
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
				CentrePanel2.getTableLivres().afficherTous();
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
				if (CentrePanel2.getTableLivres().getSelectedRow() != -1)
					new ModifierLivreDialog();
				else
				{
					JOptionPane.showMessageDialog(GestionnairePanel.getLivreWin(),"Veuillez selectionner un livre","Info",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnModifier.setBounds(25, 380, 150, 35);
		btnModifier.setBackground(new Color(41,125,125));
		btnModifier.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnModifier.setForeground(Color.WHITE);
		
		btnSupprimer = new JButton("Supprimer");
		this.add(btnSupprimer);
		btnSupprimer.setBounds(25, 440, 150, 35);
		btnSupprimer.setBackground(new Color(41,125,125));
		btnSupprimer.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				DefaultTableModel model = (DefaultTableModel) CentrePanel2.getTableLivres().getModel();
				int selectedRowIndex = CentrePanel2.getTableLivres().getSelectedRow();
				if (selectedRowIndex != -1)
				{
					int n = JOptionPane.showConfirmDialog(GestionnairePanel.getLivreWin(),"La suppression du livre supprimera tous les exemplaires et les emprunts correspondants","Info",JOptionPane.OK_CANCEL_OPTION);
					if(n == JOptionPane.OK_OPTION)
					{
						ConnecterBD.executeQuery("drop sequence seq_id_exemplaire_" + model.getValueAt(selectedRowIndex, 0));
						ConnecterBD.executeQuery("delete from emprunter where id_livre = " + model.getValueAt(selectedRowIndex, 0));
						ConnecterBD.executeQuery("delete from exemplaire where id_livre = " + model.getValueAt(selectedRowIndex, 0));
						ConnecterBD.executeQuery("delete from livre where id_livre = " + model.getValueAt(selectedRowIndex, 0));
						TableLivres.afficherTous();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(GestionnairePanel.getLivreWin(),"Veuillez selectionner un livre","Info",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		
	}
	
	
	public static AjouterLivreDialog getAjouterLivreDialog() 
	{
		return LeftPanel2.ajouterLivreDialog;
	}
	
	public static ExemplairesDialog getExemplairesDialog() 
	{
		return exemplairesDialog;
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		GradientPaint grad = new GradientPaint(100, 100, new Color(35,106,106), 500, getHeight(), Color.WHITE);
		g2.setPaint(grad);
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
}
