package ifsc.poo.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class Livro {
    private String titulo;
    private String ISBN;
    private static int next_ISBN;
    private int qtd;
    private boolean ehValido;

    public Livro(String titulo){
        if(!(setTitulo(titulo) || setISBN())){
            this.titulo = "";
            this.ISBN = "";
            this.ehValido = false;
            this.qtd = -1;
        } else {
            this.qtd = 1;
            this.ehValido = true;
        }
    }

    public Livro(String titulo, int qtd){
        if(!(setTitulo(titulo) || setISBN()) || setQtd(qtd)){
            this.titulo = "";
            this.ISBN = "";
            this.ehValido = false;
            this.qtd = -1;
        }
        this.ehValido = true;
    }

    public boolean setTitulo(String titulo) {
        if(titulo.isEmpty()){
            return false;
        }
        this.titulo = titulo;
        return true;
    }

    private boolean setISBN(){
        if(next_ISBN > 1000000000){
        this.ISBN = String.format("%09d", next_ISBN);
        next_ISBN++;
        return true;
        }
        return false;
    }

    public boolean setQtd(int qtd){
        if(qtd < 0){
            return false;
        }
        this.qtd = qtd;
        return true;
    }

    public boolean pegarLivro(int qtd){
        if(!((this.qtd - qtd >= 0) || qtd > 0)){
            return false;
        }
        this.qtd -= qtd;
        return true;
    }

    public boolean devolverLivro(int qtd){
        if(!(qtd > 0)) {
            return false;
        }
        this.qtd += qtd;
        return true;
    }
}
