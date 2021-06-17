package Comp_GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class MarcoMenu extends JFrame
{
	private final Color valoresColores[] =
		{ Color.BLACK, Color.BLUE, Color.RED, Color.GREEN };
	private JRadioButtonMenuItem elementosColores[];
	private JRadioButtonMenuItem fuentes[];
	private JCheckBoxMenuItem elementosEstilos[];
	private JLabel mostrarJLabel;
	private ButtonGroup fuentesButtonGroup;
	private ButtonGroup coloresButtonGroup;
	private int estilo;
	
	public MarcoMenu()
	{
		super( "Uso de los objetos JMenu" );
		
		JMenu menuArchivo = new JMenu( "Archivo" );
		menuArchivo.setMnemonic( 'A' );
		
		JMenuItem elementoAcercaDe = new JMenuItem( "Acerca de..." );
		elementoAcercaDe.setMnemonic( 'C' );
		menuArchivo.add( elementoAcercaDe );
		elementoAcercaDe.addActionListener(
				new ActionListener()
				{
					public void actionPerformed( ActionEvent evento )
					{
						JOptionPane.showMessageDialog( MarcoMenu.this,
								"Este es un ejemplo\ndel uso de menus",
								"Acerca de", JOptionPane.PLAIN_MESSAGE );
					}
				}
			);
		
		JMenuItem elementoSalir = new JMenuItem( "Salir" );
		elementoSalir.setMnemonic( 'S' );
		menuArchivo.add( elementoSalir );
		elementoSalir.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed( ActionEvent evento )
					{
					System.exit( 0 );
					}
				}
			);
		
		JMenuBar barra = new JMenuBar();
		setJMenuBar( barra );
		barra.add( menuArchivo );
		
		JMenu menuFormato = new JMenu( "Formato" );
		menuFormato.setMnemonic( 'F' );
		
		String colores[] = { "Negro", "Azul", "Rojo", "Verde" };
		
		JMenu menuColor = new JMenu( "Color" );
		menuColor.setMnemonic( 'C' );
		
		elementosColores = new JRadioButtonMenuItem[ colores.length ];
		coloresButtonGroup = new ButtonGroup();
		ManejadorElementos manejadorElementos = new ManejadorElementos();
		
		for ( int cuenta = 0; cuenta < colores.length; cuenta++ )
		{
			elementosColores[ cuenta ] = new JRadioButtonMenuItem( colores[ cuenta ] );
			menuColor.add( elementosColores[ cuenta ] );
			coloresButtonGroup.add( elementosColores[ cuenta ] );
			elementosColores[ cuenta ].addActionListener( manejadorElementos );
		}
		
		elementosColores[ 0 ].setSelected( true );
		
		menuFormato.add( menuColor );
		menuFormato.addSeparator();
		
		String nombresFuentes[] = { "Serif", "Monospaced", "SansSerif" };
		JMenu menuFuente = new JMenu( "Fuente" );
		menuFuente.setMnemonic( 'U' );
		
		fuentes = new JRadioButtonMenuItem[ nombresFuentes.length ];
		fuentesButtonGroup = new ButtonGroup();
		
		for ( int cuenta = 0; cuenta < fuentes.length; cuenta++ )
		{
			fuentes[ cuenta ] = new JRadioButtonMenuItem( nombresFuentes[ cuenta ] );
			menuFuente.add( fuentes[ cuenta ] );
			fuentesButtonGroup.add(fuentes[ cuenta ] );
			fuentes[ cuenta ].addActionListener( manejadorElementos );
		}
		
		fuentes[ 0 ].setSelected( true );
		menuFuente.addSeparator();
		
		String nombresEstilos[] = { "Negrita", "Cursiva" };
		elementosEstilos = new JCheckBoxMenuItem[ nombresEstilos.length];
		ManejadorEstilos manejadorEstilos = new ManejadorEstilos();
		
		for ( int cuenta = 0; cuenta < nombresEstilos.length; cuenta++ )
		{
			elementosEstilos[ cuenta ] = new JCheckBoxMenuItem( nombresEstilos[ cuenta ] );
			menuFuente.add( elementosEstilos[ cuenta ] );
			elementosEstilos[ cuenta ].addItemListener( manejadorEstilos );
		}
		
		menuFormato.add( menuFuente );
		barra.add( menuFormato );
		
		mostrarJLabel = new JLabel( "Texto de ejemplo", SwingConstants.CENTER );
		mostrarJLabel.setForeground( valoresColores[ 0 ] );
		mostrarJLabel.setFont( new Font( "Serif", Font.PLAIN, 72 ) );
		
		getContentPane().setBackground( Color.CYAN );
		add( mostrarJLabel, BorderLayout.CENTER );
	}
	
	private class ManejadorElementos implements ActionListener
	{
		public void actionPerformed( ActionEvent evento )
		{
			for ( int cuenta = 0; cuenta < elementosColores.length; cuenta++ )
			{
				if ( elementosColores[ cuenta ].isSelected() )
				{
					mostrarJLabel.setForeground( valoresColores[ cuenta ] );
					break;
				}
			}
			
			for ( int cuenta = 0; cuenta < fuentes.length; cuenta++ )
			{
				if ( evento.getSource() == fuentes[ cuenta ] )
				{
					mostrarJLabel.setFont(
							new Font( fuentes[ cuenta ].getText(), estilo, 72) );
				}
			}
			
			repaint();
		}
	}
	
	private class ManejadorEstilos implements ItemListener
	{
		public void itemStateChanged( ItemEvent e )
		{
			estilo = 0;
			
			if ( elementosEstilos[ 0 ].isSelected() )
				estilo += Font.BOLD;
			
			if ( elementosEstilos[ 1 ].isSelected() )
				estilo += Font.ITALIC;
			
			mostrarJLabel.setFont(
					new Font( mostrarJLabel.getFont().getName(), estilo, 72 ) );
			repaint();
		}
	}
	
}
