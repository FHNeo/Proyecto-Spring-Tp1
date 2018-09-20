package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.hamcrest.core.IsEqual;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;
public class PruebaMundo extends SpringTest{

  @Inject
  private SessionFactory sesion;
  @Test
  @Transactional @Rollback(true)
  public void testPaisesIdiomaIngles() {
      Continente miContinente1=new Continente();
      miContinente1.setNombre("Europa");
      getSession().save(miContinente1);

      Continente miContinente2=new Continente();
      miContinente1.setNombre("America");
      getSession().save(miContinente2);
      
      Ciudad ciud1= new Ciudad();
      Ciudad ciud2= new Ciudad();
      Ciudad ciud3= new Ciudad();
      
      ciud1.setNombre("Buenos Aires");
      ciud2.setNombre("Londres");
      ciud3.setNombre("Washington");
      
      Ubicacion ubica1= new Ubicacion();
      Ubicacion ubica2= new Ubicacion();
      Ubicacion ubica3= new Ubicacion();
      ubica1.setLatitud(25);
      ubica2.setLatitud(26);
      ubica3.setLatitud(-40);
      
      getSession().save(ubica1);
      getSession().save(ubica2);
      getSession().save(ubica3);
      
      ciud1.setUbicacionGeografica(ubica3);
      ciud2.setUbicacionGeografica(ubica2);
      ciud3.setUbicacionGeografica(ubica1);
      
      getSession().save(ciud1);
      getSession().save(ciud2);
      getSession().save(ciud3);
      
      Pais miPais1= new Pais();
      miPais1.setNombre("Inglaterra");
      miPais1.setHabitantes(100);
      miPais1.setIdioma("Ingles");
      miPais1.setCapital(ciud2);
      miPais1.setContinente(miContinente1);
      getSession().save(miPais1);

      Pais miPais2= new Pais();
      miPais2.setNombre("EE.UU");
      miPais2.setHabitantes(500);
      miPais2.setIdioma("Ingles");
      miPais2.setCapital(ciud3);
      miPais2.setContinente(miContinente2);
      getSession().save(miPais2);

      Pais miPais3= new Pais();
      miPais3.setNombre("Argentina");
      miPais3.setHabitantes(800);
      miPais3.setIdioma("Castellano");
      miPais3.setCapital(ciud1);
      miPais3.setContinente(miContinente2);
      getSession().save(miPais3);

      @SuppressWarnings("unchecked")
	List<Pais> miLista= (List<Pais>) sesion.getCurrentSession().createCriteria(Pais.class)
              .add(Restrictions.eq("idioma", "Ingles"))
              .list();

      assertThat(miLista.size()).isEqualTo(2);
  }
//  @Test
//  @Transactional @Rollback(true)
//  public void testPaisesContinenteEuropeo() {
//
//      Continente miContinente1=new Continente();
//      miContinente1.setNombre("Europa");
//      getSession().save(miContinente1);
//
//      Continente miContinente2=new Continente();
//      miContinente1.setNombre("America");
//      getSession().save(miContinente2);
//
//
//      Pais miPais1= new Pais();
//      miPais1.setNombre("Inglaterra");
//      miPais1.setHabitantes(100);
//      miPais1.setIdioma("Ingles");
//      miPais1.setCapital("Londres");
//      miPais1.setContinente(miContinente1);
//
//      Pais miPais2= new Pais();
//      miPais2.setNombre("EE.UU");
//      miPais2.setHabitantes(500);
//      miPais2.setIdioma("Ingles");
//      miPais2.setCapital("Washington");
//      miPais2.setContinente(miContinente2);
//      getSession().save(miPais2);
//
//      Pais miPais3= new Pais();
//      miPais3.setNombre("Argentina");
//      miPais3.setHabitantes(800);
//      miPais3.setIdioma("Castellano");
//      miPais3.setCapital("Bs.As");
//      miPais3.setContinente(miContinente2);
//
//      Pais miPais4= new Pais();
//      miPais4.setNombre("Uruguay");
//      miPais4.setHabitantes(800);
//      miPais4.setIdioma("Castellano");
//      miPais4.setCapital("Montevideo");
//      miPais4.setContinente(miContinente2);
//
//      getSession().save(miPais1);
//      getSession().save(miPais2);
//      getSession().save(miPais3);
//      getSession().save(miPais4);
//      
//	@SuppressWarnings("unchecked")
//	List<Pais> miLista= (List<Pais>)getSession()
//              .createCriteria(Pais.class)
//              .createAlias("continente", "Continente")
//              .add(Restrictions.eq("Continente.nombre","Europa"))
//              .list();
//      assertThat(miLista.size()).isEqualTo(1);
//
//  }

