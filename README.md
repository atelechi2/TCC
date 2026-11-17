# TCC - Acionamento de hardware de baixa potência via dispositivos móveis Android

Trabalho de Conclusão do Curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas (FATEC Senac Pelotas, 2013).
Orientador: Gladmir Ceroni Catarino.

> Projeto acadêmico de 2013, mantido como registro histórico.

## Sobre o projeto
Sistema que permite acionar dispositivos de baixa potência a partir de um aplicativo Android, usando um servidor intermediário e um microcontrolador Arduino.

## Estrutura do repositório
| Pasta | Conteúdo |
|---|---|
| `TCC/Dispositivo Android` | Aplicativo Android |
| `TCC/Servidor/AndroinControl` | Servidor em Java (projeto NetBeans), com camadas BD, BEAN e DAO |
| `TCC/Servidor/android_control.sql`, `android.mwb` | Banco de dados MySQL (script e modelo do MySQL Workbench) |
| `TCC/Arduino` | Código do Arduino (C++) |
| `_REVISAR_ANTES_DE_EXCLUIR` | Backups antigos mantidos por segurança |

## Tecnologias
Java, Android, Arduino (C++) e MySQL.

## Como executar (resumo)
1. Importar o banco executando `TCC/Servidor/android_control.sql` no MySQL.
2. Abrir `TCC/Servidor/AndroinControl` no NetBeans e executar o servidor.
3. Gravar o código da pasta `TCC/Arduino` na placa.
4. Abrir o projeto da pasta `TCC/Dispositivo Android` e instalar o aplicativo no aparelho.

## Autor
Alexandre da Silva Telechi - [LinkedIn](https://www.linkedin.com/in/alexandre-telechi-900254391/) | [Lattes](http://lattes.cnpq.br/1166821826261701)
