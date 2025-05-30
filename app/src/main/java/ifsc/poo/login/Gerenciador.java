package ifsc.poo.login;

import java.util.LinkedHashMap;
import java.util.Map;

public class Gerenciador {
    private static Map<String, Usuario> usuarios = new LinkedHashMap<>();
    private static int qtd_usuarios;

    public static boolean cadastraUsuario(String login, String senha){
        if(usuarios.containsKey(login)){
            return false;
        }
        Usuario usuario = new Usuario(login, senha);
        if(!(usuario.getLogin().isEmpty() && usuario.getSenha().isEmpty())){
            usuarios.put(login, usuario);
            qtd_usuarios++;
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
        return usuarios.containsKey(login) && usuarios.get(login).getSenha().equals(senha);
    }

    public static boolean alteraSenhaUsuario(String login, String senha){
        if(!usuarios.containsKey(login)){
            return false;
        }
        Usuario usuario = new Usuario(login, senha);
        if(!(usuario.getLogin().isEmpty() && usuario.getSenha().isEmpty())) {
            usuarios.replace(login, usuarios.get(login), usuario);
        }
        return true;
    }

    public static int getQtd_usuarios(){
        return qtd_usuarios;
    }

    public static Map<String, Usuario> getUsuarios(){
        return usuarios;
    }

    public static void listaUsuarios(){
        usuarios.forEach((login, usuario) -> System.out.println("Login: " + usuario.getLogin() + ", Senha: " + usuario.getSenha()));
    }
}
