package telas;

import java.util.List;
import java.util.Scanner;

import dao.ClienteDao;
import entidade.Cliente;

public class TelaCliente {

	Scanner sc = new Scanner(System.in);

	public void mostrarmenu() {

		System.out.println("Tela do Cliente:");
		System.out.println("1 - Cadastrar:");
		System.out.println("2 - Listar:");
		System.out.println("3 - Sair");
		int opcao = sc.nextInt();

		switch (opcao) {

		case 1:
			cadastrarCliente();
			break;
		case 2:
			listarCliente();
			break;
		default:
			break;
		}

	}
	
	private void listarCliente(){
		System.out.println("Lista de Clientes");
		
		List<Cliente> clientes = new ClienteDao().listar();
		
		for(Cliente clien : clientes){
			System.out.println("ID:"+ clien.getId());
			System.out.println("Nome:"+ clien.getNome());
			System.out.println("CPF:"+ clien.getCpf());
			System.out.println("RG:"+ clien.getRg());
			System.out.println("Sexo:"+ clien.getSexo());
			System.out.println("Telefone:"+ clien.getTelefone());
			System.out.println();
		}
	}

	private void cadastrarCliente() {
		
		Cliente clien = new Cliente() ;
			System.out.println("Informe o nome:");
			String nome = sc.next();
			
			System.out.println("Informe o CPF:");
			String cpf = sc.next();
			
			System.out.println("Informe o RG:");
			String rg = sc.next();

			System.out.println("Informe o sexo:");
			String sexo = sc.next();

			System.out.println("Informe o telefone:");
			String telefone = sc.next();
			
			
			clien.setNome(nome);
			clien.setCpf(cpf);
			clien.setRg(rg);
			clien.setSexo(sexo);
			clien.setTelefone(telefone);
			
			new ClienteDao().inserir(clien);
		
	}
	
}
