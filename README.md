# PeqSystem Refatorado

Projeto desktop em Java refatorado aplicando princípios **SOLID** (com foco em SRP e DIP) e arquitetura **MVC**.  
O código foi otimizado para eliminar *code smells* e melhorar a organização, mantendo clareza e facilidade de manutenção.

## Tecnologias Utilizadas
- Java (JDK 8+)
- NetBeans
- Git/GitHub

## Estrutura do Projeto
- **model** → Classes que representam os dados (entidades).
- **dao** → Acesso e manipulação de dados.
- **service** → Regras de negócio e validações.
- **view** → Interface de interação com o usuário.
- **testes** → Classes para testes manuais.

## Princípios Aplicados
- **SRP** (Single Responsibility Principle) → Cada classe com apenas uma responsabilidade.
- **DIP** (Dependency Inversion Principle) → Uso de injeção de dependência no *Service*.
- Arquitetura **MVC** para separação clara das camadas.

## Execução
Para rodar o projeto:
1. Abra no NetBeans ou sua IDE preferida.
2. Execute a classe `MainTestes` para verificar o funcionamento.

## Autor
Mary Oliver
