package br.com.cjweb;

import br.com.cjweb.entidade.Usuario;
import br.com.cjweb.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		//testExcluir();
		testCadastrar();
		
	}
			
	public static void testExcluir() {
		Usuario usu = new Usuario();
		usu.setId(4);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
		
		System.out.println("Excluído com sucesso");
		
		
	}
	
	
	public static void testAlterar() {
		Usuario usu = new Usuario();
		
		  //criando usuario
		  usu.setId(4);
		  usu.setNome("Maria Silva");
		  usu.setLogin("mmm");
		  usu.setSenha("5555");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
		
		System.out.println("Alterado com sucesso");
			
		
	}
	
	public static void testCadastrar() {
		Usuario usu = new Usuario();
		
		  //criando usuario
		  usu.setNome("Maria");
		  usu.setLogin("mm");
		  usu.setSenha("555");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
		
		System.out.println("Cadastrado com sucesso");
			
			
		
		
	}
}
