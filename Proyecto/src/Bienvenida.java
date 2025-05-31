import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.time.Year;

public class Bienvenida extends JFrame implements ActionListener 
{
	
	private JTextField textfield1;
	private JLabel label1, label2, label3, label4;
	private JButton boton1;
	Year anioActual = Year.now();
	public static String texto = "";
	
	public Bienvenida() { //Esta parte del codigo representa toda la configuracion de fondo de la ventana con su respectivo titulo, icono y color de fondo
		setLayout(null);
		setTitle("Bienvenid@");
		getContentPane().setBackground(new Color(255,0,0));
		setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("images/logo-coca.png")); //Esta parte del codigo representa donde estaria cada imagen y texto dentro de mi ventana
		label1 = new JLabel(imagen);                                                                                                                                            //*
		label1.setBounds(25,15,300,150);																																		//*
		add(label1);																																						    //*
																																												//*
		label2 = new JLabel("Sistema de Control Vacacional");																													//*
		label2.setBounds(35,135,300,30);																																		//*
		label2.setFont(new Font("Andale Mono", 3, 18));																														    //*
		label2.setForeground(new Color(255,255,255));																															//*
		add(label2);																																							//*
																																												//*
		label3 = new JLabel("Ingrese su nombre");																															    //*
		label3.setBounds(45,212,200,30);																																		//*
		label3.setFont(new Font("Andale Mono", 1, 12));																															//*
		label3.setForeground(new Color(255,255,255));																															//*
		add(label3);																																							//*
																																												//*
		label4 = new JLabel("©"+ anioActual.getValue()+ " The Coca-Cola Company");																								//*
		label4.setBounds(85,375,300,30);																																		//*
		label4.setFont(new Font("Andale Mono", 1, 12));																															//*
		label4.setForeground(new Color(255,255,255));																															//*
		add(label4);																																							//*
																																												//*
		textfield1 = new JTextField();																																			//*
		textfield1.setBounds(45,240,255,25);																																	//*
		textfield1.setBackground(new Color(224,224,224));																														//*
		textfield1.setFont(new Font("Andale Mono", 1, 14));																														//*
		textfield1.setForeground(new Color(255,0,0));																															//*
		add(textfield1);																																					    //*
		//*************************************************************************************************************************************************************************	
		
		// Esta parte del codigo arma la forma del boton y donde estara colocado, ademas de darle nombre, una Font y color. Tambien le agrega una linea que indica que ese boton tendra una accion.
		boton1 = new JButton("Ingresar");
		boton1.setBounds(125,280,100,30);
		boton1.setBackground(new Color(255,255,255));
		boton1.setFont(new Font("Andale Mono", 1, 14));
		boton1.setForeground(new Color(255,0,0));
		boton1.addActionListener(this);
		add(boton1);
	}
	
	public void actionPerformed(ActionEvent evento) //Toda esta llave es la que hace que el boton tenga una accion. Se utiliza .trim para eliminar los espacios en blanco al principio y al final del texto ingresado y en caso que no se ingrese texto se enviara un mensaje de error. Cuando detecta que se ingreso texto, ejecutara el siguiente programa prearmado.
	{ 
		if(evento.getSource() == boton1) 
		{
			texto = textfield1.getText().trim();
			if(texto.equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Debes Ingresar un nombre.");
			} else 
			{
				Licencia ventanalicencia = new Licencia();
				ventanalicencia.setBounds(0,0,600,360);
				ventanalicencia.setResizable(true);
				ventanalicencia.setLocationRelativeTo(null);
				ventanalicencia.setVisible(true);
				this.setVisible(false);
			}
		}
	}
	
	public static void main(String args[]) //Lo que ejecutara el programa y abrira la ventana que contendra todo lo programado con anterioridad. Tambien tiene preparada una linea para que el usuario moldee la ventana a su manera.
	{
		Bienvenida ventanabienvenida = new Bienvenida();
		ventanabienvenida.setBounds(0,0,350,450);
		ventanabienvenida.setResizable(true);
		ventanabienvenida.setVisible(true);
		ventanabienvenida.setLocationRelativeTo(null);
	}
}
	