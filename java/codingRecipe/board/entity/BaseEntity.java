package codingRecipe.board.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
    @CreationTimestamp
    @Column(updatable = false) // 수정시에는 관여 안함.
    private LocalDateTime createdTime;// 생성시 시간

    @UpdateTimestamp
    @Column(insertable = false) // 입력시 관여 안함.
    private LocalDateTime updatedTime; // update시 시간
}
