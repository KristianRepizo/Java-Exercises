import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarColoresJFrame extends JFrame
{
    private JButton cambiarColorButton;
    private Color color = Color.LIGHT_GRAY;
    private JPanel coloresJPanel;

    public MostrarColoresJFrame()
    {
        super( "Uso de JColorChooser ");


        coloresJPanel = new JPanel();
        coloresJPanel.setBackground( color );


        cambiarColorButton = new JButton( " Cambiar color ");
        cambiarColorButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                     color = JColorChooser.showDialog(
                             MostrarColoresJFrame.this, "Seleccionar un color", color);


                     if ( color== null )
                         color = Color.LIGHT_GRAY;


                     coloresJPanel.setBackground( color );
                    }
                }
        );

        add( coloresJPanel, BorderLayout.CENTER );
        add( cambiarColorButton, BorderLayout.SOUTH );

        setSize(400,130);
        setVisible( true );
    }
}
