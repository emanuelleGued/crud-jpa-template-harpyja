package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.UserProjectDAO;
import br.edu.ifpb.es.daw.dao.impl.UserProjectDAOImpl;
import br.edu.ifpb.es.daw.entities.UserProject;
import br.edu.ifpb.es.daw.entities.UserProjectId;
import br.edu.ifpb.es.daw.entities.enums.ProjectRole;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.UUID;

public class MainUserProjectSave {
    public static void main(String[] args) throws PersistenciaDawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserProjectDAO dao = new UserProjectDAOImpl(emf);

            UserProjectId id = new UserProjectId();
            id.setUserId(UUID.randomUUID());
            id.setProjectId(UUID.randomUUID());

            UserProject userProject = new UserProject();
            userProject.setId(id);
            userProject.setRole(ProjectRole.MANAGER);

            System.out.println("Salvando: " + userProject);
            dao.save(userProject);
            System.out.println("Salvo com ID: " + userProject.getId());
        }
    }
}