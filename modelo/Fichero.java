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
	    
	    int id = aleatorio;
	    String nombre;
	    int ejercito = 0;
	    String[] paisesVecinos;

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
	        try {
	        	ejercito = Integer.parseInt(propiedades.getProperty("Ejercito"));
			} catch (NumberFormatException e) {
			}
	        paisesVecinos = propiedades.getProperty("PaisVecino").split(";");
	        
	        boolean paisDuplicado = false;
	        
	        for (int i = 0; i < paises.size(); i++) {
	        	try {
	        		if (id == paises.get(i).getID()) {
						i = paises.size() + 1;
						paisDuplicado = true;
					}
				} catch (IndexOutOfBoundsException e) {
					System.err.println("61 -> No hay nada de nada guardado en el ArrayList<Pais> => paises");
				}
	        }
	        
	        if (!paisDuplicado) {
	            Pais pais = new Pais();
	            try {
					for (int j = 0; j < paisesVecinos.length; j++) {
						try {
							pais.getPaisVecino().add(Integer.parseInt(paisesVecinos[j]));
						} catch (NumberFormatException e) {
							System.err.println("72 -> No fue posible convertir la cadena de texto paisesVecinos[j] en un numero, o es null");
						} catch (IndexOutOfBoundsException e) {
							System.err.println("74 -> No hay nada de nada guardado en el ArrayList<Pais> => paisesVecinos");
						}
		            }
				} catch (NullPointerException e) {
				}
	            
	            pais.setID(id);
	            pais.setNombre(nombre);
	            pais.setEjercito(ejercito);
	            
	            paises.add(pais);
	            paisDuplicado = false;
	        }     		


			
	        ficheroPropiedades.close();
	    } catch (FileNotFoundException e) {
	        System.err.println("mLeerPropiedadesPrimero -> No se encontro el fichero");
	    } catch (IOException e) {
	        System.err.println("mLeerPropiedadesPrimero -> No se pudo leer el fichero");
	    }
        
	    return id;
	}
	
	public int mLeerPropiedadesSegundo(int primerPaisID) {
	    Properties propiedades = new Properties();
	    InputStream ficheroPropiedades = null;
	    
	    int id;
	    String nombre;
	    int ejercito = 0;
	    String[] paisesVecinos;
	    
	    for (int i = 0; i < paises.size(); i++) {
	    	if (primerPaisID == paises.get(i).getID()) {
	    		id = paises.get(i).getPaisVecino().get((int) (Math.random() * paises.get(i).getPaisVecino().size()) + 1);
			}
		}

	    try {
	        ficheroPropiedades = new FileInputStream("files\\" + primerPaisID + ".properties");
	        propiedades.load(ficheroPropiedades);
	        
//	        ESTRUCTURA - Fichero de propiedades
//	        ID=
//    		Nombre=
//    		Ejercito=
//    		PaisVecino=
	        
	        id = Integer.parseInt(propiedades.getProperty("ID"));
	        nombre = propiedades.getProperty("Nombre");
	        try {
	        	ejercito = Integer.parseInt(propiedades.getProperty("Ejercito"));
	        	
//	        	 NumberFormatException no se produce cuando se devuelve un valor null,
//	        	 sino cuando se intenta convertir una cadena de caracteres en un número,
//	        	 pero la cadena no tiene un formato numérico válido.
//	        	 La excepción NumberFormatException se lanza cuando se utiliza el
//	        	 método Integer.parseInt() (o métodos similares para otros tipos numéricos)
//	        	 para convertir una cadena en un número entero, pero la cadena no se puede interpretar como un número válido.
			} catch (NumberFormatException e) {
			}
	        paisesVecinos = propiedades.getProperty("PaisVecino").split(";");
	        
	        for (int i = 0; i < paises.size(); i++) {
				if (id == paises.get(i).getID()) {
					i = paises.size() + 1;
				} else {
					Pais pais = new Pais();
	            try {
					for (int j = 0; j < paisesVecinos.length; j++) {
		                pais.getPaisVecino().add(Integer.parseInt(paisesVecinos[j]));
		            }
				} catch (NullPointerException e) {
				}
	            
	            pais.setID(id);
	            pais.setNombre(nombre);
	            pais.setEjercito(ejercito);
	            
	            paises.add(pais);
				}
			}
	        
	        ficheroPropiedades.close();
	    } catch (FileNotFoundException e) {
	        System.err.println("mLeerPropiedadesSegundo -> No se encontro el fichero");
	    } catch (IOException e) {
	        System.err.println("mLeerPropiedadesSegundo -> No se pudo leer el fichero");
	    }
	    
	    return ejercito;
	}
	
	public ArrayList<Pais> mDevolverArrayList() {
		return paises;
	}
}
