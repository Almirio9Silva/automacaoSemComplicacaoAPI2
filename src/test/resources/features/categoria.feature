#language: pt

@categoria
Funcionalidade: Consulta Categoria


  Cenario: Realizar consulta Categoria com Sucesso
    Dado que tenha realizado login com dados validos
    E que tenha um payload da API de Categoria
    Quando relizo uma requisicao do tipo Get de Categoria
    Entao valido que recebo o status 200 no response
    E valido que no campo "tipo[2]" possui o valor "Terror"

  Cenario: Realizar consulta Categoria sem um token
    Quando relizo uma requisicao do tipo Get de Categoria
    Entao valido que recebo o status 403 no response
    E valido que no campo "message" possui o valor "Access Denied"

  Cenario: Realizar consulta com token invalido
    Quando altero o campo "Authorization" do header de categorias com o valor "invalido "
    E relizo uma requisicao do tipo Get de Categoria
    Entao valido que recebo o status 403 no response
    E valido que no campo "message" possui o valor "Access Denied"
