package model.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Tim on 16.11.2015.
 */
@Entity
@Table(name = "CATEGORY")
public class Category implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
