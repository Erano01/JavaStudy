package me.erano.com.example3.factories;

import me.erano.com.example3.Company;
import me.erano.com.example3.products.GPU;
import me.erano.com.example3.products.Monitor;
import me.erano.com.example3.products.MsiGPU;
import me.erano.com.example3.products.MsiMonitor;

public class MsiManufacturer extends Company {

    @Override
    public GPU createGpu() {
        return new MsiGPU();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }

}
