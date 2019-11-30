import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GUI extends JFrame{

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldCodice;
	private JTextField textFieldPrezzo;
	private JComboBox<Integer> comboBoxQuantity;
	private Controller Control;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public GUI(Controller ctrl) {
		Control = ctrl;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 589, 474);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnTermina = new JButton("Termina");
		btnTermina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Control.getMagazzino().isEmpty()) {
					Control.TerminaInserimentoAticoli();
					setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(new JFrame(), "Magazzino vuoto, inserire articoli", "Errore Inserimento", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnTermina.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTermina.setBounds(329, 312, 173, 81);
		getContentPane().add(btnTermina);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(67, 36, 49, 14);
		getContentPane().add(lblNome);
		
		JLabel lblCodice = new JLabel("Codice");
		lblCodice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodice.setBounds(67, 95, 90, 14);
		getContentPane().add(lblCodice);
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrezzo.setBounds(67, 157, 90, 14);
		getContentPane().add(lblPrezzo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(179, 36, 173, 20);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCodice = new JTextField();
		textFieldCodice.setColumns(10);
		textFieldCodice.setBounds(179, 95, 173, 20);
		getContentPane().add(textFieldCodice);
		
		textFieldPrezzo = new JTextField();
		textFieldPrezzo.setColumns(10);
		textFieldPrezzo.setBounds(179, 157, 173, 20);
		getContentPane().add(textFieldPrezzo);
		
		JComboBox<Integer> comboBoxQuantity = new JComboBox<Integer>();
		comboBoxQuantity.setBounds(179, 214, 47, 28);
		getContentPane().add(comboBoxQuantity);
		comboBoxQuantity.addItem(1);
		comboBoxQuantity.addItem(2);
		comboBoxQuantity.addItem(3);
		comboBoxQuantity.addItem(4);
		comboBoxQuantity.addItem(5);
		
		JButton btnAggiungiArticolo = new JButton("Aggiungi Articoli");
		btnAggiungiArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value=(int) comboBoxQuantity.getSelectedItem();
				ControllaCorrettezzaPerInserimento(value);
				comboBoxQuantity.setSelectedItem(1);

			}
		});
		btnAggiungiArticolo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAggiungiArticolo.setBounds(67, 312, 159, 81);
		getContentPane().add(btnAggiungiArticolo);
	
		
		JLabel lblQuantity = new JLabel("Quantità");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuantity.setBounds(67, 206, 90, 36);
		getContentPane().add(lblQuantity);
	}
	private void ControllaCorrettezzaPerInserimento(int value) {
		if((textFieldNome.getText().length()>0) && (textFieldCodice.getText().length()>0) && (textFieldPrezzo.getText().length()>0)) {
			Control.AggiungiArticolo(textFieldNome.getText(), textFieldCodice.getText(), textFieldPrezzo.getText(), value);
			textFieldNome.setText("");
			textFieldCodice.setText("");
			textFieldPrezzo.setText("");

		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "Inserire Valori", "Errore Inserimento", JOptionPane.ERROR_MESSAGE);
		}
			
	}
}

