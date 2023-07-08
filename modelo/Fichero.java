package modelo;

import java.util.ArrayList;

import java.util.Properties;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// El siguiente import permite que epecifiquemos la coddificacion de la variable de tipo InputStreamReader
import java.nio.charset.StandardCharsets;
// // Permite cambiar la codificacion de la consola
//import java.io.PrintStream;
//import java.io.UnsupportedEncodingException;

public class Fichero {
	public static void main(String[] args) {
		System.setProperty("file.encoding", "UTF-8");
		
//		try {
//			System.setOut(new PrintStream(System.out, true, "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			System.err.println("No se pudo codificar la consola");
//		}


		mLeerPropiedadesPrimero();
	}
	
	public static void mLeerPropiedadesPrimero() {
	    Properties propiedades = new Properties();
	    InputStream ficheroPropiedades = null;
//	    Lo siguiente permitira leer ficheros, los cuales contiene un valor no legible
//	    y se le asignara la codificacion UTF-8 para que pueda mostrarlo
	    InputStreamReader ficheroPropiedadesConvertido = null;
	    int aleatorio = (int)(Math.random() * 49) + 1;
	    
		ArrayList<Pais> paises = new ArrayList<>();

	    try {
	        ficheroPropiedades = new FileInputStream("files\\" + aleatorio + ".properties");
	        ficheroPropiedadesConvertido = new InputStreamReader(ficheroPropiedades, StandardCharsets.UTF_8);
	        propiedades.load(ficheroPropiedadesConvertido);
	        
//	        ESTRUCTURA - Fichero de propiedades
//	        ID=
//    		Nombre=
//    		Ejercito=
//    		PaisVecino=
	        
	        int id = Integer.parseInt(propiedades.getProperty("ID"));
	        String nombre = propiedades.getProperty("Nombre");
	        int ejercito = Integer.parseInt(propiedades.getProperty("Ejercito"));
	        String[] paisesVecinos = propiedades.getProperty("PaisVecino").split(";");
	        
	        for (int i = 0; i < paises.size(); i++) {
				if (id == paises.get(i).getID()) {
					i = paises.size() + 1;
				} else {
					Pais pais = new Pais();
					
					for (int j = 0; j < paisesVecinos.length; j++) {
						pais.getPaisVecino().add(Integer.parseInt(paisesVecinos[j]));
					}
					
					pais.setID(id);
					pais.setNombre(nombre);
					pais.setEjercito(ejercito);
				}
			}
	        
	        int segundoPais = Integer.parseInt(paisesVecinos[(int)(Math.random() * paisesVecinos.length)]);
	        
	        mLeerPropiedadesSegundo(segundoPais);
	        ficheroPropiedades.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("mLeerPropiedadesPrimero -> No se encontro el fichero");
	    } catch (IOException e) {
	        System.out.println("mLeerPropiedadesPrimero -> No se pudo leer el fichero");
	    }
	}
	
	public static void mLeerPropiedadesSegundo(int segundoPais) {
	    Properties propiedades = new Properties();
	    InputStream ficheroPropiedades = null;

	    try {
	        ficheroPropiedades = new FileInputStream("files\\" + segundoPais + ".properties");
	        propiedades.load(ficheroPropiedades);
	        
//	        ESTRUCTURA - Fichero de propiedades
//	        ID=
//    		Nombre=
//    		Ejercito=
//    		PaisVecino=
	        
	        System.out.println("ID Segundo pais -> " + propiedades.getProperty("ID"));
//	        System.out.println(propiedades.getProperty("Nombre"));
//	        System.out.println(propiedades.getProperty("Ejercito"));
//	        System.out.println(propiedades.getProperty("PaisVecino"));
	        System.out.println("\n\n");
	        
	        ficheroPropiedades.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("mLeerPropiedadesSegundo -> No se encontro el fichero");
	    } catch (IOException e) {
	        System.out.println("mLeerPropiedadesSegundo -> No se pudo leer el fichero");
	    }
	}
}
