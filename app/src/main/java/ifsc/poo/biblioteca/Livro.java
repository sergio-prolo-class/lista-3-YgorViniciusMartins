package ifsc.poo.biblioteca;

import java.util.*;

public class Livro {
    private String titulo;
    private String ISBN;
    private boolean ehValido;
    private static Map<String, Integer> livros = new HashMap<>();
    private Set<Autor> autores = new LinkedHashSet<>();

    public Livro(String titulo, String ISBN, Autor[] autores) {
        if (!(setTitulo(titulo) || setISBN(ISBN) || setAutores(autores))) {
            this.titulo = "";
            this.ISBN = "";
            this.ehValido = false;
        } else {
            if(!livros.containsKey(ISBN)) {
                livros.put(ISBN, 1);
            }
            this.ehValido = true;
        }
    }

    public Livro(String titulo, String ISBN, Autor[] autores, int qtd) {
        if (!(setTitulo(titulo) || setISBN(ISBN) || setQtd(qtd) || setAutores(autores))) {
            this.titulo = "";
            this.ISBN = "";
            this.ehValido = false;
        }
        this.ehValido = true;
    }

    public boolean setTitulo(String titulo) {
        if (titulo.isEmpty()) {
            return false;
        }
        this.titulo = titulo;
        return true;
    }

    public boolean setISBN(String ISBN) {
        if (ISBN.isEmpty()){
            return false;
        } if (!livros.containsKey(ISBN)){
            livros.put(ISBN, 0);
            return true;
        }
        return true;
    }

    public boolean setQtd(int qtd){
        if(qtd < 0){
            return false;
        }
        livros.put(this.ISBN, livros.get(ISBN) + qtd);
        return true;
    }

    public boolean setAutores(Autor[] autores){
        for (int i = 0; i < autores.length; i++) {
            this.autores.add(autores[i]);
        }
        return true;
    }

    public boolean pegarLivro(int qtd){
        if(!((livros.get(this.ISBN) - qtd >= 0) || qtd > 0)){
            return false;
        }
        livros.put(this.ISBN,livros.get(this.ISBN) - qtd);
        return true;
    }

    public boolean devolverLivro(int qtd){
        if(!(qtd > 0)) {
            return false;
        }
        livros.put(this.ISBN,livros.get(this.ISBN) + qtd);
        return true;
    }

    public int getQtd(){
        return livros.get(this.ISBN);
    }

    public String getISBN(){
        return this.ISBN;
    }

    public boolean getEhValido(){
        return this.ehValido;
    }
}
