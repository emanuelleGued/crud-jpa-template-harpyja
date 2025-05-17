package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AddressDAO;
import br.edu.ifpb.es.daw.dao.impl.AddressDAOImpl;
import br.edu.ifpb.es.daw.entities.Address;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainAddressDeleteAll {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            AddressDAO addressDAO = new AddressDAOImpl(emf);
            List<Address> addresses = addressDAO.getAll();
            for (Address address : addresses) {
                addressDAO.delete(address.getId());
            }
        }
    }
}
