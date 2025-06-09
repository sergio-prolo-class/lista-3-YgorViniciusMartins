package ifsc.poo.biblioteca;

import java.util.LinkedHashSet;
import java.util.Set;

public class Autor {
    private String nome; //Nome do autor
    private String idioma; //Idioma do autor
    private boolean ehValido; //True se o autor for válido, falso caso contrário
    private Set<Livro> livros = new LinkedHashSet<>(); //Armazena todos os livros vinculados a este autor

    public Autor(String nome, String idioma){ //Inicializa autor sem livros
        setIdioma(idioma); //Por algum motivo se apenas dentro do if, ele não seta o idioma
        if(!(setNome(nome) || setIdioma(idioma))){ //Se não conseguir setar os valores, inutiliza o autor
            this.nome = "";
            this.idioma = "";
            this.ehValido = false;
        }
        this.ehValido = true;
    }

    public Autor(String nome, String idioma, Livro livro){ //Inicializa autor com 1 livro
        if(!(setNome(nome) || setIdioma(idioma))){
            this.nome = "";
            this.idioma = "";
            this.ehValido = false;
        } else {
            if(livro.getEhValido()){
                livros.add(livro);
            }
            this.ehValido = true;
        }
    }

    public Autor(String nome, String idioma, Livro[] livro){ //Inicializa autor com N livros
        if(!(setNome(nome) || setIdioma(idioma))){
            this.nome = "";
            this.idioma = "";
            this.ehValido = false;
        } else {
            for (int i = 0; i < livro.length; i++) {
                if (livro[i].getEhValido()) {
                    livros.add(livro[i]);
                }
            }
            this.ehValido = true;
        }
    }

    public boolean setNome(String nome){
        if(nome.isEmpty()){ //Se nome for vazio, retorna falso
            return false;
        }
        this.nome = nome;
        return true;
    }

    public boolean setIdioma(String idioma){
        if(idioma.isEmpty()){ //Se Idioma for vazio, retorna falso
            return false;
        }
        this.idioma = idioma;
        return true;
    }

    public String getNome() {
        return this.nome;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public boolean getEhValido(){
        return this.ehValido;
    }

    public boolean vinculaLivro (Livro livro){
        if(!livro.getEhValido()){ //Se o livro for inválido, retorna falso
            return false;
        }
        livros.add(livro);
        return true;
    }

    public boolean vinculaLivro (Livro[] livro){
        boolean todos_validos = true; //Se não conseguir adcionar todos os livros retornará falso
        for (int i = 0; i < livro.length; i++) {
            if(!livro[i].getEhValido()){
                todos_validos = false;
                continue;
            }
            livros.add(livro[i]);
        }
        return todos_validos;
    }
}
