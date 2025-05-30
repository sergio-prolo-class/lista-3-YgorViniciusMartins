package ifsc.poo.biblioteca;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Leitor {
    private String nome;
    private String endereco;
    private String telefone;
    private String id;
    private boolean ehValido;
    private static int next_id = 0;
    private Set<String> livros = new LinkedHashSet<>(); //Armazena ISBN

    public Leitor(String nome, String endereco, String telefone){
        if(!(setNome(nome) || setEndereco(endereco) || setTelefone(telefone))){
            this.nome = "";
            this.endereco = "";
            this.telefone = "";
            this.ehValido = false;
        }
        setId();
        this.ehValido = true;
    }

    public boolean setNome(String nome){
        if(nome.isEmpty()){
            return false;
        }
        this.nome = nome;
        return true;
    }

    public boolean setEndereco(String endereco){
        if(endereco.isEmpty()){
            return false;
        }
        this.endereco = endereco;
        return true;
    }

    public boolean setTelefone(String telefone){
        if(telefone.isEmpty()){
            return false;
        }
        this.telefone = telefone;
        return true;
    }

    private boolean setId(){
        this.id = String.format("%05d", next_id);
        next_id++;
        return true;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public String getId(){
        return this.id;
    }

    public boolean getEhValido(){
        return this.ehValido;
    }

    public void pegaLivro(String ISBN){
        livros.add(ISBN);
    }

    public void devolveLivro(String ISBN){
        livros.remove(ISBN);
    }

    public boolean possuiLivro(String ISBN){
        return livros.contains(ISBN);
    }

    public int getQtdLivros(){
        return this.livros.size();
    }
}
