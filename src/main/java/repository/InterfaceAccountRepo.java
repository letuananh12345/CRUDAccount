package repository;

import model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface InterfaceAccountRepo extends CrudRepository<Account,Long> {
    @Query(value = "SELECT a FROM Account as a where a.userName like concat('%',:name,'%')")
    public ArrayList<Account> findAllByName(@Param("name") String userName);
}
