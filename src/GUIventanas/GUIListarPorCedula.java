package GUIventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import GUIcontroladores.ControladorListarPorCedula;
import value_objects.VOAlumnoRegistrado;

//import GUIcontroladores.


public class GUIListarPorCedula {

	private JFrame frame;
	private JPanel contentPanel;
	private ControladorListarPorCedula controlador;

	private void initialize(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP) {
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 600, 520);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(246, 240, 229));
		contentPanel.setLayout(null);
		frame = frameP;
		controlador = new ControladorListarPorCedula(this);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(246, 240, 229));
		panelTitulo.setBounds(0, 0, 583, 150);
		contentPanel.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel tituloReq1 = new JLabel("LISTAR ALUMNO");
		tituloReq1.setVerticalAlignment(SwingConstants.TOP);
		tituloReq1.setHorizontalAlignment(SwingConstants.LEFT);
		tituloReq1.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 32));
		tituloReq1.setBounds(30, 30, 300, 50);
		panelTitulo.add(tituloReq1);
		
		JLabel tituloReq2 = new JLabel("POR CEDULA");
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
		panelDatos.setBounds(20, 161, 502, 81);
		contentPanel.add(panelDatos);
		panelDatos.setLayout(null);
		
		JLabel labelCampo1 = new JLabel("Cedula del alumno:");
		labelCampo1.setBounds(10, 15, 190, 18);
		labelCampo1.setHorizontalAlignment(SwingConstants.LEFT);
		labelCampo1.setFont(new Font("Courier New", Font.PLAIN, 15));
		panelDatos.add(labelCampo1);
		
		JTextField cedulaInput = new JTextField();
		cedulaInput.setBounds(10, 40, 190, 25);
		cedulaInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		cedulaInput.setColumns(20);
		cedulaInput.setBorder(new LineBorder(Color.WHITE, 5));
		cedulaInput.setPreferredSize(new Dimension(35, 25));
		panelDatos.add(cedulaInput);
		
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
			}
		});
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedulaString = cedulaInput.getText();
				if(cedulaString.isBlank()) {
					GUIMensaje mensaje = new GUIMensaje(frame, "Faltan campos por ingresar.", true);
				}
				else {
					int cedulaInt;
					try {
					    cedulaInt = Integer.parseInt(cedulaString);
					    if(cedulaInt < 0) {
					    	GUIMensaje mensaje = new GUIMensaje(frame, "La cedula no puede ser menor a 0.", true);
					    	return;
					    }
					    VOAlumnoRegistrado voar = controlador.listarPorCedula(cedulaInt);
					    if(voar != null) {
					    	cardPanelP.add(new GUIListarPorCedulaAux(cardPanelP, cardLayoutP, frame, voar).getPanel(), "listarPorCedulaAux");
					    	cardLayoutP.show(cardPanelP, "listarPorCedulaAux");
					    }
					} catch (NumberFormatException ex) {
						GUIMensaje mensaje = new GUIMensaje(frame, "Formato de cedula incorrecto.", true);					   
					}
				}
				cedulaInput.setText("");
			}
		});
	}
	
	public GUIListarPorCedula(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frame) {
		initialize(cardPanelP, cardLayoutP, frame);
	}

	public JPanel getPanel() {
		return contentPanel;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}

