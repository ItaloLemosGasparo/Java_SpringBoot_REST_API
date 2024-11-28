package dev.SpringBootAPI.ECommerce.repositories;

import dev.SpringBootAPI.ECommerce.models.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByUserId(Long userId);
}
