package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.ProjectDAO;
import br.edu.ifpb.es.daw.entities.Project;
import jakarta.persistence.EntityManagerFactory;

import java.util.UUID;

public class ProjectDAOImpl extends AbstractDAOImpl<Project, UUID> implements ProjectDAO {
    public ProjectDAOImpl(EntityManagerFactory emf) {
        super(Project.class, emf);
    }
}
