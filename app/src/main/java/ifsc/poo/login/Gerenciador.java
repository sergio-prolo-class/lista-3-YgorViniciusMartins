package ifsc.poo.login;

import java.util.LinkedHashMap;
import java.util.Map;

public class Gerenciador {
    private static Map<String, String> usuarios = new LinkedHashMap<>();

    public static boolean cadastraUsuario(String login, String senha){
        if(usuarios.containsKey(login)){
            return false;
        }
        Usuario usuario = new Usuario(login, senha);
        if(!(usuario.getLogin().isEmpty() && usuario.getSenha().isEmpty())){
            usuarios.put(login, senha);
            return true;
        }
        return false;
    }

    public static boolean removeUsuario(String login){
        if(!usuarios.containsKey(login)){
            return false;
        }
        usuarios.remove(login);
        return true;
    }

    public static boolean autenticaUsuario(String login, String senha){
        return usuarios.containsKey(login) && usuarios.get(login).equals(senha);
    }

    public static boolean atualizaSenhaUsuario(String login, String senha){
        if(!usuarios.containsKey(login)){
            return false;
        }
        usuarios.replace(login, usuarios.get(login), senha);
        return true;
    }
}
