import java.util.ArrayList;

public class NegozioElettronica {
    private ArrayList<Prodotto> prodotti = new ArrayList<>();

    public void aggiungiProdotto(Prodotto prodotto) throws Exception {
        if(!prodotti.contains(prodotto)){
            prodotti.add(prodotto.clone());
        }else{
            throw new Exception("Prodotto già presente");
        }
    }

    public boolean rimuoviProdotto(String codice) {
        return prodotti.removeIf(p -> p.getCodice().equals(codice));
    }

    public Prodotto cercaProdotto(String codice) {
        for (Prodotto p : prodotti) {
            if (p.getCodice().equals(codice)) {
                return p;
            }
        }
        return null;
    }

    public void visualizzaProdotti() {
        if (prodotti.isEmpty()) {
            System.out.println("Nessun prodotto presente nel negozio.");
            return;
        }

        for (Prodotto prodotto : prodotti) {
            System.out.println(prodotto);
        }
    }
}