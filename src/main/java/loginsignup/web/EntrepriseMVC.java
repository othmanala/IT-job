package loginsignup.web;


import loginsignup.model.Entreprise;
import loginsignup.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EntrepriseMVC {

    @Autowired
    EntrepriseService agent;

    /*//Diplay of the link : http://localhost:8082/projetfinal
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("index");
        return mv;

    }

   ///Diplay form add entreprise : http://localhost:8082/entreprises/entreprises/add
    @RequestMapping(value = "/entreprises/add",method = RequestMethod.GET)
    public ModelAndView form_Add() {
        ModelAndView mv = new ModelAndView();
        Entreprise entreprise = new Entreprise();
        mv.addObject(entreprise);
        mv.setViewName("entreprise");
        mv.addObject("Formentreprise",entreprise);
        return mv;
    }

    //envoyer la requette en formdoctor
    //Ajout de la partie controle des données
    @RequestMapping(value = "/entreprises/save",method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("Formentreprise") Entreprise d, BindingResult result) {
        if(result.hasErrors()){
            return (new ModelAndView("entreprise"));
        }else{
            agent.add_entreprise(d);
            return new ModelAndView("redirect:/entreprises/list");
        }

    }
    @RequestMapping(value = "/enterprises/list",method =RequestMethod.GET)
    public ModelAndView display_entreprise(){
        ModelAndView mv=new ModelAndView();
       List<Entreprise> entreprises =agent.findAll();
        mv.addObject("entreprises",entreprises);
        mv.setViewName("entreprises");
        return mv;
    }

    package com.corp.cabinet.controller;

import com.corp.cabinet.model.Doctor;
import com.corp.cabinet.model.Search;
import com.corp.cabinet.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

    @Controller
    public class DoctorMvc {

        @Autowired
        EntrepriseService agent;*/

        @RequestMapping(value = "/",method = RequestMethod.GET)
        public ModelAndView index(){
            ModelAndView mv = new ModelAndView();
            mv.setViewName("index");
            return mv;
        }
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public ModelAndView admin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin");
        return mv;
    }
    @RequestMapping(value = "/portfolio",method = RequestMethod.GET)
    public ModelAndView display_offres(){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("portfolio");
        return mv;
    }

    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public ModelAndView about(){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("about");
        return mv;
    }


    @RequestMapping(value = "/portfolio-details",method = RequestMethod.GET)
    public ModelAndView Details(){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("portfolio-details");
        return mv;
    }

        @RequestMapping(value = "/entreprises/add",method = RequestMethod.GET)
        public ModelAndView form_add(){
            ModelAndView mv = new ModelAndView();
            Entreprise entreprise = new Entreprise();
            mv.addObject("Formentreprise",entreprise);
            mv.setViewName("entreprise");
            return mv;
        }

        @RequestMapping(value = "/entreprises/save",method = RequestMethod.POST)
        public ModelAndView save(@Valid @ModelAttribute("Formentreprise") Entreprise e, BindingResult result) {
            if (result.hasErrors()) {
                return (new ModelAndView("entreprise"));
            } else {
                agent.add_entreprise(e);
                return (new ModelAndView("redirect:/entreprises/list"));
            }


        }





        @RequestMapping(value = "/entreprises/list",method = RequestMethod.GET)
        public ModelAndView display_doctors(){
            ModelAndView mv = new ModelAndView();
            List<Entreprise> entreprises = agent.findAll();
            mv.addObject("list",entreprises);
            mv.setViewName("entreprises");
            return mv;
        }
    @RequestMapping(value = "/portfolio-details/list",method = RequestMethod.GET)
    public ModelAndView display_portfolio(){
        ModelAndView mv = new ModelAndView();
        List<Entreprise> entreprises = agent.findAll();
        mv.addObject("list",entreprises);
        mv.setViewName("portfolio-details");
        return mv;
    }



        @RequestMapping(value = "/entreprises/delete/{id}",method = RequestMethod.GET)
        public ModelAndView delete_entreprise(@PathVariable("id") long id){
            ModelAndView mv = new ModelAndView();
            agent.delete_entreprise(id);
            return new ModelAndView("redirect:/entreprises/list");
        }

        @RequestMapping(value = "/entreprises/update/{ide}",method = RequestMethod.GET)
        public ModelAndView display_form_update(@PathVariable("ide") long id){
            Entreprise entreprise = agent.find_entreprise(id).get();
            ModelAndView mv = new ModelAndView();
            mv.setViewName("editentreprise");
            mv.addObject("Formentreprise",entreprise);
            return mv;
        }
/*
        @RequestMapping(value = "/doctors/recherche",method = RequestMethod.GET)
        public ModelAndView display_search(){
            ModelAndView mv = new ModelAndView();
            Search search = new Search();
            mv.addObject("search",search);
            mv.setViewName("search");
            return mv;
        }

        @RequestMapping(value = "/doctors/search",method = RequestMethod.POST)
        public ModelAndView search(@ModelAttribute("search") Search search) {
            List<Doctor> res = agent.search_specialite(search.getSpecialite());
            search.setDoctors(res);
            ModelAndView mv = new ModelAndView();
            mv.addObject("search",search);
            mv.setViewName("search");
            return mv;
        }

        @RequestMapping(value = "/doctors/avancee",method = RequestMethod.GET)
        public ModelAndView display_advanced_search(){
            ModelAndView mv = new ModelAndView();
            Search search = new Search();
            mv.addObject("search",search);
            mv.setViewName("advancedsearch");
            return mv;
        }

        @RequestMapping(value = "/doctors/advancedsearch",method = RequestMethod.POST)
        public ModelAndView advanced_search(@ModelAttribute("search") Search search) {
            List<Doctor> res = agent.advanced_search(search.getSpecialite(),search.getPseudo());
            search.setDoctors(res);
            ModelAndView mv = new ModelAndView();
            mv.addObject("search",search);
            mv.setViewName("advancedsearch");
            return mv;
        }

    }*/



}
