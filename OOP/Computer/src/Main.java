public class Main {
    public static void main(String[] args) {
        /*Si intende realizzare una gerarchia di
        classi per rappresentare e gestire i seguenti tipi
        di oggetti: PC fissi, suddivisi in desktop e server,
        e PC portatili di tipo notebook. Le caratteristiche
        generali di interesse sono: il tipo di processore,
        la dimensione della memoria RAM, la dimensione
        della memoria di massa, la marca, il modello e
        il sistema operativo. I PC fissi sono caratterizzatidal
        dal tipo di contenitore (grande, medio, piccolo), per
        quelli desktop è necessario registrare il tipo di scheda video,
        mentre per i PC fissi di tipo server è necessario sapere il
        numero dei processori e se hanno o meno dischi di tipo RAID.
        I PC portatili sono caratterizzati dal peso, dalle dimensioni
        fisiche (altezza, larghezza e profondità) e dalle dimensioni del video.
        1-Definire mediante un diagramma UML le classi che realizzano la gerarchia descritta.
        2-Implementare in linguaggio Java le classi progettate specificando costruttori e
        metodi di accesso agli attributi e sovrascrivendo opportunamente i metodi toString ed equals.
        Codificare una classe Test il cui metodo main istanzi oggetti corrispondenti alle varie
        tipologie di PC e invochi ciascuno dei metodi definiti almeno una volta.
        Sempre nella stessa classe Test verificare i meccanismi di up-casting e down-casting.*/



        Server server = new Server("Xeon", 64, 1000, "Dell", "PowerEdge", "Linux", 2, true, tipi.Server);
        System.out.println(server);

        // Creazione di un oggetto PCfissi
        PCfissi desktop = new PCfissi("i7", 16, 500, "HP", "Pavilion", "Windows", Contenitore.medio, "NVIDIA GTX 1660", tipi.PC);
        System.out.println(desktop);

        // Creazione di un oggetto Portatili
        Portatili notebook = new Portatili("i5", 8, 256, "Lenovo", "ThinkPad", "Windows", 2, 15, 35, 25, 15, tipi.Notebook);
        System.out.println(notebook);

        // Up-casting
        Computer computer1 = new Server("Xeon", 32, 2000, "IBM", "SystemX", "Unix", 4, false, tipi.Server);
        System.out.println(computer1);

        // Down-casting
        if (computer1 instanceof Server) {
            Server server2 = (Server) computer1;
            System.out.println("Down-casting riuscito: " + server2.getnProcessori());
        }
    }
}
