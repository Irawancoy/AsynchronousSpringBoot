package com.example.TalentEvaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TalentEvaluation.model.AsynchronousModel;
import com.example.TalentEvaluation.services.AsynchronousServices;

@RestController
@RequestMapping("/asynchronous")
public class AsynchronousController {

   @Autowired
   private AsynchronousServices asynchronousServices;

   // post mapping untuk memulai proses asinkron
   @PostMapping("/execute")
   public String executeAsynchronously(@RequestParam int id) {
      // Memanggil method executeAsynchronously dari AsynchronousServices
      asynchronousServices.executeAsynchronously(id);
      // Mengembalikan pesan "Request is under process"
      return "Request is under process";
   }

   // get mapping untuk mendapatkan status
   @GetMapping("/status")
   public AsynchronousModel getStatus(@RequestParam int id) {
      // Memanggil method getStatus dari AsynchronousServices
      return asynchronousServices.getStatus(id);
   }

}
