package com.project.proveedorservice.controller;

import com.project.proveedorservice.entity.Supplier;
import com.project.proveedorservice.service.SupplierNotFound;
import com.project.proveedorservice.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SupplierPagesController {
    @Autowired
    private SupplierService service;

    @GetMapping("/index")
    public String showHome(){
        return "index";
    }

    @GetMapping("/home")
    public String showNewHome(){
        return "home";
    }

    @GetMapping("/table")
    public String showTable(Model model){
        List<Supplier> supplierList = service.getAll();
        model.addAttribute("listSupplier", supplierList);
        return "table";
    }
    @GetMapping("/table/new-supplier")
    public String showForm(Model model){
        model.addAttribute("crudSupplier", new Supplier());

        /* editable Title en el Form */
        model.addAttribute("titleForm", "Agregar un proveedor");

        return "add-new-supplier";
    }

    @PostMapping("/table/save")
    public String saveForm(Supplier supplier, RedirectAttributes alertMsg){
        service.save(supplier);

        /* Alerts */
        alertMsg.addFlashAttribute("alertMsg", "Tabla actualizada");

        return "redirect:/table";
    }

    @GetMapping("/table/edit/{id}")
    public String showEdition(@PathVariable("id") Integer id, Model model, RedirectAttributes alertMsg){
        try{
            Supplier supplier = service.newGetById(id);
            model.addAttribute("crudSupplier", supplier);

            /* editable Title en el Form */
            model.addAttribute("titleForm", "Editando la tabla (Id:"+id+")");

            return "add-new-supplier";
        } catch (SupplierNotFound msg){

            /* Alerts by using a message from Service file */
            alertMsg.addFlashAttribute("alertMsg", msg.getMessage());

            return "redirect:/table";
        }
    }

    @GetMapping("/table/delete/{id}")
    public String deleteRaw(@PathVariable("id") Integer id, Model model, RedirectAttributes alertMsg){
        try {
            service.deleteById(id);

            /* Alerts by using a custom message */
            alertMsg.addFlashAttribute("alertMsg", "El Id "+id+" fue eliminado");

        } catch (SupplierNotFound msg){

            /* Alerts by using a message from Service file */
            alertMsg.addFlashAttribute("alertMsg", msg.getMessage());

        }
        return "redirect:/table";
    }

}
