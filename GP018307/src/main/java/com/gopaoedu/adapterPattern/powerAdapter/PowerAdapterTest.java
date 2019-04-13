package com.gopaoedu.adapterPattern.powerAdapter;

public class PowerAdapterTest {

    public static void main(String[] args) {
        PowerAdapter powerAdapter = new PowerAdapter(new AC220V());
        powerAdapter.outptuDC5V();
    }
}
