package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ProjectDAO;
import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.dao.UserProjectDAO;
import br.edu.ifpb.es.daw.dao.impl.ProjectDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UserDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UserProjectDAOImpl;
import br.edu.ifpb.es.daw.entities.Project;
import br.edu.ifpb.es.daw.entities.User;
import br.edu.ifpb.es.daw.entities.UserProject;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainUserProjectDeleteAll {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserProjectDAO userProjectDao = new UserProjectDAOImpl(emf);
            UserDAO userDao = new UserDAOImpl(emf);
            ProjectDAO projectDao = new ProjectDAOImpl(emf);

            List<UserProject> userProjects = userProjectDao.getAll();
            System.out.println("Deletando " + userProjects.size() + " associações UserProject");
            for (UserProject userProject : userProjects) {
                userProjectDao.delete(userProject.getId());
            }

            List<User> users = userDao.getAll();
            for (User user : users) {
                userDao.delete(user.getId());
            }

            List<Project> projects = projectDao.getAll();
            for (Project project : projects) {
                projectDao.delete(project.getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}