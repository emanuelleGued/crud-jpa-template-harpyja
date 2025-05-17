package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.OrganizationDAO;
import br.edu.ifpb.es.daw.dao.impl.OrganizationDAOImpl;
import br.edu.ifpb.es.daw.entities.Organization;
import br.edu.ifpb.es.daw.entities.enums.OrganizationStatus;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.UUID;

public class MainOrganizationSave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            OrganizationDAO organizationDAO = new OrganizationDAOImpl(emf);

            Organization organization = new Organization();
            organization.setId(UUID.randomUUID());
            organization.setName("Exemplo Corp");
            organization.setRegistrationDate(LocalDateTime.now());
            organization.setStatus(OrganizationStatus.ACTIVE);
            organization.setBusinessSize("Média");

            organizationDAO.save(organization);

            System.out.println("Organização salva com sucesso: " + organization.getId());
        }
    }
}
