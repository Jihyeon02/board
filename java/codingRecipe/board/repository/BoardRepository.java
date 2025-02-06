package codingRecipe.board.repository;

import codingRecipe.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
    // (sql 기준) update board_table set board_hits = board_hits+1 where id=? : 기준의 조회수 값에서 하나 올리는 문
    @Modifying // update나 delete 쿼리를 실행해야 될 떄는 추가적으로  필수로 붙이는 어노테이션
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.id = :id") // Entity기준으로 쿼리 작성 (이떄 약어를 쓰는게 필수)
    void updateHits(@Param("id") Long id);
}
