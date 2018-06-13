package parcial2;

public class Milicia {
    private int tipo; // Escuadron o especialista
    private int ataque;
    private int costo1;
    private int costo2;
    private int costo3;
    private String personaje;
    
    public Milicia () {
        
    }

    public Milicia (String personaje, int costo1, int costo2, int costo3, int ataque, int tipo) {
        this.tipo = tipo;
        this.costo1 = costo1;
        this.costo2 = costo2;
        this.costo3 = costo3;
        this.ataque = ataque;
        this.personaje = personaje;
    }

    public int getCosto1() {
        return costo1;
    }

    public void setCosto1(int costo1) {
        this.costo1 = costo1;
    }

    public int getCosto2() {
        return costo2;
    }

    public void setCosto2(int costo2) {
        this.costo2 = costo2;
    }

    public int getCosto3() {
        return costo3;
    }

    public void setCosto3(int costo3) {
        this.costo3 = costo3;
    }
    
    

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }
}
