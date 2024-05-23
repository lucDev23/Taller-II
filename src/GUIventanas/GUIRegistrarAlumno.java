package GUIventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import GUIcontroladores.ControladorRegistrarAlumno;
import GUIcontroladores.ControladorRegistrarAsignatura;

public class GUIRegistrarAlumno {

	private JFrame frame;
	private JPanel contentPanel;
	private JTextField descuentoInput;
	private JTextField razonInput;
	
	private ControladorRegistrarAlumno controlador;
	
	private void initialize(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP) {
		controlador = new ControladorRegistrarAlumno(this);
		frame = frameP;
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 600, 520);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(246, 240, 229));
		contentPanel.setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(246, 240, 229));
		panelTitulo.setBounds(0, 0, 583, 150);
		panelTitulo.setLayout(null);
		contentPanel.add(panelTitulo);
		
		JLabel tituloReq1 = new JLabel("REGISTRAR");
		tituloReq1.setVerticalAlignment(SwingConstants.TOP);
		tituloReq1.setHorizontalAlignment(SwingConstants.LEFT);
		tituloReq1.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 32));
		tituloReq1.setBounds(30, 30, 300, 50);
		panelTitulo.add(tituloReq1);
		
		JLabel tituloReq2 = new JLabel("ALUMNO");
		tituloReq2.setBounds(30, 80, 300, 50);
		tituloReq2.setVerticalAlignment(SwingConstants.TOP);
		tituloReq2.setHorizontalAlignment(SwingConstants.LEFT);
		tituloReq2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 32));
		panelTitulo.add(tituloReq2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(250, 80, 300, 1);
		panelTitulo.add(separator);
		
		//BOTON MENU
		JButton buttonMenu = new JButton("Menu");
		buttonMenu.setFocusable(false);
		buttonMenu.setForeground(new Color(0, 0, 0));
        buttonMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonMenu.setPreferredSize(new Dimension(115, 35));
        buttonMenu.setFont(new Font("Freestyle Script", Font.PLAIN, 20));
        buttonMenu.setBackground(new Color(227, 209, 176));
        buttonMenu.setBorderPainted(false);
        buttonMenu.setBounds(455, 15, 115, 23);
        panelTitulo.add(buttonMenu);
        
        buttonMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	buttonMenu.setBackground(new Color(204, 172, 113));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	buttonMenu.setBackground(new Color(227, 209, 176));
            }
        });
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(null);
		panelDatos.setBackground(new Color(246, 240, 229));
		panelDatos.setBounds(20, 170, 270, 280);
		contentPanel.add(panelDatos);
		panelDatos.setLayout(null);
		
		JLabel labelCampo1 = new JLabel("Cedula:");
		labelCampo1.setBounds(10, 10, 83, 20);
		labelCampo1.setHorizontalAlignment(SwingConstants.LEFT);
		labelCampo1.setFont(new Font("Courier New", Font.PLAIN, 15));
		panelDatos.add(labelCampo1);
		
		JTextField cedulaInput = new JTextField();
		cedulaInput.setBounds(10, 30, 253, 25);
		cedulaInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		cedulaInput.setHorizontalAlignment(SwingConstants.LEFT);
		cedulaInput.setColumns(27);
		cedulaInput.setBorder(new LineBorder(Color.WHITE, 5));
		cedulaInput.setPreferredSize(new Dimension(35, 25));
		panelDatos.add(cedulaInput);

		JLabel labelCampo2 = new JLabel("Nombre:");
		labelCampo2.setBounds(10, 60, 83, 20);
		labelCampo2.setHorizontalAlignment(SwingConstants.LEFT);
		labelCampo2.setFont(new Font("Courier New", Font.PLAIN, 15));
		panelDatos.add(labelCampo2);
		
		JTextField nombreInput = new JTextField();
		nombreInput.setBounds(10, 80, 253, 25);
		nombreInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		nombreInput.setColumns(27);
		nombreInput.setBorder(new LineBorder(Color.WHITE, 5));
		nombreInput.setPreferredSize(new Dimension(35, 25));
		panelDatos.add(nombreInput);
		
		JLabel labelCampo3 = new JLabel("Apellido:");
		labelCampo3.setBounds(10, 110, 92, 20);
		labelCampo3.setHorizontalAlignment(SwingConstants.LEFT);
		labelCampo3.setFont(new Font("Courier New", Font.PLAIN, 15));
		panelDatos.add(labelCampo3);
		
		JTextField apellidoInput = new JTextField();
		apellidoInput.setBounds(10, 130, 253, 25);
		apellidoInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		apellidoInput.setColumns(27);
		apellidoInput.setBorder(new LineBorder(Color.WHITE, 5));
		apellidoInput.setPreferredSize(new Dimension(35, 25));
		panelDatos.add(apellidoInput);
		
		JLabel labelCampo4 = new JLabel("Domicilio:");
		labelCampo4.setBounds(10, 160, 106, 20);
		panelDatos.add(labelCampo4);
		labelCampo4.setHorizontalAlignment(SwingConstants.LEFT);
		labelCampo4.setFont(new Font("Courier New", Font.PLAIN, 15));
		
		JTextField domicilioInput = new JTextField();
		domicilioInput.setBounds(10, 180, 253, 25);
		panelDatos.add(domicilioInput);
		domicilioInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		domicilioInput.setPreferredSize(new Dimension(35, 25));
		domicilioInput.setColumns(27);
		domicilioInput.setBorder(new LineBorder(Color.WHITE, 5));
		
		JLabel labelCampo5 = new JLabel("Telefono:");
		labelCampo5.setBounds(10, 210, 92, 18);
		panelDatos.add(labelCampo5);
		labelCampo5.setHorizontalAlignment(SwingConstants.LEFT);
		labelCampo5.setFont(new Font("Courier New", Font.PLAIN, 15));
		
		JTextField telefonoInput = new JTextField();
		telefonoInput.setBounds(10, 230, 253, 25);
		panelDatos.add(telefonoInput);
		telefonoInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		telefonoInput.setPreferredSize(new Dimension(35, 25));
		telefonoInput.setColumns(27);
		telefonoInput.setBorder(new LineBorder(Color.WHITE, 5));
		
		JPanel panelBecado = new JPanel();
		panelBecado.setVisible(false);
		panelBecado.setBounds(300, 220, 270, 120);
		panelBecado.setBorder(null);
		panelBecado.setBackground(new Color(246, 240, 229));
		contentPanel.add(panelBecado);
		panelBecado.setLayout(null);
		
		JLabel lblPorcentajeDeDescuento = new JLabel("Porcentaje de descuento:");
		lblPorcentajeDeDescuento.setHorizontalAlignment(SwingConstants.LEFT);
		lblPorcentajeDeDescuento.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblPorcentajeDeDescuento.setBounds(10, 10, 231, 20);
		panelBecado.add(lblPorcentajeDeDescuento);
		
		descuentoInput = new JTextField();
		descuentoInput.setPreferredSize(new Dimension(35, 25));
		descuentoInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		descuentoInput.setColumns(27);
		descuentoInput.setBorder(new LineBorder(Color.WHITE, 5));
		descuentoInput.setBounds(10, 30, 253, 25);
		panelBecado.add(descuentoInput);
		
		JLabel razonLabel = new JLabel("Razon del descuento:");
		razonLabel.setHorizontalAlignment(SwingConstants.LEFT);
		razonLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		razonLabel.setBounds(10, 60, 231, 20);
		panelBecado.add(razonLabel);
		
		razonInput = new JTextField();
		razonInput.setPreferredSize(new Dimension(35, 25));
		razonInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		razonInput.setColumns(27);
		razonInput.setBorder(new LineBorder(Color.WHITE, 5));
		razonInput.setBounds(10, 80, 253, 25);
		panelBecado.add(razonInput);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setBackground(new Color(246, 240, 229));
		panelBoton.setBounds(400, 400, 150, 50);
		contentPanel.add(panelBoton);
		panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//BOTON ACEPTAR
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setFocusable(false);
		buttonAceptar.setPreferredSize(new Dimension(115, 35));
		buttonAceptar.setFont(new Font("Freestyle Script", Font.BOLD, 16));
		buttonAceptar.setBackground(new Color(192, 192, 192));
		buttonAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAceptar.setBorderPainted(false);
		panelBoton.add(buttonAceptar);
		
		JCheckBox becadoCheck = new JCheckBox("Becado");
		becadoCheck.setBounds(385, 180, 100, 25);
		contentPanel.add(becadoCheck);
		becadoCheck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		becadoCheck.setBackground(new Color(227, 209, 176));
		becadoCheck.setFocusable(false);
		becadoCheck.setHorizontalAlignment(SwingConstants.CENTER);
		becadoCheck.setFont(new Font("Courier New", Font.PLAIN, 15));
		
		boolean[] becado = {false};
		
		becadoCheck.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					becado[0] = true;
                    panelBecado.setVisible(true);
                } else {
                	becado[0] = false;
                    panelBecado.setVisible(false);
                }
			}
		});
		
		
		buttonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	buttonAceptar.setBackground(new Color(160, 160, 160));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	buttonAceptar.setBackground(new Color(192, 192, 192));
            }
        });
		
		buttonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "menuOpciones");
				cedulaInput.setText("");
				nombreInput.setText("");
				apellidoInput.setText("");
				domicilioInput.setText("");
				telefonoInput.setText("");
				descuentoInput.setText("");
				razonInput.setText("");
				becadoCheck.setSelected(false);
			}
		});
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedulaS = cedulaInput.getText();
				String nombre = nombreInput.getText();
				String apellido = apellidoInput.getText();
				String domicilio = domicilioInput.getText();
				String telefono = telefonoInput.getText();
				
				if(cedulaS.isBlank() || nombre.isBlank() || apellido.isBlank() || domicilio.isBlank() || telefono.isBlank()) {
					GUIMensaje mensaje = new GUIMensaje(frame, "Faltan campos por ingresar.", true);
					return;
				} 
				
				int cedula;
				try {
				    cedula = Integer.parseInt(cedulaS);
				    if(cedula < 0) {
				    	GUIMensaje mensaje = new GUIMensaje(frame, "La cedula no puede ser menor a 0.", true);
						return;
				    }
				} catch (NumberFormatException e1) {
					GUIMensaje mensaje = new GUIMensaje(frame, "Formato de cedula incorrecto.", true);
					return;
				}
				
				if(!nombre.matches("^[a-zA-Z]+$")) {
					GUIMensaje mensaje = new GUIMensaje(frame, "El nombre solo puede contener letras.", true);
					return;
				}
				
				if(!apellido.matches("^[a-zA-Z]+$")) {
					GUIMensaje mensaje = new GUIMensaje(frame, "El apellido solo puede contener letras.", true);
					return;
				}
				
				if(telefono.matches(".*[^0-9].*")) {
					GUIMensaje mensaje = new GUIMensaje(frame, "Formato de telefono incorrecto.", true);
					return;
				}
				
				if(becado[0]) {
					String descuentoS = descuentoInput.getText();
					String razon = razonInput.getText();
					
					if(descuentoS.isBlank() || razon.isBlank()) {
						GUIMensaje mensaje = new GUIMensaje(frame, "Faltan campos por ingresar.", true);
						return;
					}  
					
					double descuento;
					try {
						descuento = Double.parseDouble(descuentoS);
						if(descuento <= 0) {
							GUIMensaje mensaje = new GUIMensaje(frame, "El descuento no puede ser menor o igual 0.", true);
							return;
						}
					} catch (NumberFormatException e1) {
						GUIMensaje mensaje = new GUIMensaje(frame, "Formato de descuento incorrecto.", true);
						return;
					}
					
					clearFields(cedulaInput, nombreInput, apellidoInput, domicilioInput, telefonoInput, descuentoInput, razonInput);
					controlador.registrarBecado(cedula, nombre, apellido, domicilio, telefono, descuento, razon);
					return;
				}
					
				clearFields(cedulaInput, nombreInput, apellidoInput, domicilioInput, telefonoInput, descuentoInput, razonInput);
				controlador.registrarAlumno(cedula, nombre, apellido, domicilio, telefono);
			}
		});
		
	}

	public GUIRegistrarAlumno(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP) {
		initialize(cardPanelP, cardLayoutP, frameP);
	}
	
	public void clearFields(JTextField...fields) {
		for(JTextField field : fields) {
			field.setText("");
		}
	}
	
	public JPanel getPanel() {
		return contentPanel;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
