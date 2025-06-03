package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UserProjectDAO;
import br.edu.ifpb.es.daw.dao.impl.UserProjectDAOImpl;
import br.edu.ifpb.es.daw.entities.UserProject;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainUserProjectDeleteAll {
    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserProjectDAO userProjectDao = new UserProjectDAOImpl(emf);

            System.out.println("Deletando todos os UserProjects...");
            List<UserProject> userProjects = userProjectDao.getAll();
            for (UserProject userProject : userProjects) {
                System.out.println("Deletando UserProject: " + userProject.getId());
                userProjectDao.delete(userProject.getId());
            }
            System.out.println("Todos os UserProjects foram deletados. Total: " + userProjects.size());
        }
    }
}