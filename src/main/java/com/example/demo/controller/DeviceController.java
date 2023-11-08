package com.example.demo.controller;

import com.example.demo.model.Device;
import com.example.demo.service.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    private DeviceServiceImpl deviceService;

    @Autowired
    public DeviceController(DeviceServiceImpl deviceService) {

        this.deviceService = deviceService;
    }

    @PostMapping("/createDevice")
    public Device createDevice(@RequestBody Device device) {

        return deviceService.createDevice(device);
    }

    @GetMapping("/")
    public List<Device> getAllDevices() {

        return deviceService.getAllDevices();
    }

    @GetMapping("/{deviceId}")
    public Device getDeviceById(@PathVariable Long deviceId) {

        return deviceService.getDeviceById(deviceId);
    }

    @PutMapping("/{deviceId}")
    public Device updateDevice(@PathVariable Long deviceId, @RequestBody Device device) {
        return deviceService.updateDevice(deviceId, device);
    }

    @DeleteMapping("/{deviceId}")
    public ResponseEntity<?> deleteDevice(@PathVariable Long deviceId) {
        deviceService.deleteDevice(deviceId);
        return ResponseEntity.ok().build();
    }

}
