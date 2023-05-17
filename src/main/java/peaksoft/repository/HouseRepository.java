package peaksoft.repository;

import peaksoft.entity.House;

import java.util.List;

public interface HouseRepository {

    String saveHouse(House house);

    House getHouseById(Long id);

    List<House> getAllUserHouses(Long userId);

    void deleteHouseById(Long id);

    House editHouseDescription(Long id, String description);

    String assignHouseToPerson(Long userId, Long houseId);

}
