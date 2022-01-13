# simian-api

```
POST /simian
```

!!! example "Parâmetros"

  ==**`body`**==

  | Atributo  | Tipo               | Obrigatório            | Descrição    |
  |-----------|--------------------|------------------------|--------------|
  | `dna`     | `array of strings` | :heavy_check_mark: Sim |    `sequência de DNA`, onde, cada elemento desse array representa uma linha de uma tabela `quadrada` de (NxN) |

!!! note "Exemplo de Resposta"

  === "Sucesso"
    **==HTTP Status Code: 200==** 

    ```json
      {
        "is_simian": true
      }
    ```
  === "Erro"
    **==HTTP Status Code: 500==** 

    ```json
      {
        "erro": "Error message"
      }
    ```

```
GET /stats
```

!!! note "Exemplo de Resposta"

  === "Sucesso"
    **==HTTP Status Code: 200==** 

    ```json
      {
        "count_simian_dna": 40,
        "count_human_dna": 100,
        "ratio": 0.4
      }
    ```
  === "Erro"
    **==HTTP Status Code: 500==** 

    ```json
      {
        "erro": "Error message"
      }
    ```
