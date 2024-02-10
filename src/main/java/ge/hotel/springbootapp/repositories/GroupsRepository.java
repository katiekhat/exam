package ge.hotel.springbootapp.repositories;

import ge.hotel.springbootapp.entities.Groups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, Integer> {
}
