package ArchivosYFlujos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class DemostracionFile1 extends JFrame
{
	private JTextArea areaSalida;
	private JScrollPane panelDespl;
	
	public DemostracionFile1()
	{
		super( "Prueba de la clase File" );
		
		areaSalida = new JTextArea();
		
		panelDespl = new JScrollPane( areaSalida );
		
		add( panelDespl, BorderLayout.CENTER );
		
		setSize( 400, 400 );
		setVisible( true );
		
		analizarRuta();
	}
	
	private File obtenerArchivo()
	{
		JFileChooser selectorArchivos = new JFileChooser();
		selectorArchivos.setFileSelectionMode(
				JFileChooser.FILES_AND_DIRECTORIES );
		
		int resultado = selectorArchivos.showOpenDialog( this );
		
		if (resultado == JFileChooser.CANCEL_OPTION )
			System.exit( 1 );
		
		File nombreArchivo = selectorArchivos.getSelectedFile();
		
		if (( nombreArchivo == null ) || ( nombreArchivo.getName().equals("")))
		{
			JOptionPane.showMessageDialog( this, "Nombre de archivo invalido",
					"Nombre de archivo invalido", JOptionPane.ERROR_MESSAGE );
			System.exit( 1 );
		}
		return nombreArchivo;
	}
	
	public void analizarRuta()
	{
		File nombre = obtenerArchivo();
		
		if ( nombre.exists() )
		{
			areaSalida.setText( String.format(
					"%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
					nombre.getName(), " existe",
					( nombre.isFile() ? "es un archivo" : "no es un archivo" ),
					( nombre.isDirectory() ? "es un directorio" : "no es un directorio"),
					( nombre.isAbsolute() ? "es una ruta absoluta" : "no es una ruta absoluta"),
					"Ultima modificacion: ", nombre.lastModified(), 
					"Tama�o: ", nombre.length(), 
					"Ruta: ", nombre.getPath(), 
					"Ruta Absoluta: ", nombre.getAbsolutePath(),
			        "Padre ", nombre.getParent() ));
			        
			        if ( nombre.isDirectory() )
			        {
			        	String directorio[] = nombre.list();
			        	areaSalida.append( "\n\nContenido del directorio:\n\n" );
			        	
			        	for ( String nombreDirectorio : directorio )
			        		areaSalida.append(nombreDirectorio + "\n" );
			        	}
			        }
		else
		{
			JOptionPane.showMessageDialog( this, nombre +
					" no existe.", "ERROR", JOptionPane.ERROR_MESSAGE );
			
		}
	 }
   }