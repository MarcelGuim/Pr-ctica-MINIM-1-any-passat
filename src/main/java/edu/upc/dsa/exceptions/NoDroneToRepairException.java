package edu.upc.dsa.exceptions;

public class NoDroneToRepair extends RuntimeException {
  public NoDroneToRepair(String message) {
    super(message);
  }
}
