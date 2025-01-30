import java.util.ArrayList;

public class Concessionaria {
    private ArrayList<Veicolo> concessionaria = new ArrayList<>();

    public Concessionaria() {
        concessionaria = new ArrayList<>();
    }

    public ArrayList<Veicolo> getConcessionaria() {
        return concessionaria;
    }
    public void addVeicolo(Veicolo a) throws Exception {
        if(!concessionaria.contains(a)){
            concessionaria.add(a);
        }else{
            throw new Exception("Veicolo già presente");
        }
    }

    public void stampaConcessionaria(){
        for(Veicolo a : concessionaria){
            System.out.println(a);
        }
    }
    public int numeroVeicolo(){
        return concessionaria.size();
    }
}
