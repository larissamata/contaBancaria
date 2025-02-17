package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import contaUtil.Cores;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia = 0, tipo, aniversario;
		String titular = "";
		float saldo = 0, limite;

		System.out.println("\nCriar Contas\n");
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 2, "Maria da Silva", 2000f, 100.f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();

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

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

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

				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o tipo da conta (1 - CC ou 2 - CP)");
					tipo = leia.nextInt();

				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo da conta: (R$) ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite de crédito:");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}

				case 2 -> {
					System.out.println("Digite o dia do aniversário da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Listar todas as contas \n\n");
				contas.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Consultar dados da Conta - por número\n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Atualizar dados da conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);
				if (buscaConta != null) {

					tipo = buscaConta.getTipo();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite de crédito (R$(: ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}

					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}
				} else {
					System.out.println("\nConta não encontrada");
				}

				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Apagar a conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Saque\n\n");
				keyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Depósito\n\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Transferência entre contas\n\n");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida");
				keyPress();
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

	public static void keyPress() {

		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
}