package SleepTeam.TicTacToe.Repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import SleepTeam.TicTacToe.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
    User findById(long userId);

    User findByUsername(String username);
    @Transactional
    @Modifying
    @Query(value="UPDATE User u SET wins=wins+1 WHERE u.username=  ?1")
    int updateWinPlusOne(String username);
    @Transactional
    @Modifying
    @Query(value="UPDATE User u SET losses=losses+1 WHERE u.username=  ?1")
    int updateLossPlusOne(String username);
}
//@Query(value="UPDATE user u SET WINS=WINS+1 WHERE u.username=  ?1")
//@Query(value="SELECT u FROM User u WHERE u.username = ?1")
