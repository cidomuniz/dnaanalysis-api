# simian-api
[![CI/CD](https://github.com/cidoliveiraa/simian-api/actions/workflows/ci-cd.yml/badge.svg?branch=main)](https://github.com/cidoliveiraa/simian-api/actions/workflows/ci-cd.yml) [![codecov](https://codecov.io/gh/cidoliveiraa/simian-api/branch/main/graph/badge.svg?token=RS3WR10R6U)](https://codecov.io/gh/cidoliveiraa/simian-api)

<br>

#### `Efetuar verificação de Símio`
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

#### `Estatísticas de verificações de DNA`
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
