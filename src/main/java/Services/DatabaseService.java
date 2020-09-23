package Services;

import org.json.simple.JSONObject;

import java.sql.*;

public class DatabaseService implements DatabaseService_interface {
    private JSONObject results;
    protected String url_ = "jdbc:mysql://192.168.8.101:3306/GauBusDB";
    protected String user_ = "root";
    protected String pass_ = "";

    private Connection openDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url_, user_, pass_);
            return con;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public ResultSet request(String sqlStatement){
       try{
            results = new JSONObject();
            Statement stmt=openDB().createStatement();
            ResultSet rs=stmt.executeQuery(sqlStatement);
            openDB().close();
            return rs;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
