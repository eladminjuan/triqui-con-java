/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *
 * @author jdgom
 */
import java.io.Serializable;


public class Partida implements Serializable {

    public String jugador1, jugador2, jugadorGanador;
    public int partida, opcion, fila, columna;
    static final char marca_Vacio = ' ';
    char ficha, fichaGanador;
    int g[][];
   
    public Partida() {
        jugador1 = "";
        jugador2 = "";
        jugadorGanador="";
        partida = 0;
        opcion = 0;
        fila = 0;
        columna = 0;
        ficha = 0;
        fichaGanador=0;
        
    }

   
   public int[][] getG() {
        return g;
    }

    public void setG(int[][] g) {
        this.g = g;
    }

    public char getFichaGanador() {
        return fichaGanador;
    }

    public void setFichaGanador(char fichaGanador) {
        this.fichaGanador = fichaGanador;
    }

    public String getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(String jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }
    public char getFicha() {
        return ficha;
    }

    public void setFicha(char ficha) {
        this.ficha = ficha;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public int getPartida() {
        return partida;
    }

    public void setPartida(int partida) {
        this.partida = partida;
    }

    

    public void mostrarMenu() {
        IO.escribir("_________________________\n"
                + "‖          MENÚ         ‖\n"
                + "‖_______________________‖\n"
                + "‖ Opción ‖ Información  ‖\n"
                + "‖________‖______________‖\n"
                + "‖    1   ‖ Jugar Triqui ‖\n"
                + "‖________‖______________‖\n"
                + "‖    2   ‖ Ver Partidas ‖\n"
                + "‖________‖______________‖\n"
                + "‖    3   ‖Borrar Partida‖\n"
                + "‖________‖______________‖\n"
                + "‖    4   ‖     Salir    ‖\n"
                + "‖________‖______________‖\n");

    }

    void limpiarTablero(char[][] T) {
        int f, c;
        for (f = 0; f < 3; f++) {
            for (c = 0; c < 3; c++) {
                T[f][c] = marca_Vacio;
            }
        }
    }

    public static void mostrarTablero(char t[][]) {
        int f, c;
        for (f = 0; f < 3; f++) {
            for (c = 0; c < 3; c++) {
                IO.escribirTablero("_|_" + t[f][c]);
            }
            IO.escribir("_|_");
        }

    }
     
   
    public static boolean esGanador(char[][] t, char mj) {
        boolean sw = false;
        //las 3 filas
        if (t[0][0] == mj && t[0][1] == mj && t[0][2] == mj) {
            sw = true;
        } else if (t[1][0] == mj && t[1][1] == mj && t[1][2] == mj) {
            sw = true;
        } else if (t[2][0] == mj && t[2][1] == mj && t[2][2] == mj) {
            sw = true;
            //las 3 columnas
        } else if (t[0][0] == mj && t[1][0] == mj && t[2][0] == mj) {
            sw = true;
        } else if (t[0][1] == mj && t[1][1] == mj && t[2][1] == mj) {
            sw = true;
        } else if (t[0][2] == mj && t[1][2] == mj && t[2][2] == mj) {
            sw = true;
            //diagonales
        } else if (t[0][0] == mj && t[1][1] == mj && t[2][2] == mj) {
            sw = true;
        } else if (t[2][0] == mj && t[1][1] == mj && t[0][2] == mj) {
            sw = true;
        }
        return sw;
    }

}
