import com.sun.source.tree.WhileLoopTree;

import java.sql.*;

public class MYSQLCONNECTION {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sys?useSSL=false&allowPublicKeyRetrival=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "88888888";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("connecting...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);


            System.out.println(" Instanitiate statement object...");
            stmt = conn.createStatement();
            String sql;

//            sql = "insert into table2 value(667,'Dog(puppy)', 'U.S.A')";
//            int count = stmt.executeUpdate(sql);
//            System.out.println(count);

            sql = "SELECT `ID`, `Pet`, `Nationality` FROM table2";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("ID");
                String Pet = rs.getString("Pet");
                String Nationality = rs.getString("Nationality");

                System.out.println("ID: " + id);
                System.out.println("Pet: " + Pet);
                System.out.println("Nationality: " + Nationality);
            }



        }catch (SQLException se) {
            se.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(stmt!=null) stmt.close();
            }catch (SQLException se2){

            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");

    }
}
