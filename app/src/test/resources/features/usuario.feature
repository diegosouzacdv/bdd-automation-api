# language: pt

Funcionalidade: Gerenciamento de um usuario na PetStore

  Cenario: Cria um usuario na loja
    Quando faço um POST para v3/user com os seguintes valores:
      | id         | 10               |
      | username   | rafael           |
      | firstName  | rafael           |
      | lastName   | lima             |
      | email      | rafael@email.com |
      | password   | 12345            |
      | phone      | 54321            |
      | userStatus | 1                |
    Entao quando faço um GET para /v3/user/rafael, o usuário criado é retornado

  Cenario: Cria um usuario na loja usando docstring
    Quando faço um POST para v3/user com os seguintes docstring:
  """
  json {
    "id": 10,
    "username": "theUser",
    "firtName": "John",
    "lastName": "James",
    "email": "james@email.com",
    "phone": "12345",
    "userStatus": 1
  }
  """
    Entao quando faço um GET para /v3/user/rafael, o usuário criado é retornado


  Cenario: Cria usuário na loja refletindo o negócio
    Quando crio um usuário
    Entao o usuário é salvo no sistema