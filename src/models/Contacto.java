package models;

import javax.xml.bind.annotation.XmlType;


public class Contacto {
	
	private String alias;
	private String telefono;
	private boolean contactoEsp;
	public Contacto(String alias, String telefono, boolean contactoEsp) {
		super();
		this.alias = alias;
		this.telefono = telefono;
		this.contactoEsp = contactoEsp;
	}
	
	public Contacto() {
		
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isContactoEsp() {
		return contactoEsp;
	}
	public void setContactoEsp(boolean contactoEsp) {
		this.contactoEsp = contactoEsp;
	}
	@Override
	public String toString() {
		if( isContactoEsp()) {
		return "[alias=" + alias + ", Tlfn=" + telefono + ", contactoEsp= SI]";
		}else {
			return "[alias=" + alias + ", Tlfn=" + telefono +"contactoEsp= NO]";
		}
	}
	
	
	

}
