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
            UserDAO dao = new UserDAOImpl(emf);
            List<User> users = dao.getAll();
            for (User user : users) {
                dao.delete(user.getId());
            }
        }
    }
}
