package net.morena.esa.entity.base;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unique_id")
    private Long uniqueId;

    @Setter(AccessLevel.NONE)
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "created_timestamp")
    @CreationTimestamp
    private LocalDateTime createdTimestamp;

    @Column(name = "modified_timestamp")
    @UpdateTimestamp
    private LocalDateTime modifiedTimestamp;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity baseModelEntity = (BaseEntity) o;
        return Objects.equals(uuid, baseModelEntity.uuid);
    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }

    @PrePersist
    private void init (){
        if (this.isDeleted == null)
            this.isDeleted = false;
        if (this.createdTimestamp == null)
            this.createdTimestamp = LocalDateTime.now();
        if (this.modifiedTimestamp == null)
            this.modifiedTimestamp = this.createdTimestamp;
        if (this.uuid == null)
            this.uuid = UUID.randomUUID();
    }

}