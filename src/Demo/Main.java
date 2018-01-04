package Demo;

import java.awt.EventQueue;



import Controller.Controlador;
import Vista.VentanaLogin;
import models.Empleado;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					VentanaLogin window = new VentanaLogin();
					window.frameLogin.setVisible(true);
					
					for (Empleado emp : Controlador.getEmpleados()) {
						System.out.println(emp);
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


	}

}
