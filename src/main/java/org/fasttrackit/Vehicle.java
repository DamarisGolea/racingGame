package org.fasttrackit;

import java.time.LocalDate;
import java.util.Objects;

public class Vehicle {

    private static int totalCount;

    private String name;
    private double mileage;
    private String color;
    private double maxSpeed;
    private boolean running;
    private double fuelLevel;
    private double traveledDistance;
    private LocalDate createdDate;

    public Vehicle() {
        totalCount++;
    }


    public double accelerate(double speed, double durationInHours) {
        if(fuelLevel <= 0){
            System.out.println("You don't have enough fuel level to accelerate. " + "Fuel level: " + fuelLevel);
            return 0;
        }

        if(speed > maxSpeed){
            System.out.println("Requested speed is too high. Maximum allowed: " + maxSpeed);
            return 0;
        }
        // concatenation
        System.out.println(name + " is acceletaring with" + speed + " km/h for" + durationInHours + "h.");

        double distance = speed * durationInHours;
        System.out.println("Traveled " + distance + " km.");

//        traveledDistance = traveledDistance + distance;
        // same result as the above statement
        traveledDistance += distance;
        //logs
        System.out.println("Total traveled distance: " + traveledDistance + " km.");

        double spentFuel = distance / 100 * mileage ;
        System.out.println("Spent Fuel: " + spentFuel + " l.");

//        fuelLevel = fuelLevel - spentFuel;
        // same result as the above statement
        fuelLevel -= spentFuel;
        System.out.println("Remaining fuel: " + fuelLevel + " l.");

        return distance;
    }

    public double accelerate(double speed) {
        return accelerate(speed, 1);
    }
    // method signature must be the same, except:
    //1. co-variant return type
    // returned obj must inherit what the overridden method was returning.
    //2. overriding method can allow larger access than was allowed in the super-class
    @Override
    protected Vehicle clone() throws CloneNotSupportedException {
        return new Vehicle();
    }

    public String getName() {
        return name;
    }

    public double getMileage() {
        return mileage;
    }

    public String getColor() {
        return color;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public boolean isRunning() {
        return running;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double getTraveledDistance() {
        return traveledDistance;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setTraveledDistance(double traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public static int getTotalCount() {
        return totalCount;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", running=" + running +
                ", fuelLevel=" + fuelLevel +
                ", traveledDistance=" + traveledDistance +
                ", createdDate=" + createdDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.mileage, mileage) == 0 &&
                Double.compare(vehicle.maxSpeed, maxSpeed) == 0 &&
                running == vehicle.running &&
                Double.compare(vehicle.fuelLevel, fuelLevel) == 0 &&
                Double.compare(vehicle.traveledDistance, traveledDistance) == 0 &&
                Objects.equals(name, vehicle.name) &&
                Objects.equals(color, vehicle.color) &&
                Objects.equals(createdDate, vehicle.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mileage, color, maxSpeed, running, fuelLevel, traveledDistance, createdDate);
    }
}
