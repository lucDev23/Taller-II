package GUIventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import value_objects.VOAlumnoRegistrado;
import value_objects.VOBecadoCedula;

//import GUIcontroladores.


public class GUIListarPorCedulaAux {

	private JFrame frame;
	private JPanel contentPanel;
	
	private void initialize(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP, VOAlumnoRegistrado voar) {
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 600, 520);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(246, 240, 229));
		contentPanel.setLayout(null);
		frame = frameP;
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(246, 240, 229));
		panelTitulo.setBounds(0, 0, 600, 129);
		contentPanel.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel tituloReq1 = new JLabel("DATOS DEL ");
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
		
		buttonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "menuOpciones");
			}
		});
		
		JPanel panelCedula = new JPanel();
		panelCedula.setBackground(new Color(246, 240, 229));
		panelCedula.setBounds(60, 130, 220, 70);
		contentPanel.add(panelCedula);
		panelCedula.setLayout(null);
		
		JLabel labelCedula = new JLabel("Cedula:");
		labelCedula.setBounds(10, 15, 70, 18);
		labelCedula.setHorizontalAlignment(SwingConstants.LEFT);
		labelCedula.setFont(new Font("Courier New", Font.PLAIN, 15));
		panelCedula.add(labelCedula);
		
		JTextField cedulaOut = new JTextField(voar.getCedula() + "");
		cedulaOut.setBackground(Color.WHITE);
		cedulaOut.setEditable(false);
		cedulaOut.setBounds(10, 40, 210, 25);
		cedulaOut.setFont(new Font("Courier New", Font.PLAIN, 15));
		cedulaOut.setColumns(20);
		cedulaOut.setBorder(new LineBorder(Color.WHITE, 5));
		cedulaOut.setPreferredSize(new Dimension(35, 25));
		panelCedula.add(cedulaOut);
		
		JPanel panelNombre = new JPanel();
		panelNombre.setLayout(null);
		panelNombre.setBackground(new Color(246, 240, 229));
		panelNombre.setBounds(60, 200, 220, 70);
		contentPanel.add(panelNombre);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombre.setFont(new Font("Courier New", Font.PLAIN, 15));
		labelNombre.setBounds(10, 15, 166, 18);
		panelNombre.add(labelNombre);
		
		JTextField nombreOut = new JTextField(voar.getNombre());
		nombreOut.setBackground(Color.WHITE);
		nombreOut.setPreferredSize(new Dimension(35, 25));
		nombreOut.setFont(new Font("Courier New", Font.PLAIN, 15));
		nombreOut.setEditable(false);
		nombreOut.setColumns(20);
		nombreOut.setBorder(new LineBorder(Color.WHITE, 5));
		nombreOut.setBounds(10, 40, 210, 25);
		panelNombre.add(nombreOut);
		
		JPanel panelApellido = new JPanel();
		panelApellido.setLayout(null);
		panelApellido.setBackground(new Color(246, 240, 229));
		panelApellido.setBounds(60, 270, 220, 70);
		contentPanel.add(panelApellido);
		
		JLabel labelApellido = new JLabel("Apellido:");
		labelApellido.setHorizontalAlignment(SwingConstants.LEFT);
		labelApellido.setFont(new Font("Courier New", Font.PLAIN, 15));
		labelApellido.setBounds(10, 15, 166, 18);
		panelApellido.add(labelApellido);
		
		JTextField apellidoOut = new JTextField(voar.getApellido());
		apellidoOut.setBackground(Color.WHITE);
		apellidoOut.setPreferredSize(new Dimension(35, 25));
		apellidoOut.setFont(new Font("Courier New", Font.PLAIN, 15));
		apellidoOut.setEditable(false);
		apellidoOut.setColumns(20);
		apellidoOut.setBorder(new LineBorder(Color.WHITE, 5));
		apellidoOut.setBounds(10, 40, 210, 25);
		panelApellido.add(apellidoOut);
		
		JPanel panelDomicilio = new JPanel();
		panelDomicilio.setLayout(null);
		panelDomicilio.setBackground(new Color(246, 240, 229));
		panelDomicilio.setBounds(60, 340, 220, 70);
		contentPanel.add(panelDomicilio);
		
		JLabel labelDomicilio = new JLabel("Domicilio:");
		labelDomicilio.setHorizontalAlignment(SwingConstants.LEFT);
		labelDomicilio.setFont(new Font("Courier New", Font.PLAIN, 15));
		labelDomicilio.setBounds(10, 15, 166, 18);
		panelDomicilio.add(labelDomicilio);
		
		JTextField domicilioOut = new JTextField(voar.getDomicilio());
		domicilioOut.setBackground(Color.WHITE);
		domicilioOut.setPreferredSize(new Dimension(35, 25));
		domicilioOut.setFont(new Font("Courier New", Font.PLAIN, 15));
		domicilioOut.setEditable(false);
		domicilioOut.setColumns(20);
		domicilioOut.setBorder(new LineBorder(Color.WHITE, 5));
		domicilioOut.setBounds(10, 40, 210, 25);
		panelDomicilio.add(domicilioOut);
		
		JPanel panelTelefono = new JPanel();
		panelTelefono.setLayout(null);
		panelTelefono.setBackground(new Color(246, 240, 229));
		panelTelefono.setBounds(60, 410, 220, 70);
		contentPanel.add(panelTelefono);
		
		JLabel labelTelefono = new JLabel("Telefono:");
		labelTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		labelTelefono.setFont(new Font("Courier New", Font.PLAIN, 15));
		labelTelefono.setBounds(10, 15, 166, 18);
		panelTelefono.add(labelTelefono);
		
		JTextField telefonoOut = new JTextField(voar.getTelefono());
		telefonoOut.setBackground(Color.WHITE);
		telefonoOut.setPreferredSize(new Dimension(35, 25));
		telefonoOut.setFont(new Font("Courier New", Font.PLAIN, 15));
		telefonoOut.setEditable(false);
		telefonoOut.setColumns(20);
		telefonoOut.setBorder(new LineBorder(Color.WHITE, 5));
		telefonoOut.setBounds(10, 40, 210, 25);
		panelTelefono.add(telefonoOut);
		
		JPanel panelAprobadas = new JPanel();
		panelAprobadas.setLayout(null);
		panelAprobadas.setBackground(new Color(246, 240, 229));
		panelAprobadas.setBounds(300, 130, 220, 70);
		contentPanel.add(panelAprobadas);
		
		JLabel labelAprobadas = new JLabel("Asignaturas aprobadas:");
		labelAprobadas.setHorizontalAlignment(SwingConstants.LEFT);
		labelAprobadas.setFont(new Font("Courier New", Font.PLAIN, 15));
		labelAprobadas.setBounds(10, 15, 210, 18);
		panelAprobadas.add(labelAprobadas);
		
		JTextField aprobadasOut = new JTextField(voar.getCantAprobadas() + "");
		aprobadasOut.setBackground(Color.WHITE);
		aprobadasOut.setPreferredSize(new Dimension(35, 25));
		aprobadasOut.setFont(new Font("Courier New", Font.PLAIN, 15));
		aprobadasOut.setEditable(false);
		aprobadasOut.setColumns(20);
		aprobadasOut.setBorder(new LineBorder(Color.WHITE, 5));
		aprobadasOut.setBounds(10, 40, 210, 25);
		panelAprobadas.add(aprobadasOut);
		
		JPanel panelTipo = new JPanel();
		panelTipo.setLayout(null);
		panelTipo.setBackground(new Color(246, 240, 229));
		panelTipo.setBounds(300, 200, 220, 70);
		contentPanel.add(panelTipo);
		
		JLabel labelTipo = new JLabel("Tipo de alumno:");
		labelTipo.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipo.setFont(new Font("Courier New", Font.PLAIN, 15));
		labelTipo.setBounds(10, 15, 185, 18);
		panelTipo.add(labelTipo);
		
		JTextField tipoOut = new JTextField(voar.getTipoAlumno());
		tipoOut.setBackground(Color.WHITE);
		tipoOut.setPreferredSize(new Dimension(35, 25));
		tipoOut.setFont(new Font("Courier New", Font.PLAIN, 15));
		tipoOut.setEditable(false);
		tipoOut.setColumns(20);
		tipoOut.setBorder(new LineBorder(Color.WHITE, 5));
		tipoOut.setBounds(10, 40, 210, 25);
		panelTipo.add(tipoOut);
		
		if(voar.getTipoAlumno().equals("becado")) {
			JPanel panelDescuento = new JPanel();
			panelDescuento.setLayout(null);
			panelDescuento.setBackground(new Color(246, 240, 229));
			panelDescuento.setBounds(300, 270, 220, 70);
			contentPanel.add(panelDescuento);
			
			JLabel labelDescuento = new JLabel("Porcentaje descuento:");
			labelDescuento.setHorizontalAlignment(SwingConstants.LEFT);
			labelDescuento.setFont(new Font("Courier New", Font.PLAIN, 15));
			labelDescuento.setBounds(10, 15, 195, 18);
			panelDescuento.add(labelDescuento);
			
			JTextField descuentoOut = new JTextField(((VOBecadoCedula)voar).getPorcentajeDesc() + "");
			descuentoOut.setBackground(Color.WHITE);
			descuentoOut.setPreferredSize(new Dimension(35, 25));
			descuentoOut.setFont(new Font("Courier New", Font.PLAIN, 15));
			descuentoOut.setEditable(false);
			descuentoOut.setColumns(20);
			descuentoOut.setBorder(new LineBorder(Color.WHITE, 5));
			descuentoOut.setBounds(10, 40, 210, 25);
			panelDescuento.add(descuentoOut);
			
			JPanel panelRazonDesc = new JPanel();
			panelRazonDesc.setLayout(null);
			panelRazonDesc.setBackground(new Color(246, 240, 229));
			panelRazonDesc.setBounds(300, 340, 220, 70);
			contentPanel.add(panelRazonDesc);
			
			JLabel labelRazonDesc = new JLabel("Razon del descuento:");
			labelRazonDesc.setHorizontalAlignment(SwingConstants.LEFT);
			labelRazonDesc.setFont(new Font("Courier New", Font.PLAIN, 15));
			labelRazonDesc.setBounds(10, 15, 190, 18);
			panelRazonDesc.add(labelRazonDesc);
			
			JTextField razonDescOut = new JTextField(((VOBecadoCedula)voar).getRazonBeca());
			razonDescOut.setBackground(Color.WHITE);
			razonDescOut.setPreferredSize(new Dimension(35, 25));
			razonDescOut.setFont(new Font("Courier New", Font.PLAIN, 15));
			razonDescOut.setEditable(false);
			razonDescOut.setColumns(20);
			razonDescOut.setBorder(new LineBorder(Color.WHITE, 5));
			razonDescOut.setBounds(10, 40, 210, 25);
			panelRazonDesc.add(razonDescOut);
			panelRazonDesc.setVisible(true);
			panelDescuento.setVisible(true);
		}
	}
	
	public GUIListarPorCedulaAux(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frame, VOAlumnoRegistrado alumno) {
		initialize(cardPanelP, cardLayoutP, frame, alumno);
	}
	
	public JPanel getPanel() {
		return contentPanel;
	}
}

