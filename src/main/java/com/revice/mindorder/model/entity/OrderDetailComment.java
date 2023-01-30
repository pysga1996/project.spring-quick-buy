package com.revice.mindorder.model.entity;

import com.revice.mindorder.config.general.CustomAuditingEntityListener;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OrderDetailComment")
@Table(name = "order_detail_comment")
@EntityListeners(CustomAuditingEntityListener.class)
public class OrderDetailComment extends BaseEntity {

    @Column(name = "order_detail_id", nullable = false)
    private String orderDetailId;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "review", nullable = false)
    private String review;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderDetailComment that = (OrderDetailComment) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
