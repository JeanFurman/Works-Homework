package br.edu.positivo.sistemweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.positivo.sistemweb.entity.Jogo;

/**
 * Servlet implementation class MeuPrimeiroServlet
 */
@WebServlet("/CarregarImagemJogo")
public class CarregarImagemJogo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="sistemaweb")
	EntityManager em;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request !=null && request.getParameter("idJogo") != null ){
			Integer idJogo = Integer.valueOf(request.getParameter("idJogo"));
			Jogo jogo = em.find(Jogo.class, idJogo);
			String caminhoDaImagem = jogo.getCaminhoDaImagem();
			
			File file = new File(caminhoDaImagem);
			byte []conteudoArquivo = new byte[(int) file.length()];
			FileInputStream fis = new FileInputStream(file);
			fis.read(conteudoArquivo);
			response.getOutputStream().write(conteudoArquivo);
			fis.close();
		}
	}

}
