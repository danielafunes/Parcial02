package parcial2;

import java.util.HashMap;

public class Edificacion {

    private int vida;
    private int tipo;

    /*
        * 0 --> (Todos los recursos) ---> Sólo centro de mando, cuya principal función es alvergar  recursos (Valores iniciales: 10000, 5000, 3000)
        * 1 --> (Almacenamiento de recursos tipo 1)
        * 2 --> (Alacenamiento de recursos tipo 2)
        * 3 --> (Alacenamiento de recursos tipo 3)
        * 4 --> (Entrenamiento milicias (escuadron ó especialistas)) 
        * 5 --> (Construccion de vehículos (aereo o terrestre))
    */
    
    
    private boolean flag; // Es centro de mando ?
    private String edificacion;

    private int nivel;

    private int recurso_1; // Almacenamiento tipo 1
    private int recurso_2; // Almacenamiento tipo 2
    private int recurso_3; // Almacenamiento tipo 3

    private int recurso_tipo_1; // Almacenamiento tipo 1
    private int recurso_tipo_2; // Almacenamiento tipo 2
    private int recurso_tipo_3; // Almacenamiento tipo 3

    private int costo1; // costo tipo 1
    private int costo2; // costo tipo 2
    private int costo3; // costo tipo 3
    
    
    private int tiempo; // representa el tiempo de construcccion 

    public Edificacion(String edificacion, int vida, boolean flag, int tipo, int costo1, int costo2, int costo3, int tiempo) {
        this.vida = vida;
        this.flag = flag;
        this.edificacion = edificacion;
        this.nivel = 1;
        
        this.tipo = tipo;
        this.tiempo = tiempo;
        
        switch (tipo) {
            case 0:
                this.costo1 = 0;
                this.costo2 = 0;
                this.costo3 = 0;
                this.recurso_tipo_1 = costo1;
                this.recurso_tipo_2 = costo2;
                this.recurso_tipo_3 = costo3;
                this.recurso_1 = costo1;
                this.recurso_2 = costo2;
                this.recurso_3 = costo3;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                this.costo1 = costo1;
                this.costo2 = costo2;
                this.costo3 = costo3;
                break;
        }
    }

