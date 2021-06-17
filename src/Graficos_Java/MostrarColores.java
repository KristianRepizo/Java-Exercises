package Graficos_Java;

import javax.swing.*;

public class MostrarColores
{
    public static void main ( String args[] )
    {

        JFrame frame = new JFrame( "Uso de Colores ");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        JPanelColor jPanelColor = new JPanelColor();
        frame.add( jPanelColor );
        frame.setSize(400,180);
        frame.setVisible( true );
    }
}
