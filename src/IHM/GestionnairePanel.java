package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Classes.Gestionnaire;


public class GestionnairePanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1350053701309737162L;
	private JLabel lblWelcome;
	private JButton btnAbonne;
	private JButton btnLivre;
	private JButton btnEmprunt;
	private JButton deconnexion;
	private JLabel lblnom;
	private static LivreWin LivreWin;
	private static AbonneWin abonneWin;
	private static EmpruntWin empruntWin;
	
	public GestionnairePanel(GestionnaireWin gestionnaireWin, Gestionnaire gestionnaire)
	{
		super();
		this.setLayout(null);
		this.setBackground(new Color(110,0,15));
		
		lblWelcome = new JLabel("BIENVENUE");
		this.add(lblWelcome);
		lblWelcome.setFont(new Font("Segoe UI",Font.BOLD,23));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(145, 20, 450, 30);
	
		
		
		lblnom = new JLabel("Gestionnaire : " + gestionnaire.getNom_gestionnaire() + " " + gestionnaire.getPrenom_gestionnaire());
		this.add(lblnom);
		lblnom.setFont(new Font("Segoe UI",Font.BOLD,18));
		lblnom.setForeground(Color.WHITE);
		lblnom.setBounds(50, 100, 450, 30);
	
		
		
		btnAbonne = new JButton("Gestion des abonnés");
		this.add(btnAbonne);
		btnAbonne.setBounds(100, 170, 225, 60);
		btnAbonne.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnAbonne.setBackground(new Color(159,9,29));
		btnAbonne.setForeground(Color.WHITE);
		btnAbonne.addActionListener(new ActionListener()
		{			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				gestionnaireWin.dispose();
				abonneWin = new AbonneWin();
			}
		});
		
		
		btnLivre = new JButton("Gestion des livres et exemplaires");
		this.add(btnLivre);
		btnLivre.setBounds(100, 245, 225, 60);
		btnLivre.setFont(new Font("Segoe UI",Font.BOLD,12));
		btnLivre.setBackground(new Color(159,9,29));
		btnLivre.setForeground(Color.WHITE);
		btnLivre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				gestionnaireWin.dispose();
				LivreWin = new LivreWin();
			}
		});
		
		
		btnEmprunt = new JButton("Gestion des emprunts");
		this.add(btnEmprunt);
		btnEmprunt.setFont(new Font("Segoe UI",Font.BOLD,14));
		btnEmprunt.setBackground(new Color(159,9,29));
		btnEmprunt.setForeground(Color.WHITE);
		btnEmprunt.setBounds(100, 320, 225, 60);
		btnEmprunt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				gestionnaireWin.dispose();
				empruntWin = new EmpruntWin();
			}
		});
		
		
		deconnexion = new JButton("Déconnexion");
		this.add(deconnexion);
		deconnexion.setFont(new Font("Segoe UI",Font.BOLD,14));
		deconnexion.setBackground(new Color(159,9,29));
		deconnexion.setForeground(Color.WHITE);
		deconnexion.setBounds(100, 395 , 225, 60);
		deconnexion.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				gestionnaireWin.dispose();
				ConnectionWin connectionWin = new ConnectionWin();
				
			}
		});
	}
	
	public static AbonneWin getAbonneWin()
	{
		return abonneWin;
	}
	
	public static LivreWin getLivreWin() {
		return LivreWin;
	}
	
	public static EmpruntWin getEmpruntWin() {
		return empruntWin;
	}




}
