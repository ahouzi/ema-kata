Feature: La fonctionnalité Retrieve Videos By Tags And Level
  Scenario Outline: en tant qu'utilisateur je veux retrouver les videos par Tags et par Niveau
    Given je peux voir toutes les videos disponibles
    Given Jenvoie ma requete pour les videos ayant les tags <tags> et le Niveau <lvl>

    Examples:
      | tags   | lvl    |
      | CALCUL | MEDIUM |