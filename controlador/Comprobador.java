package controlador;

import java.util.ArrayList;

import modelo.Fichero;
import modelo.Pais;

public class Comprobador {
	Fichero fichero = new Fichero();
	ArrayList<Pais> paises = new ArrayList<>();
	
	public void mEmpezarComprobaciones() {
		boolean conquistados = true;
		
		while (!conquistados) {
			int aleatorio = (int)(Math.random() * 185) + 1;
			
			int idFichero1 = fichero.mLeerPropiedadesPrimero(aleatorio);
			int ejercitoFichero1 = 0;
			
			mActualizarArrayList();
			
			int idFichero2 = 0;
			for (int i = 0; i < paises.size(); i++) {
				if (paises.get(i).getID() == idFichero1) {
					ejercitoFichero1 = paises.get(i).getEjercito();
					idFichero2 = paises.get(i).getPaisVecino().get((int)(Math.random() * paises.get(i).getPaisVecino().size()) + 1);
					fichero.mLeerPropiedadesSegundo(idFichero2);
					
					mActualizarArrayList();
				}
			}
			
			int ejercitoFichero2 = 0;
			for (int i = 0; i < paises.size(); i++) {
				if (paises.get(i).getID() == idFichero2) {
					ejercitoFichero2 = paises.get(i).getEjercito();
				}
			}
			
			if (ejercitoFichero1 > ejercitoFichero2) {
				String nombreFichero1 = null;
				String nombreFichero2 = null;
				
				for (int i = 0; i < paises.size(); i++) {
					if (paises.get(i).getID() == idFichero1) {						
						nombreFichero1 = paises.get(i).getNombre();
					}
					
					if (paises.get(i).getID() == idFichero2) {
						paises.get(i).setConquistado(true);
						
						nombreFichero2 = paises.get(i).getNombre();
					}
				}
				
				System.err.println("En la batalla entre " + nombreFichero1 + " y " + nombreFichero2 + ": GANA " + nombreFichero1);
			} else if (ejercitoFichero1 < ejercitoFichero2) {
				String nombreFichero1 = null;
				String nombreFichero2 = null;
					
				for (int i = 0; i < paises.size(); i++) {
					if (paises.get(i).getID() == idFichero1) {
						nombreFichero1 = paises.get(i).getNombre();
						
						paises.get(i).setConquistado(true);
					}
					
					if (paises.get(i).getID() == idFichero2) {
						nombreFichero2 = paises.get(i).getNombre();
					}
				}
				
				System.err.println("En la batalla entre " + nombreFichero1 + " y " + nombreFichero2 + ": GANA " + nombreFichero1);
			}
		}
	}
	
	private void mActualizarArrayList() {
		for (int i = 0; i < fichero.mDevolverArrayList().size(); i++) {
			paises.add(fichero.mDevolverArrayList().get(i));
		}
	}
}
