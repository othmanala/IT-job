package loginsignup.web;



import loginsignup.model.Entreprise;
import loginsignup.model.Offre;
import loginsignup.service.EntrepriseService;
import loginsignup.service.OffresService;
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
public class OffreMVC {
    @Autowired
    OffresService agent;

    @Autowired
    EntrepriseService agentent;
/*
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
*/
    @RequestMapping(value = "/offres/add",method = RequestMethod.GET)
    public ModelAndView form_add(){
        ModelAndView mv = new ModelAndView();
       Offre offre = new Offre();
        List<Entreprise> entreprises=agentent.findAll();
        mv.setViewName("offre");
        mv.addObject("Formoffre",offre);
        mv.addObject("entreprises",entreprises);

        return mv;
    }

    @RequestMapping(value = "/offres/save",method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("Formoffre") Offre offre, BindingResult result) {
        if (result.hasErrors()) {
            return (new ModelAndView("offre"));
        } else {
            agent.add_offres(offre);
            return (new ModelAndView("redirect:/offres/list"));
        }

    }

    @RequestMapping(value = "/offres/list",method = RequestMethod.GET)
    public ModelAndView display_offres(){
        ModelAndView mv = new ModelAndView();
        List<Offre> offres = agent.findAll();
        mv.addObject("list",offres);
        mv.setViewName("offres");
        return mv;
    }

    @RequestMapping(value = "/offres/delete/{id}",method = RequestMethod.GET)
    public ModelAndView delete_offres(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView();
        agent.delete_offre(id);
        return new ModelAndView("redirect:/offres/list");
    }

    @RequestMapping(value = "/offres/update/{ido}",method = RequestMethod.GET)
    public ModelAndView display_form_update(@PathVariable("ido") long id){
       Offre offre = agent.find_offre(id).get();
        List<Entreprise> entreprises=agentent.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editoffre");
        mv.addObject("Formoffre",offre);
        mv.addObject("entreprises",entreprises);
        return mv;
    }
}
