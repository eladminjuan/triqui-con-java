package pkg1;

import java.util.Scanner;

public class IO {

    public static int leerEntero(String mensaje) {
        Scanner lectura = new Scanner(System.in);
        int numero = 0;
        System.out.println(mensaje);
        numero = lectura.nextInt();
        return numero;
    }

    public static double leerDecimal(String mensaje) {
        Scanner lectura = new Scanner(System.in);
        double numero = 0.0;
        System.out.println(mensaje);
        numero = lectura.nextDouble();
        return numero;
    }

    public static String leerPalabra(String mensaje) {
        Scanner lectura = new Scanner(System.in);
        String palabra = "";
        System.out.println(mensaje);
        palabra = lectura.nextLine();
        return palabra;
    }

    public static void escribir(String mensaje) {
        System.out.println(mensaje);
    }
    
    public static void escribirTablero(String mensaje) {
        System.out.print(mensaje);
    }

    @SuppressWarnings("InfiniteRecursion")
    public static int leerEntero(String mensaje, int inferior, int superior) {
        Scanner lectura = new Scanner(System.in);
        int numero = 0;
        

        try {

            System.out.println(mensaje);
            numero = lectura.nextInt();
            if (numero < inferior || numero > superior) {
                System.out.println("posición incorrecta,\nDebes igresar una posición válida entre 1 a 3");
               numero = leerEntero(mensaje, inferior, superior); 
                
            }
        } catch (Exception e) {
            System.out.println("posición incorrecta,\nNo debes ingresar letras ni caracteres especiales");
            numero = leerEntero(mensaje, inferior, superior);
        }

        return numero;
    }

}
