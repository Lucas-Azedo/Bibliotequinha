package hub;

public class Livro {
	
	private static int contador = 0;
	
	private String titulo;
	private String autor;
	private int ano;
	private int code;
	
	public Livro(String titulo, String autor, int ano){
		contador++;
		
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.code = contador;
	}

	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	@Override
	public String toString() {
		return String.format("Código: %d | Título: %s | Autor: %s | Ano: %d", code, titulo, autor, ano);
	}
}
