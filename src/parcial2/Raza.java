package parcial2;

public class Raza {
    private String nombre;
    /*
        * 0 ---> Construir edificios con mucha velocidad
        * 1 ---> Super milicia (Fuerza en puntos de ataque)
        * 2 ---> Construir vehiculos con mucha velocidad
    */
    private int fortaleza;
    /*
        * 0 --> Crear edificaciones
        * 1 --> Entrenar milicia
        * 2 --> Creacion de vehiculos
    */
    private int tipo;
   
  
    public Raza (String nombre, int tipo, int fortaleza) {
      this.nombre = nombre;
      this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFortaleza() {
        return fortaleza;
    }

    public void setFortaleza(int fortaleza) {
        this.fortaleza = fortaleza;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
