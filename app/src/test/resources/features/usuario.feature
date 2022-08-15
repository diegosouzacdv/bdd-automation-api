# language: pt

Funcionalidade: Gerenciamento de um usuario na PetStore

  Cenario: Cria um usuario na loja
    Quando faco um POST para /v3/user com os seguintes valores:
      | id         | 10               |
      | username   | rafael           |
      | firstName  | rafael           |
      | lastName   | lima             |
      | email      | rafael@email.com |
      | password   | 12345            |
      | phone      | 54321            |
      | userStatus | 1                |
    Entao quando faco um GET para /v3/user/rafael, o usuario criado e retornado





  Cenario: Cria usuario na loja refletindo o negocio
    Quando crio um usuario
    Entao o usuario e salvo no sistema