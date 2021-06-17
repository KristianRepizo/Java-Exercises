import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;

public class Figuras2JPanel extends JPanel
{

    public void paintComponent(Graphics g )
    {
        super.paintComponent( g );
        Random aleatorio = new Random();

        int puntosX[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
        int puntosY[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };

        Graphics2D g2d = ( Graphics2D ) g;
        GeneralPath estrella = new GeneralPath();

        estrella.moveTo( puntosX[ 0 ], puntosY[ 0  ] );


        for ( int cuenta = 1; cuenta < puntosX.length; cuenta++ )
            estrella.lineTo( puntosX[ cuenta ], puntosY[ cuenta ] );

        estrella.closePath();

        g2d.translate( 200,200);

        for ( int cuenta = 1; cuenta <= 20; cuenta++ )
        {
            g2d.rotate( Math.PI / 10.0 );

            g2d.setColor( new Color( aleatorio.nextInt(256),
                    aleatorio.nextInt(256), aleatorio.nextInt(256) ) );

            g2d.fill( estrella );
        }
    }
}
