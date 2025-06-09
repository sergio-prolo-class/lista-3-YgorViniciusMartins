# Correção

| Questão     | Legibilidade | Diagramas | P1 | P2 | P3 | Total |
|-------------|--------------|-----------|----|----|----|-------|
| Nota máxima | 10           | 10        | 20 | 25 | 35 | 100   |
| Nota        | 8            | 7         | 15 | 20 | 28 |       |

## Diagramas

- setas fora do padrão
- métodos sem parenteses, alguns sem tipo de retorno
- P2:
  - uma solicitação pode estar associada a múltiplos clientes? estranho.
- P3:
  - associação dupla entre Livro e Autor não faz sentido.
  - qual é a diferença entre a associação descrita pelos caminhos abaixo?
    - Gerenciador -> Emprestimo -> Leitor -> Livro
    - Gerenciador -> Leitor -> Livro
    - Gerenciador -> Emprestimo -> Livro
    - e se elas não são diferentes, por que existem várias?
    - se elas são diferentes, por que em uma delas fica explícito que o Leitor só pode ter até 5 Livros, e em outra não?
  - O que é a associação entre Emprestimo e Autor?

## P1

- não ignora maiúsculas no login
- informação duplicada: Usuário com atributo login armazenado em um mapa de login -> Usuario
- oferecer um método público para alterar qualquer login e senha sem antenticar o usuário antes é loucura
- encapsulamento vazado: Gerenciador.getUsuarios() retorna a coleção inteira, dando acesso ao atributo privado
- qtd_usuarios não é igual a usuarios.lenght()?

### Requisitos Funcionais
- [ ] Cadastrar novos usuários
- [x] Remover usuários
- [x] Listar os logins
- [x] Autenticar usuários

## P2

- informação duplicada: Cliente com atributo telefone armazenado em mapa de telefone->cliente
- Cliente
  - qtd_solicitacoes não é igual a solicitacoes.lenght()?
- Gerenciador
  - usar Queue.remove() e .element() pode gerar exceção. melhor usar peek() e poll()
  - quando um Cliente é chamado, a sua solicitação continua na lista do Cliente... como saber qual das Solicitacao eu devo atender?

### Requisitos Funcionais
- [x] Registrar novas solicitações
- [x] Listar os telefones dos clientes registrados
- [x] Imprimir o nome do próximo cliente
- [x] Atender o próximo cliente
- [x] Listar os nomes dos clientes já atendidos
- [x] Listar os telefones dos clientes em espera
- [x] Gerar um relatório estatístico
- [x] ... total de solicitações registradas, atendidas, em espera
- [x] ... distribuição percentual das solicitações por categoria

## P3

- informação duplicada: Livro com atributo... você entendeu
- Gerenciador:
  - métodos sobrecarregados com bastante duplicação de código
  - podes invocar a implementação d outro método com this.adcionarLivro(), por exemplo
  - métodos de listagem lista apenas um atributo, e não informações completas do objeto
- Leitor:
  - um método publico para alterar um ID é suspeito. mesma coisa para Livro e ISBN


### Requisitos Funcionais
- [x] Cadastrar autores
- [x] Cadastrar livros
- [x] Cadastrar leitores
- [x] Registrar empréstimos de livros para leitores
- [x] ... pelo menos uma cópia
- [x] ... leitor não tenha esse livro
- [x] ... leitor possua no máximo 5 livros emprestados
- [x] Listar autores em ordem alfabética
- [x] Listar leitores em ordem alfabética
- [x] Listar leitores por id
- [x] Listar livros por título
- [x] Listar livros por autor
- [x] Listar livros por ISBN
- [ ] Listar empréstimos por data
- [ ] Listar empréstimos de um leitor, por data