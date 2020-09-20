package Model;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServiceManager implements ServiceManager_interface{
    @PersistenceContext
    private EntityManager entityManager;

    public String getAllGauBus() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://192.168.8.101:3306/GauBusDB","root","Kingdom@8");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * stops_tbl;");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();

            return "outMessage";
        }catch (Exception e){
            //return "failed";
            return  e.toString();
        }
    }

    public Boolean checkUsernameAndPassword(String username, String password) {

        //"login" this is the name of your procedure
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("stops_all");

        //Declare the parameters in the same order
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);

        //Pass the parameter values
        query.setParameter(1, username);
        query.setParameter(2, password);

        //Execute query
        query.execute();

        //Get output parameters
        Integer outCode = (Integer) query.getOutputParameterValue(3);
        String outMessage = (String) query.getOutputParameterValue(4);

        return true; //enter your condition
    }
}
