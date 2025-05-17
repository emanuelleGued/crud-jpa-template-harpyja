package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.dao.impl.UserDAOImpl;
import br.edu.ifpb.es.daw.entities.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.UUID;

public class MainUserSave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserDAO dao = new UserDAOImpl(emf);
            User user = new User();

            user.setId(UUID.randomUUID());
            user.setName("Maria Silva");
            user.setEmail("maria@example.com");
            user.setPassword("senhaSegura123");
            user.setEmailVerified(true);
            user.setTermsAgreed(true);

            System.out.println(user);

            dao.save(user);

            System.out.println(user);
        }
    }
}

