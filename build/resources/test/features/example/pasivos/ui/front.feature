@Frontend:testExample
@example

Feature: Busquedas desde pagina principal South west Trainrail

  Yo como usuario
  quiero encontrar rutas de tren disponibles
  para conocer los horarios disponibles y sus respectivos precios

  En esta etapa solo se va a obtener resultados de busqueda con sus precios pero no se finaliza compra

  @Sprint1
  Scenario:  Busqueda de trenes con usuario no registrado
    Given que el "usuario no registrado" ingresa a la pagina principal
    When  diligencia el formulario solo con origen y destino
    Then el usuario no registrado deberia ver los resultados correspondientes al origen y destino establecidos

  @Sprint1
  Scenario:  Busqueda de trenes con usuario no registrado
    Given que el "usuario" ingresa a la pagina exapmles todomvc
    When  realiza la busqueda por "task"
    Then deberia ver "task" en la lista de resultados
