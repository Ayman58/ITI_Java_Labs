import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public static final String DB_URL="jdbc:postgresql://localhost:5432/";
    public static final String DB_NAME="MyITI";
    public static final String USER="postgres";
    public static final String PASS="123";

    private Connection con;
    private Statement stmt;

    private void connect() throws SQLException {
        con = DriverManager.getConnection(DB_URL+DB_NAME,USER,PASS);
        stmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY) ;
    }

    public List<ContactPerson> getContacts() throws SQLException {
        List<ContactPerson> list = new ArrayList<>();
//        String queryString= new String("SELECT * FROM public.\"contacts \"");
        String queryString= new String("SELECT * FROM public.contacts");
        connect();

        ResultSet rs= stmt.executeQuery(queryString) ;
        while(rs.next()){
            System.out.println( rs.getString(2));

            list.add(new ContactPerson(rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("middle_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getInt("phone")));
        }

        stmt.close();
        con.close();
        return list;
    }


}

