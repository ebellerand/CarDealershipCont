package com.learntocode;

import java.io.BufferedReader;
import java.io.FileReader;

public class ContractDataManager {
    public void saveContract(Contract contract) {
        String filename = "contracts.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

        String line;
        while ((line = br.readLine()) != null) {
            processContract(line);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void processContract(String line) {
        String[] fields = line.split("\\|");
        String contractType = fields[0];
        String date = fields[1];
        String customerName = fields[2];
        String customerEmail = fields[3];
        int carID = Integer.parseInt(fields[4]);
        int year = Integer.parseInt(fields[5]);
        String make = fields[6];
        String model = fields[7];
        String vehicleType = fields[8];
        String color = fields[9];
        int odometer = Integer.parseInt(fields[10]);

    }
}
