import java.time.LocalTime;

public class Cronometro implements Comparable <Cronometro>{
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer tempoGiro;

    public Cronometro() {
        setStartTime();
        setEndTime();
    }

    void setStartTime() {
        startTime = LocalTime.now();
    }

    void setEndTime() {
        endTime = LocalTime.now();
    }

    public int getTempoGiro() {
        return tempoGiro;
    }

    void calcolaIntTimer() throws Exception {
        int tempoGiro = this.endTime.toSecondOfDay() - this.startTime.toSecondOfDay();
        if (tempoGiro <= 0) {
            throw new Exception("Tempo non valido per il cronometro.");
        }
        this.tempoGiro = tempoGiro;
    }


    @Override
    public String toString() {
        return String.format("Tempo: %d", tempoGiro);
    }

    @Override
    public int compareTo(Cronometro o) {
        return tempoGiro.compareTo(o.tempoGiro);
    }
}