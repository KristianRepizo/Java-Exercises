package Graficos_Java;

import javax.swing.*;
import java.awt.*;

public class LineasRectsOvalos
{
    public static void main ( String args[] )
    {

        JFrame marco =
                new JFrame( " Dibujo en lineas, rectangulo y ovalos ");
        marco.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

        LineasRectsOvalosJPanel lineasRectsOvalosJPanel =
                new LineasRectsOvalosJPanel();
        lineasRectsOvalosJPanel.setBackground(Color.WHITE);
        marco.add( lineasRectsOvalosJPanel );
        marco.setSize(400,210);
        marco.setVisible( true );
    }
}