	  @Test
	  @Transactional @Rollback(true)
	  public void testTropico(){

	      Continente miContinente1=new Continente();
	      miContinente1.setNombre("Europa");
	      getSession().save(miContinente1);

	      Continente miContinente2=new Continente();
	      miContinente1.setNombre("America");
	      getSession().save(miContinente2);
	      
	      Ciudad ciud1= new Ciudad();
	      Ciudad ciud2= new Ciudad();
	      Ciudad ciud3= new Ciudad();
	      
	      ciud1.setNombre("Buenos Aires");
	      ciud2.setNombre("Londres");
	      ciud3.setNombre("Washington");
	      
	      Ubicacion ubica1= new Ubicacion();
	      Ubicacion ubica2= new Ubicacion();
	      Ubicacion ubica3= new Ubicacion();
	      ubica1.setLatitud(25);
	      ubica2.setLatitud(26);
	      ubica3.setLatitud(-40);
	      
	      getSession().save(ubica1);
	      getSession().save(ubica2);
	      getSession().save(ubica3);
	      
	      ciud1.setUbicacionGeografica(ubica3);
	      ciud2.setUbicacionGeografica(ubica2);
	      ciud3.setUbicacionGeografica(ubica1);
	      
	      getSession().save(ciud1);
	      getSession().save(ciud2);
	      getSession().save(ciud3);
	      
	      Pais miPais1= new Pais();
	      miPais1.setNombre("Inglaterra");
	      miPais1.setHabitantes(100);
	      miPais1.setIdioma("Ingles");
	      miPais1.setCapital(ciud2);
	      miPais1.setContinente(miContinente1);
	      getSession().save(miPais1);

	      Pais miPais2= new Pais();
	      miPais2.setNombre("EE.UU");
	      miPais2.setHabitantes(500);
	      miPais2.setIdioma("Ingles");
	      miPais2.setCapital(ciud3);
	      miPais2.setContinente(miContinente2);
	      getSession().save(miPais2);

	      Pais miPais3= new Pais();
	      miPais3.setNombre("Argentina");
	      miPais3.setHabitantes(800);
	      miPais3.setIdioma("Castellano");
	      miPais3.setCapital(ciud1);
	      miPais3.setContinente(miContinente2);
	      getSession().save(miPais3);
	      
	      @SuppressWarnings("unchecked")
		List<Pais>lista = (List<Pais>)getSession()
	    		  .createCriteria(Pais.class)
	    		  .createAlias("capital", "capitalDePais")
	    		  .createAlias("capitalDePais.ubicacionGeografica","ubicacionCapital")
	    		  .add(Restrictions.gt("ubicacionCapital.latitud", 23))
	    		  .list();
	      
	      assertThat(lista.size()).isEqualTo(2);
	  }
	  
	  @Test
	  @Transactional @Rollback(true)
	  public void testHemisferio(){

	      Continente miContinente1=new Continente();
	      miContinente1.setNombre("Europa");
	      getSession().save(miContinente1);

	      Continente miContinente2=new Continente();
	      miContinente1.setNombre("America");
	      getSession().save(miContinente2);
	      
	      Ciudad ciud1= new Ciudad();
	      Ciudad ciud2= new Ciudad();
	      Ciudad ciud3= new Ciudad();
	      
	      ciud1.setNombre("Buenos Aires");
	      ciud2.setNombre("Londres");
	      ciud3.setNombre("Washington");
	      
	      Ubicacion ubica1= new Ubicacion();
	      Ubicacion ubica2= new Ubicacion();
	      Ubicacion ubica3= new Ubicacion();
	      ubica1.setLatitud(25);
	      ubica2.setLatitud(26);
	      ubica3.setLatitud(-40);
	      
	      getSession().save(ubica1);
	      getSession().save(ubica2);
	      getSession().save(ubica3);
	      
	      ciud1.setUbicacionGeografica(ubica3);
	      ciud2.setUbicacionGeografica(ubica2);
	      ciud3.setUbicacionGeografica(ubica1);
	      
	      getSession().save(ciud1);
	      getSession().save(ciud2);
	      getSession().save(ciud3);
	      
	      Pais miPais1= new Pais();
	      miPais1.setNombre("Inglaterra");
	      miPais1.setHabitantes(100);
	      miPais1.setIdioma("Ingles");
	      miPais1.setCapital(ciud2);
	      miPais1.setContinente(miContinente1);
	      getSession().save(miPais1);

	      Pais miPais2= new Pais();
	      miPais2.setNombre("EE.UU");
	      miPais2.setHabitantes(500);
	      miPais2.setIdioma("Ingles");
	      miPais2.setCapital(ciud3);
	      miPais2.setContinente(miContinente2);
	      getSession().save(miPais2);

	      Pais miPais3= new Pais();
	      miPais3.setNombre("Argentina");
	      miPais3.setHabitantes(800);
	      miPais3.setIdioma("Castellano");
	      miPais3.setCapital(ciud1);
	      miPais3.setContinente(miContinente2);
	      getSession().save(miPais3);
	      
	      @SuppressWarnings("unchecked")
		List<Pais>lista = (List<Pais>)getSession()
	    		  .createCriteria(Pais.class)
	    		  .createAlias("capital", "capitalDePais")
	    		  .createAlias("capitalDePais.ubicacionGeografica","ubicacionCapital")
	    		  .add(Restrictions.lt("ubicacionCapital.latitud", 0))
	    		  .list();
	      
	      assertThat(lista.size()).isEqualTo(1);
	  }
}