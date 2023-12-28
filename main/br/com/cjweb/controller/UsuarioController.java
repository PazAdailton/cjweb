package br.com.cjweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cjweb.entidade.Usuario;
import br.com.cjweb.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UsuarioController() {
        super();
        //System.out.println("Novo Servlet");
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usu = new Usuario();
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);
		
		
		response.getWriter().print("sucesso");
	  //System.out.println("sucesso!");
	}

}
