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
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            SessionDAO sessionDAO = new SessionDAOImpl(emf);
            ProjectDAO projectDAO = new ProjectDAOImpl(emf);

            Project project = projectDAO.getAll().stream().findFirst()
                    .orElseThrow(() -> new DawException("Nenhum projeto encontrado."));

            SessionEntity session = new SessionEntity();
            session.setId(UUID.randomUUID());
            session.setDeviceTime(LocalDateTime.now().minusHours(1));
            session.setUploadTime(LocalDateTime.now());
            session.setRecordingTime(LocalDateTime.now().minusMinutes(30));

            sessionDAO.save(session);

            System.out.println("Sessão salva com sucesso: " + session.getId());
        }
    }
}
