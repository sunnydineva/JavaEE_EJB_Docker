package com.airline.dto;

import com.airline.models.Flight;

public class FlightMapper
{

    //SE: does not work this way due to not empty constructor
    public static FlightResponseDto toFlightResponseDto(Flight f)
    {
        return new FlightResponseDto(
                f.getId(),
                f.getFlightOrigin(),
                f.getFlightDestination(),
                f.getPrice(),
                f.getFlightTime());
    }

    public static FlightResponseDto toDto(Flight f)
    {
        FlightResponseDto responseDto = new FlightResponseDto();
        responseDto.setId(f.getId());
        responseDto.setFlightOrigin(f.getFlightOrigin());
        responseDto.setFlightDestination(f.getFlightDestination());
        responseDto.setPrice(f.getPrice());
        responseDto.setFlightTime(f.getFlightTime());

        return responseDto;
    }


    public FlightMapper()
    {
    }
}
