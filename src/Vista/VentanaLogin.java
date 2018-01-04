package Vista;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.Controlador;
import models.Agenda;
import models.Contacto;
import models.Empleado;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;

public class VentanaLogin {

	public JFrame frameLogin;
	private JTextField txtfUser;
	private JTextField txtfEmpNuevo;
	private JPasswordField txtPassEmp;
	private JPasswordField txtPassUser;
	
	/**
	 * Create the application.
	 */
	public VentanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameLogin = new JFrame();
		frameLogin.setBounds(100, 100, 496, 394);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.getContentPane().setLayout(null);
		
		/**
		 * Configuramos el controlador al caso 3 (Nuevo empleado) por defecto en caso de presionar
		 * el boton validar sin configurar
		 */
		
		Controlador.setCaso(3);
		
		Controlador.setEmpleados(new ArrayList<Empleado>());
		Controlador.setAgendas(new ArrayList<Agenda>());
		
		
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setBounds(10, 161, 233, 113);
		frameLogin.getContentPane().add(panelRegistro);
		panelRegistro.setLayout(null);
		
		
		JLabel lblTitulo = new JLabel("MANHATTAN PROJECT");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(150, 11, 260, 33);
		frameLogin.getContentPane().add(lblTitulo);
		
		JPanel panelRegistrado = new JPanel();
		panelRegistrado.setBounds(10, 111, 260, 39);
		frameLogin.getContentPane().add(panelRegistrado);
		panelRegistrado.setLayout(null);
		
		JPanel panelSelUsuario = new JPanel();
		panelSelUsuario.setBounds(10, 61, 260, 39);
		frameLogin.getContentPane().add(panelSelUsuario);
		panelSelUsuario.setLayout(null);
		
		JRadioButton radBtnEmp = new JRadioButton("EMPLEADO");
		radBtnEmp.setBounds(6, 17, 109, 23);
		panelSelUsuario.add(radBtnEmp);
		
	
		
		//BTN_GROUP
		ButtonGroup bG1 = new ButtonGroup();
		ButtonGroup bG2 = new ButtonGroup();
		
		
		
		JRadioButton radBtnAdmin = new JRadioButton("ADMINISTRADOR");
		radBtnAdmin.setBounds(123, 17, 134, 23);
		panelSelUsuario.add(radBtnAdmin);
		
		bG1.add(radBtnAdmin);
		bG1.add(radBtnEmp);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(253, 161, 217, 113);
		frameLogin.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblPassword = new JLabel("Usuario");
		lblPassword.setBounds(4, 56, 62, 14);
		panelLogin.add(lblPassword);

