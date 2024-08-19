package me.erano.com.example3.factories;

import me.erano.com.example3.Company;
import me.erano.com.example3.products.AsusGPU;
import me.erano.com.example3.products.AsusMonitor;
import me.erano.com.example3.products.GPU;
import me.erano.com.example3.products.Monitor;

public class AsusManufacturer extends Company {

    @Override
    public GPU createGpu() {
        return new AsusGPU();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }

}
