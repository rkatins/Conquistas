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
	ArrayList<Pais> paises = new ArrayList<>();
	
	
	public int mLeerPropiedadesPrimero(int aleatorio) {
	    Properties propiedades = new Properties();
	    InputStream ficheroPropiedades = null;
	    InputStreamReader ficheroPropiedadesConvertido = null;
	    
	    int id = 0;
	    String nombre;
	    int ejercito;
	    String[] paisesVecinos;
	    int segundoPais;

	    try {
//		    Lo siguiente permitira leer ficheros, los cuales contiene un valor no legible
//		    y se le asignara la codificacion UTF-8 para que pueda mostrarlo
	        ficheroPropiedades = new FileInputStream("files\\" + aleatorio + ".properties");
	        ficheroPropiedadesConvertido = new InputStreamReader(ficheroPropiedades, StandardCharsets.UTF_8);
	        propiedades.load(ficheroPropiedadesConvertido);
	        
//	        ESTRUCTURA - Fichero de propiedades
//	        ID=
//    		Nombre=
//    		Ejercito=
//    		PaisVecino=
	        
	        id = Integer.parseInt(propiedades.getProperty("ID"));
	        nombre = propiedades.getProperty("Nombre");
	        ejercito = Integer.parseInt(propiedades.getProperty("Ejercito"));
	        paisesVecinos = propiedades.getProperty("PaisVecino").split(";");
	        
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
					
					paises.add(pais);
				}
			}
	        
	        segundoPais = Integer.parseInt(paisesVecinos[(int)(Math.random() * paisesVecinos.length)]);
	        
	        mLeerPropiedadesSegundo(segundoPais);
	        ficheroPropiedades.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("mLeerPropiedadesPrimero -> No se encontro el fichero");
	    } catch (IOException e) {
	        System.out.println("mLeerPropiedadesPrimero -> No se pudo leer el fichero");
	    }
	    
	    return id;
	}
	
	public int mLeerPropiedadesSegundo(int segundoPaisID) {
	    Properties propiedades = new Properties();
	    InputStream ficheroPropiedades = null;
	    
	    int id;
	    String nombre;
	    int ejercito = 0;
	    String[] paisesVecinos;

	    try {
	        ficheroPropiedades = new FileInputStream("files\\" + segundoPaisID + ".properties");
	        propiedades.load(ficheroPropiedades);
	        
//	        ESTRUCTURA - Fichero de propiedades
//	        ID=
//    		Nombre=
//    		Ejercito=
//    		PaisVecino=
	        
	        id = Integer.parseInt(propiedades.getProperty("ID"));
	        nombre = propiedades.getProperty("Nombre");
	        ejercito = Integer.parseInt(propiedades.getProperty("Ejercito"));
	        paisesVecinos = propiedades.getProperty("PaisVecino").split(";");
	        
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
					
					paises.add(pais);
				}
			}
	        
	        ficheroPropiedades.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("mLeerPropiedadesSegundo -> No se encontro el fichero");
	    } catch (IOException e) {
	        System.out.println("mLeerPropiedadesSegundo -> No se pudo leer el fichero");
	    }
	    
	    return ejercito;
	}
	
	public ArrayList<Pais> mDevolverArrayList() {
		return paises;
	}
}
