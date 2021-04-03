
![POD](https://img.shields.io/badge/version-v1.0.0-blue.svg) 
![POD](https://img.shields.io/badge/language-Scala-black.svg) 
![POD](https://img.shields.io/badge/license-MIT-lightgrey.svg) 
![SBT compatible](https://img.shields.io/badge/SBT-compatible-4BC51D.svg?style=flat)


## Descrição
### API check senha(password) é válida.
    Input: Uma senha (string).
    Output: Um boolean indicando se a senha é válida.

## Tecnologias
    Scala | 2.11.x
    SBT | 1.2.8

## Validacao
### Valida senha(password) com seguintes definições:
    - Nove ou mais caracteres
    - Ao menos 1 dígito
    - Ao menos 1 letra minúscula
    - Ao menos 1 letra maiúscula
    - Ao menos 1 caractere especial
    - Não possuir caracteres repetidos

## Running simple validate password -> :params API
    sbt run
    
    curl http://localhost:9000/validate/:password

## run check test
    sbt test

## output test
    [info] Tests:
    [info] - should password tem nove ou mais caracteres - IsValid("AbTp9!fo") -> true
    [info] - should password tem ao menos 1 dígito IsValid("") -> false
    [info] - should password tem ao menos 1 letra minúscula - IsValid("ABTP9!FOK") -> false
    [info] - should password tem ao menos 1 letra maiúscula - IsValid("abtp9!fok") -> false
    [info] - should password tem ao menos 1 caractere especial - IsValid("AbTp9fok") -> false
    [info] - should password não possuir caracteres repetidos - IsValid("AbTTp9!fok") -> false
    [info] - should password - IsValid("AbTp9!fok") -> is valid
    [info] Run completed in 291 milliseconds.
    [info] Total number of tests run: 7
    [info] Suites: completed 1, aborted 0
    [info] Tests: succeeded 7, failed 0, canceled 0, ignored 0, pending 0
    [info] All tests passed.
    [success] Total time: 2 s


