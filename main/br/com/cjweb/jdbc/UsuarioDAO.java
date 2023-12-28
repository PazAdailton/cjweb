package br.com.cjweb.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cjweb.entidade.Usuario;

public class UsuarioDAO {

	
	
	private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrar(Usuario usu) {
		
		String sql = "insert into usuario(nome,login, senha) values (?,?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome()); //substitui a "?" pelos dados do usuario
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			
		//executando o comando sql no banco
			preparador.execute();
			//fechando o preparador
			preparador.close();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public void alterar(Usuario usu) {
		String sql = "update usuario set nome=?, login=?, senha=? where id=?";
		
		try 
			(PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
		    
			preparador.execute();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id=?";	
		
		try 
		(PreparedStatement preparador = con.prepareStatement(sql)) {
		preparador.setInt(1, usu.getId());
	    
		preparador.execute();
	
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
	}
	
	public void salvar(Usuario usuario) {
 		if(usuario.getId()!= null) {	
			alterar(usuario);
		}else {
			cadastrar(usuario);	
		}
		
	}
	
	/*Busca de um registro no bando de dados pelo número do id do usuario   */
	/* Return um objeto usuario quando encontra ou  nulo quando não encontra */
	public Usuario buscarPorId(Integer id) {
		
		String sql = "Select * from usuario where id=?";
		
		try 
			(PreparedStatement preparador = con.prepareStatement(sql)) {
				
			preparador.setInt(1, id);
			
			
			ResultSet resultado = preparador.executeQuery();
			
			//cursor do primeiro registro
			if(resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
			
				return usuario;
			}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	 /* Realiza a busca de todos registros da tabela de usuários
	  * return uma lista de objetos de Usuario 
	  */
       public List<Usuario> buscarTodos() {
		
		String sql = "Select * from usuario";
		List<Usuario> lista = new ArrayList<Usuario>();
		
		
		try 
			(PreparedStatement preparador = con.prepareStatement(sql)) {
					
			ResultSet resultado = preparador.executeQuery();
			
			//cursor do primeiro registro
			while(resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
			
				lista.add(usuario);
				
			}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
		
	}
	
       
       public Usuario autenticar(Usuario usuConsulta) {
    	   
    	String sql = "select * from usuario where login=? and senha=?" ;
    	
    	try 
			(PreparedStatement preparador = con.prepareStatement(sql)){
    		preparador.setString(1, usuConsulta.getLogin());
    		preparador.setString(2, usuConsulta.getSenha());
    		ResultSet resultado = preparador.executeQuery();
    		
    		if(resultado.next()) {
    		Usuario usuario = new Usuario();
    		usuario.setId(resultado.getInt("id"));
    		usuario.setNome(resultado.getString("nome"));
    		usuario.setLogin(resultado.getString("login"));
    		usuario.setSenha(resultado.getString("senha"));
    		
    		return usuario;
    		
    		}
    	
    	} catch (Exception e) {
			
    	}
    		return null;
    	   
    	
       }
	
}
