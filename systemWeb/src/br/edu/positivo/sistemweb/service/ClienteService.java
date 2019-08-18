package br.edu.positivo.sistemweb.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.positivo.sistemweb.entity.Cliente;

@Local
public interface ClienteService {

	public void salvar(Cliente cliente);
	public List<Cliente> listar();
	public void remove(Cliente cliente);
	
}
