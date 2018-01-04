package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Element;
import org.dom4j.Node;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import models.Utilities;

import models.Agenda;
import models.Contacto;
import models.Empleado;


public  class Controlador {
	
	private static char[] passAdmin = "admin".toCharArray();  //Contraseña del director
	private static String userAdmin = "boss";	 //Nombre de usuario del director
	
	private static char[] passEmpNuevo ;
	private static String userEmpNuevo ;
	
	private static char[] passEmpExistente ;
	private static String userEmpExistente ;
	
	private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private static ArrayList<Agenda> agendas = new ArrayList<Agenda>();
	private static int caso;  // 1: Director , 2:Empleado existente , 3:Empleado nuevo
	
	private static final String[] DEPARTAMENTOS = new String[] {"DIRECCIÓN", "COMPRAS", "RECURSOS HUMANOS", "ADMINISTRACIÓN", "PRODUCCIÓN", "CONTROL DE GESTIÓN"};
	private static final String[] GRUPO_SANGUINEO = new String[] {"A", "B", "O","AB"};
	private static final String[] SPECIAL_OPS = new String[] {"OP_ANACONDA", "OP_SINIESTRO", "OP_HAKUNAMATATA","OP_RATATA"};
	private static boolean pos_neg;  //Si es positivo, es true
	
	public static boolean correcto;   //Para las validaciones
	
	
	
	
	
	public static char[] getPassAdmin() {
		return passAdmin;
	}
	public static void setPassAdmin(char[] passAdmin) {
		Controlador.passAdmin = passAdmin;
	}
	public static String getUserAdmin() {
		return userAdmin;
	}
	public static void setUserAdmin(String userAdmin) {
		Controlador.userAdmin = userAdmin;
	}
	public static ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	public static void setEmpleados(ArrayList<Empleado> empleados) {
		Controlador.empleados = empleados;
	}
	public static ArrayList<Agenda> getAgendas() {
		return agendas;
	}
	public static void setAgendas(ArrayList<Agenda> agendas) {
		Controlador.agendas = agendas;
	}
	public static int getCaso() {
		return caso;
	}
	public static void setCaso(int caso) {
		Controlador.caso = caso;
	}
	public static boolean isPos_neg() {
		return pos_neg;
	}
	public static void setPos_neg(boolean pos_neg) {
		Controlador.pos_neg = pos_neg;
	}
	public static String[] getDepartamentos() {
		return DEPARTAMENTOS;
	}
	public static String[] getGrupoSanguineo() {
		return GRUPO_SANGUINEO;
	}
	public static String[] getSpecialOps() {
		return SPECIAL_OPS;
	}
	
	public static void setSpecialOps(String op) {//****************
		
	}
	
	public static char[] getPassEmpNuevo() {
		return passEmpNuevo;
	}
	public static void setPassEmpNuevo(char[] passEmpNuevo) {
		Controlador.passEmpNuevo = passEmpNuevo;
	}
	public static String getUserEmpNuevo() {
		return userEmpNuevo;
	}
	public static void setUserEmpNuevo(String userEmpNuevo) {
		Controlador.userEmpNuevo = userEmpNuevo;
	}
	public static char[] getPassEmpExistente() {
		return passEmpExistente;
	}
	public static void setPassEmpExistente(char[] passEmpExistente) {
		Controlador.passEmpExistente = passEmpExistente;
	}
	public static String getUserEmpExistente() {
		return userEmpExistente;
	}
	public static void setUserEmpExistente(String userEmpExistente) {
		Controlador.userEmpExistente = userEmpExistente;
	}
	/**
	 * Captar pass y user del empleado nuevo
	 */
	
	public static void captarDatosEmpNuevo(String user, char[]pass) {
		userEmpNuevo = user;
		passEmpNuevo = pass;
		
	}
	
	/**
	 * Captar pass y user del empleado existente
	 */
	public static void captarDatosExistente(String user, char[]pass) {
		userEmpExistente = user;
		passEmpExistente = pass;
		
	}
	
