package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ActivityDAO;
import br.edu.ifpb.es.daw.dao.SessionDAO;
import br.edu.ifpb.es.daw.dao.impl.ActivityDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.SessionDAOImpl;
import br.edu.ifpb.es.daw.entities.Activity;
import br.edu.ifpb.es.daw.entities.SessionEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class MainActivitySave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            ActivityDAO activityDAO = new ActivityDAOImpl(emf);
            SessionDAO sessionDAO = new SessionDAOImpl(emf);

            List<SessionEntity> sessions = sessionDAO.getAll();
            if (sessions.isEmpty()) {
                System.out.println("Nenhuma sessão encontrada. Crie uma sessão primeiro.");
                return;
            }

            SessionEntity session = sessions.get(0);

            Activity activity = new Activity();
            activity.setId(UUID.randomUUID());
            activity.setActivityName("Atividade Teste - " + UUID.randomUUID());
            activity.setCreatedAt(LocalDateTime.now());
            activity.setUpdatedAt(LocalDateTime.now());

            System.out.println(activity);

            activityDAO.save(activity);

            System.out.println(activity);
        }
    }
}
