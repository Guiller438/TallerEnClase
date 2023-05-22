import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private JTabbedPane tabbedPane1;
    private JTextField txttitulo;
    private JTextField txtpaginas;
    private JButton agregarButton;
    private JTextArea areaagregar;
    private JPanel mainPanel;
    private JTextArea agregaarrea;
    private JTextField textField1;
    private JTextField txtcodigo;
    private JButton eliminarPorTituloButton;
    private JButton eliminarPorIDButton;
    private JTextField paginastotal;
    private JButton calcularButton;

    Library library = new Library();
    public Ventana() {

        library.DatosPredefinidos();
        agregaarrea.setText(library.toString());
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book b = new Book(Integer.parseInt(txtpaginas.getText()), txttitulo.getText());
                b.setID(library.getsize() + 1);
                if(library.Repetidos(b)){
                    library.addBook(b);
                    agregaarrea.setText(library.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "El libro ya existe");
                }
            }
        });

        eliminarPorTituloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               library.sortByID();
               if(library.searchByTitle(txttitulo.getText()) != null) {
                   JOptionPane.showMessageDialog(null, "El libro se elimino");
                   agregaarrea.setText(library.toString());
               }else{
                     JOptionPane.showMessageDialog(null, "El libro no existe");
               }
            }
        });
        eliminarPorIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                library.sortByID();
                if(library.searchByID(Integer.parseInt(txtcodigo.getText()))) {
                    JOptionPane.showMessageDialog(null, "El libro se elimino" );
                    agregaarrea.setText(library.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "El libro no existe");
                }
            }
        });
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                library.sortByID();
                JOptionPane.showMessageDialog(null, "El total de paginas es: " + library.totalPaginas(library.getsize()-1, library.getBooks()));
                paginastotal.setText(String.valueOf(library.totalPaginas(library.getsize()-1, library.getBooks())));
            }
        });
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
