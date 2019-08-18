package br.edu.positivo.sistemweb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

import br.edu.positivo.sistemweb.entity.Jogo;
import br.edu.positivo.sistemweb.entity.Perfil;
import br.edu.positivo.sistemweb.service.JogoService;
import br.edu.positivo.sistemweb.service.PerfilService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanJogo")
@RequestScoped
public class MbeanJogo {

	@EJB
	JogoService jogoService;
	
	@EJB
	PerfilService perfilService;
	
	private List<Jogo> jogos;
	private List<Perfil> perfis;
	
	private Integer id;
	private String nome;
	private String descricao;
	
	private Integer idPerfil;
	
	private Part foto;
		
	@PostConstruct
	public void listar() {
		jogos = jogoService.listar();
		perfis = perfilService.listar();
	}
	
	public void salvar() {
		try {
			Perfil perfilSelecionado = perfilService.getPerfilById(idPerfil);
			
			String caminhoDaImagem = salvarFoto(foto);
			
			Jogo jogo = new Jogo();
			jogo.setId(id);
			jogo.setNome(nome);
			jogo.setDescricao(descricao);
			jogo.setCaminhoDaImagem(caminhoDaImagem);
			jogo.setPerfil(perfilSelecionado);

			jogoService.salvar(jogo);
			
			id = null;
			descricao = null;
			nome = null;
			
			 listar();
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
	
	private String salvarFoto(Part foto) throws Exception {
		if (foto != null && foto.getSubmittedFileName() != null) {
			byte [] arquivo = new byte [(int) foto.getSize()];
			foto.getInputStream().read(arquivo);
			
			String storage = "C:\\Users\\1814442\\"
					+ "Desktop\\jean\\storageJogo\\";
			//C:\\Users\\1814442\\Desktop\\jean\\storageJogo\\<nome_do_arquivo>		
			File file = new File(storage + foto.getSubmittedFileName());
			FileOutputStream out = new FileOutputStream(file);
			out.write(arquivo);
			out.close();
			
			return storage + foto.getSubmittedFileName();
		} 
		return null;
	}

	public String excluir(Jogo jogo) {
		jogoService.remove(jogo);
		listar();
		return "";
	}
	
	public String carregar(Jogo jogo) {
		
		this.id = jogo.getId();
		this.descricao = jogo.getDescricao();
		this.nome = jogo.getNome();
		return "";
	}

	public Part getFoto() {
		return foto;
	}

	public void setFoto(Part foto) {
		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}


}
