package GUIventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import GUIcontroladores.ControladorRegistrarAsignatura;
import javax.swing.border.LineBorder;


public class GUIRegistrarAsignatura {

	private JFrame frame;
	private JPanel contentPanel;
	private JTextField codigoInput;
	private JTextField nombreInput;
	
	private ControladorRegistrarAsignatura controlador;
	
	private void initialize(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP) {
		frame = frameP;
			
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 600, 520);
		contentPanel.setBackground(new Color(246, 240, 229));
		contentPanel.setLayout(null);
		controlador = new ControladorRegistrarAsignatura(this);
		
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
		
		JLabel tituloReq2 = new JLabel("ASIGNATURA");
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
		panelDatos.setBounds(20, 170, 347, 320);
		contentPanel.add(panelDatos);
		panelDatos.setLayout(null);
		
		JLabel labelCampo1 = new JLabel("Codigo alfanumerico:");
		labelCampo1.setBounds(10, 15, 198, 18);
		labelCampo1.setHorizontalAlignment(SwingConstants.LEFT);
		labelCampo1.setFont(new Font("Courier New", Font.PLAIN, 15));
		panelDatos.add(labelCampo1);
		
		codigoInput = new JTextField();
		codigoInput.setBounds(10, 48, 327, 25);
		codigoInput.setHorizontalAlignment(SwingConstants.LEFT);
		codigoInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		codigoInput.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		codigoInput.setMargin(new Insets(2, 5, 2, 5));
		codigoInput.setColumns(35);
		codigoInput.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		codigoInput.setPreferredSize(new Dimension(35, 25));
		panelDatos.add(codigoInput);
		
		JLabel labelCampo2 = new JLabel("Nombre de la asignatura:");
		labelCampo2.setBounds(10, 88, 235, 18);
		labelCampo2.setHorizontalAlignment(SwingConstants.LEFT);
		labelCampo2.setFont(new Font("Courier New", Font.PLAIN, 15));
		panelDatos.add(labelCampo2);
		
		nombreInput = new JTextField();
		nombreInput.setBounds(10, 121, 327, 25);
		nombreInput.setMargin(new Insets(2, 5, 2, 5));
		nombreInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		nombreInput.setColumns(35);
		nombreInput.setBorder(new LineBorder(Color.WHITE, 5));
		nombreInput.setPreferredSize(new Dimension(35, 25));
		panelDatos.add(nombreInput);
		
		JLabel labelCampo3 = new JLabel("Descripcion del contenido tematico:");
		labelCampo3.setBounds(10, 161, 327, 18);
		labelCampo3.setHorizontalAlignment(SwingConstants.LEFT);
		labelCampo3.setFont(new Font("Courier New", Font.PLAIN, 15));
		panelDatos.add(labelCampo3);
		
		JTextArea descripcionInput = new JTextArea();
		descripcionInput.setWrapStyleWord(true);
		descripcionInput.setBorder(new LineBorder(Color.WHITE, 5));
		descripcionInput.setBounds(10, 194, 325, 76);
		descripcionInput.setMaximumSize(new Dimension(5, 22));
		descripcionInput.setLineWrap(true);
		descripcionInput.setMargin(new Insets(2, 5, 2, 5));
		descripcionInput.setFont(new Font("Courier New", Font.PLAIN, 15));
		descripcionInput.setRows(4);
		descripcionInput.setColumns(35);
		
		JScrollPane scrollPane = new JScrollPane(descripcionInput);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 194, 325, 76);
		panelDatos.add(scrollPane);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setBackground(new Color(246, 240, 229));
		panelBoton.setBounds(400, 400, 150, 50);
		contentPanel.add(panelBoton);
		panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setFocusable(false);
		buttonAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAceptar.setPreferredSize(new Dimension(115, 35));
		buttonAceptar.setFont(new Font("Freestyle Script", Font.BOLD, 16));
		buttonAceptar.setBackground(new Color(192, 192, 192));
		buttonAceptar.setBorderPainted(false);
		buttonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(new Color(160, 160, 160));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAceptar.setBackground(new Color(192, 192, 192));
            }
        });
		panelBoton.add(buttonAceptar);
		
		buttonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "menuOpciones");
				codigoInput.setText("");
				nombreInput.setText("");
				descripcionInput.setText("");
			}
		});
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = codigoInput.getText();
				String nombre = nombreInput.getText();
				String descripcion = descripcionInput.getText();
				
				if(codigo.isEmpty() || nombre.isEmpty() || descripcion.isEmpty()) {
					GUIMensaje mensaje = new GUIMensaje(frame, "Faltan campos por ingresar.", true);
				} else {
					if(codigo.matches(".*[^a-zA-Z0-9].*")) {
						GUIMensaje mensaje = new GUIMensaje(frame, "El codigo debe ser alfanumerico.", true);
						return;
					}
					clearFields(codigoInput, nombreInput);
					descripcionInput.setText("");
					controlador.registrarAsignatura(codigo, nombre, descripcion);
				}
			}
		});
	
	}
	
	public GUIRegistrarAsignatura(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frame) {
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