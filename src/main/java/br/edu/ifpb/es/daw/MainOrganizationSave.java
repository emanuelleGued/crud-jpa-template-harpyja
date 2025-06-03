package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.OrganizationDAO;
import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.dao.impl.OrganizationDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UserDAOImpl;
import br.edu.ifpb.es.daw.entities.Organization;
import br.edu.ifpb.es.daw.entities.Project;
import br.edu.ifpb.es.daw.entities.User;
import br.edu.ifpb.es.daw.entities.UserOrganization;
import br.edu.ifpb.es.daw.entities.enums.OrganizationStatus;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class MainOrganizationSave {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            OrganizationDAO orgDao = new OrganizationDAOImpl(emf);
            UserDAO userDao = new UserDAOImpl(emf);

            // Criar organização
            Organization org = new Organization();
            org.setId(UUID.randomUUID());
            org.setName("Nome da Organização");
            org.setRegistrationDate(LocalDateTime.now());
            org.setStatus(OrganizationStatus.ACTIVE);
            org.setBusinessSize("MEDIUM");
            org.setProjects(new ArrayList<>());
            org.setUsers(new ArrayList<>());

            // Criar e associar um projeto
            Project project = new Project();
            project.setId(UUID.randomUUID());
            project.setName("Projeto Principal");
            project.setOrganization(org);
            org.getProjects().add(project);

            // Criar e associar um usuário
            User user = new User();
            user.setId(UUID.randomUUID());
            user.setName("Gerente da Organização");
            user.setEmail("gerente@org.com");
            user.setPassword("senha123");
            user.setEmailVerified(true);
            user.setTermsAgreed(true);
            user.setOrganizations(new ArrayList<>());

            userDao.save(user);

            UserOrganization userOrg = new UserOrganization();
            userOrg.setUser(user);
            userOrg.setOrganization(org);

            org.addUserOrganization(userOrg);
            user.addOrganization(userOrg);

            System.out.println("Antes de salvar:");
            System.out.println(org);

            orgDao.save(org);

            System.out.println("\nDepois de salvar:");
            System.out.println(org);

            System.out.println("\nProjetos associados: " + org.getProjects().size());
            System.out.println("Usuários associados: " + org.getUsers().size());
        }
    }
}