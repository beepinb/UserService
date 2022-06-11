package com.example.userservice.repository;

import com.example.userservice.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressDAO extends JpaRepository<Address,Long> {

    @Query("Select u.addresses from User u where u.id = ?1")
    List<Address> findAllAddresses(Long id);

    @Query("select a from User u join u.addresses a where u.id=?1 and a.id=?2")
    Address findAddressById(Long userId,Long addressId);


}
