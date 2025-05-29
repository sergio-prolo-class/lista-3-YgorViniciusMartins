package ifsc.poo.biblioteca;

import java.util.*;

public class Gerenciador {
    private static Map<String, Livro> livros = new HashMap<>(); //chave: ISBN
    private static Map<String,Leitor> leitores = new HashMap<>(); //chave: id

    public boolean adcionarLivro(String titulo, String ISBN, String[] autores){
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

    public boolean emprestandoLivro(String ISBN,int qtd){
        if(!livros.containsKey(ISBN)){
            return false;
        }
        Livro livro = livros.get(ISBN);
        livro.pegarLivro(qtd);
        return true;
    }

    public boolean devolvendoLivro(String ISBN){
        if(!livros.containsKey(ISBN)){
            return false;
        }
        Livro livro = livros.get(ISBN);
        livro.devolverLivro(1);
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
}
