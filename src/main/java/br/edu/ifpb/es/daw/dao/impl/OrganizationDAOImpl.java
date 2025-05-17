package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.OrganizationDAO;
import br.edu.ifpb.es.daw.entities.Organization;
import jakarta.persistence.EntityManagerFactory;

import java.util.UUID;

public class OrganizationDAOImpl extends AbstractDAOImpl<Organization, UUID> implements OrganizationDAO {
    public OrganizationDAOImpl(EntityManagerFactory emf) {
        super(Organization.class, emf);
    }
}
