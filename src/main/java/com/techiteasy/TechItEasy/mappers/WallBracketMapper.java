//package com.techiteasy.TechItEasy.mappers;
//
//import com.techiteasy.TechItEasy.dtos.WallBracketDto;
//import com.techiteasy.TechItEasy.dtos.WallBracketInputDto;
//import com.techiteasy.TechItEasy.models.WallBracket;
//
//public class WallBracketMapper {
//
//    public static WallBracket toEntity(WallBracketInputDto wallBracketInputDto, WallBracket existingWallBracket) {
//        if (existingWallBracket == null) {
//            existingWallBracket = new WallBracket();
//        }
//
//        existingWallBracket.setSize(wallBracketInputDto.size);
//        existingWallBracket.setAdjustable(wallBracketInputDto.adjustable);
//        existingWallBracket.setName(wallBracketInputDto.name);
//        existingWallBracket.setPrice(wallBracketInputDto.price);
//
//        return existingWallBracket;
//    }
//
//    public static WallBracketDto toDto(WallBracket wallBracket) {
//        WallBracketDto wallBracketDto = new WallBracketDto();
//
//        wallBracketDto.id = wallBracket.getId();
//        wallBracketDto.size = wallBracket.getSize();
//        wallBracketDto.adjustable = wallBracket.getAdjustable();
//        wallBracketDto.name = wallBracket.getName();
//        wallBracketDto.price = wallBracket.getPrice();
//
//        return wallBracketDto;
//    }
//}
