package com.example.TalentEvaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TalentEvaluation.model.AsynchronusModel;
import com.example.TalentEvaluation.services.AsynchronusServices;

@RestController
@RequestMapping("/asynchronus")
public class AsynchronusController {

   @Autowired
   private AsynchronusServices asynchronusServices;

   //post mapping untuk memulai proses asinkron
   @PostMapping("/execute")
   public String executeAsynchronously(@RequestParam int id) {
      // Memanggil method executeAsynchronously dari AsynchronusServices
      asynchronusServices.executeAsynchronously(id);
      // Mengembalikan pesan "Request is under process"
      return "Request is under process";
   }

   //get mapping untuk mendapatkan status
   @GetMapping("/status")
   public AsynchronusModel getStatus(@RequestParam int id) {
      // Memanggil method getStatus dari AsynchronusServices
      return asynchronusServices.getStatus(id);
   }


}
