package hotel.util;

public enum Lang {
	//-- LoginForm --
	LOGIN_USERNAME                      {public String toString() {return "Username :";}},
	LOGIN_PASSWORD                      {public String toString() {return "Password :";}},
	LOGIN_CONNECTION_SCREEN_TITLE       {public String toString() {return "Login";}},
	LOGIN_CONNECT                       {public String toString() {return "Login";}},
	LOGIN_CONNECTION_FAILED_MESSAGE     {public String toString() {return "Connection failed.";}},
	LOGIN_CANCEL                        {public String toString() {return "Cancel";}},
	
	//-- ReservationList --
	RESERVATION_LIST_CLOSE              {public String toString() {return "Fermer";}},
	RESERVATION_LIST_ADD                {public String toString() {return "Ajouter";}},
	RESERVATION_LIST_CLIENT             {public String toString() {return "Client";}},
	RESERVATION_LIST_CONFIRMATION       {public String toString() {return "No de confirmation";}},
	RESERVATION_LIST_ID                 {public String toString() {return "ID";}},
	RESERVATION_LIST_TITLE              {public String toString() {return "Réservations";}},
	
	//-- ReservationDetailForm --
	RESERVATION_DETAIL_CATEGORY         {public String toString() {return "Catégorie :";}},
	RESERVATION_DETAIL_QUANTITY         {public String toString() {return "Quantité :";}},
	RESERVATION_DETAIL_DATE_ARRIVAL     {public String toString() {return "Date d'arrivée :";}},
	RESERVATION_DETAIL_DATE_DEPARTURE   {public String toString() {return "Date de départ :";}},
	RESERVATION_DETAIL_CANCEL           {public String toString() {return "Annuler";}},
	RESERVATION_DETAIL_OK               {public String toString() {return "Ok";}},
	RESERVATION_DETAIL_TITLE            {public String toString() {return "Ajouter une chambre";}},
	RESERVATION_DETAIL_REMAINING_ROOMS  {public String toString() {return "Il n'y a pas suffisament de chambres de cette catégorie dans l'interval de dates sélectionné.\nLes chambres restantes sont:\n";}},
	RESERVATION_DETAIL_ERROR_DATA_INPUT {public String toString() {return "Les données entrées sont incorrectes.";}},
	
	//-- ReservationForm --
	RESERVATION_FORM_TITLE              {public String toString() {return "Réservation";}},
	RESERVATION_FORM_CATEGORY           {public String toString() {return "Catégorie";}},
	RESERVATION_FORM_QUANTITY           {public String toString() {return "Quantité";}},
	RESERVATION_FORM_DATE_ARRIVAL       {public String toString() {return "Date d'arrivée";}},
	RESERVATION_FORM_DATE_DEPARTURE     {public String toString() {return "Date de départ";}},
	RESERVATION_FORM_ID                 {public String toString() {return "ID";}},
	RESERVATION_FORM_ADD                {public String toString() {return "+";}},
	RESERVATION_FORM_DELETE             {public String toString() {return "-";}},
	RESERVATION_FORM_CLOSE              {public String toString() {return "Fermer";}},
	RESERVATION_FORM_SAVE               {public String toString() {return "Enregistrer";}},
	RESERVATION_FORM_DETAIL             {public String toString() {return "Détails de la réservation";}},
	RESERVATION_FORM_NAME               {public String toString() {return "Nom :";}},
	RESERVATION_FORM_TELEPHONE          {public String toString() {return "Telephone :";}},
	RESERVATION_FORM_CLIENT             {public String toString() {return "Client";}},
	RESERVATION_FORM_CONFIRMATION       {public String toString() {return "Votre numéro de confirmation :\n";}},
	RESERVATION_FORM_ERROR              {public String toString() {return "Une erreur est survenue.";}}
}
