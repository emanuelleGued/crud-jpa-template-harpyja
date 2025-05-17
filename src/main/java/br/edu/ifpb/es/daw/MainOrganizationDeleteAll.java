package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.OrganizationDAO;
import br.edu.ifpb.es.daw.dao.impl.OrganizationDAOImpl;
import br.edu.ifpb.es.daw.entities.Organization;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainOrganizationDeleteAll {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            OrganizationDAO organizationDAO = new OrganizationDAOImpl(emf);

            List<Organization> allOrganizations = organizationDAO.getAll();
            for (Organization org : allOrganizations) {
                organizationDAO.delete(org.getId());
            }

            System.out.println("Todas as organizações foram excluídas.");
        }
    }
}
