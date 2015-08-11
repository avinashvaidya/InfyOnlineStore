/**
 * 
 */
package com.infy.service;

import org.springframework.stereotype.Service;

import com.infy.domain.LocationData;

/**
 * @author AvinashVaidya
 *
 */
@Service
public interface GeoLocationService {

	public LocationData getLatlongFromGoogle(String address) throws Exception;

}
