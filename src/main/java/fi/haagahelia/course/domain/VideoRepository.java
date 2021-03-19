package fi.haagahelia.course.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long>  {
    
	List<Video> findByName(String name);
}

