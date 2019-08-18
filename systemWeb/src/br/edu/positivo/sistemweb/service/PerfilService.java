package br.edu.positivo.sistemweb.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.positivo.sistemweb.entity.Perfil;
@Local
public interface PerfilService {

	public void salvar(Perfil perfil);
	public List<Perfil> listar();
	public void remove(Perfil perfil);
	public Perfil getPerfilById(Integer id);
	
}
