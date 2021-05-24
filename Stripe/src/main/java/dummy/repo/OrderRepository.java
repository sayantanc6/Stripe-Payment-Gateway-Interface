package dummy.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dummy.entity.StripeEntity;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<StripeEntity, String> {

}
