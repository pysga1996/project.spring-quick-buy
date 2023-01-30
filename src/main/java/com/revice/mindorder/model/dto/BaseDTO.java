package com.revice.mindorder.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author pysga
 * @created 30/01/2023 - 9:45 CH
 * @project mind-order-service
 * @since 1.0
 **/
@Data
public class BaseDTO {

    protected String id;

    protected Date createdDate;

    protected Date updatedDate;
}
