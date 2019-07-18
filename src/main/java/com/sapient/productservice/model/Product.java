package com.sapient.productservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "Product")
public class Product implements Serializable
{
@Id
@XmlElement
@Column(name="id")
private int id;
@XmlElement


@Column(name="name")
private String name;

@XmlElement


@Column(name="price")
private double price;
public Product(int id, String name, double price) {
	
	this.id = id;
	this.name = name;
	this.price = price;
}
public Product()
{}

}
