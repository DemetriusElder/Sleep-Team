package repo;

import org.springframework.stereotype.Repository;

import model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	public User findById(int id);
}
