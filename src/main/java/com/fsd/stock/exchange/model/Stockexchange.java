// Generated with g9.

package com.fsd.stock.exchange.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="stockexchange", indexes={@Index(name="stockexchange_stock_exchanges_ID_IX", columnList="stock_exchanges_ID", unique=true)})
public class Stockexchange {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="stock_exchanges_ID", unique=true, nullable=false, length=6)
    private String stockExchangesId;
    @Column(name="stock_exchange_brief", length=2000)
    private String stockExchangeBrief;
    @Column(name="contact_address", length=2000)
    private String contactAddress;
    @Column(name="contact_number", length=2000)
    private String contactNumber;
    @Column(length=2000)
    private String remarks;

    /** Default constructor. */
    public Stockexchange() {
        super();
    }
    public Stockexchange(String stockExchangesId, String stockExchangeBrief, String contactAddress, String contactNumber, String remarks) {
        this.stockExchangesId = stockExchangesId;
        this.stockExchangeBrief = stockExchangeBrief;
        this.contactAddress = contactAddress;
        this.contactNumber = contactNumber;
        this.remarks = remarks;
    }

    /**
     * Access method for stockExchangesId.
     *
     * @return the current value of stockExchangesId
     */
    public String getStockExchangesId() {
        return stockExchangesId;
    }

    /**
     * Setter method for stockExchangesId.
     *
     * @param aStockExchangesId the new value for stockExchangesId
     */
    public void setStockExchangesId(String aStockExchangesId) {
        stockExchangesId = aStockExchangesId;
    }

    /**
     * Access method for stockExchangeBrief.
     *
     * @return the current value of stockExchangeBrief
     */
    public String getStockExchangeBrief() {
        return stockExchangeBrief;
    }

    /**
     * Setter method for stockExchangeBrief.
     *
     * @param aStockExchangeBrief the new value for stockExchangeBrief
     */
    public void setStockExchangeBrief(String aStockExchangeBrief) {
        stockExchangeBrief = aStockExchangeBrief;
    }

    /**
     * Access method for contactAddress.
     *
     * @return the current value of contactAddress
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * Setter method for contactAddress.
     *
     * @param aContactAddress the new value for contactAddress
     */
    public void setContactAddress(String aContactAddress) {
        contactAddress = aContactAddress;
    }

    /**
     * Access method for remarks.
     *
     * @return the current value of remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Setter method for remarks.
     *
     * @param aRemarks the new value for remarks
     */
    public void setRemarks(String aRemarks) {
        remarks = aRemarks;
    }

}
