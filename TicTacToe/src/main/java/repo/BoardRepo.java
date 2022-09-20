package repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Board;

@Repository
public interface BoardRepo extends JpaRepository<Board, Long>{
	
	public Board findById(int id);

}
