package controlador;

import java.util.ArrayList;

import modelo.Fichero;
import modelo.Pais;

public class Comprobador {
	Fichero fichero = new Fichero();
	ArrayList<Pais> paises = new ArrayList<>();
	
	public void mEmpezarComprobaciones() {
		boolean conquistados = true;
		int vueltas = 0;
		
		while (conquistados) {
			int aleatorio = (int)(Math.random() * 185) + 1;
			
			int idFichero1 = 0;
			int ejercitoFichero1 = 0;
			
			int idFichero2 = 0;
			int ejercitoFichero2 = 0;			
			
			idFichero1 = fichero.mLeerPropiedadesPrimero(aleatorio);
			paises = mActualizarArrayList();
			
				for (int i = 0; i < paises.size(); i++) {
					if (idFichero1 == paises.get(i).getID()) {
						while (paises.get(i).getPaisVecino().size() == 1 && paises.get(i).getPaisVecino().contains(0)) {
							paises.remove(i);
							
							aleatorio = (int)(Math.random() * 185) + 1;
							idFichero1 = fichero.mLeerPropiedadesPrimero(aleatorio);
							
							paises = mActualizarArrayList();
						}
					}
				}
			
			paises = mActualizarArrayList();
			for (int i = 0; i < paises.size(); i++) {
				if (idFichero1 == paises.get(i).getID()) {
					System.out.println(paises.get(i).getID() + "_" + paises.get(i).getNombre() + " => " + paises.get(i).getPaisVecino() + " logitud = " + paises.get(i).getPaisVecino().size());
				}
			}
			
			
			
			
			
			// Solamente esta para ejecutarse las veces que se requiera para hacer pruebas
			vueltas++;
			
			if (vueltas == 1) {
				conquistados = false;
			} else {
				conquistados = true;
				System.out.println("--- --- --- ---");
			}
			
			//			
//			int idFichero2 = 0;
//			for (int i = 0; i < paises.size(); i++) {
//				if (paises.get(i).getID() == idFichero1) {
//					ejercitoFichero1 = paises.get(i).getEjercito();
//					
//					try {
//						idFichero2 = paises.get(i).getPaisVecino().get((int)(Math.random() * paises.get(i).getPaisVecino().size()));
//					} catch (NullPointerException e) {
//					}
//					
//					try {
//						for (int j = 0; j < paises.size(); j++) {
//							System.out.println("posible idFichero2 -> " + paises.get(i).getPaisVecino().get(j));
//						}
//					} catch (NullPointerException e) {
//					}
//
//					System.out.println("idFichero2 -> " + idFichero2);
//					fichero.mLeerPropiedadesSegundo(idFichero2);
//					
//					mActualizarArrayList();
//				}
//			}
//			
//			int ejercitoFichero2 = 0;
//			for (int i = 0; i < paises.size(); i++) {
//				if (paises.get(i).getID() == idFichero2) {
//					ejercitoFichero2 = paises.get(i).getEjercito();
//				}
//			}
//			
//			if (ejercitoFichero1 > ejercitoFichero2) {
//				String nombreFichero1 = null;
//				String nombreFichero2 = null;
//				
//				for (int i = 0; i < paises.size(); i++) {
//					if (paises.get(i).getID() == idFichero1) {						
//						nombreFichero1 = paises.get(i).getNombre();
//					}
//					
//					if (paises.get(i).getID() == idFichero2) {
//						paises.get(i).setConquistado(true);
//						
//						nombreFichero2 = paises.get(i).getNombre();
//					}
//				}
//				
//				System.err.println("En la batalla entre " + nombreFichero1 + " y " + nombreFichero2 + ": GANA " + nombreFichero1);
//			} else if (ejercitoFichero1 < ejercitoFichero2) {
//				String nombreFichero1 = null;
//				String nombreFichero2 = null;
//					
//				for (int i = 0; i < paises.size(); i++) {
//					if (paises.get(i).getID() == idFichero1) {
//						nombreFichero1 = paises.get(i).getNombre();
//						
//						paises.get(i).setConquistado(true);
//					}
//					
//					if (paises.get(i).getID() == idFichero2) {
//						nombreFichero2 = paises.get(i).getNombre();
//					}
//				}
//				
//				System.err.println("En la batalla entre " + nombreFichero1 + " y " + nombreFichero2 + ": GANA " + nombreFichero1);
//			}
		}
	}
	
	private ArrayList<Pais> mActualizarArrayList() {
		return fichero.mDevolverArrayList();
	}
}
