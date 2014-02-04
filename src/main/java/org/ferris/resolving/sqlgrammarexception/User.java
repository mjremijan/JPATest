/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ferris.resolving.sqlgrammarexception;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Michael
 */
@Entity
@Table(name = "\"user\"")
public class User implements Serializable 
{
    private static final long serialVersionUID = 987369876876987L;

    @EmbeddedId
    UserKey key;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Collection<Address> addresses;

    @Column(name = "email")
    String email;

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserKey getKey() {
        return key;
    }

    public void setKey(UserKey key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 97 * hash + (this.addresses != null ? this.addresses.hashCode() : 0);
        hash = 97 * hash + (this.email != null ? this.email.hashCode() : 0);
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
        final User other = (User) obj;
        if (this.key != other.key && (this.key == null || !this.key.equals(other.key))) {
            return false;
        }
        if (this.addresses != other.addresses && (this.addresses == null || !this.addresses.equals(other.addresses))) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "key=" + key + ", addresses=" + addresses + ", email=" + email + '}';
    }

}
