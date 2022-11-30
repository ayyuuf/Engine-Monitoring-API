package com.monitoring.sitemanagement.controller;

import com.monitoring.sitemanagement.model.Account;
import com.monitoring.sitemanagement.service.AccountService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public ResponseEntity<?> getAllAccount() {

        List<Account> accounts = accountService.getAllAccount();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @PostMapping("/save-account")
    public ResponseEntity<?> addAccount(@RequestBody Account account) {

         accountService.addAccount(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-account")
    public ResponseEntity<?> updateAccount(@RequestBody Account account) {

        accountService.updateAccount(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-account/{screen_name}")
    public ResponseEntity<?> deleteByScreen_name(@PathVariable("screen_name") String screen_name) {

        accountService.deleteByScreen_name(screen_name);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable("email") String email) {

        Account account = accountService.findByEmail(email);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }


    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file")MultipartFile file) {

        if (isCSVFile(file)) {
            try {
                accountService.uploadFile(file);
                return ResponseEntity.ok(csvToListModelMap(file));
            } catch (Exception e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity("file isn't csv", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    private boolean isCSVFile(MultipartFile file){
        if(!"text/csv".equals(file.getContentType())){
            return false;
        }
        return true;
    }

    private List<ModelMap> csvToListModelMap(MultipartFile file) throws Exception {
        BufferedReader fileReader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), "UTF-8"));
        CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().withDelimiter(';').parse(fileReader);
        List<ModelMap> list = new ArrayList<>();

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            ModelMap m = new ModelMap();

            m.put("screen_name", csvRecord.get("screen_name"));
            m.put("email", csvRecord.get("email"));
            m.put("phone_no", csvRecord.get("phone_no"));
            m.put("password", csvRecord.get("password"));
            m.put("status", csvRecord.get("status"));
            m.put("type", csvRecord.get("type"));
            m.put("app_name", csvRecord.get("app_name"));
            m.put("consumer_key", csvRecord.get("consumer_key"));
            m.put("consumer_secret", csvRecord.get("consumer_secret"));
            m.put("access_token", csvRecord.get("access_token"));
            m.put("access_token_secret", csvRecord.get("access_token_secret"));
            m.put("username", csvRecord.get("username"));
            m.put("description", csvRecord.get("description"));

            list.add(m);}

        return list;
    }

}
