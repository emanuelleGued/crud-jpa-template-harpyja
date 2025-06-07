package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AddressDAO;
import br.edu.ifpb.es.daw.dao.OrganizationDAO;
import br.edu.ifpb.es.daw.dao.UserDAO;
import br.edu.ifpb.es.daw.dao.UserOrganizationDAO;
import br.edu.ifpb.es.daw.dao.impl.AddressDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.OrganizationDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UserDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.UserOrganizationDAOImpl;
import br.edu.ifpb.es.daw.entities.Address;
import br.edu.ifpb.es.daw.entities.Organization;
import br.edu.ifpb.es.daw.entities.User;
import br.edu.ifpb.es.daw.entities.UserOrganization;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainUserOrganizationDeleteAll {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            AddressDAO addressDao = new AddressDAOImpl(emf);
            UserOrganizationDAO userOrganizationDao = new UserOrganizationDAOImpl(emf);
            UserDAO userDao = new UserDAOImpl(emf);
            OrganizationDAO organizationDao = new OrganizationDAOImpl(emf);

            List<UserOrganization> userOrganizations = userOrganizationDao.getAll();
            System.out.println("Deletando " + userOrganizations.size() + " associações UserOrganization");
            for (UserOrganization userOrganization : userOrganizations) {
                userOrganizationDao.delete(userOrganization.getId());
            }

            List<Address> addresses = addressDao.getAll();
            System.out.println("Deletando " + addresses.size() + " endereços");
            for (Address address : addresses) {
                addressDao.delete(address.getId());
            }

            List<User> users = userDao.getAll();
            System.out.println("Deletando " + users.size() + " usuários");
            for (User user : users) {
                userDao.delete(user.getId());
            }

            List<Organization> organizations = organizationDao.getAll();
            System.out.println("Deletando " + organizations.size() + " organizações");
            for (Organization organization : organizations) {
                organizationDao.delete(organization.getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}