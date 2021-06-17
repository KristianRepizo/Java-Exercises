package Comp_GUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.ButtonGroup;


public class MarcoContextual extends JFrame
{
	private JRadioButtonMenuItem elementos[];
	private final Color valoresColores[] =
		{ Color.BLUE, Color.YELLOW, Color.RED };
	private JPopupMenu menuContextual;
	
	public MarcoContextual()
	{
		super( "Uso de objetos JPopupMenu" );
		
		ManejadorElementos manejador = new ManejadorElementos();
		String colores[] = { "Azul", "Amarillo", "Rojo" };
		
		ButtonGroup grupoColores = new ButtonGroup();
		menuContextual = new JPopupMenu();
		elementos = new JRadioButtonMenuItem[ 3 ];
		
		for ( int cuenta = 0; cuenta < elementos.length; cuenta++ )
		{
			elementos[ cuenta ] = new JRadioButtonMenuItem( colores[ cuenta ] );
			menuContextual.add( elementos[ cuenta ] );
			grupoColores.add( elementos[ cuenta ] );
			elementos[ cuenta ].addActionListener( manejador );
		}
		
		setBackground( Color.GREEN);
		
		addMouseListener(
				new MouseAdapter()
				{
					public void MousePressed( MouseEvent evento )
					{
						checkForTriggerEvent( evento );
					}
					
					public void mouseReleased( MouseEvent evento )
					{
						checkForTriggerEvent( evento );
					}
					
					private void checkForTriggerEvent( MouseEvent evento )
					{
						if( evento.isPopupTrigger() )
							menuContextual.show(
									evento.getComponent(), evento.getX(), evento.getY() );
					}
				}
			);
	}
	
	private class ManejadorElementos implements ActionListener
	{
		public void ActionPerformed( ActionEvent evento )
		{
			for ( int i = 0; i < elementos.length; i++ )
			{
				if ( evento.getSource() == elementos[ 1 ] )
				{
					getContentPane().setBackground( valoresColores[ i ] );
					return;
				}
			}
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}
