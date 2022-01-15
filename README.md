# simian-api
![Coverage](.github/badges/jacoco.svg)

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
