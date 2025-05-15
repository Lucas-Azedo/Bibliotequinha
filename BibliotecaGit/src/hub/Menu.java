package hub;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
	Scanner sc = new Scanner(System.in);
	static LivroFactory build = new LivroFactory();
	
	public int mostrarMenu(){
		System.out.println("---MENU---\n1. Cadastrar Livro\n2. Pesquisar Livros\n3. Pesquisar livro por codigo\n4. Editar Livro\n5. Delete\n0. Sair");
		return sc.nextInt();

	}
	
	public void createLivro() {
		String sub1, sub2;
		int sub3;
		
		sc.nextLine();
		System.out.println("Insira o titulo do livro: ");
		sub1 = sc.nextLine();

		System.out.println("Insira o autor do livro: ");
		sub2 = sc.nextLine();
		
		System.out.println("Insira o ano de lancamento do livro: ");
		sub3 = sc.nextInt();
		
		sub1 = sub1.toUpperCase();
		sub2 = sub2.toUpperCase();
		
		build.create(sub1, sub2, sub3);	
	}
	
	public void readLivro() {
		int code;
		boolean encontrado = false;
		
		sc.nextLine();
		System.out.println("Insira o codigo do livro: ");
		code = sc.nextInt();
;		
		for(Livro livro : build.getLivros()) {
			if (livro.getCode() == code) {
				System.out.println(livro.toString());
				encontrado = true;
			}
		}
		if(!encontrado) {
			System.out.println("Livro nao encontrado");
		}
	}
	
	public void updateLivro() {
		int code, op, upI;
		String up;
		boolean encontrado = false;
		
		sc.nextLine();
		System.out.println("Insira o codigo do livro: ");
		code = sc.nextInt();
		
		for(Livro i : build.getLivros()) {
			if (i.getCode() == code) {
				System.out.println(i.toString());
				encontrado = true;
				
				sc.nextLine();
				System.out.println("Insira o que sera editado\n1. Titulo\\n2. Autor\\n3. Ano de lancamento");
				op = sc.nextInt();
				System.out.println("Insira o dado: ");
				
				switch(op) {
				case 1:
	
					sc.nextLine();
					up = sc.nextLine();
					up = up.toUpperCase();
					
					i.setTitulo(up);
					break;
			
				case 2:
					sc.nextLine();
					up = sc.nextLine();
					up = up.toUpperCase();
					
					i.setAutor(up);
					break;
					
				case 3:
					upI = sc.nextInt();
					
					i.setAno(upI);
					break;
				}
				
				System.out.println(i.toString());
				break;
			}
		}
		
		
		if(!encontrado) {
			System.out.println("Livro nao encontrado");
		}
		
	}
	
	public void deleteLivro() {
		int code;
		boolean encontrado = false, confirm;
		
		System.out.println("Insira o codigo do livro: ");
		code = sc.nextInt();
		sc.nextLine();
		
		for(Livro i : build.getLivros()) {
			
			if (i.getCode() == code) {
				encontrado = true;
				
				System.out.println(i.toString());
				System.out.println("Tem certeza que deseja deletar? true/false ");
				confirm = sc.nextBoolean();
				
				if(confirm) {
					System.out.println("Livro removido com sucesso");
					build.delete(i);
				}
				else {
					System.out.println("Remocao cancelada");
				}
				break;
			}
		}
		
		if(!encontrado) {
			System.out.println("Livro nao encontrado");
		}
	}
	
	public void searchLivro() {
		
	    ArrayList<Livro> resultados = new ArrayList<>();
		
		String termo;
		int termoI, op;
		boolean encontrado = false;
		
		System.out.println("Deseja procurar por:\n1. Titulo\n2. Autor\n3. Ano de lancamento");
		op = sc.nextInt();
		System.out.println("Insira o dado: ");
		
		switch(op) {
		case 1:
				
				sc.nextLine();
				termo = sc.nextLine();
				termo = termo.toUpperCase();
				
				for(Livro i : build.getLivros()) {
					
					if (i.getTitulo().contains(termo)) {
						encontrado = true;
				        resultados.add(i);
					}
				}
				break;
				
		case 2:
			sc.nextLine();
			termo = sc.nextLine();
			termo = termo.toUpperCase();
			
			for(Livro i : build.getLivros()) {
				
				if (i.getAutor().contains(termo)) {
					encontrado = true;
			        resultados.add(i);
				}
			}
			break;
			
		case 3: 
			termoI = sc.nextInt();
			
			for(Livro i : build.getLivros()) {
				
				if (i.getAno() == termoI) {
			        resultados.add(i);
					encontrado = true;
				}
			}
			break;
		}
		if (encontrado == true) {
			for (Livro livro : resultados) {
	            System.out.println(livro);
	        }
			
		}
		else {
			System.out.println("Livro nao encontrado");
		}
	}
}
