import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI2 extends JFrame {

	private JPanel contentPane;
	private Controller Control;

	public GUI2(Controller ctrl) {
		Control = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAggiungiAlCarrello = new JButton("Aggiungi Al Carrello");
		btnAggiungiAlCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<Articolo> temp = AggiornaArticoliDisponibili();
				Control.AggiungiItemsAlCarrello(temp);

			}
		});
		btnAggiungiAlCarrello.setFont(new Font("Tahoma", Font.PLAIN, 18));
			
		btnAggiungiAlCarrello.setBounds(25, 199, 215, 53);
		contentPane.add(btnAggiungiAlCarrello);
		
		JButton btnTermina = new JButton("Termina");
		btnTermina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnTermina.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTermina.setBounds(277, 199, 136, 53);
		contentPane.add(btnTermina);
		
		JLabel lblArticoliDisponibili = new JLabel("Articoli Disponibili");
		lblArticoliDisponibili.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArticoliDisponibili.setBounds(29, 10, 136, 14);
		contentPane.add(lblArticoliDisponibili);
		
		JComboBox comboBoxQuantity = new JComboBox();
		comboBoxQuantity.setBounds(34, 109, 56, 22);
		contentPane.add(comboBoxQuantity);
		
		JLabel lblQuantit = new JLabel("Quantity");
		lblQuantit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantit.setBounds(25, 89, 98, 14);
		contentPane.add(lblQuantit);
		
	}
	
	public JComboBox<Articolo> AggiornaArticoliDisponibili() {
		JComboBox comboBoxArticoliDisponibili = new JComboBox();
		comboBoxArticoliDisponibili.setBounds(34, 35, 365, 22);
		contentPane.add(comboBoxArticoliDisponibili);
		for(Articolo a:Control.getMagazzino()) {
			comboBoxArticoliDisponibili.addItem(a.toString());
		}
		return comboBoxArticoliDisponibili;
	}
}
