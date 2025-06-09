package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ActivityDAO;
import br.edu.ifpb.es.daw.dao.GesturesDAO;
import br.edu.ifpb.es.daw.dao.impl.ActivityDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.GesturesDAOImpl;
import br.edu.ifpb.es.daw.entities.Activity;
import br.edu.ifpb.es.daw.entities.Gestures;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.UUID;

public class MainGesturesSave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            GesturesDAO gesturesDAO = new GesturesDAOImpl(emf);
            ActivityDAO activityDAO = new ActivityDAOImpl(emf);

            List<Activity> activities = activityDAO.getAll();
            if (activities.isEmpty()) {
                System.out.println("Nenhuma atividade encontrada. Crie uma atividade primeiro.");
                return;
            }

            Activity activity = activities.get(0);

            Gestures gesture = new Gestures();
            gesture.setId(UUID.randomUUID());
            gesture.setTargetTime("2025-05-03T12:00:00");
            gesture.setCreatedAt("2025-05-03T12:00:01");
            gesture.setCoordinates("x:10,y:20,z:30");
            gesture.setActivity(activity);
            gesturesDAO.save(gesture);

            System.out.println("Gesto salvo com sucesso: " + gesture.getId());
            System.out.println(gesture);
        }
    }
}
