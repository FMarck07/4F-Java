public class Test {
    public static void main(String[] args) {
        Scuola elementare = new ScuolaElementare("EL123", "Scuola Elementare Rossi", "Via Roma 1", "Milano",150, 10, 2, 0);

        Scuola media = new ScuolaMedia("ME456", "Scuola Media Verdi", "Via Milano 2", "Roma",200, 12, 1, 3);

        ScuolaSuperiore liceo = new Liceo("LI789", "Liceo Scientifico Bianchi", "Via Napoli 3", "Torino",300, 15, 0, 5);

        ScuolaSuperiore tecnico = new Tecnico("TE012", "Istituto Tecnico Neri", "Via Firenze 4", "Bologna", 250, 14, 2, 8);

        ScuolaSuperiore professionale = new Professionale("PR345", "Istituto Professionale Gialli", "Via Venezia 5", "Firenze", 180, 12, 1, 6);

        System.out.println("=== SCUOLA ELEMENTARE ===");
        System.out.println(elementare);

        System.out.println("=== SCUOLA MEDIA ===");
        System.out.println(media);

        System.out.println("=== LICEO ===");
        System.out.println(liceo);

        System.out.println("=== ISTITUTO TECNICO ===");
        System.out.println(tecnico);

        System.out.println("=== ISTITUTO PROFESSIONALE ===");
        System.out.println(professionale);
    }
}