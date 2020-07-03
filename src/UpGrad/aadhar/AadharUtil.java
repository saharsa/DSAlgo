package UpGrad.aadhar;

import java.util.HashMap;
import java.util.Map;

public class AadharUtil {
    public static void main(String[] args) {

        AadharIdentifier ramIdentifier = new AadharIdentifier();
        ramIdentifier.setAadharNumber(1111);
        ramIdentifier.setFingerPrints("ramFingerPrint");
        ramIdentifier.setEyePrints("ramEyePrint");

        AadharDetails ramDetails = new AadharDetails();
        ramDetails.setName("Ram");
        ramDetails.setAddress("Worli, Mumbai");

        Map<AadharIdentifier, AadharDetails> aadharMap = new HashMap<>();
        aadharMap.put(ramIdentifier, ramDetails);

        if (aadharMap.containsKey(ramIdentifier)){
            System.out.println("Aadhar identifier found! Retrieving Details...");
            AadharDetails retrievedValue = aadharMap.get(ramIdentifier);
            System.out.println("Name: " + retrievedValue.getName());
            System.out.println("Address: " + retrievedValue.getAddress());
        } else {
            System.out.println("Aadhar identifier not found");
        }

    }
}
