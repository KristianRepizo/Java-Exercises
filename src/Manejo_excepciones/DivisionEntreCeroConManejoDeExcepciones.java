package Manejo_excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionEntreCeroConManejoDeExcepciones
{

    public static int cociente( int numerador, int denominador )
        throws ArithmeticException
    {
        return numerador / denominador;
    }

    public static void main ( String args[] )
    {
        Scanner explorador = new Scanner( System.in );
        boolean continuarCiclo = true;

        do
        {
            try
            {
                System.out.print( " Introduzca un numerador entero: ");
                int numerador = explorador.nextInt();
                System.out.print( " Introduzca un denominador entero: ");
                int denominador = explorador.nextInt();

                int resultados = cociente( numerador, denominador );
                System.out.printf( "/nResultados: %d/%d = %d/n", numerador,
                        denominador, resultados );
                continuarCiclo = false;
            }
            catch ( InputMismatchException inputMismatchException )
            {

                System.err.printf( "/nExcepcion: %s/n",
                        inputMismatchException );
                explorador.nextLine();
                System.out.println(
                        "Debe introducir enteros. Intente de nuevo./n");
            }
            catch ( ArithmeticException arithmeticException )
            {
                System.err.printf( "/nExecpcion: %s/n", arithmeticException );
                System.out.println(
                        "Cero es un denominador invalido. Intente de nuevo./n" );
            }
        } while ( continuarCiclo );
    }
}
