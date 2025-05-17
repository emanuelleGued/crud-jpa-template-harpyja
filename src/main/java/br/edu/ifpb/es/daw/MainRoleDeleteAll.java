package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.RoleDAO;
import br.edu.ifpb.es.daw.dao.impl.RoleDAOImpl;
import br.edu.ifpb.es.daw.entities.Role;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainRoleDeleteAll {
    public static void main(String[] args) throws PersistenciaDawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            RoleDAO dao = new RoleDAOImpl(emf);
            List<Role> roles = dao.getAll();

            System.out.println("Encontrados " + roles.size() + " registros para remover");
            for (Role role : roles) {
                dao.delete(role.getId());
            }
            System.out.println("Todos os registros de Role removidos");
        }
    }
}