package hub;


public class Main {
	
	public static void main(String[] args) {	
		Menu menu = new Menu();
		
		int op; 
		
		do {
			op = menu.mostrarMenu();
			switch (op) {
			
			case 1:
				menu.createLivro();
				break;
				
			case 2:
				menu.searchLivro();
				break;
				
			case 3:
				menu.readLivro();
			}
			
		}while(op!= 0);

	}

}
