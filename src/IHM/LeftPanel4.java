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

public class LeftPanel4 extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3197083251746788141L;
	private JButton btnRetour;
	private JButton btnHistoriqueEmprunts;
	private JButton btnEmprunter;
	private JButton btnRendre;
	private JButton btnAfficherEmprunts;
	protected RendreDialog rendreDialog;
	private static EmprunterDialog emprunterDialog;
	private static HistoriqueEmpruntsDialog historiqueEmpruntsDialog;

	

	public LeftPanel4()
	{
		this.setLayout(null);
		this.setPreferredSize(new Dimension(200,0));
		
		btnRetour = new JButton("Retour");
		this.add(btnRetour);
		btnRetour.setBounds(25, 25, 150, 35);
		btnRetour.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnRetour.setForeground(Color.black);	
		btnRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				GestionnairePanel.getEmpruntWin().dispose();
				@SuppressWarnings("unused")
				GestionnaireWin gestionnaireWin = new GestionnaireWin(ConnectionPanel.getGestionnaire());
			}
		});
		
		
		btnHistoriqueEmprunts = new JButton("Historique");
		this.add(btnHistoriqueEmprunts);
		btnHistoriqueEmprunts.setBounds(25, 220, 150, 35);
		btnHistoriqueEmprunts.setBackground(new Color(36,72,54));
		btnHistoriqueEmprunts.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnHistoriqueEmprunts.setForeground(Color.WHITE);
		btnHistoriqueEmprunts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				historiqueEmpruntsDialog = new HistoriqueEmpruntsDialog();
			}
		});
		
		btnEmprunter = new JButton("Emprunter");
		this.add(btnEmprunter);
		btnEmprunter.setBounds(25, 280, 150, 35);
		btnEmprunter.setBackground(new Color(36,72,54));
		btnEmprunter.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnEmprunter.setForeground(Color.WHITE);
		btnEmprunter.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (DisponiblesPanel.getTableDisponibles().getSelectedRow() != -1)
					emprunterDialog = new EmprunterDialog();
				else
				{
					JOptionPane.showMessageDialog(GestionnairePanel.getLivreWin(),"Veuillez selectionner un exemplaire parmis les exemplaires disponibles","Info",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});


		btnRendre = new JButton("Rendre");
		this.add(btnRendre);
		btnRendre.setBounds(25, 340, 150, 35);
		btnRendre.setBackground(new Color(36,72,54));
		btnRendre.setFont(new Font("Segoe UI",Font.BOLD,16));
		btnRendre.setForeground(Color.WHITE);
		btnRendre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (EmpruntsPanel.getTableEmpurunts().getSelectedRow() != -1)
					rendreDialog = new RendreDialog();
				else
				{
					JOptionPane.showMessageDialog(GestionnairePanel.getLivreWin(),"Veuillez selectionner un exemplaire parmis les exemplaires à rendre","Info",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnAfficherEmprunts = new JButton("Tout Afficher");
		this.add(btnAfficherEmprunts);
		btnAfficherEmprunts.setBounds(25, 400, 150, 35);
		btnAfficherEmprunts.setBackground(new Color(36,72,54));
		btnAfficherEmprunts.setFont(new Font("Segoe UI",Font.BOLD,15));
		btnAfficherEmprunts.setForeground(Color.WHITE);
		btnAfficherEmprunts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				TableEmprunts.afficherTousEmprunts();
			}
		});
		

	}
	public static HistoriqueEmpruntsDialog getHistoriqueEmpruntsDialog() {
		return historiqueEmpruntsDialog;
	}
	
	public static EmprunterDialog getEmprunterDialog() {
		return emprunterDialog;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		GradientPaint grad = new GradientPaint(100, 100, new Color(63,123,93), 500, getHeight(), Color.WHITE);
		g2.setPaint(grad);
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
}