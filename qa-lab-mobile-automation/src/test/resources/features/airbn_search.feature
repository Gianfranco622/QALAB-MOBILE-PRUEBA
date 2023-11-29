Feature: Búsqueda en Airbnb

  @test
  Scenario: Búsqueda simple de hospedaje

    Given que me encuentro en el login de Airbnb
    When busco "Hoteles en Vichayito"
    Then valido que exista al menos un resultado
    And se muestra el texto sobre la busquedas "Over 1,000 places"