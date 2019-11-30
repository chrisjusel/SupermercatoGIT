import java.util.ArrayList;

public class Carrello {
    private ArrayList <Articolo> Cart = new ArrayList<Articolo>();

    public void AggiungiArticolo(Articolo A) throws CarrelloPienoException{
        int max=10;
        if(Cart.size()<max)
            Cart.add(A);
        else
            throw new CarrelloPienoException("Il carrello � pieno");
    }

    public void RimuoviArticolo(Articolo A) throws CarrelloVuotoException,ArticoloAssenteException{
        if(Cart.isEmpty())
            throw new CarrelloVuotoException("Il carrello � vuoto");
        else {
            if (Cart.contains(A))
                Cart.remove(A);
            else
                throw new ArticoloAssenteException("L'articolo non � presente nel carrello");
        }
    }

    public void SvuotaCarrello(){
            Cart.clear();
    }

    public ArrayList<Articolo> GetElencoArticoli(){
        return Cart;
    }


}