	/**
	 * Comprobamos si existe este departamento dentro de nuestra lista de departamentos oficiales
	 */
	public static boolean comprobarDepartamento(String dep) {
	
		boolean ok = false;
		for (String el : DEPARTAMENTOS) {
			
			if(el.equals(dep.toUpperCase()))
				ok = true;
			
		}
		return ok;
	}
	
	/**
	 * Comprobamos si existe esta operacion dentro de la base de datos de las operaciones reales
	 */
	public static boolean comprobarOperacionEspecial(String op) {
	
		boolean ok = false;
		for (String oper : SPECIAL_OPS ) {
			
			if(oper.equals(op.toUpperCase()))
				ok = true;
			
		}
		return ok;
	}
		
	
	/**
	 * Metodos de validacion del controlador
	 */
	
	public static boolean esSoloLetras(String name) {
	    return name.matches("[a-zA-Z]+");
	}
	
	/**
	 * Metodo que nos controla el numero de contactos especiales por empleado (Max de 5)
	 * Devuelve el numero de contatos especiales del empleado
	 */
	
	public static int getNumContactosEsp(Empleado emp) {
		
		int contador=0;
		for (Contacto contact : emp.getListaContactos()) {
			if(contact.isContactoEsp()) {
				contador++;
			}
		}
		return contador;
		
		
	}
	
	public static String listarOpEspeciales(Empleado empleado) {
		String res = "";
		for (String string : empleado.getListaCodigosEsp()) {
			res+="["+string+"] ";
		}	
		return res;
	}
	
