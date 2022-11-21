package TudoApp;

import controller.ProjectController;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import util.ConnectionFactory;

public class App {

    public static void main(String[] args) {
        ProjectController projectController = new ProjectController();
        Project project = new Project();
        project.setName("Projeto Teste");
        project.setDescription("Descrição");
        project.setCreatedAt(new Date());
        project.setUpdateAt(new Date());
        projectController.save(project);

        //project.setName("Novo nome do projeto");
        //projectController.update(project);
        //List<Project> projects = projectController.getAll();
        //System.out.println("Total de projetos = " + projects.size());
    }
}
