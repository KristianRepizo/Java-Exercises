package Graficos_Java;

import javax.swing.*;

public class Figurass
{
    public static void main ( String args[] )
    {

        JFrame marco = new JFrame( " Dibujo de figura en 2D" );
        marco.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        FigurasJPanel figurasJPanel = new FigurasJPanel();
        marco.add( figurasJPanel );
        marco.setSize(425,200);
        marco.setVisible( true );
    }
}