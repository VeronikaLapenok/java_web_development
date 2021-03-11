package by.epam.course.entity;

import by.epam.course.exception.ThreadException;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ferry extends Thread {
  private static Logger logger = LogManager.getLogger();
  
  private static final int TIMEOUT = 5; // Time for moving ferry to one side
  
  private static Lock locker = new ReentrantLock();
  private static Ferry instance;
  private static Deque<Auto> queue = new ConcurrentLinkedDeque<>();
  private static double currentWeight;
  
  double square;
  double carring;
  double parkingPlaceSquare;
  int freeParkingPlacesCount;
  Status status = Status.LOADING;
 
  public Ferry() {
  }
  
  public Ferry(double square, double carring, double parkingPlaceSquare, Status status) {
    this.square = square;
    this.carring = carring;
    this.parkingPlaceSquare = parkingPlaceSquare;
    freeParkingPlacesCount = findParkingPlacesCount(square, false);
    this.status = status;
  }
  
  public enum Status {
    LOADING,
    UNLOADING
  }
  
  public double getSquare() {
    return square;
  }
  
  public void setSquare(double square) {
    this.square = square;
  }
  
  public double getCarring() {
    return carring;
  }
  
  public void setCarring(double carring) {
    this.carring = carring;
  }
  
  public double getParkingPlaceSquare() {
    return parkingPlaceSquare;
  }
  
  public void setParkingPlaceSquare(double parkingPlaceSquare) {
    this.parkingPlaceSquare = parkingPlaceSquare;
  }
  
  public Status getStatus() {
    try {
      locker.lock();
      return status;
    } finally {
      locker.unlock();
    }
  }
  
  public void setStatus(Status status) {
    try {
      locker.lock();
      this.status = status;
    } finally {
      locker.unlock();
    }
  }
  
  
  public static Ferry getInstance() {
    if (instance == null) {
      locker.lock();
      if (instance == null) {
        instance = new Ferry();
      }
      locker.unlock();
    }
    return instance;
  }
  
  public int findParkingPlacesCount(double square, boolean isCeil) {
    int result;
    double parkingPlacesCount = square / parkingPlaceSquare;
    
    if (isCeil) {
      result = (int) Math.ceil(parkingPlacesCount);
    } else {
      result = (int) parkingPlacesCount;
    }
    
    return result;
  }
  
  public int getFreeParkingPlacesCount() {
    return freeParkingPlacesCount;
  }
  
  public void setFreeParkingPlacesCount(int freeParkingPlacesCount) {
    this.freeParkingPlacesCount = freeParkingPlacesCount;
  }
  
  public boolean load(Auto auto) {
    try {
      locker.lock();
      // Get parking places count for loading auto
      int parkingPlacesCount = findParkingPlacesCount(auto.getSize(), true);
      boolean result = false;
      
      if ((parkingPlacesCount <= freeParkingPlacesCount) && auto.getWeight() <= carring - currentWeight) {
        addToQueue(auto);
        result = true;
        
        freeParkingPlacesCount -= parkingPlacesCount;
        currentWeight += auto.getWeight();   
        
        logger.debug("Auto " + auto.getNumber() + ", Free places: " + freeParkingPlacesCount + ", Current Weight: " + round(currentWeight, 2));
      } else {
        logger.debug("----- Stop loading automobiles ------");
        setStatus(Status.UNLOADING);
      }
      return result;
    } finally {
      locker.unlock();
    }
  }
  
  public void addToQueue(Auto auto) {
    queue.add(auto);
  }
  
  public void moving() throws ThreadException {
    try {
      locker.lock();
      logger.debug("----- Ferry started moving. -----");
      try {
        TimeUnit.SECONDS.sleep(TIMEOUT);
      } catch (InterruptedException e) {
        throw new ThreadException("Thread was interrupted");
      }
      logger.debug("----- Ferry stopped moving. -----");
    } finally {
      locker.unlock();
    }
  }
  
  public void unload() {
    try {
      locker.lock();
      logger.debug("----- Start unloading automobiles ------");
      while (!queue.isEmpty()) {
        Auto auto = queue.pollLast();
        int parkingPlacesCount = findParkingPlacesCount(auto.getSize(), true);
      
        freeParkingPlacesCount += parkingPlacesCount;
        currentWeight -= auto.getWeight();   
      
        logger.debug("Auto " + auto.getNumber() + ", Free places: " + freeParkingPlacesCount + ", Current Weight: " + round(currentWeight, 2));
      }
      logger.debug("----- Stop unloading automobiles ------");
    } finally {
      locker.unlock();
    }
  }
  
  @Override
  public void run() {
    while (true) {
      if (getStatus() == Status.UNLOADING) {
        // Moving to that side
        try {
          moving();
        } catch (ThreadException e) {
          logger.error(e);
        }
        unload();
        // Coming back
        try {
          moving();
        } catch (ThreadException e) {
          logger.error(e);
        }
        setStatus(Status.LOADING);
        logger.debug("----- Start loading automobiles ------");
      }
    }
  }
  
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
  
    if (object == null) {
      return false;
    }
    
    if (getClass() != object.getClass()) {
      return false;
    }
    
    Ferry other = (Ferry) object;
    
    if (square != other.square) {
      return false;
    }
    
    if (carring != other.carring) {
      return false;
    }
    
    if (parkingPlaceSquare != other.parkingPlaceSquare) {
      return false;
    }
    
    if (status != other.status) {
      return false;
    }
    
    return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 31;
    int result = 1;
    result = PRIME * result + (int) square;
    result = PRIME * result + (int) carring;
    result = PRIME * result + (int) parkingPlaceSquare;
    result = PRIME * result + ((status == null) ? 0 : status.hashCode());
    
    return result;
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Square: ").append(square);
    builder.append(", Carring: ").append(carring);
    builder.append(", Square of one parking place: ").append(parkingPlaceSquare);
    
    return builder.toString();
  }
  
  private static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();
 
    BigDecimal bd = new BigDecimal(Double.toString(value));
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }
}
