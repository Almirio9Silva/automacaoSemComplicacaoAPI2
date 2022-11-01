#language:pt

  @Filme
  Funcionalidade: CRUD Filme
    @CadastroFilme
    Cenario: Cadastro Filme
      Dado que tenha realizado login com dados validos
      E que tenha um payload da API de Filme
      Quando realizo uma requisicao do tipo POST de Filme
      Entao valido que recebo o status 201 no response
      E valido que no campo "categorias.tipo[1]" possui o valor "Comedia"
      E armazeno o id que recebo do response de Filme

      @ConsultaFilme
      Cenario: Consulta Filme
        Dado que tenha realizado login com dados validos
        E que tenha um payload da API de Filme
        Quando realizo uma requisicao do tipo GET de Filme atraves do nome
        Entao valido que recebo o status 200 no response
        E valido que no campo "categorias.tipo[1]" possui o valor "Comedia"