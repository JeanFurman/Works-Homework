package br.edu.positivo.sistemweb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.positivo.sistemweb.entity.Jogo;
import br.edu.positivo.sistemweb.service.JogoService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanIndex")
@RequestScoped
public class MbeanIndex {

	@EJB
	JogoService jogoService;

	private List<Jogo> jogos;

	private Integer idPerfil;

	@PostConstruct
	public void listar() {
		jogos = jogoService.listar();
	}

	public void filtrar() {
		if(idPerfil == null) 
		{
			jogos = jogoService.listar();
		}
		else
		{
			jogos = jogoService.listar(idPerfil);
		}
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

}
