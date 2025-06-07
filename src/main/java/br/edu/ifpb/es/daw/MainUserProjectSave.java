package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.*;
import br.edu.ifpb.es.daw.dao.impl.*;
import br.edu.ifpb.es.daw.entities.*;
import br.edu.ifpb.es.daw.entities.enums.OrganizationStatus;
import br.edu.ifpb.es.daw.entities.enums.ProjectRole;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.UUID;

public class MainUserProjectSave {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserDAO userDao = new UserDAOImpl(emf);
            ProjectDAO projectDao = new ProjectDAOImpl(emf);
            UserProjectDAO userProjectDao = new UserProjectDAOImpl(emf);
            OrganizationDAO organizationDao = new OrganizationDAOImpl(emf);

            Organization organization = new Organization();
            organization.setName("Dunddies");
            organization.setRegistrationDate(LocalDateTime.now());
            organization.setStatus(OrganizationStatus.ACTIVE);
            organization.setBusinessSize("MEDIUM");
            organizationDao.save(organization);

            User user = new User();
            user.setId(UUID.randomUUID());
            user.setName("Jim Halpper");
            user.setEmail("projeto.jim@email.com");
            user.setPassword("*********");
            user.setEmailVerified(true);
            user.setTermsAgreed(true);
            userDao.save(user);

            Project project = new Project();
            project.setId(UUID.randomUUID());
            project.setName("Web Dundies");
            project.setKey("PROJ-001");
            project.setType("DESENVOLVIMENTO");
            project.setExpiration(LocalDateTime.now().plusMonths(6));
            project.setOrganization(organization);
            projectDao.save(project);

            System.out.println("Antes da associação:");
            System.out.println("User: " + user.getId());
            System.out.println("Project: " + project.getId());

            try (EntityManager em = emf.createEntityManager()) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();

                try {
                    User managedUser = em.merge(user);
                    Project managedProject = em.merge(project);

                    UserProjectId userProjectId = new UserProjectId(
                            managedUser.getId(),
                            managedProject.getId());

                    UserProject userProject = new UserProject();
                    userProject.setId(userProjectId);
                    userProject.setRole(ProjectRole.DEVELOPER);
                    userProject.setUser(managedUser);
                    userProject.setProject(managedProject);

                    managedUser.addProject(userProject);
                    managedProject.addUserProject(userProject);

                    em.persist(userProject);
                    transaction.commit();

                    System.out.println("\nDepois da associação:");
                    System.out.println("UserProject: " + userProject.getId());
                    System.out.println("User projects count: " + managedUser.getProjects().size());
                    System.out.println("Project users count: " + managedProject.getUsers().size());

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