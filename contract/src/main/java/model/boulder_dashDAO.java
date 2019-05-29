package model;

import java.sql.*;

/**
 * <h1> the class Lorann DAO </h1>
 * <p>
 * This class allow the connection between java and a data base
 * </p>
 * <p>
 * The LorannDAO class is a public class with 3 private attributes and 2 public attributes and 5 methods
 * </p>
 * @see getMAPQuery
 * @see open
 * @see close
 * @see getMAp
 * @see executeQuery
 */
public class boulder_dashDAO 
{
	/** URL of the data base (local data base) */
    private static  String URL = "jdbc:mysql://localhost/lorann? autoReconnect=true&useSSL=false&useUnicode=true&useJDBC"
                + "CompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    /** user with who the connection will be done (root has all the privileges)*/
    private static String LOGIN = "root";
    /** password the user (root - no password)*/
    private static String PASSWORD = "";
    /** Connection represent a connection */
    public Connection connection;
    /** Statement represent the connection flow */
    public Statement statement;


    /** Launch a call query (call the stored procedures) */
    public static String getMAPQuery(int id) 
    {
         return "call CALL_MAP(" + id + ");";
    }


    public boulder_dashDAO () {

    this.connection = null;
    this.statement = null; 

    }
    
    /** Open a connection between java and the data base */
    public boolean open () {

        System.out.println("opening a connection");

        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection(boulder_dashDAO.URL,boulder_dashDAO.LOGIN, boulder_dashDAO.PASSWORD);

        this.statement = this.connection.createStatement();

        } catch (final ClassNotFoundException e) {
        e.printStackTrace();
        return false;
        } catch (final SQLException e) {
        e.printStackTrace();
        return false;
        }
        return true;
    }

    /** Close a connection between java and the data base */
    public void close () {

        System.out.println("closing a connection");

        if ( connection != null )
        try 
        {
        connection.close();
        } 
        catch ( SQLException ignore ) 
        {
        }
    }

    /** Get the map as a String 
     * @return map
     **/
    public String getMAp (int id) throws SQLException {

    final ResultSet resultSet = this.executeQuery(getMAPQuery(id));

    String map = ""; 

    if (resultSet.first()) {
        map = resultSet.getString("map");
    }

     return map;

    }
    
    /** execute the call query (call the stored procedures) 
     * return the result of the call query
     * @return retur
     **/
    private ResultSet executeQuery (String query_p) throws SQLException{

        ResultSet retur = this.statement.executeQuery(query_p);

        return retur;

    }
}
