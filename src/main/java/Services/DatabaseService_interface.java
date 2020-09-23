package Services;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseService_interface {
    ResultSet request(String sqlStatement) throws SQLException;
}
