package GUIventanas;


import javax.swing.SwingConstants;

import GUIcontroladores.ControladorRecuperar;
import GUIcontroladores.ControladorRespaldar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.Insets;


public class GUIMenuOpciones {
	
	private JPanel contentPanel;
	private JFrame frame;
	private ControladorRespaldar controladorRespaldar;
	private ControladorRecuperar controladorRecuperar;
	
	private void initialize(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP) {

		frame = frameP;
		controladorRespaldar = new ControladorRespaldar(this);
		controladorRecuperar = new ControladorRecuperar(this);
		
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBounds(0, 0, 600, 520);
		contentPanel.setOpaque(true);
		contentPanel.setBackground(new Color(246, 240, 229));
		
		JLabel titleLabel = new JLabel("MENU");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Freestyle Script", Font.BOLD, 60));
		titleLabel.setBounds(150, 20, 300, 70);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setOpaque(true);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(200, 90, 200, 2);
		contentPanel.add(separator);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setOpaque(false);
		buttonsPanel.setBounds(0, 123, 600, 250);
		contentPanel.add(buttonsPanel);
		buttonsPanel.setLayout(null);
		
		JButton btnRegistrarAsignatura = new JButton("REGISTRAR ASIGNATURA");
		btnRegistrarAsignatura.setForeground(Color.WHITE);
		btnRegistrarAsignatura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarAsignatura.setFocusable(false);
		btnRegistrarAsignatura.setBorder(null);
		btnRegistrarAsignatura.setBackground(new Color(222, 184, 135));
		btnRegistrarAsignatura.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnRegistrarAsignatura.setBounds(10, 0, 285, 45);
		buttonsPanel.add(btnRegistrarAsignatura);
		
		btnRegistrarAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	btnRegistrarAsignatura.setBackground(new Color(255, 160, 122));
		    	}
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	btnRegistrarAsignatura.setBackground(new Color(222, 184, 135));
	    		}
	        });
		
		btnRegistrarAsignatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "registrarAsignatura");
			}
		});
		
		JButton btnListarPorCedula = new JButton("LISTAR POR CEDULA");
		btnListarPorCedula.setForeground(Color.WHITE);
		btnListarPorCedula.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarPorCedula.setFocusable(false);
		btnListarPorCedula.setBorder(null);
		btnListarPorCedula.setBackground(new Color(222, 184, 135));
		btnListarPorCedula.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnListarPorCedula.setBounds(10, 200, 285, 45);
		buttonsPanel.add(btnListarPorCedula);
		
		btnListarPorCedula.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnListarPorCedula.setBackground(new Color(255, 160, 122));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnListarPorCedula.setBackground(new Color(222, 184, 135));
		    }
		});
		
		btnListarPorCedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "listarPorCedula");
			}
		});
		
		JButton btnInscripcionAsignatura = new JButton("INSCRIPCION ASIGNATURA");
		btnInscripcionAsignatura.setForeground(Color.WHITE);
		btnInscripcionAsignatura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInscripcionAsignatura.setFocusable(false);
		btnInscripcionAsignatura.setBorder(null);
		btnInscripcionAsignatura.setBackground(new Color(222, 184, 135));
		btnInscripcionAsignatura.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnInscripcionAsignatura.setBounds(305, 0, 285, 45);
		buttonsPanel.add(btnInscripcionAsignatura);
		
		btnInscripcionAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnInscripcionAsignatura.setBackground(new Color(255, 160, 122));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnInscripcionAsignatura.setBackground(new Color(222, 184, 135));
		    }
		});
		
		btnInscripcionAsignatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "inscripcionAsignatura");
			}
		});
		
		JButton btnResultadoAsignatura = new JButton("RESULTADO DE ASIGNATURA");
		btnResultadoAsignatura.setForeground(Color.WHITE);
		btnResultadoAsignatura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResultadoAsignatura.setFocusable(false);
		btnResultadoAsignatura.setBorder(null);
		btnResultadoAsignatura.setBackground(new Color(222, 184, 135));
		btnResultadoAsignatura.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnResultadoAsignatura.setBounds(305, 50, 285, 45);
		buttonsPanel.add(btnResultadoAsignatura);
		
		btnResultadoAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnResultadoAsignatura.setBackground(new Color(255, 160, 122));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnResultadoAsignatura.setBackground(new Color(222, 184, 135));
		    }
		});
		
		btnResultadoAsignatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "resultadoAsignatura");
			}
		});
		
		JButton btnListarAsignaturas = new JButton("LISTAR ASIGNATURAS");
		btnListarAsignaturas.setForeground(Color.WHITE);
		btnListarAsignaturas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarAsignaturas.setFocusable(false);
		btnListarAsignaturas.setBorder(null);
		btnListarAsignaturas.setBackground(new Color(222, 184, 135));
		btnListarAsignaturas.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnListarAsignaturas.setBounds(10, 50, 285, 45);
		buttonsPanel.add(btnListarAsignaturas);
		
		btnListarAsignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnListarAsignaturas.setBackground(new Color(255, 160, 122));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnListarAsignaturas.setBackground(new Color(222, 184, 135));
		    }
		});
		
		btnListarAsignaturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "listarAsignaturas");
			}
		});
		
		JButton btnInscribirAlumno = new JButton("REGISTRAR ALUMNO");
		btnInscribirAlumno.setForeground(Color.WHITE);
		btnInscribirAlumno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInscribirAlumno.setFocusable(false);
		btnInscribirAlumno.setBorder(null);
		btnInscribirAlumno.setBackground(new Color(222, 184, 135));
		btnInscribirAlumno.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnInscribirAlumno.setBounds(10, 100, 285, 45);
		buttonsPanel.add(btnInscribirAlumno);
		
		btnInscribirAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnInscribirAlumno.setBackground(new Color(255, 160, 122));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnInscribirAlumno.setBackground(new Color(222, 184, 135));
		    }
		});
		
		btnInscribirAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "registrarAlumno");
			}
		});
		
		JButton btnMontoRecaudado = new JButton("MONTO RECAUDADO");
		btnMontoRecaudado.setForeground(Color.WHITE);
		btnMontoRecaudado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMontoRecaudado.setFocusable(false);
		btnMontoRecaudado.setBorder(null);
		btnMontoRecaudado.setBackground(new Color(222, 184, 135));
		btnMontoRecaudado.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnMontoRecaudado.setBounds(305, 100, 285, 45);
		buttonsPanel.add(btnMontoRecaudado);
		
		btnMontoRecaudado.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnMontoRecaudado.setBackground(new Color(255, 160, 122));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnMontoRecaudado.setBackground(new Color(222, 184, 135));
		    }
		});
		
		btnMontoRecaudado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "montoRecaudado");
			}
		});
		
		JButton btnConsultarEscolaridad = new JButton("CONSULTA DE ESCOLARIDAD");
		btnConsultarEscolaridad.setForeground(Color.WHITE);
		btnConsultarEscolaridad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultarEscolaridad.setFocusable(false);
		btnConsultarEscolaridad.setBorder(null);
		btnConsultarEscolaridad.setBackground(new Color(222, 184, 135));
		btnConsultarEscolaridad.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnConsultarEscolaridad.setBounds(305, 150, 285, 45);
		buttonsPanel.add(btnConsultarEscolaridad);
		
		btnConsultarEscolaridad.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnConsultarEscolaridad.setBackground(new Color(255, 160, 122));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnConsultarEscolaridad.setBackground(new Color(222, 184, 135));
		    }
		});
		
		btnConsultarEscolaridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "listarEscolaridad");
			}
		});
		
		JButton btnListarPorApellido = new JButton("LISTAR ALUMNO POR APELLIDO");
		btnListarPorApellido.setForeground(Color.WHITE);
		btnListarPorApellido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarPorApellido.setFocusable(false);
		btnListarPorApellido.setBorder(null);
		btnListarPorApellido.setBackground(new Color(222, 184, 135));
		btnListarPorApellido.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnListarPorApellido.setBounds(10, 150, 285, 45);
		buttonsPanel.add(btnListarPorApellido);
		
		btnListarPorApellido.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnListarPorApellido.setBackground(new Color(255, 160, 122));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnListarPorApellido.setBackground(new Color(222, 184, 135));
		    }
		});
		
		btnListarPorApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "listarPorApellido");
			}
		});
		
		JButton btnListarEgresados = new JButton("LISTAR EGRESADOS");
		btnListarEgresados.setForeground(Color.WHITE);
		btnListarEgresados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarEgresados.setFocusable(false);
		btnListarEgresados.setBorder(null);
		btnListarEgresados.setBackground(new Color(222, 184, 135));
		btnListarEgresados.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnListarEgresados.setBounds(305, 200, 285, 45);
		buttonsPanel.add(btnListarEgresados);
		
		btnListarEgresados.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnListarEgresados.setBackground(new Color(255, 160, 122));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnListarEgresados.setBackground(new Color(222, 184, 135));
		    }
		});
		
		btnListarEgresados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "listarEgresados");
			}
		});
		
		JPanel buttonsPanel2 = new JPanel();
		buttonsPanel2.setOpaque(false);
		buttonsPanel2.setBounds(151, 384, 299, 100);
		buttonsPanel2.setLayout(null);
		contentPanel.add(buttonsPanel2);
		
		JButton btnRespaldarDatos = new JButton("RESPALDAR DATOS");
		btnRespaldarDatos.setForeground(Color.WHITE);
		btnRespaldarDatos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRespaldarDatos.setFocusable(false);
		btnRespaldarDatos.setBorder(null);
		btnRespaldarDatos.setBackground(new Color(222, 184, 135));
		btnRespaldarDatos.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnRespaldarDatos.setBounds(7, 0, 285, 45);
		buttonsPanel2.add(btnRespaldarDatos);
		
		btnRespaldarDatos.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnRespaldarDatos.setBackground(new Color(255, 160, 122));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnRespaldarDatos.setBackground(new Color(222, 184, 135));
		    }
		});
		
		btnRespaldarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorRespaldar.respaldar();
			}
		});
		
		
		JButton btnRecuperarDatos = new JButton("RECUPERAR DATOS");
		btnRecuperarDatos.setForeground(Color.WHITE);
		btnRecuperarDatos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRecuperarDatos.setFocusable(false);
		btnRecuperarDatos.setBorder(null);
		btnRecuperarDatos.setBackground(new Color(222, 184, 135));
		btnRecuperarDatos.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnRecuperarDatos.setBounds(7, 50, 285, 45);
		buttonsPanel2.add(btnRecuperarDatos);
		
		btnRecuperarDatos.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnRecuperarDatos.setBackground(new Color(255, 160, 122));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnRecuperarDatos.setBackground(new Color(222, 184, 135));
		    }
		});
		
		btnRecuperarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorRecuperar.recuperar();
			}
		});
		
		contentPanel.add(titleLabel);
		contentPanel.add(buttonsPanel);
		contentPanel.add(buttonsPanel2);
		
		JButton btnInicio = new JButton("←");
		btnInicio.setVerticalAlignment(SwingConstants.BOTTOM);
		btnInicio.setMargin(new Insets(2, 14, 5, 14));
		btnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicio.setBorder(null);
		btnInicio.setFocusable(false);
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setBackground(new Color(222, 184, 135));
		btnInicio.setFont(new Font("Impact", Font.BOLD, 28));
		btnInicio.setBounds(10, 10, 60, 25);
		contentPanel.add(btnInicio);
		
		btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnInicio.setBackground(new Color(255, 160, 122));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnInicio.setBackground(new Color(222, 184, 135));
		    }
		});
		
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "menuInicial");
			}
		});
	}
	
	public GUIMenuOpciones(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP) {
		initialize(cardPanelP, cardLayoutP, frameP);
	}
	
	public JPanel getPanel() {
		return contentPanel;
	}

	public JFrame getFrame() {
		return frame;
	}
}
