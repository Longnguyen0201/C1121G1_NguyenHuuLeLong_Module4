package com.codegym.models;

public class MedicalDeclaration {
    private int id;
    private String name;
    private int yearBirthday;
    private String gender;
    private String nationality;
    private int idCard;
    private String vehicle;
    private String idVehicle;
    private String seats;
    private String startDate;
    private String endDate;
    private String nearestProvince;
    private String province;
    private String district;
    private String ward;
    private String address;
    private String phone;
    private String email;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(int id, String name, int yearBirthday, String gender, String nationality,
                              int idCard, String vehicle, String idVehicle, String seats, String startDate,
                              String endDate, String nearestProvince, String province, String district, String ward,
                              String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.yearBirthday = yearBirthday;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.idVehicle = idVehicle;
        this.seats = seats;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nearestProvince = nearestProvince;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public MedicalDeclaration(int id, String name, int yearBirthday, String gender, String nationality, int idCard,
                              String vehicle, String startDate, String endDate, String nearestProvince, String province,
                              String district, String ward, String address, String phone) {
        this.id = id;
        this.name = name;
        this.yearBirthday = yearBirthday;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nearestProvince = nearestProvince;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearBirthday() {
        return yearBirthday;
    }

    public void setYearBirthday(int yearBirthday) {
        this.yearBirthday = yearBirthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNearestProvince() {
        return nearestProvince;
    }

    public void setNearestProvince(String nearestProvince) {
        this.nearestProvince = nearestProvince;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
