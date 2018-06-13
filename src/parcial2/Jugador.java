package parcial2;

import java.util.HashMap;
import java.util.Iterator;

public class Jugador {
   
    private String nombre;
    private int recurso_1;
    private int recurso_2;
    private int recurso_3;
    
    private Edificacion centroDeMando;
    
    private Raza raza;
    private HashMap<String, Object[]> edificaciones = new HashMap<>();
    private HashMap<String, Object[]> vehiculos = new HashMap<>();
    private HashMap<String, Object[]> milicia = new HashMap<>();
    
    public Jugador () {
        this.centroDeMando = new Edificacion("Centro de mando", 20000, true, 0, 10000, 5000, 3000, 0); 
    }
    
    public Jugador (String nombre) {
        this.nombre = nombre;
    }
    
    public void setRaza (Raza raza) {
        this.raza = raza;
    }
    
    public Raza getRaza () {
        return this.raza;
    }
    
    public void putVehiculos (String key, Object[] data, Jugador jugador) {
        Iterator iterador = this.vehiculos.keySet().iterator();
        String llaveActual = null;
        
        this.centroDeMando = jugador.getCentroDeMando();
        Vehiculos auxiliar = (Vehiculos) data[1]; 
        
        int costo1 = auxiliar.getCosto1();
        int costo2 = auxiliar.getCosto2();
        int costo3 = auxiliar.getCosto3();
        
        if ((this.centroDeMando.getRecurso_tipo_1() - costo1) >= 0 && (this.centroDeMando.getRecurso_tipo_1() - costo2) >= 0 && (this.centroDeMando.getRecurso_tipo_3()- costo3) >= 0) {
            boolean bandera = false;
            
            while (iterador.hasNext()) {
                key = (String) iterador.next();
                if (auxiliar.getNombre().equals(key)) {
                    bandera = true;
                    break;
                }
            }

            String llave = auxiliar.getNombre();

            if (!bandera) {
                this.vehiculos.put(llave, data);
            } else {
                Object[] aux = this.vehiculos.get(llave);
                aux[0] = (int) aux[0] + 1;
                this.vehiculos.put(llave, aux);
            }

            this.centroDeMando.setRecurso_tipo_1(this.centroDeMando.getRecurso_tipo_1() - costo1);
            this.centroDeMando.setRecurso_tipo_2(this.centroDeMando.getRecurso_tipo_2() - costo2);
            this.centroDeMando.setRecurso_tipo_3(this.centroDeMando.getRecurso_tipo_3() - costo3);
            
            this.listarVehiculos(jugador);
        } else {
            System.out.println("***********************************************");
            System.out.println("Has agotado todos tus recursos.");
            System.out.println("***********************************************");
        } 
    }
    
    private void listarVehiculos (Jugador jugador) {
        Vehiculos vehiculos = null;
        String key = null;
         
        Iterator iterador = this.vehiculos.keySet().iterator();
        System.out.println("********************* Detalle ****************************");  
        while (iterador.hasNext()) {
           key = (String) iterador.next();   
           Object[] data = this.vehiculos.get(key); // [ Objecto edificacion, cantidad de edificaciones ]
           
           vehiculos = (Vehiculos) data[1];         
           System.out.println("Nombre de edificación: " + vehiculos.getNombre());
           System.out.println("Número de construcciones: " + (int) data[0]);
           System.out.println("");
           
        }
        
        System.out.println("Recursos disponibles (Jugador: " + jugador.getNombre() + "):");
        System.out.println("Recurso 1: " + this.centroDeMando.getRecurso_tipo_1());
        System.out.println("Recurso 2: " + this.centroDeMando.getRecurso_tipo_2());
        System.out.println("Recurso 3: " + this.centroDeMando.getRecurso_tipo_3());
        System.out.println("**********************************************************");
    }
    

    public void putEdificacion (String key, Object[] data, Jugador jugador) {
        Iterator iterador = this.edificaciones.keySet().iterator();
        String llaveActual = null;
        
        this.centroDeMando = jugador.getCentroDeMando();
        Edificacion auxiliar = (Edificacion) data[1]; 
        int costo1 = auxiliar.getCosto1();
        int costo2 = auxiliar.getCosto2();
        int costo3 = auxiliar.getCosto3();
        
        if ((this.centroDeMando.getRecurso_tipo_1() - costo1) >= 0 && (this.centroDeMando.getRecurso_tipo_1() - costo2) >= 0 && (this.centroDeMando.getRecurso_tipo_3()- costo3) >= 0) {
            boolean bandera = false;
            while (iterador.hasNext()) {
                key = (String) iterador.next();
                if (auxiliar.getEdificacion().equals(key)) {
                    bandera = true;
                    break;
                }
            }

            String llave = auxiliar.getEdificacion();

            if (!bandera) {
                this.edificaciones.put(llave, data);
            } else {
                Object[] aux = this.edificaciones.get(llave);
                aux[0] = (int) aux[0] + 1;
                this.edificaciones.put(llave, aux);
            }

            this.centroDeMando.setRecurso_tipo_1(this.centroDeMando.getRecurso_tipo_1() - costo1);
            this.centroDeMando.setRecurso_tipo_2(this.centroDeMando.getRecurso_tipo_2() - costo2);
            this.centroDeMando.setRecurso_tipo_3(this.centroDeMando.getRecurso_tipo_3() - costo3);
            
            this.listarEdificaciones();
        } else {
            System.out.println("***********************************************");
            System.out.println("Has agotado todos tus recursos.");
            System.out.println("***********************************************");
        }
       
    }

    public HashMap<String, Object[]> getEdificaciones() {
        return edificaciones;
    }

    public void setEdificaciones(HashMap<String, Object[]> edificaciones) {
        this.edificaciones = edificaciones;
    }
    
    
    
    public void listarEdificaciones () {
        Edificacion edificacion = null;
        String key = null;
         
        Iterator iterador = this.edificaciones.keySet().iterator();
        System.out.println("********************* Detalle ****************************");  
        while (iterador.hasNext()) {
           key = (String) iterador.next();   
           Object[] data = this.edificaciones.get(key); // [ Objecto edificacion, cantidad de edificaciones ]
           
           edificacion = (Edificacion) data[1];         
           System.out.println("Nombre de edificación: " + edificacion.getEdificacion());
           System.out.println("Número de construcciones: " + (int) data[0]);
           System.out.println("");
        }
        
        System.out.println("Recursos disponibles (Jugador: " + this.getNombre() + "):");
        System.out.println("Recurso 1: " + this.centroDeMando.getRecurso_tipo_1());
        System.out.println("Recurso 2: " + this.centroDeMando.getRecurso_tipo_2());
        System.out.println("Recurso 3: " + this.centroDeMando.getRecurso_tipo_3());
        System.out.println("**********************************************************");
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Edificacion getCentroDeMando() {
        return centroDeMando;
    }

    public void setCentroDeMando(Edificacion centroDeMando) {
        this.centroDeMando = centroDeMando;
    }
}
