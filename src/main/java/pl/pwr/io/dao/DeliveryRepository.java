package pl.pwr.io.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pwr.io.model.Delivery;

import java.util.List;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
    public List<Delivery> findAllBySender_Id(Long senderUserId);
}
