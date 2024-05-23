package GUIventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.LineBorder;

import value_objects.VOAlumnoApellido;

public class GUIListarPorApellidoAux {

	private JFrame frame;
	private JPanel contentPanel;
	private JPanel listadoPanel;

	private void initialize(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP, ArrayList<VOAlumnoApellido> lista) {
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 600, 520);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(246, 240, 229));
		contentPanel.setLayout(null);
		frame = frameP;
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(246, 240, 229));
		panelTitulo.setBounds(0, 0, 583, 148);
		contentPanel.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel tituloReq1 = new JLabel("ALUMNOS POR");
		tituloReq1.setVerticalAlignment(SwingConstants.TOP);
		tituloReq1.setHorizontalAlignment(SwingConstants.LEFT);
		tituloReq1.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 32));
		tituloReq1.setBounds(30, 30, 300, 50);
		panelTitulo.add(tituloReq1);
		
		JLabel tituloReq2 = new JLabel("APELLIDO");
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
        
		listadoPanel = new JPanel();
		listadoPanel.setLayout(new BoxLayout(listadoPanel, BoxLayout.Y_AXIS));
		listadoPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		listadoPanel.setBackground(new Color(246, 240, 229));
		
		JScrollPane scrollPane = new JScrollPane(listadoPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setFocusable(false);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(0, 148, 595, 372);
		scrollPane.setBackground(new Color(246, 240, 229));
		contentPanel.add(scrollPane);
		
		Iterator<VOAlumnoApellido> iter = lista.iterator();
		while (iter.hasNext()) {
			VOAlumnoApellido voa = iter.next();
			
			JPanel panelItem = new JPanel();
			panelItem.setMaximumSize(new Dimension(20000, 80));
			panelItem.setPreferredSize(new Dimension(200, 80));
			panelItem.setAlignmentX(Component.LEFT_ALIGNMENT);
			panelItem.setBackground(new Color(246, 240, 229));
			panelItem.setLayout(null);
			
			JPanel panelCaja = new JPanel();
			panelCaja.setBackground(new Color(227, 209, 176));
			panelCaja.setBounds(40, 5, 520, 70);
			panelItem.add(panelCaja);
			panelCaja.setLayout(null);
			
			JLabel labelCampo1 = new JLabel("Cedula:");
			labelCampo1.setBounds(10, 15, 240, 17);
			labelCampo1.setFont(new Font("Courier New", Font.PLAIN, 14));
			panelCaja.add(labelCampo1);
			
			JTextField cedulaOutput = new JTextField(voa.getCedula() + "");
			cedulaOutput.setBackground(Color.WHITE);
			cedulaOutput.setEditable(false);
			cedulaOutput.setBounds(90, 15, 150, 17);
			cedulaOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
			cedulaOutput.setColumns(20);
			cedulaOutput.setBorder(new LineBorder(Color.WHITE, 3));
			cedulaOutput.setPreferredSize(new Dimension(35, 25));
			panelCaja.add(cedulaOutput);
			
			JLabel labelCampo2 = new JLabel("Nombre:");
			labelCampo2.setFont(new Font("Courier New", Font.PLAIN, 14));
			labelCampo2.setBounds(10, 35, 240, 17);
			panelCaja.add(labelCampo2);
			
			JTextField nombreOutput = new JTextField(voa.getNombre());
			nombreOutput.setPreferredSize(new Dimension(35, 25));
			nombreOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
			nombreOutput.setEditable(false);
			nombreOutput.setColumns(20);
			nombreOutput.setBorder(new LineBorder(Color.WHITE, 3));
			nombreOutput.setBackground(Color.WHITE);
			nombreOutput.setBounds(90, 35, 150, 17);
			panelCaja.add(nombreOutput);
			
			JLabel labelCampo4 = new JLabel("Apellido:");
			labelCampo4.setFont(new Font("Courier New", Font.PLAIN, 14));
			labelCampo4.setBounds(270, 15, 240, 17);
			panelCaja.add(labelCampo4);
			
			JTextField apellidoOutput = new JTextField(voa.getApellido());
			apellidoOutput.setPreferredSize(new Dimension(35, 25));
			apellidoOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
			apellidoOutput.setEditable(false);
			apellidoOutput.setColumns(20);
			apellidoOutput.setBorder(new LineBorder(Color.WHITE, 3));
			apellidoOutput.setBackground(Color.WHITE);
			apellidoOutput.setBounds(360, 15, 150, 17);
			panelCaja.add(apellidoOutput);
			
			JLabel labelCampo5 = new JLabel("Tipo:");
			labelCampo5.setFont(new Font("Courier New", Font.PLAIN, 14));
			labelCampo5.setBounds(270, 35, 240, 17);
			panelCaja.add(labelCampo5);
			
			JTextField tipoOutput = new JTextField(voa.getTipoAlumno());
			tipoOutput.setPreferredSize(new Dimension(35, 25));
			tipoOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
			tipoOutput.setEditable(false);
			tipoOutput.setColumns(20);
			tipoOutput.setBorder(new LineBorder(Color.WHITE, 3));
			tipoOutput.setBackground(Color.WHITE);
			tipoOutput.setBounds(360, 35, 150, 17);
			panelCaja.add(tipoOutput);
			
			listadoPanel.add(panelItem);
		}
		
	}
	
	public GUIListarPorApellidoAux(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP, ArrayList<VOAlumnoApellido> lista) {
		initialize(cardPanelP, cardLayoutP, frameP, lista);
	}
	
	public void actualizarListado(ArrayList<VOAlumnoApellido> listaApellidos) {
		if(listaApellidos.isEmpty()) return;
		
	}
	
	public JPanel getPanel() {
		return contentPanel;
	}
}
