package ifsc.poo.biblioteca;

import java.util.LinkedHashSet;
import java.util.Set;

public class Autor {
    private String nome;
    private String idioma;
    private Set<Livro> livros = new LinkedHashSet<>();


    public boolean setNome(String nome){
        if(nome.isEmpty()){
            return false;
        }
        this.nome = nome;
        return true;
    }

    public boolean setIdioma(String idioma){
        if(idioma.isEmpty()){
            return false;
        }
        this.idioma = idioma;
        return true;
    }
}
