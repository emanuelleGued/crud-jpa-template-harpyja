package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.ProjectDAO;
import br.edu.ifpb.es.daw.dao.SessionDAO;
import br.edu.ifpb.es.daw.dao.impl.ProjectDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.SessionDAOImpl;
import br.edu.ifpb.es.daw.entities.Activity;
import br.edu.ifpb.es.daw.entities.Project;
import br.edu.ifpb.es.daw.entities.SessionEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class MainSessionSave {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            SessionDAO dao = new SessionDAOImpl(emf);
            ProjectDAO projectDAO = new ProjectDAOImpl(emf);

            List<Project> projects = projectDAO.getAll();
            if (projects.isEmpty()) {
                System.out.println("Nenhum projeto encontrada. Crie um projeto primeiro.");
                return;
            }

            Project project = projects.get(0);

            if (project.getUsers() != null) {
                project.getUsers().size();
            }

            SessionEntity session = new SessionEntity();
            session.setId(UUID.randomUUID());
            session.setDeviceTime(LocalDateTime.now());
            session.setUploadTime(LocalDateTime.now());
            session.setRecordingTime(LocalDateTime.now());
            session.setProject(project);

            Activity activity1 = new Activity();
            activity1.setId(UUID.randomUUID());
            activity1.setActivityName("Activity 1");
            activity1.setCreatedAt(LocalDateTime.now());
            activity1.setUpdatedAt(LocalDateTime.now());

            Activity activity2 = new Activity();
            activity2.setId(UUID.randomUUID());
            activity2.setActivityName("Activity 2");
            activity2.setCreatedAt(LocalDateTime.now());
            activity2.setUpdatedAt(LocalDateTime.now());

            session.addActivity(activity1);
            session.addActivity(activity2);

            System.out.println("Antes de salvar:");
            System.out.println(session);
            System.out.println(activity1);
            System.out.println(activity2);

            dao.save(session);

            System.out.println("\nDepois de salvar:");
            System.out.println(session);
            System.out.println(activity1);
            System.out.println(activity2);
        }
    }
}
