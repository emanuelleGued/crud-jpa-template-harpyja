package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.*;
import br.edu.ifpb.es.daw.dao.impl.AddressDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.OrganizationDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UserDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UserOrganizationDAOImpl;
import br.edu.ifpb.es.daw.entities.*;
import br.edu.ifpb.es.daw.entities.enums.OrganizationRole;
import br.edu.ifpb.es.daw.entities.enums.OrganizationStatus;
import br.edu.ifpb.es.daw.entities.enums.ProjectRole;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.UUID;

public class MainUserOrganizationSave {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserDAO userDao = new UserDAOImpl(emf);
            OrganizationDAO organizationDao = new OrganizationDAOImpl(emf);
            UserOrganizationDAO userOrganizationDao = new UserOrganizationDAOImpl(emf);
            AddressDAO addressDao = new AddressDAOImpl(emf);

            User user = new User();
            user.setId(UUID.randomUUID());
            user.setName("Jonh Done");
            user.setEmail("done.jonh@gmail.com");
            user.setPassword("********");
            user.setEmailVerified(true);
            user.setTermsAgreed(true);
            userDao.save(user);

            Organization organization = new Organization();
            organization.setName("Dunder Mikeer");
            organization.setRegistrationDate(LocalDateTime.now());
            organization.setStatus(OrganizationStatus.ACTIVE);
            organization.setBusinessSize("MEDIUM");
            organizationDao.save(organization);

            Address address = new Address();
            address.setId(UUID.randomUUID());
            address.setCountry("USA");
            address.setCity("Virginia");
            address.setStreet("Patriot Hwy");
            address.setZip("58000-000");
            address.setOrganization(organization);
            addressDao.save(address);

            System.out.println("Antes da associação:");
            System.out.println(user);
            System.out.println(organization);
            System.out.println(address);

            try (EntityManager em = emf.createEntityManager()) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();

                try {
                    User managedUser = em.merge(user);
                    Organization managedOrg = em.merge(organization);
                    Address managedAddress = em.merge(address); // Adicionado

                    UserOrganizationId userOrganizationId = new UserOrganizationId(managedUser.getId(), managedOrg.getId());
                    UserOrganization userOrganization = new UserOrganization();
                    userOrganization.setId(userOrganizationId);
                    userOrganization.setRole(OrganizationRole.ADMIN);
                    userOrganization.setDefaultProjectRole(ProjectRole.MANAGER);
                    userOrganization.setUser(managedUser);
                    userOrganization.setOrganization(managedOrg);

                    managedUser.addOrganization(userOrganization);
                    managedOrg.addUserOrganization(userOrganization);

                    em.persist(userOrganization);
                    transaction.commit();

                    System.out.println("\nDepois da associação:");
                    System.out.println("User ID: " + managedUser.getId());
                    System.out.println("Organization ID: " + managedOrg.getId());
                    System.out.println("Address ID: " + managedAddress.getId());
                    System.out.println("UserOrganization: " + userOrganization.getId());
                } catch (Exception e) {
                    if (transaction.isActive()) {
                        transaction.rollback();
                    }
                    throw e;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
