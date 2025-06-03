package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ProjectDAO;
import br.edu.ifpb.es.daw.dao.impl.ProjectDAOImpl;
import br.edu.ifpb.es.daw.entities.Project;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainProjectDeleteAll {
    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            ProjectDAO projectDao = new ProjectDAOImpl(emf);

            System.out.println("Deletando todos os Projects...");
            List<Project> projects = projectDao.getAll();
            for (Project project : projects) {
                System.out.println("Deletando Project: " + project.getId());
                projectDao.delete(project.getId());
            }
            System.out.println("Todos os Projects foram deletados. Total: " + projects.size());
        }
    }
}