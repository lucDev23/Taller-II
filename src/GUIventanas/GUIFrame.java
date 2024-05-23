package GUIventanas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class GUIFrame {
	
	private JFrame frame;
	private CardLayout cardLayout;
    private JPanel cardPanel;
    
    private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/iconoFrame.png"));
		frame.setSize(612, 555);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
		
        cardPanel.add(new GUIMenuInicial(cardPanel, cardLayout, frame).getPanel(), "menuInicial");
        cardLayout.show(cardPanel, "menuInicial");
        
        cardPanel.add(new GUIMenuOpciones(cardPanel, cardLayout, frame).getPanel(), "menuOpciones");
        
        cardPanel.add(new GUIRegistrarAsignatura(cardPanel, cardLayout, frame).getPanel(), "registrarAsignatura");
        
        cardPanel.add(new GUIListarAsignaturas(cardPanel, cardLayout, frame).getPanel(), "listarAsignaturas");
        
        cardPanel.add(new GUIRegistrarAlumno(cardPanel, cardLayout, frame).getPanel(), "registrarAlumno");
        
        cardPanel.add(new GUIListarPorApellido(cardPanel, cardLayout, frame).getPanel(), "listarPorApellido");
        
        cardPanel.add(new GUIListarPorCedula(cardPanel, cardLayout, frame).getPanel(), "listarPorCedula");
        
        cardPanel.add(new GUIInscripcionAsignatura(cardPanel, cardLayout, frame).getPanel(), "inscripcionAsignatura");
        
        cardPanel.add(new GUIRegistrarResultado(cardPanel, cardLayout, frame).getPanel(), "resultadoAsignatura");
        
        cardPanel.add(new GUIMontoRecaudado(cardPanel, cardLayout, frame).getPanel(), "montoRecaudado");
        
        cardPanel.add(new GUIListarEscolaridad(cardPanel, cardLayout, frame).getPanel(), "listarEscolaridad");
        
        cardPanel.add(new GUIListarEgresados(cardPanel, cardLayout, frame).getPanel(), "listarEgresados");
        
        frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
	}
	
	public GUIFrame() {
		initialize();
		setVisible(true);
		GUIMensaje mensaje = new GUIMensaje(frame, "Atencion: Leer archivo readme antes de continuar", false);
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}

