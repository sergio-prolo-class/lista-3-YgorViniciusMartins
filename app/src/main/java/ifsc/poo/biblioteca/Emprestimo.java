package ifsc.poo.biblioteca;

public class Emprestimo {
    private Livro livro;
    private String data;
    private Leitor leitor;
    private boolean ehValido;

    public Emprestimo(Livro livro, String data, Leitor leitor){
        if(!(setLivro(livro) || setData(data) || setLeitor(leitor))){
            this.ehValido = false;
        }
        this.ehValido = true;
    }

    public boolean setLeitor(Leitor leitor) {
        if(!leitor.getEhValido()){
            return false;
        }
        this.leitor = leitor;
        return true;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getData() {
        return data;
    }

    public boolean setData(String data) {
        String[] datas = data.split("/");
        int[] data_int = new int[3];
        for (int i = 0; i < datas.length; i++) {
            data_int[i] = Integer.parseInt(datas[i]);
        }
        if(data_int[0] < 0 || (data_int[1] > 12 || data_int[1] < 0) || (data_int[2] > 31 || data_int[2] < 0)){
            return false;
        }
        this.data = data;
        return true;
    }

    public boolean setLivro(Livro livro) {
        if(!livro.getEhValido()){
            return false;
        }
        this.livro = livro;
        return true;
    }

    public boolean getEhValido() {
        return this.ehValido;
    }
}
