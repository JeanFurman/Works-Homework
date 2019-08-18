package Calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {

		int num=0;
		int num1;
		int num2;
		Scanner sc = new Scanner(System.in);
		while(num!=8)
		{		
			try {
				System.out.println("Digite 1 para soma:");
				System.out.println("Digite 2 para subtração:");
				System.out.println("Digite 3 para multiplicação:");
				System.out.println("Digite 4 para divisão:");
				System.out.println("Digite 5 para exponenciação:");
				System.out.println("Digite 6 para radiciação:");
				System.out.println("Digite 7 para bhaskara:");
				System.out.println("Digite 8 para sair:");
				num = sc.nextInt();
			}
			catch(InputMismatchException e){
				System.err.println("\nEntrada incorreta ou incompatível!");
				sc.nextLine();
			}
			
			
			switch (num)
			{
			case 1:
				try {
					num1=0;
					num2=0;
					System.out.println("Digite 2 números:");
					num1 = sc.nextInt();
					num2 = sc.nextInt();
					System.out.println("Resultado: " + (num1+num2));
				}catch(InputMismatchException e){
					System.err.println("Entrada incorreta ou incompatível!");
					sc.nextLine();
				}
				
				break;
			case 2:
				try {
					num1=0;
					num2=0;
					System.out.println("Digite 2 números:");
					num1 = sc.nextInt();
					num2 = sc.nextInt();
					System.out.println("Resultado: " + (num1-num2));
				}catch(InputMismatchException e){
					System.err.println("Entrada incorreta ou incompatível!");
					sc.nextLine();
				}
				break;
			case 3:
				try {
					num1=0;
					num2=0;
					System.out.println("Digite 2 números:");
					num1 = sc.nextInt();
					num2 = sc.nextInt();
					System.out.println("Resultado: " + (num1*num2));
				}catch(InputMismatchException e){
					System.err.println("Entrada incorreta ou incompatível!");
					sc.nextLine();
				}
				break;
			case 4:
				try {
					num1=0;
					num2=0;
					System.out.println("Digite 2 números:");
					num1 = sc.nextInt();
					num2 = sc.nextInt();
					System.out.println("Resultado: " + (num1/num2));	
				}catch(InputMismatchException e){
					System.err.println("Entrada incorreta ou incompatível!");
					sc.nextLine();
				}catch(ArithmeticException e){
	                System.err.println("O número do divisor deve ser diferente de 0!");
	            }
				break;
			case 5:
				try {
					num1=0;
					num2=0;
					System.out.println("Digite 2 números:");
					num1 = sc.nextInt();
					num2 = sc.nextInt(); 
					System.out.println("Resultado: " + Math.pow(num1, num2));
				}catch(InputMismatchException e){
					System.err.println("Entrada incorreta ou incompatível!");
					sc.nextLine();
				}
				break;
			case 6:
				try {
					num1=0;
					System.out.println("Digite 1 número:");
					num1 = sc.nextInt();
					double resultR = Math.sqrt(num1);
					System.out.println("Resultado: " + resultR);
				}catch(InputMismatchException e){
					System.err.println("Entrada incorreta ou incompatível!");
					sc.nextLine();
				}
				break;
			case 7:
				try {
					System.out.println("Digite 3 números:");
					int a = sc.nextInt();
					int b = sc.nextInt();
					int c = sc.nextInt();
					double delta = (b * b) + (-4 * (a * c));
					 
				        if (delta >= 0) {
				        	double x1 = (double) ((-(b) + Math.sqrt(delta)) / 2 * a);
				            double x2 = (double) ((-(b) - Math.sqrt(delta)) / 2 * a);
				     
				            System.out.println("x1 = " + x1);
				            System.out.println("x2 = " + x2);
				     
				        } else {
				            System.out.println("Delta não possui raiz!");
				        }
				}catch(InputMismatchException e){
					System.err.println("Entrada incorreta ou incompatível!");
					sc.nextLine();
				}
				break;
			default:
				break;
				
			}
		
		}
	}
}