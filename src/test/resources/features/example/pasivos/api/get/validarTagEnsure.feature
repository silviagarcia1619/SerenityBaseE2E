@Backend:ValidarMultipleTagEnsure
@example

Feature: Validar multiples tag con ensure serenity
  Yo como ingeniero
  quiero obtener la informacion del servicio
  para validar los tag de la respuesta

  informacion adicional para el reporte de serenity

  @SchemaValidation
  Scenario:  Validar tags in response
    Given "Aplication principal" llama a servicio stats records
    When Se valida data de volume
    Then Se valida data de notional y routedVolume
