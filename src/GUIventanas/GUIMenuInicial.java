package GUIventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;


public class GUIMenuInicial {

	private JLayeredPane contentPanel;
	private JFrame frame;
	
	private void initialize(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP) {
		frame = frameP;
		contentPanel  = new JLayeredPane();
		contentPanel.setBounds(0, 0, 600, 520);
		contentPanel.setLayout(null);
		
		for(int i = 0; i < 52; i++) {
			JPanel fondo = new JPanel();
			fondo.setBounds(0, 10*i, 600, 10);
			fondo.setOpaque(true);
			fondo.setBackground(new Color(245, 200+i, 120+i*2));
			contentPanel.add(fondo);
		}
		
		JPanel namesPanel = new JPanel();
		namesPanel.setOpaque(false);
		namesPanel.setBounds(0, 0, 600, 45);
		namesPanel.setLayout(new GridLayout(1, 4, 5, 5));
		
		JLabel camilaName = new JLabel("C.Lasalvia");
		camilaName.setForeground(new Color(255, 250, 240));
		camilaName.setHorizontalAlignment(SwingConstants.CENTER);
		camilaName.setFont(new Font("Freestyle Script", Font.PLAIN, 22));
		camilaName.setBounds(103, 0, 75, 40);
		namesPanel.add(camilaName);
		
		JLabel gastonName = new JLabel("G.Bieito");
		gastonName.setForeground(new Color(255, 250, 240));
		gastonName.setHorizontalAlignment(SwingConstants.CENTER);
		gastonName.setFont(new Font("Freestyle Script", Font.PLAIN, 22));
		gastonName.setBounds(270, 0, 150, 40);
		namesPanel.add(gastonName);
		
		JLabel lucasName = new JLabel("L.Gonzalez");
		lucasName.setForeground(new Color(255, 250, 240));
		lucasName.setHorizontalAlignment(SwingConstants.CENTER);
		lucasName.setFont(new Font("Freestyle Script", Font.PLAIN, 22));
		lucasName.setBounds(454, 0, 150, 40);
		namesPanel.add(lucasName);
		
		JLabel ludmilaName = new JLabel("L.Berger");
		ludmilaName.setForeground(new Color(255, 250, 240));
		ludmilaName.setHorizontalAlignment(SwingConstants.CENTER);
		ludmilaName.setFont(new Font("Freestyle Script", Font.PLAIN, 22));
		ludmilaName.setBounds(558, 0, 150, 40);
		namesPanel.add(ludmilaName);
		
		JLabel titleLabel = new JLabel("MODA FASHIONISTA DO NORTE");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Freestyle Script", Font.BOLD, 48));
		titleLabel.setBounds(0, 170, 600, 79);
		
		JLabel esloganLabel = new JLabel("COSTURANDO SONHOS, MOLDANDO FUTUROS");
		esloganLabel.setHorizontalAlignment(SwingConstants.CENTER);
		esloganLabel.setForeground(Color.WHITE);
		esloganLabel.setFont(new Font("Freestyle Script", Font.BOLD, 28));
		esloganLabel.setBounds(0, 250, 600, 40);
		
		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.setFocusable(false);
		btnIniciar.setBorder(null);
		btnIniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIniciar.setMargin(new Insets(2, 5, 2, 5));
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.setBackground(new Color(245, 200, 120));
		btnIniciar.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		btnIniciar.setBounds(245, 350, 110, 35);
		
		btnIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnIniciar.setBackground(new Color(204, 172, 113));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnIniciar.setBackground(new Color(245, 200, 120));
		    }
		});
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutP.show(cardPanelP, "menuOpciones");
				GUIMensaje mensaje = new GUIMensaje(frame, "Atencion: Puede que existan datos para recuperar", false);
			}
		});
		
		contentPanel.add(btnIniciar,0);
		contentPanel.add(esloganLabel,0);
		contentPanel.add(titleLabel,0);
		contentPanel.add(namesPanel,0);
	}
	
	public GUIMenuInicial(JPanel cardPanelP, CardLayout cardLayoutP, JFrame frameP) {
		initialize(cardPanelP, cardLayoutP, frameP);
	}
	
	public JComponent getPanel() {
		return contentPanel;
	}

}
