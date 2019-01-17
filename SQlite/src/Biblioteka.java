import java.sql.*;
import java.util.ArrayList;

public class Biblioteka {

    public final String driver = "org.sqlite.JDBC";
    public final String db_url = "jdbc:sqlite:biblioteka.db";

    private Connection connection;
    private Statement statement;


    public Biblioteka() {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            connection = DriverManager.getConnection(db_url);
            statement = connection.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void createTable() {
        String createCzytelnicy = "CREATE TABLE IF NOT EXISTS czytelnicy (id_czytelnika INTEGER PRIMARY KEY AUTOINCREMENT, imie varchar(255), nazwisko varchar(255), pesel int)";
        String createKsiazki = "CREATE TABLE IF NOT EXISTS ksiazki(id_ksiazki INTEGER PRIMARY KEY AUTOINCREMENT, tytul VARCHAR(255), autor VARCHAR(255))";
        String createWypozyczania = "CREATE TABLE IF NOT EXISTS wypozyczalnia(id_wypozyczenia INTEGER PRIMARY KEY, id_czytelnika, id_ksiazki)";
        try {
            statement.execute(createCzytelnicy);
            statement.execute(createKsiazki);
            statement.execute(createWypozyczania);
            System.out.println("Stworzone baze danych SQLite");
        } catch (SQLException e) {
            System.out.println(e);
            //return false;
        }
        //return true;
    }

    public void insertKsiazka(String tytul, String autor) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into ksiazki values(NULL, ?, ? )");
            preparedStatement.setString(1, tytul);
            preparedStatement.setString(2, autor);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertCzytelnicy(String imie, String nazwisko, int pesel) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into czytelnicy values (null ,?,?,?)");
            preparedStatement.setString(1, imie);
            preparedStatement.setString(2, nazwisko);
            preparedStatement.setInt(3, pesel);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertWypozyczanie(int idKsiazki, int idCzytelnika) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into wypozyczalnia values (NULL ,?,?)");
            preparedStatement.setInt(1, idKsiazki);
            preparedStatement.setInt(2, idCzytelnika);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void selctKsiazki() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from ksiazki");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Ksiazka> ksiazkas = new ArrayList<>();
            int id = 0;
            String tytul = "";
            String autor = "";
            while (resultSet.next()) {
                System.out.print(resultSet.getString("id_ksiazki"));
                System.out.print(" ");
                System.out.print(resultSet.getString("tytul"));
                System.out.print(" ");
                System.out.print(resultSet.getString("autor"));
                System.out.println();
                ksiazkas.add(new Ksiazka(id, tytul, autor));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void selectCzytelnicy(){
        try{
            ArrayList<Czytelnicy> czytelnicies = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM czytelnicy");
            ResultSet resultSet = preparedStatement.executeQuery();
            int id=0;
            String imie ="";
            String nazwisko="";
            int pesel=0;
            while (resultSet.next()){
                System.out.print(resultSet.getInt("id_czytelnika"));
                System.out.print(" ");
                System.out.print(resultSet.getString("imie"));
                System.out.print(" ");
                System.out.print(resultSet.getString("nazwisko"));
                System.out.print(" ");
                System.out.print(resultSet.getInt("pesel"));
                System.out.println();
                czytelnicies.add(new Czytelnicy(id,imie,nazwisko,pesel));
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Biblioteka biblioteka = new Biblioteka();

        biblioteka.createTable();
        // biblioteka.insertKsiazka("Pokahontas", "Jan Kowalksi");
        //  biblioteka.insertCzytelnicy("Tomasz","Pawlak",880928);
        //  biblioteka.insertWypozyczanie(1,1);
        // biblioteka.createTable();
        biblioteka.selctKsiazki();
        biblioteka.selectCzytelnicy();
    }
}
