package ifsc.poo.atendimento;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Cliente {
    private String nome;
    private String numero_telefone;
    private Queue<Solicitacao> solicitacoes = new LinkedList<>();
    private int qtd_solicitacoes;

    public Cliente(String nome, String numero_telefone, String categoria, String descricao){
        Solicitacao solicitacao = new Solicitacao(categoria, descricao);
        if(!(setNome(nome) && setNumeroTelefone(numero_telefone) && solicitacao.solicitacaoEhValida())){
            this.nome = "";
            this.numero_telefone = "";
        }
        this.solicitacoes.add(solicitacao);
        this.qtd_solicitacoes++;
    }

    public boolean setNome(String nome){
        if(nome.isEmpty()){
            return false;
        }
        this.nome = nome;
        return true;
    }

    public boolean setNumeroTelefone(String numero_telefone){
        if(numero_telefone.isEmpty()){
            return false;
        }
        this.numero_telefone = numero_telefone;
        return true;
    }

    public String getNome(){
        return this.nome;
    }

    public String getNumero_telefone(){
        return  this.numero_telefone;
    }

    public boolean novaSolicitacao(String categoria, String descricao){
        Solicitacao solicitacao = new Solicitacao(categoria, descricao);
        if(!(solicitacao.solicitacaoEhValida())){
            return false;
        }
        this.solicitacoes.add(solicitacao);
        this.qtd_solicitacoes++;
        return true;
    }

    public int getQtd_solicitacoes(){
        return this.qtd_solicitacoes;
    }

    public boolean clienteEhValido(){
        return !(this.nome.isEmpty() && this.numero_telefone.isEmpty());
    }

}
