package com.techiteasy.TechItEasy.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "televisions")
public class Television {

    @Id
    @GeneratedValue
    private Long id;

    private String type;
    private String brand;
    private String name;
    private Double price;

    @Enumerated(EnumType.STRING)
    private AvailableSize availableSize;

    @Enumerated(EnumType.STRING)
    private RefreshRate refreshRate;

    @Enumerated(EnumType.STRING)
    private ScreenType screenType;

    @Enumerated(EnumType.STRING)
    private ScreenQuality screenQuality;

    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private Integer originalStock;
    private Integer sold;
    private LocalDate lastPurchased;
    private LocalDate lastSold;

    public Television() {
    }

    public Television(ScreenType screenType,
                      Long id,
                      String type,
                      String brand,
                      String name,
                      Double price,
                      AvailableSize availableSize,
                      RefreshRate refreshRate,
                      ScreenQuality screenQuality,
                      Boolean smartTv,
                      Boolean wifi,
                      Boolean voiceControl,
                      Boolean hdr,
                      Boolean bluetooth,
                      Boolean ambiLight,
                      Integer originalStock,
                      Integer sold,
                      LocalDate lastPurchased,
                      LocalDate lastSold
    ) {
        this.screenType = screenType;
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
        this.lastPurchased = lastPurchased;
        this.lastSold = lastSold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public AvailableSize getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(AvailableSize availableSize) {
        this.availableSize = availableSize;
    }

    public RefreshRate getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(RefreshRate refreshRate) {
        this.refreshRate = refreshRate;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public void setScreenType(ScreenType screenType) {
        this.screenType = screenType;
    }

    public ScreenQuality getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(ScreenQuality screenQuality) {
        this.screenQuality = screenQuality;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public LocalDate getLastSold() {
        return lastSold;
    }

    public void setLastSold(LocalDate lastSold) {
        this.lastSold = lastSold;
    }

    public LocalDate getLastPurchased() {
        return lastPurchased;
    }

    public void setLastPurchased(LocalDate lastPurchased) {
        this.lastPurchased = lastPurchased;
    }
}
