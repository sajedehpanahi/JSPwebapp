package dataAccess.entities;

import dataAccess.entities.MyEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER")
@Inheritance(strategy = InheritanceType.JOINED)
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID", nullable = false, insertable = false, updatable = false, unique = true)
    private int customerId;

    public CustomerEntity(){

    }
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

}
