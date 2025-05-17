package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.UserOrganizationDAO;
import br.edu.ifpb.es.daw.dao.impl.UserOrganizationDAOImpl;
import br.edu.ifpb.es.daw.entities.UserOrganization;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainUserOrganizationDeleteAll {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserOrganizationDAO dao = new UserOrganizationDAOImpl(emf);
            List<UserOrganization> list = dao.getAll();

            System.out.println("Encontrados " + list.size() + " registros para remover");
            for (UserOrganization userOrg : list) {
                dao.delete(userOrg.getId());
            }
            System.out.println("Todos os registros removidos");
        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }
    }
}