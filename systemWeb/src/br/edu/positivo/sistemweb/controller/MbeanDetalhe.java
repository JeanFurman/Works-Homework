package br.edu.positivo.sistemweb.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.positivo.sistemweb.entity.Jogo;
import br.edu.positivo.sistemweb.service.JogoService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanDetalhe")
@SessionScoped
public class MbeanDetalhe {

	@EJB
	JogoService jogoService;
	
	private Jogo jogo;

	public String carregar(Jogo jogo) {
		this.jogo = jogo;
		return "detalhe.jsf";
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	
}
