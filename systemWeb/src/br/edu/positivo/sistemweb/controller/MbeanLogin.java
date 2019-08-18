package br.edu.positivo.sistemweb.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.edu.positivo.sistemweb.entity.Usuario;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanLogin")
@RequestScoped

public class MbeanLogin {
	private String email;
	private String senha;
	
	public String login(){
		//realizar a chamada para o service e procurar o cliente por login/senha
		
		Usuario usuario = new Usuario();
		usuario.setNome(email);
		usuario.setLogin(senha);
		
		if ("admin".equals(usuario.getNome())
	            && "123".equals(usuario.getLogin())) {
			//redirecionar para última página
			ExternalContext externalContext = FacesContext.
					getCurrentInstance().getExternalContext();
			((HttpServletRequest)externalContext.getRequest()).
				getSession().setAttribute("usuario", usuario);
			
			return "/protegido/carrinho.jsf?faces-redirect=true";
		}
		else 
		{
			return "login.jsf";
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
