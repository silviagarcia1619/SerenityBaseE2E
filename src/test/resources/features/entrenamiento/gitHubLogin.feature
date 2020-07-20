# language: es

Característica: Yo como usuario
  quiero realizar login en pagina github
  para validar el ingreso correcto o errado al sistema

  @github
  Escenario: login fallido en github
    Dado que el "usuario" esta en la pagina de github
    Cuando   el usuario se logea con credenciales erradas
    Entonces se validara que se presente un mensaje informando el error

