package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ActivityDAO;
import br.edu.ifpb.es.daw.dao.GesturesDAO;
import br.edu.ifpb.es.daw.dao.impl.ActivityDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.GesturesDAOImpl;
import br.edu.ifpb.es.daw.entities.Activity;
import br.edu.ifpb.es.daw.entities.Gestures;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.UUID;

public class MainGesturesSave {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            GesturesDAO gesturesDao = new GesturesDAOImpl(emf);
            ActivityDAO activityDao = new ActivityDAOImpl(emf);

            Activity activity = new Activity();
            activity.setId(UUID.randomUUID());
            activity.setActivityName("Atividade para Gestos");
            activityDao.save(activity);

            Gestures gesture = new Gestures();
            gesture.setId(UUID.randomUUID());
            gesture.setTargetTime("10:30:00");
            gesture.setCreatedAt("2023-01-01 10:30:00");
            gesture.setCoordinates("x:100,y:200");
            gesture.setActivity(activity);

            System.out.println("Antes de salvar:");
            System.out.println(gesture);

            gesturesDao.save(gesture);

            System.out.println("\nDepois de salvar:");
            System.out.println(gesture);

            gesture.setCoordinates("x:150,y:250");
            gesturesDao.update(gesture);

            System.out.println("\nDepois de atualizar:");
            System.out.println(gesture);
        }
    }
}