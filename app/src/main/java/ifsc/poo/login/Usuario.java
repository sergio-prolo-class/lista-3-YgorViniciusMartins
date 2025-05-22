package ifsc.poo.login;

public class Usuario {
    private String login;
    private String senha;

    public Usuario(String login, String senha){
        if(!(setLogin(login) && setSenha(senha))){
            this.login = "";
            this.senha = "";
        }
    }

    public boolean setLogin(String login) {
        if(login.isEmpty()) {
            return false;
        }
        login = login.toLowerCase();
        this.login = login;
        return true;
    }

    public String getLogin() {
        return this.login;
    }

    public boolean setSenha(String senha) {
        if(senha.isEmpty()) {
            return false;
        }
        this.senha = senha;
        return true;
    }

    public String getSenha() {
        return this.senha;
    }
}
