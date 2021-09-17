import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Test1 {

	public static void main(String[] args) throws Exception {
		InitialContext cxt = new InitialContext();
		if ( cxt == null ) {
		   throw new Exception("Uh oh -- no context!");
		}

		DataSource ds = (DataSource) cxt.lookup( "jdbc/musicIncStoreDB" );

		if ( ds == null ) {
		   throw new Exception("Data source not found!");
		}
	}
	
}
