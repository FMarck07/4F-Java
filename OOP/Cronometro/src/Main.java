public class Main {
    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();
        try {
            cronometro.avvia();
            Thread.sleep(150); // Attende 2,5 secondi
            System.out.println("Durata corrente: " + cronometro.getDurataFormattata());
            cronometro.ferma();
            System.out.println("Durata finale: " + cronometro.getDurataFormattata());
            cronometro.reset();
        } catch (InterruptedException e) {
            System.err.println("Operazione interrotta: " + e.getMessage());
        }
    }
}
