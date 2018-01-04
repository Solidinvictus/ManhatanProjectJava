package models;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Agenda {
	
	private String user;
	private char[] pass;
	private String telefonoPropietario;
	private GregorianCalendar fechaCreacion;
	private ArrayList<Contacto> contactos;
	
	
	
	public Agenda(String telefonoPropietario, GregorianCalendar fechaCreacion, ArrayList<Contacto> contactos) {
		super();
		this.telefonoPropietario = telefonoPropietario;
		this.fechaCreacion = fechaCreacion;
		this.contactos = contactos;
	}

	public Agenda(String user, char[] passUsuario) {
		this.user = user;
		this.pass = passUsuario;
		
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public char[] getPass() {
		return pass;
	}



	public void setPass(char[] pass) {
		this.pass = pass;
	}



	public String getTelefonoPropietario() {
		return telefonoPropietario;
	}



	public void setTelefonoPropietario(String telefonoPropietario) {
		this.telefonoPropietario = telefonoPropietario;
	}



	public GregorianCalendar getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(GregorianCalendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	public ArrayList<Contacto> getContactos() {
		return contactos;
	}



	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}
	
	
	
	


}
