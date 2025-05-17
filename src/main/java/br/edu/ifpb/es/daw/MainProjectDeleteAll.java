package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ProjectDAO;
import br.edu.ifpb.es.daw.dao.impl.ProjectDAOImpl;
import br.edu.ifpb.es.daw.entities.Project;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainProjectDeleteAll {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            ProjectDAO dao = new ProjectDAOImpl(emf);

            List<Project> projects = dao.getAll();

            System.out.println("Encontrados " + projects.size() + " projetos para remover");

            for (Project project : projects) {
                System.out.println("Removendo projeto: " + project.getId());
                dao.delete(project.getId());
            }

            System.out.println("Todos os projetos foram removidos com sucesso");
        } catch (Exception e) {
            System.err.println("Erro ao remover projetos: ");
            e.printStackTrace();
        }
    }
}