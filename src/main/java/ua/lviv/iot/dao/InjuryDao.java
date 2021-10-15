package ua.lviv.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Injury;

@Repository
public interface InjuryDao extends JpaRepository<Injury, Integer> {
}
