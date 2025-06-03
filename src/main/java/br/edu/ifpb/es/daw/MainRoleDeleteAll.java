package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.RoleDAO;
import br.edu.ifpb.es.daw.dao.impl.RoleDAOImpl;
import br.edu.ifpb.es.daw.entities.Role;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainRoleDeleteAll {
    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            RoleDAO roleDao = new RoleDAOImpl(emf);

            System.out.println("Deletando todas as Roles...");
            List<Role> roles = roleDao.getAll();
            for (Role role : roles) {
                System.out.println("Deletando Role: " + role.getId() + " - " + role.getName());
                roleDao.delete(role.getId());
            }
            System.out.println("Todas as Roles foram deletadas. Total: " + roles.size());
        }
    }
}