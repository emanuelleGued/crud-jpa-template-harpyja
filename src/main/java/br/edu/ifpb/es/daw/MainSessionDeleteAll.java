package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.SessionDAO;
import br.edu.ifpb.es.daw.dao.impl.SessionDAOImpl;
import br.edu.ifpb.es.daw.entities.SessionEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainSessionDeleteAll {

    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            SessionDAO dao = new SessionDAOImpl(emf);

            List<SessionEntity> sessions = dao.getAll();
            for (SessionEntity session : sessions) {
                dao.delete(session.getId());
            }

            System.out.println("Todas as sessions foram removidas. Total: " + sessions.size());
        }
    }
}
