package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.UserProjectDAO;
import br.edu.ifpb.es.daw.dao.impl.UserProjectDAOImpl;
import br.edu.ifpb.es.daw.entities.UserProject;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MainUserProjectDeleteAll {
    public static void main(String[] args) throws PersistenciaDawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UserProjectDAO dao = new UserProjectDAOImpl(emf);
            List<UserProject> list = dao.getAll();

            System.out.println("Encontrados " + list.size() + " registros para remover");
            for (UserProject userProject : list) {
                dao.delete(userProject.getId());
            }
            System.out.println("Todos os registros removidos");
        }
    }
}