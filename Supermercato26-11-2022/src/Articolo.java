
public class Articolo {
	private String Nome;
	private String Codice;
	private double Prezzo;
	private int Quantity;
	
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCodice() {
		return Codice;
	}
	public void setCodice(String codice) {
		Codice = codice;
	}
	public double getPrezzo() {
		return Prezzo;
	}
	public void setPrezzo(double prezzo) {
		Prezzo = prezzo;
	}
	
	public Articolo(String Name, String Code, double Price, int quantity) {
		Nome = Name;
		Codice = Code;
		Prezzo = Price;
		Quantity = quantity;
	}
	
	@Override
	public String toString() {
		String string;
		string = Codice +" "+Nome+" "+Prezzo+"  Quantità:  "+Quantity;
		return string;
	}
}
