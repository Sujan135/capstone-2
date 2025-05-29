package services;

import models.Order;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptServiceImpl implements ReceiptService {
    @Override
    public void saveReceipt(Order order) {
        String fileName = "receipts/" + order.getReceiptFileName();
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(order.getDetails());
        } catch (IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }
}
