package com.revice.mindorder.model.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.Objects;

/**
 * @author pysga
 * @created 30/01/2023 - 9:36 CH
 * @project mind-order-service
 * @since 1.0
 **/
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    protected String id;

    @CreatedDate
    @Column(name = "created_date")
    protected Date createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    protected Date updatedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BaseEntity that = (BaseEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
