@example

Feature: Validacion de prueba manual

  Yo como tester
  quiero realizar pruebas manuales
  para validar los casos no criticos

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-15
  @manual-test-evidence:https:assets/responsive.png
  Scenario:  Ejemplo de escenario manual
    Given que se va a realizar una prueba manual
    When  ejecuto la pruebaa
    Then se refleja la evidencia en serenity report

