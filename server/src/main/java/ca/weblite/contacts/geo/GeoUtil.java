/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.weblite.contacts.geo;

/**
 *
 * @author shannah
 */
public class GeoUtil {
    public static double getApproximateMetresPerLatDegreeAtLat(double lat) {
        return 111132.954 - 559.822 * Math.cos( 2 * lat ) + 1.175 * Math.cos( 4 * lat);
    }
    
    public static double getApproximateMetresPerLngDegreeAtLat(double lat) {
        return 111132.954 * Math.cos ( lat );
    }
}
