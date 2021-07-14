package am.demo.product.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
public class AuditEntity {

    @CreatedDate
    @Column(name = "creation_dt")
    private LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "last_update_dt")
    private LocalDateTime lastUpdatedDate;
}