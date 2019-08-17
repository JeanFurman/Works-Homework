package telas;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDao;
import dao.JogoDao;
import dao.PedidoDao;
import entidade.Cliente;
import entidade.Jogo;
import entidade.Pedido;

public class TeladeJogos {
	
	static Scanner sc = new Scanner(System.in);

	public void mostrarmenu() {
		
		System.out.println("Tela de Jogos:");
		System.out.println("1 - Cadastrar Jogo:");
		System.out.println("2 - Listar Jogo:");
		System.out.println("3 - Criar Pedido");
		System.out.println("4 - Listar Pedido por Cliente");
		System.out.println("5 - Sair");
		int opcao = sc.nextInt();
		
		switch (opcao) {
		
			case 1: 
				cadastrarJogo();
				break;
			case 2: 
				listarJogo();
				break;
			case 3:
				criarPedido();
				break;
			case 4:
				listarPedidoPorCliente();
				break;
			case 5:
				break;
			}
		
	}
	
	private void cadastrarJogo() {
		System.out.println("Informe o nome do jogo:");
		String nome = sc.next();
		
		System.out.println("Informe o desenvolvedor:");
		String desen = sc.next();
		
		System.out.println("Informe o gênero:");
		String genero = sc.next();
		
		System.out.println("Informe a quantidade:");
		Integer quant = sc.nextInt();
		
		System.out.println("Informe o preço:");
		Double preco = sc.nextDouble();
		
		Jogo jg = new Jogo();
		jg.setNome(nome);
		jg.setDesenvolvedor(desen);
		jg.setGenero(genero);
		jg.setQuantidade(quant);
		jg.setPreco(preco);
		
		new JogoDao().inserir(jg);
	
	}
	
	private static void listarPedidoPorCliente() {
		
		System.out.println("Digite o ID do cliente:");
		Integer idCliente = sc.nextInt();
		
		Cliente cliente = new ClienteDao().buscarPorId(idCliente);
		
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Pedidos:");
		for (Pedido pedido : cliente.getPedidos()) {
			if (pedido.getJogo()!= null) {
				System.out.println("Id...........: " + pedido.getId());
				System.out.println("Data.........: " + pedido.getData());
				System.out.println("Valor total..: " + pedido.getValorTotal());
				System.out.println("Jogo.........: " + pedido.getJogo().getNome());
				System.out.println();
			}
		}
		
	}
	
	private static void criarPedido() {
		
		System.out.println("Digite o ID do jogo:");
		Integer idJogo = sc.nextInt();
		
		Jogo jogo = new JogoDao().buscarPorId(idJogo);
		
		System.out.println("Digite o ID do cliente:");
		Integer idCliente = sc.nextInt();
		
		Cliente cliente = new ClienteDao().buscarPorId(idCliente);
		
		Pedido pedido = new Pedido();
		pedido.setJogo(jogo);
		pedido.setCliente(cliente);
		pedido.setData(LocalDate.now());
		pedido.setValorTotal(jogo.getPreco());
		
		new PedidoDao().inserir(pedido);		
	}
	
	private void listarJogo(){
		System.out.println("Lista de Jogos");
		
		List<Jogo> jogos = new JogoDao().listar();
		
		for(Jogo jg : jogos){
			System.out.println("ID:"+ jg.getId());
			System.out.println("Nome:"+ jg.getNome());
			System.out.println("Desenvolvedor:"+ jg.getDesenvolvedor());
			System.out.println("Gênero:"+ jg.getGenero());
			System.out.println();
		}
	}
}