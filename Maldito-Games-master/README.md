# Sistema de Loja

## Apresentação do Projeto

Este projeto consiste no desenvolvimento de um Sistema de Loja com fins
educacionais, elaborado por alunos do 3º ano do Ensino Médio Técnico. O
objetivo principal é simular o funcionamento de um sistema comercial
real, aplicando conceitos fundamentais de programação, banco de dados e
modelagem de sistemas.

O projeto será desenvolvido de forma contínua ao longo do ano, com
rodízio de alunos a cada bimestre. Dessa forma, a organização, clareza e
documentação adequada tornam-se elementos essenciais para garantir a
continuidade e evolução do sistema.

Este repositório não representa apenas código, mas também um ambiente de
aprendizado colaborativo.

------------------------------------------------------------------------

## Objetivo Geral

Desenvolver um sistema capaz de:

-   Realizar cadastro de produtos
-   Gerenciar controle de estoque
-   Cadastrar clientes
-   Registrar vendas
-   Processar pagamentos
-   Permitir futura expansão com relatórios e controle de usuários

O sistema deve ser estruturado de maneira organizada, permitindo que
novos alunos compreendam rapidamente sua lógica e possam dar
continuidade ao desenvolvimento.

------------------------------------------------------------------------

## Motivação

O tema foi escolhido por sua relevância prática e por permitir a
aplicação de diversos conteúdos técnicos aprendidos no curso.

Sistemas comerciais estão presentes em praticamente todos os
estabelecimentos. Trabalhar com esse modelo permite compreender:

-   Estruturação de banco de dados
-   Relacionamento entre entidades
-   Organização de código
-   Separação de responsabilidades no sistema
-   Boas práticas de documentação

Além disso, o formato com rodízio de desenvolvedores simula um cenário
próximo ao ambiente profissional, onde diferentes pessoas contribuem
para o mesmo projeto ao longo do tempo.

------------------------------------------------------------------------

## Previsão de Entidades do Sistema

A seguir estão as principais entidades previstas para o sistema:

### Produto

-   idProduto
-   nome
-   descricao
-   preco
-   quantidadeEstoque
-   categoria

### Cliente

-   idCliente
-   nome
-   cpf
-   telefone
-   email
-   endereco

### Venda

-   idVenda
-   data
-   valorTotal
-   idCliente
-   statusPagamento

### ItemVenda

-   idItemVenda
-   idVenda
-   idProduto
-   quantidade
-   subtotal

### Pagamento

-   idPagamento
-   idVenda
-   formaPagamento
-   valorPago
-   dataPagamento

### Funcionario (evolução futura)

-   idFuncionario
-   nome
-   cargo
-   login
-   senha

------------------------------------------------------------------------

## Organização e Continuidade

Como o projeto terá troca de alunos a cada bimestre, algumas diretrizes
são fundamentais:

1.  Manter o código organizado e comentado quando necessário.
2.  Realizar commits descritivos.
3.  Atualizar este README sempre que houver alterações estruturais.
4.  Garantir que o sistema permaneça funcional ao final de cada ciclo.

Cada aluno que contribuir para este projeto faz parte de sua construção
histórica. Por isso, é importante desenvolver pensando em quem dará
continuidade depois.

