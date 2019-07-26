package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	
	private Date raiseDate;
	
	@ManyToOne
	@JoinColumn(name="raised_employee_email")
	private Employee raisedBy; 
	
	@ManyToOne
	@JoinColumn(name="resolved_employee_email")
	private Employee resolvedBy;
	
	private Date resolvedDate;
	
	private String resolvedInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRaiseDate() {
		return raiseDate;
	}

	public void setRaiseDate(Date raiseDate) {
		this.raiseDate = raiseDate;
	}

	public Employee getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(Employee e) {
		this.raisedBy = e;
	}

	public Employee getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(Employee resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public Date getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getResolvedInfo() {
		return resolvedInfo;
	}

	public void setResolvedInfo(String resolvedInfo) {
		this.resolvedInfo = resolvedInfo;
	}
	
	
}
