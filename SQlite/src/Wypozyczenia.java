public class Wypozyczenia {
    private int idKsiazki;
    private int idCzytelnika;

    @Override
    public String toString() {
        return "Wypozyczenia{" +
                "idKsiazki=" + idKsiazki +
                ", idCzytelnika=" + idCzytelnika +
                '}';
    }

    public Wypozyczenia(int idKsiazki, int idCzytelnika) {
        this.idKsiazki = idKsiazki;
        this.idCzytelnika = idCzytelnika;
    }
    public Wypozyczenia(){}

    public int getIdKsiazki() {
        return idKsiazki;
    }

    public void setIdKsiazki(int idKsiazki) {
        this.idKsiazki = idKsiazki;
    }

    public int getIdCzytelnika() {
        return idCzytelnika;
    }

    public void setIdCzytelnika(int idCzytelnika) {
        this.idCzytelnika = idCzytelnika;
    }
}
