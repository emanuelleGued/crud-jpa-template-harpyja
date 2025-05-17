package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.UserOrganizationDAO;
import br.edu.ifpb.es.daw.dao.impl.UserOrganizationDAOImpl;
import br.edu.ifpb.es.daw.entities.UserOrganization;
import br.edu.ifpb.es.daw.entities.UserOrganizationId;
import br.edu.ifpb.es.daw.entities.enums.OrganizationRole;
import br.edu.ifpb.es.daw.entities.enums.ProjectRole;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.UUID;

public class MainUserOrganizationSave {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserOrganizationDAO dao = new UserOrganizationDAOImpl(emf);

            UserOrganizationId id = new UserOrganizationId();
            id.setUserId(UUID.randomUUID());
            id.setOrganizationId(UUID.randomUUID());

            UserOrganization userOrg = new UserOrganization();
            userOrg.setId(id);
            userOrg.setRole(OrganizationRole.ADMIN);
            userOrg.setDefaultProjectRole(ProjectRole.DEVELOPER);

            System.out.println("Salvando: " + userOrg);
            dao.save(userOrg);
            System.out.println("Salvo com ID: " + userOrg.getId());
        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }
    }
}
