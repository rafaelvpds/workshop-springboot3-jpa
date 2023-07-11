package com.rvweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rvweb.course.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
//muitos pedidos para 1 cliente
	// o lado do muito esta no pedido
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant instant;

	private Integer orderStatus;

	@ManyToOne
	// dentro do parenteses vou falar o nome da chave estrangeira que vai ter dentro
	// do banco de dados
	@JoinColumn(name = "client_id")
	private User client;

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();

	public Order() {
	}

	public Order(Long id, Instant instant, OrderStatus orderStatus, User client) {
		this.id = id;
		this.instant = instant;
		setOrderStatus(orderStatus);
		this.client = client;

	}

//Tem que retorna um objeto Order Status
	// Para converter o numero inteiro para OrderStatus vou usar o metodo
	// implementado na classe OrderStatus
	public OrderStatus getOrderStatus() {
		// pegando o numero inteiro Interno da classe e convertendo ele para OrderStatus
		return OrderStatus.valueOf(orderStatus);
	}

	// Receber um ORDERSTATUS e tenho que guardar internamente um NUMERO INTEIRO

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			// PARA PEGAR O NUMERO CORRESPONDENTE DO ORDERSTATUS BASTA CHAMAR A OPERAÇÃO
			// GETCODE()
			this.orderStatus = orderStatus.getCode();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	

	public Set<OrderItem> getItems() {
		return items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
