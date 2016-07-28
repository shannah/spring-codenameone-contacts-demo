/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.weblite.contacts.services;

import ca.weblite.contacts.dto.UpdateDeviceRequest;
import ca.weblite.contacts.dto.UpdateDeviceResponse;
import com.codename1.util.Callback;

/**
 *
 * @author shannah
 */
public interface WebServiceClient {
    public void updateDeviceLocation(UpdateDeviceRequest request, Callback<UpdateDeviceResponse> callback);
    
}
