package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.RoleDAO;
import br.edu.ifpb.es.daw.dao.impl.RoleDAOImpl;
import br.edu.ifpb.es.daw.entities.Role;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.UUID;

public class MainRoleSave {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            RoleDAO roleDao = new RoleDAOImpl(emf);

            Role role = new Role();
            role.setId(UUID.randomUUID());
            role.setName("Admin");
            role.setDescription("Administrador do sistema");
            role.setType("SYSTEM");
            role.setDefaultProjectRoleId("PROJ-ADMIN");

            System.out.println("Antes de salvar:");
            System.out.println(role);

            roleDao.save(role);

            System.out.println("\nDepois de salvar:");
            System.out.println(role);

            role.setDescription("Administrador com todos os privilégios");
            role = roleDao.update(role);

            System.out.println("\nDepois de atualizar:");
            System.out.println(role);
        }
    }
}