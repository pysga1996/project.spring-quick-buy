package com.revice.mindorder.config.general;

import com.github.f4b6a3.ulid.UlidCreator;
import com.revice.mindorder.model.entity.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author pysga
 * @created 30/01/2023 - 9:28 CH
 * @project mind-order-service
 * @since 1.0
 **/
public class CustomAuditingEntityListener extends AuditingEntityListener {

    public void touchForCreate(BaseEntity target) {
        target.setId(UlidCreator.getUlid().toString());
        super.touchForCreate(target);
    }

}
