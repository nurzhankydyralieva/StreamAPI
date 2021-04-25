package com.company.classes;

import com.company.enums.Hotels;
import com.company.enums.Rooms;
import com.company.enums.Stars;

import java.util.List;
import java.util.Objects;

public class Information {
    private String name;
    private int cost;
    private Hotels hotel;
    private Rooms room;
    private Stars stars;
    private List<String> reservedPeriod;

    public Information(String name, int cost, Hotels hotel, Rooms room, Stars stars, List<String> reservedPeriod) {
        this.name = name;
        this.cost = cost;
        this.hotel = hotel;
        this.room = room;
        this.stars = stars;
        this.reservedPeriod = reservedPeriod;
    }

    public List<String> getReservedPeriod() {
        return reservedPeriod;
    }

    public void setReservedPeriod(List<String> reservedPeriod) {
        this.reservedPeriod = reservedPeriod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Hotels getHotel() {
        return hotel;
    }

    public void setHotel(Hotels hotel) {
        this.hotel = hotel;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public Stars getStars() {
        return stars;
    }

    public void setStars(Stars stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Information that = (Information) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", hotel=" + hotel +
                ", room=" + room +
                ", stars=" + stars +
                '}';
    }
}
