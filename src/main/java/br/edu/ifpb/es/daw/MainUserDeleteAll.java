package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.dao.impl.UserDAOImpl;
import br.edu.ifpb.es.daw.entities.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainUserDeleteAll {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserDAO userDao = new UserDAOImpl(emf);

            System.out.println("Deletando todos os Users...");
            List<User> users = userDao.getAll();
            for (User user : users) {
                System.out.println("Deletando User: " + user.getId());
                userDao.delete(user.getId());
            }
            System.out.println("Todos os Users foram deletados. Total: " + users.size());
        }
    }
}
