/*package br.edu.positivo.sistemweb.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.positivo.sistemweb.entity.Pedido;
import br.edu.positivo.sistemweb.service.PedidoService;
@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanPedido")
@SessionScoped
public class MbeanPedido {

	@EJB
	PedidoService pedidoService;
	
	private List<Pedido> pedidos = new ArrayList<>();
	private Integer id;
	
	@PostConstruct
	public void listar() {
		pedidos = pedidoService.listar();
	}
	
	public void finalizar() {
		Pedido pedido = new Pedido();
		pedido.setId(id);
		pedidos.add(pedido);
		
		listar();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}*/
