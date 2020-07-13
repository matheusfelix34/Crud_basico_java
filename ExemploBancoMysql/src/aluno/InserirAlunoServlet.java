package aluno;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InserirAlunoServlet
 */

public class InserirAlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirAlunoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		//Instanciar um objeto do tipo JavaBean que representa a tabela (ou entidade) e preencher os atributos dessa classe 
		
		try{ 
			inserir(nome, endereco, codigo);
		} catch(SQLException ex){
			ex.printStackTrace();
			
			response.getOutputStream().println("Ops.... aconteceu um erro na inclusão!");
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
	
	
	
	private void inserir (String nome, String endereco, int codigo) throws SQLException {
			
			 
								 
					Connection connection = getConexaoMySQL();
			            
			
			
		            Statement statement = connection.createStatement();
			
			            
		            String inserir = "Insert into aluno.usuario values ("+codigo+",'"+nome+"','"+endereco+"')";
			            
			            
			        statement.execute(inserir);
			
			        statement.close();    
			          
			        connection.close();
			
			 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
