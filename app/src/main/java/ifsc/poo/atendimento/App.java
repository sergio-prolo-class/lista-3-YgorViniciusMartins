package ifsc.poo.atendimento;

import java.util.LinkedHashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Gerenciador gerenciador = new Gerenciador();

        gerenciador.nova_solicitacao("A", "123456789", "Suporte Técnico", "UwU");
        gerenciador.nova_solicitacao("B", "987654321", "informação", ">.<");
        gerenciador.nova_solicitacao("A", "123456789", "Suporte Técnico", "UwU");
        gerenciador.nova_solicitacao("C", "987456123", "atendimento financeiro", "OwO");

        System.out.println("+-----+-----+-----+-----+-----+-----+");

        System.out.println("Números dos clientes registrados:");
        gerenciador.listaNumeroClientesRegistrados().forEach(System.out::println);
        System.out.println("+-----+-----+-----+-----+-----+-----+");

        System.out.println("Atendendo clientes:");
        while (gerenciador.getTamanhoFila() != 0){
            System.out.println("Nome do próximo cliente: " + gerenciador.quemEhProximo());
            gerenciador.chamaCliente();
        }
        System.out.println("+-----+-----+-----+-----+-----+-----+");

        System.out.println("Nomes dos clientes atendidos:");
        gerenciador.nomesClientesAtendidos().forEach(System.out::println);
        System.out.println("+-----+-----+-----+-----+-----+-----+");

        System.out.println("Números dos clientes registrados:");
        gerenciador.listaNumeroClientesRegistrados().forEach(System.out::println);
        System.out.println("+-----+-----+-----+-----+-----+-----+");

        System.out.println("Números cliente esperando");
        gerenciador.nova_solicitacao("A", "135798642", "Suporte Técnico", "OMAGAAA");
        gerenciador.listaNumerosClientesEsperando().forEach(System.out::println);
        System.out.println("+-----+-----+-----+-----+-----+-----+");
        System.out.println(gerenciador.geraRelatorio());
    }
}
