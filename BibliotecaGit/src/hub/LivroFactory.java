package hub;
import java.util.ArrayList;

public class LivroFactory {
	private final ArrayList<Livro> livros = new ArrayList<>();
	
	public void create(String a, String b, int c) {
		Livro novo = new Livro(a, b, c);
		livros.add(novo);		
	}
	
	public ArrayList<Livro> getLivros(){
		return livros;
	}
	
	public void delete(Livro livro) {
		livros.remove(livro);
	}
	
}
