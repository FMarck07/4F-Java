/*I PC fissi sono caratterizzati dal tipo di contenitore (grande, medio, piccolo), per
        quelli desktop è necessario registrare il tipo di scheda video*/


public class PCfissi extends Computer{
    private Contenitore contenitore;
    private String schedaVideo;
    private tipi tipo;

    public PCfissi(String processore, int ram, int memoriaMassa, String marca, String modello, String SO, Contenitore contenitore, String schedaVideo, tipi tipo) {
        super(processore, ram, memoriaMassa, marca, modello, SO);
        this.contenitore = contenitore;
        this.schedaVideo = schedaVideo;
        this.tipo = tipo;
    }

    public Contenitore getContenitore() {
        return contenitore;
    }

    public void setContenitore(Contenitore contenitore) {
        this.contenitore = contenitore;
    }

    public String getSchedaVideo() {
        return schedaVideo;
    }

    public void setSchedaVideo(String schedaVideo) {
        this.schedaVideo = schedaVideo;
    }

    public tipi getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Tipo: %s, Contenitore: %s, Scheda Video: %s", tipo, contenitore, schedaVideo);
    }
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof PCfissi computer)){
            return false;
        }else{
            return super.equals(computer) && schedaVideo.equals(computer.schedaVideo) && tipo.equals(computer.tipo) && contenitore.equals(computer.contenitore);
        }
    }

}
