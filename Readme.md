# Pràctica: Desenvolupament i test del joc SHOGUI

## Català

Aquest projecte forma part de la pràctica de l'assignatura **Test i Qualitat del Software**. L’objectiu és desenvolupar un joc utilitzant diverses tècniques de test explicades durant el curs. El joc escollit és una **versió simplificada del SHOGUI**.

### Arquitectura

El desenvolupament segueix el patró **Model-Vista-Controlador (MVC)** per garantir una separació clara de responsabilitats.

### Tècniques de test aplicades

- **Caixa Negra**:
  - Per a tots els mètodes desenvolupats de classes de baix nivell

- **Caixa Blanca**:
  - Per a tot el codi:
    - *Statement coverage*
  - Per a un mínim d’1 mètode desenvolupat (amb almenys dos condicionals):
    - *Decision coverage* i *condition coverage*

- **Design by Contract**:
  - Aplicat a tots els mètodes d’un mínim de dues classes del Model.

- **Mock Objects**:
  - S’han creat mocks necessaris per testar el Model i el Controlador simulant la interacció amb la Vista.

- **CI/CD**:
  - Els tests s’executen automàticament quan es fa un merge a la branca `main`.

---

## English

This project is a practice assignment from the subject **Software Testing and Quality**. The goal is to develop a game using various testing techniques taught during the course. The selected game is a **simplified version of SHOGUI**.

### Architecture

The project uses a **Model-View-Controller (MVC)** architecture to ensure a clear separation of concerns.

### Applied testing techniques

- **Black-box Testing**:
  - For all developed methods of low-level classes:
    - 50% of all equivalence partitions
    - 50% of all possible boundary and edge value cases

- **White-box Testing**:
  - For the entire codebase:
    - *Statement coverage*
  - For at least one developed method (with at least two conditionals):
    - *Decision coverage* and *condition coverage*

- **Design by Contract**:
  - Applied to all methods of at least two classes in the Model.

- **Mock Objects**:
  - Required mocks have been created to test the Model and Controller by simulating interaction with the View.

- **CI/CD**:
  - Tests are automatically executed on every merge into the `main` branch.
