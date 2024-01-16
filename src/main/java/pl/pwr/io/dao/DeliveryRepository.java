package pl.pwr.io.dao;

import org.springframework.data.repository.CrudRepository;
import pl.pwr.io.model.Delivery;

import java.util.List;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
    public List<Delivery> findBySender_UserId(Long senderUserId);
}
