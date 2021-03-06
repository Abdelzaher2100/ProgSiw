package persistence;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;

import model.Utente;
import model.Veicolo;
import persistence.dao.*;


public class MainJDBC {

	public static void main(String args[]) throws FileNotFoundException {
		
		Calendar cal = Calendar.getInstance();
		cal.set(1996, Calendar.JANUARY, 1);  // 21 marzo 1995
		Date date1 = cal.getTime();
		
		cal.set(1997, Calendar.FEBRUARY, 3);  // 21 marzo 1995
		Date date2 = cal.getTime();
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	//	UtilDao util = factory.getUtilDAO();
		
		//	util.resetDatabase();
		//util.dropDatabase();
		//util.createDatabase();
		
		
		UtenteDao utenteDao = factory.getUtenteDAO();
	//	Utente admin=new Utente("admin", "admin", "admin", "admin", "admin", "admin", "admin", "admin", date1, "admin", true);
		//Utente utente= new Utente("utente", "Davide", "Perri", "pass", "indirizzo", "codiceFiscale", "numCartaCredito", "numPatente", date1, "numCellulare", false);
		//utenteDao.save(admin);
		//utenteDao.save(utente);
		// creo i veicoli
		
		//VeicoloDao veicoloDao = factory.getVeicoloDAO();
		
		Veicolo veicolo1 = new Veicolo("aaaaaa", "A", "FIAT", "500", date1);
		Veicolo veicolo2 = new Veicolo("bbbbbb", "A", "PEUGEOT", "107", date1);
		Veicolo veicolo3 = new Veicolo("cccccc", "A", "OPEL", "adam", date1);
		Veicolo veicolo4 = new Veicolo("dddddd", "B", "FIAT", "panda", date1);
		Veicolo veicolo5 = new Veicolo("eeeeee", "B", "RENAULT", "clio", date1);
		Veicolo veicolo6 = new Veicolo("ffffff", "B", "TOYOTA", "yaris", date1);
		Veicolo veicolo7 = new Veicolo("gggggg", "C", "FORD", "fiesta", date1);
		Veicolo veicolo8 = new Veicolo("hhhhhh", "C", "CITROEN", "c3", date1);
		Veicolo veicolo9 = new Veicolo("iiiiii", "D", "AUDI", "A3", date1);
		Veicolo veicolo10 = new Veicolo("llllll","D", "VOLKSWAGEN", "golf",date1);
		Veicolo veicolo11 = new Veicolo("mmmmmm", "I", "AUDI", "A4", date1);
		Veicolo veicolo12 = new Veicolo("nnnnnnn","P", "CITROEN", "picasso",date1);
		Veicolo veicolo13 = new Veicolo("nnnnnnn1","I", "AUDI", "c18",date1);
		Veicolo veicolo14 = new Veicolo("nnnnnnn2","P", "CITROEN", "picasso",date1);
		Veicolo veicolo15 = new Veicolo("nnnnnnn3","I", "AUDI", "picasso",date1);
		Veicolo veicolo16 = new Veicolo("nnnnnnn4","O", "CITROEN", "picasso",date1);
		Veicolo veicolo17 = new Veicolo("nnnnnnn5","I", "AUDI", "picasso",date1);
		Veicolo veicolo18 = new Veicolo("nnnnnnn6","N", "CITROEN", "picasso",date1);
		Veicolo veicolo19 = new Veicolo("nnnnnnn7","N", "MERCEDES", "GLK",date1);
		Veicolo veicolo20 = new Veicolo("nnnnnnn8","N", "FIAT", "panda",date1);
		Veicolo veicolo21 = new Veicolo("nnnnnnn9","L", "MERCEDES", "classe A",date1);
		Veicolo veicolo22 = new Veicolo("nnnnnnn10","L", "AUDI", "A 6",date1);
		
		
//		veicoloDao.delete(veicolo1);
//		veicoloDao.delete(veicolo2);
//		veicoloDao.delete(veicolo3);
//		veicoloDao.delete(veicolo4);
//		veicoloDao.delete(veicolo5);
//		veicoloDao.delete(veicolo6);
//		veicoloDao.delete(veicolo7);
//		veicoloDao.delete(veicolo8);
//		veicoloDao.delete(veicolo9);
//		veicoloDao.delete(veicolo10);
//		veicoloDao.delete(veicolo11);
//		veicoloDao.delete(veicolo12);
		
		//veicoloDao.save(veicolo1);		
		//veicoloDao.save(veicolo2);	
		//veicoloDao.save(veicolo3);		
		//veicoloDao.save(veicolo4);
		//veicoloDao.save(veicolo5);		
		//veicoloDao.save(veicolo6);
		//veicoloDao.save(veicolo7);		
		//veicoloDao.save(veicolo8);
		//veicoloDao.save(veicolo9);		
		//veicoloDao.save(veicolo10);
		//veicoloDao.save(veicolo11);		
		//veicoloDao.save(veicolo12);
		//veicoloDao.save(veicolo13);
		//veicoloDao.save(veicolo14);
		//veicoloDao.save(veicolo15);
		//veicoloDao.save(veicolo16);
		//veicoloDao.save(veicolo17);
		//veicoloDao.save(veicolo18);
		//veicoloDao.save(veicolo19);
		//veicoloDao.save(veicolo20);
		//veicoloDao.save(veicolo21);
		//veicoloDao.save(veicolo22);
		// fine creazione veicoli
		
		
		
		
//	 	PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDAO();
	 	
//	 	List <Prenotazione> prenotazioni = prenotazioneDao.findByCredential(1);
//		
//	 	System.out.println(prenotazioni);
		
//		veicolo2=veicoloDao.findOneByCategory("A", , dataFine)

//		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDAO();
//		cal.set(2019, Calendar.FEBRUARY, 4);  // 21 marzo 1995
//		Date dataInizio = cal.getTime();
//		cal.set(2019, Calendar.FEBRUARY, 8);
//		Date dataFine =cal.getTime();
//		Prenotazione prenotazione1 = new Prenotazione(utente1.getIdUtente(), date1, dataInizio, dataFine, veicolo1);
//		prenotazione1.setTarga(veicolo1.getTarga());
//
//		prenotazioneDao.save(prenotazione1);
//		System.out.println(prenotazione1.toString());
//		prenotazioneDao.save(prenotazione2);
//
//		NoleggioDao noleggioDao = factory.getNoleggioDAO();
//		
//		Noleggio noleggio1 = new Noleggio(prenotazione1, veicolo1);
//		Noleggio noleggio2 = new Noleggio(prenotazione2, veicolo2);
//		
//		noleggioDao.save(noleggio1);
//		noleggioDao.save(noleggio2);
		
		

	}

}
