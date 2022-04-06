<h1 align="center">Task To-Do List</h1>
<p align="center">Teste prático para Pessoa Desenvolvedora Java, <a href="https://site.esig.com.br/">ESIG Software</a></p>

<p align="center">Aplicação simples de gerenciamento de tarefas de usuário</p>

<h4 align="center"> 
	🚧  Status do projeto: 1ª etapa concluída (MVP)  🚧
</h4>


Tabela de conteúdos
=================
<!--ts-->
   * [Sobre](#sobre)
   * [Executar aplicação](#executar)
   * [Como utilizar](#como-utilizar)
   * [Tecnologias](#tecnologias)
<!--te-->

## Sobre
<p align="justify">Aplicação básica para gerenciar tarefas diárias (ou as tarefas que preferir). O projeto cumpre o mínimo viável possível do que se foi pedido no teste prático da <a href="https://site.esig.com.br/">ESIG Software</a>. Todavia, futuramente, será desenvolvido aos poucos mais funcionalidades, conforme necessidade, unicamente por prática para obter aprimoramento de aprendizado nas ferramentas utilizadas no projeto (devido isso, justifica-se o status do projeto).</p>

### Features

- [x] Adicionar Tarefas
- [x] Listar Tarefas
- [x] Cadastrar Usuários

## Executar
<!--ts-->
 * Instalar e configurar a versão OpenJDK do <a href="https://www.openlogic.com/openjdk-downloads?field_java_parent_version_target_id=All&field_operating_system_target_id=All&field_architecture_target_id=All&field_java_package_target_id=All&page=1">Java 8</a>, de acordo com a estrutura da sua máquina;
 * Instalar e configurar o <a href="https://archive.apache.org/dist/maven/maven-3/3.8.4/binaries/">Apache Maven 3.8.4</a>;
 * Instalar e configurar o <a href="https://tomcat.apache.org/download-90.cgi">Apache Tomcat 9.0.62</a>;
 * Instalar e configurar o banco de dados <a href="https://www.postgresql.org/download/">PostgreSQL</a>. Assim que estiver configurado, criar um banco de dados chamado <b>taskdb</b>;
 * Clonar este repositório: 
      ```bash
      $ git clone https://github.com/rodriguesrafael-dev/task-to-do.git
      ```
 * Compilar o projeto para que seja baixada todas as dependências, acessando a pasta do projeto (via terminal, por exemplo), onde se encontra o arquivo <b>pom.xml</b>, e executar o comando: 
     ```bash
     $ mvn compile
     ```
 * Iniciar o servidor da aplicação (Apache Tomcat 9):<br>
     <i>Unix \ Linux \ Mac (com os binários instalados):</i> <br>
     ```bash
     $ <Tomcat Root>/bin>./catalina.sh start 
     ```
     <i>Windows:</i> <br>
     ```bash
     >_ <Tomcat Root>/bin>./catalina.bat start 
     ```        
<!--te-->

## Como utilizar
<!--ts-->
  * 1º Cadastrar o usuário, pois sem essa etapa não será possível gerenciar o responsável pela tarefa;
  * 2º Adicionar as tarefas a serem realizadas, preenchendo os dados requeridos;
  * 3º Ao concluir a tarefa, na tela de "lista de tarefas", clicar em "concluir" para finalizá-la.
<!--te-->

## Tecnologias
<!--ts-->
  * OpenJDK Java 8;
  * JPA (Java Persistence API) 2.0;
  * JSF (Java Server Faces) 2.2;
  * Bootstrap 5;
  * Apache Maven 3.8.4;
  * Apache Tomcat 9.0.62;
  * PostgreSQL 12.4;
  * Eclipse Packaging Project 4.23.0
<!--te-->
