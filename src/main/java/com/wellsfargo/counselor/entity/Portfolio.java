package com.wellsfargo.counselor.entity;

import java.util.List;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue()
    private long portfolioId;

    @OneToOne // Under the assumption that each client has one portfolio
    @JoinColumn(name="client_id")
    private Client owner;

    @Column(nullable=false)
    private final Date creationDate;

    @OneToMany(mappedBy = "portfolio")
    private List<Security> securities;

    public Portfolio(Client owner, Date creationDate, List<Security> securities){
        this.owner = owner;
        this.creationDate = creationDate;
        this.securities = securities;
    }
    public Client getOwner(){
        return owner;
    }
    public void setOwner(Client owner){
        this.owner = owner;
    }

    public Date getCreationDate(){
        return creationDate;
    }
    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
