package GUIventanas;

import javax.swing.*;
import javax.swing.border.LineBorder;

import GUIcontroladores.ControladorListarAsignaturas;
import value_objects.VOAsignatura;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIListarAsignaturas {
	private JFrame frame;
	private JPanel contentPanel;
	private JPanel listadoPanel;
	private ControladorListarAsignaturas controlador;
	
	private void initialize(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP) {
		
		frame = frameP;
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 600, 520);
		contentPanel.setLayout(null);
		controlador = new ControladorListarAsignaturas(this);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(246, 240, 229));
		panelTitulo.setBounds(0, 0, 600, 150);
		contentPanel.add(panelTitulo);
		panelTitulo.setLayout(null);
	
		JLabel tituloReq1 = new JLabel("LISTADO DE");
		tituloReq1.setVerticalAlignment(SwingConstants.TOP);
		tituloReq1.setHorizontalAlignment(SwingConstants.LEFT);
		tituloReq1.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 32));
		tituloReq1.setBounds(30, 30, 300, 50);
		panelTitulo.add(tituloReq1);
		
		JLabel tituloReq2 = new JLabel("ASIGNATURAS");
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
        
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setPreferredSize(new Dimension(115, 35));
        btnActualizar.setForeground(Color.BLACK);
        btnActualizar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        btnActualizar.setFocusable(false);
        btnActualizar.setBorderPainted(false);
        btnActualizar.setBackground(new Color(227, 209, 176));
        btnActualizar.setBounds(455, 116, 115, 23);
        panelTitulo.add(btnActualizar);
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	btnActualizar.setBackground(new Color(204, 172, 113));
    	    	}
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	btnActualizar.setBackground(new Color(227, 209, 176));
        		}
            });
        
        btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarListado();
				contentPanel.revalidate();
			}
		});
	
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
		scrollPane.setBounds(0, 148, 600, 372);
		scrollPane.setBackground(new Color(246, 240, 229));
		contentPanel.add(scrollPane);
	}
	
	public GUIListarAsignaturas(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP) {
		initialize(cardPanelP, cardLayoutP, frameP);
	}
	
	public void actualizarListado() {
		VOAsignatura lista[] = controlador.listarAsignaturas();
		if(lista == null) return;
		listadoPanel.removeAll();
		listadoPanel.revalidate();
		listadoPanel.repaint();
		int i = 0;
		while (i < lista.length) {
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
			
			JLabel labelCampo1 = new JLabel("Codigo:");
			labelCampo1.setBounds(15, 10, 70, 17);
			labelCampo1.setFont(new Font("Courier New", Font.PLAIN, 14));
			panelCaja.add(labelCampo1);
			
			JTextField codigoOutput = new JTextField(lista[i].getCodigo());
			codigoOutput.setBackground(Color.WHITE);
			codigoOutput.setEditable(false);
			codigoOutput.setBounds(80, 10, 90, 17);
			codigoOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
			codigoOutput.setColumns(20);
			codigoOutput.setBorder(new LineBorder(Color.WHITE, 3));
			codigoOutput.setPreferredSize(new Dimension(35, 25));
			panelCaja.add(codigoOutput);
			
			JLabel labelCampo2 = new JLabel("Nombre:");
			labelCampo2.setFont(new Font("Courier New", Font.PLAIN, 14));
			labelCampo2.setBounds(15, 40, 250, 17);
			panelCaja.add(labelCampo2);
			
			JTextField nombreOutput = new JTextField(lista[i].getNombre());
			nombreOutput.setPreferredSize(new Dimension(35, 25));
			nombreOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
			nombreOutput.setEditable(false);
			nombreOutput.setColumns(20);
			nombreOutput.setBorder(new LineBorder(Color.WHITE, 3));
			nombreOutput.setBackground(Color.WHITE);
			nombreOutput.setBounds(80, 40, 200, 17);
			panelCaja.add(nombreOutput);
			
			JLabel labelCampo4 = new JLabel("Descripcion:");
			labelCampo4.setFont(new Font("Courier New", Font.PLAIN, 14));
			labelCampo4.setBounds(180, 10, 150, 17);
			panelCaja.add(labelCampo4);
			
			JTextArea descripcionOutput = new JTextArea(lista[i].getDescripcion());
			descripcionOutput.setWrapStyleWord(true);
			descripcionOutput.setBorder(new LineBorder(Color.WHITE, 3));
			descripcionOutput.setBounds(300, 10, 200, 48);
			descripcionOutput.setEditable(false);
			descripcionOutput.setMaximumSize(new Dimension(5, 35));
			descripcionOutput.setLineWrap(true);
			descripcionOutput.setMargin(new Insets(2, 5, 2, 5));
			descripcionOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
			descripcionOutput.setRows(4);
			descripcionOutput.setColumns(45);		
			panelCaja.add(descripcionOutput);
			
			JScrollPane scrollPane = new JScrollPane(descripcionOutput);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(290, 10, 210, 48);
			panelCaja.add(scrollPane);
			
			listadoPanel.add(panelItem);
			i++;
		}
	}
	
	public JPanel getPanel() {
		return contentPanel;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}