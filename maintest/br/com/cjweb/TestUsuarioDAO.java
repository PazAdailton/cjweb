package br.com.cjweb;

import java.util.List;

import br.com.cjweb.entidade.Usuario;
import br.com.cjweb.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		//testExcluir();
		//testCadastrar();
		//testSalvar();
		//testBuscarPorId();
		//testBuscarTodos();
		testAutenticar();
		
	}
			
	private static void testAutenticar() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		Usuario usu = new Usuario();
		usu.setLogin("jjj");
		usu.setSenha("jj");
		
		Usuario usuRetorno = usuDAO.autenticar(usu);
		System.out.println(usuRetorno);
		
	}

	private static void testBuscarPorId() {
		UsuarioDAO usuDAO = new UsuarioDAO();
	    Usuario usuario = 	usuDAO.buscarPorId(1);
	    System.out.println(usuario);
		
	}
	
	private static void testBuscarTodos() {
		UsuarioDAO usuDAO = new UsuarioDAO();
	    List<Usuario> lista = 	usuDAO.buscarTodos();
	    
	    for(Usuario u : lista) {
	    System.out.println(u);
	    
	    
	    }
	}

	
	public static void testExcluir() {
		//criando usuario
		Usuario usu = new Usuario();
		usu.setId(4);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
		
		System.out.println("Excluído com sucesso");
		
		
	}
	
	
	public static void testAlterar() {
		
		//criando usuario
		Usuario usu = new Usuario();
		
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
	
	public static void testSalvar() {
		Usuario usuario = new Usuario();
		usuario.setId(null);
		usuario.setNome("João");
		usuario.setLogin("ja");
		usuario.setSenha("jj");
		
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usuario);
		
		System.out.println("Salvo com sucesso");
	}
}
