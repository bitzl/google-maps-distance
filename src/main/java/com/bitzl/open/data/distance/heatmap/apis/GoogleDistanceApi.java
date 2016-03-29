package com.bitzl.open.data.distance.heatmap.apis;

import com.bitzl.open.data.distance.heatmap.model.api.TravelInfo;
import feign.Param;
import feign.RequestLine;

public interface GoogleDistanceApi {

    @RequestLine("GET /maps/api/distancematrix/json?key={apiKey}&mode=transit&origins={origins}&destinations={destination}&units=metric")
    TravelInfo query(@Param("apiKey") String apiKey, @Param("origins") String origins, @Param("destination") String destination);

}
