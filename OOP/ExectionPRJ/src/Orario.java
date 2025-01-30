public class Orario {
    private int h;
    private int n;
    private int s;

    public Orario(int h, int n, int s) {
        try{
            checkOrario(h, n, s);
        }catch (OrarioExeption4F e){
            System.out.println(e.getMessage());
            System.out.println(e.getH());
            System.out.println(e.getN());
            System.out.println(e.getS());
        }
        this.h = h;
        this.n = n;
        this.s = s;
    }
    private void checkOrario(int h, int n, int s) throws OrarioExeption4F {
        if(h<0 || h>23 || n>59 || n<0 || s>59 || s<0){
            throw new OrarioExeption4F(h, n, s);
        }
    }
}