	public static String listarContactos(Empleado empleado) {
		String res = "";
		for (Contacto c : empleado.getListaContactos()) {
			res+="["+c.toString()+"] ";
		}	
		return res;
	}
	
	
	public static <T extends Serializable> void convertirBinario(String pathDest, Empleado emp) throws
	FileNotFoundException, IOException{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pathDest));
		try{
			out.writeObject(emp);
		} finally {
			if (out!=null){
				out.close();
			}
		}
	}

	public static Empleado generarEmpTest() {

		Calendar fexNac = new GregorianCalendar();
		Calendar fexIni = new GregorianCalendar();
		fexNac.set(1981, 9, 27);
		fexIni.set(2012, 8, 27);
		Set<String> listaCodigosEspTest = new HashSet<String>();
		listaCodigosEspTest.add("OP_RATATA");
		ArrayList<Contacto> listaContactosTest = new ArrayList<Contacto>();
		Contacto contactTest = new Contacto("cenec", "678888888", true);
		listaContactosTest.add(contactTest);
		char[]passAli = "smiliali".toCharArray();
		/**
		 * Creamos un empleado de prueba y se lo añadimos al controlador
		 */
		Empleado empTest = new Empleado("alismili", passAli,"678880510", "ali", "smili",fexNac, "PRODUCCIÓN",
				fexIni,listaCodigosEspTest,listaContactosTest,"O",true );


		return empTest;
	}

	/**
	 * EXPORTAR A XML
	 * @throws JAXBException 
	 */
	public static void convertirXML(Empleado emp) throws JAXBException {

		String st = "C:/Users/ali/Desktop/Practica_AADD/empleadoXML.xml";
		File file = new File(st);
		JAXBContext jaxbContext = JAXBContext.newInstance(Empleado.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(emp, file);


	}

	/**
	 * EXPORTAR A JSON
	 * @throws IOException 
	 * @throws JsonIOException 
	 */
	public static void convertirJSON(Empleado emp) throws JsonIOException, IOException {

		Gson gson = new Gson();

		String ruta = "C:/Users/ali/Desktop/Practica_AADD/empleadoJSON.json";

		// 1. Java object to JSON, and save into a file
		gson.toJson(emp, new FileWriter(ruta));
		String empleado = gson.toJson(emp);
		System.out.println(empleado);
		FileWriter fw = new FileWriter(ruta);

		fw.append(empleado);
		fw.close();
		//String jsonInString = gson.toJson(emp);

	}


	/**
	 * IMPORTAR LISTA DE CONTACTOS DESDE XML
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public static Empleado importarDesdeXML() throws JAXBException {
		String ruta = "C:/Users/ali/Desktop/Practica_AADD/empleadoXMLimport.xml";

		JAXBContext jaxbContext = JAXBContext.newInstance(Empleado.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		Empleado emp = (Empleado) jaxbUnmarshaller.unmarshal( new File(ruta) );

		return emp;
	}
	

	public static Empleado getContactsJson() throws JAXBException, IOException {

		String ruta = "C:/Users/ali/Desktop/Practica_AADD/empleadoJSONimport.json";
		String jsonFromPath = Utilities.prettyJSON(Utilities.readFile(ruta));


		Gson gson = new Gson();
		Empleado emp = gson.fromJson(jsonFromPath, Empleado.class);

		return emp;
	}
	
	/**
	 * GENERADOR DE EMPLEADOS PARA TESTEO
	 */
	public static ArrayList<Empleado> generarEmpleadosTest() {

		
		Calendar fexNac = new GregorianCalendar();
		Calendar fexIni = new GregorianCalendar();
		fexNac.set(1981, 9, 27);
		fexIni.set(2012, 8, 27);
		Set<String> listaCodigosEspTest = new HashSet<String>();
		listaCodigosEspTest.add("OP_RATATA");
		ArrayList<Contacto> listaContactosTest = new ArrayList<Contacto>();
		Contacto contactTest = new Contacto("cenec", "678888888", true);
		listaContactosTest.add(contactTest);
		char[]passAli = "smiliali".toCharArray();
		/**
		 * Creamos un empleado de prueba y se lo añadimos al controlador
		 */
		Empleado empTest = new Empleado("alismili", passAli,"678880510", "ali", "smili",fexNac, "PRODUCCIÓN",
				fexIni,listaCodigosEspTest,listaContactosTest,"O",true );
		
		Calendar fexNac2 = new GregorianCalendar();
		Calendar fexIni2 = new GregorianCalendar();
		fexNac2.set(1986, 9, 22);
		fexIni2.set(2014, 2, 15);
		Set<String> listaCodigosEspTest2 = new HashSet<String>();
		listaCodigosEspTest2.add("OP_ANACONDA");
		listaCodigosEspTest2.add("OP_HAKUNAMATATA");
		ArrayList<Contacto> listaContactosTest2 = new ArrayList<Contacto>();
		Contacto contactTest2 = new Contacto("WellTec", "670778564", true);
		listaContactosTest.add(contactTest2);
		char[]pass2 = "smiliali2".toCharArray();
		/**
		 * Creamos un empleado de prueba y se lo añadimos al controlador
		 */
		Empleado empTest2 = new Empleado("alismili2", pass2,"679990584", "Aston", "Martin",fexNac2, "CONTROL DE GESTIÓN",
				fexIni2,listaCodigosEspTest2,listaContactosTest2,"AB",true );
		
		Calendar fexNac3 = new GregorianCalendar();
		Calendar fexIni3 = new GregorianCalendar();
		fexNac3.set(1982, 10, 14);
		fexIni3.set(2014, 2, 13);
		Set<String> listaCodigosEspTest3 = new HashSet<String>();
		listaCodigosEspTest3.add("OP_ANACONDA");
		listaCodigosEspTest3.add("OP_SINIESTRO");
		ArrayList<Contacto> listaContactosTest3 = new ArrayList<Contacto>();
		Contacto contactTest3 = new Contacto("MiCasero", "670998560", false);
		listaContactosTest3.add(contactTest3);
		char[]pass3 = "smiliali3".toCharArray();
		/**
		 * Creamos un empleado de prueba y se lo añadimos al controlador
		 */
		Empleado empTest3 = new Empleado("alismili3", pass3,"675556723", "Pablo", "Jesus Marin",fexNac3, "PRODUCCIÓN",
				fexIni3,listaCodigosEspTest3,listaContactosTest3,"A",false );
		
		getEmpleados().add(empTest);
		getEmpleados().add(empTest2);
		getEmpleados().add(empTest3);

		return getEmpleados();
	}

    
	
	
	
	
	

}
