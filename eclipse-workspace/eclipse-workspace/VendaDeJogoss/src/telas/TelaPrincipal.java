package telas;

import java.util.Scanner;

public class TelaPrincipal {

public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		for (;;) {
			System.out.println("Bem vindo ao Loja de Jogos: ");
			System.out.println("Digite 1 para jogo:");
			System.out.println("Digite 2 para console: ");
			System.out.println("Digite 3 para cliente:");
			System.out.println("Digite 4 para sair:");
			
			int opcao = sc.nextInt();
			
			if(opcao==1) {
				new TeladeJogos().mostrarmenu();
			}
			if(opcao==2) {
				new TeladeConsoles().mostrarmenu();
			}
			if(opcao==3) {
				new TelaCliente().mostrarmenu();
			}
			if(opcao==4) {
				
			}
	
		}
	}
}
