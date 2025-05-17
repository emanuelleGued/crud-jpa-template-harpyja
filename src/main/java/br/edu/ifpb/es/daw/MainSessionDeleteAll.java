package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.SessionDAO;
import br.edu.ifpb.es.daw.dao.impl.SessionDAOImpl;
import br.edu.ifpb.es.daw.entities.SessionEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainSessionDeleteAll {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            SessionDAO sessionDAO = new SessionDAOImpl(emf);

            List<SessionEntity> sessions = sessionDAO.getAll();
            for (SessionEntity session : sessions) {
                sessionDAO.delete(session.getId());
            }

            System.out.println("Todas as sessões foram excluídas.");
        }
    }
}
