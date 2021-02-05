package com.example.Gestion.des.taches.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestion.des.taches.project.model.Categorie;
import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.service.CategorieService;
import com.example.Gestion.des.taches.project.service.LivreService;


@RestController
public class LivreController {
	
	@Autowired
	private LivreService livreService ;
	@Autowired
	private CategorieService categorieService;
	
	
	@PostMapping("/savelivre")
	public Livre save(@RequestBody Livre livre) {
		livreService.save(livre);
		return livre ;
	}
	
	@PostMapping("/ajouterlivre")
	public Livre ajouterLivre(@RequestBody  Livre livre) {
		livreService.ajouterLivre(livre);
		return livre ;
	}
	@DeleteMapping("/supprimerlivre/{idLivre}")
	public void delete(@PathVariable("idLivre") Long id) {
		 livreService.delete(id);
	}
		 
		 
    @GetMapping(value = "findOneL/{idLivre}")
    @ResponseBody
		   public Livre findOne(@PathVariable ("idLivre") Long id) {
				return livreService.findOne(id);
			}
	
	
    @GetMapping(value = "findAllL")
	public Iterable<Livre> findAll() {
		return livreService.findAll();
	}
		
    
    @PostMapping("/add-new-book")
    
    public void addNewBook( @RequestBody Livre livre) {
        livreService.addNewBook(livre);
    }
    @PutMapping("/add-book/{id}/{quantityToAdd}")
  
    public void addBook(@PathVariable Long id,
                        @PathVariable int quantityToAdd) {
        livreService.addBook(id, quantityToAdd);
    }
    
    @GetMapping("/book/{id}")
    @ResponseBody
    public Livre getBookById(@PathVariable ("id") Long id) {
        return livreService.getBookById(id);
    }
    
  
    
    @GetMapping("/number-of-books/{id}")
    public int getNumberOfBooksById(@PathVariable Long id) {
        return livreService.getNumberOfBooksById(id);
    }
  
    @GetMapping("/books/sortPriceA")
	public List<Livre> findAllBooksSortedByPriceA() {
		
			return livreService.getBookSortedByPriceASC();
		
	}

	@GetMapping("/books/sortPriceD")
	public List<Livre> findAllBooksSortedByPriceD() {
		
			return livreService.getBookSortedByPriceDESC();
	}
	
	
   /* @GetMapping("/books")
    public List<Livre> getBookByCategoryKeyWord(@RequestParam String keyword,
                                                @RequestParam Long id) {
        return livreService.getBookByCategoryKeyWord(keyword, id);
        */
    @GetMapping("/books")
    public ResponseEntity<?> getBookByCategoryKeyWord(@RequestParam String keyword,
            @RequestParam Long id){
    	return ResponseEntity.ok(livreService.getBookByCategoryKeyWord(keyword, id));
    }
    
    @GetMapping("cat/{id}")
    public ResponseEntity<?> findByCategory(@PathVariable("id") Long id){
        return ResponseEntity.ok(livreService.findByCategorie(id));
    }
    
    @GetMapping("/countBook")
    public Long countLivre(){
    	return livreService.countLivre();
    }
    
   
    @PutMapping("/book/{id}")
	public Livre update(@PathVariable Long id, @RequestBody Livre livre ) {
		Livre update = livreService.findOne(id);
		update.setName(livre.getName());
		update.setDescription(livre.getDescription());
		update.setPrice(livre.getPrice());
		update.setCategorie(livre.getCategorie());
		update.setPhoto(livre.getPhoto());
        update.setAuthor(livre.getAuthor());
        livreService.save(update);
		return livre;
    }
    
    @PutMapping("/booky/{id}")
	public Livre updatePrice(@PathVariable Long id, @RequestBody Livre livre ) {
		Livre update = livreService.findOne(id);
		
		update.setPrice(livre.getPrice());
 livreService.save(update);
		return livre;
   }
    @GetMapping("/bookName/{name}")
    public Iterable<Livre> findByName(@PathVariable String name){
    	return livreService.findByName(name);
    }

}
  
	
	
