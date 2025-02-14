package conta;

import java.util.Scanner;

import conta.model.Conta;
import contaUtil.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {

		// Teste da Classe Conta

		//Conta c1 = new Conta(1, 123, 1, "Adriana", 10000.0f);
		//c1.visualizar();
		//c1.sacar(12000.0f);
		//c1.visualizar();
		//c1.depositar(5000.0f);
		//c1.visualizar();
		
		// Teste da classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "Inácio", 15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
	    cc1.visualizar();
	    cc1.depositar(5000.0f);
	    cc1.visualizar();
	    
	    // Teste da classe Conta Poupança
	    ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Itachi", 10000.0f, 15);
	    cp1.visualizar();
	    cp1.sacar(1000.0f);
	    cp1.visualizar();
	    cp1.depositar(5000.0f);
	    cp1.visualizar();
	    

		Scanner leia = new Scanner(System.in);
		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND
					+ "====================================================");
			System.out.println("                                                    ");
			System.out.println("                     ANNE'S BANK                    ");
			System.out.println("                                                    ");
			System.out.println("====================================================");
			System.out.println("                                                    ");
			System.out.println("               1 - Criar Conta                      ");
			System.out.println("               2 - Listar todas as contas           ");
			System.out.println("               3 - Buscar conta por número          ");
			System.out.println("               4 - Atualizar dados da conta         ");
			System.out.println("               5 - Apagar conta                     ");
			System.out.println("               6 - Saques                           ");
			System.out.println("               7 - Depósitos                        ");
			System.out.println("               8 - Transferências                   ");
			System.out.println("               9 - Sair                             ");
			System.out.println("                                                    ");
			System.out.println("====================================================");
			System.out.println("             Insira a opção desejada:               ");
			System.out.println("                                                    " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(
						Cores.TEXT_BLACK_BOLD + "\nAnne's Bank - descomplicando sua vida, um saldo de cada vez!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Criar conta\n\n");
				break;

			case 2:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Listar todas as contas \n\n");
				break;

			case 3:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Consultar dados da Conta - por número\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Atualizar dados da conta\n\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Apagar a conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Saque\n\n");
				break;

			case 7:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Depósito\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Transferência entre contas\n\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida");
				break;

			}
		}

	}

	public static void sobre() {
		System.out.println("\n***************************************************************");
		System.out.println("            Projeto Desenvolvido por: Larissa Mata            ");
		System.out.println("            Generation Brasil - larissa.smata@hotmail.com            ");
		System.out.println("            https://github.com/larissamata/contaBancaria            ");
		System.out.println("\n***************************************************************");
	}
}
