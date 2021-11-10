package Test;

import static org.junit.Assert.assertEquals;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Classes.Abonne;
import IHM.ConnectionWin;
import junit.framework.TestCase;


public class Test extends TestCase
{
	public static void main(String[] args) throws Exception 
	{
		assertEquals(true,Abonne.RechercheParPrenom("rayen"));
		
		UIManager.setLookAndFeel(new NimbusLookAndFeel());			
		@SuppressWarnings("unused")
		ConnectionWin connectionWin = new ConnectionWin();

	}
	
}
