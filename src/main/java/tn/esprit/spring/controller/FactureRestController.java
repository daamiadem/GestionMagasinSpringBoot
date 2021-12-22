package tn.esprit.spring.controller;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.DAO.model.Facture;
import tn.esprit.spring.response.ResponseHandler;
import tn.esprit.spring.service.FacturePDFExporter;
import tn.esprit.spring.service.FactureService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class FactureRestController {
    @Autowired
    FactureService factureService;

    @GetMapping("getAllFactures")
    public List<Facture> getAllFactures(){
        return factureService.retrieveAllFactures();
    }

    @GetMapping("/getFacture/{idFacture}")
    public Facture retrieveFacture (@PathVariable("idFacture") Long idFacture){
        return factureService.retrieveFacture(idFacture);
    }

    @PutMapping(value = "/updateFacture", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateFacture(@RequestBody Facture facture){
        factureService.updateFacture(facture);
    }

    @PutMapping(value="/changeStatus", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void changeStatus(@RequestBody FactureEntity facture){
        factureService.cancelFacture(facture);
    }

    @DeleteMapping("/deleteFacture/{idFacture}")
    public void deleteFacture(@PathVariable("idFacture") Long idFacture){
        factureService.deleteFacture(idFacture);
    }

    @PostMapping(value="/addFacture", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addFacture (@RequestBody Facture facture){

        try {
            Facture f = factureService.createFacture(facture);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, f);
        }catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    @GetMapping("/getInActiveFacture")
    public List<Facture> getInActiveFacture(){
        return factureService.retrieveFacturesInActive();
    }

    @GetMapping("/getActiveFacture")
    public List<Facture> getActiveFacture(){
        return factureService.retrieveFacturesActive();
    }

    @GetMapping("/getFacturesByDateDesc")
    public List<Facture> getAllFacturesByDateDesc(){
        return factureService.retrieveFacturesByDateDesc();
    }

    @GetMapping("/getFacturesByDateAsc")
    public List<Facture> getAllFacturesByDateAsc(){
        return factureService.retrieveFacturesByDateAsc();
    }

    @GetMapping("/getFacturesByDateBetween/{date1}/{date2}")
    public List<Facture> getAllFacturesByDateBetween(@PathVariable("date1") String date1, @PathVariable("date2") String date2){
        return factureService.retrieveFacturesBetweenDates(date1,date2);
    }

    @GetMapping("/factureExportPdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Factures_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Facture> listFactures = factureService.retrieveAllFactures();

        FacturePDFExporter exporter = new FacturePDFExporter(listFactures);
        exporter.export(response);

    }

}
