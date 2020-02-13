@Backend:PruebasPathQueryParam
@example

Feature: Pruebas de uso ws con path y query param

  Yo como asesor
  quiero obtener informacion del webservice
  para alimentar la base de datos

  informacion adicional para el reporte de serenity

  @BaseProjectWS
  Scenario:  Uso de path param
    Given Se consume el servicio usando pathParam "six"
    When se valida tag "title"
    Then se valida tag "id"

  @BaseProjectWS
  Scenario:  Uso de query param
    Given Se consume el servicio usando query "aapl"
    When se valida tag "title"
    Then se valida tag "id"
