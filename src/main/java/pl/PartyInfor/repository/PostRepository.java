package pl.PartyInfor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.PartyInfor.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	
	List<Post> findByUserId(Long userId);
	List<Post> findByDistrictId(long i);
	
}
