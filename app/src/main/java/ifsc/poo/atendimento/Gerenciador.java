package ifsc.poo.atendimento;

import java.util.*;

public class Gerenciador {
    private Queue<Cliente> fila = new LinkedList<>();
    private Map<String, Cliente> clientes = new HashMap<>();
    private List<Cliente> clientes_atendidos = new ArrayList<>();

    public boolean nova_solicitacao(String nome, String num_telefone, String categoria, String descricao){
        Cliente cliente = new Cliente(nome, num_telefone, categoria, descricao);
        if(cliente.EhValido() && !clientes.containsKey(num_telefone)){
            return novo_cliente(cliente, num_telefone);
        } else if (cliente.EhValido()) {
            return nova_solicitacao(cliente, categoria, descricao);
        }
        return false;
    }

    private boolean novo_cliente(Cliente cliente, String num_telefone){
        fila.add(cliente);
        clientes.put(num_telefone, cliente);
        return true;
    }

    private boolean nova_solicitacao(Cliente cliente, String categoria, String descricao){
        fila.add(cliente);
        cliente.novaSolicitacao(categoria, descricao);
        return true;
    }

    public boolean chamaCliente(){
        if(fila.isEmpty()){
            return false;
        }
        Cliente cliente = fila.element();
        clientes_atendidos.add(cliente);
        fila.remove();

        return true;
    }

    public int getTamanhoFila(){
        return fila.size();
    }

    public String quemEhProximo(){
        if(fila.peek() != null) {
            return fila.peek().getNome();
        }
        return "";
    }

    public Set<String> listaNumeroClientesRegistrados(){
        Set<String> lista = new LinkedHashSet<>();
        clientes.forEach((numero, cliente) -> lista.add(numero));
        return lista;
    }

    public Set<String> listaNumerosClientesEsperando(){
        Set<String> lista = new LinkedHashSet<>();
        fila.forEach((cliente) -> lista.add(cliente.getNumero_telefone()));
        return lista;
    }

    public Set<String> nomesClientesAtendidos(){
        Set<String> nomes = new LinkedHashSet<>();
        clientes_atendidos.forEach((cliente) -> nomes.add(cliente.getNome()));
        return nomes;
    }

    public String geraRelatorio(){
        String relatorio;
        Solicitacao solicitacao = new Solicitacao(".",".");
        relatorio = "Número total de solicitações registradas: " + (fila.size() + clientes_atendidos.size()) + "\n";
        relatorio += "Número total de solicitações atendidas: " + clientes_atendidos.size() + "\n";
        relatorio += "Número total de solicitações em espera: " + fila.size() + "\n";

        relatorio += "Distribuição percentual:\n";
        String[] categorias = solicitacao.getCategorias();
        for (int i = 0; i < solicitacao.getQtdCategorias(); i++) {
            relatorio += categorias[i] + ": " + (((float)solicitacao.getNAparicoesCategoria(categorias[i]) / (fila.size() + clientes_atendidos.size()) * 100)) + "%" + "\n";
        }


        return relatorio;
    }
}
