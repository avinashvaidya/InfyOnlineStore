/**
 * 
 */
package com.infy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderGeometry;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;
import com.infy.dao.ProductDetailsDaoImpl;
import com.infy.domain.LocationData;
import com.infy.helper.InfyOnlineStoreUtil;

/**
 * @author AvinashVaidya
 *
 */
@Service
public class GeoLocationServiceImpl implements GeoLocationService {

	private static Logger LOGGER = LoggerFactory.getLogger(ProductDetailsDaoImpl.class);

	@Override
	public LocationData getLatlongFromGoogle(String address) throws Exception {
		LocationData ld = new LocationData();
		Geocoder geocoder = new Geocoder();
		String editedAddress = InfyOnlineStoreUtil.buildAddress(address);
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(editedAddress).setLanguage("en")
				.getGeocoderRequest();

		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		LOGGER.info("Geo location Results " + geocoderResponse.getResults());
		GeocoderResult geocodeResult = geocoderResponse.getResults().get(0);
		GeocoderGeometry geocoderGeometry = geocodeResult.getGeometry();
		LatLng latlong = geocoderGeometry.getLocation();
		ld.setLatitude(String.valueOf(latlong.getLat()));
		ld.setLongitude(String.valueOf(latlong.getLng()));
		ld.toString();

		return ld;
	}

}
