package ifsc.poo.atendimento;

public class Solicitacao {
    private String categoria;
    private String descricao;
    private String[] categorias =
    {
     "suporte técnico",
     "informação",
     "atendimento financeiro"
    };


    public Solicitacao(String categoria, String descricao){
        if(!(setCategoria(categoria) && setDescricao(descricao))){
            this.categoria = "";
            this.descricao = "";
        }
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

    public boolean solicitacaoEhValida(){
        return !(this.categoria.isEmpty() && this.descricao.isEmpty());
    }
}
