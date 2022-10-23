package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private Long roomId;
	
	@Column(name = "room_type",nullable=false)
	private String roomType;
	
	@Column(name="cost_perday",nullable=false)
	private double costPerday;
		

	public Room() {
		super();	
	}

	public Room(Long roomId, String roomType, double costPerday) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.costPerday = costPerday;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getCostPerday() {
		return costPerday;
	}

	public void setCostPerday(double costPerday) {
		this.costPerday = costPerday;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", costPerday=" + costPerday + "]";
	}

}
