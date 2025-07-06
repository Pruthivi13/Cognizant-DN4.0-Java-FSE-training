package com.cognizant.ormlearn.dto;

public class ProductFilter {

    private String keyword;
    private Double minCustomerReview;
    private Integer ramSize;
    private Integer hardDiskSize;
    private String operatingSystem;
    private String cpu;
    private Double minCpuSpeed;
    private Double maxWeight;

    // Getters and Setters

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Double getMinCustomerReview() {
        return minCustomerReview;
    }

    public void setMinCustomerReview(Double minCustomerReview) {
        this.minCustomerReview = minCustomerReview;
    }

    public Integer getRamSize() {
        return ramSize;
    }

    public void setRamSize(Integer ramSize) {
        this.ramSize = ramSize;
    }

    public Integer getHardDiskSize() {
        return hardDiskSize;
    }

    public void setHardDiskSize(Integer hardDiskSize) {
        this.hardDiskSize = hardDiskSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Double getMinCpuSpeed() {
        return minCpuSpeed;
    }

    public void setMinCpuSpeed(Double minCpuSpeed) {
        this.minCpuSpeed = minCpuSpeed;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }
}
