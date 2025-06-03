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
import java.util.UUID;

public class MainActivitySave {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            ActivityDAO activityDao = new ActivityDAOImpl(emf);
            SessionDAO sessionDao = new SessionDAOImpl(emf);

            // Criando a sessão
            SessionEntity session = new SessionEntity();
            session.setId(UUID.randomUUID());
            session.setDeviceTime(LocalDateTime.now());
            sessionDao.save(session);

            // Criando a atividade
            Activity activity = new Activity();
            activity.setId(UUID.randomUUID());
            activity.setActivityName("Atividade Teste");
            activity.setCreatedAt(LocalDateTime.now());
            activity.setUpdatedAt(LocalDateTime.now());
            activity.setSession(session);

            System.out.println("Antes de salvar:");
            System.out.println(activity);

            // Salvando a atividade
            activityDao.save(activity);

            System.out.println("\nDepois de salvar:");
            System.out.println(activity);

            // Adicionando a atividade à sessão
            session.getActivities().add(activity);
            sessionDao.update(session);

            System.out.println("\nDepois de associar à sessão:");
            System.out.println(activity);
            System.out.println("Sessão: " + session);
        }
    }
}