		JRadioButton rdbtnNuevo;
		rdbtnNuevo = new JRadioButton("NUEVO");
		rdbtnNuevo.setBounds(6, 7, 79, 23);
		panelRegistrado.add(rdbtnNuevo);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(314, 298, 117, 46);
		frameLogin.getContentPane().add(btnSalir);
			
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 42, 460, 2);
		frameLogin.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 285, 460, 9);
		frameLogin.getContentPane().add(separator_1);
		
		JButton btnReset = new JButton("RESET");

		txtfUser = new JTextField();
		txtfUser.setBounds(76, 51, 131, 25);
		panelLogin.add(txtfUser);
		txtfUser.setColumns(10);
		
		JLabel lblNuevoMiembro = new JLabel("NUEVO EMPLEADO - REGISTRO");
		lblNuevoMiembro.setBounds(10, 23, 213, 17);
		panelRegistro.add(lblNuevoMiembro);

		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setBounds(4, 87, 62, 14);
		panelLogin.add(lblPassword_1);

		JLabel lblSeleccioneUnaOpcin = new JLabel("LOGIN MIEMBRO");
		lblSeleccioneUnaOpcin.setBounds(44, 23, 142, 17);
		panelLogin.add(lblSeleccioneUnaOpcin);

		txtPassUser = new JPasswordField();
		txtPassUser.setBounds(76, 82, 131, 25);
		panelLogin.add(txtPassUser);
		
		txtfEmpNuevo = new JTextField();
		txtfEmpNuevo.setColumns(10);
		txtfEmpNuevo.setBounds(82, 51, 141, 24);
		panelRegistro.add(txtfEmpNuevo);
		
		JLabel label = new JLabel("Usuario");
		label.setBounds(10, 56, 62, 14);
		panelRegistro.add(label);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setBounds(10, 88, 62, 15);
		panelRegistro.add(label_1);
		
		txtPassEmp = new JPasswordField();
		txtPassEmp.setBounds(82, 83, 141, 24);
		panelRegistro.add(txtPassEmp);
		
		
		JLabel lblElijaUnaOpcion = new JLabel("SELECCIONE OPCIONES:");
		lblElijaUnaOpcion.setBounds(10, 42, 171, 27);
		frameLogin.getContentPane().add(lblElijaUnaOpcion);

		JRadioButton rdbtnRegistrado = new JRadioButton("REGISTRADO");
		rdbtnRegistrado.setBounds(126, 7, 134, 23);
		panelRegistrado.add(rdbtnRegistrado);
		
		JButton btnValidar = new JButton("VALIDAR");
		
		//btn_group
		bG2.add(rdbtnNuevo);
		bG2.add(rdbtnRegistrado);
		
		//logica del programa
		/**
		 * Aqui se desactivan los 3 paneles por defecto para poder tener control sobre el login
		 */
		
		Component[] comLogin = panelLogin.getComponents();
		Component[] comRegistrado = panelRegistrado.getComponents();
		Component[] comRegistro = panelRegistro.getComponents();
		/**
		 * Desactivo aqui los paneles que no me interesan
		 */
		for (int a = 0; a < comLogin.length; a++) {
		     comLogin[a].setEnabled(false);
		}
		
		for (int a = 0; a < comRegistrado.length; a++) {
		     comRegistrado[a].setEnabled(false);
		}
		
		for (int a = 0; a < comRegistro.length; a++) {
		     comRegistro[a].setEnabled(false);
		}
		
		/**
		 * *********************EVENTOS DE RADIOBUTOONS !!!!!!!!!
		 */
		
		class RadioButtonActionListener implements ActionListener {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		        JRadioButton button = (JRadioButton) event.getSource();
		 
		        if (button == radBtnAdmin) {
		        	
		        	Controlador.setCaso(1);  //CASO DEL DIRECTOR
		 
		        	for (int a = 0; a < comLogin.length; a++) {  
					     comLogin[a].setEnabled(true);
					}
		        	
		        	
		        	for (int a = 0; a < comRegistrado.length; a++) {  
					     comRegistrado[a].setEnabled(false);
					}
		        	
		        	for (int a = 0; a < comRegistro.length; a++) {  
					     comRegistro[a].setEnabled(false);
					}
		        	
		        	
		        	
		 
		        } else if (button == radBtnEmp) {
		        	
		        	
		 
		        	for (int a = 0; a < comRegistrado.length; a++) {  
					     comRegistrado[a].setEnabled(true);
		        	}
		        	
		        	for (int a = 0; a < comLogin.length; a++) {  
					     comLogin[a].setEnabled(false);
					}

		        } else if (button == rdbtnRegistrado) {
		        	
		        	Controlador.setCaso(2);  //CASO DEL EMPLEADO YA REGISTRADO

		        	for (int a = 0; a < comLogin.length; a++) {  
		        		comLogin[a].setEnabled(true);
		        	}
		        	
		        	for (int a = 0; a < comRegistrado.length; a++) {  
					     comRegistrado[a].setEnabled(true);
					}
		        	
		        	for (int a = 0; a < comRegistro.length; a++) {  
					     comRegistro[a].setEnabled(false);
					}
		        	
		        	
		        	
		        }else if (button == rdbtnNuevo) {
		        	
		        	Controlador.setCaso(3);  //CASO DE UN EMPLEADO NUEVO

		        	for (int a = 0; a < comRegistro.length; a++) {  
		        		comRegistro[a].setEnabled(true);
		        	}
		        	
		        	for (int a = 0; a < comLogin.length; a++) {  
					     comLogin[a].setEnabled(false);
					}
		        	
		        	for (int a = 0; a < comRegistrado.length; a++) {  
					     comLogin[a].setEnabled(false);
					}

		        }
		    }

		}
		RadioButtonActionListener actionListener = new RadioButtonActionListener();
		radBtnAdmin.addActionListener(actionListener);
		radBtnEmp.addActionListener(actionListener);
		rdbtnRegistrado.addActionListener(actionListener);
		rdbtnNuevo.addActionListener(actionListener);
		
	
		
				
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * BTN VALIDAR
				 */
				
				char[] passUsuario;      	//Contraseña del empleado
				String userEmpleado;		//Nombre de usuario del empleado
				
				char[] passAdmin;      	//Contraseña del empleado
				String userAdmin;		//Nombre de usuario del empleado

				if(radBtnAdmin.isSelected()) {  //Solo el director 

					userAdmin= txtfUser.getText();
					passAdmin = txtPassUser.getPassword();

					if(userAdmin.equals(Controlador.getUserAdmin()) && Arrays.equals(passAdmin, Controlador.getPassAdmin())) {
						//Se cumplen las condiciones
						//Nos lleva al Jpanel del director
						VentanaAdmin r = new VentanaAdmin();
						r.frameAdmin.setVisible(true);
						frameLogin.setVisible(false);
						
						Controlador.setCaso(1);
					}else {

						JOptionPane.showMessageDialog(null, "Datos inválidos del Login BOSS !", "Login Error", JOptionPane.ERROR_MESSAGE);					
					}
				}

				//Registro nuevo Empleado con validación

				if(rdbtnNuevo.isSelected()) {
					
					String st = txtfEmpNuevo.getText();
					char[] pass = txtPassEmp.getPassword();
					
					Controlador.correcto = false;
					if(st.isEmpty()  || st== null || pass== null ||  st.equals("")|| pass.length==0) {

						Controlador.correcto=false;
										
					}else {
						userEmpleado= txtfEmpNuevo.getText(); 
						passUsuario = txtPassEmp.getPassword();    
						
						/**
						 * Se crea un nuevo empleado y una agenda asociada a el con datos muy limitados
						 */
						Empleado empNuevo = new Empleado(userEmpleado, passUsuario );
						Agenda nuevaAgenda = new Agenda(userEmpleado, passUsuario );
						
						//Añadimos los datos al controlador
						Controlador.getEmpleados().add(empNuevo);
						Controlador.getAgendas().add(nuevaAgenda);			
						Controlador.setCaso(3);
						Controlador.captarDatosEmpNuevo(txtfEmpNuevo.toString(), txtPassEmp.getPassword());
						Controlador.correcto=true;
						
					}
										
						/**
						 * Creamos un nuevo empleado gracias al controlador
						 */
					if(Controlador.correcto) {
						Empleado empNuevo1 = new Empleado(Controlador.getUserEmpNuevo(), Controlador.getPassEmpNuevo());
						//Ahora hay que ir al panel para registrar un nuevo empleado
						
						Registro r = new Registro(empNuevo1);
						r.frameRegistro.setVisible(true);
						frameLogin.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UN USER Y UN PASSWORD ", "Register Error", JOptionPane.ERROR_MESSAGE);
					}
						
				}
				/**
				 * Con esta condicion, nos llevara al panel de un empleado ya registrado
				 */
				if(rdbtnRegistrado.isSelected()) {
					userEmpleado= txtfUser.getText();
					passUsuario = txtPassUser.getPassword();
					
					Controlador.getEmpleados().add(Controlador.generarEmpTest());
					for (Empleado em : Controlador.getEmpleados()) {

						char[] passAli = "smiliali".toCharArray();
						if(userEmpleado.equals(em.getUser()) && Arrays.equals(passUsuario, em.getPass()) ) {  //AKI ESTABA EL PROBLEMA PERO NO VA EL LOGIN

							//OK --> PUEDE PASAR A LA VENTANA DE EMPLEADO YA EXISTENTE
							//Hay que ir al Jframe de los empleados existentes
							
							Controlador.setCaso(2);
							AgendaEmpleado dtosEmp = new AgendaEmpleado(Controlador.generarEmpTest());   //Metodo que nos genera un modelo de prueba
							dtosEmp.frameEmpleado.setVisible(true);
							frameLogin.setVisible(false);
							
						}else {

							JOptionPane.showMessageDialog(null, "Datos Inválidos del Login Don Empleado", "Login Error", JOptionPane.ERROR_MESSAGE);
						}

					}

				}
				
			}
		});
		btnValidar.setBounds(20, 298, 111, 46);
		frameLogin.getContentPane().add(btnValidar);
		
		
		btnSalir.addActionListener(new ActionListener() {
			/*
			 Boton Salir
			 */
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
	
		btnReset.addActionListener(new ActionListener() {
			/**
			 * Btn reset
			 */
			public void actionPerformed(ActionEvent e) {
				txtfUser.setText(null);
				txtfEmpNuevo.setText(null);
				txtPassEmp.setText(null);
				txtPassUser.setText(null);
				
			}
		});
		btnReset.setBounds(166, 298, 111, 46);
		frameLogin.getContentPane().add(btnReset);
				
	}
	
	
}


