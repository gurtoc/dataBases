package database;


import java.sql.*;
import java.util.ArrayList;

public class main {

    public static void delete(){
        try {
            Connection connection = getConnection();
            PreparedStatement del = connection.prepareStatement("DELETE  FROM pracownicy where id=2");
            del.executeUpdate();

            System.out.println("skasowanie");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void show(){
        try{
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pracownicy");
            //System.out.println(resultSet.toString());
            while (resultSet.next()){
                System.out.print(resultSet.getInt("id"));
                System.out.print(" ");
                System.out.print(resultSet.getString("imie"));
                System.out.print(" ");
                System.out.print(resultSet.getString("nazwisko"));
                System.out.println();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://www.db4free.net:3306/pracownicy29";
            String username = "username";
            String password = "pass";
            Class.forName(driver);

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Połączono");

            return connection;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
//    public static Connection getConnection() throws Exception {
//        try {
//            String driver = "com.mysql.cj.jdbc.Driver";
//            String url = "jdbc:mysql://localhost:3306/database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//            String username = "root";
//            String password = "tomasson1";
//            Class.forName(driver);
//
//            Connection connection = DriverManager.getConnection(url, username, password);
//            System.out.println("Połączono");
//
//            return connection;
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return null;
//    }

    public static void createTabel() throws Exception {
        try {
            Connection connection = getConnection();
            PreparedStatement create = connection.prepareStatement("CREATE TABLE IF NOT EXISTS pracownicy(id int NOT NULL AUTO_INCREMENT, imie VARCHAR (255), nazwisko VARCHAR (255),PRIMARY KEY (id)) ");
            create.executeUpdate();

            System.out.println("Zrobiono");

        } catch (Exception e) {
            System.out.println(e);
        }

        //post();

    }

    public static void post(){
        final String var1 ="Jan";
        final String var2 ="Nowak";
        try {
            Connection connection = getConnection();                   // "INSERT INTO iamalive (first, last) VALUES ('"+var1+"', '"+var2+"')");
            PreparedStatement posted = connection.prepareStatement("INSERT into pracownicy(imie, nazwisko) VALUES ('"+var1+"', '"+var2+"')");
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            System.out.println("Dodano do bazy danych"+var1+var2);
        }
    }

    public static ArrayList<String> get() throws Exception{
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from pracownicy");

            ResultSet resultSet = statement.executeQuery();

            ArrayList<String> arrayList = new ArrayList<>();
            while (resultSet.next()){
                System.out.print(resultSet.getInt("id"));
                System.out.print(" ");
                System.out.print(resultSet.getString("imie"));
                System.out.print(" ");
                System.out.println(resultSet.getString("nazwisko"));

                arrayList.add("nazwisko");

            }
            System.out.println("Wszystkie dane pozytywne wysłane do db");
            return arrayList;


        }catch(Exception e){
            System.out.println(e);
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
        //createTabel();
        //post();
       // get();
      //  delete();
        //getConnection();
        show();
    }
}
