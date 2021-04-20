package ro.emanuel.banca;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.banca.clientiDAO.*;
import ro.emanuel.banca.dao.*;
import ro.emanuel.banca.clientiPOJO.*;
import ro.emanuel.banca.pojo.*;


public class BancaController {

	  @RequestMapping(value = "list.htm", method = RequestMethod.GET)
	    public ModelAndView listBanca() throws SQLException {
	        ModelMap model = new ModelMap();

	        ArrayList<Banca> banca = BancaDAO.getBanca();
	        model.put("students", banca);


	        return new ModelAndView("list.jsp", model);
	    }
	    
	    @RequestMapping(value = "detalii.htm", method = RequestMethod.GET)
	    public ModelAndView detailsStudent(@RequestParam Integer id) throws SQLException {
	    	ModelMap model = new ModelMap();
	    	
	    	Banca bt = BancaDAO.getBancaByID(id);
	    	model.put("banca", bt);
	    	
	    	return new ModelAndView("detalii.jsp", model);
	    }
	    @RequestMapping(value = "adugare-banca.htm", method = RequestMethod.GET)
	    public ModelAndView showAddBanca(Model model)  {
	    	Banca bt = new Banca();
	    	model.addAttribute("bancaForm", bt);
	    	
	    	return new ModelAndView("add.jsp","model", model);
	    }
	    
	    @RequestMapping(value = "adugare-banca-save.htm", method = RequestMethod.POST)
	    public ModelAndView addBanca(@ModelAttribute("bancaForm") Banca bt, ModelMap model, BindingResult result)  {
	    	
	    		try {
					BancaDAO.createBanca(bt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		return new ModelAndView("redirect:/list.htm");
	    	}
	    
	@RequestMapping(value = "delete.htm", method = RequestMethod.GET)
	public ModelAndView deleteBanca(@RequestParam Integer id) throws SQLException {
		
		BancaDAO.deleteBanca(id);
		return new ModelAndView("redirect:/list.htm");
	}}