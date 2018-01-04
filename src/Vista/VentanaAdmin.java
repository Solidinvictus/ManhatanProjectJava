package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Controller.Controlador;
import models.Contacto;
import models.Empleado;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaAdmin {

	public JFrame frameAdmin;
	private JTextField txtfNombreEmp;
	private JTextField txtfApellidosEmp;
	private JTextField txtfDepartamento;
	private JTextField txtfGrupoSang;
	
	public DefaultListModel<String> listaResultados = new DefaultListModel<String>();
	ArrayList<Empleado> misEmpleados;
	private JTextField txtfOpEsp;


	/**
	 * Create the application.
	 */
	public VentanaAdmin() {
		misEmpleados = Controlador.generarEmpleadosTest(); //Aqui se cargan los empleados para el testeo + lo que se registraron
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAdmin = new JFrame();
		frameAdmin.setBounds(100, 100, 575, 455);
		frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAdmin.getContentPane().setLayout(null);
		
		JList<String> listaAdmin = new JList<>(listaResultados);
		
		listaAdmin.setBounds(249, 88, 300, 317);
         //listOps.setBounds(400,100, 180,75);  
         frameAdmin.getContentPane().add(listaAdmin);
         
         JLabel lblDescripcion = new JLabel("");
 		lblDescripcion.setBounds(257, 62, 292, 21);
 		frameAdmin.getContentPane().add(lblDescripcion);
		
		JLabel label = new JLabel("MANHATTAN PROJECT");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(195, 11, 260, 33);
		frameAdmin.getContentPane().add(label);
		
		JLabel lblNombreDelEmpleado = new JLabel("Nombre del Empleado");
		lblNombreDelEmpleado.setBounds(10, 56, 130, 21);
		frameAdmin.getContentPane().add(lblNombreDelEmpleado);
		
		txtfNombreEmp = new JTextField();
		txtfNombreEmp.setBounds(10, 88, 130, 20);
		frameAdmin.getContentPane().add(txtfNombreEmp);
		txtfNombreEmp.setColumns(10);
		
		JLabel lblApellidosdelEmpleado = new JLabel("Apellidosdel Empleado");
		lblApellidosdelEmpleado.setBounds(10, 119, 130, 21);
		frameAdmin.getContentPane().add(lblApellidosdelEmpleado);
		
		txtfApellidosEmp = new JTextField();
		txtfApellidosEmp.setColumns(10);
		txtfApellidosEmp.setBounds(10, 151, 130, 20);
		frameAdmin.getContentPane().add(txtfApellidosEmp);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(10, 196, 130, 21);
		frameAdmin.getContentPane().add(lblDepartamento);
		
		txtfDepartamento = new JTextField();
		txtfDepartamento.setColumns(10);
		txtfDepartamento.setBounds(10, 228, 130, 20);
		frameAdmin.getContentPane().add(txtfDepartamento);
		
		JLabel lblGrupoSanguneo = new JLabel("Grupo sangu\u00EDneo");
		lblGrupoSanguneo.setBounds(10, 278, 130, 21);
		frameAdmin.getContentPane().add(lblGrupoSanguneo);
		
		txtfGrupoSang = new JTextField();
		txtfGrupoSang.setColumns(10);
		txtfGrupoSang.setBounds(10, 310, 130, 20);
		frameAdmin.getContentPane().add(txtfGrupoSang);
		
		
		
		JButton btnVer = new JButton("VER");
		btnVer.addActionListener(new ActionListener() {
			/**
			 * FILTRO POR NOMBRE Y APELLIDOS
			 */
			public void actionPerformed(ActionEvent e) {
				listaAdmin.setModel(listaResultados);
				listaResultados.clear();
				boolean existe= false;
				lblDescripcion.setText("FILTRO POR NOMBRE Y APELLIDOS");
				
				for (Empleado empleado : misEmpleados) {
					if(txtfNombreEmp.getText().equals(empleado.getNombre()) && txtfApellidosEmp.getText().equals(empleado.getApellido())) {
						
						listaResultados.addElement("Telefono del empleado:");
						listaResultados.addElement(empleado.getTelefono().toString());
						listaResultados.addElement("Fecha de nacimiento del empleado:");
						listaResultados.addElement(empleado.getDiaCalendar(empleado.getFechaNac()).toString()+" "+empleado.getMesCalendar(empleado.getFechaNac()).toString()+" "
								+empleado.getAnioCalendar(empleado.getFechaNac()).toString());
						
						listaResultados.addElement("Fecha de inicio de servicio del empleado:");
						listaResultados.addElement(empleado.getDiaCalendar(empleado.getFechaInicioServ()).toString()+" "+empleado.getMesCalendar(empleado.getFechaInicioServ()).toString()+" "
								+empleado.getAnioCalendar(empleado.getFechaInicioServ()).toString());
						listaResultados.addElement("Contactos especiales del empleado:");
						for (Contacto contact : empleado.getListaContactos()) {
							if(contact.isContactoEsp()) {
								listaResultados.addElement(contact.toString());
							}
							
						}
						
						existe = true;
						
					}
				}
				if(!existe) {
					JOptionPane.showMessageDialog(null, "EL EMPLEADO INTRODUCIDO NO EXISTE", "Add Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		btnVer.setBounds(150, 118, 89, 23);
		frameAdmin.getContentPane().add(btnVer);
		
		JButton button = new JButton("VER");
		button.addActionListener(new ActionListener() {
			/**
			 * FILTRO POR DEPARTAMENTOS
			 */
			public void actionPerformed(ActionEvent e) {
				listaAdmin.setModel(listaResultados);
				lblDescripcion.setText("FILTRO POR DEPARTAMENTOS");
				listaResultados.clear();
				boolean existe = false;
				for (Empleado empleado : misEmpleados) {
					if(txtfDepartamento.getText().equals(empleado.getDepartamento())) {
						
						listaResultados.addElement("Nombre del empleado:");
						listaResultados.addElement(empleado.getNombre().toString());
						listaResultados.addElement("Apellidos del empleado:");
						listaResultados.addElement(empleado.getApellido().toString());
						existe = true;
											
					}
							
				}
				if(!existe) {
					JOptionPane.showMessageDialog(null,
					        "No hay ningún empleado en este departamento ! ");
				}
			}
		});
		button.setBounds(150, 227, 89, 23);
		frameAdmin.getContentPane().add(button);
		
		JButton button_1 = new JButton("VER");
		button_1.addActionListener(new ActionListener() {
			/**
			 * FILTRO POR GRUPO SANGUÍNEO
			 */
			public void actionPerformed(ActionEvent e) {
				listaAdmin.setModel(listaResultados);
				lblDescripcion.setText("FILTRO POR GRUPO SANGUÍNEO");
				listaResultados.clear();
				boolean existe = false;
				
				for (Empleado empleado : misEmpleados) {
					if(txtfGrupoSang.getText().equals(empleado.getGrupoSang())) {
						
						listaResultados.addElement("Nombre del empleado:");
						listaResultados.addElement(empleado.getNombre().toString());
						listaResultados.addElement("Apellidos del empleado:");
						listaResultados.addElement(empleado.getApellido().toString());
						existe = true;
																
					}			
			}
				
				if(!existe) {
					JOptionPane.showMessageDialog(null,
					        "No hay ningún empleado con el grupo sanguíneo introducido ! ");
				}
			}
		});
		button_1.setBounds(150, 309, 89, 23);
		frameAdmin.getContentPane().add(button_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 182, 237, 3);
		frameAdmin.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 278, 237, -11);
		frameAdmin.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 265, 237, 2);
		frameAdmin.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(433, 41, -422, 3);
		frameAdmin.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 55, 539, 3);
		frameAdmin.getContentPane().add(separator_4);
		
		
		
		JButton btnOpEsp = new JButton("VER");
		btnOpEsp.addActionListener(new ActionListener() {
			/**
			 * FILTRO POR OPERACIÓN ESPECIAL
			 */
			public void actionPerformed(ActionEvent e) {
				listaAdmin.setModel(listaResultados);
				listaResultados.clear();
				boolean existe = false;
				lblDescripcion.setText("FILTRO POR OPERACIONES ESPECIALES");
				for (Empleado empleado : misEmpleados) {
					if(empleado.getListaCodigosEsp().contains(txtfOpEsp.getText())) {
						
						listaResultados.addElement("Nombre del empleado:");
						listaResultados.addElement(empleado.getNombre().toString());
						listaResultados.addElement("Apellidos del empleado:");
						listaResultados.addElement(empleado.getApellido().toString());
						existe = true;
											
					}
							
				}
				if(!existe) {
					JOptionPane.showMessageDialog(null,
					        "No hay ningún empleado que actualmente este trabajando en esta operacion ! ");
				}
				
				
			}
		});
		btnOpEsp.setBounds(150, 382, 89, 23);
		frameAdmin.getContentPane().add(btnOpEsp);
		
		txtfOpEsp = new JTextField();
		txtfOpEsp.setColumns(10);
		txtfOpEsp.setBounds(10, 383, 130, 20);
		frameAdmin.getContentPane().add(txtfOpEsp);
		
		JLabel lblOperacinEspecial = new JLabel("Operaci\u00F3n especial");
		lblOperacinEspecial.setBounds(10, 351, 130, 21);
		frameAdmin.getContentPane().add(lblOperacinEspecial);
	}
}
