# API de Gerenciamento de Clínica Médica

Desenvolvi uma API de gerenciamento de clínica médica utilizando Spring Boot, como um projeto pessoal para simular o funcionamento de um sistema de gestão clínica. A API permite realizar operações essenciais, como o cadastro, edição e exclusão de pacientes e médicos, além do agendamento e gerenciamento de consultas médicas. Adicionalmente, a API conta com um sistema de autenticação via token, garantindo que apenas usuários autenticados possam acessar as rotas disponíveis.

## Objetivo
O principal objetivo deste projeto foi criar uma solução robusta e eficiente para o gerenciamento de uma clínica médica, permitindo a simulação de um sistema real que facilita o controle de pacientes, médicos e consultas, enquanto implementa regras de negócio essenciais para um funcionamento adequado e eficiente.

## Funcionalidades Principais
- Cadastro de Pacientes e Médicos: Permite criar, editar e excluir registros de pacientes e médicos.
- Gerenciamento de Consultas: Facilita o agendamento, edição e cancelamento de consultas médicas.
- Sistema de Autenticação: Implementação de autenticação via token, garantindo que apenas usuários autenticados possam acessar as funcionalidades da API.
- 
## Regras de Negócio Implementadas:
- Restrições de agendamento para garantir que consultas sejam marcadas apenas dentro do horário de funcionamento da clínica.
- Prevenção de conflitos de horário, garantindo que não haja consultas agendadas para o mesmo horário.
- Auto escolha de médicos baseado na especialidade escolhida pelo paciente quando o mesmo não escolher um médico específico.
- Prevenção de agendamento de consultas inválidas como: consultas com médicos ou pacientes inativos no sistema.
  
## Resultados Alcançados:
- Segurança e Controle de Acesso: A autenticação via token garante que apenas usuários autorizados possam acessar e manipular os dados, aumentando a segurança do sistema.
- Eficiência e Controle: A API proporciona um controle eficiente sobre o agendamento e gerenciamento de consultas e cadastro de pacientes e médicos.
- Validação e Confiabilidade: Implementação de regras de negócio que aumentam a confiabilidade do sistema, prevenindo conflitos de agendamento e respeitando os horários de funcionamento.

## Tecnologias Utilizadas:

Linguagem de Programação: **Java**
Framework: **Spring Boot**
Autenticação: JWT (JSON Web Token)
