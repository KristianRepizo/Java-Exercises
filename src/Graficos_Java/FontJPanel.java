import javax.swing.*;
import java.awt.*;

public class FontJPanel extends JPanel
{
    public void paintComponent ( Graphics g )
    {
        super.paintComponent( g );


        g.setFont( new Font("Serif", Font.BOLD, 12) );
        g.drawString( "Serif 12 puntos, negrita.", 20,50);

        g.setFont( new Font(" Monospaced", Font.ITALIC, 24) );
        g.drawString(" Monospaced 24 puntos, cursiva.", 20,70);

        g.setFont( new Font( " SensSerif", Font.PLAIN, 14) );
        g.drawString( " SensSerif 14 puntos, simple.", 20,90);

        g.setColor( Color.RED );
        g.setFont( new Font( " Serif", Font.BOLD + Font.ITALIC ,18) );
        g.drawString( g.getFont().getName()+ " "+ g.getFont().getSize()+
                "puntos, negrita, cursiva. ",20,110);

    }
}
