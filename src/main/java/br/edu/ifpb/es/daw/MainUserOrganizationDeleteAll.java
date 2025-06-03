package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.UserOrganizationDAO;
import br.edu.ifpb.es.daw.dao.impl.UserOrganizationDAOImpl;
import br.edu.ifpb.es.daw.entities.UserOrganization;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainUserOrganizationDeleteAll {
    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserOrganizationDAO userOrganizationDao = new UserOrganizationDAOImpl(emf);

            System.out.println("Deletando todas as UserOrganizations...");
            List<UserOrganization> userOrganizations = userOrganizationDao.getAll();
            for (UserOrganization userOrg : userOrganizations) {
                System.out.println("Deletando UserOrganization: " + userOrg.getId());
                userOrganizationDao.delete(userOrg.getId());
            }
            System.out.println("Todas as UserOrganizations foram deletadas. Total: " + userOrganizations.size());
        }
    }
}