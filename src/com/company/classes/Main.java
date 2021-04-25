package com.company.classes;

import com.company.enums.Hotels;
import com.company.enums.Rooms;
import com.company.enums.Stars;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Information> informationList = Arrays.asList(
                new Information("Jumeirah Village", 8000, Hotels.RESORT, Rooms.DELUXE_ROOM, Stars.FOUR_STAR, Arrays.asList("03,15,2021 - 04,15,2021")),
                new Information("Atana Hotel", 6010, Hotels.AIRPORT_HOTEL, Rooms.CABANA_ROOM, Stars.FIVE_STAR, Arrays.asList("02,15,2021 - 03,15,2021")),
                new Information("Atlantis Hotel", 7500, Hotels.AIRPORT_HOTEL, Rooms.PRESIDENTIAL_SUITE, Stars.FIVE_STAR, Arrays.asList("03,15,2020 - 04,15,2020")),
                new Information("Atlantis Hotel", 7500, Hotels.AIRPORT_HOTEL, Rooms.PRESIDENTIAL_SUITE, Stars.FIVE_STAR, Arrays.asList("01,15,2021 - 01,15,2021")),
                new Information("The Meydan Hotel", 4000, Hotels.FLOATING_HOTEL, Rooms.DOUBLE_ROOM, Stars.TREE_STAR, Arrays.asList("03,15,2021 - 04,15,2021")),
                new Information("The Meydan Hotel", 2600, Hotels.FLOATING_HOTEL, Rooms.DOUBLE_ROOM, Stars.TREE_STAR, Arrays.asList("04,15,2021 - 05,15,2021")),
                new Information("The Meydan Hotel", 2600, Hotels.FLOATING_HOTEL, Rooms.DOUBLE_ROOM, Stars.TREE_STAR, Arrays.asList("01,15,2020 - 04,15,2021")),
                new Information("Meydan Hotel", 2800, Hotels.FLOATING_HOTEL, Rooms.DOUBLE_ROOM, Stars.TREE_STAR, Arrays.asList("03,10,2021 - 04,15,2021")),
                new Information("Grand Hyatt", 3000, Hotels.BOATEL, Rooms.LANAI_ROOM, Stars.FOUR_STAR, Arrays.asList("01,15,2021 - 04,15,2021")),
                new Information("Ak keme", 4500, Hotels.SELF_CATERING_HOTEL, Rooms.DUPLEX_ROOM, Stars.ONE_STAR, Arrays.asList("03,15,2021 - 04,15,2021")),
                new Information("Ak keme", 4500, Hotels.SELF_CATERING_HOTEL, Rooms.DUPLEX_ROOM, Stars.ONE_STAR, Arrays.asList("03,05,2021 - 04,15,2021")),
                new Information("Sofitel Dubai The Obelisk", 2999, Hotels.SUBURB_HOTEL, Rooms.SINGLE_ROOM, Stars.ONE_STAR, Arrays.asList("03,20,2021 - 04,15,2021")),
                new Information("Palm Jumeirah", 2300, Hotels.MOTEL, Rooms.TWIN_ROOM, Stars.TWO_STAR, Arrays.asList("03,15,2019 - 04,15,2019")),
                new Information("Sheraton Grand Hotel", 9000, Hotels.ROTEL, Rooms.PRESIDENTIAL_SUITE, Stars.FIVE_STAR, Arrays.asList("02,25,2019 - 04,15,2019")));

        Stream<Object> streamBuilder = Stream.builder()
                .add(new Information("Jumeirah Village", 8000, Hotels.RESORT, Rooms.DELUXE_ROOM, Stars.FOUR_STAR, Arrays.asList("03,15,2021","04,15,2021")))
                .add(new Information("Atana Hotel", 6000, Hotels.AIRPORT_HOTEL, Rooms.CABANA_ROOM, Stars.FIVE_STAR, Arrays.asList("02,15,2021","04,15,2021")))
                .add(new Information("The Meydan Hotel", 4000, Hotels.FLOATING_HOTEL, Rooms.DOUBLE_ROOM, Stars.TREE_STAR, Arrays.asList("01,15,2019","04,15,2019")))
                .add(new Information("Grand Hyatt", 3000, Hotels.BOATEL, Rooms.LANAI_ROOM, Stars.FOUR_STAR, Arrays.asList("03,15,2021","04,15,2021")))
                .add(new Information("Ak keme", 4500, Hotels.SELF_CATERING_HOTEL, Rooms.DUPLEX_ROOM, Stars.ONE_STAR, Arrays.asList("01,17,2021","01,15,2021")))
                .add(new Information("Sofitel Dubai The Obelisk", 5000, Hotels.SUBURB_HOTEL, Rooms.SINGLE_ROOM, Stars.ONE_STAR, Arrays.asList("03,20,2019","04,15,2020")))
                .add(new Information("Palm Jumeirah", 2300, Hotels.MOTEL, Rooms.TWIN_ROOM, Stars.TWO_STAR, Arrays.asList("03,15,2020","04,15,2020")))
                .add(new Information("Sheraton Grand Hotel", 5000, Hotels.ROTEL, Rooms.PRESIDENTIAL_SUITE, Stars.FIVE_STAR, Arrays.asList("03,28,2021","04,20,2021")))
                .build();

        System.out.println("\n------------------------------------List of hotels (Stream.builder)-----------------------------");
        streamBuilder.forEach(System.out::println);
        System.out.println("\n--------------------------------------------Five star hotels (filter method)-------------------------------------");
        informationList.stream().filter((s) -> s.getStars().equals(Stars.FIVE_STAR)).forEach(System.out::println);
        System.out.println("\n----------------------------------------------Four star hotels (filter method)------------------------------------");
        informationList.stream().filter((s) -> s.getStars().equals(Stars.FOUR_STAR)).forEach(System.out::println);
        System.out.println("\n---Quantity of hotels (filter method and count)---");
        System.out.println("Quantity of AIRPORT_HOTEL = " + informationList.stream().filter((x) -> x.getHotel().equals(Hotels.AIRPORT_HOTEL)).count());
        System.out.println("Quantity of FLOATING_HOTEL = " + informationList.stream().filter((x) -> x.getHotel().equals(Hotels.FLOATING_HOTEL)).count());
        System.out.println("Quantity of SUBURB_HOTEL = " + informationList.stream().filter((x) -> x.getHotel().equals(Hotels.SUBURB_HOTEL)).count());
        System.out.println("Quantity of SELF_CATERING_HOTEL = " + informationList.stream().filter((x) -> x.getHotel().equals(Hotels.SELF_CATERING_HOTEL)).count());
        System.out.println("\n----------------------------The cost of rooms are more than 3000-------------------------------");
        informationList.stream().filter(n -> n.getCost() > 3000).forEach(System.out::println);
        System.out.println("\n---------------------------------The cost of rooms are less than 3000-----------------------------");
        informationList.stream().filter(n -> n.getCost() < 3000).forEach(System.out::println);
        System.out.println("\n--------------------------------------Sort by price (sort method)------------------------------------");
        List<Information> sorted = informationList.stream().sorted(Comparator.comparing(Information::getCost)).collect(Collectors.toList());
        sorted.forEach(System.out::println);
        System.out.println("\n---------------------------------------Sort by name (sort method)-----------------------------------------");
        List<Information> sortedByName = informationList.stream().sorted(Comparator.comparing(Information::getName)).collect(Collectors.toList());
        sortedByName.forEach(System.out::println);
        System.out.println("\n--------------------------------------Sort by star--------------------------------------------------");
        List<Information> sortedByHotel = informationList.stream().sorted(Comparator.comparing(Information::getStars)).collect(Collectors.toList());
        sortedByHotel.forEach(System.out::println);
        System.out.println("\n-------------------------------------------All list--------------------------------------------");
        informationList.forEach(System.out::println);
        System.out.print("\n-----------------Counted stream (count method)\nCounted elements = ");
        long streamCount = informationList.stream().count();
        System.out.println(streamCount);
        System.out.println("\n------------------------------------------Used method distinct---------------------------------------------");
        List<Information> informationList1 = informationList.stream().distinct().collect(Collectors.toList());
        informationList1.forEach(System.out::println);
        System.out.print("\n----------------------------------------Counted after distinct method------------------------------------\nCounted elements = ");
        System.out.println(informationList1.stream().count());
        System.out.print("\n-----------Used flatMap method to get reservation period---------------\n");

        List<String> hotelReservation = informationList
                .stream()
                .flatMap(information -> information
                        .getReservedPeriod()
                        .stream())
                .collect(Collectors.toList());
        hotelReservation.forEach(System.out::println);
        System.out.print("\n---------------Used map method to get name of hotels-------------\n");

        List<String> hotelName = informationList.stream()
                .map(hotel -> hotel.getName().toUpperCase(Locale.ROOT)).collect(Collectors.toList());
        hotelName.forEach(System.out::println);
    }
}
