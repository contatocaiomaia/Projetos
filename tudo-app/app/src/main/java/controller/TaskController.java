package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {

    public void save(Task task) {

        String sql = "INSERT INTO tasks(idProject" //DECLARANDO OS OBJETOS DO BANCO.
                + "name,"
                + "description,"
                + "completed,"
                + "notes,"
                + "deadline,"
                + "createAt,"
                + "updateAt,"
                + ") VALUES(?,?,?,?,?,?,?,?)"; // SEMPRE QUE FOR PRECISO DECLARAR UM VALOR NO SQL QUE AINDA NÃO EXISTE É PRECISSO PASSAR O VALOR "?" COMO DEFAULT.

        Connection connection = null; //VARIÁVEL PARA CONEXÃO COM O BANCO DE DADOS.
        PreparedStatement statement = null; //

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdateAt().getTime()));
            statement.execute();
        } catch (Exception ex) {
            System.out.println("Erro ao salvar tarefa" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement);

        }

    }

    public void update(Task task) {
        String sql = "UPDATE task SET"
                + "idProject = ?,"
                + "name = ?,"
                + "description = ?"
                + "completed = ?"
                + "deadline = ?"
                + "createdAt = ?"
                + "updatedAt = ?"
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //ESTABELENCENDO A CONEXAO COM O BANCO DE DADOS.
            connection = ConnectionFactory.getConnection();
            //PREPARANDO A QUERY 
            statement = connection.prepareStatement(sql);
            //SETANDO OS VALORES DO STATEMENT
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdateAt().getTime()));
            statement.setInt(9, task.getId());

            //EXECUTANDO A QUERY;
            statement.execute();

        } catch (Exception ex) {
            System.out.println("Erro ao atualiazar a tarefa" + ex.getMessage());
        }
    }

    public void removeById(int taskId) throws SQLException {

        String sql = "DELETE FROM tasks WHERE ID = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //CRIAÇÃO DA CONEXAO COM O BANCO DE DADOS.
            connection = ConnectionFactory.getConnection(); //ESTABELENCENDO UMA CONEXÃO COM O BANCO DE DADOS;
            //PREPARANDO A QUERY
            statement = connection.prepareStatement(sql);  // CRIANDO UM OBJETO STATEMENT; AJUDA A PREPARA O COMANDO QUE VAI SER EXECUTADO NO BANCO DE DADOS;
            //SETANDO OS VCALORES;
            statement.setInt(1, taskId); //COMANDO QUE COLOCA UM VALOR NUMÉRICO NO LUGAR DO "?";
            //EXECUTANDO A QUERY.
            statement.execute();

        } catch (Exception ex) {
            throw new SQLException("Erro ao deletar a tarefa" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Task> getAll(int idProject) { //ENTREGA UMA LISTA DE TAREFAS.

        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null; //Classe que trás a resposta do banco de Dados

        List<Task> tasks = new ArrayList<Task>(); //LISTA DE TAREFAS QUE SERÁ DEVOLVIDA QUANDO A CHAMADA DO MÉTODO ACONTECER

        try {
            //CRIANDO A CONEXÃO
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            //SETANDO O VALOR QUE CORRESPONDE AO FILTRO DE BUSCA.
            statement.setInt(1, idProject);
            //VALOR RETORNADO PELA EXECUÇÃO DA QUERY
            ResultSet resultSet = statement.executeQuery();
            //ENQUANTO HOUVEREM OS VALORES A SEREM CORRESPONDIDOS NO MEU resultSet.
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadLine"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdateAt(resultSet.getDate("updateAt"));
                tasks.add(task);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir a tarefa" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultset);
        }
        //LISTA DE TAREFAS CRIADA E CARREGADA DO BANCO DE DADOS.
        return tasks;
    }
}
