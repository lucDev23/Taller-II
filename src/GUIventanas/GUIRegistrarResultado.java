package GUIventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import GUIcontroladores.ControladorInscripcionAsignatura;
import GUIcontroladores.ControladorRegistrarResultado;

public class GUIRegistrarResultado {
	
	private JFrame frame;
	private JPanel contentPanel;
	
	private ControladorRegistrarResultado controlador;
	
	private void initialize(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP) {
		frame = frameP;
		
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 600, 520);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(246, 240, 229));
		contentPanel.setLayout(null);
		controlador = new ControladorRegistrarResultado(this);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(246, 240, 229));
		panelTitulo.setBounds(0, 0, 583, 150);
		contentPanel.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel tituloReq1 = new JLabel("REGISTRAR");
		tituloReq1.setVerticalAlignment(SwingConstants.TOP);
		tituloReq1.setHorizontalAlignment(SwingConstants.LEFT);
		tituloReq1.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 32));
		tituloReq1.setBounds(30, 30, 300, 50);
		panelTitulo.add(tituloReq1);
		
		JLabel tituloReq2 = new JLabel("RESULTADO");
		tituloReq2.setBounds(30, 80, 300, 50);
		tituloReq2.setVerticalAlignment(SwingConstants.TOP);
		tituloReq2.setHorizontalAlignment(SwingConstants.LEFT);
		tituloReq2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 32));
		panelTitulo.add(tituloReq2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(250, 80, 300, 1);
		panelTitulo.add(separator);
		
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
		panelDatos.setBackground(new Color(246, 240, 229));
		panelDatos.setBounds(20, 170, 370, 320);
		contentPanel.add(panelDatos);
		panelDatos.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
		
		JLabel labelCampo1 = new JLabel("Cedula del alumno:");
		labelCampo1.setHorizontalAlignment(SwingConstants.LEFT);
		labelCampo1.setFont(new Font("Courier New", Font.PLAIN, 15));
		panelDatos.add(labelCampo1);
		
		JTextField cedulaInput = new JTextField();
		cedulaInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		cedulaInput.setHorizontalAlignment(SwingConstants.LEFT);
		cedulaInput.setColumns(35);
		cedulaInput.setBorder(new LineBorder(Color.WHITE, 5));
		cedulaInput.setPreferredSize(new Dimension(35, 25));
		panelDatos.add(cedulaInput);
		
		JLabel labelCampo2 = new JLabel("Calificacion:");
		labelCampo2.setHorizontalAlignment(SwingConstants.LEFT);
		labelCampo2.setFont(new Font("Courier New", Font.PLAIN, 15));
		panelDatos.add(labelCampo2);
		
		JTextField calificacionInput = new JTextField();
		calificacionInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		calificacionInput.setHorizontalAlignment(SwingConstants.LEFT);
		calificacionInput.setColumns(35);
		calificacionInput.setBorder(new LineBorder(Color.WHITE, 5));
		calificacionInput.setPreferredSize(new Dimension(35, 25));
		panelDatos.add(calificacionInput);
		
		JLabel labelCampo3 = new JLabel("Numero de inscripcion:");
		labelCampo3.setHorizontalAlignment(SwingConstants.LEFT);
		labelCampo3.setFont(new Font("Courier New", Font.PLAIN, 15));
		panelDatos.add(labelCampo3);
		
		JTextField numeroInscripInput = new JTextField();
		numeroInscripInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		numeroInscripInput.setHorizontalAlignment(SwingConstants.LEFT);
		numeroInscripInput.setColumns(35);
		numeroInscripInput.setBorder(new LineBorder(Color.WHITE, 5));
		numeroInscripInput.setPreferredSize(new Dimension(35, 25));
		panelDatos.add(numeroInscripInput);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setBackground(new Color(246, 240, 229));
		panelBoton.setBounds(400, 400, 150, 50);
		contentPanel.add(panelBoton);
		panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setFocusable(false);
        buttonAceptar.setPreferredSize(new Dimension(115, 35));
        buttonAceptar.setFont(new Font("Freestyle Script", Font.BOLD, 16));
        buttonAceptar.setBackground(new Color(192, 192, 192));
        buttonAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonAceptar.setBorderPainted(false);
        panelBoton.add(buttonAceptar);
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
				calificacionInput.setText("");
				numeroInscripInput.setText("");
			}
		});
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedulaString = cedulaInput.getText();
				String calificacionString = calificacionInput.getText();
				String numeroInscrString = numeroInscripInput.getText();
				
				if(cedulaString.isBlank() || calificacionString.isBlank() || numeroInscrString.isBlank()) {
					GUIMensaje mensaje = new GUIMensaje(frame, "Faltan campos por ingresar.", true);
					return;
				} 
					
				int cedula;
				try {
				    cedula = Integer.parseInt(cedulaString);
				    if(cedula < 0) {
				    	GUIMensaje mensaje = new GUIMensaje(frame, "La cedula no puede ser menor a 0.", true);
						return;
				    }
				} catch (NumberFormatException e1) {
					GUIMensaje mensaje = new GUIMensaje(frame, "Formato de cedula incorrecto.", true);
					return;
				}
				
				int calificacion ;
				try {
				    calificacion = Integer.parseInt(calificacionString);
				    if(calificacion < 1 || calificacion > 12) {
				    	GUIMensaje mensaje = new GUIMensaje(frame, "La calificacion debe ser un numero entre 1 y 12.", true);
						return;
				    }
				} catch (NumberFormatException e1) {
					GUIMensaje mensaje = new GUIMensaje(frame, "Formato de calificacion incorrecto.", true);
					return;
				}
				
				int numeroInscripcion;
				try {
					numeroInscripcion = Integer.parseInt(numeroInscrString);
					if(numeroInscripcion < 0) {
				    	GUIMensaje mensaje = new GUIMensaje(frame, "El numero de inscripcion no puede ser menor a 0.", true);
						return;
				    }
				} catch (NumberFormatException e1) {
					GUIMensaje mensaje = new GUIMensaje(frame, "Formato de inscripcion incorrecto.", true);
					return;
				}
			
				clearFields(cedulaInput, calificacionInput, numeroInscripInput);
				controlador.registrarResultado(cedula, calificacion, numeroInscripcion);
				}
		});
	}
	
	public GUIRegistrarResultado(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frame) {
		initialize(cardPanelP, cardLayoutP, frame);
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