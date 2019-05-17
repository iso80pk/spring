package pl.softsystem.wyklad1.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.softsystem.wyklad1.model.Organization;

public interface OrganizationRepo  extends JpaRepository<Organization, Long> {

}
