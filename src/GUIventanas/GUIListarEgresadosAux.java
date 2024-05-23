package GUIventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.LineBorder;

import value_objects.VOEgresadoCompleto;
import value_objects.VOEgresadoParcial;

public class GUIListarEgresadosAux {

	private JFrame frame;
	private JPanel contentPanel;
	private JTextField promAprobadasOutput;
	private JTextField promTotalOutput;

	private void initialize(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP, ArrayList<? extends VOEgresadoParcial> listado) {
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
		
		JLabel tituloReq2 = new JLabel("EGRESADOS");
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
		
		Iterator<? extends VOEgresadoParcial> iter = listado.iterator();
		while(iter.hasNext()) {
			VOEgresadoParcial voe = iter.next();
			
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
			labelCampo1.setFont(new Font("Courier New", Font.PLAIN, 14));
			panelCaja.add(labelCampo1);
			
			JTextField cedulaOutput = new JTextField(voe.getCedula() + "");
			cedulaOutput.setBackground(Color.WHITE);
			cedulaOutput.setEditable(false);
			cedulaOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
			cedulaOutput.setColumns(20);
			cedulaOutput.setBorder(new LineBorder(Color.WHITE, 3));
			cedulaOutput.setPreferredSize(new Dimension(35, 25));
			panelCaja.add(cedulaOutput);
			
			JLabel labelCampo2 = new JLabel("Nombre:");
			labelCampo2.setFont(new Font("Courier New", Font.PLAIN, 14));
			panelCaja.add(labelCampo2);
			
			JTextField nombreOutput = new JTextField(voe.getNombre());
			nombreOutput.setPreferredSize(new Dimension(35, 25));
			nombreOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
			nombreOutput.setEditable(false);
			nombreOutput.setColumns(20);
			nombreOutput.setBorder(new LineBorder(Color.WHITE, 3));
			nombreOutput.setBackground(Color.WHITE);
			panelCaja.add(nombreOutput);
			
			JLabel labelCampo3 = new JLabel("Apellido:");
			labelCampo3.setFont(new Font("Courier New", Font.PLAIN, 14));
			panelCaja.add(labelCampo3);
			
			JTextField apellidoOutput = new JTextField(voe.getApellido());
			apellidoOutput.setPreferredSize(new Dimension(35, 25));
			apellidoOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
			apellidoOutput.setEditable(false);
			apellidoOutput.setColumns(20);
			apellidoOutput.setBorder(new LineBorder(Color.WHITE, 3));
			apellidoOutput.setBackground(Color.WHITE);
			panelCaja.add(apellidoOutput);
			
			if(voe instanceof VOEgresadoCompleto) {
				labelCampo1.setBounds(10, 5, 70, 17);
				cedulaOutput.setBounds(90, 5, 150, 17);
				labelCampo2.setBounds(10, 25, 250, 17);
				nombreOutput.setBounds(90, 25, 150, 17);
				labelCampo3.setBounds(10, 45, 250, 17);
				apellidoOutput.setBounds(90, 45, 150, 17);
				
				JLabel labelCampo4 = new JLabel("Promedio total:");
				labelCampo4.setFont(new Font("Courier New", Font.PLAIN, 14));
				labelCampo4.setBounds(270, 15, 240, 17);
				panelCaja.add(labelCampo4);
				
				promTotalOutput = new JTextField(((VOEgresadoCompleto)voe).getPromedioTotal() + "");
				promTotalOutput.setPreferredSize(new Dimension(35, 25));
				promTotalOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
				promTotalOutput.setEditable(false);
				promTotalOutput.setColumns(20);
				promTotalOutput.setBorder(new LineBorder(Color.WHITE, 3));
				promTotalOutput.setBackground(Color.WHITE);
				promTotalOutput.setBounds(430, 15, 80, 17);
				panelCaja.add(promTotalOutput);
				
				JLabel labelCampo5 = new JLabel("Promedio aprobadas:");
				labelCampo5.setFont(new Font("Courier New", Font.PLAIN, 14));
				labelCampo5.setBounds(270, 35, 240, 17);
				panelCaja.add(labelCampo5);
				
				promAprobadasOutput = new JTextField(((VOEgresadoCompleto)voe).getPromedioAprobado() + "");
				promAprobadasOutput.setPreferredSize(new Dimension(35, 25));
				promAprobadasOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
				promAprobadasOutput.setEditable(false);
				promAprobadasOutput.setColumns(20);
				promAprobadasOutput.setBorder(new LineBorder(Color.WHITE, 3));
				promAprobadasOutput.setBackground(Color.WHITE);
				promAprobadasOutput.setBounds(430, 35, 80, 17);
				panelCaja.add(promAprobadasOutput);
			} else {
				labelCampo1.setBounds(141, 5, 70, 17);
				cedulaOutput.setBounds(221, 5, 150, 17);
				labelCampo2.setBounds(141, 25, 91, 17);
				nombreOutput.setBounds(221, 25, 150, 17);
				labelCampo3.setBounds(141, 45, 100, 17);
				apellidoOutput.setBounds(221, 45, 150, 17);
			}
			listadoPanel.add(panelItem);
		}
	}
	
	public GUIListarEgresadosAux(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frame, ArrayList<? extends VOEgresadoParcial> listado) {
		initialize(cardPanelP, cardLayoutP, frame, listado);
	}
	
	public JPanel getPanel() {
		return contentPanel;
	}
}
