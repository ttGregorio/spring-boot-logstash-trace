package br.com.nex2you.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "orders")
@Entity
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Date date;

	private String product;

	private int quantity;

	private double value;

	@Column(name = "payment_code")
	private UUID paymentCode;
}
