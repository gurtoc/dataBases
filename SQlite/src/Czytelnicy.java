public class Czytelnicy {

    private int id_czytelnika;
    private String imie;
    private String nazwisko;
    private int pesel;

    public Czytelnicy(int id_czytelnika, String imie, String nazwisko, int pesel) {
        this.id_czytelnika = id_czytelnika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public Czytelnicy(){}

    public int getId_czytelnika() {
        return id_czytelnika;
    }

    public void setId_czytelnika(int id_czytelnika) {
        this.id_czytelnika = id_czytelnika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Czytelnicy{" +
                "id_czytelnika=" + id_czytelnika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel=" + pesel +
                '}';
    }
}
