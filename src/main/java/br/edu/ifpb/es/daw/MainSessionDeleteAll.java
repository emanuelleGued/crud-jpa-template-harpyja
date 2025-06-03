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
                SessionDAO sessionDao = new SessionDAOImpl(emf);

                System.out.println("Deletando todas as Sessions...");
                List<SessionEntity> sessions = sessionDao.getAll();
                for (SessionEntity session : sessions) {
                    System.out.println("Deletando Session: " + session.getId() +
                            " - Project: " + (session.getProject() != null ? session.getProject().getId() : "null"));
                    sessionDao.delete(session.getId());
                }
                System.out.println("Todas as Sessions foram deletadas. Total: " + sessions.size());
            }
        }
}
