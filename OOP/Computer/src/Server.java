/*mentre per i PC fissi di tipo server è necessario sapere il
        numero dei processori e se hanno o meno dischi di tipo RAID.*/

public class Server extends Computer{
    private int nProcessori;
    private boolean raid;
    private tipi tipo;


    public Server(String processore, int ram, int memoriaMassa, String marca,String modello, String SO, int nProcessori, boolean raid, tipi tipo) {
        super(processore, ram, memoriaMassa, marca, modello, SO);
        this.nProcessori = nProcessori;
        this.raid = raid;
        this.tipo = tipo;
    }

    public int getnProcessori() {
        return nProcessori;
    }

    public void setnProcessori(int nProcessori) {
        this.nProcessori = nProcessori;
    }

    public boolean isRaid() {
        return raid;
    }

    public void setRaid(boolean raid) {
        this.raid = raid;
    }

    public void setTipo(tipi tipo) {
        this.tipo = tipi.valueOf(String.format(String.valueOf(getClass())));
    }

    public tipi getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" , Tipo: %s, nProcessori: %d, Sono presenti Raid: %s", tipo, nProcessori, raid);
    }


    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Server computer)){
            return false;
        }else{
            return super.equals(computer) && tipo.equals(computer.tipo) && nProcessori == computer.nProcessori;
        }
    }

}
