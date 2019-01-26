package Repository;

import Entity.TA_UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TA_UserRepository extends JpaRepository<TA_UserEntity, Long> {
}
