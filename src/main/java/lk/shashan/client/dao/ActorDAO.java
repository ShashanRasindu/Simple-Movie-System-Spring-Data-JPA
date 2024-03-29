package lk.shashan.client.dao;

import lk.shashan.client.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActorDAO extends JpaRepository<Actor,Integer> {
    public Actor getActorById(int id);

    @Query(value = "select id from actor order by id desc limit 1",nativeQuery = true)
    public int getOrderByIdDesc();
}
