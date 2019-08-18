package br.edu.positivo.sistemweb.controller;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.positivo.sistemweb.entity.Item;
import br.edu.positivo.sistemweb.entity.Jogo;
@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanCarrinho")
@SessionScoped
public class MbeanCarrinho {

	private List<Item> itens = new ArrayList<>();
	
	public String adicionar(Jogo jogo) {
		Item item = new Item();
		item.setQuantidade(1);
		item.setJogo(jogo);
		itens.add(item);
		return "/protegido/carrinho.jsf?faces-redirect=true";
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	
	
}
