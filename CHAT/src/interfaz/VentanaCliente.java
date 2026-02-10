package interfaz;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;

import util.Consumer;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCliente {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCliente window = new VentanaCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public VentanaCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("SALA DE CHAT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Introduzca el texto que quiere enviar:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JTextArea txtEnviar = new JTextArea();
		GridBagConstraints gbc_txtEnviar = new GridBagConstraints();
		gbc_txtEnviar.anchor = GridBagConstraints.SOUTH;
		gbc_txtEnviar.insets = new Insets(0, 0, 0, 5);
		gbc_txtEnviar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnviar.gridx = 0;
		gbc_txtEnviar.gridy = 3;
		frame.getContentPane().add(txtEnviar, gbc_txtEnviar);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtEnviar.getText());
			}
		});
		
		GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.anchor = GridBagConstraints.SOUTH;
		gbc_btnEnviar.gridx = 1;
		gbc_btnEnviar.gridy = 3;
		frame.getContentPane().add(btnEnviar, gbc_btnEnviar);
	}
	
	public void agnadePanel(Consumer salachat) {
		GridBagConstraints gbc_salachat = new GridBagConstraints();
		//gbc_salachat.gridheight = 3 ;
		//gbc_salachat.gridwidth = 6;
		gbc_salachat.insets = new Insets(0, 0, 5, 5);
		gbc_salachat.fill = GridBagConstraints.BOTH;
		gbc_salachat.gridx = 0;
		gbc_salachat.gridy = 1;
		frame.getContentPane().add((Component) salachat, gbc_salachat);
	}


}
