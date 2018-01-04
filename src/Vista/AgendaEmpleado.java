package Vista;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import Controller.Controlador;
import models.Contacto;
import models.Empleado;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
 
import javax.xml.bind.JAXBException;
import com.google.gson.JsonIOException;


public class AgendaEmpleado {

	public JFrame frameEmpleado;
	private JTextField txtfNombre;
	private JTextField txtfApellidos;
	private JTextField txtfDiaNac;
	private JTextField txtfMesNac;
	private JTextField txtfAnioNac;

	private JTextField txtfDepartamento;
	private JLabel lblNombreEmp;
	private JLabel lblApellidosEmp;
	
	public DefaultListModel<String> listaOpEsp = new DefaultListModel<String>();
	public DefaultListModel<String> listaContactos = new DefaultListModel<String>();
	
	JList<String> listCont = new JList<>(listaContactos); 
	JList<String> listOps = new JList<String>(listaOpEsp); 
	//JList<String> listaContactos;
	public Empleado empleado  ;  //oups
	//BTN_GROUP
	ButtonGroup Bg1 = new ButtonGroup();
	ButtonGroup Bg2 = new ButtonGroup();
	private JTextField txtfGrupSang;
	private JTextField txtfPosNeg;
	private JTextField txtfOpNueva;
	private JTextField txtfAlias;
	private JTextField txtfDiaIni;
	private JTextField txtfMesIni;
	private JTextField txtfAnioIni;
	private JTextField txtfTlfno;
	
	private static final String AGENDA_DAT_FILE = "agenda.dat";
	
