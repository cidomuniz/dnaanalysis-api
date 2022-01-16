# simian-api
[![CI/CD](https://github.com/cidoliveiraa/simian-api/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/cidoliveiraa/simian-api/actions/workflows/ci-cd.yml) [![codecov](https://codecov.io/gh/cidoliveiraa/simian-api/branch/main/graph/badge.svg?token=RS3WR10R6U)](https://codecov.io/gh/cidoliveiraa/simian-api)

* [Clean Architecture](#clean-architecture)
* [Estrutura da Aplicação](#estrutura-da-aplicação)
* [Pipelines, URL e mais](#pipelines-url-e-mais)
* [Construindo e Executando a aplicação](#construindo-e-executando-a-aplicação)
* [Documentação das Rotas](#documentação-das-rotas)

***

## Clean Architecture
> By separating the software into layers, and conforming to The Dependency Rule, you will create a system that is intrinsically testable, with all the benefits that implies. When any of the external parts of the system become obsolete, like the database, or the web framework, you can replace those obsolete elements with a minimum of fuss. -  _Unclebob_ ([source](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html))

* Os frameworks são isolados em módulos individuais para que quando (se) mudarmos de ideia, só tenhamos que mudar um lugar;
* Fácil entendimento da estrutura de pacotes;
* Toda a lógica de negócios está em um caso de uso, então é fácil de encontrar e não é duplicada em nenhum outro lugar.

***

## Estrutura da aplicação
##### Core: Domain 
* Representa o objeto de domínio;
* Apenas a lógica que é aplicável, em geral, a toda a entidade;

##### Core: Use Cases
* Lógica de negócios pura, java simples;
* Interfaces para os dados de que precisam para aplicar alguma lógica.

##### Adapters
* Conjunto de adaptadores que convertem dados no formato que é mais conveniente para os casos de uso e entidades;
* Maneiras de interagir com o aplicativo, nesse caso controllers;
* Aciona um caso de uso e converte o resultado para o formato apropriado de saída.

##### Frameworks
  * Spring Boot 
    - Web
    - Data MongoDB
    - Test
    - Actuator
  * SpringDoc - Swagger e documentação.
  * ModelMapper - Mapeamento entre classes.

***

## Pipelines, URL e mais
* DNS do servidor da aplicação na AWS: http://ec2-18-205-116-20.compute-1.amazonaws.com;
* Pipeline simples de CI/CD com GitHub Actions: https://github.com/cidoliveiraa/simian-api/actions/workflows/ci-cd.yml;
* Repositório no Docker Hub com imagens entregues pelo pipeline: https://hub.docker.com/r/cidoliveiraa/simian-api/tags;
***

## Construindo e Executando a Aplicação
#### construindo a aplicação (na pasta raiz da aplicação):
* Requisitos
  - Docker
  - Docker Compose
#### executando a aplicação local:
```
docker-compose up -d 
```
***

## Documentação das rotas
### Swagger
* http://ec2-18-205-116-20.compute-1.amazonaws.com/swagger-ui/index.html
### Actuator
* http://ec2-18-205-116-20.compute-1.amazonaws.com/actuator/health
### Efetuar verificação de Símio
>`POST`
>```
> /simian
>```
>
>`body`
>
>| Atributo  | Tipo               | Obrigatório            | Descrição    |
>|-----------|--------------------|------------------------|--------------|
>| `dna`     | `array of strings` | :heavy_check_mark: Sim |    `sequência de DNA`, onde, cada elemento desse array representa uma linha de uma tabela `quadrada` de >(NxN) |
>
>
>> `Exemplo de Resposta`
>>
>>    HTTP Status Code: 200
>>
>>    ```json
>>      {
>>        "is_simian": true
>>      }
>>    ```

<br>

### Estatísticas de verificações de DNA
> `GET`
>```
>  /stats
>```
>
>> `Exemplo de Resposta`
>>
>>   HTTP Status Code: 200 
>>
>>   ```json
>>     {
>>       "count_simian_dna": 40,
>>       "count_human_dna": 100,
>>       "ratio": 0.4
>>     }
>>   ```
