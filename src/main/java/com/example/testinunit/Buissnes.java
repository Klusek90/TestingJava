package com.example.testinunit;

public class Buissnes {


    private SomeDataService someDataService;

        public int calculatedSum() {
            int[ ]data = someDataService.retriveAllData();
            int sum = 0;
            for (int value : data) {
                sum += value;
            }
            return sum;
        }
    public void setSomeDataService(SomeDataService someDataService)
    {
        this.someDataService = someDataService;
    }

}
