package Comp_GUI;

import javax.swing.JFrame;

public class PruebaContextual
{
	public static void main( String args[] )
	{
		MarcoContextual marcoContextual = new MarcoContextual();
		marcoContextual.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		marcoContextual.setSize( 300, 200 );
		marcoContextual.setVisible( true );
	}
}
