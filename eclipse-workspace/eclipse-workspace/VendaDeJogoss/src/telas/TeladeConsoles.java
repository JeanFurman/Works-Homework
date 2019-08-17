package telas;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDao;
import dao.ConsoleDao;
import dao.PedidoDao;
import entidade.Cliente;
import entidade.Console;
import entidade.Pedido;
public class TeladeConsoles {

	static Scanner sc = new Scanner(System.in);

	public void mostrarmenu() {

		System.out.println("Tela de Consoles:");
		System.out.println("1 - Cadastrar Console:");
		System.out.println("2 - Listar Console:");
		System.out.println("3 - Criar Pedido");
		System.out.println("4 - Listar Pedido por Cliente");
		System.out.println("5 - Sair");
		int opcao = sc.nextInt();

		switch (opcao) {

		case 1:
			cadastrarConsole();
			break;
		case 2:
			listarConsole();
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
	
	private static void listarPedidoPorCliente() {
		
		System.out.println("Digite o ID do cliente:");
		Integer idCliente = sc.nextInt();
		
		Cliente cliente = new ClienteDao().buscarPorId(idCliente);
		
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Pedidos:");
		for (Pedido pedido : cliente.getPedidos()) {
			if (pedido.getConsole()!=null) {
				System.out.println("Id...........: " + pedido.getId());
				System.out.println("Data.........: " + pedido.getData());
				System.out.println("Valor total..: " + pedido.getValorTotal());
				System.out.println("Console......: " + pedido.getConsole().getNome());
				System.out.println();
			}
		}
		
	}
	
	private static void criarPedido() {
		
		System.out.println("Digite o ID do Console:");
		Integer idConsole = sc.nextInt();
		
		Console console = new ConsoleDao().buscarPorId(idConsole);
		
		System.out.println("Digite o ID do cliente:");
		Integer idCliente = sc.nextInt();
		
		Cliente cliente = new ClienteDao().buscarPorId(idCliente);
		
		Pedido pedido = new Pedido();
		pedido.setConsole(console);
		pedido.setCliente(cliente);
		pedido.setData(LocalDate.now());
		pedido.setValorTotal(console.getPreco());
		
		new PedidoDao().inserir(pedido);		
	}

	private void listarConsole() {
		System.out.println("Lista de Consoles");
		
		List<Console> consoles = new ConsoleDao().listar();
		
		for (Console cons : consoles) {
			System.out.println("ID:" + cons.getId());
			System.out.println("Nome:" + cons.getNome());
			System.out.println("Marca:" + cons.getMarca());
			System.out.println();
		}
	}

	private void cadastrarConsole() {
		System.out.println("Informe o nome do console:");
		String nome = sc.next();

		System.out.println("Informe a marca:");
		String marca = sc.next();
		
		System.out.println("Informe o preço:");
		Double preco = sc.nextDouble();

		Console cons = new Console();
		cons.setNome(nome);
		cons.setMarca(marca);
		cons.setPreco(preco);

		new ConsoleDao().inserir(cons);

	}
}
