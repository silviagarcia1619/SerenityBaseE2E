@Backend:ObtenerDataJsonPath
@Frontend:ObtenerDataJsonPath
@example

Feature: Obtener data con jsonPath
  Yo como ingeniero
  quiero obtener la informacion del servicio
  para validar los datos mediante path

  informacion adicional para el reporte de serenity

  @BaseTest
  Scenario:  Obtener data
    Given "Aplication principal" llama a servicio stats records
    When Se valida data de volume con JsonPath
    Then Se valida data de notional y routedVolume con JsonPath


