@Backend:WebServicePostWithConPojo
@example

Feature: web service post con data pojo

  Yo como ingeniero
  quiero obtener la informacion del servicio
  para validar los datos mediante pojo


  informacion adicional para el reporte de serenity

  @examplePost
  Scenario:  Obtener list data reqrest
    Given post webservice
    When se obtiene valor de la ultima respuesta
    And se obtiene pojo desde respuesta
    Then se validan los datos de respuesta
  @examplePost
  Scenario:  Obtener list data reqrest
    Given post webservice
    When se obtiene valor de la ultima respuesta
    And se obtiene pojo desde respuesta
    Then se validan los datos de respuesta
