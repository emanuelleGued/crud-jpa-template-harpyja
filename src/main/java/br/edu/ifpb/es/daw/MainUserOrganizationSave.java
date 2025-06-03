package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.OrganizationDAO;
import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.dao.impl.OrganizationDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UserDAOImpl;
import br.edu.ifpb.es.daw.entities.Organization;
import br.edu.ifpb.es.daw.entities.User;
import br.edu.ifpb.es.daw.entities.UserOrganization;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.UUID;

public class MainUserOrganizationSave {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserDAO userDao = new UserDAOImpl(emf);
            OrganizationDAO orgDao = new OrganizationDAOImpl(emf);

            User user = new User();
            user.setId(UUID.randomUUID());
            user.setName("Usuário com Organização");
            user.setEmail("userorg@example.com");
            user.setPassword("senha123");
            user.setEmailVerified(true);
            user.setTermsAgreed(true);

            Organization org = new Organization();
            org.setId(UUID.randomUUID());
            org.setName("Organização do Usuário");

            userDao.save(user);
            orgDao.save(org);

            UserOrganization userOrg = new UserOrganization();
            userOrg.setUser(user);
            userOrg.setOrganization(org);

            user.addOrganization(userOrg);
            org.addUserOrganization(userOrg);

            userDao.update(user);
            orgDao.update(org);

            System.out.println("Usuário após associação:");
            System.out.println(user);
            System.out.println("\nOrganização após associação:");
            System.out.println(org);
        }
    }
}