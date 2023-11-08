package com.example.demo.service;

import com.example.demo.model.Device;
import com.example.demo.model.User;
import com.example.demo.model.Warehouse;
import com.example.demo.repository.DeviceRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository, DeviceRepository deviceRepository, UserRepository userRepository) {
        this.warehouseRepository = warehouseRepository;
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
    }

    public List<Device> getAllDevices() {

        return deviceRepository.findAll();
    }

    public Device addDevice(Device device) {
        // Thực hiện các kiểm tra và xử lý trước khi lưu thiết bị vào cơ sở dữ liệu
        return deviceRepository.save(device);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        // Thực hiện các kiểm tra và xử lý trước khi lưu người dùng vào cơ sở dữ liệu
        return userRepository.save(user);
    }

    public Warehouse createWarehouse(Warehouse warehouse) {
        // Kiểm tra xem kho đã tồn tại hay chưa

//        if (warehouseRepository.existsByName(warehouse.getName())) {
//            throw new RuntimeException("Kho đã tồn tại!");
//        }
//        WarehouseRepository warehouseRepository1 = new
        // Lưu kho vào cơ sở dữ liệu
        return this.warehouseRepository.save(warehouse);
    }


    public List<Warehouse> getAllWarehouses() {
        // Trả về danh sách tất cả các kho từ cơ sở dữ liệu
        return warehouseRepository.findAll();
    }
}
