package models;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import Controller.Controlador;

@XmlRootElement
public class Empleado {
	
	private String user;
	private char[] password;
	private String telefono;
	private String nombre;
	private String apellido;
	private Calendar fechaNac = new GregorianCalendar();
	private String departamento;
	private Calendar fechaInicioServ;
	private Set<String> listaCodigosEsp;
	private ArrayList<Contacto>listaContactos;
	private String grupoSang;
	private boolean RH ;  //Si es positivo, es true----else, es false
	public Empleado(String user, char[]pass, String telefono, String nombre, String apellido, Calendar fechaNac, String departamento,
			Calendar fechaInicioServ, Set<String> listaCodigosEsp, ArrayList<Contacto> listaContactos,
			String grupoSang, boolean rH) {
		super();
		this.user = user;
		this.password = pass;
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.departamento = departamento;
		this.fechaInicioServ = fechaInicioServ;
		this.listaCodigosEsp = listaCodigosEsp;
		this.listaContactos = listaContactos;
		this.grupoSang = grupoSang;
		RH = rH;
	}
	
	public Empleado(String user, char[] passUsuario) {
		this.user = user;
		this.password = passUsuario;
	}
	
	public Empleado() {
		
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public char[] getPass() {
		return password;
	}
	public void setPass(char[] password) {
		this.password = password;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Calendar getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Calendar fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public Calendar getFechaInicioServ() {
		return fechaInicioServ;
	}
	public void setFechaInicioServ(Calendar fechaInicioServ) {
		this.fechaInicioServ = fechaInicioServ;
	}
	public Set<String> getListaCodigosEsp() {
		return listaCodigosEsp;
	}
	public void setListaCodigosEsp(Set<String> listaCodigosEsp) {
		this.listaCodigosEsp = listaCodigosEsp;
	}
	public ArrayList<Contacto> getListaContactos() {
		return listaContactos;
	}
	public void setListaContactos(ArrayList<Contacto> listaContactos) {
		this.listaContactos = listaContactos;
	}
	public String getGrupoSang() {
		return grupoSang;
	}
	public void setGrupoSang(String grupoSang) {
		this.grupoSang = grupoSang;
	}
	public boolean getRH() {
		return RH;
	}
	public void setRH(boolean rH) {
		RH = rH;
	}
	
	/**
	 * Controlar los campos del Calendar
	 * @param cal
	 * @return
	 */	
	public String getDiaCalendar(Calendar cal) {
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		String diaSt = String.valueOf(dia);
		return diaSt;
	}
	
	public String getMesCalendar(Calendar cal) {
		int mes = cal.get(Calendar.MONTH);
		String MesSt = String.valueOf(mes);
		return MesSt;
	}
	
	public String getAnioCalendar(Calendar cal) {
		int anio = cal.get(Calendar.YEAR);
		String anioSt = String.valueOf(anio);
		return anioSt;
	}
	
	@Override
	public String toString() {
		return  "Nombre : "+nombre+"\n"+"Apellidos : "+apellido+"\n"+"Fecha de Nacimiento : "+fechaNac+"\n"
				+ "Departamento :"+departamento+"\n"+"Fecha de inicio del servicio :"+fechaInicioServ+"\n"
				+"Lista de operaciónes especiales :"+Controlador.listarOpEspeciales(this)+"\n"
				+"Lista de contactos : "+Controlador.listarContactos(this)+"\n"
				+"Grupo sanguíneo : "+grupoSang+"\n"
				+"Tipo de sangre : "+RH;
	}
	
	
	// "Nombre : "+nombre+"\n"+"Apellidos : "+apellido+"\n"+"Fecha de Nacimiento : "+fechaNac+"\n"
	//+ "Departamento :"+departamento+"\n"+"Fecha de inicio del servicio :"+fechaInicioServ+"\n"
	//+"Lista de operaciónes especiales :"+Contolador.listarOpEspeciales(this)+"\n"
	//+"Lista de contactos : "+Controlador.listarContactos(this)+"\n"
	//+"Grupo sanguíneo : "+grupoSang+"\n"
	//+"Tipo de sangre : "+RH

}
