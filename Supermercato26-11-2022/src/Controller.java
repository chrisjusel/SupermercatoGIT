import java.util.ArrayList;

import javax.swing.JComboBox;

public class Controller {
	ArrayList<Articolo> Magazzino;
	GUI2 Carrello;
	Carrello Cart;
	
	public static void main(String[] args) {
		Controller TheController = new Controller();
		GUI frame = new GUI(TheController);
		frame.setVisible(true);
	}

	public Controller() {
		Magazzino = new ArrayList<Articolo>();
		Carrello = new GUI2(this);
	}
	
	public ArrayList<Articolo> getMagazzino() {
		return Magazzino;
	}

	public void AggiungiArticolo(String Nome, String Codice, String Prezzo, int Quantity) {
		Double d = new Double(Prezzo);
		Articolo temp = new Articolo(Nome, Codice, d, Quantity);
		Magazzino.add(temp);
		System.out.println("Ho aggiunto nel magazzino un oggetto di nome "+temp.getNome());
	}
	
	public void TerminaInserimentoAticoli() {
		Carrello.setVisible(true);
		Carrello.AggiornaArticoliDisponibili();
	}
	
	public void AggiungiItemsAlCarrello(JComboBox<Articolo> comboBox) {
		Articolo item = (Articolo)comboBox.getSelectedItem();
		try {
			Cart.AggiungiArticolo(item);
		}catch(CarrelloPienoException e) {
		}
		System.out.println("Aggiunto al carrello un item di nome");
	}
	
}
