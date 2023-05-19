package com.learntocode;

import java.io.*;

public class ContractDataManager {
    public void saveContract(Contract contract) {
        String filename = "contracts.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            if (contract instanceof SalesContract) {
                writeSalesContract(bw, (SalesContract) contract);

            } else if (contract instanceof LeaseContract) {
                writeLeaseContract(bw, (LeaseContract) contract);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void writeSalesContract(BufferedWriter bw, SalesContract contract) throws IOException {
        bw.write("SALE|" + contract.getDate()  + "|" + contract.getCustomerName() + "|" +
                contract.getCustomerEmail() + "|" + contract.getVehicleSold().getVin() + "|" +
                contract.getVehicleSold().getYear() + "|" + contract.getVehicleSold().getMake() + "|" +
                contract.getVehicleSold().getModel() + "|" + contract.getVehicleSold().getVehicleType() + "|" +
                contract.getVehicleSold().getColor() + "|" + contract.getVehicleSold().getOdometer() + "|" +
                contract.getVehicleSold().getPrice() + "|" + contract.getSalesTaxAmount() + "|" +
                contract.getRecordingFee() + "|" + contract.getProcessingFee() + "|" + contract.getTotalPrice() +
                "|" + contract.isFinanced() + "|" + contract.getMonthlyPayment());
        bw.newLine();
    }
    private void writeLeaseContract(BufferedWriter bw, LeaseContract contract) throws IOException {
        bw.write("LEASE|" + contract.getDate() + "|" + contract.getCustomerName() + "|" +
                contract.getCustomerEmail() + "|" + contract.getVehicleLeased().getCarID() + "|" +
                contract.getVehicleLeased().getYear() + "|" + contract.getVehicleLeased().getMake() + "|" +
                contract.getVehicleLeased().getModel() + "|" + contract.getVehicleLeased().getVehicleType() + "|" +
                contract.getVehicleLeased().getColor() + "|" + contract.getVehicleLeased().getOdometer() + "|" +
                contract.getVehicleLeased().getPrice() + "|" + contract.getEndingValue() + "|" +
                contract.getLeaseFee() + "|" + contract.getTotalCost() + "|" + contract.getMonthlyPayment());
        bw.newLine();}
}
