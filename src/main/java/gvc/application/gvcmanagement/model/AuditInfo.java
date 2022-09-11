package gvc.application.gvcmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"create_at", "update_at"}, allowGetters = true)
public class AuditInfo {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at", updatable = false)
    @CreatedDate
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at", updatable = false)
    @LastModifiedDate
    private Date updateAt;

    @Column(name = "create_by")
    @CreatedBy
    private String createBy;

    @Column(name = "updated_by")
    @LastModifiedBy
    private String updateBy;
}
