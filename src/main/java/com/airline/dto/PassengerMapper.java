package com.airline.dto;

import com.airline.models.Passenger;

public class PassengerMapper
{
    public static PassengerResponseDto toDto(Passenger p)
    {
        PassengerResponseDto response = new PassengerResponseDto();
        response.setId(p.getId());
        response.setFirstName(p.getFirstName());
        response.setLastName(p.getLastName());
        response.setFlightClass(p.getFlightClass());
        response.setDob(p.getDob());
        response.setGender(p.getGender());

        return response;
    }
}
