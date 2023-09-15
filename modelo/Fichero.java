package modelo;

import java.util.ArrayList;
import java.util.Properties;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// El siguiente import permite que epecifiquemos la codificacion de la variable de tipo InputStreamReader
import java.nio.charset.StandardCharsets;
//Permite cambiar la codificacion de la consola
//import java.io.PrintStream;
//import java.io.UnsupportedEncodingException;

public class Fichero {
	ArrayList<Pais> paises = new ArrayList<>();
	private int[] paisesVecinosConvertidos;
	
	
	public int mLeerPropiedadesPrimero(int aleatorio) {
	    Properties propiedades = new Properties();
	    InputStream ficheroPropiedades = null;
	    InputStreamReader ficheroPropiedadesConvertido = null;
	    
	    // Podria contener un valor 0, solamente esta para inicializar la variable
	    int id = aleatorio;
	    
	    String nombre;
	    int ejercito = 0;
	    ArrayList<Integer> paisesVecinos = new ArrayList<>();
	   
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
	        
	        int longitudPaisesVecinos = propiedades.getProperty("PaisVecino").split(";").length;
	        String[] arrayPaisesVecinos = propiedades.getProperty("PaisVecino").split(";");
	        for (int i = 0; i < longitudPaisesVecinos; i++) {
				paisesVecinos.add(Integer.parseInt(arrayPaisesVecinos[i]));
			}
	        
	        boolean paisDuplicado = false;
	        
	        for (int i = 0; i < paises.size(); i++) {
	        	try {
	        		if (id == paises.get(i).getID()) {
						i = paises.size() + 1;
						paisDuplicado = true;
					}
				} catch (IndexOutOfBoundsException e) {
					System.err.println("TCx001001 -> No hay nada de nada guardado en el ArrayList<Pais> => paises");
				}
	        }
	        
	        if (!paisDuplicado) {
	            Pais pais = new Pais(id, nombre, ejercito, paisesVecinos);
	            try {
					for (int j = 0; j < paisesVecinosConvertidos.length; j++) {
						try {
							pais.getPaisVecino().add(paisesVecinosConvertidos[j]);
						} catch (NumberFormatException e) {
							System.err.println("TCx001002 -> No fue posible convertir la cadena de texto paisesVecinos[j] en un numero, o es null");
						} catch (IndexOutOfBoundsException e) {
							System.err.println("TCx001003 -> No hay nada de nada guardado en el ArrayList<Pais> => paisesVecinos");
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
	        System.err.println("TCx001004 -> No se encontro el fichero");
	    } catch (IOException e) {
	        System.err.println("TCx001005 -> No se pudo leer el fichero");
	    }
        
	    return id;
	}
	
	public int mLeerPropiedadesSegundo(int idPrimero) {
	    Properties propiedades = new Properties();
	    InputStream ficheroPropiedades = null;
	    InputStreamReader ficheroPropiedadesConvertido = null;
	    
	    int id = 0;
	    String nombre;
	    int ejercito = 0;
	    ArrayList<Integer> paisesVecinos = new ArrayList<>();
	    
	    for (int i = 0; i < paises.size(); i++) {
			if (paises.get(i).getID() == idPrimero) {
				id = paises.get(i).getPaisVecino().get((int)(Math.random() * paises.get(i).getPaisVecino().size()));
			} 
		}

//	    try {
////		    Lo siguiente permitira leer ficheros, los cuales contiene un valor no legible
////		    y se le asignara la codificacion UTF-8 para que pueda mostrarlo
//	        ficheroPropiedades = new FileInputStream("files\\" + aleatorio2 + ".properties");
//	        ficheroPropiedadesConvertido = new InputStreamReader(ficheroPropiedades, StandardCharsets.UTF_8);
//	        propiedades.load(ficheroPropiedadesConvertido);
//	        
////	        ESTRUCTURA - Fichero de propiedades
////	        ID=
////    		Nombre=
////    		Ejercito=
////    		PaisVecino=
//	        	        
//	        id = Integer.parseInt(propiedades.getProperty("ID"));
//	        
//	        nombre = propiedades.getProperty("Nombre");
//	        
//	        ejercito = Integer.parseInt(propiedades.getProperty("Ejercito"));
//	        
//	        int longitudPaisesVecinos = propiedades.getProperty("PaisVecino").split(";").length;
//	        String[] arrayPaisesVecinos = propiedades.getProperty("PaisVecino").split(";");
//	        for (int i = 0; i < longitudPaisesVecinos; i++) {
//				paisesVecinos.add(Integer.parseInt(arrayPaisesVecinos[i]));
//			}
//	        
//	        boolean paisDuplicado = false;
//	        
//	        for (int i = 0; i < paises.size(); i++) {
//	        	try {
//	        		if (id == paises.get(i).getID()) {
//						i = paises.size() + 1;
//						paisDuplicado = true;
//					}
//				} catch (IndexOutOfBoundsException e) {
//					System.err.println("TCx002001 -> No hay nada de nada guardado en el ArrayList<Pais> => paises");
//				}
//	        }
//	        
//	        if (!paisDuplicado) {
//	            Pais pais = new Pais(id, nombre, ejercito, paisesVecinos);
//	            try {
//					for (int j = 0; j < paisesVecinosConvertidos.length; j++) {
//						try {
//							pais.getPaisVecino().add(paisesVecinosConvertidos[j]);
//						} catch (NumberFormatException e) {
//							System.err.println("TCx002002 -> No fue posible convertir la cadena de texto paisesVecinos[j] en un numero, o es null");
//						} catch (IndexOutOfBoundsException e) {
//							System.err.println("TCx002003 -> No hay nada de nada guardado en el ArrayList<Pais> => paisesVecinos");
//						}
//		            }
//				} catch (NullPointerException e) {
//				}
//	            
//	            pais.setID(id);
//	            pais.setNombre(nombre);
//	            pais.setEjercito(ejercito);
//	            
//	            paises.add(pais);
//	            paisDuplicado = false;
//	        }
//			
//	        ficheroPropiedades.close();
//	    } catch (FileNotFoundException e) {
//	        System.err.println("TCx002004 -> No se encontro el fichero");
//	    } catch (IOException e) {
//	        System.err.println("TCx002005 -> No se pudo leer el fichero");
//	    }
	    return id;
	}
	
	public ArrayList<Pais> mDevolverArrayList() {
		return paises;
	}
}
