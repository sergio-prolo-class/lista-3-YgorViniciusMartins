package ifsc.poo.atendimento;

import java.util.HashMap;
import java.util.Map;

public class Solicitacao {
    private String categoria;
    private String descricao;
    private String[] categorias =
    {
     "suporte técnico",
     "informação",
     "atendimento financeiro"
    };
    private boolean eh_valida;
    Map<String, Integer> n_solicitacoes_cada = new HashMap<>();


    public Solicitacao(String categoria, String descricao){
        if(!(setCategoria(categoria) && setDescricao(descricao))){
            this.eh_valida = false;
        }
        this.eh_valida = true;
        n_solicitacoes_cada.put(categoria, n_solicitacoes_cada.get(categoria) + 1);
    }

    public boolean setCategoria(String categoria) {
        if(!verificaCategoria(categoria)){
            return false;
        }
        this.categoria = categoria;
        return true;
    }

    public boolean setDescricao(String descricao) {
        if(descricao.isEmpty()){
            return false;
        }
        this.descricao = descricao;
        return true;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public String getDescricao(){
        return this.descricao;
    }

    private boolean verificaCategoria(String categoria){
        categoria = categoria.toLowerCase();
        for (int i = 0; i < categorias.length; i++) {
            if(categorias[i].equals(categoria)) {
                return true;
            }
        }
        return false;
    }

    public boolean EhValida(){
        return this.eh_valida;
    }
}
