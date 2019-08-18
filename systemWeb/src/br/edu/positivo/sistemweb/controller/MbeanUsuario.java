package br.edu.positivo.sistemweb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.OneToMany;
import javax.servlet.http.Part;

import br.edu.positivo.sistemweb.entity.Pedido;
import br.edu.positivo.sistemweb.entity.Usuario;
import br.edu.positivo.sistemweb.service.UsuarioService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanUsuario")
@RequestScoped
public class MbeanUsuario {

	@EJB
	UsuarioService usuarioService;


	private List<Usuario> usuarios;

	private Integer id;
	private String nome;
	private String login;


	private Part foto;

	@OneToMany
	(mappedBy = "usuario")
	private List<Pedido> pedidos;
	
	@PostConstruct
	public void listar() {
		usuarios = usuarioService.listar();
	}

	public void salvar() {
		try {

			String caminhoDaImagem = salvarFoto(foto);

			Usuario usuario = new Usuario();
			usuario.setId(id);
			usuario.setNome(nome);
			usuario.setLogin(login);
			usuario.setCaminhoDaImagem(caminhoDaImagem);

			usuarioService.salvar(usuario);

			id = null;
			nome = null;
			login = null;
			listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String salvarFoto(Part foto) throws Exception {
		if (foto != null && foto.getSubmittedFileName() != null) {
			byte[] arquivo = new byte[(int) foto.getSize()];
			foto.getInputStream().read(arquivo);

			String storage = "C:\\Users\\1814442\\" + "Desktop\\jean\\storageUsuario\\";
			// C:\\Users\\1814442\\Desktop\\jean\\storageUsuario\\<nome_do_arquivo>
			File file = new File(storage + foto.getSubmittedFileName());
			FileOutputStream out = new FileOutputStream(file);
			out.write(arquivo);
			out.close();

			return storage + foto.getSubmittedFileName();
		}
		return null;
	}

	public String excluir(Usuario usuario) {
		usuarioService.remove(usuario);
		listar();
		return "";
	}

	public String carregar(Usuario usuario) {

		this.id = usuario.getId();
		this.login = usuario.getLogin();
		this.nome = usuario.getNome();
		return "";
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Part getFoto() {
		return foto;
	}

	public void setFoto(Part foto) {
		this.foto = foto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
