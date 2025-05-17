package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.RoleDAO;
import br.edu.ifpb.es.daw.dao.impl.RoleDAOImpl;
import br.edu.ifpb.es.daw.entities.Role;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.UUID;

public class MainRoleSave {
    public static void main(String[] args) throws PersistenciaDawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            RoleDAO dao = new RoleDAOImpl(emf);

            Role role = new Role();
            role.setId(UUID.randomUUID());
            role.setName("Admin-" + System.currentTimeMillis()); // Nome único
            role.setDescription("Administrator role with full access");
            role.setType("SYSTEM");
            role.setDefaultProjectRoleId("ADMIN");

            System.out.println("Salvando: " + role);
            dao.save(role);
            System.out.println("Salvo com ID: " + role.getId());
        }
    }
}