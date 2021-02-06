package Server;
import java.sql.*;
import java.util.concurrent.ExecutionException;

public class DataBass  {
    public static Connection conn;
    public static Statement statement;
    public static ResultSet resultSet;
public static void Run()  throws SQLException, ClassNotFoundException{
   // setConn();
  // createDB();
  //  writeBD();
  //  Search("AndFag2", "12345");
   // readBD();
  // closeDB();

}
    public static String Search(String l,String p) throws SQLException, ClassNotFoundException {
        setConn();
        String nikName;
        try {
            nikName=DataBass.finderBD(l,p);
            System.out.println("Good  "+ nikName);
        }catch (Exception e){
            e.printStackTrace();
            nikName="error";
            return nikName;

        }
        closeDB();
        return nikName;
    }

    public static void setConn() throws ClassNotFoundException, SQLException {
        conn = null;
        // загрузить драйвер в память виртуальной машины;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:TEST4.Pass");
    }

/*/
    public static void writeBD() throws SQLException {
        statement.execute("INSERT INTO 'users' ('NikName','login', 'password') VALUES ('Psaetya','AndFag2', '12345')");
       statement.execute("INSERT INTO 'users' ('NikName','login', 'password') VALUES ('Psaetya','AndFag3', '12345')");
       statement.execute("INSERT INTO 'users' ('NikName','login', 'password') VALUES ('Psaetya','AndFag1', '12345')");
        statement.execute("INSERT INTO 'users' ('NikName','login', 'password') VALUES ('Petya','AndFag0', '12345')");
    }


     public static void createDB() throws SQLException {
        statement = conn.createStatement();
        statement.execute(
                "CREATE TABLE if not exists 'users'" +
                        "( 'NikName' text,'login' text, 'password' text);");
    }


   public static void readBD() throws SQLException{
        resultSet = statement.executeQuery("SELECT * FROM users");
        while (resultSet.next()) {

            String nikName = resultSet.getString("NikName");
            String password = resultSet.getString("password");
            String login = resultSet.getString("login");
            System.out.println( nikName + " " +login+" "+ password);
        }
    }
/*/



    public static String finderBD(String l,String p) throws  SQLException{


        statement = conn.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM users");


    resultSet = statement.executeQuery("select NikName from users where login='" +l+"' and password = '"+p+"' ");
    String nikName = resultSet.getString("NikName");

        return nikName;
    }
    public static void findAndCheang(String oldNik,String newNik) throws SQLException, ClassNotFoundException {

        setConn();
        statement = conn.createStatement();
       // resultSet = statement.executeQuery("SELECT * FROM users");
        //update users set login = LOGIN where login = OLD_Login
        try {
            resultSet = statement.executeQuery("UPDATE users SET NikName = '" + newNik + "' where NikName= '" + oldNik + "' ");
        }catch (Exception e){

        }
        System.out.println("NewNikInBD");
       // closeDB();
    }

    public static void closeDB() throws SQLException {
        resultSet.close();
        statement.close();
        conn.close();
    }
}