	/**
	 * Create the application.
	 */
	public AgendaEmpleado(Empleado emp) {
		this.empleado = emp;
		  for (Contacto item : empleado.getListaContactos()) {
	        	 listaContactos.addElement(item.toString());
				
			}
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameEmpleado = new JFrame();
		frameEmpleado.setBounds(100, 100, 485, 331);
		frameEmpleado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frameEmpleado.getContentPane().setLayout(null);
		
		 txtfGrupSang = new JTextField();
		 txtfGrupSang.setBounds(142, 310, 110, 20);
         frameEmpleado.getContentPane().add(txtfGrupSang);
         txtfGrupSang.setColumns(10);
         
         txtfPosNeg = new JTextField();
         txtfPosNeg.setBounds(142, 369, 110, 20);
         txtfPosNeg.setColumns(10);
         frameEmpleado.getContentPane().add(txtfPosNeg);
         frameEmpleado.setSize(700,472);  
         frameEmpleado.getContentPane().setLayout(null);
         
         JCheckBox chckbxEspecial = new JCheckBox("Especial");
         chckbxEspecial.setBounds(272, 438, 97, 23);
         frameEmpleado.getContentPane().add(chckbxEspecial);
         
         txtfTlfno = new JTextField();
         txtfTlfno.setColumns(10);
         txtfTlfno.setBounds(156, 439, 110, 20);
         frameEmpleado.getContentPane().add(txtfTlfno);
		
         frameEmpleado.setSize(700,600);  
         frameEmpleado.getContentPane().setLayout(null); 
   
         JLabel lblDatosEmpleado = new JLabel("DATOS EMPLEADO :");
         lblDatosEmpleado.setBounds(91, 11, 113, 27);
         frameEmpleado.getContentPane().add(lblDatosEmpleado);
         
         JLabel lblNombre = new JLabel("Nombre :");
         lblNombre.setBounds(10, 65, 66, 14);
         frameEmpleado.getContentPane().add(lblNombre);
         
         JLabel lblApellidos = new JLabel("Apellidos:");
         lblApellidos.setBounds(10, 101, 66, 14);
         frameEmpleado.getContentPane().add(lblApellidos);
         
         JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
         lblFechaNacimiento.setBounds(10, 151, 107, 14);
         frameEmpleado.getContentPane().add(lblFechaNacimiento);
         
         JLabel lblFechaInicio = new JLabel("Fecha Inicio Servicio:");
         lblFechaInicio.setBounds(10, 260, 119, 14);
         frameEmpleado.getContentPane().add(lblFechaInicio);
         
         JLabel lblDepartamento = new JLabel("Departamento:");
         lblDepartamento.setBounds(10, 216, 85, 14);
         frameEmpleado.getContentPane().add(lblDepartamento);
        
         lblNombreEmp = new JLabel(empleado.getNombre().toUpperCase());
         lblNombreEmp.setBounds(214, 17, 78, 14);
         frameEmpleado.getContentPane().add(lblNombreEmp);         
        
         lblApellidosEmp = new JLabel(empleado.getApellido().toUpperCase());
         lblApellidosEmp.setBounds(302, 17, 110, 14);
         frameEmpleado.getContentPane().add(lblApellidosEmp);
         
         JLabel lblListaDeOperaciones = new JLabel("Lista de operaciones especiales:");
         lblListaDeOperaciones.setBounds(293, 62, 190, 17);
         frameEmpleado.getContentPane().add(lblListaDeOperaciones);
          
         //JList<String> listOps = new JList<String>();
         for (String item : empleado.getListaCodigosEsp()) {
        	 listaOpEsp.addElement(item);
			
		}
         listOps.setBounds(303, 100, 180, 75);
         frameEmpleado.getContentPane().add(listOps);  
         
          //*************
       
         listCont.setBounds(302, 310, 372, 118);
         //listOps.setBounds(400,100, 180,75);  
         frameEmpleado.getContentPane().add(listCont);
         
         JLabel lblNewLabel = new JLabel("Grupo Sanguineo");
         lblNewLabel.setBounds(10, 312, 107, 17);
         frameEmpleado.getContentPane().add(lblNewLabel);
         
         JLabel lblRh = new JLabel("Rh");
         lblRh.setBounds(10, 372, 46, 14);
         frameEmpleado.getContentPane().add(lblRh);
         
         JLabel lblListaContactosEspeciales = new JLabel("Lista Contactos:");
         lblListaContactosEspeciales.setBounds(307, 289, 160, 14);
         frameEmpleado.getContentPane().add(lblListaContactosEspeciales);
         
         JButton btnEditar = new JButton("Editar");
	
		
		txtfGrupSang.setText(empleado.getGrupoSang());
		
		  
		if(empleado.getRH()) {
			txtfPosNeg.setText("Positivo");
		}else {
			txtfPosNeg.setText("Negativo");
		}
		/**
		 * Añador las operaciones especiales del empleado en el DefaultListModel
		 */
		 listaOpEsp = new DefaultListModel<>();
		 for (String op : empleado.getListaCodigosEsp()) {
			 listaOpEsp.addElement(op);
		}
                
    
      
         btnEditar.addActionListener(new ActionListener() {
        	 /**
        	  * BTN EDITAR
        	  */
         	public void actionPerformed(ActionEvent e) {
         		
         		empleado.setNombre(txtfNombre.getText());
         		empleado.setApellido(txtfApellidos.getText());
         		empleado.getDiaCalendar(empleado.getFechaNac()).equals(txtfDiaNac);  //Validacion pendiente
         		empleado.getMesCalendar(empleado.getFechaNac()).equals(txtfMesNac);	//Validacion pendiente
         		empleado.getAnioCalendar(empleado.getFechaNac()).equals(txtfAnioNac);  //Validación pendiente
         		empleado.setGrupoSang(txtfGrupSang.getText());
         		empleado.getDiaCalendar(empleado.getFechaInicioServ()).equals(txtfDiaIni);
         		empleado.getMesCalendar(empleado.getFechaInicioServ()).equals(txtfMesIni);
         		empleado.getAnioCalendar(empleado.getFechaInicioServ()).equals(txtfAnioIni);
         		
         		JOptionPane.showMessageDialog(null,
				        "Se han editado los datos con exito :) ");
         		
         	}
         });
         btnEditar.setBounds(10, 515, 89, 23);
         frameEmpleado.getContentPane().add(btnEditar);
         
         JButton btnVolver = new JButton("Volver");
         btnVolver.addActionListener(new ActionListener() {
        	 /**
        	  * BTN VOLVER
        	  */
         	public void actionPerformed(ActionEvent e) {
         		
         		VentanaLogin v = new VentanaLogin();
				v.frameLogin.setVisible(true);
				frameEmpleado.setVisible(false);
         		
         	}
         });
         btnVolver.setBounds(560, 188, 89, 23);
         frameEmpleado.getContentPane().add(btnVolver);
         
         JButton btnAgenda = new JButton("Almacenar en formato binario");
         btnAgenda.addActionListener(new ActionListener() {
        	 /**
        	  * CONVERTIR A FICHERO BINARIO
        	  */
         	public void actionPerformed(ActionEvent e) {
         		
         		String st = "C:/Users/ali/Desktop/Practica_AADD/empleado.txt";
         		try {
					Controlador.convertirBinario(st,empleado);
					JOptionPane.showMessageDialog(null,
					        "Se ha creado el archivo binario con exito :) ");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
         	}
         });
         btnAgenda.setBounds(109, 515, 206, 23);
         frameEmpleado.getContentPane().add(btnAgenda);
         
         JButton btnSalir = new JButton("Salir");
         btnSalir.addActionListener(new ActionListener() {
        	 /**
        	  * BTN SALIR
        	  */
         	public void actionPerformed(ActionEvent e) {
         		System.exit(0);
         	}
         });
         btnSalir.setBounds(560, 147, 89, 23);
         frameEmpleado.getContentPane().add(btnSalir);
         
         txtfNombre = new JTextField(empleado.getNombre());
         txtfNombre.setBounds(108, 62, 144, 20);
         frameEmpleado.getContentPane().add(txtfNombre);
         txtfNombre.setColumns(10);
         
         txtfApellidos = new JTextField(empleado.getApellido()); //APELLIDOS EN EL TEXTFIELD
         txtfApellidos.setBounds(108, 98, 144, 20);
         txtfApellidos.setColumns(10);
         frameEmpleado.getContentPane().add(txtfApellidos);
         
         txtfDiaNac = new JTextField(empleado.getDiaCalendar(empleado.getFechaNac()));  //DIA DE NACIMIENTO EN EL TEXTFIELD    
         txtfDiaNac.setBounds(138, 148, 40, 20);
         txtfDiaNac.setColumns(10);
         frameEmpleado.getContentPane().add(txtfDiaNac);
         
         txtfMesNac = new JTextField(empleado.getMesCalendar(empleado.getFechaNac()));  //MES DE NACIMIENTO GRACIAS AL METODO EMPLEADO EN LA CLASE EMPLEADO
         txtfMesNac.setBounds(188, 148, 40, 20);
         txtfMesNac.setColumns(10);
         frameEmpleado.getContentPane().add(txtfMesNac);
         
         txtfAnioNac = new JTextField(empleado.getAnioCalendar(empleado.getFechaNac())); //AÑO DE NACIMIENTO
         txtfAnioNac.setBounds(238, 148, 49, 20);
         txtfAnioNac.setColumns(10);
         frameEmpleado.getContentPane().add(txtfAnioNac);
         
         txtfDepartamento = new JTextField(empleado.getDepartamento());
         txtfDepartamento.setBounds(108, 213, 144, 20);
         txtfDepartamento.setColumns(10);
         frameEmpleado.getContentPane().add(txtfDepartamento);
         
         JSeparator separator = new JSeparator();
         separator.setBounds(0, 49, 483, -11);
         frameEmpleado.getContentPane().add(separator);
         
         JSeparator separator_1 = new JSeparator();
         separator_1.setBounds(0, 378, 483, -6);
         frameEmpleado.getContentPane().add(separator_1);
         
         txtfOpNueva = new JTextField();
         txtfOpNueva.setBounds(302, 210, 181, 20);
         frameEmpleado.getContentPane().add(txtfOpNueva);
         txtfOpNueva.setColumns(10);
         
         JButton btnAddOp = new JButton("Aniadir");
         btnAddOp.addActionListener(new ActionListener() {
        	 /**
        	  * AÑADIR OPERACIÓN NUEVA
        	  */
         	public void actionPerformed(ActionEvent e) {
         		listOps.setModel(listaOpEsp);
         		
         		if(Controlador.comprobarOperacionEspecial(txtfOpNueva.getText())) {
         			if(empleado.getListaCodigosEsp().contains(txtfOpNueva.getText())) {
         				JOptionPane.showMessageDialog(null, "LA OPERACION INTRODUCIDA YA LA INCLUISTE", "Add Error", JOptionPane.ERROR_MESSAGE);
         			}else {
         				empleado.getListaCodigosEsp().add(txtfOpNueva.getText());
         				 listaOpEsp.addElement(txtfOpNueva.getText());  //*****************NO AÑADE EN EL PANEL
         				 JOptionPane.showMessageDialog(null,
        						 "Se ha añadido la operación especial con exito :) ");
         				
         				
         			}
         		}else {
         			JOptionPane.showMessageDialog(null, "LA OPERACION INTRODUCIDA NO EXISTE", "Add Error", JOptionPane.ERROR_MESSAGE);
         		}
         		
         		
         	}
         });
         btnAddOp.setBounds(293, 239, 76, 23);
         frameEmpleado.getContentPane().add(btnAddOp);
         
         JButton btnRemoveOp = new JButton("Quitar");
         btnRemoveOp.addActionListener(new ActionListener() {
        	 /**
        	  * QUITAR OPERACION ESPECIAL
        	  */
         	public void actionPerformed(ActionEvent e) {
         		
         		if(Controlador.comprobarOperacionEspecial(txtfOpNueva.getText())) {
         			if(empleado.getListaCodigosEsp().contains(txtfOpNueva.getText())) {
         				empleado.getListaCodigosEsp().remove(txtfOpNueva.getText());
         				listaOpEsp.removeElement(txtfOpNueva.getText());
         				 JOptionPane.showMessageDialog(null,
        						 "Se ha quitado la operación especial con exito :) ");
         				
         			}else {
         				JOptionPane.showMessageDialog(null, "LA OPERACION INTRODUCIDA NO EXISTE EN SU LISTA", "Add Error", JOptionPane.ERROR_MESSAGE);
         				
         				
         			}
         		}else {
         			JOptionPane.showMessageDialog(null, "LA OPERACION INTRODUCIDA NO EXISTE", "Add Error", JOptionPane.ERROR_MESSAGE);
         		}
         		
         		
         	}
         });
         btnRemoveOp.setBounds(378, 239, 105, 23);
         frameEmpleado.getContentPane().add(btnRemoveOp);
         
         JLabel lblAadirquitarOperacinEspecial = new JLabel("A\u00F1adir/Quitar Operaci\u00F3n Especial:");
         lblAadirquitarOperacinEspecial.setBounds(296, 179, 203, 20);
         frameEmpleado.getContentPane().add(lblAadirquitarOperacinEspecial);
         
         JLabel lblAadirquitarContacto = new JLabel("A\u00F1adir/Quitar Contacto:");
         lblAadirquitarContacto.setBounds(10, 408, 148, 20);
         frameEmpleado.getContentPane().add(lblAadirquitarContacto);

         txtfAlias = new JTextField();
         txtfAlias.setColumns(10);
         txtfAlias.setBounds(44, 439, 66, 20);
         frameEmpleado.getContentPane().add(txtfAlias);

         JButton btnAddContact = new JButton("Aniadir");
         btnAddContact.addActionListener(new ActionListener() {
        	 /**
        	  * BTN AÑADIR CONTACTO NUEVO
        	  */
        	 public void actionPerformed(ActionEvent e) {

        		 Controlador.correcto= false;
        		 listCont.setModel(listaContactos);
        		 if(!txtfAlias.getText().isEmpty() && !txtfTlfno.getText().isEmpty()) {
        			 Controlador.correcto= true;
        			 //Se crea el objeto
        			 if(!chckbxEspecial.isSelected() ) {
        				 Contacto contNuevo = new Contacto(txtfAlias.getText(),txtfTlfno.getText(),false);
        				 //Se añade a la lista de contactos del empleado
        				 empleado.getListaContactos().add(contNuevo);
        				 //Se muestra en directo
        				 listaContactos.addElement(contNuevo.toString());   //***************NO SE MUESTRA
        				 
        				
        				
        				 Controlador.correcto= true;
        				 JOptionPane.showMessageDialog(null,
        						 "Se ha añadido el contacto con exito :) ");
        			 }else {

        				 if(Controlador.getNumContactosEsp(empleado)==5) {
        					 JOptionPane.showMessageDialog(null, "Tiene el máximo de número de contactos especiales [5] ", "Add Error", JOptionPane.ERROR_MESSAGE);
        					 
        				 }else {

        					 Contacto contNuevo = new Contacto(txtfAlias.getText(),txtfTlfno.getText(),true);
        					 //Se añade a la lista de contactos del empleado
        					 empleado.getListaContactos().add(contNuevo);
        					 //Se muestra en directo
        					 listaContactos.addElement(contNuevo.toString());	 //***************NO SE MUESTRA  
        					 Controlador.correcto= true;
        					 JOptionPane.showMessageDialog(null,
        							 "Se ha añadido el contacto con exito :) ");

        				 }
        			 }
        		 }else {
        			 Controlador.correcto= false;
        			 JOptionPane.showMessageDialog(null, "Datos Inválidos del Contacto!", "Add Error", JOptionPane.ERROR_MESSAGE);

        		 }
        	 }

         });
         btnAddContact.setBounds(44, 470, 79, 23);
         frameEmpleado.getContentPane().add(btnAddContact);
         
         JButton btnRemoveContact = new JButton("Quitar");
         btnRemoveContact.addActionListener(new ActionListener() {
        	 /**
        	  * QUITAR UN CONTACTO
        	  */
         	public void actionPerformed(ActionEvent e) {
         		listCont.setModel(listaContactos);
         		
         		try {
         		for (Contacto contact : empleado.getListaContactos()) {
					if(contact.getAlias().equals(txtfAlias.getText().toString())) {
						empleado.getListaContactos().remove(contact);
						JOptionPane.showMessageDialog(null,
						        "Se ha quitado el contacto con exito :) ");
						//LO QUITAMOS DE LA LISTA EN LA INTERFAZ
						listaContactos.removeElement(contact.toString());
						
					}
					
				}
         		}catch(Exception e1){
         			System.out.println(e1);;
         		}
         	}
         });
         btnRemoveContact.setBounds(142, 470, 97, 23);
         frameEmpleado.getContentPane().add(btnRemoveContact);
         
         txtfDiaIni = new JTextField(empleado.getDiaCalendar(empleado.getFechaInicioServ()));  //DIA DE INICIO DE SERVICIO
         txtfDiaIni.setColumns(10);
         txtfDiaIni.setBounds(138, 257, 40, 20);
         frameEmpleado.getContentPane().add(txtfDiaIni);
         
         txtfMesIni = new JTextField(empleado.getMesCalendar(empleado.getFechaInicioServ()));
         txtfMesIni.setColumns(10);
         txtfMesIni.setBounds(188, 257, 40, 20);
         frameEmpleado.getContentPane().add(txtfMesIni);
         
         txtfAnioIni = new JTextField(empleado.getAnioCalendar(empleado.getFechaInicioServ()));
         txtfAnioIni.setColumns(10);
         txtfAnioIni.setBounds(238, 257, 49, 20);
         frameEmpleado.getContentPane().add(txtfAnioIni);
         
         JLabel lblNewLabel_1 = new JLabel("Alias");
         lblNewLabel_1.setBounds(10, 443, 46, 14);
         frameEmpleado.getContentPane().add(lblNewLabel_1);
         
       
         
         JLabel lblTlfno = new JLabel("Tlfno");
         lblTlfno.setBounds(117, 442, 49, 14);
         frameEmpleado.getContentPane().add(lblTlfno);
         
         JButton btnActualizar = new JButton("Actualizar");
         btnActualizar.addActionListener(new ActionListener() {
        	 /**
        	  * ACTUALIZAR CONTACTO
        	  */
        	 public void actionPerformed(ActionEvent e) {

        		 listCont.setModel(listaContactos);
        		 for (Contacto contact : empleado.getListaContactos()) {
        			 if(contact.getAlias().equals(txtfAlias.getText().toString()) && !txtfTlfno.getText().isEmpty()) {
        				 listaContactos.removeElement(contact.toString());
        				 //Actualizamos el tlfno
        				 contact.setTelefono(txtfTlfno.getText());
        				 if(chckbxEspecial.isSelected()) {  //Actualizar el parametro de si es contacto especial
        					 contact.setContactoEsp(true);
        					 //Ahora lo volvemos a añadir
        					 listaContactos.addElement(contact.toString());
        					 JOptionPane.showMessageDialog(null,
            						 "Se ha actualizado el telefono del contacto con exito :) ");

        				 }else {
        					 contact.setContactoEsp(false);
        					 listaContactos.addElement(contact.toString());
        					 JOptionPane.showMessageDialog(null,
            						 "Se ha actualizado el telefono del contacto con exito :) ");
        				 }
        				 
        			 }
        			 if(contact.getTelefono().equals(txtfTlfno.getText()) && !txtfAlias.getText().isEmpty()) { //Dado un Tlfno, actualizamos el Alias
        				 listaContactos.removeElement(contact.toString());
        				 contact.setAlias(txtfAlias.getText());

        				 if(chckbxEspecial.isSelected()) {  //Actualizar el parametro de si es contacto especial
        					 contact.setContactoEsp(true);
        					 //Ahora lo volvemos a añadir
        					 listaContactos.addElement(contact.toString());
        					 JOptionPane.showMessageDialog(null,
            						 "Se ha actualizado el alias del contacto con exito :) ");

        				 }else {
        					 contact.setContactoEsp(false);
        					 listaContactos.addElement(contact.toString());
        					 JOptionPane.showMessageDialog(null,
            						 "Se ha actualizado el alias del contacto con exito :) ");
        				 }
        				
        			 }
        		 }

        	 }

         });
         btnActualizar.setBounds(249, 468, 97, 23);
         frameEmpleado.getContentPane().add(btnActualizar);
         
         JButton btnExportarAXml = new JButton("Exportar a XML");
         btnExportarAXml.addActionListener(new ActionListener() {
        	 /**
        	  * EXPORTAR A XML
        	  */
         	public void actionPerformed(ActionEvent e){
         		
         		
        		try {
					Controlador.convertirXML(empleado);
					JOptionPane.showMessageDialog(null,
   						 "Se ha exportado a xml con éxito :) ");
				} catch (JAXBException e1) {
					e1.printStackTrace();
				}
        		
         	}
         });
         btnExportarAXml.setBounds(355, 515, 165, 23);
         frameEmpleado.getContentPane().add(btnExportarAXml);
         
         JButton btnExportarAJson = new JButton("Exportar a JSON");
         btnExportarAJson.addActionListener(new ActionListener() {
        	 /**
        	  * EXPORTAR A JSON
        	  */
         	public void actionPerformed(ActionEvent e) {
         		
         		try {
					Controlador.convertirJSON(empleado);
					JOptionPane.showMessageDialog(null,
	   						 "Se ha exportado a json con éxito :) ");
				} catch (JsonIOException | IOException e1) {
					
					e1.printStackTrace();
				}
         	}
         });
         btnExportarAJson.setBounds(530, 515, 144, 23);
         frameEmpleado.getContentPane().add(btnExportarAJson); 
         
         JButton btnImportarDesdeXml = new JButton("Importar desde XML");
         btnImportarDesdeXml.addActionListener(new ActionListener() {
        	 /**
        	  * IMPORTAR DESDE XML
        	  */
         	public void actionPerformed(ActionEvent e) {
         		Empleado em = new Empleado();
         		
         		try {
					em = Controlador.importarDesdeXML();
					listCont.setModel(listaContactos);
					listaContactos.clear();
					JOptionPane.showMessageDialog(null,
	   						 "Se ha importado desde XML con éxito :) ");
					for (Contacto it : em.getListaContactos()) {
						listaContactos.addElement(it.toString());
						
					}
					
					
				} catch (JAXBException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
					//e1.printStackTrace();
				}
         	}
         });
         btnImportarDesdeXml.setBounds(356, 487, 164, 23);
         frameEmpleado.getContentPane().add(btnImportarDesdeXml);
         
         JButton btnImportarDesdeJson = new JButton("Importar desde JSON");
         btnImportarDesdeJson.addActionListener(new ActionListener() {
        	 /**
        	  * IMPORTAR DESDE JSON
        	  */
         	public void actionPerformed(ActionEvent e) {
         		Empleado em = new Empleado();
         		try {
					try {
						em = Controlador.getContactsJson();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					listCont.setModel(listaContactos);
					listaContactos.clear();
					JOptionPane.showMessageDialog(null,
	   						 "Se ha importado desde JSON con éxito :) ");
					for (Contacto it : em.getListaContactos()) {
						listaContactos.addElement(it.toString());
						
					}
					
					
				} catch (JAXBException e1) {
					// TODO Auto-generated catch block
					//System.out.println(e1);
					e1.printStackTrace();
				}
         		
         	}
         });
         btnImportarDesdeJson.setBounds(530, 487, 144, 23);
         frameEmpleado.getContentPane().add(btnImportarDesdeJson);
		
		
	}
}
