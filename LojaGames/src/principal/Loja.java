package principal;

import java.util.ArrayList;
import java.util.Scanner;

import classe.Jogo;

public class Loja {

	public static ArrayList<Jogo> jogos = new ArrayList<>();
	private static Scanner scanf = new Scanner(System.in);
	static int id = 1;

	public static void main(String[] args) {
		int opcao;

		do {
			System.out.println("\n===== CADASTRO DE JOGOS =====");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("3 - Buscar por ID");
			System.out.println("4 - Atualizar");
			System.out.println("5 - Excluir");
			System.out.println("6 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanf.nextInt();
			scanf.nextLine();
			validarEscolha(opcao);

		} while (opcao != 6);

	}

	public static void validarEscolha(int escolha) {
		switch (escolha) {
		case 1:
			cadastroJogo();
			break;
		case 2:
			listarJogos();
			break;
		case 3:
			buscarId();
			break;
		case 4:
			atualizarJogo();
			break;
		case 5:
			excluirJogo();
			break;
		case 6:
			System.out.println("Encerrando o programa.");
			break;
		default:
			System.out.println("Opção invalida! Tente novamente");
		}

	}

	private static void excluirJogo() {
		int idBuscado;
		boolean achou = false;
		System.out.println("Digite o ID do jogo que quer excluir: ");
		idBuscado = scanf.nextInt();
		scanf.nextLine();

		for (Jogo jogo : jogos) {

			if (idBuscado == jogo.getId()) {
				jogos.remove(jogo);
				System.out.println("Jogo excluído com sucesso!");
				achou = true;
				break;
			}
		}

		if (!achou) {
			System.out.println("Jogo não encontrado");
		}
	}

	private static void atualizarJogo() {
		System.out.print("Digite o ID do jogo que deseja atualizar: ");
		int idBusca = scanf.nextInt();
		scanf.nextLine();
		boolean achou = false;

		for (Jogo jogo : jogos) {
			if (idBusca == jogo.getId()) {
				System.out.println("Novo nome:");
				jogo.setNome(scanf.nextLine());
				System.out.println("Novo gênero:");
				jogo.setGenero(scanf.nextLine());
				System.out.println("Jogo atualizado com sucesso!");
				achou = true;
			}
		}

		if (!achou) {
			System.out.println("Jogo não encontrado!");
		}

	}

	private static void listarJogos() {
		for (Jogo jogo : jogos) {
			jogo.exibir();
		}

	}

	private static void buscarId() {
		System.out.println("DIgite o ID:");
		int id = scanf.nextInt();
		scanf.nextLine();
		boolean achou = false;

		for (Jogo jogo : jogos) {
			if (id == jogo.getId()) {
				jogo.exibir();
				achou = true;
			}
		}

		if (!achou) {
			System.out.println("Jogo não encontrado!");
		}

	}

	private static void cadastroJogo() {
		Jogo jogo = new Jogo();
		jogo.setId(id++);
		System.out.println("Coloque o Nome");
		jogo.setNome(scanf.nextLine());
		System.out.println("Digite o genero");
		jogo.setGenero(scanf.nextLine());
		jogos.add(jogo);

	}

}
