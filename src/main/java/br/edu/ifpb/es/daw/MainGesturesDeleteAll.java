package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.GesturesDAO;
import br.edu.ifpb.es.daw.dao.impl.GesturesDAOImpl;
import br.edu.ifpb.es.daw.entities.Gestures;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainGesturesDeleteAll {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            GesturesDAO gesturesDao = new GesturesDAOImpl(emf);

            System.out.println("Deletando todos os Gestures...");
            List<Gestures> gesturesList = gesturesDao.getAll();
            for (Gestures gesture : gesturesList) {
                System.out.println("Deletando Gesture: " + gesture.getId() +
                        " - Activity: " + (gesture.getActivity() != null ? gesture.getActivity().getId() : "null"));
                gesturesDao.delete(gesture.getId());
            }
            System.out.println("Todos os Gestures foram deletados. Total: " + gesturesList.size());
        }
    }
}
