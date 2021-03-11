package edu.ntnu.idatt2001.trygveam.mappe_1.hospital.exception;
import java.io.Serial;
import java.io.Serializable;

/**
 * The type Remove exception.
 * @author trygveam
 */
public class RemoveException extends Exception implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Remove exception.
     *
     * @param message the exception
     */
    public RemoveException(String message) {
        super(message);
    }
}
