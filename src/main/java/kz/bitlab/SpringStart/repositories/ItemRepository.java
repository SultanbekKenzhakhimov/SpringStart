package kz.bitlab.SpringStart.repositories;

import jakarta.transaction.Transactional;
import kz.bitlab.SpringStart.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item,Long> {
    Item findAllById(Long id);
}
