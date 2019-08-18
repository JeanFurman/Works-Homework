package br.edu.positivo.sistemweb.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.OneToMany;

import br.edu.positivo.sistemweb.entity.Pedido;
import br.edu.positivo.sistemweb.entity.Perfil;
import br.edu.positivo.sistemweb.service.PerfilService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanPerfil")
@RequestScoped
public class MbeanPerfil {


	@EJB
	PerfilService perfilService;

	private List<Perfil> perfis;

	private Integer id;
	private String nome;


	@OneToMany
	(mappedBy = "usuario")
	private List<Pedido> pedidos;
	
	@PostConstruct
	public void listar() {
		perfis = perfilService.listar();
	}

	public void salvar() {
		try {


			Perfil perfil = new Perfil();
			perfil.setId(id);
			perfil.setNome(nome);
	
			perfilService.salvar(perfil);

			id = null;
			nome = null;
			listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String excluir(Perfil perfil) {
		perfilService.remove(perfil);
		listar();
		return "";
	}

	public String carregar(Perfil perfil) {

		this.id = perfil.getId();
		this.nome = perfil.getNome();
		return "";
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

}
