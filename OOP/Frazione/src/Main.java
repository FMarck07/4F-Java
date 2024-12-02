public class Main {
    public static void main(String[] args) {
        double risultato = 0;
        try {
            Frazione frazione = new Frazione(5, 2);
            Frazione addendo = new Frazione(3,2);
            System.out.println("Il risultato in frazione è: " + frazione.sommaFrazione(addendo));
            risultato = frazione.somma(addendo);
            System.out.println("IL risultato in decimale è: " + risultato);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}