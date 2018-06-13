package parcial2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Parcial2 {
    //  Declaramos objeto Razas
    private static Raza[] razas;
    // Creación de objeto Jugador
    private static Jugador[] player;
    // Creacion de objeto milicia
    private static Milicia[] milicia;
    // Creación de objeto edificación 
    private static Edificacion[] edificacion;
    // Creación de objeto Vehiculo
    private static Vehiculos[] vehiculos;
    // Llevar el control de turnos
    private boolean flag = false;
    
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       player = new Jugador[2];
       
       edificacion = new Edificacion[3];
       edificacion[0] = new Edificacion("Dakar Kindom", 10000, false, 1, 5000, 2500, 1500, 2);
       edificacion[1] = new Edificacion("Imperio Cobalt", 10000, false, 2, 5000, 2500, 1500, 1);
       edificacion[2] = new Edificacion("La taberna de bob", 10000, false, 3, 5000, 2500, 1500, 2);
       
       razas = new Raza[3];
       razas[0] = new Raza("Elfos", 0, 0);
       razas[1] = new Raza("Orcos", 4, 1);
       razas[2] = new Raza("Duendes", 5, 2);
       
       vehiculos = new Vehiculos[3];
       vehiculos[0] = new Vehiculos("Catapulta", 5000, 5000, 2500, 1500, 1500, edificacion[1], 1);
       vehiculos[1] = new Vehiculos("Tanque", 5000, 5000, 2500, 1500, 2500, edificacion[1], 2);
       vehiculos[2] = new Vehiculos("Vendetta", 5000, 5000, 2500, 1500, 1500, edificacion[1], 3);
       
       milicia = new Milicia[3];
       milicia[0] = new Milicia("Donkey", 500, 500, 500, 1000, 1);
       milicia[0] = new Milicia("Barbaros", 100, 100, 100, 500, 0);
       milicia[0] = new Milicia("Unos", 100, 100, 100, 500, 0);
       
       for (int i = 0; i < player.length; i++) {
           player[i] = new Jugador();
           System.out.print("Ingresa el nombre del jugador " + (i + 1) + ": ");
           player[i].setNombre(scanner.nextLine());
           setRaza(i);
       }
       
       int aleatorio = (int) (Math.random() * 2) + 1;
       init(aleatorio);
    }
    
    private static void verificarTiempo (int jugador) {
        
    }
    
    private static void generarRecursos (int jugador) {
        Scanner scanner = new Scanner(System.in);
        Edificacion ed = null; int opcion = 0, count = 1;
        
        HashMap<String, Object[]> edificaciones = player[jugador].getEdificaciones();
        String[] keys = new String[edificaciones.size()];
        
        
        System.out.println("***********************************");
        for (String key : edificaciones.keySet()) {
            Object[] data = edificaciones.get(key);
            System.out.println(count + ") " + key);
            keys[count - 1] =  key;
            count ++;
        }
        
        System.out.println("***********************************");
        System.out.print("Seleccione una opccion: ");
        opcion = scanner.nextInt();
        
        ed = (Edificacion) edificaciones.get(keys[opcion - 1])[1];
        ed.generarRecursos(player[jugador]);
    }
    
    private static void init (int player) {
        System.out.println("\nIniciando partida...");
        boolean turno = (player % 2 == 0); int opcion = 0, count = 0;
        boolean flag = true;
        
        while (flag) {
            if (turno) {
                System.out.println("Turno del jugador: " + Parcial2.player[player % 2].getNombre() + ".\n");
                opcion = showMenu();
            } else {
                System.out.println("Turno del Jugaddor "+ Parcial2.player[player % 2].getNombre() +".\n");
                opcion = showMenu();
            }
            
            switch (opcion) {
                case 1:
                    Parcial2.edificar(player % 2);
                    break;
                case 2: 
                    Parcial2.crearVihuculo(player % 2);
                    break;
                case 3:
                    Parcial2.player[player % 2].getCentroDeMando().mejorarEdificacion(Parcial2.player[player % 2]);
                    break;
                case 4:
                   Parcial2.generarRecursos(player % 2);
                    break;
                case 5:
                    // Explorar
                    break;
                case 6:
                    turno = !turno;
                    player ++;
                    count ++;
                    break;
            }
        }
    }
    
    private static void edificar (int jugador) {
        System.out.println("Escoge una opción: ");
        System.out.println("1) Construir Dakar Kindom.");
        System.out.println("2) Construir Imperio Cobalt");
        System.out.println("3) Construir taberna de bob");
        System.out.println("4) Terminar.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione una opcion:");
        int opcion = scanner.nextInt();

        Object[] data = new Object[2];
        
        switch (opcion) {
            case 1:
                data[0] = 1;
                data[1] = edificacion[0];
                Parcial2.player[jugador].putEdificacion(edificacion[0].getEdificacion(), data, Parcial2.player[jugador]);
                break;
            case 2:
                data[0] = 1;
                data[1] = edificacion[1];
                Parcial2.player[jugador].putEdificacion(edificacion[1].getEdificacion(), data, Parcial2.player[jugador]);
                break;
            case 3:
                data[0] = 1;
                data[1] = edificacion[2];
                Parcial2.player[jugador].putEdificacion(edificacion[2].getEdificacion(), data, Parcial2.player[jugador]);
                break;
            case 4:
                
                break;
        }
    }
    
    private static void setRaza (int jugador) {
        System.out.println("Escoge una raza: ");
        System.out.println("1) Entrenar Elfos.");
        System.out.println("2) Entrenar Orcos.");
        System.out.println("3) Entrenar Duendes.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione una opcion:");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                Parcial2.player[jugador].setRaza(razas[0]);
                System.out.println("****************************************");
                System.out.println("Nombre de raza: " + razas[0].getNombre());
                System.out.println("****************************************");
                break;
            case 2:
                Parcial2.player[jugador].setRaza(razas[1]);
                System.out.println("****************************************");
                System.out.println("Nombre de raza: " + razas[1].getNombre());
                System.out.println("****************************************");
                break;
            case 3:
                Parcial2.player[jugador].setRaza(razas[2]);
                System.out.println("****************************************");
                System.out.println("Nombre de raza: " + razas[2].getNombre());
                System.out.println("****************************************");
                break;
        }
    }
    
    private static void crearVihuculo (int jugador) {
        System.out.println("Escoge una opción: ");
        System.out.println("1) Construir Catapulta.");
        System.out.println("2) Construir Tanque.");
        System.out.println("3) Construir Vendetta.");
        System.out.println("4) Terminar.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione una opcion:");
        int opcion = scanner.nextInt();

        Object[] data = new Object[2];
        
        switch (opcion) {
            case 1:
                data[0] = 1;
                data[1] = vehiculos[0];
                Parcial2.player[jugador].putVehiculos(vehiculos[0].getNombre(), data, Parcial2.player[jugador]);
                break;
            case 2:
                data[0] = 1;
                data[1] = vehiculos[1];
                Parcial2.player[jugador].putVehiculos(vehiculos[1].getNombre(), data, Parcial2.player[jugador]);
                break;
            case 3:
                data[0] = 1;
                data[1] = vehiculos[2];
                Parcial2.player[jugador].putVehiculos(vehiculos[2].getNombre(), data, Parcial2.player[jugador]);
                break;    
            case 4:
                break;
        }
    }
    
    private static int showMenu () {
       int menu = 0;
        
       System.out.println("Seleccione una opción:");
       System.out.println("1) Crear una edificación.");
       System.out.println("2) Crear un vehiculo.");
       System.out.println("3) Mejorar nivel de centro de mando.");
       System.out.println("4) Generar recursos.");
       System.out.println("5) Explorar.");
       System.out.println("6) Salir.");
        
       Scanner scanner = new Scanner(System.in);
       System.out.print("Ingrese opcion: ");
       menu = scanner.nextInt();
       
       System.out.println("");
       return menu;
    }
}