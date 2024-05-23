package GUIventanas;

import javax.swing.*;
import java.awt.*;

public class GUIMensaje extends JDialog {
	private JFrame frame;
	
	public GUIMensaje(JFrame parent, String mensaje, boolean error) {
        super(parent, "Popup Personalizado", true); 
        setResizable(false);
        frame = parent;
        initialize(mensaje, error);
        setVisible(true);
    }
	
	public void initialize(String mensaje, boolean error) {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		
		if(error)  {
			panel.setBackground(new Color(255, 128, 128));
			setTitle("");
			setIconImage(Toolkit.getDefaultToolkit().getImage("images/error.png"));
		}
		else {
			if (mensaje.startsWith("Atencion")) {
				panel.setBackground(new Color(176, 224, 230));
				setTitle("");
				setIconImage(Toolkit.getDefaultToolkit().getImage("images/warning.png"));
			} else {
				panel.setBackground(new Color(176, 217, 166));
				setTitle("");
				setIconImage(Toolkit.getDefaultToolkit().getImage("images/succeed.png"));
			}
			
		}
		
			panel.setLayout(null);
		panel.setBounds(0, 0, 388, 100);
		
		JLabel lblMensaje = new JLabel();
		lblMensaje.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setText(mensaje);
		lblMensaje.setBounds(10, 10, 368, 40);
		
		JButton closeButton = new JButton("OK");
		closeButton.setFocusable(false);
		closeButton.setBackground(Color.WHITE);
		closeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeButton.setBorder(null);
		closeButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
		closeButton.setBounds(164, 64, 60, 25);
		
		panel.add(lblMensaje);
        panel.add(closeButton);
        getContentPane().add(panel);
        setSize(400, 135);
        setLocationRelativeTo(getParent());
        closeButton.addActionListener(e -> dispose());
	}
	

}