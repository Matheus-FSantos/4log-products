package model.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByLgCode", query = "SELECT p FROM Product p WHERE p.lgCode = :lgCode"),
    @NamedQuery(name = "Product.findByLgName", query = "SELECT p FROM Product p WHERE p.lgName = :lgName"),
    @NamedQuery(name = "Product.findByLgBrand", query = "SELECT p FROM Product p WHERE p.lgBrand = :lgBrand"),
    @NamedQuery(name = "Product.findByLgPrice", query = "SELECT p FROM Product p WHERE p.lgPrice = :lgPrice"),
    @NamedQuery(name = "Product.findByLgcreatedAt", query = "SELECT p FROM Product p WHERE p.lgcreatedAt = :lgcreatedAt")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_code")
    private String lgCode;
    @Basic(optional = false)
    @Column(name = "lg_name")
    private String lgName;
    @Basic(optional = false)
    @Column(name = "lg_brand")
    private String lgBrand;
    @Basic(optional = false)
    @Column(name = "lg_price")
    private double lgPrice;
    @Basic(optional = false)
    @Column(name = "lg_createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lgcreatedAt;

    public Product() {
    }

    public Product(String lgCode) {
        this.lgCode = lgCode;
    }

    public Product(String lgCode, String lgName, String lgBrand, double lgPrice, Date lgcreatedAt) {
        this.lgCode = lgCode;
        this.lgName = lgName;
        this.lgBrand = lgBrand;
        this.lgPrice = lgPrice;
        this.lgcreatedAt = lgcreatedAt;
    }

    public String getLgCode() {
        return lgCode;
    }

    public void setLgCode(String lgCode) {
        this.lgCode = lgCode;
    }

    public String getLgName() {
        return lgName;
    }

    public void setLgName(String lgName) {
        this.lgName = lgName;
    }

    public String getLgBrand() {
        return lgBrand;
    }

    public void setLgBrand(String lgBrand) {
        this.lgBrand = lgBrand;
    }

    public double getLgPrice() {
        return lgPrice;
    }

    public void setLgPrice(double lgPrice) {
        this.lgPrice = lgPrice;
    }

    public Date getLgcreatedAt() {
        return lgcreatedAt;
    }

    public void setLgcreatedAt(Date lgcreatedAt) {
        this.lgcreatedAt = lgcreatedAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgCode != null ? lgCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.lgCode == null && other.lgCode != null) || (this.lgCode != null && !this.lgCode.equals(other.lgCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "lgCode=" + lgCode + ", lgName=" + lgName + ", lgBrand=" + lgBrand + ", lgPrice=" + lgPrice + ", lgcreatedAt=" + lgcreatedAt + '}';
    }    
    
}
