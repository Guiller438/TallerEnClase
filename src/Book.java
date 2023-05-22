public class Book {
    private int ID;
    private int numeroPaginas;
    private String titulo;

    public Book(int numeroPaginas, String titulo) {
        this.numeroPaginas = numeroPaginas;
        this.titulo = titulo;
    }

    public Book(int ID, int numeroPaginas, String titulo) {
        this.ID = ID;
        this.numeroPaginas = numeroPaginas;
        this.titulo = titulo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "\nID=" + ID + "\nnumeroPaginas=" + numeroPaginas + "\ntitulo=" + titulo;
    }

}
