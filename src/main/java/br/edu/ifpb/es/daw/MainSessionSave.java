package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ProjectDAO;
import br.edu.ifpb.es.daw.dao.SessionDAO;
import br.edu.ifpb.es.daw.dao.impl.ProjectDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.SessionDAOImpl;
import br.edu.ifpb.es.daw.entities.Project;
import br.edu.ifpb.es.daw.entities.SessionEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.UUID;

public class MainSessionSave {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            SessionDAO sessionDao = new SessionDAOImpl(emf);
            ProjectDAO projectDao = new ProjectDAOImpl(emf);

            Project project = new Project();
            project.setId(UUID.randomUUID());
            project.setName("Projeto para Sessão");
            projectDao.save(project);

            SessionEntity session = new SessionEntity();
            session.setId(UUID.randomUUID());
            session.setDeviceTime(LocalDateTime.now());
            session.setUploadTime(LocalDateTime.now());
            session.setRecordingTime(LocalDateTime.now());
            session.setProject(project);

            System.out.println("Antes de salvar:");
            System.out.println(session);

            sessionDao.save(session);

            System.out.println("\nDepois de salvar:");
            System.out.println(session);

            session.setUploadTime(LocalDateTime.now().plusHours(1));
            sessionDao.update(session);

            System.out.println("\nDepois de atualizar:");
            System.out.println(session);
        }
    }
}