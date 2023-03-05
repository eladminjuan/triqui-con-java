package pkg1;

import java.io.*;

public class Persistencia {

    private String carpeta;
    private String nombreArchivo;
    private FileOutputStream baseSalida;
    private ObjectOutputStream salida;
    private FileInputStream baseEntrada;
    private ObjectInputStream entrada;

    public Persistencia(String carpeta, String nombreArchivo) {
        this.carpeta = carpeta;
        this.nombreArchivo = nombreArchivo;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void abrirEscritura() {
        try {
            baseSalida = new FileOutputStream(carpeta + nombreArchivo);
            salida = new ObjectOutputStream(baseSalida);
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e);
        }
    }

    public void cerrarEscritura() {
        try {
            salida.close();
            baseSalida.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void abrirLectura() {
        try {
            baseEntrada = new FileInputStream(carpeta + nombreArchivo);
            entrada = new ObjectInputStream(baseEntrada);
        } catch (IOException e) {
            System.out.println("Error al abrir archivo: " + e);
        }
    }

    public void cerrarLectura() {
        try {
            entrada.close();
            baseEntrada.close();
        } catch (IOException | NullPointerException e) {
            System.out.println("");
        }
    }

    public void guardar(Object x) {
        try {
            salida.writeObject(x);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e);
        }
    }

    public Object cargar() {
        Object resultado = null;
        try {
            resultado = entrada.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar: " + e);
        }
        return resultado;
    }

    public boolean existe() {
        try {
            baseEntrada = new FileInputStream(carpeta + nombreArchivo);
            baseEntrada.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe: " + e);
        } catch (IOException e) {
            System.out.println("El archivo cierre de archivo: " + e);
        }
        return false;
    }
}
