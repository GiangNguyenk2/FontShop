/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.util.Random;

/**
 *
 * @author dinhd513
 */
public class GetRandom {
    
    public static String generateRandomNumber(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int randomNumber = random.nextInt(10);
            sb.append(randomNumber);
        }
        
        return sb.toString();
    }
}
