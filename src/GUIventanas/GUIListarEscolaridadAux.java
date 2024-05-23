package GUIventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.LineBorder;

import capa_logica.Becado;
import value_objects.VOAlumnoApellido;
import value_objects.VOInscripcionCompleta;
import value_objects.VOInscripcionParcial;

public class GUIListarEscolaridadAux {

	private JFrame frame;
	private JPanel contentPanel;
	
	private void initialize(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP, ArrayList<? extends VOInscripcionParcial> lista) {
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
		
		JLabel tituloReq1 = new JLabel("LISTADO DE");
		tituloReq1.setVerticalAlignment(SwingConstants.TOP);
		tituloReq1.setHorizontalAlignment(SwingConstants.LEFT);
		tituloReq1.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 32));
		tituloReq1.setBounds(30, 30, 300, 50);
		panelTitulo.add(tituloReq1);
		
		JLabel tituloReq2 = new JLabel("ESCOLARIDAD");
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
        
		JPanel listadoPanel = new JPanel();
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
		
		//Para agregarlo varias veces
		
		Iterator<? extends VOInscripcionParcial> iter = lista.iterator();
		while (iter.hasNext()) {
			VOInscripcionParcial voa = iter.next();
			
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
			
			JLabel labelCampo1 = new JLabel("Numero:");
			labelCampo1.setBounds(10, 5, 70, 17);
			labelCampo1.setFont(new Font("Courier New", Font.PLAIN, 14));
			panelCaja.add(labelCampo1);
			
			JTextField textFieldResultado1 = new JTextField(voa.getNumero() + "");
			textFieldResultado1.setBackground(Color.WHITE);
			textFieldResultado1.setEditable(false);
			textFieldResultado1.setBounds(75, 5, 30, 17);
			textFieldResultado1.setFont(new Font("Courier New", Font.PLAIN, 14));
			textFieldResultado1.setColumns(20);
			textFieldResultado1.setBorder(new LineBorder(Color.WHITE, 3));
			textFieldResultado1.setPreferredSize(new Dimension(35, 25));
			panelCaja.add(textFieldResultado1);
			
			JLabel labelCampo2 = new JLabel("Asignatura:");
			labelCampo2.setFont(new Font("Courier New", Font.PLAIN, 14));
			labelCampo2.setBounds(10, 45, 95, 17);
			panelCaja.add(labelCampo2);
			
			JTextField textFieldResultado2 = new JTextField(voa.getAsignatura());
			textFieldResultado2.setPreferredSize(new Dimension(35, 25));
			textFieldResultado2.setFont(new Font("Courier New", Font.PLAIN, 14));
			textFieldResultado2.setEditable(false);
			textFieldResultado2.setColumns(20);
			textFieldResultado2.setBorder(new LineBorder(Color.WHITE, 3));
			textFieldResultado2.setBackground(Color.WHITE);
			textFieldResultado2.setBounds(120, 45, 200, 17);
			textFieldResultado2.setHorizontalAlignment(SwingConstants.LEFT);
			panelCaja.add(textFieldResultado2);
			
			JLabel labelCampo3 = new JLabel("Año lectivo:");
			labelCampo3.setFont(new Font("Courier New", Font.PLAIN, 14));
			labelCampo3.setBounds(10, 25, 105, 17);
			panelCaja.add(labelCampo3);
			
			JTextField textFieldResultado3 = new JTextField(voa.getAnio() + "");
			textFieldResultado3.setPreferredSize(new Dimension(35, 25));
			textFieldResultado3.setFont(new Font("Courier New", Font.PLAIN, 14));
			textFieldResultado3.setEditable(false);
			textFieldResultado3.setColumns(20);
			textFieldResultado3.setBorder(new LineBorder(Color.WHITE, 3));
			textFieldResultado3.setBackground(Color.WHITE);
			textFieldResultado3.setBounds(120, 25, 40, 17);
			panelCaja.add(textFieldResultado3);
			
			JLabel labelCampo4 = new JLabel("Calificacion:");
			labelCampo4.setFont(new Font("Courier New", Font.PLAIN, 14));
			labelCampo4.setBounds(290, 5, 110, 17);
			panelCaja.add(labelCampo4);
			
			JTextField textFieldResultado4 = new JTextField(voa.getCalificacion() + "");
			textFieldResultado4.setPreferredSize(new Dimension(35, 25));
			textFieldResultado4.setFont(new Font("Courier New", Font.PLAIN, 14));
			textFieldResultado4.setEditable(false);
			textFieldResultado4.setColumns(20);
			textFieldResultado4.setBorder(new LineBorder(Color.WHITE, 3));
			textFieldResultado4.setBackground(Color.WHITE);
			textFieldResultado4.setBounds(410, 5, 80, 17);
			panelCaja.add(textFieldResultado4);
			if (voa instanceof VOInscripcionCompleta) {
				JLabel labelCampo5 = new JLabel("Monto base:");
				labelCampo5.setFont(new Font("Courier New", Font.PLAIN, 14));
				labelCampo5.setBounds(290, 25, 110, 17);
				panelCaja.add(labelCampo5);
			
				JTextField textFieldResultado5 = new JTextField(((VOInscripcionCompleta)voa).getMontoBase() + "");
				textFieldResultado5.setPreferredSize(new Dimension(35, 25));
				textFieldResultado5.setFont(new Font("Courier New", Font.PLAIN, 14));
				textFieldResultado5.setEditable(false);
				textFieldResultado5.setColumns(20);
				textFieldResultado5.setBorder(new LineBorder(Color.WHITE, 3));
				textFieldResultado5.setBackground(Color.WHITE);
				textFieldResultado5.setBounds(410, 25, 80, 17);
				panelCaja.add(textFieldResultado5);
			}
			
			listadoPanel.add(panelItem);
        }
	        
	}
	
	public GUIListarEscolaridadAux(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP, ArrayList<? extends VOInscripcionParcial> lista) {
		initialize(cardPanelP, cardLayoutP, frameP, lista);
	}
	
	public void actualizarListado(ArrayList<? extends VOInscripcionParcial> listaEscolaridad) {
		if(listaEscolaridad.isEmpty()) return;
		
	}
	
	public JPanel getPanel() {
		return contentPanel;
	}
}