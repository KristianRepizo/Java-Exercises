package Comp_GUI;

import javax.swing.JFrame;

public class PruebaMenu
{
	public static void main( String args[])
	{
		MarcoMenu marcoMenu = new MarcoMenu();
		marcoMenu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		marcoMenu.setSize( 600, 200 );
		marcoMenu.setVisible( true );
	}
}
