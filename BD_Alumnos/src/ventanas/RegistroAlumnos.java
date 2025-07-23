package ventanas;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;


public class RegistroAlumnos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_nombre;
	private JTextField text_grupo;
	private JTextField text_buscar;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroAlumnos frame = new RegistroAlumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RegistroAlumnos() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		text_nombre = new JTextField();
		text_nombre.setBounds(10, 30, 203, 20);
		contentPane.add(text_nombre);
		text_nombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Grupo");
		lblNewLabel_1.setBounds(10, 71, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		text_grupo = new JTextField();
		text_grupo.setBounds(10, 93, 203, 20);
		contentPane.add(text_grupo);
		text_grupo.setColumns(10);
		
		JLabel label_status = new JLabel("");
		label_status.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_status.setBounds(10, 282, 203, 32);
		contentPane.add(label_status);
		
		JButton boton1 = new JButton("Registrar");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_institucion", "root", ""); //Se establece la conexion a la base de datos y se puede cambiar por una URL de una pagina web.
					PreparedStatement pst = cn.prepareStatement("insert into alumnos values(?,?,?)");
					
					pst.setString(1, "0");
					pst.setString(2, text_nombre.getText().trim());
					pst.setString(3, text_grupo.getText().trim());
					pst.executeUpdate();
					
					text_nombre.setText("");
					text_grupo.setText("");
					label_status.setText("Registro exitoso");
				} catch(Exception ex) 
				{
					
				}
			}
		});
		boton1.setBounds(10, 143, 89, 23);
		contentPane.add(boton1);
		
		JButton boton2 = new JButton("Modificar");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					String ID = text_buscar.getText().trim();
					
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_institucion", "root", ""); //Se establece la conexion a la base de datos y se puede cambiar por una URL de una pagina web.
					PreparedStatement prst = cn.prepareStatement("update alumnos set NombreAlumno = ?, Grupo = ?  where ID = " + ID);
					
					prst.setString(1, text_nombre.getText().trim());
					prst.setString(2, text_grupo.getText().trim());
					prst.executeUpdate();
					
					label_status.setText("Modificacion exitosa");
				} catch(Exception ex) 
				{
					 label_status.setText("Error al modificar");
				}
			}
		});
		boton2.setBounds(124, 143, 89, 23);
		contentPane.add(boton2);
		
		JButton boton3 = new JButton("Eliminar");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_institucion", "root", ""); //Se establece la conexion a la base de datos y se puede cambiar por una URL de una pagina web.
					PreparedStatement prst = cn.prepareStatement("delete from alumnos where ID = ?");
					
					prst.setString(1, text_buscar.getText().trim());
					prst.executeUpdate();
					
					text_nombre.setText("");
					text_grupo.setText("");
					text_buscar.setText("");
					
					label_status.setText("Eliminacion exitosa");
					
				} catch (Exception ex) {
					label_status.setText("Error al eliminar");
				}
			}
		});
		boton3.setBounds(241, 143, 89, 23);
		contentPane.add(boton3);
		
		JLabel lblNewLabel_2 = new JLabel("Ingresa el ID del alumno:");
		lblNewLabel_2.setBounds(10, 199, 172, 14);
		contentPane.add(lblNewLabel_2);
		
		text_buscar = new JTextField();
		text_buscar.setBounds(192, 196, 86, 20);
		contentPane.add(text_buscar);
		text_buscar.setColumns(10);
		
		JButton boton4 = new JButton("Buscar");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_institucion", "root", ""); //Se establece la conexion a la base de datos y se puede cambiar por una URL de una pagina web.
					PreparedStatement pst = cn.prepareStatement("select * from alumnos where ID = ?");
					pst.setString(1, text_buscar.getText().trim());
					
					ResultSet rs = pst.executeQuery();

					if (rs.next()) {
						text_nombre.setText(rs.getString("NombreAlumno"));
						text_grupo.setText(rs.getString("Grupo"));
					} else {
						JOptionPane.showMessageDialog(null, "Alumno no encontrado");
					}
				} catch (Exception ex) {
					label_status.setText("Error al buscar");
				}
			}
		});
		boton4.setBounds(10, 227, 89, 23);
		contentPane.add(boton4);
		
		JButton boton5 = new JButton("Generar PDF");
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Document documento = new Document();

		        try {
		            String ruta = System.getProperty("user.home") + "/Desktop/Informe_Alumnos.pdf";
		            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
		            
		            Image header = Image.getInstance("src/img/header.jpg");
		            header.scaleToFit(600, 1000);
		            header.setAlignment(Chunk.ALIGN_CENTER);
		            
		            Paragraph parrafo = new Paragraph();
		            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
		            parrafo.add("Informe creado a modo de practica por Matias Tomas Del Pup \n\n");
		            parrafo.setFont(FontFactory.getFont("Arial", 18, Font.BOLD, BaseColor.BLUE));
		            parrafo.add("Alumnos Registrados \n\n");
		            
		            documento.open();
		            documento.add(header);
		            documento.add(parrafo);

		            PdfPTable tabla = new PdfPTable(3);
		            tabla.addCell("ID");
		            tabla.addCell("Nombre");
		            tabla.addCell("Grupo");

		            try (Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_institucion", "root", "");
		                 PreparedStatement pst = cn.prepareStatement("SELECT * FROM alumnos");
		                 ResultSet rs = pst.executeQuery()) {

		                while (rs.next()) {
		                    tabla.addCell(rs.getString("ID"));
		                    tabla.addCell(rs.getString("NombreAlumno"));
		                    tabla.addCell(rs.getString("Grupo"));
		                }

		                documento.add(tabla);
		                documento.close();

		                JOptionPane.showMessageDialog(null, "PDF generado exitosamente en: " + ruta);

		            } catch (SQLException ex) {
		                documento.close();
		                JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos.\n" + ex.getMessage());
		            }

		        } catch (DocumentException ex) {
		            JOptionPane.showMessageDialog(null, "Error al crear el documento PDF.\n" + ex.getMessage());
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error general al generar PDF.\n" + ex.getMessage());
		        }
		    }
		});
		boton5.setBounds(351, 143, 127, 23);
		contentPane.add(boton5);
		
		
	}
}
