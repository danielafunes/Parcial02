package parcial2;

public class Vehiculos {
   private int tipo; // Aereo y terrestre
   private int vida; 
   
   private final int costo1;
   private final int costo2;
   private final int costo3;
   private final int ataque; // puntos de ataque
   
   private Edificacion edificacion;
   
   private String nombre;
   private int tiempo;
   
   public Vehiculos (String nombre, int vida, int costo1, int costo2, int costo3, int ataque, Edificacion edificacion, int tiempo) {
       this.vida = vida;
       this.nombre = nombre;
       
       this.costo1 = costo1;
       this.costo2 = costo2;
       this.costo3 = costo3;
       
       this.tiempo = tiempo;
       this.ataque = ataque;
       this.edificacion = edificacion;
   }

    public Edificacion getEdificacion() {
        return edificacion;
    }

    public void setEdificacion(Edificacion edificacion) {
        this.edificacion = edificacion;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
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

    public int getCosto1() {
        return costo1;
    }

    public int getCosto2() {
        return costo2;
    }

    public int getCosto3() {
        return costo3;
    }

    public int getAtaque() {
        return ataque;
    }
    
    
}
