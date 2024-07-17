package com.example.TalentEvaluation.services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.TalentEvaluation.model.AsynchronusModel;

@Service
public class AsynchronusServices {

    private Map<Integer, AsynchronusModel> taskStatus = new HashMap<>();

    @Async
    public void executeAsynchronously(int id) {
        // Menambahkan status "Processing"
        taskStatus.put(id, new AsynchronusModel(id, "Processing", "Request is under process"));

        try {
           // Menunggu selama 5 detik 
            //Saya buat 5 detik supaya testnya tidak terlalu lama
            TimeUnit.SECONDS.sleep(5); 
            taskStatus.put(id, new AsynchronusModel(id, "Completed", "Request is completed"));
        } catch (InterruptedException e) {
            e.printStackTrace();
            // Memperbarui status menjadi "Failed" jika terjadi kesalahan
            taskStatus.put(id, new AsynchronusModel(id, "Failed", "Request is failed"));
        }
    }

    public AsynchronusModel getStatus(int id) {
       // Mengembalikan status berdasarkan ID
      // Jika ID tidak ditemukan, maka akan mengembalikan pesan "Task ID does not exist"
        return taskStatus.getOrDefault(id, new AsynchronusModel(id, "Not Found", "Task ID does not exist"));
    }
}
