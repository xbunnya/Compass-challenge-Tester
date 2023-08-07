# Planejamento de testes   

## Resumo: 
   Os testes realizados terão o intuíto de garantir o funcionamento de consultas e simulações de acordo com as regras e padrões presentes na API Sicred.

## Recursos utilizados 
-  *Desktop*
-  *VSCODE*
-  *JDK*
-  *Maven* 
-  *RestAssured*
-  *JUnit*
-  *API Sicred*
-  *GitLab*
-  *Allure*
-  *Jira*

## Condições

- Texto informando o CPF não pode ser no formato 999.999.999-99;
- Texto informando o nome da pessoa;
- Texto informando um e-mail válido;
- Valor da simulação deve ser maior ou igual a R$1.000 e menor ou igual a R$40.000;
- Número de parcelas deve ser igual ou maior que 2 e menor ou igual a 48;
- Utilizar o valor booleano "true" se for com seguro e "false" se sem.


## Casos de testes 

-  CT_001 Inserir uma nova simulação seguindo todos os padrões.
- 	CT_002 Inserir uma simulação com cpf inválido.
- 	CT_003 Inserir uma simulação com o campo "seguro" vazio.
-	CT_004 Inserir uma simulação com o campo "cpf" vazio.
-	CT_005 Inserir uma simulação com campo "nome" vazio.
-	CT_006 Inserir uma simulação com o campo "parcelas" vazio.
-	CT_007 Inserir uma simulação com o campo "valor" vazio.
-	CT_008 Consultar uma restrição por cpf que não consta no banco.
- 	CT_009 Inserir uma simulação com o campo "seguro" nulo.
-	CT_010 Inserir uma simulação com o campo "cpf" nulo.
-	CT_011 Inserir uma simulação com campo "nome" nulo.
-	CT_012 Inserir uma simulação com o campo "parcelas" nulo.
-	CT_013 Inserir uma simulação com o campo "valor" nulo.
-	CT_014 Consultar uma restrição por cpf sem dados.
-	CT_015 Consultar uma restrição por cpf.
-	CT_016 Inserir uma simulação com cpf restringido.
-  CT_017 Atualizar uma simulação existente.
-	CT_019 Atualizar uma simulação deixando dados em branco.
-  CT_020 Atualizar uma simulação deixando dados vazios.
-  CT_021 Atualizar uma simulação colocando um cpf já utilizado.
-  CT_022 Inserir simulação com empréstimo menor que R$1.000.
-  CT_023 Inserir simulação com empréstimo maior que R$40.000.
-	CT_024 Inserir simulação com parcela menor que 2.
-	CT_025 Inserir simulação com parcela maior que 48.
-	CT_026 Deletar simulação inexistente.
-	CT_027 Deletar simulação.
-	CT_028 Chamar todas as simulações existentes.


## Testes candidatos à automação:
-  CT_001  Inserir nova simulação.
-  CT_010 Inserir uma simulação com cpf restringido
-  CT_019 Atualizar uma simulação deixando dados em branco.
-  CT_020 Atualizar uma simulação deixando dados vazios.
-  CT_022 Inserir simulação com empréstimo menor que R$1.000.
-  CT_023 Inserir simulação com empréstimo maior que R$40.000.
-  CT_024 Inserir simulação com parcela menor que 2.
-  CT_025 Inserir simulação com parcela maior que 48.
-  CT_027 Deletar simulação. 
-  CT_028 Chamar todas as simulações existentes.