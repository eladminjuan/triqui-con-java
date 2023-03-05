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
public class Principal {

    static final char marca_O = 'O';
    static final char marca_X = 'X';
    static final char marca_Vacio = ' ';

    public static void main(String[] args) {
        Persistencia archivo = new Persistencia("", "archie.dat");
        Partida winer = new Partida();
        Partida[] tablero, tableroNuevo, tableroBorrado;
        int opcion = 0;

        char T[][] = new char[3][3];

        boolean ganador = false;
        int jugadas = 0;
        int contador = 0;

        do {
            winer.mostrarMenu();
            opcion = IO.leerEntero("Digite su opcion  ⇨");
            if (opcion == 1) {
                if (!archivo.existe()) {
                    tableroNuevo = new Partida[1];
                    tableroNuevo[0] = new Partida();
                    tableroNuevo[0].limpiarTablero(T);
                    tableroNuevo[0].setJugador1(IO.leerPalabra("Digita el nombre del jugador 1 quien llevará la O como ficha"));
                    tableroNuevo[0].setJugador2(IO.leerPalabra("Digita el nombre del jugador 2 quien llevará la X como ficha"));
                    tableroNuevo[0].mostrarTablero(T);
                    ganador = false;
                    while (ganador == false) {

                        IO.escribir("Es el turno de " + tableroNuevo[0].getJugador1());
                        tableroNuevo[0].setFila(IO.leerEntero("Digite número de fila: ", 1, 3));
                        tableroNuevo[0].setColumna(IO.leerEntero("Digite número de columna: ", 1, 3));

                        T[tableroNuevo[0].getFila() - 1][tableroNuevo[0].getColumna() - 1] = marca_O;

                        tableroNuevo[0].setFicha(marca_O);
                        tableroNuevo[0].mostrarTablero(T);
                        if (tableroNuevo[0].esGanador(T, marca_O)) {
                            IO.escribir("Felicidades " + tableroNuevo[0].getJugador1() + " has ganado esta ronda\nFicha: O");
                            tableroNuevo[0].setJugadorGanador(tableroNuevo[0].getJugador1());
                            tableroNuevo[0].setFichaGanador(marca_O);

                            ganador = true;
                            break;
                        }
                        jugadas++;
                        if (jugadas == 9) {
                            break;
                        } else if (T[tableroNuevo[0].getFila() - 1][tableroNuevo[0].getColumna() - 1] == 0) {
                            jugadas = jugadas - 1;
                        }

                        IO.escribir("Es el turno de " + tableroNuevo[0].getJugador2());
                        tableroNuevo[0].setFila(IO.leerEntero("Digite número de fila: ", 1, 3));
                        tableroNuevo[0].setColumna(IO.leerEntero("Digite número de columna: ", 1, 3));

                        T[tableroNuevo[0].getFila() - 1][tableroNuevo[0].getColumna() - 1] = marca_X;
                        tableroNuevo[0].setFicha(marca_X);
                        tableroNuevo[0].mostrarTablero(T);
                        if (tableroNuevo[0].esGanador(T, marca_X)) {
                            IO.escribir("Felicidades " + tableroNuevo[0].getJugador2() + " has ganado esta ronda\nFicha: X");
                            tableroNuevo[0].setJugadorGanador(tableroNuevo[0].getJugador2());
                            tableroNuevo[0].setFichaGanador(marca_X);
                            ganador = true;
                            break;
                        }
                        jugadas++;
                    }
                    if (ganador == false) {

                        IO.escribir("¡Esta ronda quedó empatada!");
                    }

                } else {
                    archivo.abrirLectura();
                    tablero = (Partida[]) archivo.cargar();
                    archivo.cerrarLectura();

                    tableroNuevo = new Partida[tablero.length + 1];

                    for (int i = 0; i < tablero.length; i = i + 1) {
                        tableroNuevo[i] = new Partida();
                        tableroNuevo[i] = tablero[i];
                    }

                    tableroNuevo[tablero.length] = new Partida();
                    tableroNuevo[tablero.length].limpiarTablero(T);
                    tableroNuevo[tablero.length].setJugador1(IO.leerPalabra("Digita el nombre del jugador 1 quien llevará la O como ficha"));
                    tableroNuevo[tablero.length].setJugador2(IO.leerPalabra("Digita el nombre del jugador 2 quien llevará la X como ficha"));
                    tableroNuevo[tablero.length].mostrarTablero(T);
                    ganador = false;
                    while (ganador == false) {

                        IO.escribir("Es el turno de " + tableroNuevo[tablero.length].getJugador1());
                        tableroNuevo[tablero.length].setFila(IO.leerEntero("Digite número de fila: ", 1, 3));
                        tableroNuevo[tablero.length].setColumna(IO.leerEntero("Digite número de columna: ", 1, 3));

                        T[tableroNuevo[tablero.length].getFila() - 1][tableroNuevo[tablero.length].getColumna() - 1] = marca_O;
                        tableroNuevo[tablero.length].setFicha(marca_O);
                        tableroNuevo[tablero.length].mostrarTablero(T);
                        if (tableroNuevo[tablero.length].esGanador(T, marca_O)) {
                            IO.escribir("Felicidades " + tableroNuevo[tablero.length].getJugador1() + " has ganado esta ronda\nFicha: O");
                            tableroNuevo[tablero.length].setJugadorGanador(tableroNuevo[tablero.length].getJugador1());
                            tableroNuevo[tablero.length].setFichaGanador(marca_O);
                            ganador = true;
                            break;
                        }
                        jugadas++;
                        if (jugadas == 9) {
                            break;
                        } else if (T[tableroNuevo[tablero.length].getFila() - 1][tableroNuevo[tablero.length].getColumna() - 1] == 0) {
                            jugadas = jugadas - 1;
                        }

                        IO.escribir("Es el turno de " + tableroNuevo[tablero.length].getJugador2());
                        tableroNuevo[tablero.length].setFila(IO.leerEntero("Digite número de fila: ", 1, 3));
                        tableroNuevo[tablero.length].setColumna(IO.leerEntero("Digite número de columna: ", 1, 3));

                        T[tableroNuevo[tablero.length].getFila() - 1][tableroNuevo[tablero.length].getColumna() - 1] = marca_X;
                        tableroNuevo[tablero.length].setFicha(marca_X);
                        tableroNuevo[tablero.length].mostrarTablero(T);
                        if (tableroNuevo[tablero.length].esGanador(T, marca_X)) {
                            IO.escribir("Felicidades " + tableroNuevo[tablero.length].getJugador2() + " has ganado esta ronda\nFicha: X");
                            tableroNuevo[tablero.length].setJugadorGanador(tableroNuevo[tablero.length].getJugador2());
                            tableroNuevo[tablero.length].setFichaGanador(marca_X);
                            ganador = true;
                            break;
                            
                        }
                        jugadas++;
                    }
                    if (ganador == false) {

                        IO.escribir("¡Esta ronda quedó empatada!");
                    }
                }
                archivo.abrirEscritura();
                archivo.guardar(tableroNuevo);
                archivo.cerrarEscritura();
            }
            if (opcion == 2) {
                if (archivo.existe()) {
                    archivo.abrirLectura();
                    tablero = (Partida[]) archivo.cargar();
                    IO.escribir("\n\nPARTIDAS DE JUGADAS");
                    for (int i = 0; i < tablero.length; i = i + 1) {
                        IO.escribir("GANADOR(A)\n"
                                +i+ "‖  Nombre  ‖  " + tablero[i].getJugadorGanador() + " \n"
                                + "  ‖   Ficha  ‖ " + tablero[i].getFichaGanador());
                        //tablero[i].mostrarTablero(T);
                        
                                        

                    }
                    archivo.cerrarLectura();
                }

            }
            
            if(opcion == 3){
               if (archivo.existe()){
                   archivo.abrirLectura();
                   tableroBorrado=(Partida[]) archivo.cargar();
                   IO.escribir("\n\nPARTIDAS A BORRAR");
                   for (int i = 0; i < tableroBorrado.length-1; i = i + 1){
                      contador++;
                      IO.escribir("GANADOR(A)\n"
                                +i+ "‖  Nombre  ‖  " + tableroBorrado[i].getJugadorGanador() + " \n"
                                + "  ‖   Ficha  ‖ " + tableroBorrado[i].getFichaGanador());
                   }
                    archivo.cerrarLectura();
               } 
            }

        } while (opcion != 4);
    }

}
