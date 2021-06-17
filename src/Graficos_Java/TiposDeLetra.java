package Graficos_Java;

import javax.swing.*;

public class TiposDeLetra
{
    public static void main ( String args[] )
    {
        JFrame marco = new JFrame( " Uso de tipos de letra" );
        marco.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

        FontJPanel fontJPanel = new FontJPanel();
        marco.add( fontJPanel );
        marco.setSize( 475, 170);
        marco.setVisible( true );
    }
}
