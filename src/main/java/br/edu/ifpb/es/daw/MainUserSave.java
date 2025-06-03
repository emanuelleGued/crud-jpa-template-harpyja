package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.dao.impl.UserDAOImpl;
import br.edu.ifpb.es.daw.entities.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.UUID;

public class MainUserSave {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserDAO userDao = new UserDAOImpl(emf);

            User user = new User();
            user.setId(UUID.randomUUID());
            user.setName("Jucelino Figueredo");
            user.setEmail("lino@example.com");
            user.setPassword("********");
            user.setEmailVerified(true);
            user.setTermsAgreed(true);
            user.setOrganizations(new ArrayList<>());
            user.setProjects(new ArrayList<>());

            System.out.println("Antes de salvar:");
            System.out.println(user);

            userDao.save(user);

            System.out.println("\nDepois de salvar:");
            System.out.println(user);
        }
    }
}