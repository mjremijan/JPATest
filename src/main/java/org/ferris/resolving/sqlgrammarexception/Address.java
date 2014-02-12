/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ferris.resolving.sqlgrammarexception;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Michael
 */
@Entity
@Table(name = "app_address")
public class Address implements Serializable 
{
    private static final long serialVersionUID = 1987458724098L;

    @EmbeddedId
    AddressKey key;

    @Column(name = "type")
    private String type;

@ManyToOne(optional=false, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
@JoinColumns({
    @JoinColumn(name="last_name", referencedColumnName="last_name", insertable=false, updatable=false),
    @JoinColumn(name="zip_code",  referencedColumnName="zip_code",  insertable=false, updatable=false),
    @JoinColumn(name="birthday",  referencedColumnName="birthday",  insertable=false, updatable=false)
})    
private User user;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AddressKey getKey() {
        return key;
    }

    public void setKey(AddressKey key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 71 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 71 * hash + (this.user != null ? this.user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (this.key != other.key && (this.key == null || !this.key.equals(other.key))) {
            return false;
        }
        if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
            return false;
        }
        if (this.user != other.user && (this.user == null || !this.user.equals(other.user))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "key=" + key + ", type=" + type + ", user=" + user + '}';
    }
}
