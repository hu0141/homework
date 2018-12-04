package com.hik.hyy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hik.hyy.entity.Device;

@Repository
public interface IDeviceRepository extends JpaRepository<Device, Long> {

}
