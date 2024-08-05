package pastpractice.springmvc.repsoitory;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface MemberRepository extends Repository {

    public void findById(Long id);

    public List<Integer> findAll();

}
