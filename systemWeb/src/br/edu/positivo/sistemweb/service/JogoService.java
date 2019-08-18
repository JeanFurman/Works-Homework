package br.edu.positivo.sistemweb.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.positivo.sistemweb.entity.Jogo;

@Local
public interface JogoService {

	public void salvar(Jogo jogo);
	public List<Jogo> listar();
	public void remove(Jogo jogo);
	public List<Jogo> listar(Integer idPerfil);
	
}
