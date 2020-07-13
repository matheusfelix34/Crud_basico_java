package aluno;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConsultarAlunosrv
 */
@WebServlet("/ConsultarAlunosrv")
public class ConsultarAlunosrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarAlunosrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String codigo = request.getParameter("codigo_consulta");
		Connection connection = getConexaoMySQL();

        try {
			Statement statement = connection.createStatement();
			String consulta;
			consulta = "select *from aluno.usuario where codigo = "+codigo;
			//statement.execute(consulta);
			
			// executa um select
		    ResultSet rs = statement.executeQuery(consulta);
		    
		    while (rs.next()) {
		        String nome = rs.getString("nome");
		        

		        System.out.println(nome + " _ ");
		    }
		    
		    
		    statement.close();    
	          
	        connection.close();
		    
			//  String inserir = "Insert into aluno.usuario values ("+codigo+",'"+nome+"','"+endereco+"')";
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Houve um erro:" + e.getMessage());
		}
		
		
		
	}
	
	public static java.sql.Connection getConexaoMySQL() {
		 
        Connection connection = null;          //atributo do tipo Connection
 
  
 
	try {
	 
		// Carregando o JDBC Driver padrão
		 
		String driverName = "com.mysql.jdbc.Driver";                        
		 
		Class.forName(driverName);
 
  
 
		// Configurando a nossa conexão com um banco de dados//
 
        String serverName = "localhost:3307";    //caminho do servidor do BD
 
        String mydatabase = "aluno";        //nome do seu banco de dados
 
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
 
        String username = "root";        //nome de um usuário de seu BD      
 
        String password = "ThorAsgard@69";      //sua senha de acesso
 
        connection = DriverManager.getConnection(url, username, password);
 
 
 
        //Testa sua conexão//  
 
        if (connection != null) {
 
            System.out.println("STATUS--->Conectado com sucesso!");
 
        } else {
 
            System.out.println("STATUS--->Não foi possivel realizar conexão");
 
        }
 
 
 
        return connection;
 
  
 
        } catch (Exception e) {  
 
  
        	e.printStackTrace();
 
            return null;
 
        } 
 
  
 
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
