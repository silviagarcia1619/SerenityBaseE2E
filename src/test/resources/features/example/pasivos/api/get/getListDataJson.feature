@Backend:GetListData
@example

Feature: get list data
  Yo como ingeniero
  quiero obtener la informacion en listas
  para validar los datos

  informacion adicional para el reporte de serenity

  Scenario:  Obtener list data reqrest
    Given get webservice
    When no implemented
    And se obtiene lista de id usuarios


  @BaseTestx
  Scenario:  Obtener list data reqrest validando headers
    Given get webservice validando headers y estado menor que
    When no implemented
    And se obtiene lista de usuarios y se hacen validaciones

