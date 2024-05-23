package GUIventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import GUIcontroladores.ControladorListarEgresados;
import value_objects.VOEgresadoParcial;

public class GUIListarEgresados {

	private JFrame frame;
	private JPanel contentPanel;
	private ControladorListarEgresados controlador;

	private void initialize(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP) {
		contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 600, 520);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(246, 240, 229));
		contentPanel.setLayout(null);
		frame = frameP;
		controlador = new ControladorListarEgresados(this);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(246, 240, 229));
		panelTitulo.setBounds(0, 0, 583, 150);
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
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(new Color(246, 240, 229));
		panelDatos.setBounds(20, 170, 350, 280);
		contentPanel.add(panelDatos);
		panelDatos.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo de consulta:");
		lblNewLabel.setBounds(30, 50, 168, 18);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		panelDatos.add(lblNewLabel);
		
		ButtonGroup buttonGroupOpciones = new ButtonGroup();
		JRadioButton rdbtnCompleto = new JRadioButton("Completo");
        rdbtnCompleto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rdbtnCompleto.setBounds(130, 90, 110, 27);
        rdbtnCompleto.setFont(new Font("Courier New", Font.PLAIN, 15));
        rdbtnCompleto.setFocusable(false);
        rdbtnCompleto.setBackground(new Color(246, 240, 229));
        buttonGroupOpciones.add(rdbtnCompleto);
        panelDatos.add(rdbtnCompleto);
        JRadioButton rdbtnParcial = new JRadioButton("Parcial");
        rdbtnParcial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rdbtnParcial.setBounds(30, 90, 98, 27);
        rdbtnParcial.setFont(new Font("Courier New", Font.PLAIN, 15));
        rdbtnParcial.setFocusable(false);
        rdbtnParcial.setBackground(new Color(246, 240, 229));
        buttonGroupOpciones.add(rdbtnParcial);
        panelDatos.add(rdbtnParcial);
		
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

		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion = null;
				
				if(rdbtnCompleto.isSelected()) {
					seleccion = "completo";
				}
				else if(rdbtnParcial.isSelected()) {
					seleccion = "parcial";
				}
				
				if(seleccion == null) {
					GUIMensaje mensaje = new GUIMensaje(frame, "Ingrese un modo de listado.", true);
				}
				else {
					ArrayList<? extends VOEgresadoParcial> listaEgresados = controlador.listarEgresados(seleccion);
					if(listaEgresados != null) {
						cardPanelP.add(new GUIListarEgresadosAux(cardPanelP, cardLayoutP, frame, listaEgresados).getPanel(), "listarEgresadosAux");
						cardLayoutP.show(cardPanelP, "listarEgresadosAux");
					}
				}
			}
		});
	}
	
	public GUIListarEgresados(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frame) {
		initialize(cardPanelP, cardLayoutP, frame);
	}
	
	public JPanel getPanel() {
		return contentPanel;
	}

	public JFrame getFrame() {
		return frame;
	}
}
