package ifsc.poo.atendimento;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Gerenciador {
    private Queue<Cliente> fila = new LinkedList<>();
    private Map<String, Cliente> clientes = new HashMap<>();

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

    public boolean proximo_cliente(){
        if(fila.isEmpty()){
            return false;
        }
        Cliente cliente = fila.element();
        fila.remove();

        return true;
    }
}
