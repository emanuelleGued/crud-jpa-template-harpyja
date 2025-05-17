package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.GesturesDAO;
import br.edu.ifpb.es.daw.dao.impl.GesturesDAOImpl;
import br.edu.ifpb.es.daw.entities.Gestures;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainGesturesDeleteAll {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            GesturesDAO gesturesDAO = new GesturesDAOImpl(emf);
            List<Gestures> gesturesList = gesturesDAO.getAll();
            for (Gestures gesture : gesturesList) {
                gesturesDAO.delete(gesture.getId());
            }
            System.out.println("Todos os gestos foram excluídos.");
        }
    }
}
