package com.learntocode;

public class SalesContract extends Contract{
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean financed;
    private double financedMonthlyPayment;


    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double salesTaxAmount, double recordingFee, double processingFee, boolean financing) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financed = financing;
    }
    public void setProcessingFee() {
        double vehiclePrice = getVehicleSold().getPrice();
        if (vehiclePrice < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }
    } public void setMonthlyPayment(double vehicleAmount) {
        if (!financed) {
            financedMonthlyPayment = 0;
        } else {
            financedMonthlyPayment = calculateMonthlyPayment(vehicleAmount);
        }
    }

        public double getTotalPrice() {
                 double totalPrice = getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;
                 return totalPrice;
            }
            public double calculateMonthlyPayment(double totalPrice) {
                int numberOfPayments = 0;
                double interestRate = 0;
                if (financed) {
                    if (getVehicleSold().getPrice() >= 10000) {
                        numberOfPayments = 48;
                        interestRate = 4.25 / 1200;
                    } else {
                        numberOfPayments = 24;
                        interestRate = 5.25 / 1200;
                    }

                    double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
                    monthlyPayment = Math.round(monthlyPayment * 100);
                    monthlyPayment /= 100;
                    return monthlyPayment;
                } else {
                    return 0.0;
                }
            }
            public double getMonthlyPayment() {
        return financedMonthlyPayment;
            }

        }
