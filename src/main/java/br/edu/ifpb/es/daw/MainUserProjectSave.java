package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ProjectDAO;
import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.dao.impl.ProjectDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UserDAOImpl;
import br.edu.ifpb.es.daw.entities.Project;
import br.edu.ifpb.es.daw.entities.User;
import br.edu.ifpb.es.daw.entities.UserProject;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.UUID;

public class MainUserProjectSave {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserDAO userDao = new UserDAOImpl(emf);
            ProjectDAO projectDao = new ProjectDAOImpl(emf);

            User user = new User();
            user.setId(UUID.randomUUID());
            user.setName("Usuário com Projeto");
            user.setEmail("userproj@example.com");
            user.setPassword("senha123");
            user.setEmailVerified(true);
            user.setTermsAgreed(true);

            Project project = new Project();
            project.setId(UUID.randomUUID());
            project.setName("Projeto do Usuário");
            project.setKey("PROJ-" + System.nanoTime());

            userDao.save(user);
            projectDao.save(project);

            UserProject userProject = new UserProject();
            userProject.setUser(user);
            userProject.setProject(project);

            user.addProject(userProject);
            project.addUserProject(userProject);

            userDao.update(user);
            projectDao.update(project);

            System.out.println("Usuário após associação:");
            System.out.println(user);
            System.out.println("\nProjeto após associação:");
            System.out.println(project);
        }
    }
}