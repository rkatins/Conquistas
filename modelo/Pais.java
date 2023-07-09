package modelo;

import java.util.ArrayList;

public class Pais {
    private int ID;
    private String Nombre;
    private int Ejercito;
    private ArrayList<Integer> PaisVecino;
    private boolean conquistado;

    public Pais(int ID, String Nombre, int Ejercito, ArrayList<Integer> PaisVecino) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Ejercito = Ejercito;
        this.PaisVecino = PaisVecino;
        this.conquistado = false;
    }
    
    public Pais() {
    	
	}

	public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEjercito() {
        return Ejercito;
    }

    public void setEjercito(int Ejercito) {
        this.Ejercito = Ejercito;
    }

    public ArrayList<Integer> getPaisVecino() {
        return PaisVecino;
    }

    public void setPaisVecino(ArrayList<Integer> PaisVecino) {
        this.PaisVecino = PaisVecino;
    }
    
	public boolean isConquistado() {
		return conquistado;
	}

	public void setConquistado(boolean conquistado) {
		this.conquistado = conquistado;
	}

	@Override
	public String toString() {
		return "Pais [ID=" + ID + ", Nombre=" + Nombre + ", Ejercito=" + Ejercito + ", PaisVecino=" + PaisVecino + "]";
	}
}
