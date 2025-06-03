package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AddressDAO;
import br.edu.ifpb.es.daw.dao.OrganizationDAO;
import br.edu.ifpb.es.daw.dao.impl.AddressDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.OrganizationDAOImpl;
import br.edu.ifpb.es.daw.entities.Address;
import br.edu.ifpb.es.daw.entities.Organization;
import br.edu.ifpb.es.daw.entities.enums.OrganizationStatus;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.UUID;

public class MainAddressSave {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            AddressDAO addressDao = new AddressDAOImpl(emf);
            OrganizationDAO orgDao = new OrganizationDAOImpl(emf);

            Organization org = new Organization();
            org.setId(UUID.randomUUID());
            org.setName("Organização com Endereço");
            org.setRegistrationDate(LocalDateTime.now());
            org.setStatus(OrganizationStatus.ACTIVE);
            org.setBusinessSize("MEDIUM");

            Address address = new Address();
            address.setId(UUID.randomUUID());
            address.setCountry("Brasil");
            address.setCity("João Pessoa");
            address.setStreet("Rua Exemplo, 123");
            address.setZip("58000-000");
            address.setOrganization(org);

            System.out.println("Antes de salvar:");
            System.out.println("Organização: " + org);
            System.out.println("Endereço: " + address);

            orgDao.save(org);

            addressDao.save(address);

            System.out.println("\nDepois de salvar:");
            System.out.println("Organização: " + org);
            System.out.println("Endereço: " + address);

            org = orgDao.update(org);

            System.out.println("\nDepois de atualizar a organização:");
            System.out.println("Organização: " + org);
            System.out.println("Endereço: " + address);
        }
    }
}