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

public class LeftPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5843865698671133787L;
	private JButton btnRetour;
	private JButton btnAjouter;
	private JButton btnAfficher;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private static AjouterAbonneDialog ajouterAbonneDialog;
	
	public LeftPanel()
	{		
		this.setLayout(null);
		this.setPreferredSize(new Dimension(200,0));
		
		btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Segoe UI",Font.BOLD,14));
		this.add(btnRetour);
		btnRetour.setBounds(25, 25, 150, 35);
		btnRetour.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnRetour.setForeground(Color.black);
		btnRetour.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				GestionnairePanel.getAbonneWin().dispose();
				GestionnaireWin gestionnaireWin = new GestionnaireWin(ConnectionPanel.getGestionnaire());
			}
		});

		btnAjouter = new JButton("Ajouter");
		this.add(btnAjouter);
		btnAjouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				ajouterAbonneDialog = new AjouterAbonneDialog();
			}
		});
		btnAjouter.setBounds(25, 200, 150, 35);
		btnAjouter.setBackground(new Color(159,9,29));
		btnAjouter.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnAjouter.setForeground(Color.WHITE);

		btnAfficher = new JButton("Afficher");
		this.add(btnAfficher);
		btnAfficher.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				CentrePanel.getTableAbonnes().afficherTous();
			}
		});
		btnAfficher.setBounds(25, 260, 150, 35);
		btnAfficher.setBackground(new Color(159,9,29));
		btnAfficher.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnAfficher.setForeground(Color.WHITE);

		btnModifier = new JButton("Modifier");
		this.add(btnModifier);
		btnModifier.setBounds(25, 320, 150, 35);
		btnModifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (CentrePanel.getTableAbonnes().getSelectedRow() != -1)
					new ModifierAbonneDialog();
				else
				{
					JOptionPane.showMessageDialog(GestionnairePanel.getAbonneWin(),"Veuillez selectionner un abonne","Info",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnModifier.setBackground(new Color(159,9,29));
		btnModifier.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnModifier.setForeground(Color.WHITE);
		
		btnSupprimer = new JButton("Supprimer");
		this.add(btnSupprimer);
		btnSupprimer.setBounds(25, 380, 150, 35);
		btnSupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				DefaultTableModel model = (DefaultTableModel) CentrePanel.getTableAbonnes().getModel();
				int selectedRowIndex = CentrePanel.getTableAbonnes().getSelectedRow();
				if(selectedRowIndex != -1)
				{	
					int n = JOptionPane.showConfirmDialog(GestionnairePanel.getLivreWin(),"La suppression de l'abonnée supprimera tous les emprunts correspondants","Info",JOptionPane.OK_CANCEL_OPTION);
					if (n == JOptionPane.OK_OPTION)
					{
						ConnecterBD.executeQuery("delete from abonne where id_abonne = " + model.getValueAt(selectedRowIndex, 0));
						ConnecterBD.executeQuery("delete from emprunter where id_abonne = " + model.getValueAt(selectedRowIndex, 0));
						TableAbonnes.afficherTous();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(GestionnairePanel.getAbonneWin(),"Veuillez selectionner un abonne","Info",JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		btnSupprimer.setBackground(new Color(159,9,29));
		btnSupprimer.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnSupprimer.setForeground(Color.WHITE);
	}
	

	public static AjouterAbonneDialog getAjouterAbonneDialog() 
	{
		return LeftPanel.ajouterAbonneDialog;
	}
	

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		GradientPaint grad = new GradientPaint(100, 100, new Color(152,14,33), 500, getHeight(), Color.WHITE);
		g2.setPaint(grad);
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
}
	 
