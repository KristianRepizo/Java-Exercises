package Comp_GUI;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;

public class PanelOvalo extends JPanel
{
	private int diametro = 10;
	
	public void paintcomponent ( Graphics g)
	{
		super.paintComponent( g );
		
		g.fillOval( 10, 10, diametro, diametro);
	}
	
	public void establecerDiametro( int nuevoDiametro )
	{
		diametro = ( nuevoDiametro >= 0 ? nuevoDiametro : 10 );
		repaint();
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension( 200, 200 );
	}
	
	public Dimension getMinimunSize()
	{
		return getPreferredSize();
	}
}
