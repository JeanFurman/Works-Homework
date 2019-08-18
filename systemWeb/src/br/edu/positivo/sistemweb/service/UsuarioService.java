package br.edu.positivo.sistemweb.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.positivo.sistemweb.entity.Usuario;

@Local
public interface UsuarioService {

	public void salvar(Usuario usuario);
	public List<Usuario> listar();
	public void remove(Usuario usuario);
	public Usuario getUsuarioById(Integer id);
}
