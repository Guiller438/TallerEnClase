import java.util.ArrayList;

public class Library {
    ArrayList<Book> Books;

    public Library() {
        Books = new ArrayList<Book>();
    }


    public int CrearCodigo(ArrayList<Book> Books){
        int codigo = 0;
        for (int i = 0; i < Books.size(); i++) {
            codigo = Books.get(i).getID();
        }
        return codigo + 1;
    }
    //metodo getBooks
    public ArrayList<Book> getBooks() {
        return Books;
    }
    public void DatosPredefinidos(){
        Books.add(new Book(CrearCodigo(Books), 100, "El principito"));
        Books.add(new Book(CrearCodigo(Books),200, "El señor de los anillos"));
        Books.add(new Book(CrearCodigo(Books),300, "El hobbit"));
        Books.add(new Book(CrearCodigo(Books),400, "El arte de la guerra"));
        Books.add(new Book(CrearCodigo(Books),500, "El código da vinci"));
    }
    public boolean Repetidos(Book book) {
        boolean repetido = true;
        for (int i = 0; i < Books.size(); i++) {
            if (Books.get(i).getTitulo().equalsIgnoreCase(book.getTitulo())){
                return repetido = false;
            } else {
                return repetido = true;
            }
        }
        return repetido;
    }
    public void addBook(Book book) {
        Books.add(book);
    }

    public int getsize(){
        return Books.size();
    }

    //busqueda secuencial por titulo
    public Book searchByTitle(String s) {
        for(int i = 0; i < Books.size(); i++) {
            if(Books.get(i).getTitulo().replaceAll("\\s", "").equalsIgnoreCase(s.replaceAll("\\s", ""))) {
                return Books.remove(i);
            }
        }
        return null;
    }


    public boolean removeBookTitle(String s) {
        boolean removed = false;
        for(int i = 0; i < Books.size(); i++) {
            if(Books.get(i).getTitulo().replaceAll("\\s", "").equalsIgnoreCase(s.replaceAll("\\s", ""))) {
                  Books.remove(i);
                  removed = true;
            }
        }
        return removed;
    }

    public void sortByID(){
        for (int i = 0; i < Books.size(); i++) {
            for (int j = 0; j < Books.size() - 1; j++) {
                if (Books.get(j).getID() > Books.get(j + 1).getID()) {
                    Book temp = Books.get(j);
                    Books.set(j, Books.get(j + 1));
                    Books.set(j + 1, temp);
                }
            }
        }
    }

    public boolean searchByID(int c){
        boolean found = false;
        int min = 0;
        int max = Books.size() - 1;
        int med = (min + max)/2;
        while (min <= max){
            if (Books.get(med).getID() == c){
                Books.remove(med);
                return found = true;
            }else if (Books.get(med).getID() < c){
                min = max + 1;
            }else{
                min = med - 1;
            }
            med = (min + max)/2;
        }
        return found;
    }
    public int totalPaginas(int i,  ArrayList<Book> Books){
        if (i == 0){
            return Books.get(i).getNumeroPaginas();
        }else{
            return Books.get(i).getNumeroPaginas() + totalPaginas(i - 1, Books);
        }
    }


    @Override
    public String toString() {
        return "\n" + Books + "\n";
    }
}
