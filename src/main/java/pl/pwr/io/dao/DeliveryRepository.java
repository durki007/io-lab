package pl.pwr.io.dao;

import org.springframework.data.repository.CrudRepository;
import pl.pwr.io.model.Delivery;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
