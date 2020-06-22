# language: es

Característica: Iniciar sesion en facebook
  Yo como usuario
  quiero iniciar sesion en la pagina facebook
  para validar la funcionalidad de inicio de sesion

  @facebook
  Escenario:  Inicio de sesion con credenciales erradas
    Dado que el "usuario" esta en la pagina de inicio de sesion de facebook
    Cuando  el usuario inicia sesion con credenciales erradas
    Entonces se valida que se informe el inicio de sesion fallido

