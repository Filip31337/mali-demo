package com.filip.malidemo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "note")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Note implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

	@NotBlank
    private String content;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
		
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
    //@Column(name = "kreirano_na")
    //private String createdAt;
	
    //@Column(name = "updateano_na")
    //private String updatedAt;

	public String getContent() {
		return content;
	}

	//public Date getCreatedAt() {
	//	return createdAt;
	//}

    public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	//novo
	//public String getUpdatedAt() {
	//	return updatedAt;
	//}
	
    public void setContent(String content) {
		this.content = content;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
    
    //novo
    //public void setCreatedAt(String createdAt) {
    //	this.createdAt = createdAt;
    //}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	//novo
	//public void setUpdatedAt(String updatedAt) {
	//	this.updatedAt = updatedAt;
	//}

    // Getters and Setters ... (Omitted for brevity) 
	// ja sam dodao svoje 
}
