package io.pykmi.pma.dao;

import io.pykmi.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
