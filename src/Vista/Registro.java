package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controlador;
import models.Empleado;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Registro {

	public JFrame frameRegistro;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtAnioNac;
	private JTextField txtDepartamento;
	private JTextField txtMesNac;
	private JTextField txtDiaNac;
	private JTextField txtDiaInicio;
	private JTextField txtAnioInicio;
	
	//Panel de las operacones especiales prestablecidas en el controlador
	/* Declaro todos los JMenuItem */
	private JMenuItem anacondaItem, siniestroItem, hakunamatataItem,ratatItem;
	
	//BTN_GROUP
	ButtonGroup Bg1 = new ButtonGroup();
	ButtonGroup Bg2 = new ButtonGroup();
	private JTextField txtMesInicio;
	private JTextField txtOpEspecial;
	Empleado empNuevo;
	
	//Bg1.add(radBtnAdmin);
	//Bg2.add(radBtnEmp);



	/**
	 * Create the application.
	 */
	public Registro(Empleado empNuevo) {
		initialize();
		this.empNuevo = empNuevo;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frameRegistro = new JFrame();
		frameRegistro.setBounds(100, 100, 625, 429);
		frameRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRegistro.getContentPane().setLayout(null);
		
		JLabel lblNuevoRegistro = new JLabel("NUEVO REGISTRO");
		lblNuevoRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNuevoRegistro.setBounds(195, 11, 165, 23);
		frameRegistro.getContentPane().add(lblNuevoRegistro);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 45, 599, -1);
		frameRegistro.getContentPane().add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 54, 342, 252);
		frameRegistro.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 22, 71, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(203, 20, 129, 17);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(203, 57, 129, 17);
		panel.add(txtApellidos);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setBounds(10, 59, 90, 14);
		panel.add(lblApellidos);
		
		txtAnioNac = new JTextField();
		txtAnioNac.setColumns(10);
		txtAnioNac.setBounds(281, 96, 51, 17);
		panel.add(txtAnioNac);
		
		JLabel lblFechaNac = new JLabel("FECHA NACIMIENTO [d -m-a]");
		lblFechaNac.setBounds(10, 98, 168, 14);
		panel.add(lblFechaNac);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(203, 138, 129, 17);
		panel.add(txtDepartamento);
		
		JLabel lblDepartamento = new JLabel("DEPARTAMENTO");
		lblDepartamento.setBounds(10, 139, 105, 17);
		panel.add(lblDepartamento);
		
		txtMesNac = new JTextField();
		txtMesNac.setColumns(10);
		txtMesNac.setBounds(240, 96, 31, 17);
		panel.add(txtMesNac);
		
		txtDiaNac = new JTextField();
		txtDiaNac.setColumns(10);
		txtDiaNac.setBounds(199, 96, 31, 17);
		panel.add(txtDiaNac);
		
		JLabel lblFechaInicio = new JLabel("FECHA INICIO  [d -m-a]");
		lblFechaInicio.setBounds(10, 188, 150, 16);
		panel.add(lblFechaInicio);
		
		txtDiaInicio = new JTextField();
		txtDiaInicio.setColumns(10);
		txtDiaInicio.setBounds(199, 187, 31, 17);
		panel.add(txtDiaInicio);
		
		txtMesInicio = new JTextField();
		txtMesInicio.setColumns(10);
		txtMesInicio.setBounds(240, 187, 31, 17);
		panel.add(txtMesInicio);
		
		txtAnioInicio = new JTextField();
		txtAnioInicio.setColumns(10);
		txtAnioInicio.setBounds(281, 187, 51, 17);
		panel.add(txtAnioInicio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(362, 54, 237, 252);
		frameRegistro.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblGrupoSanguineo = new JLabel("GRUPO SANGUINEO");
		lblGrupoSanguineo.setBounds(20, 113, 107, 14);
		panel_1.add(lblGrupoSanguineo);
		
		JLabel lblR = new JLabel("Rh");
		lblR.setBounds(10, 210, 46, 14);
		panel_1.add(lblR);
		
		JRadioButton rdbtnPos = new JRadioButton("Positivo");
		rdbtnPos.setBounds(40, 189, 109, 23);
		panel_1.add(rdbtnPos);
		
		JRadioButton rdbtnNeg = new JRadioButton("Negativo");
		rdbtnNeg.setBounds(40, 222, 109, 23);
		panel_1.add(rdbtnNeg);
		
		JRadioButton rdbtnO = new JRadioButton("O");
		rdbtnO.setBounds(134, 83, 73, 23);
		panel_1.add(rdbtnO);
		
		JRadioButton rdbtnA = new JRadioButton("A");
		rdbtnA.setBounds(133, 113, 65, 19);
		panel_1.add(rdbtnA);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.setBounds(134, 135, 65, 23);
		panel_1.add(rdbtnB);
		
		JRadioButton rdbtnAB = new JRadioButton("AB");
		rdbtnAB.setBounds(134, 161, 64, 23);
		panel_1.add(rdbtnAB);
		
		
		Bg1.add(rdbtnO);
		Bg1.add(rdbtnA);
		Bg1.add(rdbtnB);
		Bg1.add(rdbtnAB);
		
		Bg2.add(rdbtnPos);
		Bg2.add(rdbtnNeg);
		
		JLabel lblOperacionesEspecialesParticipadas = new JLabel("Operaciones Especiales participadas");
		lblOperacionesEspecialesParticipadas.setBounds(10, 11, 217, 23);
		panel_1.add(lblOperacionesEspecialesParticipadas);
		
		txtOpEspecial = new JTextField();
		txtOpEspecial.setBounds(10, 45, 99, 20);
		panel_1.add(txtOpEspecial);
		txtOpEspecial.setColumns(10);
		
		JButton btnAniadirOp = new JButton("+");
		btnAniadirOp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Aniadir operaciones especiales al Set del empleado
				 */
				
				if(Controlador.comprobarOperacionEspecial(txtOpEspecial.getText())) {
				empNuevo.getListaCodigosEsp().add(txtOpEspecial.getText().toUpperCase());  //No puede haber duplicados ya que es un Set
				 JOptionPane.showMessageDialog(null,
					        "Se ha a�adido la operaci�n especial con �xito ");
				}else {
					JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UNA OPERACI�N ESPECIAL V�LIDA", "Register Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAniadirOp.setBounds(116, 45, 58, 23);
		panel_1.add(btnAniadirOp);
		
		JButton btnQuitarOp = new JButton("-");
		btnQuitarOp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Quitar operaci�n especial en el Set del empleado
				 */
				if(Controlador.comprobarOperacionEspecial(txtOpEspecial.getText())) {
				empNuevo.getListaCodigosEsp().remove(txtOpEspecial.getText().toUpperCase());
				JOptionPane.showMessageDialog(null,
				        "Se ha quitado la operaci�n especial con �xito ");
				}else {
					JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UNA OPERACI�N ESPECIAL V�LIDA", "Register Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnQuitarOp.setBounds(184, 45, 53, 23);
		panel_1.add(btnQuitarOp);
		
		JButton btnValidar = new JButton("VALIDAR");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * Se recogen todos los datos  desde el formulario validados y se almacenan**********************
				 */
				String st;
				int dia, mes, anio;
				int diaI, mesI, anioI;
				Calendar fexaNac = new GregorianCalendar();
				Calendar fexaInicio = new GregorianCalendar();
				
				Controlador.correcto = false;
				
				//Nombre
				st = txtNombre.getText();
				if(st=="" || st== null || !Controlador.esSoloLetras(st)) {
					Controlador.correcto = false;
					JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UN NOMBRE V�LIDO", "Register Error", JOptionPane.ERROR_MESSAGE);
				}else {
					Controlador.correcto = true;
					empNuevo.setNombre(txtNombre.getText().toUpperCase());
				}
				
				//Apellidos
				st = txtApellidos.getText();
				if(st=="" || st== null || !Controlador.esSoloLetras(st)) {
					Controlador.correcto = false;
					JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UN APELLIDO V�LIDO", "Register Error", JOptionPane.ERROR_MESSAGE);
				}else {
					Controlador.correcto = true;
					empNuevo.setApellido(txtNombre.getText().toUpperCase());
				}
				
				//Fecha de nacimiento
				
				try {
					dia = Integer.parseInt(txtDiaNac.getText());
					if(dia > 31 || dia < 1) {
						Controlador.correcto = false;
						JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UN DIA DE NACIMIENTO V�LIDO", "Register Error", JOptionPane.ERROR_MESSAGE);
					}
					mes = Integer.parseInt(txtMesNac.getText());
					if(mes > 12 || mes < 1 ) {
						Controlador.correcto = false;
						JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UN MES DE NACIMIENTO V�LIDO", "Register Error", JOptionPane.ERROR_MESSAGE);
					}
					anio = Integer.parseInt(txtAnioNac.getText());
					if(anio > 2018 || anio < 1940) {
						Controlador.correcto = false;
						JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UN A�IO DE NACIMIENTO V�LIDO", "Register Error", JOptionPane.ERROR_MESSAGE);
					}
					if(Controlador.correcto) {
						fexaNac.set(anio, mes-1, dia);
						empNuevo.setFechaNac(fexaNac);
					}
						
					
				} catch (NumberFormatException e1) {
					
					JOptionPane.showMessageDialog(null, "Datos no num�ricos de la fecha introducida", "ERROR FECHA", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
					System.exit(0);
				}

				//Departamento
				String stDep = txtDepartamento.getText();

				if(stDep=="" || stDep== null ) {
					Controlador.correcto = false;
					JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UN DEPARTAMENTO V�LIDO", "Register Error", JOptionPane.ERROR_MESSAGE);
				}
				if(!Controlador.comprobarDepartamento(stDep)){
					Controlador.correcto = false;
					JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UN DEPARTAMENTO EXISTENTE ", "Register Error", JOptionPane.ERROR_MESSAGE);
				}
				if(Controlador.correcto){
					empNuevo.setDepartamento(txtDepartamento.getText().toUpperCase());
				}
				
				//Fecha de inicio
				
				try {
					diaI = Integer.parseInt(txtDiaInicio.getText());
					if(diaI > 31 || diaI < 1 || txtDiaInicio.getText()== null) {
						Controlador.correcto = false;
						JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UN DIA DE INICIO V�LIDO", "Register Error", JOptionPane.ERROR_MESSAGE);
					}
					mesI = Integer.parseInt(txtMesInicio.getText());
					if(mesI > 12 || mesI < 1 || txtMesInicio.getText()== null ) {
						Controlador.correcto = false;
						JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UN MES DE INICIO V�LIDO", "Register Error", JOptionPane.ERROR_MESSAGE);
					}
					anioI = Integer.parseInt(txtAnioInicio.getText());
					if(anioI > 2018 || anioI < 1938 || txtAnioInicio.getText()== null) {
						Controlador.correcto = false;
						JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UN A�IO DE INICIO V�LIDO", "Register Error", JOptionPane.ERROR_MESSAGE);
					}
					
					if(Controlador.correcto) {
						fexaInicio.set(anioI, mesI-1, diaI);
						empNuevo.setFechaNac(fexaInicio);
					}
						
					
				} catch (NumberFormatException e1) {
					
					JOptionPane.showMessageDialog(null, "Datos no num�ricos de la fecha introducida", "ERROR FECHA", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
					System.exit(0);
				}
				
				//Operaciones especiales
				st = txtOpEspecial.getText();

				if(st=="" || st== null ) {
					Controlador.correcto = false;
					JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UNA OPERACI�N ESPECIAL V�LIDA", "Register Error", JOptionPane.ERROR_MESSAGE);
				}
				if(!Controlador.comprobarOperacionEspecial(st)){
					Controlador.correcto = false;
					JOptionPane.showMessageDialog(null, "HAY QUE INTRODUCIR UN OPERACI�N ESPECIAL EXISTENTE ", "Register Error", JOptionPane.ERROR_MESSAGE);
				}
				if(Controlador.correcto) {			
					Set<String> ops = new HashSet<String>();
					empNuevo.setListaCodigosEsp(ops);
					ops.add(txtOpEspecial.getText().toUpperCase());
				}
				
				
				//Grupo sangu�neo
				
				if(rdbtnO.isSelected()) {
					empNuevo.setGrupoSang("O");
				}
				if(rdbtnA.isSelected()) {
					empNuevo.setGrupoSang("A");
				}
				if(rdbtnB.isSelected()) {
					empNuevo.setGrupoSang("B");
				}
				if(rdbtnAB.isSelected()) {
					empNuevo.setGrupoSang("AB");
				}
				
				//Sangre positivo / negativo
				
				if(rdbtnPos.isSelected()) {
					empNuevo.setRH(true);
				}
				if(rdbtnNeg.isSelected()) {
					empNuevo.setRH(false);
				}
				
				if(Controlador.correcto) {
					
					 JOptionPane.showMessageDialog(null,
						        "Se ha registrado el empleado con �xito ");
				}
			}
		});
		btnValidar.setBounds(90, 345, 109, 23);
		frameRegistro.getContentPane().add(btnValidar);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * BTN RESET
				 */
				txtNombre.setText(null);
				txtApellidos.setText(null);
				txtDiaNac.setText(null);
				txtMesNac.setText(null);
				txtAnioNac.setText(null);
				txtDepartamento.setText(null);
				txtDiaInicio.setText(null);
				txtMesInicio.setText(null);
				txtAnioInicio.setText(null);
				txtOpEspecial.setText(null);
				
			}
		});
		btnReset.setBounds(251, 345, 109, 23);
		frameRegistro.getContentPane().add(btnReset);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * BTN SALIR
				 */
				System.exit(0);
			}
		});
		btnSalir.setBounds(418, 345, 109, 23);
		frameRegistro.getContentPane().add(btnSalir);
		
		
		
		
		
		
	}
}
