package com.techiteasy.TechItEasy.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "televisions")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Integer sold = 0;
    private LocalDate lastPurchased;
    private LocalDate lastSold;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "remote_controller_id")
    RemoteController remoteController;

//    @ManyToOne
//    @JoinColumn(name = "ci_module_id")
//    CIModule ciModule;
//
//    @ManyToMany
//    @JoinTable(
//            name = "television_wallbrackets",
//            joinColumns = @JoinColumn(name = "wall_bracket_id"),
//            inverseJoinColumns = @JoinColumn(name = "television_id")
//    )
//    List<WallBracket> wallBrackets;

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

    public RemoteController getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
    }

//    public CIModule getCiModule() {
//        return ciModule;
//    }
//
//    public void setCiModule(CIModule ciModule) {
//        this.ciModule = ciModule;
//    }
//
//    public List<WallBracket> getWallBrackets() {
//        return wallBrackets;
//    }
//
//    public void setWallBrackets(List<WallBracket> wallBrackets) {
//        this.wallBrackets = wallBrackets;
//    }
}
