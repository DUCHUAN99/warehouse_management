package com.example.demo.service;

import com.example.demo.model.Device;
import com.example.demo.repository.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device createDevice(Device device) {

        return this.deviceRepository.save(device);
    }

    public List<Device> getAllDevices() {

        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long deviceId) {
        return deviceRepository.findById(deviceId)
                .orElseThrow(() -> new EntityNotFoundException("Device not found with id: " + deviceId));
    }

    public Device updateDevice(Long deviceId, Device device) {
        Device existingDevice = getDeviceById(deviceId);
        existingDevice.setName(device.getName());
        existingDevice.setDescription(device.getDescription());
        // Update other fields as needed
        return deviceRepository.save(existingDevice);
    }

    public void deleteDevice(Long deviceId) {

        deviceRepository.deleteById(deviceId);
    }
}
