package ifsc.poo.biblioteca;

import java.util.*;

public class Gerenciador {
    private static Map<String,Livro> livros = new HashMap<>(); //chave: ISBN
    private static Map<String,Leitor> leitores = new HashMap<>(); //chave: id
    private static Map<String,Autor> autores = new HashMap<>();
   private static Map<String,Emprestimo> emprestimos = new HashMap<>(); //chave: id

    public boolean adcionaAutor (String nome, String idioma){
        Autor autor = new Autor(nome, idioma);
        if(!autor.getEhValido()){
            return false;
        }
        autores.put(nome,autor);
        return true;
    }

    public boolean adcionarLivro(String titulo, String ISBN, Autor[] autores){
        Livro livro = new Livro(titulo, ISBN, autores);
        if(livros.containsKey(livro.getISBN())){
            return true;
        }
        if(!livro.getEhValido()){
            return false;
        }
        livros.put(livro.getISBN(), livro);
        return true;
    }

    public boolean adcionarLivro(String titulo, String ISBN, Autor[] autores, int qtd){
        Livro livro = new Livro(titulo, ISBN, autores, qtd);
        if(livros.containsKey(livro.getISBN())){
            return true;
        }
        if(!livro.getEhValido()){
            return false;
        }
        livros.put(livro.getISBN(), livro);
        return true;
    }

    public boolean adcionarLivro(String titulo, String ISBN, Autor autores){
        Livro livro = new Livro(titulo, ISBN, autores);
        if(livros.containsKey(livro.getISBN())){
            return true;
        }
        if(!livro.getEhValido()){
            return false;
        }
        livros.put(livro.getISBN(), livro);
        return true;
    }

    public boolean adcionarLivro(String titulo, String ISBN, Autor autores, int qtd){
        Livro livro = new Livro(titulo, ISBN, autores, qtd - 1);
        if(livros.containsKey(livro.getISBN())){
            return true;
        }
        if(!livro.getEhValido()){
            return false;
        }
        livros.put(livro.getISBN(), livro);
        return true;
    }

    public boolean emprestandoLivro(String ISBN, Leitor leitor){
        boolean a = !livros.containsKey(ISBN);
        boolean b = leitor.possuiLivro(ISBN);
        boolean c = leitor.getQtdLivros() >= 5;
        boolean d = livros.get(ISBN).getQtd() < 0;
        if(!livros.containsKey(ISBN) || leitor.possuiLivro(ISBN) || leitor.getQtdLivros() >= 5 || livros.get(ISBN).getQtd() < 0){
            return false;
        }
        Livro livro = livros.get(ISBN);
        livro.pegarLivro(1);
        leitor.pegaLivro(ISBN);
        return true;
    }

    public boolean devolvendoLivro(String ISBN, Leitor leitor){
        if(!livros.containsKey(ISBN) || !leitor.possuiLivro(ISBN)){
            return false;
        }
        Livro livro = livros.get(ISBN);
        livro.devolverLivro(1);
        leitor.devolveLivro(ISBN);
        return true;
    }

    public boolean cadastroLeitor(String nome, String endereco, String  telefone){
        Leitor leitor = new Leitor(nome, endereco, telefone);
        if(leitores.containsKey(leitor.getId())){
            return true;
        }
        if(!leitor.getEhValido()){
            return false;
        }
        leitores.put(leitor.getId(), leitor);
        return true;
    }

    public Set<String> getTodosIds(){
        Set<String> ids = new LinkedHashSet<>();
        leitores.forEach((id, leitor) -> ids.add(id));
        return ids;
    }

    public Set<String> getTodosISBN(){
        Set<String> ISBNs = new LinkedHashSet<>();
        livros.forEach((ISBN, livro) -> ISBNs.add(ISBN));
        return ISBNs;
    }

    public Autor getAutor(String nome){
        return autores.get(nome);
    }

    public Leitor getLeitor(String id){
        return leitores.get(id);
    }

    public void listaAutoresOrdenados(){
        Set<String> autores_ordenados = new TreeSet<>();
        autores.forEach((nome, autor) -> autores_ordenados.add(nome));
        autores_ordenados.forEach((nome) -> System.out.println(nome));
    }

    public void listaLeitoresOrdenadosId(){
        Set<String> leitores_ordenados = new TreeSet<>();
        leitores.forEach((id, leitor) -> leitores_ordenados.add(id));
        leitores_ordenados.forEach((id) -> System.out.println(id));
    }

    public void listaLeitoresOrdenadosNome(){
        Set<String> leitores_ordenados = new TreeSet<>();
        leitores.forEach((id, leitor) -> leitores_ordenados.add(leitor.getNome()));
        leitores_ordenados.forEach((nome) -> System.out.println(nome));
    }

    public void listaLivrosOrdenadosISBN(){
        Set<String> livros_ordenados = new TreeSet<>();
        livros.forEach((isbn, livro) -> livros_ordenados.add(isbn));
        livros_ordenados.forEach((isbn) -> System.out.println(isbn));
    }

    public void listaLivrosOrdenadosAutor(){
        Set<String> livros_ordenados = new TreeSet<>();
        livros.forEach((isbn, livro) -> livros_ordenados.add(livro.getNomesAutores()));
        livros_ordenados.forEach((nome) -> System.out.println(nome));
    }

    public void listaLivrosOrdenadosTitulo(){
        Set<String> livros_ordenados = new TreeSet<>();
        livros.forEach((isbn, livro) -> livros_ordenados.add(livro.getTitulo()));
        livros_ordenados.forEach((titulo) -> System.out.println(titulo));
    }
}
