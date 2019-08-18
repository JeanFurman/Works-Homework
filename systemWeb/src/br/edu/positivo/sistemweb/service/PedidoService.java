package br.edu.positivo.sistemweb.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.positivo.sistemweb.entity.Pedido;

@Local
public interface PedidoService {

	public List<Pedido> listar();
	public void finalizar();
}
