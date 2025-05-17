package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.ProjectDAO;
import br.edu.ifpb.es.daw.dao.OrganizationDAO;
import br.edu.ifpb.es.daw.dao.impl.ProjectDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.OrganizationDAOImpl;
import br.edu.ifpb.es.daw.entities.Organization;
import br.edu.ifpb.es.daw.entities.Project;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.UUID;

public class MainProjectSave {

    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            ProjectDAO projectDAO = new ProjectDAOImpl(emf);
            OrganizationDAO organizationDAO = new OrganizationDAOImpl(emf);

            Organization organization = organizationDAO.getAll().stream().findFirst()
                    .orElseThrow(() -> new DawException("Nenhuma organização encontrada."));

            Project project = new Project();
            project.setId(UUID.randomUUID());
            project.setName("Projeto Exemplo");
            project.setKey("EX123");
            project.setType("Pesquisa");
            project.setExpiration(LocalDateTime.now().plusMonths(6));

            projectDAO.save(project);

            System.out.println("Projeto salvo com sucesso: " + project.getId());
        }
    }
}
