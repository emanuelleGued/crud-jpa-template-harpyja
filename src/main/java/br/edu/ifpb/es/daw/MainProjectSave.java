package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ProjectDAO;
import br.edu.ifpb.es.daw.dao.impl.ProjectDAOImpl;
import br.edu.ifpb.es.daw.entities.Project;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class MainProjectSave {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            ProjectDAO projectDao = new ProjectDAOImpl(emf);

            Project project = new Project();
            project.setId(UUID.randomUUID());
            project.setName("Nome do Projeto");
            project.setKey("PROJ-" + System.nanoTime());
            project.setType("Software");
            project.setExpiration(LocalDateTime.now().plusYears(1));
            project.setUsers(new ArrayList<>());

            System.out.println("Antes de salvar:");
            System.out.println(project);

            projectDao.save(project);

            System.out.println("\nDepois de salvar:");
            System.out.println(project);
        }
    }
}