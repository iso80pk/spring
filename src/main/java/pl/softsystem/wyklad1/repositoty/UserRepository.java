package pl.softsystem.wyklad1.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.softsystem.wyklad1.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