    public String getEdificacion() {
        return edificacion;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setEdificacion(String edificacion) {
        this.edificacion = edificacion;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCosto1() {
        return this.costo1;
    }

    public void setCosto1(int costo1) {
        this.costo1 = costo1;
    }

    public int getCosto2() {
        return this.costo2;
    }

    public void setCosto2(int costo2) {
        this.costo2 = costo2;
    }

    public int getCosto3() {
        return this.costo3;
    }

    public void setCosto3(int costo3) {
        this.costo3 = costo3;
    }

    public int getRecurso_tipo_1() {
        return recurso_tipo_1;
    }

    public void setRecurso_tipo_1(int recurso_tipo_1) {
        this.recurso_tipo_1 = recurso_tipo_1;
    }

    public int getRecurso_tipo_2() {
        return recurso_tipo_2;
    }

    public void setRecurso_tipo_2(int recurso_tipo_2) {
        this.recurso_tipo_2 = recurso_tipo_2;
    }

    public int getRecurso_tipo_3() {
        return recurso_tipo_3;
    }

    public void setRecurso_tipo_3(int recurso_tipo_3) {
        this.recurso_tipo_3 = recurso_tipo_3;
    }

    public int getRecurso_1() {
        return recurso_1;
    }

    public void setRecurso_1(int recurso_1) {
        this.recurso_1 = recurso_1;
    }

    public int getRecurso_2() {
        return recurso_2;
    }

    public void setRecurso_2(int recurso_2) {
        this.recurso_2 = recurso_2;
    }

    public int getRecurso_3() {
        return recurso_3;
    }

    public void setRecurso_3(int recurso_3) {
        this.recurso_3 = recurso_3;
    }

    
    
    public void generarRecursos(Jugador jugador) {
        switch (tipo) {
            case 0:
                this.recurso_tipo_1 = 10000;
                this.recurso_tipo_2 = 5000;
                this.recurso_tipo_3 = 3000; // Almacenamiento máximo
                break;
            case 1:
                if (this.recurso_tipo_1 <= jugador.getCentroDeMando().getRecurso_1()) {
                    this.recurso_tipo_1 = (int) Math.floor((0.10 * this.recurso_1) + this.recurso_1); // Almacenamiento máximo
                    System.out.println("Se ha incrementa el recurso tipo 1: " + this.recurso_tipo_1);
                } else {
                    System.out.println("Ya no puedes generar más recursos de tipo 1");
                }
                break;
            case 2:
                if (this.recurso_tipo_2 <= jugador.getCentroDeMando().getRecurso_2()) {
                    this.recurso_tipo_2 = (int) Math.floor((0.30 * this.recurso_2) + this.recurso_2); // Almacenamiento máximo
                    System.out.println("Se ha incrementa el recurso tipo 2: " + this.recurso_2);
                } else {
                    System.out.println("Ya no puedes generar más recursos de tipo 2");
                }
                break;
            case 3:
                if (this.recurso_tipo_3 <= jugador.getCentroDeMando().getRecurso_3()) {
                    this.recurso_tipo_3 = (int) Math.floor((0.30 * this.recurso_3) + this.recurso_3); // Almacenamiento máximo
                    System.out.println("Se ha incrementa el recurso tipo 3: " + this.recurso_3);
                } else {
                    System.out.println("Ya no puedes generar más recursos de tipo 3");
                }
                break;
            case 4:
                  
                break;
            case 5:
                
                break;
        }
    }

    public void mejorarEdificacion(Jugador jugador) {
        int costoMejora = 0;
        
        switch (this.nivel) {
            case 1:
                jugador.getCentroDeMando().setRecurso_1((int) Math.floor((jugador.getCentroDeMando().getRecurso_1() * 0.10) + jugador.getCentroDeMando().getRecurso_1()));
                jugador.getCentroDeMando().setRecurso_2((int) Math.floor((jugador.getCentroDeMando().getRecurso_2() * 0.10) + jugador.getCentroDeMando().getRecurso_2()));
                jugador.getCentroDeMando().setRecurso_3((int) Math.floor((jugador.getCentroDeMando().getRecurso_3() * 0.10) + jugador.getCentroDeMando().getRecurso_3()));
                
                costoMejora = (int) Math.floor(0.25 * (jugador.getCentroDeMando().getRecurso_1() + jugador.getCentroDeMando().getRecurso_2() + jugador.getCentroDeMando().getRecurso_3()));
                costoMejora = costoMejora / 3;
                
                if ((jugador.getCentroDeMando().getRecurso_tipo_1() - costoMejora) >= 0 && (jugador.getCentroDeMando().getRecurso_tipo_2() - costoMejora) >= 0 && (jugador.getCentroDeMando().getRecurso_tipo_3() - costoMejora) >= 0) {
                    jugador.getCentroDeMando().setRecurso_tipo_1(jugador.getCentroDeMando().getRecurso_tipo_1()  - costoMejora);
                    jugador.getCentroDeMando().setRecurso_tipo_2(jugador.getCentroDeMando().getRecurso_tipo_2()  - costoMejora);
                    jugador.getCentroDeMando().setRecurso_tipo_3(jugador.getCentroDeMando().getRecurso_tipo_3()  - costoMejora);
                } else {
                    System.out.println("No posees suficientes recusos.");
                }
                
                this.nivel ++;
                break;
            case 2:
                jugador.getCentroDeMando().setRecurso_1((int) Math.floor((jugador.getCentroDeMando().getRecurso_1() * 0.30) + jugador.getCentroDeMando().getRecurso_1()));
                jugador.getCentroDeMando().setRecurso_2((int) Math.floor((jugador.getCentroDeMando().getRecurso_2() * 0.30) + jugador.getCentroDeMando().getRecurso_2()));
                jugador.getCentroDeMando().setRecurso_3((int) Math.floor((jugador.getCentroDeMando().getRecurso_3() * 0.30) + jugador.getCentroDeMando().getRecurso_3()));
                            
                costoMejora = (int) Math.floor(0.25 * (jugador.getCentroDeMando().getRecurso_1() + jugador.getCentroDeMando().getRecurso_2() + jugador.getCentroDeMando().getRecurso_3()));
                costoMejora = costoMejora / 3;
                   
                if ((jugador.getCentroDeMando().getRecurso_tipo_1() - costoMejora) >= 0 && (jugador.getCentroDeMando().getRecurso_tipo_2() - costoMejora) >= 0 && (jugador.getCentroDeMando().getRecurso_tipo_3() - costoMejora) >= 0) {
                    jugador.getCentroDeMando().setRecurso_tipo_1(jugador.getCentroDeMando().getRecurso_tipo_1()  - costoMejora);
                    jugador.getCentroDeMando().setRecurso_tipo_2(jugador.getCentroDeMando().getRecurso_tipo_2()  - costoMejora);
                    jugador.getCentroDeMando().setRecurso_tipo_3(jugador.getCentroDeMando().getRecurso_tipo_3()  - costoMejora);
                } else {
                    System.out.println("No posees suficientes recusos.");
                }
                
                this.nivel ++;
                break;
            case 3:
                jugador.getCentroDeMando().setRecurso_1((int) Math.floor((jugador.getCentroDeMando().getRecurso_1() * 0.50) + jugador.getCentroDeMando().getRecurso_1()));
                jugador.getCentroDeMando().setRecurso_2((int) Math.floor((jugador.getCentroDeMando().getRecurso_2() * 0.50) + jugador.getCentroDeMando().getRecurso_2()));
                jugador.getCentroDeMando().setRecurso_3((int) Math.floor((jugador.getCentroDeMando().getRecurso_3() * 0.50) + jugador.getCentroDeMando().getRecurso_3()));
                
                
                costoMejora = (int) Math.floor(0.25 * (jugador.getCentroDeMando().getRecurso_1() + jugador.getCentroDeMando().getRecurso_2() + jugador.getCentroDeMando().getRecurso_3()));
                costoMejora = costoMejora / 3;
                
                if ((jugador.getCentroDeMando().getRecurso_tipo_1() - costoMejora) >= 0 && (jugador.getCentroDeMando().getRecurso_tipo_2() - costoMejora) >= 0 && (jugador.getCentroDeMando().getRecurso_tipo_3() - costoMejora) >= 0) {
                    jugador.getCentroDeMando().setRecurso_tipo_1(jugador.getCentroDeMando().getRecurso_tipo_1()  - costoMejora);
                    jugador.getCentroDeMando().setRecurso_tipo_2(jugador.getCentroDeMando().getRecurso_tipo_2()  - costoMejora);
                    jugador.getCentroDeMando().setRecurso_tipo_3(jugador.getCentroDeMando().getRecurso_tipo_3()  - costoMejora);
                } else {
                    System.out.println("No posees suficientes recusos.");
                }
                break;
        }
        
        System.out.println("***************************************************");
        System.out.println("El centro de mando ha sido mejorado. (Nivel " + this.nivel + ")");
        System.out.println("Almacenamiento tipo 1: " + this.recurso_1);
        System.out.println("Almacenamiento tipo 2: " + this.recurso_2);
        System.out.println("Almacenamiento tipo 3: " + this.recurso_3);
        System.out.println("Recursos disponibles: ");
        System.out.println("Recurso 1: " + this.recurso_tipo_1);
        System.out.println("Recurso 2: " + this.recurso_tipo_2);
        System.out.println("Recurso 3: " + this.recurso_tipo_3);
        System.out.println("***************************************************");
    }
}
