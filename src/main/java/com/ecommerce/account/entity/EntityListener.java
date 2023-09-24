package com.ecommerce.account.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.sql.Timestamp;


/**
 * Entity listener for the all entity in this service.
 * This listener handles the automatic setting of metadata fields such as
 * createdAt, updatedAt, createdBy, and updatedBy.
 *
 * @author [Binh Nguyen Van]
 * @since 2023-09-24
 */
public class EntityListener {

    /**
     * Pre-persist event handler.
     * This method is called before a new record is persisted (saved) to the database.
     * It sets the createdAt and updatedAt timestamps to the current time.
     *
     * @param target The entity that is about to be persisted.
     */
    @PrePersist
    public void prePersist(User target) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        target.setCreatedAt(now);
        target.setUpdatedAt(now);
        // Set createdBy and updatedBy here (create User context in this service or receive context from other service).
    }

    /**
     * Pre-update event handler.
     * This method is called before an existing record is updated in the database.
     * It updates the updatedAt timestamp to the current time.
     *
     * @param target The entity that is about to be updated.
     */
    @PreUpdate
    public void preUpdate(User target) {
        target.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        // Set updatedBy here.
    }
}
