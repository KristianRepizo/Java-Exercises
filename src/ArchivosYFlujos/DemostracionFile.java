package ArchivosYFlujos;
import java.io.File;

public class DemostracionFile {

	public void analizarRuta(String ruta)
	{
		File nombre = new File(ruta);
		
		if ( nombre.exists() )
		{
			System.out.printf(
				"%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
				nombre.getName(), " existe",
				( nombre.isFile() ? "es un archivo" : "no es un archivo"),
				( nombre.isDirectory() ? "es un directorio" : "no es un directorio"),
				( nombre.isAbsolute() ? "es ruta absoluta" : "no es ruta absoluta"),
				"ultima modificacion: ", nombre.lastModified(), "tama�o: ", nombre.length(),
				"ruta: ", nombre.getPath(), "ruta absoluta: ", 
				nombre.getAbsolutePath(), "padre: ", nombre.getParent());
			
			if ( nombre.isDirectory())
			{
				String directorio[] = nombre.list();
				System.out.println("\n\nContenido del directorio:\n");
				
				for (String nombreDirectorio : directorio)
					System.out.printf("%s\n", nombreDirectorio);
			}
				
		}
	}
}
