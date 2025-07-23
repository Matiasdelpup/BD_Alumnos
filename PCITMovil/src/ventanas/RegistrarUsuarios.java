package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class RegistrarUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarUsuarios frame = new RegistrarUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RegistrarUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(255, 255, 255));
		textField.setFont(new Font("Arial", Font.BOLD, 16));
		textField.setBackground(new Color(153, 153, 255));
		textField.setBounds(30, 75, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 50, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Registro de usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(210, 10, 237, 29);
		contentPane.add(lblNewLabel);
		
		JLabel label_wallpaper = new JLabel("");
		label_wallpaper.setBounds(0, 0, 614, 311);
		contentPane.add(label_wallpaper);
	}
}
