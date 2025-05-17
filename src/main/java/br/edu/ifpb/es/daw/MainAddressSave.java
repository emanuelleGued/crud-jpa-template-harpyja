package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AddressDAO;
import br.edu.ifpb.es.daw.dao.OrganizationDAO;
import br.edu.ifpb.es.daw.dao.impl.AddressDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.OrganizationDAOImpl;
import br.edu.ifpb.es.daw.entities.Address;
import br.edu.ifpb.es.daw.entities.Organization;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.UUID;

public class MainAddressSave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            AddressDAO addressDAO = new AddressDAOImpl(emf);
            OrganizationDAO organizationDAO = new OrganizationDAOImpl(emf);

            List<Organization> organizations = organizationDAO.getAll();
            if (organizations.isEmpty()) {
                System.out.println("Nenhuma organização encontrada. Crie uma organização primeiro.");
                return;
            }

            Organization organization = organizations.get(0);

            Address address = new Address();
            address.setId(UUID.randomUUID());
            address.setCountry("Brasil");
            address.setCity("João Pessoa");
            address.setStreet("Rua das Flores");
            address.setZip("58000-000");

            System.out.println(address);

            addressDAO.save(address);

            System.out.println(address);
        }
    }
}
