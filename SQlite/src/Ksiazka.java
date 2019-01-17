public class Ksiazka {

    private int id_ksiazki;
    private String tytul;
    private String autor;

    public Ksiazka(int id_ksiazki, String tytul, String autor) {
        this.id_ksiazki = id_ksiazki;
        this.tytul = tytul;
        this.autor = autor;
    }

    public Ksiazka(){};

    public int getId_ksiazki() {
        return id_ksiazki;
    }

    public void setId_ksiazki(int id_ksiazki) {
        this.id_ksiazki = id_ksiazki;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Ksiazka{" +
                "id_ksiazki=" + id_ksiazki +
                ", tytul='" + tytul + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
