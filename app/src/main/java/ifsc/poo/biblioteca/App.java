package ifsc.poo.biblioteca;

import java.util.LinkedHashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Gerenciador gerenciador = new Gerenciador();
        Set<String> ids = new LinkedHashSet<>();
        Set<String> isbn = new LinkedHashSet<>();


        //Adicionando leitores
        gerenciador.cadastroLeitor("B", "b" , "987654321");
        gerenciador.cadastroLeitor("A", "a" , "123456789");
        gerenciador.cadastroLeitor("C", "c" , "135792468");
        //Adicionando autores
        gerenciador.adcionaAutor("B ", "b");
        gerenciador.adcionaAutor("Z", "z");
        gerenciador.adcionaAutor("X", "x");
        gerenciador.adcionaAutor("V", "v");


        Autor[] autores_ex = new Autor[2];
        autores_ex[0] = gerenciador.getAutor("Z");
        autores_ex[1] = gerenciador.getAutor("X");
        //Adicionando livrosd
        gerenciador.adcionarLivro("L", "0001", gerenciador.getAutor("Z"));
        gerenciador.adcionarLivro("K", "0002", gerenciador.getAutor("X"));
        gerenciador.adcionarLivro("J", "0003", gerenciador.getAutor("V"), 0);
        gerenciador.adcionarLivro("H", "0004", gerenciador.getAutor("B"));
        gerenciador.adcionarLivro("G", "0005", gerenciador.getAutor("X"));
        gerenciador.adcionarLivro("F", "0006", autores_ex);
        //Obtendo ids
        ids = gerenciador.getTodosIds();
        System.out.println("IDS dos leitores: ");
        ids.forEach((id) -> System.out.println(id));
        //Obtendo isbn
        isbn = gerenciador.getTodosISBN();
        System.out.println("ISBNs dos livros: ");
        isbn.forEach((ISBN -> System.out.println(ISBN)));

        Leitor leitor1 = gerenciador.getLeitor("00000"); //Utilizando a chave inicial com exemplo
        Leitor leitor2 = gerenciador.getLeitor("00001");
        Leitor leitor3 = gerenciador.getLeitor("00002");

        //Aqui vemos que o leitor é capaz de portar até 5 livros
        System.out.println("Leitor 1 conseguiu pegar o livro 0001? " + gerenciador.emprestandoLivro("0001", leitor1));
        System.out.println("Leitor 1 conseguiu pegar o livro 0002? " + gerenciador.emprestandoLivro("0002", leitor1));
        System.out.println("Leitor 1 conseguiu pegar o livro 0003? " + gerenciador.emprestandoLivro("0003", leitor1));
        System.out.println("Leitor 1 conseguiu pegar o livro 0003? " + gerenciador.emprestandoLivro("0003", leitor1));
        System.out.println("Leitor 2 conseguiu pegar o livro 0003? " + gerenciador.emprestandoLivro("0003", leitor2));
        System.out.println("Leitor 3 conseguiu pegar o livro 0003? " + gerenciador.emprestandoLivro("0003", leitor3));
        System.out.println("Leitor 1 conseguiu pegar o livro 0004? " + gerenciador.emprestandoLivro("0004", leitor1));
        System.out.println("Leitor 1 conseguiu pegar o livro 0005? " + gerenciador.emprestandoLivro("0005", leitor1));
        System.out.println("Leitor 1 conseguiu pegar o livro 0006? " + gerenciador.emprestandoLivro("0006", leitor1));
        System.out.println("Leitor 1 conseguiu devolver o livro 0005? " + gerenciador.devolvendoLivro("0005", leitor1));
        System.out.println("Leitor 1 conseguiu pegar o livro 0006? " + gerenciador.emprestandoLivro("0006", leitor1));

        System.out.println("Autores ordenados: ");
        gerenciador.listaAutoresOrdenados();

        System.out.println("Autores ordenados: ");
        gerenciador.listaLeitoresOrdenadosNome();

        System.out.println("Leitores ordenados por ID: ");
        gerenciador.listaLeitoresOrdenadosId();

        System.out.println("Livros ordenados por Título: ");
        gerenciador.listaLivrosOrdenadosTitulo();

        System.out.println("Livros ordenados por ISBN: ");
        //gerenciador.listaLivrosOrdenadosISBN();




    }


}
